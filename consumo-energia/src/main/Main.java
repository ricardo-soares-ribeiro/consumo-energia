package main;

import util.ReportFactory;
import util.constants.CsvFilesPath;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ReportFactory reportFactory = new ReportFactory();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(reportFactory.resolveTxtPath()))) {

            writer.write("COMO O PROGRAMA FOI IMPLEMENTADO: ");
            writer.write("\n\n");
            writer.write("O programa foi projetado para gerar um relatório a partir de arquivos CSV contendo dados de consumo de energia. \nEle percorre uma lista de arquivos CSV, lê seus dados, preenche uma matriz de consumo, e calcula as informações estatísticas requisitadas. \nOs resultados são escritos em um arquivo de texto que contém a matriz de consumo, estatísticas como menor e maior consumo, \ntotal de consumo, média por subestação e consumo total por mês.");
            writer.write("\n\n");
            writer.write("O código pode ser dividido em três partes principais: \n");
            writer.write("\n1. Leitura dos dados: A classe CsvManager é responsável por ler os arquivos CSV, preencher a matriz de consumo e exibir os dados formatados");
            writer.write("\n2. Cálculo de estatísticas: A classe StatisticsUtil é utilizada para processar a matriz de consumo e gerar relatórios de estatísticas");
            writer.write("\n3. Geração do relatório: A classe ReportFactory centraliza o processo, combinando a leitura de CSVs, geração de estatísticas e a escrita dos \nresultados no arquivo resultados.txt");

            writer.write("\n\n\n");

            writer.write("COMPLEXIDADE BIG O DE CADA MÉTODO: ");
            writer.write("\n\n");
            writer.write("1. CsvManager.lerArquivoCsv(): O(n)");
            writer.write("\n2. CsvManager.preencherMatriz(): O(n)");
            writer.write("\n3. CsvManager.exibirMatriz(): O(1)");
            writer.write("\n4. StatisticsUtil.getMenorConsumo(): O(1)");
            writer.write("\n5. StatisticsUtil.getMaiorConsumo(): O(1)");
            writer.write("\n6. StatisticsUtil.getConsumoTotal(): O(1)");
            writer.write("\n7. StatisticsUtil.getMediaDeConsumoPorSubEstacao(): O(1)");
            writer.write("\n8. StatisticsUtil.getConsumoTotalPorMes(): O(1)");
            writer.write("\n9. ReportFactory.gerarRelatorioTxt(): O(n)");

            writer.write("\n\nConsiderando que n = número de linhas no arquivo CSV, temos que: \n\n");
            writer.write("Os métodos (1) e (2) são O(n) pois o número de repetições depende diretamente da quantidade de linhas no arquivo CSV.\n\n");
            writer.write("O método (3) é O(1) pois tanto o número de subestações como o número de meses são fixos e, portanto, não depende da quantidade de linhas no arquivo CSV.\n\n");
            writer.write("Todos os métodos da classe StatisticsUtil são O(1) pelo mesmo motivo, dependem apenas da quantidade fixa de meses e subestações.\n\n");
            writer.write("O método (9) é O(n) devido à chamada interna do método CsvManager.lerArquivoCsv(), o qual também é O(n). Como os demais métodos chamados internamente são \ntodos O(1) da classe StatisticsUtil, a complexidade O(n) se sobrepõe às demais.");

            writer.write("\n\n\n--------------------------------------------------------------------------------");
            writer.write("\n\n\n");


            writer.write("EVIDÊNCIAS DOS CASOS DE TESTE: \n\n");

            for (CsvFilesPath path : CsvFilesPath.values()) {
                reportFactory.gerarRelatorioTxt(path.getPath(), writer);
            }

            writer.close();

            System.out.println("Relatório gerado com sucesso em: " + reportFactory.resolveTxtPath());
        }
    }
}