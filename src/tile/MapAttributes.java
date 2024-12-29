package tile;

public enum MapAttributes {

    MAX_WORLD_COL(50),
    MAX_WORLD_ROW(50),
    TOP_BORDER(0),
    BOTTOM_BORDER(960),
    LEFT_BORDER(0),
    RIGHT_BORDER(1680);


    private final Integer intValue;
    private final String stringValue;

    MapAttributes(int intValue) {
        this.intValue = intValue;
        this.stringValue = null;
    }
    MapAttributes(String stringValue) {
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
