package util;

import util.constants.Mes;
import util.constants.SubEstacao;
import java.util.HashMap;
import java.util.Map;

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

        sb.append(String.format("%-10s", ""));
        sb.append("Média\n");
        for (Map.Entry<String, String> m : tabela.entrySet()) {
            sb.append(String.format("%-10s", m.getKey()));
            sb.append(String.format("%-10s", m.getValue()));
            sb.append("\n");
        }

        return sb.toString();
    }

    public String getConsumoTotalPorMes(int[][] matrizConsumo) {

        StringBuilder sb = new StringBuilder();

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

        sb.append(String.format("%-10s", "Mês"));
        sb.append(String.format("%-10s", "Consumo Total"));
        sb.append("\n");
        for (Mes m : Mes.values()) {
            sb.append(String.format("%-10s", m.name()));
            sb.append(String.format("%-10s", tabela.get(m.name())));
            sb.append("\n");
        }

        return sb.toString();
    }
}
