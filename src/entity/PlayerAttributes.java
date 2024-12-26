package entity;

public enum PlayerAttributes {
    START_SPEED(4),
    START_X(100),
    START_Y(100),
    START_DIRECTION("down"),
    PLAYER_SCALE(2);

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
