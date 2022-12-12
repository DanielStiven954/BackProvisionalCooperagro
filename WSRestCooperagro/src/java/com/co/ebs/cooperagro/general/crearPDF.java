package com.co.ebs.cooperagro.general;

import com.co.ebs.cooperagro.respuestasGenericas.ResponseEstadoCuenta;
//import com.ebssystem.Detallecta;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.math.BigInteger;
import java.net.URL;
import java.nio.file.Paths;
import java.text.ParseException;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Locale;
import wsmovimientoscygnus_retefuente.RespuestaCert;

/**
 *
 * @author YO
 */
public class crearPDF {

    public static final Font FONT_NORMAL = new Font(Font.FontFamily.HELVETICA, 14, Font.NORMAL, BaseColor.BLACK);
    public static final Font BLACK_BOLD = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.BLACK);
    public static final Font ITALIC = new Font(Font.FontFamily.HELVETICA, 12, Font.ITALIC, new BaseColor(141, 141, 141));
    public static final Font font = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL, new BaseColor(84, 136, 90));
    public static final Font font_BOLD = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, new BaseColor(84, 136, 90));
    public static final Font FONT_BOLD = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, new BaseColor(41, 108, 48));
    public static final String RUTA_RETEFUENTE = "D:\\cooperagro\\Retencion\\";

    public void item(Document document, String linea, String saldo) throws DocumentException {
        PdfPTable table;
        PdfPCell cellL;
        PdfPCell cellR;
        Font font = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL, BaseColor.BLACK);
        table = new PdfPTable(5);
        cellL = new PdfPCell(new Phrase(linea.toLowerCase(), font));
        cellL.setHorizontalAlignment(Element.ALIGN_LEFT);
        cellL.setColspan(4);
        cellL.setBorder(Rectangle.NO_BORDER);

        cellR = new PdfPCell(new Phrase("$ " + saldo, font));

        cellR.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cellR.setBorder(Rectangle.NO_BORDER);
        table.addCell(cellL);
        table.addCell(cellR);
        table.setSpacingBefore(5);
        table.setWidthPercentage(100);
        document.add(table);
    }

    public void itemBackgroud(Document document, String linea, String saldo) throws DocumentException {

        PdfPTable table;
        PdfPCell cellL;
        PdfPCell cellR;
        Font font2 = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL, BaseColor.BLACK);
        table = new PdfPTable(5);
        cellL = new PdfPCell(new Phrase(linea, font2));
        cellL.setBackgroundColor(new BaseColor(84, 136, 90));
        cellL.setHorizontalAlignment(Element.ALIGN_LEFT);
        cellL.setColspan(4);
        cellL.setPaddingTop(5);
        cellL.setPaddingLeft(8);
        cellL.setPaddingBottom(8);
        cellL.setBorder(Rectangle.NO_BORDER);

        cellR = new PdfPCell(new Phrase("$ " + saldo, font2));
        cellR.setBackgroundColor(new BaseColor(84, 136, 90));
        cellR.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cellR.setBorder(Rectangle.NO_BORDER);
        cellR.setPaddingTop(5);
        cellR.setPaddingRight(8);
        cellR.setPaddingBottom(8);
        table.addCell(cellL);
        table.addCell(cellR);
        table.setSpacingBefore(5);
        table.setWidthPercentage(100);
        document.add(table);
    }

    public boolean generarReteFuente(RespuestaCert respuestaCert, String sIdentificacion, String SNombre, String fechaInicio, String fechaFin, String generoP) {

        String genero = (generoP.equals("F") ? " la señora " : " el señor ");
        String identificado = (generoP.equals("F") ? " identificada" : " identificado");
        String sustantivo = (generoP.equals("F") ? " la " : " él ");
        String cita = (generoP.equals("F") ? "citada " : "citado ");

        try {
            LocalDate localDate = LocalDate.now();

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(RUTA_RETEFUENTE + sIdentificacion + ".pdf"));
            document.open();

            Image encabezado = Image.getInstance("D:\\cooperagro\\assets\\Header.png");
            encabezado.scaleAbsolute(595, 100);
            encabezado.setAbsolutePosition(0, 772);

            Image logo = Image.getInstance("D:\\cooperagro\\assets\\logoPNG.png");
            logo.scaleAbsolute(320, 100);

            Paragraph parrafo1 = new Paragraph("");
            parrafo1.add(encabezado);
            Paragraph parrafo = new Paragraph("");
            parrafo.add(logo);
            parrafo.setSpacingBefore(35);

            document.add(parrafo1);
            document.add(parrafo);

            Chunk fechaT = new Chunk("Fecha: \n");
            Chunk fecha = new Chunk(localDate.getDayOfMonth() + "/" + localDate.getMonthValue() + "/" + localDate.getYear(), font);

            Paragraph parrafo3 = new Paragraph();
            parrafo3.setSpacingBefore(-43);
            parrafo3.setIndentationLeft(450);
            parrafo3.setAlignment(Element.ALIGN_RIGHT);
            parrafo3.add(fechaT);
            parrafo3.add(fecha);
            document.add(parrafo3);

            Paragraph parrafo4 = new Paragraph();
            Chunk texto1 = new Chunk("Hacemos constar que desde el " + fechaInicio + " hasta " + fechaFin + genero, FONT_NORMAL);
            Chunk texto2 = new Chunk(SNombre.toUpperCase(), FONT_NORMAL);
            Chunk texto3 = new Chunk(identificado + " con CC No. " + sIdentificacion
                    + " presenta el siguiente estado de cuenta: \nIgualmente certificamos que por concepto "
                    + "de los préstamos otorgados"+ sustantivo + cita + "canceló intereses así:", FONT_NORMAL);
            parrafo4.add(texto1);
            parrafo4.add(texto2);
            parrafo4.add(texto3);
            parrafo4.setAlignment(Element.ALIGN_JUSTIFIED);
            parrafo4.setSpacingBefore(50);

            document.add(parrafo4);

            Image separadorImg = Image.getInstance("D:\\cooperagro\\assets\\separador1.png");
            separadorImg.scaleAbsolute(520, 1);
            Paragraph separador = new Paragraph();
            separador.add(separadorImg);
            separador.setSpacingBefore(40);
            document.add(separador);
            separador.setSpacingBefore(2);

            utilidad util = new utilidad();

            BigInteger totalLiqCert = new BigInteger("0");

            for (int i = 0; i < respuestaCert.getRLiquidacion().getLiquidacionCert().size(); i++) {
                item(document, "saldo obligación " + respuestaCert.getRLiquidacion().getLiquidacionCert().get(i).getSLinea(), util.valorPattern(respuestaCert.getRLiquidacion().getLiquidacionCert().get(i).getSSaldo()));
                totalLiqCert = totalLiqCert.add(new BigInteger("".equals(respuestaCert.getRLiquidacion().getLiquidacionCert().get(i).getSSaldo()) ? "0" : respuestaCert.getRLiquidacion().getLiquidacionCert().get(i).getSSaldo()));
            }

            document.add(separador);
            itemBackgroud(document, "total obligaciones", util.valorPattern(totalLiqCert + ""));
            document.add(separador);

            BigInteger totalAportesCert = new BigInteger("0");

            for (int i = 0; i < respuestaCert.getAportesLiq().getAportesCert().size(); i++) {

                item(document, respuestaCert.getAportesLiq().getAportesCert().get(i).getSLinea(), util.valorPattern(respuestaCert.getAportesLiq().getAportesCert().get(i).getSSaldo()));
                totalAportesCert = totalAportesCert.add(new BigInteger("".equals(   respuestaCert.getAportesLiq().getAportesCert().get(i).getSSaldo()) ? "0" : respuestaCert.getAportesLiq().getAportesCert().get(i).getSSaldo()));
            }

            document.add(separador);

            itemBackgroud(document, "total aportes", util.valorPattern(totalAportesCert + ""));

            document.add(separador);

            for (int i = 0; i < respuestaCert.getIntLiquidacion().getInteresesCert().size(); i++) {
                item(document, respuestaCert.getIntLiquidacion().getInteresesCert().get(i).getSLinea(), util.valorPattern("".equals(respuestaCert.getIntLiquidacion().getInteresesCert().get(i).getSSaldo()) ? "0" : respuestaCert.getIntLiquidacion().getInteresesCert().get(i).getSSaldo()));
            }

            Paragraph atentamente = new Paragraph("Atentamente,");
            atentamente.setSpacingBefore(50);
            atentamente.setAlignment(Element.ALIGN_CENTER);
            document.add(atentamente);
            separadorImg.scaleAbsolute(160, 1);
            separadorImg.setAlignment(Element.ALIGN_CENTER);
            separador.setSpacingBefore(20);
            document.add(separador);
            Paragraph firma = new Paragraph();
            Chunk firmaF = new Chunk("Original firmado", ITALIC);
            firma.add(firmaF);
            firma.setSpacingBefore(-19);
            firma.setFont(ITALIC);
            firma.setAlignment(Element.ALIGN_CENTER);
            document.add(firma);
            Paragraph gerente = new Paragraph("HELDA USTARIZ USTARIZ \n Gerente");
            gerente.setAlignment(Element.ALIGN_CENTER);
            document.add(gerente);

            Image footer = Image.getInstance("D:\\cooperagro\\assets\\Coop.png");
            footer.scaleAbsolute(595, 40);
            footer.setAbsolutePosition(0, 0);
            document.add(footer);

            document.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(crearPDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(crearPDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(crearPDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(crearPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

/*    public boolean generarPazySalvo(Detallecta detalleCta, String sIdentificacion, String SNombre, String generoP) {

        String genero = (generoP.equals("F") ? "la señora" : "el señor");
        String identificado = (generoP.equals("F") ? "identificada" : "identificado");
        String interes = (generoP.equals("F") ? "de la interesada" : "del interesado");
        String fechaSplit[] = detalleCta.getSFechaUltPago().split("/");
        String fechaUlpago = "día " + fechaSplit[0] + " de " + fechaSplit[1].toLowerCase() + " de " + fechaSplit[2];
        try {
            LocalDate localDate = LocalDate.now();
            Calendar calendar = Calendar.getInstance();

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("D:\\cooperagro\\certificadoPaz_Salvo" + sIdentificacion + ".pdf"));
            document.open();

            Image encabezado = Image.getInstance("D:\\cooperagro\\assets\\Header.png");
            encabezado.scaleAbsolute(595, 100);
            encabezado.setAbsolutePosition(0, 772);

            Image logo = Image.getInstance("D:\\cooperagro\\assets\\logoPNG.png");
            logo.scaleAbsolute(320, 100);

            Paragraph parrafo1 = new Paragraph("");
            parrafo1.add(encabezado);
            Paragraph parrafo = new Paragraph("");
            parrafo.add(logo);
            parrafo.setSpacingBefore(35);

            document.add(parrafo1);
            document.add(parrafo);

            Chunk fechaT = new Chunk("JGS   / Cartera  \n", FONT_BOLD);
            //Chunk fecha = new Chunk(LocalDate.now().getMonth().getDisplayName(TextStyle.FULL, new Locale("es", "ES")).toUpperCase() + " / " + localDate.getYear(), FONT_BOLD);
            Chunk fecha = new Chunk(localDate.getDayOfMonth() + "/"
                    + LocalDate.now().getMonth().getDisplayName(TextStyle.FULL, new Locale("es", "ES")).toUpperCase()
                    + "/" + localDate.getYear()
                    + " \n" + (calendar.getTime().getHours() < 10 ? "0" + calendar.getTime().getHours() : calendar.getTime().getHours()) + ":"
                    + (calendar.getTime().getMinutes() <= 9 ? "0" + calendar.getTime().getMinutes() : calendar.getTime().getMinutes()) + ":" + (calendar.getTime().getSeconds() < 10 ? "0" + calendar.getTime().getSeconds() : calendar.getTime().getSeconds()), FONT_BOLD);

            Paragraph parrafo3 = new Paragraph();
            parrafo3.setSpacingBefore(-43);
            parrafo3.setIndentationLeft(350);
            parrafo3.setAlignment(Element.ALIGN_RIGHT);
            parrafo3.add(fechaT);
            parrafo3.add(fecha);
            document.add(parrafo3);

            Paragraph parrafo4 = new Paragraph();
            Chunk texto1 = new Chunk("LA SUSCRITA GERENTE DE LA COOPERATIVA MULTIACTIVA\n"
                    + "DE TRABAJADORES Y PENSIONADOS DE ESTABLECIMIENTOS\n"
                    + "DEL MINISTERIO DE AGRICULTURA Y OTROS\n"
                    + "COOPERAGRO E.C.", FONT_NORMAL);
            parrafo4.add(texto1);
            parrafo4.setAlignment(Element.ALIGN_CENTER);
            parrafo4.setSpacingBefore(70);

            document.add(parrafo4);

            Paragraph subTitulo = new Paragraph();
            Chunk texto2 = new Chunk("Certifica:", FONT_NORMAL);
            subTitulo.add(texto2);
            subTitulo.setAlignment(Element.ALIGN_CENTER);
            subTitulo.setSpacingBefore(50);

            document.add(subTitulo);

            Paragraph parrafo5 = new Paragraph();
            Chunk texto3 = new Chunk("Que " + genero + " ", FONT_NORMAL);
            Chunk texto4 = new Chunk(SNombre.toUpperCase() + ", ", FONT_NORMAL);
            Chunk texto5 = new Chunk(identificado + " con cédula de ciudadanía número " + sIdentificacion + " el " + fechaUlpago + " " + "pagó en su totalidad el crédito con número de radicado " + detalleCta.getINumRadic()
                    + " de la línea " + detalleCta.getSNombreLinea().toLowerCase() + ".", FONT_NORMAL);
            parrafo5.add(texto3);
            parrafo5.add(texto4);
            parrafo5.add(texto5);
            parrafo5.setAlignment(Element.ALIGN_CENTER);
            parrafo5.setSpacingBefore(20);

            document.add(parrafo5);

            Paragraph parrafo6 = new Paragraph();
            //Chunk texto6 = new Chunk("Crédito ", FONT_NORMAL);
            //Chunk texto7 = new Chunk("No. " + detalleCta.getINumRadic() + " ", BLACK_BOLD);
            //Chunk texto8 = new Chunk("otorgado por la línea ", FONT_NORMAL);
            //Chunk texto9 = new Chunk(detalleCta.getSNombreLinea() + ", ", BLACK_BOLD);
            Chunk texto10 = new Chunk("Que " + genero + " ", FONT_NORMAL);
            Chunk texto11 = new Chunk(SNombre.toUpperCase() + " ", FONT_NORMAL);
            Chunk texto12 = new Chunk("se encuentra a paz y salvo por concepto del crédito anteriormente relacionado.", FONT_NORMAL);
            //parrafo6.add(texto6);
            //parrafo6.add(texto7);
            //parrafo6.add(texto8);
            //parrafo6.add(texto9);
            parrafo6.add(texto10);
            parrafo6.add(texto11);
            parrafo6.add(texto12);
            parrafo6.setAlignment(Element.ALIGN_CENTER);
            parrafo6.setSpacingBefore(20);

            document.add(parrafo6);

            Paragraph parrafo7 = new Paragraph();
            Chunk texto13 = new Chunk("Se expide la presente certificación por solicitud " + interes +", a los " + localDate.getDayOfMonth()
                    + " días del mes de " + localDate.getMonth().getDisplayName(TextStyle.FULL, new Locale("es", "ES")) + " de " + localDate.getYear() + " en la ciudad de Bogotá.", FONT_NORMAL);

            parrafo7.add(texto13);
            parrafo7.setAlignment(Element.ALIGN_CENTER);
            parrafo7.setSpacingBefore(20);

            document.add(parrafo7);

            Image separadorImg = Image.getInstance("D:\\cooperagro\\assets\\separador1.png");
            separadorImg.scaleAbsolute(160, 1);
            Paragraph separador = new Paragraph();
            separador.add(separadorImg);

            separadorImg.setAlignment(Element.ALIGN_CENTER);
            separador.setSpacingBefore(80);
            document.add(separador);
            Paragraph firma = new Paragraph();
            Chunk firmaF = new Chunk("Original firmado", ITALIC);
            firma.add(firmaF);
            firma.setSpacingBefore(-19);
            firma.setFont(ITALIC);
            firma.setAlignment(Element.ALIGN_CENTER);
            document.add(firma);
            Paragraph gerente = new Paragraph("HELDA USTARIZ USTARIZ \n Gerente");
            gerente.setAlignment(Element.ALIGN_CENTER);
            document.add(gerente);

            Image footer = Image.getInstance("D:\\cooperagro\\assets\\Coop.png");
            footer.scaleAbsolute(595, 40);
            footer.setAbsolutePosition(0, 0);
            document.add(footer);

            document.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            return false;
        } catch (DocumentException ex) {
            ex.printStackTrace();
            return false;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
*/
    public boolean generarEstadoCuenta(ResponseEstadoCuenta cuenta, String sIdentificacion, String SNombre) throws ParseException {

        utilidad util = new utilidad();

        try {
            LocalDate localDate = LocalDate.now();
            Calendar calendar = Calendar.getInstance();

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("D:\\cooperagro\\cuenta" + sIdentificacion + ".pdf"));
            document.open();

            Image encabezado = Image.getInstance("D:\\cooperagro\\assets\\Header.png");
            encabezado.scaleAbsolute(595, 100);
            encabezado.setAbsolutePosition(0, 772);

            Image logo = Image.getInstance("D:\\cooperagro\\assets\\logoPNG.png");
            logo.scaleAbsolute(320, 100);

            Paragraph parrafo1 = new Paragraph("");
            parrafo1.add(encabezado);
            Paragraph parrafo = new Paragraph("");
            parrafo.add(logo);
            parrafo.setSpacingBefore(35);

            document.add(parrafo1);
            document.add(parrafo);

            Chunk fechaT = new Chunk("Fecha: \n");
            Chunk fecha = new Chunk(localDate.getDayOfMonth() + "/"
                    + LocalDate.now().getMonth().getDisplayName(TextStyle.FULL, new Locale("es", "ES")).toUpperCase()
                    + "/" + localDate.getYear()
                    + " \n" + (calendar.getTime().getHours() < 10 ? "0" + calendar.getTime().getHours() : calendar.getTime().getHours()) + ":"
                    + (calendar.getTime().getMinutes() <= 9 ? "0" + calendar.getTime().getMinutes() : calendar.getTime().getMinutes()) + ":" + (calendar.getTime().getSeconds() < 10 ? "0" + calendar.getTime().getSeconds() : calendar.getTime().getSeconds()), FONT_BOLD);

            Paragraph parrafo3 = new Paragraph();
            parrafo3.setSpacingBefore(-43);
            parrafo3.setIndentationLeft(350);
            parrafo3.setAlignment(Element.ALIGN_RIGHT);
            parrafo3.add(fechaT);
            parrafo3.add(fecha);
            document.add(parrafo3);

            Paragraph parrafo4 = new Paragraph();
            Chunk texto1 = new Chunk("NOMBRE: ", FONT_NORMAL);
            Chunk texto2 = new Chunk(SNombre, BLACK_BOLD);
            parrafo4.add(texto1);
            parrafo4.add(texto2);
            parrafo4.setAlignment(Element.ALIGN_LEFT);
            parrafo4.setSpacingBefore(50);
            document.add(parrafo4);

            Paragraph parrafo5 = new Paragraph();
            Chunk texto3 = new Chunk("DOCUMENTO: ", FONT_NORMAL);
            Chunk texto4 = new Chunk(sIdentificacion, BLACK_BOLD);
            parrafo5.add(texto3);
            parrafo5.add(texto4);
            parrafo5.setAlignment(Element.ALIGN_LEFT);
            parrafo5.setSpacingBefore(10);
            document.add(parrafo5);

            Paragraph subTitulo = new Paragraph();
            Chunk texto9 = new Chunk("ESTADO DE CUENTA", FONT_BOLD);
            subTitulo.add(texto9);
            subTitulo.setAlignment(Element.ALIGN_CENTER);
            subTitulo.setSpacingBefore(30);
            document.add(subTitulo);

            Paragraph parrafo6 = new Paragraph();
            Chunk texto5 = new Chunk("DEUDA DE CRÉDITOS: ", FONT_NORMAL);
            Chunk texto6 = new Chunk("$ " + util.valorPattern(cuenta.getDeudaCreditos()), BLACK_BOLD);
            parrafo6.add(texto5);
            parrafo6.add(texto6);
            parrafo6.setAlignment(Element.ALIGN_LEFT);
            parrafo6.setSpacingBefore(20);
            document.add(parrafo6);

            Paragraph parrafo7 = new Paragraph();
            Chunk texto7 = new Chunk("APORTES REALIZADOS: ", FONT_NORMAL);
            Chunk texto8 = new Chunk("$ " + util.valorPattern(cuenta.getMisAportes()), BLACK_BOLD);
            parrafo7.add(texto7);
            parrafo7.add(texto8);
            parrafo7.setAlignment(Element.ALIGN_LEFT);
            parrafo7.setSpacingBefore(10);
            document.add(parrafo7);

            PdfPTable table;
            PdfPCell cellL;
            Font font2 = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL, BaseColor.WHITE);
            table = new PdfPTable(5);
            table.setWidthPercentage(100);
            cellL = new PdfPCell(new Phrase("MIS CRÉDITOS", font2));
            cellL.setBackgroundColor(new BaseColor(84, 136, 90));
            cellL.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellL.setColspan(5);
            cellL.setPaddingTop(5);
            cellL.setPaddingLeft(8);
            cellL.setPaddingBottom(8);
            cellL.setBorder(Rectangle.NO_BORDER);
            table.addCell(cellL);
            table.setSpacingBefore(30);
            document.add(table);

            /*Paragraph creditos = new Paragraph();
            Chunk texto10 = new Chunk("Mis créditos", font_BOLD);
            creditos.add(texto10);
            creditos.setAlignment(Element.ALIGN_CENTER);
            creditos.setSpacingBefore(30);
            document.add(creditos);*/
            float[] columnWidths = {4, 5, 4, 4, 5};
            PdfPTable tabla = new PdfPTable(columnWidths);

            tabla.setWidthPercentage(100);

            String columnasC[] = {"NÚMERO DE RADICADO", "LÍNEA", "VALOR CUOTA", "SALDO TOTAL", "FECHA DE PAGO"};

            for (int i = 0; i < columnasC.length; i++) {
                PdfPCell cellI;
                cellI = new PdfPCell(new Phrase(columnasC[i], font2));
                cellI.setBackgroundColor(new BaseColor(84, 136, 90));
                cellI.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellI.setColspan(1);
                cellI.setPaddingTop(5);
                cellI.setPaddingLeft(8);
                cellI.setPaddingBottom(8);
                tabla.addCell(cellI);
            }

            for (int i = 0; i < cuenta.getListCreditos().size(); i++) {
                tabla.addCell(cuenta.getListCreditos().get(i).getRadicado());
                tabla.addCell(cuenta.getListCreditos().get(i).getLinea());
//                tabla.addCell(cuenta.getListCreditos().get(i).getValorpago());
                //tabla.addCell(cuenta.getListCreditos().get(i).getSFechaUltPago());
//                tabla.addCell("$"+util.valorPattern(cuenta.getListCreditos().get(i).getSaldocapital()));
                tabla.addCell("$"+util.valorPattern(cuenta.getListCreditos().get(i).getCupo()));
//                tabla.addCell(cuenta.getListCreditos().get(i).getFechapago());
                //tabla.addCell(cuenta.getListCreditos().get(i).getSFechaUltPago());
            }

            tabla.setSpacingBefore(20);
            document.add(tabla);

            PdfPTable tableA;
            PdfPCell cellA;
            tableA = new PdfPTable(5);
            tableA.setWidthPercentage(100);
            cellA = new PdfPCell(new Phrase("MIS APORTES", font2));
            cellA.setBackgroundColor(new BaseColor(84, 136, 90));
            cellA.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellA.setColspan(5);
            cellA.setPaddingTop(5);
            cellA.setPaddingLeft(8);
            cellA.setPaddingBottom(8);
            cellA.setBorder(Rectangle.NO_BORDER);
            tableA.addCell(cellA);
            tableA.setSpacingBefore(30);
            document.add(tableA);

            PdfPTable tablaA = new PdfPTable(columnWidths);

            tablaA.setWidthPercentage(100);

            String columnasA[] = {"NÚMERO DE APORTES", "LÍNEA", "VALOR PAGO", "SALDO TOTAL", "FECHA DE PAGO"};

            for (int i = 0; i < columnasA.length; i++) {
                PdfPCell cellI;
                cellI = new PdfPCell(new Phrase(columnasA[i], font2));
                cellI.setBackgroundColor(new BaseColor(84, 136, 90));
                cellI.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellI.setColspan(1);
                cellI.setPaddingTop(5);
                cellI.setPaddingLeft(8);
                cellI.setPaddingBottom(8);
                tablaA.addCell(cellI);
            }

            for (int i = 0; i < cuenta.getListAportes().size(); i++) {
//                tablaA.addCell(cuenta.getListAportes().get(i).getNumapo());
                tablaA.addCell(cuenta.getListAportes().get(i).getCupo());
                tablaA.addCell(cuenta.getListAportes().get(i).getLinea());
//                tablaA.addCell(cuenta.getListAportes().get(i).getValorpago());
//                tablaA.addCell("$" + util.valorPattern(cuenta.getListAportes().get(i).getSaldocapital()));
                tablaA.addCell("$" + util.valorPattern(cuenta.getListAportes().get(i).getRadicado()));
//                tablaA.addCell(cuenta.getListAportes().get(i).getFechapago());
                //tablaA.addCell(cuenta.getListAportes().get(i).getSFechaUltPago());
            }

            tablaA.setSpacingBefore(20);
            document.add(tablaA);

            PdfPTable tableS;
            PdfPCell cellS;
            tableS = new PdfPTable(5);
            tableS.setWidthPercentage(100);
            cellS = new PdfPCell(new Phrase("MIS SERVICIOS", font2));
            cellS.setBackgroundColor(new BaseColor(84, 136, 90));
            cellS.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellS.setColspan(5);
            cellS.setPaddingTop(5);
            cellS.setPaddingLeft(8);
            cellS.setPaddingBottom(8);
            cellS.setBorder(Rectangle.NO_BORDER);
            tableS.addCell(cellS);
            tableS.setSpacingBefore(30);
            document.add(tableS);

            PdfPTable tablaS = new PdfPTable(columnWidths);

            tablaS.setWidthPercentage(100);

            String columnasS[] = {"NÚMERO DE RADICADO", "LÍNEA", "VALOR PAGO", "SALDO TOTAL", "FECHA DE PAGO"};

            for (int i = 0; i < columnasA.length; i++) {
                PdfPCell cellI;
                cellI = new PdfPCell(new Phrase(columnasS[i], font2));
                cellI.setBackgroundColor(new BaseColor(84, 136, 90));
                cellI.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellI.setColspan(1);
                cellI.setPaddingTop(5);
                cellI.setPaddingLeft(8);
                cellI.setPaddingBottom(8);
                tablaS.addCell(cellI);
            }

            for (int i = 0; i < cuenta.getListServicios().size(); i++) {
                tablaS.addCell(cuenta.getListServicios().get(i).getRadicado());
                tablaS.addCell(cuenta.getListServicios().get(i).getLinea());
//                tablaS.addCell(cuenta.getListServicios().get(i).getCuota());
                tablaS.addCell(cuenta.getListServicios().get(i).getCupo());
//                tablaS.addCell(cuenta.getListServicios().get(i).getSaldocapital());
                tablaS.addCell(cuenta.getListServicios().get(i).getLinea());
//                tablaS.addCell(cuenta.getListServicios().get(i).getFechapago());
                //tablaS.addCell(cuenta.getListServicios().get(i).getSFechaUltPago());
            }

            tablaS.setSpacingBefore(20);
            document.add(tablaS);

            Image footer = Image.getInstance("D:\\cooperagro\\assets\\Coop.png");
            footer.scaleAbsolute(595, 40);
            footer.setAbsolutePosition(0, 0);
            document.add(footer);

            document.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            return false;
        } catch (DocumentException ex) {
            ex.printStackTrace();
            return false;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        crearPDF dF = new crearPDF();
        Class class1 = dF.getClass();
        URL url = class1.getResource("");

        String rutaImagenes = "";

        String ruta[] = url.getPath().split("/");
        for (String path : ruta) {
            if (!path.equals("web")) {
                rutaImagenes += path + "/";
            } else {
                break;
            }
        }

        //System.err.println("url " + url.getPath());
        //System.out.println("urlIm " + rutaImagenes + "web");
        //crearPDF dF = new crearPDF();
        //dF.generarEstadoCuenta("", "1024589319", "BRAYAN ALEXANDER MORENO CUPITRA", "1");
        //dF.generarPazySalvo("N/N", "1024589319", "BRAYAN ALEXANDER MORENO CUPITRA", "2");
    }

    public void metodo() {
        URL url = getClass().getResource("");
    }

}
