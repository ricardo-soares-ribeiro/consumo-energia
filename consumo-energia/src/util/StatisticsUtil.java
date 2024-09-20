package util;

import util.constants.Mes;
import util.constants.SubEstacao;

public class StatisticsUtil {

    public String getMenorConsumo(int[][] matrizConsumo) {

        int menorConsumo = Integer.MAX_VALUE;
        String subEstacaoMenorConsumo = "";
        String mesMenorConsumo = "";

        for (int i = 0; i < matrizConsumo.length; i++) {
            for (int j = 0; j < matrizConsumo[i].length; j++) {
                int valorConsumo = matrizConsumo[i][j];

                if (valorConsumo != 0 && valorConsumo < menorConsumo) {
                    menorConsumo = valorConsumo;
                    subEstacaoMenorConsumo = SubEstacao.getSubEstacao(i + 1).name();
                    mesMenorConsumo = Mes.getMes(j + 1).name();
                }
            }
        }

        return "Subestação com menor consumo mensal: " + subEstacaoMenorConsumo + " - " + mesMenorConsumo + " (" + menorConsumo + ")\n";
    }

    public String getMaiorConsumo(int[][] matrizConsumo) {

        int maiorConsumo = 0;
        String subEstacaoMaiorConsumo = "";
        String mesMaiorConsumo = "";

        for (int i = 0; i < matrizConsumo.length; i++) {
            for (int j = 0; j < matrizConsumo[i].length; j++) {
                int valorConsumo = matrizConsumo[i][j];

                if (valorConsumo != 0 && valorConsumo > maiorConsumo) {
                    maiorConsumo = valorConsumo;
                    subEstacaoMaiorConsumo = SubEstacao.getSubEstacao(i + 1).name();
                    mesMaiorConsumo = Mes.getMes(j + 1).name();
                }
            }
        }

        return "Subestação com maior consumo mensal: " + subEstacaoMaiorConsumo + " - " + mesMaiorConsumo + " (" + maiorConsumo + ")\n";
    }

    public String getConsumoTotal(int[][] matrizConsumo) {
        int totalConsumo = 0;

        for (int i = 0; i < matrizConsumo.length; i++) {
            for (int j = 0; j < matrizConsumo[i].length; j++) {
                int valorConsumo = matrizConsumo[i][j];

                totalConsumo += valorConsumo;
            }
        }

        return "Total geral de consumo: " + totalConsumo + "\n";
    }

    public String getMediaDeConsumoPorSubEstacao(int[][] matrizConsumo) {

        StringBuilder sb = new StringBuilder();

        double[] medias = new double[SubEstacao.values().length];

        int soma = 0;
        double media;

        for (int i = 0; i < matrizConsumo.length; i++) {
            for (int j = 0; j < matrizConsumo[i].length; j++) {
                int valorConsumo = matrizConsumo[i][j];
                soma += valorConsumo;
            }

            media = (double) soma / matrizConsumo[i].length;
            medias[i] = media;

            soma = 0;
        }

        sb.append(String.format("%-10s", ""));
        sb.append("Média\n");

        for (int i = 0; i < SubEstacao.values().length; i++) {
            sb.append(String.format("%-10s", SubEstacao.getSubEstacao(i + 1).name()));
            sb.append(String.format("%-10s", String.format("%.2f", medias[i])));
            sb.append("\n");
        }

        return sb.toString();
    }

    public String getConsumoTotalPorMes(int[][] matrizConsumo) {

        StringBuilder sb = new StringBuilder();

        int[] consumoTotalMes = new int[Mes.values().length];

        for (int i = 0; i < matrizConsumo.length; i++) {
            for (int j = 0; j < matrizConsumo[i].length; j++) {
                consumoTotalMes[j] += matrizConsumo[i][j];
            }
        }

        sb.append(String.format("%-10s", "Mês"));
        sb.append(String.format("%-10s", "Consumo Total"));
        sb.append("\n");

        for (int j = 0; j < Mes.values().length; j++) {
            sb.append(String.format("%-10s", Mes.getMes(j + 1).name()));
            sb.append(String.format("%-10s", consumoTotalMes[j]));
            sb.append("\n");
        }

        return sb.toString();
    }
}
