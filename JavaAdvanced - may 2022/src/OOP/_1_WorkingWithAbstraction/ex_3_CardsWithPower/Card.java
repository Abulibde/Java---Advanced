package OOP._1_WorkingWithAbstraction.ex_3_CardsWithPower;

public class Card {
    private CardSuits cardSuit;
    private CardRanks cardRank;

    public Card(CardSuits cardSuit, CardRanks cardRank) {
        this.cardSuit = cardSuit;
        this.cardRank = cardRank;
    }

    public CardSuits getCardSuit() {
        return cardSuit;
    }

    public void setCardSuit(CardSuits cardSuit) {
        this.cardSuit = cardSuit;
    }

    public CardRanks getCardRank() {
        return cardRank;
    }

    public void setCardRank(CardRanks cardRank) {
        this.cardRank = cardRank;
    }

    public int getPower() {
        return cardRank.getRankPower() + cardSuit.getSuitPower();
    }
}
