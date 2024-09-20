package main;

import util.ReportFactory;
import util.constants.CsvFilesPath;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ReportFactory reportFactory = new ReportFactory();

        Path csvPath = Paths.get(CsvFilesPath.CONSUMO_20_PATH.getPath()).toAbsolutePath();
        Path txtPath = Paths.get("consumo-energia/txt-file-generated/relatorio.txt").toAbsolutePath();

        reportFactory.gerarRelatorioPDF(
                csvPath.toString(),
                txtPath.toString()
        );
    }
}