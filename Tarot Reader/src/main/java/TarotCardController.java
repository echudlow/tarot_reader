import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TarotCardController {

    public TarotCardDAO tarotCardDAO;

    public TarotCardController(TarotCardDAO tarotCardDAO) {
        this.tarotCardDAO = tarotCardDAO;
    }

    @RequestMapping(path = "/tarotcards", method = RequestMethod.GET)
    public List<TarotCard> finalAllTarotCards(){
        return tarotCardDAO.findAll();
    }

    @RequestMapping(path = "/tarotcards/{tarot_id}", method = RequestMethod.GET)
    public TarotCard getTarotCardByID(@PathVariable int tarot_id) {
        return tarotCardDAO.getCardByID(tarot_id);
    }

    @RequestMapping(path = "/tarotcards/{card_name}", method = RequestMethod.GET)
    public TarotCard getCardByName(@PathVariable String card_name) {
        return tarotCardDAO.findCardByName(card_name);
    }
}
