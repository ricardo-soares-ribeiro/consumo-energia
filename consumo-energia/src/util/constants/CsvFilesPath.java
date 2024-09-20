package util.constants;

import java.nio.file.Path;
import java.nio.file.Paths;

public enum CsvFilesPath {
    CONSUMO_20_PATH(Paths.get("consumo-energia/src/resources/consumos_20.csv").toAbsolutePath()),
    CONSUMO_100_PATH(Paths.get("consumo-energia/src/resources/consumos_100.csv").toAbsolutePath()),
    CONSUMO_500_PATH(Paths.get("consumo-energia/src/resources/consumos_500.csv").toAbsolutePath()),
    CONSUMO_1000_PATH(Paths.get("consumo-energia/src/resources/consumos_1000.csv").toAbsolutePath()),
    CONSUMO_2000_PATH(Paths.get("consumo-energia/src/resources/consumos_2000.csv").toAbsolutePath()),
    CONSUMO_4000_PATH(Paths.get("consumo-energia/src/resources/consumos_4000.csv").toAbsolutePath()),
    CONSUMO_8000_PATH(Paths.get("consumo-energia/src/resources/consumos_8000.csv").toAbsolutePath()),
    CONSUMO_16000_PATH(Paths.get("consumo-energia/src/resources/consumos_16000.csv").toAbsolutePath()),
    CONSUMO_32000_PATH(Paths.get("consumo-energia/src/resources/consumos_32000.csv").toAbsolutePath()),
    CONSUMO_50000_PATH(Paths.get("consumo-energia/src/resources/consumos_50000.csv").toAbsolutePath()),
    CONSUMO_100000_PATH(Paths.get("consumo-energia/src/resources/consumos_100000.csv").toAbsolutePath());

    private final Path path;

    CsvFilesPath(Path path) {
        this.path = path;
    }

    public Path getPath() {
        return this.path;
    }
}
