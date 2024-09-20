package util;

import java.io.*;

public class ReportFactory {

    public void gerarRelatorioPDF(String csvFilePath, String txtFilePath) {

        CsvManager csvManager = new CsvManager(csvFilePath);
        StatisticsUtil statisticsUtil = new StatisticsUtil();

        try {
            csvManager.lerArquivoCsv();
            csvManager.exibirMatriz();

            int[][] matrizConsumo = csvManager.getMatrizConsumo();

            BufferedWriter writer = new BufferedWriter(new FileWriter(txtFilePath));

            writer.write("RELATÓRIO DE CONSUMO\n\n");

            writer.write(csvManager.exibirMatriz());

            writer.write("\n\nESTATÍSTICAS\n\n");
            writer.write(statisticsUtil.getMenorConsumo(matrizConsumo));
            writer.write(statisticsUtil.getMaiorConsumo(matrizConsumo));
            writer.write(statisticsUtil.getConsumoTotal(matrizConsumo));

            writer.write("\n\nMÉDIA DE CONSUMO POR SUBESTAÇÃO\n\n");
            writer.write(statisticsUtil.getMediaDeConsumoPorSubEstacao(matrizConsumo));

            writer.write("\n\nCONSUMO TOTAL POR MÊS\n\n");
            writer.write(statisticsUtil.getConsumoTotalPorMes(matrizConsumo));

            writer.close();

            System.out.println("Relatório gerado com sucesso em: " + txtFilePath);

        } catch (FileNotFoundException exception) {
            throw new RuntimeException("Arquivo .csv não encontrado: " + csvFilePath, exception);
        } catch (IOException exception) {
            throw new RuntimeException("Mão foi possível escrever no arquivo .txt: " + txtFilePath, exception);
        }
    }
}
