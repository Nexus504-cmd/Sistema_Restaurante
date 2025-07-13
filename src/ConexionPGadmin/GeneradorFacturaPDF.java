package ConexionPGadmin;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;

public class GeneradorFacturaPDF {

    public static void generarFactura(String nombreCliente, String[] productos, double[] precios, double total) {
        Document documento = new Document(PageSize.A4, 50, 50, 50, 50);

        try {
            String fechaHoy = LocalDate.now().toString(); // ejemplo: 2025-07-11
            String ruta = "Factura_" + nombreCliente.replace(" ", "_") + "_" + fechaHoy + ".pdf";
            PdfWriter.getInstance(documento, new FileOutputStream(ruta));
            documento.open();

            // ===== TÍTULO =====
            Paragraph titulo = new Paragraph("DON RICO SAC", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20, BaseColor.RED));
            titulo.setAlignment(Element.ALIGN_CENTER);
            documento.add(titulo);

            Paragraph rucDireccion = new Paragraph("RUC: 2073140478 | Av. Sabor y Sazón 378, Lima - Perú",
                    FontFactory.getFont(FontFactory.HELVETICA, 10));
            rucDireccion.setAlignment(Element.ALIGN_CENTER);
            documento.add(rucDireccion);

            documento.add(Chunk.NEWLINE);
            documento.add(new LineSeparator());
            documento.add(Chunk.NEWLINE);

            // ===== DATOS DEL CLIENTE =====
            PdfPTable datosCliente = new PdfPTable(2);
            datosCliente.setWidthPercentage(100);

            datosCliente.addCell(getCell("Cliente:", PdfPCell.ALIGN_LEFT, true));
            datosCliente.addCell(getCell(nombreCliente, PdfPCell.ALIGN_LEFT, false));

            datosCliente.addCell(getCell("Fecha:", PdfPCell.ALIGN_LEFT, true));
            datosCliente.addCell(getCell(fechaHoy, PdfPCell.ALIGN_LEFT, false));

            documento.add(datosCliente);

            documento.add(Chunk.NEWLINE);
            documento.add(new Paragraph("Detalle del Pedido:", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12)));
            documento.add(Chunk.NEWLINE);

            // ===== TABLA DE PRODUCTOS =====
            PdfPTable tabla = new PdfPTable(3);
            tabla.setWidthPercentage(100);
            tabla.setWidths(new float[]{1, 6, 3});

            tabla.addCell(getHeaderCell("N°"));
            tabla.addCell(getHeaderCell("Producto"));
            tabla.addCell(getHeaderCell("Precio (S/.)"));

            for (int i = 0; i < productos.length; i++) {
                tabla.addCell(getBodyCell(String.valueOf(i + 1)));
                tabla.addCell(getBodyCell(productos[i]));
                tabla.addCell(getBodyCell(String.format("%.2f", precios[i])));
            }

            documento.add(tabla);
            documento.add(Chunk.NEWLINE);

            // ===== TOTAL =====
            Paragraph totalParrafo = new Paragraph("Total a pagar: S/. " + String.format("%.2f", total),
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14));
            totalParrafo.setAlignment(Element.ALIGN_RIGHT);
            documento.add(totalParrafo);

            documento.add(Chunk.NEWLINE);
            documento.add(new LineSeparator());
            documento.add(Chunk.NEWLINE);

            // ===== PIE DE PÁGINA =====
            Paragraph pie = new Paragraph("Gracias por su compra. ¡Vuelva pronto!",
                    FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 10, BaseColor.GRAY));
            pie.setAlignment(Element.ALIGN_CENTER);
            documento.add(pie);

            documento.close();
            System.out.println("✅ Factura generada correctamente: " + ruta);

            // ===== ABRIR PDF AUTOMÁTICAMENTE =====
            if (Desktop.isDesktopSupported()) {
                File archivoPDF = new File(ruta);
                if (archivoPDF.exists()) {
                    Desktop.getDesktop().open(archivoPDF);
                }
            }

        } catch (Exception e) {
            System.out.println("❌ Error al generar factura: " + e.getMessage());
        }
    }

    private static PdfPCell getCell(String texto, int alignment, boolean negrita) {
        Font font = negrita
                ? FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10)
                : FontFactory.getFont(FontFactory.HELVETICA, 10);

        PdfPCell cell = new PdfPCell(new Phrase(texto, font));
        cell.setBorder(PdfPCell.NO_BORDER);
        cell.setHorizontalAlignment(alignment);
        return cell;
    }

    private static PdfPCell getHeaderCell(String texto) {
        PdfPCell cell = new PdfPCell(new Phrase(texto,
                FontFactory.getFont(FontFactory.HELVETICA_BOLD, 11, BaseColor.WHITE)));
        cell.setBackgroundColor(BaseColor.DARK_GRAY);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(8);
        return cell;
    }

    private static PdfPCell getBodyCell(String texto) {
        PdfPCell cell = new PdfPCell(new Phrase(texto, FontFactory.getFont(FontFactory.HELVETICA, 10)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(6);
        return cell;
    }

}
