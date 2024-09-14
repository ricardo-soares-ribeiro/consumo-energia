package util;

import util.constants.Mes;
import util.constants.SubEstacao;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CsvManager {

    int[][] matrizConsumo;

    String csvFilePath;

    public CsvManager(String csvFilePath) {
        this.matrizConsumo = new int[5][12];
        this.csvFilePath = csvFilePath;
    }

    public void lerArquivoCsv() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(csvFilePath));

        scanner.nextLine();

        preencherMatriz(scanner);

        scanner.close();
    }

    private void preencherMatriz(Scanner scanner) {
        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();
            String[] valores = linha.split(",");

            try {
                int mes = Mes.valueOf(valores[0].toUpperCase()).getNumero();
                int subEstacao = SubEstacao.valueOf(valores[1].toUpperCase()).getCodigo();
                int consumo = Integer.parseInt(valores[2]);

                matrizConsumo[subEstacao - 1][mes - 1] = consumo;

            } catch (NumberFormatException exception) {
                System.out.println(exception + "Não foi possível converter o valor informado para consumo.");
            } catch (IllegalArgumentException exception) {
                System.out.println(exception + "Valor informado para o mês ou a subestação está incorreto.");
            }
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

    public int[][] getMatrizConsumo() {
        return matrizConsumo;
    }
}
