package Estore;

public enum CardType {

    MASTER_CARD("Master Card"),
    VISA_CARD("Visa Card"),
    VERVE("Verve"),
    AMERICAN_EXPRESS("American Express");

    private final String cardName;

    CardType(String cardName) {
        this.cardName = cardName;
    }

    public String getCardName() {
        return cardName;
    }
}