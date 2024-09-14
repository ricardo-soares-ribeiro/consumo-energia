import util.ReportFactory;
import util.constants.CsvFilesPath;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ReportFactory reportFactory = new ReportFactory();

        reportFactory.gerarRelatorioPDF(
                CsvFilesPath.CONSUMO_20_PATH.getPath(),
                 ""
        );
    }
}