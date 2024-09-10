package util;

import util.constants.CsvFilesPath;
import util.constants.Mes;
import util.constants.SubEstacao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CsvManager {

    int[][] matrizConsumo;

    public CsvManager() {
        this.matrizConsumo = new int[5][12];
    }

    public void lerArquivoCsv() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(CsvFilesPath.CONSUMO_20_PATH.getPath()));

        scanner.nextLine();

        preencherMatriz(scanner);
    }

    private void preencherMatriz(Scanner scanner) {
        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();
            String[] valores = linha.split(",");

            int mes = Mes.valueOf(valores[0].toUpperCase()).getNumero();
            int subEstacao = SubEstacao.valueOf(valores[1].toUpperCase()).getCodigo();
            int consumo = Integer.parseInt(valores[2]);

            matrizConsumo[subEstacao - 1][mes - 1] = consumo;
        }
    }

    public void exibirMatriz() {
        System.out.printf("%-10s", "");
        for (Mes mes : Mes.values()) {
            System.out.printf("%-10s", mes.name());
        }

        System.out.println();

        for (SubEstacao subestacao : SubEstacao.values()) {
            System.out.printf("%-10s", subestacao.name());
            for (Mes mes : Mes.values()) {
                System.out.printf("%-10s", matrizConsumo[subestacao.getCodigo() - 1][mes.getNumero() - 1]);
            }
            System.out.println();
        }
    }
}
