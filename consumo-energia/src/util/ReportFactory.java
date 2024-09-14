package util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import util.constants.Mes;
import util.constants.SubEstacao;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ReportFactory {

    public void gerarRelatorioPDF(String csvFilePath, String pdfFilePath) {

        CsvManager csvManager = new CsvManager(csvFilePath);
        StatisticsUtil statisticsUtil = new StatisticsUtil();

        try {
            csvManager.lerArquivoCsv();
            csvManager.exibirMatriz();

            int[][] matrizConsumo = csvManager.getMatrizConsumo();

            Document document = new Document();

            PdfWriter.getInstance(document,new FileOutputStream(pdfFilePath));

            document.open();

            Font fontTitulo = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, BaseColor.BLACK);
            Font fontTexto = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, BaseColor.BLACK);
            Font fontLabel = FontFactory.getFont(FontFactory.TIMES_ROMAN, 8, BaseColor.BLACK);
            Font fontValores = FontFactory.getFont(FontFactory.TIMES_ROMAN, 6, BaseColor.BLACK);


            document.add(new Paragraph(new Chunk("Relatório de Consumo \n\n", fontTitulo)));


            // Adiciona matriz de consumo ao PDF
            PdfPTable table = new PdfPTable(Mes.values().length + 1);
            table.setWidthPercentage(100);

            float[] columnWidths = new float[Mes.values().length + 1];
            columnWidths[0] = 2.3f;
            for (int i = 1; i < columnWidths.length; i++) {
                columnWidths[i] = 1.0f;
            }
            table.setWidths(columnWidths);

            table.addCell(createCell("SUBESTAÇÃO", fontLabel));
            for (Mes mes : Mes.values()) {
                table.addCell(createCell(mes.name().substring(0, 3), fontLabel));
            }

            for (SubEstacao subestacao : SubEstacao.values()) {
                table.addCell(createCell(subestacao.name(), fontLabel));
                for (Mes mes : Mes.values()) {
                    table.addCell(createCell(String.valueOf(csvManager.getMatrizConsumo()[subestacao.getCodigo() - 1][mes.getNumero() - 1]), fontValores));
                }
            }

            document.add(table);


            // Adiciona estatísticas ao PDF
            document.add(new Paragraph(new Chunk("\nEstatísticas\n\n", fontTitulo)));
            document.add(new Paragraph(new Chunk(statisticsUtil.getMenorConsumo(matrizConsumo), fontTexto)));
            document.add(new Paragraph(new Chunk("\n", fontTexto)));
            document.add(new Paragraph(new Chunk(statisticsUtil.getMaiorConsumo(matrizConsumo), fontTexto)));
            document.add(new Paragraph(new Chunk("\n", fontTexto)));
            document.add(new Paragraph(new Chunk(statisticsUtil.getConsumoTotal(matrizConsumo), fontTexto)));

            document.close();

            System.out.println("Relatório PDF gerado com sucesso em: " + pdfFilePath);


        } catch (FileNotFoundException exception) {
            System.out.println(exception + "Arquivo não encontrado.");
        } catch (DocumentException exception) {
            System.out.println(exception + "Não foi possível adicionar elemento no PDF.");
        }
    }

    private static PdfPCell createCell(String content, Font font) {
        PdfPCell cell = new PdfPCell(new Phrase(content, font));
        cell.setPadding(5);
        return cell;
    }
}
