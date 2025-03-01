public enum Suits {
    //Heart → \u2665, Tile → \u2666, Clover → \u2663, Pike → \u2660
    HEART("♥"),
    TILE("♦"),
    CLOVER("♣"),
    PIKE("♠");
    public String description;

    Suits(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
