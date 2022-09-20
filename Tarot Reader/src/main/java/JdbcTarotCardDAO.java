import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class JdbcTarotCardDAO implements TarotCardDAO{

    private final JdbcTemplate jdbcTemplate;

    public JdbcTarotCardDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<TarotCard> findAll() {
        List<TarotCard> users = new ArrayList<>();
        String sql = "select * from tarot_cards";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            TarotCard card = mapRowToUser(results);
            users.add(card);
        }

        return users;
    }

    @Override
    public TarotCard getCardByID(int tarot_id) {
        String sql = "select * from tarot_cards where tarot_id =?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, tarot_id);
        if (results.next()) {
            return mapRowToUser(results);
        } else {
            return null;
        }
    }

    @Override
    public TarotCard findCardByName(String card_name) {
        if (card_name == null) throw new IllegalArgumentException("Tarot card cannot be found");

        for (TarotCard card : this.findAll()) {
            if (card.getCard_name().equalsIgnoreCase(card_name)) {
                return card;
            }
        }
        throw new UsernameNotFoundException(card_name + " was not found.");
    }

    private TarotCard mapRowToUser(SqlRowSet rs) {
        TarotCard card = new TarotCard();
        card.setTarot_id(rs.getInt("tarot_id"));
        card.setCard_name(rs.getString("card_name"));
        card.getSummary(rs.getString("summary"));
        card.setCard_meaning(Objects.requireNonNull(rs.getString("card_meaning")));
        return card;
    }
}
