package util;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReportFactory {

    public void gerarRelatorioTxt(Path csvFilePath, BufferedWriter writer) {

        CsvManager csvManager = new CsvManager(csvFilePath.toString());
        StatisticsUtil statisticsUtil = new StatisticsUtil();

        try {
            csvManager.lerArquivoCsv();

            int[][] matrizConsumo = csvManager.getMatrizConsumo();

            writer.write("CASO DE TESTE - " + csvFilePath.getFileName() + "\n\n");

            writer.write(csvManager.exibirMatriz());

            writer.write("\n\nESTATÍSTICAS\n\n");
            writer.write(statisticsUtil.getMenorConsumo(matrizConsumo));
            writer.write(statisticsUtil.getMaiorConsumo(matrizConsumo));
            writer.write(statisticsUtil.getConsumoTotal(matrizConsumo));

            writer.write("\n\nMÉDIA DE CONSUMO POR SUBESTAÇÃO\n\n");
            writer.write(statisticsUtil.getMediaDeConsumoPorSubEstacao(matrizConsumo));

            writer.write("\n\nCONSUMO TOTAL POR MÊS\n\n");
            writer.write(statisticsUtil.getConsumoTotalPorMes(matrizConsumo));

            writer.write("\n\n--------------------------------------------------------------------------------\n\n\n");

        } catch (FileNotFoundException exception) {
            throw new RuntimeException("Arquivo .csv não encontrado: " + csvFilePath, exception);
        } catch (IOException exception) {
            throw new RuntimeException("Mão foi possível escrever no arquivo .txt", exception);
        }
    }

    public String resolveTxtPath() {
        Path txtPath = Paths.get("consumo-energia/resultado/" + "resultados.txt").toAbsolutePath();
        return txtPath.toString();
    }
}
