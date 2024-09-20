import util.CsvManager;
import util.ReportFactory;
import util.StatisticsUtil;
import util.constants.CsvFilesPath;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ReportFactory reportFactory = new ReportFactory();

        reportFactory.gerarRelatorioPDF(
                CsvFilesPath.CONSUMO_20_PATH.getPath(),
                 ""
        );

//        CsvManager csvManager = new CsvManager(CsvFilesPath.CONSUMO_20_PATH.getPath());
//        StatisticsUtil statisticsUtil = new StatisticsUtil();
//
//        csvManager.lerArquivoCsv();
//
//        System.out.println(statisticsUtil.getMediaDeConsumoPorSubEstacao(csvManager.getMatrizConsumo()));
//        System.out.println();
//        System.out.println(statisticsUtil.getConsumoTotalPorMes(csvManager.getMatrizConsumo()));

    }
}