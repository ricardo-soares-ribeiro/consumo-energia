import util.CsvManager;
import util.StatisticsHelper;
import util.constants.CsvFilesPath;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        CsvManager csvManager = new CsvManager(CsvFilesPath.CONSUMO_20_PATH.getPath());

        try {
            csvManager.lerArquivoCsv();
            csvManager.exibirMatriz();
        } catch (FileNotFoundException exception) {
            System.out.println(exception + " : Arquivo não encontrado.");
        }

        int[][] matrizConsumo = csvManager.getMatrizConsumo();

        System.out.println();

        System.out.println(StatisticsHelper.getMenorConsumo(matrizConsumo));
        System.out.println();
        System.out.println(StatisticsHelper.getMaiorConsumo(matrizConsumo));
        System.out.println();
        System.out.println(StatisticsHelper.getConsumoTotal(matrizConsumo));

        System.out.println();

        StatisticsHelper.getMediaDeConsumoPorSubEstacao(matrizConsumo);
        System.out.println();
        StatisticsHelper.getConsumoTotalPorMes(matrizConsumo);
    }
}