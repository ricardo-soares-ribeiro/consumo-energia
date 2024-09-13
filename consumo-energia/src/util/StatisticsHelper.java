package util;

import util.constants.Mes;
import util.constants.SubEstacao;
import java.util.HashMap;
import java.util.Map;

public final class StatisticsHelper {

    public static String getMenorConsumo(int[][] matrizConsumo) {

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

        return "Subestação com menor consumo mensal: \n" + subEstacaoMenorConsumo + " - " + mesMenorConsumo + " (" + menorConsumo + ")";
    }

    public static String getMaiorConsumo(int[][] matrizConsumo) {

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

        return "Subestação com maior consumo mensal: \n" + subEstacaoMaiorConsumo + " - " + mesMaiorConsumo + " (" + maiorConsumo + ")";
    }

    public static String getConsumoTotal(int[][] matrizConsumo) {
        int totalConsumo = 0;

        for (int i = 0; i < matrizConsumo.length; i++) {
            for (int j = 0; j < matrizConsumo[i].length; j++) {
                int valorConsumo = matrizConsumo[i][j];

                totalConsumo += valorConsumo;
            }
        }

        return "Total geral de consumo: " + totalConsumo;
    }

    public static void getMediaDeConsumoPorSubEstacao(int[][] matrizConsumo) {

        HashMap<String, String> tabela = new HashMap<>();

        int soma = 0;
        double media;

        for (int i = 0; i < matrizConsumo.length; i++) {
            for (int j = 0; j < matrizConsumo[i].length; j++) {
                int valorConsumo = matrizConsumo[i][j];
                soma += valorConsumo;
            }

            media = (double) soma / matrizConsumo[i].length;
            tabela.put(SubEstacao.getSubEstacao(i + 1).name(), String.format("%.2f", media));

            soma = 0;
        }

        System.out.printf("%-10s", "");
        System.out.print("Média");
        System.out.println();
        for (Map.Entry<String, String> m : tabela.entrySet()) {
            System.out.printf("%-10s", m.getKey());
            System.out.printf("%-10s", m.getValue());
            System.out.println();
        }
    }

    public static void getConsumoTotalPorMes(int[][] matrizConsumo) {

        HashMap<String, Integer> tabela = new HashMap<>();

        String mes;
        int consumo;

        for (int i = 0; i < matrizConsumo.length; i++) {
            for (int j = 0; j < matrizConsumo[i].length; j++) {
                mes = Mes.getMes(j + 1).name();
                consumo = matrizConsumo[i][j];

                if (!tabela.containsKey(mes)) {
                    tabela.put(mes, consumo);
                } else {
                    tabela.put(mes, tabela.get(mes) + consumo);
                }
            }
        }

        System.out.printf("%-10s", "Mês");
        System.out.printf("%-10s", "Consumo Total");
        System.out.println();
        for (Mes m : Mes.values()) {
            System.out.printf("%-10s", m.name());
            System.out.printf("%-10s", tabela.get(m.name()));
            System.out.println();
        }
    }
}
