import util.CsvManager;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        CsvManager csvManager = new CsvManager();

        try {
            csvManager.lerArquivoCsv();
            csvManager.exibirMatriz();
        } catch (FileNotFoundException exception) {
            System.out.println(exception + " : Arquivo não encontrado.");
        }
    }
}