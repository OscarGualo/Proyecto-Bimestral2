
/**
 * Simulador de Préstamos UI
 * 
 * Esta clase proporciona una interfaz de usuario para simular préstamos, permitiendo al usuario seleccionar el tipo de crédito,
 * ingresar datos relevantes y visualizar una tabla de amortización.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.table.DefaultTableModel;

public class SimuladorPrestamoUI {
    private static double valorVehiculoIngresado = 0, valorCasaIngresado = 0; // Almacena el valor del vehículo
    
    /**
     * Método principal que inicia la aplicación y crea la interfaz de usuario.
     */
    public static void main(String[] args) {
        // Crear la ventana principal
        JFrame frame = new JFrame("Simulador de Préstamos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 740);
        frame.setLayout(new BorderLayout());

        // Panel de selección de tipo de crédito
        JPanel panelSeleccion = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblPregunta = new JLabel("¿Qué crédito necesitas?");
        lblPregunta.setFont(new Font("Serif", Font.BOLD, 18));
        panelSeleccion.add(lblPregunta, gbc);

        gbc.gridy++;
        String[] tiposCredito = {"Automotriz", "Hipotecario", "Emergente", "Consumo"};
        JComboBox<String> comboCredito = new JComboBox<>(tiposCredito);
        comboCredito.setPreferredSize(new Dimension(200, 30));
        panelSeleccion.add(comboCredito, gbc);

        frame.add(panelSeleccion, BorderLayout.NORTH);

        // Panel de formulario
        JPanel panelFormulario = new JPanel(new GridBagLayout());

        gbc.gridy = 0;
        gbc.gridx = 0;
        panelFormulario.add(new JLabel("¿Cuánto dinero necesitas que te prestemos?"), gbc);

        gbc.gridy++;
        JTextField cantidadPrestamo = new JTextField("Ej. $1000");
        cantidadPrestamo.setPreferredSize(new Dimension(200, 30));
        cantidadPrestamo.setForeground(Color.GRAY);

        cantidadPrestamo.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (cantidadPrestamo.getText().equals("Ej. $1000")) {
                    cantidadPrestamo.setText("");
                    cantidadPrestamo.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (cantidadPrestamo.getText().isEmpty()) {
                    cantidadPrestamo.setText("Ej. $1000");
                    cantidadPrestamo.setForeground(Color.GRAY);
                }
            }
        });

        panelFormulario.add(cantidadPrestamo, gbc);

        gbc.gridy++;
        panelFormulario.add(new JLabel("¿En cuánto tiempo quieres pagarlo? (meses)"), gbc);

        gbc.gridy++;
        String[] plazos = {"3 meses", "4 meses", "5 meses", "6 meses", "7 meses", "8 meses", "9 meses", "10 meses", "11 meses", 
        "12 meses (1.0 años)", "18 meses (1.5 años)", "24 meses (2.0 años)", "30 meses (2.5 años)", "36 meses (3.0 años)", 
        "42 meses (3.5 años)", "48 meses (4.0 años)", "54 meses (4.5 años)", "60 meses (5.0 años)", "66 meses (5.5 años)", 
        "72 meses (6.0 años)", "78 meses (6.5 años)","84 meses (7.0 años)"};
        JComboBox<String> comboPlazo = new JComboBox<>(plazos);
        comboPlazo.setPreferredSize(new Dimension(200, 30));
        panelFormulario.add(comboPlazo, gbc);

        

        // Panel para el valor del vehículo (Solo para crédito automotriz)
        JPanel panelVehiculo = new JPanel(new GridBagLayout());
        gbc.gridy = 0;
        panelVehiculo.add(new JLabel("Valor del vehículo ($)"), gbc);

        gbc.gridy++;
        JTextField valorVehiculo = new JTextField("Ej. $15000");
        valorVehiculo.setPreferredSize(new Dimension(200, 30));
        valorVehiculo.setForeground(Color.GRAY);

        valorVehiculo.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (valorVehiculo.getText().equals("Ej. $15000")) {
                    valorVehiculo.setText("");
                    valorVehiculo.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (valorVehiculo.getText().isEmpty()) {
                    valorVehiculo.setText("Ej. $15000");
                    valorVehiculo.setForeground(Color.GRAY);
                }
            }
        });

        panelVehiculo.add(valorVehiculo, gbc);

        gbc.gridy++;
        JButton btnConfirmarValor = new JButton("Confirmar Valor");
        JLabel lblValorGuardado = new JLabel(""); // Muestra el valor almacenado

        btnConfirmarValor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    valorVehiculoIngresado = Double.parseDouble(valorVehiculo.getText().replace("$", "").replace(",", "").trim());
                    lblValorGuardado.setText("Valor almacenado: $" + valorVehiculoIngresado);
                } catch (NumberFormatException ex) {
                    lblValorGuardado.setText("⚠ Ingrese un valor numérico válido");
                }
            }
        });

        panelVehiculo.add(btnConfirmarValor, gbc);

        gbc.gridy++;
        panelVehiculo.add(lblValorGuardado, gbc);

        panelVehiculo.setVisible(false); // Ocultar inicialmente

        // Agregar el panel del vehículo al formulario
        gbc.gridy++;
        panelFormulario.add(panelVehiculo, gbc);

        // Panel para el valor del vehículo (Solo para crédito automotriz)
        JPanel panelHipoteca = new JPanel(new GridBagLayout());
        gbc.gridy = 0;
        panelHipoteca.add(new JLabel("Valor de la casa ($)"), gbc);

        gbc.gridy++;
        JTextField valorCasa = new JTextField("Ej. $15000");
        valorCasa.setPreferredSize(new Dimension(200, 30));
        valorCasa.setForeground(Color.GRAY);

        valorCasa.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (valorCasa.getText().equals("Ej. $15000")) {
                    valorCasa.setText("");
                    valorCasa.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (valorCasa.getText().isEmpty()) {
                    valorCasa.setText("Ej. $15000");
                    valorCasa.setForeground(Color.GRAY);
                }
            }
        });

        panelHipoteca.add(valorCasa, gbc);

        gbc.gridy++;
        JButton btnConfirmarValorc = new JButton("Confirmar Valor");
        JLabel lblValorGuardadoc = new JLabel(""); // Muestra el valor almacenado

        btnConfirmarValorc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    valorCasaIngresado = Double.parseDouble(valorCasa.getText().replace("$", "").replace(",", "").trim());
                    lblValorGuardadoc.setText("Valor almacenado: $" + valorCasaIngresado);
                } catch (NumberFormatException ex) {
                    lblValorGuardadoc.setText("⚠ Ingrese un valor numérico válido");
                }
            }
        });

        panelHipoteca.add(btnConfirmarValorc, gbc);

        gbc.gridy++;
        panelHipoteca.add(lblValorGuardadoc, gbc);

        panelHipoteca.setVisible(false); // Ocultar inicialmente

        // Agregar el panel del vehículo al formulario
        gbc.gridy++;
        panelFormulario.add(panelHipoteca, gbc);
        

        // Tasa de interés anual
        gbc.gridy++;
        panelFormulario.add(new JLabel("Tasa de interés anual (%)"), gbc);

        gbc.gridy++;
        JTextField tasaInteres = new JTextField();
        tasaInteres.setPreferredSize(new Dimension(200, 30));
        panelFormulario.add(tasaInteres, gbc);

        gbc.gridy++;
        panelFormulario.add(new JLabel("Prima anual del seguro (%):"), gbc);
        gbc.gridy++;
        JTextField txtPrimaSeguro = new JTextField();
        txtPrimaSeguro.setPreferredSize(new Dimension(200, 30));
        panelFormulario.add(txtPrimaSeguro, gbc);

        // Métodos de pago
        gbc.gridy++;
        panelFormulario.add(new JLabel("¿Cómo quieres pagar tus intereses?"), gbc);

        gbc.gridy++;
        JPanel panelMetodos = new JPanel(new GridLayout(1, 2, 10, 10));

        JButton metodoFrances = new JButton("<html><b>Método Francés</b><br>Cuotas fijas</html>");
        JButton metodoAleman = new JButton("<html><b>Método Alemán</b><br>Cuotas decrecientes</html>");

        metodoFrances.addActionListener(e -> {
            metodoFrances.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
            metodoAleman.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
        });

        metodoAleman.addActionListener(e -> {
            metodoAleman.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
            metodoFrances.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
        });

        panelMetodos.add(metodoFrances);
        panelMetodos.add(metodoAleman);
        panelFormulario.add(panelMetodos, gbc);

        // Botones de acción
        gbc.gridy++;
        JPanel panelBotones = new JPanel();
        JButton btnSimular = new JButton("Simular Préstamo");
        JButton btnMostrarTabla = new JButton("Mostrar Tabla de Amortización");
        JButton btnSalir = new JButton("Salir");

        btnSalir.addActionListener(e -> System.exit(0));

        panelBotones.add(btnSimular);
        panelBotones.add(btnMostrarTabla);
        panelBotones.add(btnSalir);
        panelFormulario.add(panelBotones, gbc);

        // Ocultar formulario inicialmente
        panelFormulario.setVisible(false);
        frame.add(panelFormulario, BorderLayout.CENTER);

        // Acción para desplegar formulario y mostrar el valor del vehículo si es "Automotriz"
        comboCredito.addActionListener(e -> { 
            panelFormulario.setVisible(true);
        
            // Ocultar ambos paneles antes de mostrar el correcto
            panelVehiculo.setVisible(false);
            panelHipoteca.setVisible(false);
        
            if (comboCredito.getSelectedItem().equals("Automotriz")) {
                panelVehiculo.setVisible(true);
            } 
            if (comboCredito.getSelectedItem().equals("Hipotecario")) {
                panelHipoteca.setVisible(true);
            }
        
            frame.revalidate();
            frame.repaint();
        });
        

        btnMostrarTabla.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TablaAmortizacion tabla = new TablaAmortizacion();
                tabla.mostrar();
            }
        });

        
        // Mostrar la ventana
        frame.setVisible(true);
    }
}

 /**
 * Clase que representa una tabla de amortización para mostrar los pagos de un préstamo.
 */

class TablaAmortizacion {
    private JFrame frame;
    private JTable table;
    private DefaultTableModel model;
     /**
     * Constructor que inicializa la interfaz de la tabla de amortización.
     */
    public TablaAmortizacion() {
        frame = new JFrame("Tabla de Amortización");
        frame.setSize(700, 450);
        frame.setLayout(new BorderLayout());
        
        model = new DefaultTableModel();
        model.addColumn("No. de cuota");
        model.addColumn("Capital");
        model.addColumn("Interés");
        model.addColumn("Saldo Capital");
        model.addColumn("Seguro de Desgravamen");
        model.addColumn("Valor de Cuota");

        table = new JTable(model);
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        frame.add(scrollPane, BorderLayout.CENTER);
    }

    public void mostrar() {
        frame.setVisible(true);
    }
}