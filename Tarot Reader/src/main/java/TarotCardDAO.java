import java.util.List;

public interface TarotCardDAO {

    List<TarotCard> findAll();

    TarotCard getCardByID(int tarot_id);

    TarotCard findCardByName(String card_name);

}
