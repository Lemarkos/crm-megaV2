package enums;

public enum Format {
    BOOTCAMP("Bootcamp"),
    ORDINARY("Ordinary");

    private String f;

    Format(String f) {
        this.f = f;
    }

    public String getF() {
        return f;
    }
}
