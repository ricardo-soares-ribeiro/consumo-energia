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
                throw new RuntimeException("Não foi possível converter o valor informado para consumo.", exception);
            } catch (IllegalArgumentException exception) {
                throw new RuntimeException("Valor informado para o mês ou a subestação está incorreto.", exception);
            }
        }
    }

    public String exibirMatriz() {

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%-10s", ""));
        for (Mes mes : Mes.values()) {
            sb.append(String.format("%-10s", mes.name()));
        }

        sb.append("\n");

        for (SubEstacao subestacao : SubEstacao.values()) {
            sb.append(String.format("%-10s", subestacao.name()));
            for (Mes mes : Mes.values()) {
                sb.append(String.format("%-10s", matrizConsumo[subestacao.getCodigo() - 1][mes.getNumero() - 1]));
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public int[][] getMatrizConsumo() {
        return matrizConsumo;
    }
}
