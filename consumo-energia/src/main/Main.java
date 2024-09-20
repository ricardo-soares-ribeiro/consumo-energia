package main;

import util.ReportFactory;
import util.constants.CsvFilesPath;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ReportFactory reportFactory = new ReportFactory();

        reportFactory.gerarRelatorioPDF(
                CsvFilesPath.CONSUMO_20_PATH.getPath()
        );

        reportFactory.gerarRelatorioPDF(
                CsvFilesPath.CONSUMO_100_PATH.getPath()
        );

        reportFactory.gerarRelatorioPDF(
                CsvFilesPath.CONSUMO_500_PATH.getPath()
        );

        reportFactory.gerarRelatorioPDF(
                CsvFilesPath.CONSUMO_1000_PATH.getPath()
        );

        reportFactory.gerarRelatorioPDF(
                CsvFilesPath.CONSUMO_2000_PATH.getPath()
        );

        reportFactory.gerarRelatorioPDF(
                CsvFilesPath.CONSUMO_4000_PATH.getPath()
        );

        reportFactory.gerarRelatorioPDF(
                CsvFilesPath.CONSUMO_8000_PATH.getPath()
        );

        reportFactory.gerarRelatorioPDF(
                CsvFilesPath.CONSUMO_16000_PATH.getPath()
        );

        reportFactory.gerarRelatorioPDF(
                CsvFilesPath.CONSUMO_32000_PATH.getPath()
        );

        reportFactory.gerarRelatorioPDF(
                CsvFilesPath.CONSUMO_50000_PATH.getPath()
        );

        reportFactory.gerarRelatorioPDF(
                CsvFilesPath.CONSUMO_100000_PATH.getPath()
        );
    }
}