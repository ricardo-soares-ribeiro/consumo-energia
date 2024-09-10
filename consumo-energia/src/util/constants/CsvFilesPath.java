package util.constants;

public enum CsvFilesPath {

    CONSUMO_20_PATH(""),
    CONSUMO_100_PATH(""),
    CONSUMO_500_PATH(""),
    CONSUMO_1000_PATH(""),
    CONSUMO_2000_PATH(""),
    CONSUMO_4000_PATH(""),
    CONSUMO_8000_PATH(""),
    CONSUMO_16000_PATH(""),
    CONSUMO_32000_PATH(""),
    CONSUMO_50000_PATH(""),
    CONSUMO_100000_PATH("");

    private final String path;

    CsvFilesPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
}
