public enum Ranks {
    //String[] ranks = {"9", "10", "Jack", "Queen", "King", "Ace"};
    NINE(1,"9"),
    TEN(5,"10"),
    JACK(10,"Jack"),
    QUEEN(22,"Queen"),
    KNIGHT(37,"King"),
    ACE(100,"Ace");

    private int weight;
    public String description;

    Ranks(int weight, String description) {
        this.weight = weight;
        this.description = description;
    }

    public int getWeight() {
        return weight;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}
