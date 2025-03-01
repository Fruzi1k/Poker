public enum HandType {
    HIGHCARD(1,"HIGHCARD"),
    PAIR(2,"PAIR"),
    TWO_PAIRS(3,"TWO_PAIRS"),
    THREE(4,"THREE"),
    STRAIGHT(5,"STRAIGHT"),
    FLUSH(6,"FLUSH"),
    FULL_HOUSE(7,"FULL_HOUSE"),
    FOUR(8,"FOUR"),
    STRAIGHT_FLUSH(9,"STRAIGHT_FLUSH"),
    ROYAL_FLUSH(10,"ROYAL_FLUSH"),;

    private int weight;
    private String description;

    HandType(int weight, String description) {
        this.weight = weight;
        this.description = description;
    }

    public int getWeight() {
        return weight;
    }

    public String getDescription() {
        return description;
    }
}
