public class TarotCard {

    private int tarot_id;
    private String card_name;
    private String summary;
    private String card_meaning;

    public TarotCard() {}

    public TarotCard(int tarot_id, String card_name, String summary, String card_meaning) {
        this.tarot_id = tarot_id;
        this.card_name = card_name;
        this.summary = summary;
        this.card_meaning = card_meaning;
    }

    public int getTarot_id() {
        return tarot_id;
    }

    public void setTarot_id(int tarot_id) {
        this.tarot_id = tarot_id;
    }

    public String getCard_name() {
        return card_name;
    }

    public void setCard_name(String card_name) {
        this.card_name = card_name;
    }

    public String getSummary(String summary) {
        return this.summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCard_meaning() {
        return card_meaning;
    }

    public void setCard_meaning(String card_meaning) {
        this.card_meaning = card_meaning;
    }

    @Override
    public String toString() {
        return "TarotCard{" +
                "tarot_id=" + tarot_id +
                ", card_name='" + card_name + '\'' +
                ", summary='" + summary + '\'' +
                ", card_meaning='" + card_meaning + '\'' +
                '}';
    }
}
