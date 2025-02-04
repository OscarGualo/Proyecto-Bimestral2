import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.List;
import javax.swing.JOptionPane;
import java.util.Date;
import java.util.HashMap;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileReader;
import java.util.ArrayList;
import com.itextpdf.text.pdf.PdfPCell;

/**
 * Clase que gestiona las transacciones de caja
 * 
 * @author Cristofer Díaz
 * @version 1.0.0
 */
public class Cajero extends Empleado {

    // Atributo
    private double dineroCaja;

    /**
     * Constructor para inicializar un Cajero.
     * 
     * @param codigoCajero Código del cajero.
     * @param nombreCajero Nombre del cajero.
     * @param horario      Horario del cajero.
     * @param dineroCaja   Monto inicial de dinero en la caja.
     */
    public Cajero(String codigoCajero, String nombreCajero, String horario, double dineroCaja) {
        super(nombreCajero, codigoCajero, horario);
        this.dineroCaja = dineroCaja;
    }

    // Getters y Setters

    /**
     * Obtiene el monto de dinero en la caja.
     * 
     * @return El monto de dinero en la caja.
     */
    public double getDineroCaja() {
        return dineroCaja;
    }

    /**
     * Establece el monto de dinero en la caja.
     * 
     * @param dineroCaja El monto a establecer en la caja.
     */
    public void setDineroCaja(Double dineroCaja) {
        this.dineroCaja = dineroCaja;
    }

    /**
     * Registra una transacción de ingreso o egreso en la caja.
     * 
     * @param isIngreso       Indica si la transacción es un ingreso (true) o un egreso (false).
     * @param monto           Monto de la transacción.
     * @param institucion     Institución asociada a la transacción.
     * @param tipoTransaccion Tipo de transacción.
     */
    public void registrarTransaccion(boolean isIngreso, double monto, Institucion institucion, String tipoTransaccion) {
        if (isIngreso) {
            dineroCaja += monto; // Sumamos el monto de ingresos
        } else {
            dineroCaja -= monto; // Restamos el monto de egresos
        }
        Transaccion transaccion = new Transaccion(super.getCodigo(), super.getNombre(), monto, institucion.getInsititucion(),
                tipoTransaccion, isIngreso);
        transaccion.generarCSVTransaccion();
    }

    /**
     * Verifica y entrega el excedente de dinero en la caja a la Bóveda.
     * 
     * @param boveda La Bóveda a la que se entregará el excedente.
     */
    public void entregarExcedenteABoveda(Boveda boveda) {
        double excedente = dineroCaja - 1000.00; // Umbral de 1000 USD
        Institucion inst = new Institucion("");
        if (excedente > 0) {
            // Llamamos al método de la Bóveda para agregar el excedente
            boveda.agregarDinero(excedente);
            dineroCaja -= excedente; // Reducir el excedente de la caja
            JOptionPane.showMessageDialog(null, "El excedente de " + excedente +
                    "USD ha sido entregado a la Bóveda.\nDinero en caja: " + getDineroCaja(), null, 1);
                    registrarTransaccion(false, excedente, inst, "Entrega excedente a boveda");
                    

        } else {
            JOptionPane.showMessageDialog(null, "No hay excedente en la caja. Dinero de la caja: " +
                    getDineroCaja(), null, 1);
        }
    }

    /**
     * Verifica y entrega el excedente de dinero en la caja a otro cajero.
     * 
     * @param otroCajero El cajero al que se entregará el excedente.
     */
    public void entregarExcedenteACajero(Cajero otroCajero) {
        double excedente = dineroCaja - 1000.00; // Umbral de 1000 USD

        if (excedente > 0) {
            // Verificar si el excedente más el dinero actual del otro cajero no supera los
            // 1000
            double totalOtroCajero = otroCajero.getDineroCaja() + excedente;

            if (totalOtroCajero <= 1000.00) {
                // Reducir el excedente de la caja actual
                dineroCaja -= excedente;
                // Aumentar el dinero del otro cajero
                otroCajero.setDineroCaja(otroCajero.getDineroCaja() + excedente);

                JOptionPane.showMessageDialog(null, "El excedente de " + excedente +
                        " USD ha sido entregado al otro cajero.", null, 1);
            } else {
                JOptionPane.showMessageDialog(null,
                        "No se puede enviar el exedente. Caja + " + otroCajero.getDineroCaja() +
                                "Llena",
                        null, 1);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay excedente en la caja. Dinero de la caja: " +
                    getDineroCaja(), null, 1);
        }
    }

}

/**
 * Genera un archivo CSV con los detalles de la transacción.
 * 
 * @author Cristofer Díaz
 * @version 1.0.0
 */

class Transaccion {

    // Atributos
    private String codigoCajero;
    private String nombreCajero;
    private double monto;
    private String institucion;
    private String tipoTransaccion;
    private boolean isIngreso;

    // Constructor
    /**
     * Constructor para inicializar una transacción.
     * 
     * @param codigoCajero    Código del cajero que realizó la transacción.
     * @param nombreCajero    Nombre del cajero que realizó la transacción.
     * @param monto           Monto de la transacción.
     * @param institucion     Institución asociada a la transacción.
     * @param tipoTransaccion Tipo de transacción
     * @param isIngreso       Indica si la transacción es un ingreso (true) o un egreso (false).
     */
    public Transaccion(String codigoCajero, String nombreCajero, double monto, String institucion,
            String tipoTransaccion, boolean isIngreso) {
        this.codigoCajero = codigoCajero;
        this.nombreCajero = nombreCajero;
        this.monto = monto;
        this.institucion = institucion;
        this.tipoTransaccion = tipoTransaccion;
        this.isIngreso = isIngreso;
    }

    // Getters y Setters
    /**
     * Obtiene el código del cajero que realizó la transacción.
     */
    public String getCodigoCajero() {
        return codigoCajero;
    }

    /**
     * Obtiene el nombre del cajero que realizó la transacción.
     * 
     * @return El nombre del cajero.
     */
    public String getNombreCajero() {
        return nombreCajero;
    }

    /**
     * Obtiene el monto de la transacción.
     * 
     * @return El monto de la transacción.
     */
    public double getMonto() {
        return monto;
    }

    /**
     * Obtiene la institución asociada a la transacción.
     * 
     * @return El nombre de la institución.
     */
    public String getInstitucion() {
        return institucion;
    }

    /**
     * Genera un archivo CSV con los detalles de la transacción.
     * 
     * @param Ninguno.
     * @return Ninguno.
     */
    public void generarCSVTransaccion() {
        // Definir la ruta del archivo CSV
        String rutaArchivo = "archivosPantallaTransaccional\\transacciones.csv";
        String tipoSalida;
        if (isIngreso) {
            tipoSalida = "ingreso";
        } else {
            tipoSalida = "egreso";
        }
        try (FileWriter writer = new FileWriter(rutaArchivo, true)) {
            // Escribir los datos de la transacción en el archivo CSV
            writer.append(codigoCajero + "," + nombreCajero + ","
                    + institucion + "," + tipoTransaccion + "," + monto + "," + tipoSalida + "\n");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al registar la transacción: " +
                    e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

/**
 * Representa una bóveda que almacena dinero, permitiendo agregar y obtener fondos
 * 
 * @author Cristofer Díaz
 * @version 1.0.0
 */
class Boveda {

    // Atributo
    private double dinero;

    // Constructor
    /**
     * Constructor para inicializar la Bóveda con una cantidad de dinero.
     * 
     * @param dineroInicial El monto inicial de dinero en la Bóveda.
     */
    public Boveda(double dineroInicial) {
        this.dinero = dineroInicial;
    }

    // Getters y setters
    /**
     * Obtiene el monto de dinero en la Bóveda.
     * 
     * @return El monto de dinero en la Bóveda.
     */
    public double getDinero() {
        return dinero;
    }

    /**
     * Establece el monto de dinero en la Bóveda.
     * 
     * @param dinero El monto a establecer en la Bóveda.
     */
    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    /**
     * Agrega una cantidad de dinero a la Bóveda.
     * 
     * @param cantidad La cantidad de dinero a agregar a la Bóveda.
     */
    public void agregarDinero(double cantidad) {
        this.dinero += cantidad;
    }

    /**
     * Obtiene el monto de dinero disponible en la Bóveda.
     * 
     * @return El monto de dinero en la Bóveda.
     */
    public double obtenerDinero() {
        return this.dinero;
    }

    /**
     * Muestra el saldo actual de la Bóveda en un mensaje.
     * 
     * @return Ninguno.
     */
    public void mostrarSaldo() {
        JOptionPane.showMessageDialog(null, "Saldo en la Bóveda: " + this.dinero + " USD.", null, 1);
    }
}

class Supervisor extends Empleado {

    // Atributos
    private Date fecha;
    private Cajero cajero;
    

    // Constructor
    /**
     * Constructor para inicializar un Supervisor 
     * 
     * @param nombre  Nombre del supervisor.
     * @param codigo  Código del supervisor.
     * @param horario Horario de trabajo del supervisor.
     * @param cajero  El cajero asignado al supervisor.
     */
    public Supervisor(String nombre, String codigo, String horario, Cajero cajero) {
        super(nombre, codigo, horario);
        this.fecha = new Date();
        this.cajero = cajero;
    }

    /**
     * Genera un reporte de cierre de caja para el cajero, procesando las
     * transacciones de un archivo CSV.
     * 
     * @param archivoCSV El archivo CSV que contiene las transacciones a procesar.
     */
    public void generarReporteCierreCaja(String archivoCSV) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivoCSV));
            String linea;

            Map<String, Double> subtotalEfectivo = new HashMap<>();
            Map<String, Integer> subtotalDocumentos = new HashMap<>();
            Map<String, List<String>> transaccionesPorInstitucion = new HashMap<>();
            Map<String, Double> subtotalInstituciones = new HashMap<>();

            double totalEfectivo = 0;
            int totalDocumentos = 0;

            boolean hayMovimientos = false;

            String codigoCajero = cajero.getCodigo(); // Obtener el código del cajero

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length < 6)
                    continue;

                // Verificar si el código del cajero coincide
                if (!datos[0].trim().equals(codigoCajero)) {
                    continue; // Si no coincide, ignoramos esta transacción
                }

                hayMovimientos = true;

                String institucion = datos[2].trim();
                String tipoSalida = datos[5].trim();
                String tipoTransaccion = datos[3].trim();
                double monto = Double.parseDouble(datos[4]);

                if (institucion.isEmpty()) {
                    institucion = "Superpagos";
                }

                subtotalEfectivo.putIfAbsent(institucion, 0.0);
                subtotalDocumentos.putIfAbsent(institucion, 0);
                transaccionesPorInstitucion.putIfAbsent(institucion, new ArrayList<>());
                subtotalInstituciones.putIfAbsent(institucion, 0.0); // Inicializar el subtotal de la institución

                // Ajustar el signo del monto según el tipo de transacción (Ingreso/Egreso)
                if (tipoSalida.equalsIgnoreCase("Ingreso")) {
                    subtotalEfectivo.put(institucion, subtotalEfectivo.get(institucion) + monto);
                    subtotalInstituciones.put(institucion, subtotalInstituciones.get(institucion) + monto);
                    if (tipoTransaccion.toLowerCase().contains("cheque")) {
                        subtotalDocumentos.put(institucion, subtotalDocumentos.get(institucion) + 1);
                        totalDocumentos++;
                    }
                    totalEfectivo += monto;
                } else if (tipoSalida.equalsIgnoreCase("Egreso")) {
                    subtotalEfectivo.put(institucion, subtotalEfectivo.get(institucion) - monto);
                    subtotalInstituciones.put(institucion, subtotalInstituciones.get(institucion) - monto);
                    if (tipoTransaccion.toLowerCase().contains("cheque")) {
                        subtotalDocumentos.put(institucion, subtotalDocumentos.get(institucion) + 1);
                        totalDocumentos++;
                    }
                    totalEfectivo -= monto;
                    monto = -monto;
                }
                transaccionesPorInstitucion.get(institucion).add(tipoTransaccion + ": " +
                        String.format("%.2f", monto));
            }
            br.close();

            if (!hayMovimientos) {
                JOptionPane.showMessageDialog(null, "No se encontraron movimientos para el cajero especificado",
                        null, 1);
                return;
            }

            generarPDF(subtotalEfectivo, subtotalDocumentos, totalEfectivo, totalDocumentos,
                    transaccionesPorInstitucion, subtotalInstituciones);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Genera un reporte en formato PDF con los detalles del cierre de caja
     * 
     * @param subtotalEfectivo            Map que contiene los subtotales de efectivo por institución.
     * @param subtotalDocumentos          Map que contiene los subtotales de documentos por institución.
     * @param totalEfectivo               Total de efectivo procesado en el cierre de caja.
     * @param totalDocumentos             Total de documentos procesados en el cierre de caja.
     * @param transaccionesPorInstitucion Map que contiene las transacciones por institución.
     * @param subtotalInstituciones       Map que contiene los subtotales de efectivo por institución.
     */
    private void generarPDF(Map<String, Double> subtotalEfectivo, Map<String, Integer> subtotalDocumentos,
            double totalEfectivo, int totalDocumentos, Map<String, List<String>> transaccionesPorInstitucion,
            Map<String, Double> subtotalInstituciones) {
        try {
            Document documento = new Document(PageSize.A4.rotate());
            PdfWriter.getInstance(documento, new FileOutputStream("Reportes/ReporteCierreCaja.pdf"));
            documento.open();

            SimpleDateFormat sdfFecha = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm:ss");
            String fechaActual = sdfFecha.format(new Date());
            String horaActual = sdfHora.format(new Date());

            documento.add(new Paragraph("Reporte de Cierre de Caja: \n",
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14)));
            documento.add(new Paragraph("Fecha: " + fechaActual + " - Hora: " + horaActual));
            documento.add(new Paragraph("Cajero: " + cajero.getNombre()));
            documento.add(new Paragraph("Código Cajero: " + cajero.getCodigo()));
            documento.add(new Paragraph("Horario del Cajero: " + cajero.getHorario()));
            documento.add(new Paragraph("\nDetalles por Institución:\n"));

            // Crear una tabla por cada institución
            for (String institucion : transaccionesPorInstitucion.keySet()) {
                documento.add(new Paragraph("\nInstitución: " + institucion + "\n\n"));
                PdfPTable tabla = new PdfPTable(2);
                tabla.setWidthPercentage(100);
                PdfPCell celdaTipoTransaccion = new PdfPCell(new Phrase("Tipo de Transacción",
                        FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12))); // Fuente en negrita
                PdfPCell celdaMonto = new PdfPCell(new Phrase("Monto",
                        FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12)));

                // Establecer la altura de las celdas del encabezado
                celdaTipoTransaccion.setFixedHeight(25f);
                celdaMonto.setFixedHeight(25f);

                // Añadir las celdas del encabezado
                tabla.addCell(celdaTipoTransaccion);
                tabla.addCell(celdaMonto);

                // Añadir las transacciones para la institución actual
                for (String transaccion : transaccionesPorInstitucion.get(institucion)) {
                    String[] partesTransaccion = transaccion.split(": ");
                    String tipoTransaccion = partesTransaccion[0];
                    String monto = partesTransaccion[1];

                    // Agregar las celdas en el orden correcto
                    PdfPCell tipoTransaccionCell = new PdfPCell(new Phrase(tipoTransaccion));
                    PdfPCell montoCell = new PdfPCell(new Phrase(monto));

                    // Ajustar el alto de las celdas
                    tipoTransaccionCell.setFixedHeight(25f);
                    montoCell.setFixedHeight(25f);

                    // Añadir las celdas a la tabla
                    tabla.addCell(tipoTransaccionCell);
                    tabla.addCell(montoCell);
                }

                documento.add(tabla);

                // Añadir los subtotales
                documento.add(new Paragraph("\nSubtotal de Efectivo para " + institucion + ": "
                        + String.format("%.2f", subtotalEfectivo.get(institucion))));
                documento.add(new Paragraph(
                        "Subtotal Documentos para " + institucion + ": " + subtotalDocumentos.get(institucion)));
            }

            // Información total del reporte
            documento.add(new Paragraph("\nTotal Documentos: " + totalDocumentos,
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12)));
            documento.add(new Paragraph("Total Efectivo: " + String.format("%.2f", totalEfectivo),
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12)));

            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte de Cierre de caja generado exitosamente", null, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Genera un reporte en formato PDF con la información de la nómina del cajero.
     *
     * @param cajero Objeto que representa al cajero para obtener su información y las denominaciones asociadas.
     */

    public void generarReporteNomina(Cajero cajero) {

        try {
            // Leer el archivo CSV
            String archivoCSV = "archivosPantallaTransaccional/denominaciones.csv";
            File archivo = new File(archivoCSV);

            if (!archivo.exists()) {
                JOptionPane.showMessageDialog(null, "Por favor registre la nómina", null, 1);
                return;
            }

            BufferedReader br = new BufferedReader(new FileReader(archivoCSV));
            String linea;

            // Mapa para almacenar las denominaciones filtradas por el código del cajero
            Map<String, List<String>> denominacionesPorCajero = new HashMap<>();
            double totalDinero = 0; // Variable para almacenar el total de dinero en caja

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                if (datos.length != 4) {
                    JOptionPane.showMessageDialog(null, "Línea inválida o incompleta en el CSV: ", null, 1);
                    continue;
                }

                String codigoCajero = datos[0].trim();
                String denominacion = datos[1].trim();
                String valor = datos[2].trim();
                String cantidad = datos[3].trim();

                // Filtrar por el código del cajero actual
                if (codigoCajero.equalsIgnoreCase(cajero.getCodigo().trim())) {
                    try {
                        double valorDenominacion = Double.parseDouble(valor); // Convertir el valor de la denominación
                        int cantidadDenominacion = Integer.parseInt(cantidad); // Convertir la cantidad

                        // Sumar el total para esta denominación
                        totalDinero += valorDenominacion * cantidadDenominacion;

                        // Almacenar la denominación y su valor/cantidad en el mapa
                        denominacionesPorCajero.putIfAbsent(denominacion, new ArrayList<>());
                        denominacionesPorCajero.get(denominacion).add(valor + "," + cantidad);
                    } catch (NumberFormatException e) {
                        System.out.println(
                                "Error al convertir los valores de la denominación o la cantidad: "
                                        + e.getMessage());
                    }
                }
            }
            br.close();

            // Verificar que se agregaron denominaciones al mapa
            if (denominacionesPorCajero.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se encontraron denominaciones para el cajero: " + cajero.getCodigo(), null, 1);
                   
               // System.out.println("No se encontraron denominaciones para el cajero: " + cajero.getCodigo());
            }

            // Generación del PDF
            Document documento = new Document();
            PdfWriter.getInstance(documento, new FileOutputStream("Reportes/ReporteNomina.pdf"));
            documento.open();

            // Fecha y hora actual
            SimpleDateFormat sdfFecha = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm:ss");
            String fechaActual = sdfFecha.format(fecha);
            String horaActual = sdfHora.format(new Date());

            // Encabezado del reporte
            documento.add(new Paragraph("Reporte de Nómina: \n", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14)));
            documento.add(new Paragraph("Fecha: " + fechaActual + " - Hora: " + horaActual));
            documento.add(new Paragraph("Código Cajero: " + cajero.getCodigo()));
            documento.add(new Paragraph("Horario del Cajero: " + cajero.getHorario()));
            documento.add(new Paragraph("Nombre del Cajero: " + cajero.getNombre()));
            documento.add(new Paragraph("\nDetalle de Dinero Físico en Caja:\n\n"));

            // Crear tabla con las denominaciones
            PdfPTable tablaDenominaciones = new PdfPTable(3);
            tablaDenominaciones.setWidthPercentage(100);
            tablaDenominaciones.setWidths(new float[] { 40f, 30f, 30f });

            // Encabezado de la tabla
            tablaDenominaciones.addCell("Denominación");
            tablaDenominaciones.addCell("Valor");
            tablaDenominaciones.addCell("Cantidad");

            // Llenar la tabla con las denominaciones filtradas
            for (String denominacion : denominacionesPorCajero.keySet()) {
                // Para cada denominación, agregar una fila de datos
                for (String valorCantidad : denominacionesPorCajero.get(denominacion)) {
                    String[] partes = valorCantidad.split(",");
                    if (partes.length == 2) {
                        String valor = partes[0];
                        String cantidad = partes[1];

                        // Añadir las celdas con el orden correcto
                        tablaDenominaciones.addCell(denominacion); // Denominación
                        tablaDenominaciones.addCell(valor); // Valor
                        tablaDenominaciones.addCell(cantidad); // Cantidad
                    }
                }
            }

            // Añadir la tabla al documento
            documento.add(tablaDenominaciones);

            // Información adicional
            documento.add(new Paragraph("\nTotal Verificado: " + String.format("%.2f", totalDinero)));
            documento.add(new Paragraph("Total Disponible: " + String.format("%.2f", cajero.getDineroCaja())));
            documento.add(new Paragraph("Faltante: " + String.format("%.2f", cajero.getDineroCaja() - totalDinero)));

            // Cerrar documento
            documento.close();

            JOptionPane.showMessageDialog(null, "Reporte de nómina generado exitosamente", null, 1);
                
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/**
 * Representa a un supervisor que gestiona las transacciones de un cajero
 * 
 * @author Cristofer Díaz
 * @version 1.0.0
 */
class Empleado {
    // Atributos
    private String nombre;
    private String codigo;
    private String horario;

    // Constructor
    /**
     * Constructor para inicializar un objeto de tipo Empleado con su nombre, código
     * y horario.
     * 
     * @param nombre  El nombre del empleado.
     * @param codigo  El código de identificación del empleado.
     * @param horario El horario de trabajo del empleado.
     */
    public Empleado(String nombre, String codigo, String horario) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.horario = horario;
    }

    // Getters y setters
    /**
     * Obtiene el nombre del empleado.
     * 
     * @return El nombre del empleado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el código de identificación del empleado.
     * 
     * @return El código del empleado.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Obtiene el horario de trabajo del empleado.
     * 
     * @return El horario de trabajo del empleado.
     */
    public String getHorario() {
        return horario;
    }
}
