package entity;

public enum PlayerAttributes {
    START_SPEED(4), // as of now must be a multiple of 4  (will fix later)
    START_X(890),
    START_Y(475),
    START_DIRECTION("down"),
    PLAYER_SCALE(2),
    SCREEN_X_CENTER(600),
    SCREEN_Y_CENTER(264);

    private final Integer intValue;
    private final String stringValue;

    PlayerAttributes(int intValue) {
        this.intValue = intValue;
        this.stringValue = null;
    }
    PlayerAttributes(String stringValue) {
        this.intValue = null;
        this.stringValue = stringValue;
    }

    public Integer getIntValue() {
        return intValue;
    }
    public String getStringValue() {
        return stringValue;
    }
}
