import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;

/**
 * Clase que gestiona las acciones de transacción en generando una interfaz
 * gráfica para cada accion de caja
 * Permite ejecutar diversas operaciones bancarias como depósitos, retiros,
 * pagos y actualizaciones.
 * 
 * @author Grupo 3
 * @version 1.0.5
 */
public class GUIAccionesDeTransaccion {

	// atributos
	private String opcionSeleccionada;
	private JPanel rightPanel;
	private String intitucionSeleccionada;
	private Cajero cajero001, cajero002;
	private Boveda boveda;
	private double totalVerificado;
	private double faltante;

	/**
	 * Constructor de la clase GUIAccionesDeTransaccion.
	 * Inicializa los valores y la referencia a los componentes de la interfaz
	 * gráfica.
	 *
	 * @param opcion      Opción seleccionada por el usuario en la interfaz.
	 * @param rightPanel  Panel donde se mostrarán las opciones de transacción.
	 * @param institucion Nombre de la institución bancaria asociada.
	 * @param cajero1     Referencia al primer cajero del sistema.
	 * @param cajero2     Referencia al segundo cajero del sistema.
	 * @param boveda      Referencia a la bóveda del sistema.
	 */

	public GUIAccionesDeTransaccion(String opcion, JPanel rightPanel, String institucion, Cajero cajero1,
			Cajero cajero2, Boveda boveda) {
		this.opcionSeleccionada = opcion;
		this.rightPanel = rightPanel;
		this.intitucionSeleccionada = institucion;
		this.cajero001 = cajero1;
		this.cajero002 = cajero2;
		this.boveda = boveda;
	}

	// Getter and Setters
	public String getIntitucionSeleccionada() {
		return intitucionSeleccionada;
	}

	public void setIntitucionSeleccionada(String intitucionSeleccionada) {
		this.intitucionSeleccionada = intitucionSeleccionada;
	}

	public void setRightPanel(JPanel rightPanel) {
		this.rightPanel = rightPanel;
	}

	public JPanel getRightPanel() {
		return rightPanel;
	}

	public String getOpcionSeleccionada() {
		return opcionSeleccionada;
	}

	public void setOpcionSeleccionada(String opcionSeleccionada) {
		this.opcionSeleccionada = opcionSeleccionada;
	}

	public double getTotalVerificado() {
		return totalVerificado;
	}

	public double getFaltante() {
		return faltante;
	}

	public void setTotalVerificado(double totalVerificado) {
		this.totalVerificado = totalVerificado;
	}

	public void setFaltante(double faltante) {
		this.faltante = faltante;
	}

	/**
	 * Ejecuta la acción y la GUI correspondiente a la opción seleccionada por el
	 * usuario.
	 */
	public void accionDeLaOpcion() {

		String opcion = getOpcionSeleccionada();

		switch (opcion) {

			case "Depósito en Efectivo":
				depositoEnEfectivo();
				break;

			case "Depósito en Cheques":
				depositoEnCheque();
				break;

			case "Depósito Mixto":
				depositoMixto();
				break;

			case "Pago de Cheques":
				pagoDeCheque();
				break;

			case "Actualización de Libreta de Ahorro":
				actualizacionLiAho();
				break;

			case "Pago de Giros":
				pagoDeGiros();
				break;

			case "Retiro con Libreta":
				retiroConLibreta();
				break;

			case "Pago de Revisión Vehicular":
				revisionVehicular();
				break;

			case "Pago de Planilla de EEQ":
				planillasEEQ();
				break;

			case "Pago de Impuesto Predial":
				impuestoPredial();
				break;

			case "Cierre de Caja":
				cierreDeCaja();
				break;

			case "Nómina (Reporte)":
				nominaReporte();
				break;

			case "Pago de Matriculación Vehicular":
				matriculacionVehicular();
				break;

			case "Retiro sin Libreta":
				retiroSinLibreta();
				break;

			case "Ingreso de Caja":
				ingresoDeCaja();
				break;

			case "Egreso de Caja":
				egresoDeCaja();
				break;

			case "Nómina":
				nominaDeCaja();
				break;
			default:
				break;
		}
	}

	/**
	 * Muestra la interfaz y gestiona la operación de nomina de caja.
	 */
	public void nominaDeCaja() {

		JLabel lblTitle = new JLabel("Nómina");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblTitle.setBounds(300, 11, 451, 47);
		rightPanel.add(lblTitle);

		final Set<Double> denominacionesUSD = new HashSet<>(Arrays.asList(
				0.01, 0.05, 0.10, 0.25, 0.50, 1.00, 5.00, 10.00, 20.00, 50.00, 100.00));

		JLabel lblCodigo = new JLabel("Código de Cajero:");
		lblCodigo.setBounds(65, 91, 150, 25);
		rightPanel.add(lblCodigo);

		JTextField txtCodigoCajero = new JTextField();
		txtCodigoCajero.setBounds(205, 91, 150, 25);
		rightPanel.add(txtCodigoCajero);

		JLabel lblNombre = new JLabel("Nombre de Cajero:");
		lblNombre.setBounds(397, 91, 150, 25);
		rightPanel.add(lblNombre);

		JTextField txtNombreCajero = new JTextField();
		txtNombreCajero.setBounds(513, 91, 150, 25);
		rightPanel.add(txtNombreCajero);

		JLabel lblDenominacion = new JLabel("Tipo:");
		lblDenominacion.setBounds(65, 135, 150, 25);
		rightPanel.add(lblDenominacion);

		@SuppressWarnings("rawtypes")
		JComboBox cmbDenominacion = new JComboBox<>(new String[] { "Billete", "Moneda" });
		cmbDenominacion.setBounds(205, 135, 150, 25);
		rightPanel.add(cmbDenominacion);

		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(65, 197, 150, 25);
		rightPanel.add(lblValor);

		JTextField txtValor = new JTextField();
		txtValor.setBounds(205, 197, 150, 25);
		rightPanel.add(txtValor);

		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(65, 255, 150, 25);
		rightPanel.add(lblCantidad);

		JTextField txtCantidad = new JTextField();
		txtCantidad.setBounds(205, 255, 150, 25);
		rightPanel.add(txtCantidad);

		JLabel lblTotalUSD = new JLabel("Total (USD):");
		lblTotalUSD.setBounds(65, 291, 150, 25);
		rightPanel.add(lblTotalUSD);

		JTextField txtTotalUSD = new JTextField();
		txtTotalUSD.setEditable(false);
		txtTotalUSD.setBounds(205, 291, 150, 25);
		rightPanel.add(txtTotalUSD);
		JLabel lblHorario = new JLabel("Horario:");
		lblHorario.setBounds(397, 135, 150, 25);
		rightPanel.add(lblHorario);

		@SuppressWarnings("rawtypes")
		JComboBox cmbHorario = new JComboBox<>(new String[] { "Normal", "Diferido" });
		cmbHorario.setBounds(513, 136, 150, 22);
		cmbHorario.setEnabled(false);
		rightPanel.add(cmbHorario);

		JLabel lblTotalVerificado = new JLabel("Total verificado:");
		lblTotalVerificado.setBounds(397, 197, 150, 25);
		rightPanel.add(lblTotalVerificado);

		JTextField totalVeridicado = new JTextField("");
		totalVeridicado.setEditable(false);
		totalVeridicado.setBounds(513, 197, 150, 25);
		rightPanel.add(totalVeridicado);

		JLabel lblCantidad_2 = new JLabel("Total Disponible:");
		lblCantidad_2.setBounds(397, 245, 150, 25);
		rightPanel.add(lblCantidad_2);

		JTextField totalDisponible = new JTextField();
		totalDisponible.setText("100");
		totalDisponible.setEditable(false);
		totalDisponible.setBounds(513, 245, 150, 25);
		rightPanel.add(totalDisponible);

		JLabel lblCantidad_1 = new JLabel("Diferencia:");
		lblCantidad_1.setBounds(397, 291, 150, 25);
		rightPanel.add(lblCantidad_1);

		JTextField diferencia = new JTextField();
		diferencia.setEditable(false);
		diferencia.setBounds(513, 291, 150, 25);
		rightPanel.add(diferencia);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(420, 352, 198, 30);
		rightPanel.add(btnGuardar);
		btnGuardar.setEnabled(false);

		// Botón para registrar el valor y actualizar el total
		JButton btnRegistrar = new JButton("Registrar billete/monedas");
		btnRegistrar.setBounds(120, 348, 198, 30);
		rightPanel.add(btnRegistrar);

		txtCodigoCajero.getDocument().addDocumentListener(new DocumentListener() {
			private void updateFields() {
				String text = txtCodigoCajero.getText();
				if (cajero001.getCodigo().equalsIgnoreCase(text)) {
					totalDisponible.setText(cajero001.getDineroCaja() + "");
					txtNombreCajero.setText(cajero001.getNombre());
					cmbHorario.setSelectedItem(cajero001.getHorario());
				} else if (cajero002.getCodigo().equalsIgnoreCase(text)) {
					totalDisponible.setText(cajero002.getDineroCaja() + "");
					txtNombreCajero.setText(cajero002.getNombre());
					cmbHorario.setSelectedItem(cajero002.getHorario());
				} else {
					totalDisponible.setText("Código incorrecto");
					txtNombreCajero.setText("Código incorrecto");
				}
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				updateFields();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				updateFields();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				updateFields();
			}
		});

		btnRegistrar.addActionListener(new ActionListener() {
			double totalUSD = 0.0;

			public void actionPerformed(ActionEvent e) {
				try {

					// Validar que los campos no estén vacíos
					if (txtValor.getText().isEmpty() || txtCantidad.getText().isEmpty()) {
						JOptionPane.showMessageDialog(rightPanel, "Debe ingresar un valor y una cantidad.", "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					} else {
						btnGuardar.setEnabled(true);
					}

					double valor = Double.parseDouble(txtValor.getText());
					int cantidad = Integer.parseInt(txtCantidad.getText());

					// Validar si la denominación ingresada existe en USD
					if (!denominacionesUSD.contains(valor)) {
						JOptionPane.showMessageDialog(rightPanel,
								"Denominación inválida. Solo se aceptan valores en USD.", "Error",
								JOptionPane.ERROR_MESSAGE);
						txtValor.setText(""); // Limpiar el campo
						return;
					}

					double subtotal = valor * cantidad;
					totalUSD += subtotal;

					txtTotalUSD.setText(String.format("%.2f", totalUSD));
					totalVeridicado.setText(txtTotalUSD.getText());

					String archivoCSV = "archivosPantallaTransaccional\\denominaciones.csv";

					try (PrintWriter writer = new PrintWriter(new FileWriter(archivoCSV, true))) {

						writer.println(txtCodigoCajero.getText() + "," + cmbDenominacion.getSelectedItem() + ","
								+ txtValor.getText() + "," + txtCantidad.getText());
					} catch (IOException ef) {
						ef.printStackTrace();
					}

					// Limpiar campos después de registrar
					txtValor.setText("");
					txtCantidad.setText("");
					txtValor.requestFocus();

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(rightPanel, "Ingrese valores numéricos válidos.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

				String verificadoText = totalVeridicado.getText().replace(",", ".");
				String disponibleText = totalDisponible.getText().replace(",", ".");
				double verificado = Double.parseDouble(verificadoText);
				double disponible = Double.parseDouble(disponibleText);
				double resultado = verificado - disponible;
				diferencia.setText("" + resultado);
			}

		});

		btnGuardar.addActionListener(e -> {
			JOptionPane.showMessageDialog(rightPanel, "Nomina guardada exitosamente", null, 1);
		});
	}

	/**
	 * Muestra la interfaz y gestiona el egreso de caja.
	 * Permite transferencias entre cajeros o desde la caja a la bóveda.
	 */
	public void egresoDeCaja() {
		JLabel lblNewLabel = new JLabel("Origen:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(172, 90, 199, 34);
		rightPanel.add(lblNewLabel);

		JLabel lblNombre = new JLabel("Destino:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(172, 150, 168, 34);
		rightPanel.add(lblNombre);

		// Opciones de origen y destino (Cajeros y Bóveda)
		String opcionesCorresponsal[] = { "Cajero 1", "Cajero 2", "Bóveda" };
		JComboBox<String> opciones = new JComboBox<>(opcionesCorresponsal);
		rightPanel.add(opciones);
		opciones.setBounds(385, 95, 199, 29);

		JComboBox<String> opciones2 = new JComboBox<>(opcionesCorresponsal);
		rightPanel.add(opciones2);
		opciones2.setBounds(385, 155, 199, 29);

		JTextField monto = new JTextField();
		monto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		monto.setBounds(385, 215, 199, 29);
		rightPanel.add(monto);

		JLabel lblNewLabel_1 = new JLabel("Egreso de Caja");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(284, 36, 451, 47);
		rightPanel.add(lblNewLabel_1);

		JLabel lblCiDelBeneficiario = new JLabel("Monto:");
		lblCiDelBeneficiario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCiDelBeneficiario.setBounds(172, 215, 217, 34);
		rightPanel.add(lblCiDelBeneficiario);

		JButton registrar = new JButton("Registrar egreso");
		registrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		registrar.setBounds(279, 300, 187, 47);
		rightPanel.add(registrar);

		registrar.addActionListener(e -> {
			String origen = (String) opciones.getSelectedItem();
			String destino = (String) opciones2.getSelectedItem();
			String montoIngresado = monto.getText();

			// 1. Validar que el monto sea un número
			try {
				double cantidad = Double.parseDouble(montoIngresado.replace(",", "."));
				if (cantidad <= 0) {
					JOptionPane.showMessageDialog(null, "El monto debe ser mayor a 0.", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				// 2. Validar que el origen y destino sean diferentes
				if (origen.equals(destino)) {
					JOptionPane.showMessageDialog(null, "El origen y el destino no pueden ser iguales.", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				// 3. Determinar el cajero de origen y destino
				Cajero cajeroOrigen = null, cajeroDestino = null;
				boolean esBovedaOrigen = false, esBovedaDestino = false;

				if (origen.equals("Cajero 1")) {
					cajeroOrigen = cajero001;
				} else if (origen.equals("Cajero 2")) {
					cajeroOrigen = cajero002;
				} else if (origen.equals("Bóveda")) {
					esBovedaOrigen = true;
				}

				if (destino.equals("Cajero 1")) {
					cajeroDestino = cajero001;
				} else if (destino.equals("Cajero 2")) {
					cajeroDestino = cajero002;
				} else if (destino.equals("Bóveda")) {
					esBovedaDestino = true;
				}

				// 4. Procesar la transacción según el caso
				if (esBovedaOrigen && cajeroDestino != null) {
					// Transferencia desde la Bóveda a un Cajero
					if (boveda.getDinero() < cantidad) {
						JOptionPane.showMessageDialog(null, "Saldo insuficiente en la Bóveda.", "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					boveda.setDinero(boveda.getDinero() - cantidad);
					cajeroDestino.registrarTransaccion(true, cantidad, "", getOpcionSeleccionada());
					JOptionPane.showMessageDialog(null, "Transferencia desde Bóveda realizada con éxito.", "Éxito",
							JOptionPane.INFORMATION_MESSAGE);
				} else if (cajeroOrigen != null && cajeroDestino != null) {
					// **VALIDACIÓN DEL DINERO ANTES DE HACER UN EGRESO ENTRE CAJEROS**
					System.out.println(validarDineroCaja(cajeroOrigen, cantidad) || cajeroOrigen.getDineroCaja()<cajeroDestino.getDineroCaja());
					if (validarDineroCaja(cajeroOrigen, cantidad) || cajeroOrigen.getDineroCaja()<cajeroDestino.getDineroCaja()) {
						return;
					} else {

					// Transferencia entre Cajeros
					cajeroOrigen.registrarTransaccion(false, cantidad, "", getOpcionSeleccionada());
					cajeroDestino.registrarTransaccion(true, cantidad, "", getOpcionSeleccionada());
					JOptionPane.showMessageDialog(null, "Transferencia entre cajeros realizada con éxito.", "Éxito",
							JOptionPane.INFORMATION_MESSAGE);}
				} else if (cajeroOrigen != null && esBovedaDestino) {
					// **VALIDACIÓN DEL DINERO ANTES DE HACER UN EGRESO DESDE UN CAJERO A LA
					// BÓVEDA**
					if (!validarDineroCaja(cajeroOrigen, cantidad)) {
						return;
					}

					// Transferencia desde un Cajero a la Bóveda
					cajeroOrigen.registrarTransaccion(false, cantidad, "", getOpcionSeleccionada());
					boveda.setDinero(boveda.getDinero() + cantidad);
					JOptionPane.showMessageDialog(null, "Transferencia a la Bóveda realizada con éxito.", "Éxito",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "No se puede procesar la transacción.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Ingrese un monto válido (solo números).", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		});
	}

	/**
	 * Muestra la interfaz y gestiona el ingreso de caja.
	 * Permite registrar dinero en la caja desde otras fuentes.
	 */
	public void ingresoDeCaja() {
		JLabel lblNewLabel = new JLabel("Origen:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(172, 90, 199, 34);
		rightPanel.add(lblNewLabel);

		JLabel lblNombre = new JLabel("Destino:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(172, 150, 168, 34);
		rightPanel.add(lblNombre);

		String opcionesCorresponsal[] = { "Cajero 1", "Cajero 2", "Bóveda" };
		JComboBox<String> opciones = new JComboBox<>(opcionesCorresponsal);
		rightPanel.add(opciones);
		opciones.setBounds(385, 95, 199, 29);

		JComboBox<String> opciones2 = new JComboBox<>(opcionesCorresponsal);
		rightPanel.add(opciones2);
		opciones2.setBounds(385, 155, 199, 29);

		JTextField monto = new JTextField();
		monto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		monto.setBounds(385, 215, 199, 29);
		rightPanel.add(monto);

		JLabel lblNewLabel_1 = new JLabel("Ingreso de Caja");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(284, 36, 451, 47);
		rightPanel.add(lblNewLabel_1);

		JLabel lblCiDelBeneficiario = new JLabel("Monto:");
		lblCiDelBeneficiario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCiDelBeneficiario.setBounds(172, 215, 217, 34);
		rightPanel.add(lblCiDelBeneficiario);

		JButton registrar = new JButton("Registrar ingreso");
		registrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		registrar.setBounds(279, 300, 187, 47);
		rightPanel.add(registrar);

		registrar.addActionListener(e -> {
			String origen = (String) opciones.getSelectedItem();
			String destino = (String) opciones2.getSelectedItem();
			String montoIngresado = monto.getText();

			try {
				double cantidad = Double.parseDouble(montoIngresado.replace(",", "."));
				if (cantidad <= 0) {
					JOptionPane.showMessageDialog(null, "El monto debe ser mayor a 0.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (origen.equals(destino)) {
					JOptionPane.showMessageDialog(null, "El origen y el destino no pueden ser iguales.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				Cajero cajeroOrigen = null, cajeroDestino = null;
				boolean esBovedaOrigen = false, esBovedaDestino = false;

				if (origen.equals("Cajero 1")) {
					cajeroOrigen = cajero001;
				} else if (origen.equals("Cajero 2")) {
					cajeroOrigen = cajero002;
				} else if (origen.equals("Bóveda")) {
					esBovedaOrigen = true;
				}

				if (destino.equals("Cajero 1")) {
					cajeroDestino = cajero001;
				} else if (destino.equals("Cajero 2")) {
					cajeroDestino = cajero002;
				} else if (destino.equals("Bóveda")) {
					esBovedaDestino = true;
				}

				// Procesar la transacción según el caso
				List<String> lineasActualizadas = new ArrayList<>();
				String archivo = "archivosPantallaTransaccional/cuentasAutorizadas.csv";

				if (esBovedaOrigen && cajeroDestino != null) {
					if (boveda.getDinero() < cantidad) {
						JOptionPane.showMessageDialog(null, "Saldo insuficiente en la Bóveda.", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
					boveda.setDinero(boveda.getDinero() - cantidad);
					cajeroDestino.registrarTransaccion(true, cantidad, "", "Ingreso de Caja");

				} else if (cajeroOrigen != null && cajeroDestino != null) {
					if (cajeroOrigen.getDineroCaja() < cantidad) {
						JOptionPane.showMessageDialog(null, "Saldo insuficiente en el cajero de origen.", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
					cajeroOrigen.registrarTransaccion(false, cantidad, "", "Egreso de Caja");
					cajeroDestino.registrarTransaccion(true, cantidad, "", "Ingreso de Caja");

				} else if (cajeroOrigen != null && esBovedaDestino) {
					if (cajeroOrigen.getDineroCaja() < cantidad) {
						JOptionPane.showMessageDialog(null, "Saldo insuficiente en el cajero.", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
					cajeroOrigen.registrarTransaccion(false, cantidad, "", "Ingreso de Caja");
					boveda.setDinero(boveda.getDinero() + cantidad);

				} else {
					JOptionPane.showMessageDialog(null, "No se puede procesar la transacción.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				// **Actualizar el CSV**
				try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
					String line;
					while ((line = reader.readLine()) != null) {
						String[] datos = line.split(",");
						if (datos[0].equals(origen)) {
							double saldoActual = Double.parseDouble(datos[2]) - cantidad;
							datos[2] = String.valueOf(saldoActual);
						} else if (datos[0].equals(destino)) {
							double saldoActual = Double.parseDouble(datos[2]) + cantidad;
							datos[2] = String.valueOf(saldoActual);
						}
						lineasActualizadas.add(String.join(",", datos));
					}
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(null, "Error al leer el archivo de cuentas.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
					for (String nuevaLinea : lineasActualizadas) {
						writer.write(nuevaLinea);
						writer.newLine();
					}
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(null, "Error al actualizar el saldo en el archivo CSV.", "Error", JOptionPane.ERROR_MESSAGE);
				}

				JOptionPane.showMessageDialog(null, "Transacción realizada con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Ingrese un monto válido (solo números).", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
	}

	/**
	 * Muestra la interfaz y gestiona el retiro sin libreta.
	 * Verifica la cuenta y valida la firma antes de procesar el retiro.
	 */
	public void retiroSinLibreta() {
		JLabel lblNewLabel_1 = new JLabel("Retiro sin Libreta");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(309, 55, 187, 47);
		rightPanel.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("N° De Cuenta de Ahorros:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(175, 168, 193, 25);
		rightPanel.add(lblNewLabel);

		JLabel lblMontoARetirar = new JLabel("Monto a Retirar:");
		lblMontoARetirar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMontoARetirar.setBounds(175, 226, 193, 25);
		rightPanel.add(lblMontoARetirar);

		JTextField numeroDeCuenta = new JTextField();
		numeroDeCuenta.setBounds(434, 167, 207, 25);
		rightPanel.add(numeroDeCuenta);
		numeroDeCuenta.setColumns(10);

		JTextField montoARetirar = new JTextField();
		montoARetirar.setColumns(10);
		montoARetirar.setBounds(434, 226, 207, 25);
		rightPanel.add(montoARetirar);

		JButton revisarFirmaButton = new JButton("Revisar Firma");
		revisarFirmaButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		revisarFirmaButton.setBounds(175, 409, 207, 47);
		rightPanel.add(revisarFirmaButton);

		JButton pagarRetirButton = new JButton("Pagar Retiro");
		pagarRetirButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pagarRetirButton.setBounds(434, 409, 207, 47);
		pagarRetirButton.setEnabled(false);
		rightPanel.add(pagarRetirButton);

		// Acción del botón "Revisar Firma"
		revisarFirmaButton.addActionListener(e -> {
			String cuenta = numeroDeCuenta.getText().trim();
			// Verificar que la cuenta exista en cuentasAutorizadas.txt
			boolean cuentaEncontrada = false;
			try (BufferedReader reader = new BufferedReader(
					new FileReader("archivosPantallaTransaccional\\cuentasAutorizadas.csv"))) {
				String line;
				while ((line = reader.readLine()) != null) {
					String[] datos = line.split(",");
					if (datos[0].equals(cuenta)) {
						cuentaEncontrada = true;
						break;
					}
				}
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, "Error al leer el archivo de cuentas.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (!cuentaEncontrada) {
				JOptionPane.showMessageDialog(null, "Cuenta no encontrada. Verifique el número de cuenta.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			String imagePath = "archivosPantallaTransaccional\\firmas\\" + cuenta + ".jpg"; // Usa solo el nombre si la
																							// imagen está en la raíz
																							// del
			// proyecto

			// Verificar si la imagen existe en el directorio del proyecto
			File imageFile = new File(imagePath);

			if (!imageFile.exists()) {
				JOptionPane.showMessageDialog(null, "Firma no encontrada para la cuenta " + cuenta, "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Crear ventana emergente para la firma
			JDialog firmaDialog = new JDialog();
			firmaDialog.setTitle("Verificación de Firma");
			firmaDialog.setSize(400, 400);
			firmaDialog.setLayout(new BorderLayout());
			firmaDialog.setLocationRelativeTo(null);

			// Intentar cargar la imagen
			try {
				BufferedImage img = ImageIO.read(imageFile);
				Image dimg = img.getScaledInstance(350, 250, Image.SCALE_SMOOTH);
				ImageIcon firmaIcono = new ImageIcon(dimg);
				JLabel imagenFirma = new JLabel(firmaIcono, JLabel.CENTER);

				// Etiqueta superior
				JLabel label = new JLabel("Firma del titular de la cuenta:", JLabel.CENTER);
				label.setFont(new Font("Tahoma", Font.BOLD, 14));

				// Botón "Firma Correcta"
				JButton btnCorrecta = new JButton("Sí, es correcta");
				btnCorrecta.addActionListener(ev -> {
					JOptionPane.showMessageDialog(null, "Firma validada correctamente.", "Éxito",
							JOptionPane.INFORMATION_MESSAGE);
					pagarRetirButton.setEnabled(true);
					firmaDialog.dispose();
				});

				// Botón "Firma Incorrecta"
				JButton btnIncorrecta = new JButton("No, no es correcta");
				btnIncorrecta.addActionListener(ev -> {
					JOptionPane.showMessageDialog(null, "Firma incorrecta. No se puede continuar con el retiro.",
							"Error", JOptionPane.ERROR_MESSAGE);
					pagarRetirButton.setEnabled(false);
					firmaDialog.dispose();
				});

				// Panel para los botones
				JPanel panelBotones = new JPanel();
				panelBotones.add(btnCorrecta);
				panelBotones.add(btnIncorrecta);

				// Agregar componentes a la ventana
				firmaDialog.add(label, BorderLayout.NORTH);
				firmaDialog.add(imagenFirma, BorderLayout.CENTER);
				firmaDialog.add(panelBotones, BorderLayout.SOUTH);

				// Mostrar ventana
				firmaDialog.setVisible(true);

			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, "Error al cargar la firma.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});

		// Acción del botón "Pagar Retiro"
		pagarRetirButton.addActionListener(e -> {
			String cuenta = numeroDeCuenta.getText();
			String montoIngresado = montoARetirar.getText();
			double monto;

			try {
				monto = Double.parseDouble(montoIngresado.replace(",", "."));
				if (monto <= 0) {
					JOptionPane.showMessageDialog(null, "El monto debe ser mayor a 0.", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				// **Validar si hay suficiente dinero en el cajero antes de continuar**
				if (validarDineroCaja(cajero001, monto)) {
					return;
				}

				// **Leer y validar el saldo real de la cuenta desde el archivo CSV**
				boolean cuentaEncontrada = false;
				double saldoDisponible = 0.0;
				List<String> lineasActualizadas = new ArrayList<>();

				try (BufferedReader reader = new BufferedReader(
						new FileReader("archivosPantallaTransaccional\\cuentasAutorizadas.csv"))) {
					String line;
					while ((line = reader.readLine()) != null) {
						String[] datos = line.split(",");
						if (datos[0].equals(cuenta)) {
							cuentaEncontrada = true;
							saldoDisponible = Double.parseDouble(datos[2]); // Obtener saldo actual
							if (saldoDisponible < monto) {
								JOptionPane.showMessageDialog(null,
										"No se puede realizar el retiro, saldo insuficiente.",
										"Error", JOptionPane.ERROR_MESSAGE);
								return;
							}
							// Actualizar saldo después del retiro
							datos[2] = String.valueOf(saldoDisponible - monto);
						}
						// Guardamos la línea actualizada o sin cambios
						lineasActualizadas.add(String.join(",", datos));
					}
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(null, "Error al leer el archivo de cuentas.", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (!cuentaEncontrada) {
					JOptionPane.showMessageDialog(null, "Cuenta no encontrada. Verifique el número de cuenta.", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				// **Actualizar el archivo CSV con el nuevo saldo**
				try (BufferedWriter writer = new BufferedWriter(
						new FileWriter("archivosPantallaTransaccional\\cuentasAutorizadas.csv"))) {
					for (String linea : lineasActualizadas) {
						writer.write(linea);
						writer.newLine();
					}
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(null, "Error al actualizar el saldo de la cuenta.", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				JOptionPane.showMessageDialog(null, "El retiro se realizó con éxito.", "Éxito",
						JOptionPane.INFORMATION_MESSAGE);

				// **Registrar el egreso en el cajero después de validar**
				cajero001.registrarTransaccion(false, monto, intitucionSeleccionada, getOpcionSeleccionada());

			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Ingrese un monto válido (solo números).", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		});
	}

	/**
	 * Muestra la interfaz y gestiona el pago de matriculación vehicular.
	 * Consulta los datos del vehículo y permite registrar el pago.
	 */
	public void matriculacionVehicular() {
		JLabel lblNewLabel_1 = new JLabel("Pago de Matriculación Vehicular");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(243, 51, 451, 47);
		rightPanel.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("Numero De Placa:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(172, 126, 199, 34);
		rightPanel.add(lblNewLabel);

		JTextField numeroDePlaca = new JTextField();
		numeroDePlaca.setFont(new Font("Tahoma", Font.PLAIN, 15));
		numeroDePlaca.setBounds(385, 131, 199, 29);
		rightPanel.add(numeroDePlaca);
		numeroDePlaca.setColumns(10);

		JButton consultarButton = new JButton("Consultar");
		consultarButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		consultarButton.setBounds(174, 507, 207, 47);
		rightPanel.add(consultarButton);

		JButton btnPagarMatriculacion = new JButton("Pagar Matriculación Vehicular");
		btnPagarMatriculacion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPagarMatriculacion.setBounds(414, 507, 230, 47);
		btnPagarMatriculacion.setEnabled(false); // Se deshabilita hasta que se consulte la placa
		rightPanel.add(btnPagarMatriculacion);

		// Etiquetas para mostrar la información del vehículo (vacías por defecto)
		JLabel lblPropietario = new JLabel("Propietario: ");
		lblPropietario.setBounds(172, 180, 300, 30);
		lblPropietario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPropietario.setVisible(false);
		rightPanel.add(lblPropietario);

		JLabel lblMarca = new JLabel("Marca: ");
		lblMarca.setBounds(172, 220, 400, 30);
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMarca.setVisible(false);
		rightPanel.add(lblMarca);

		JLabel lblModelo = new JLabel("Modelo: ");
		lblModelo.setBounds(172, 260, 200, 30);
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblModelo.setVisible(false);
		rightPanel.add(lblModelo);

		JLabel lblAnio = new JLabel("Año: ");
		lblAnio.setBounds(172, 300, 200, 30);
		lblAnio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAnio.setVisible(false);
		rightPanel.add(lblAnio);

		JLabel lblRevision = new JLabel("Fecha de Revisión: ");
		lblRevision.setBounds(172, 340, 250, 30);
		lblRevision.setVisible(false);
		lblRevision.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rightPanel.add(lblRevision);

		JLabel lblMonto = new JLabel("Monto a Pagar: ");
		lblMonto.setBounds(172, 380, 200, 30);
		lblMonto.setVisible(false);
		lblMonto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rightPanel.add(lblMonto);
		// Botón para consultar los datos del vehículo
		consultarButton.addActionListener(e -> {
			String placa = numeroDePlaca.getText().trim();

			// Validar que la placa tenga el formato correcto (Ejemplo: ABC123 o ABC1234)
			if (!placa.matches("[A-Z]{3}\\d{3,4}")) {
				JOptionPane.showMessageDialog(null, "Formato de placa inválido. Use AAA123 o AAA1234.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Buscar la información del vehículo en un archivo simulado (vehiculos.txt)
			boolean vehiculoEncontrado = false;
			try (BufferedReader reader = new BufferedReader(
					new FileReader("archivosPantallaTransaccional\\vehiculos.csv"))) {
				String line;
				while ((line = reader.readLine()) != null) {
					String[] datos = line.split(",");
					if (datos[0].equals(placa)) {
						lblPropietario.setText("Propietario:           " + datos[1]);
						lblMarca.setText("Marca:                 " + datos[2]);
						lblModelo.setText("Modelo:                " + datos[3]);
						lblAnio.setText("Año:                     " + datos[4]);
						lblRevision.setText("Fecha de Revisión:   " + datos[5]);
						lblMonto.setText("Monto a Pagar:        $" + datos[6]);
						// Mostrar los datos en pantalla
						lblPropietario.setVisible(true);
						lblMarca.setVisible(true);
						lblModelo.setVisible(true);
						lblAnio.setVisible(true);
						lblRevision.setVisible(true);
						lblMonto.setVisible(true);

						// Habilitar el botón de pago
						btnPagarMatriculacion.setEnabled(true);

						vehiculoEncontrado = true;
						break;
					}
				}
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, "Error al leer el archivo de vehículos.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (!vehiculoEncontrado) {
				JOptionPane.showMessageDialog(null, "Vehículo no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});

		// Acción del botón "Pagar Matriculación Vehicular"
		btnPagarMatriculacion.addActionListener(e -> {
			String placa = numeroDePlaca.getText().trim();
			String montoTexto = lblMonto.getText().replace("Monto a Pagar:", "").trim();

			if (placa.isEmpty() || montoTexto.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debe consultar un vehículo antes de pagar.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Eliminar el símbolo de dólar y posibles espacios extras
			montoTexto = montoTexto.replace("$", "").replace(",", ".").trim();

			try {
				double monto = Double.parseDouble(montoTexto);

				// Validación de saldo en el cajero antes de procesar el pago
				if (validarDineroCaja(cajero001, monto)) {
					return; // No continuar si no hay saldo suficiente
				}

				JOptionPane.showMessageDialog(null, "El pago de Matriculación Vehicular fue realizado con éxito.",
						"Éxito", JOptionPane.INFORMATION_MESSAGE);

				// Registrar la transacción en el cajero
				cajero001.registrarTransaccion(false, monto, intitucionSeleccionada, getOpcionSeleccionada());

			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Error: El monto ingresado no es válido.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		});
	}

	/**
	 * Muestra la interfaz y gestiona la operación de depósito en efectivo.
	 * Verifica la cuenta destino, valida el monto ingresado y registra la
	 * transacción.
	 */
	public void depositoEnEfectivo() {
		// Etiqueta para el título de la transacción
		JLabel lblNewLabel_1 = new JLabel("Depósito en Efectivo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(277, 43, 224, 47);
		rightPanel.add(lblNewLabel_1);

		// Etiquetas de entrada
		JLabel lblNewLabel = new JLabel("Número de cuenta destino:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(172, 126, 199, 34);
		rightPanel.add(lblNewLabel);

		JLabel lblNombre = new JLabel("Nombre del dueño:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(172, 184, 168, 34);
		rightPanel.add(lblNombre);

		JLabel lblMonto = new JLabel("Monto del depósito:");
		lblMonto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMonto.setBounds(172, 246, 168, 34);
		rightPanel.add(lblMonto);

		// Campos de entrada
		JTextField numeroCuenta = new JTextField();
		numeroCuenta.setBounds(370, 131, 199, 29);
		rightPanel.add(numeroCuenta);

		JTextField nombreDueño = new JTextField();
		nombreDueño.setBounds(370, 189, 199, 29);
		rightPanel.add(nombreDueño);

		JTextField montoDeposito = new JTextField();
		montoDeposito.setBounds(370, 249, 199, 29);
		rightPanel.add(montoDeposito);

		JButton registrarDepositButton = new JButton("Registrar Depósito");
		registrarDepositButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		registrarDepositButton.setBounds(299, 307, 187, 47);
		rightPanel.add(registrarDepositButton);

		// Acción del botón "Registrar Depósito"
		registrarDepositButton.addActionListener(e -> {
			String cuenta = numeroCuenta.getText().trim();
			String nombreIngresado = nombreDueño.getText().trim();
			String montoIngresado = montoDeposito.getText().trim();

			// Verificar que los campos no estén vacíos
			if (cuenta.isEmpty() || nombreIngresado.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debe ingresar el número de cuenta y el nombre del dueño.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Verificar si la cuenta y el nombre coinciden en cuentasAutorizadas.csv
			boolean cuentaEncontrada = false;
			String nombreRegistrado = "";
			double saldoDisponible = 0.0;
			List<String> lineasActualizadas = new ArrayList<>();

			try (BufferedReader reader = new BufferedReader(
					new FileReader("archivosPantallaTransaccional\\cuentasAutorizadas.csv"))) {
				String line;
				while ((line = reader.readLine()) != null) {
					String[] datos = line.split(",");

					if (datos[0].equals(cuenta)) {
						nombreRegistrado = datos[1].trim();
						saldoDisponible = Double.parseDouble(datos[2]); // Obtener saldo actual
						cuentaEncontrada = true;
					}

					lineasActualizadas.add(line);
				}
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, "Error al leer el archivo de cuentas.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (!cuentaEncontrada) {
				JOptionPane.showMessageDialog(null, "Cuenta no encontrada. Verifique el número de cuenta.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Validar que el nombre ingresado coincida con el nombre registrado
			if (!nombreIngresado.equalsIgnoreCase(nombreRegistrado)) {
				JOptionPane.showMessageDialog(null, "El nombre ingresado no coincide con el registrado en la cuenta.",
						"Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Validar que el monto ingresado sea un número válido
			double monto;
			try {
				monto = Double.parseDouble(montoIngresado.replace(",", "."));
				if (monto <= 0) {
					JOptionPane.showMessageDialog(null, "El monto debe ser mayor a 0.", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Ingrese un monto válido (solo números).", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Actualizar saldo en el archivo CSV
			List<String> lineasFinales = new ArrayList<>();
			try (BufferedReader reader = new BufferedReader(
					new FileReader("archivosPantallaTransaccional\\cuentasAutorizadas.csv"))) {
				String line;
				while ((line = reader.readLine()) != null) {
					String[] datos = line.split(",");
					if (datos[0].equals(cuenta)) {
						double nuevoSaldo = saldoDisponible + monto;
						datos[2] = String.valueOf(nuevoSaldo);
						line = String.join(",", datos);
					}
					lineasFinales.add(line);
				}
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, "Error al actualizar el archivo de cuentas.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Escribir los datos actualizados en el CSV
			try (BufferedWriter writer = new BufferedWriter(
					new FileWriter("archivosPantallaTransaccional\\cuentasAutorizadas.csv"))) {
				for (String nuevaLinea : lineasFinales) {
					writer.write(nuevaLinea);
					writer.newLine();
				}
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, "Error al guardar la actualización de saldo.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Confirmación del depósito
			JOptionPane.showMessageDialog(null, "El depósito se realizó con éxito.", "Éxito",
					JOptionPane.INFORMATION_MESSAGE);

			// Registrar transacción en el cajero
			cajero001.registrarTransaccion(true, monto, intitucionSeleccionada, getOpcionSeleccionada());

			// Limpiar los campos de entrada
			montoDeposito.setText("");
		});
	}

	/**
	 * Muestra la interfaz y gestiona la operación de depósito en cheques.
	 * Verifica la cuenta destino, valida los cheques y registra la transacción.
	 */
	public void depositoEnCheque() {
		// Etiqueta para el título de la transacción
		JLabel lblNewLabel_1 = new JLabel("Depósito en Cheques");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(277, 43, 224, 47);
		rightPanel.add(lblNewLabel_1);

		// Etiquetas de entrada
		JLabel lblCuenta = new JLabel("Número de cuenta destino:");
		lblCuenta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCuenta.setBounds(172, 126, 199, 34);
		rightPanel.add(lblCuenta);

		JLabel lblNombre = new JLabel("Nombre del dueño:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(172, 184, 168, 34);
		rightPanel.add(lblNombre);

		JLabel lblMontoCheques = new JLabel("Monto por cheque:");
		lblMontoCheques.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMontoCheques.setBounds(172, 246, 217, 34);
		rightPanel.add(lblMontoCheques);

		JLabel lblNumCheques = new JLabel("Número de cheques:");
		lblNumCheques.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNumCheques.setBounds(172, 304, 217, 34);
		rightPanel.add(lblNumCheques);

		// Campos de entrada
		JTextField numeroCuenta = new JTextField();
		numeroCuenta.setBounds(385, 131, 199, 29);
		rightPanel.add(numeroCuenta);

		JTextField nombreDueño = new JTextField();
		nombreDueño.setBounds(385, 189, 199, 29);
		rightPanel.add(nombreDueño);

		JTextField montoCheques = new JTextField();
		montoCheques.setBounds(385, 249, 199, 29);
		rightPanel.add(montoCheques);

		JTextField numCheques = new JTextField();
		numCheques.setBounds(385, 307, 199, 29);
		rightPanel.add(numCheques);

		JButton registrarDepositButton = new JButton("Registrar Depósito");
		registrarDepositButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		registrarDepositButton.setBounds(299, 364, 187, 47);
		rightPanel.add(registrarDepositButton);

		// Acción del botón "Registrar Depósito"
		registrarDepositButton.addActionListener(e -> {
			String cuenta = numeroCuenta.getText().trim();
			String nombreIngresado = nombreDueño.getText().trim();
			String montoPorCheque = montoCheques.getText().trim();
			String cantidadCheques = numCheques.getText().trim();

			// Verificar que los campos no estén vacíos
			if (cuenta.isEmpty() || nombreIngresado.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debe ingresar el número de cuenta y el nombre del dueño.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Verificar si la cuenta y el nombre coinciden en cuentasAutorizadas.csv
			boolean cuentaEncontrada = false;
			String nombreRegistrado = "";
			double saldoDisponible = 0.0;
			List<String> lineasActualizadas = new ArrayList<>();

			try (BufferedReader reader = new BufferedReader(
					new FileReader("archivosPantallaTransaccional\\cuentasAutorizadas.csv"))) {
				String line;
				while ((line = reader.readLine()) != null) {
					String[] datos = line.split(",");

					if (datos[0].equals(cuenta)) {
						nombreRegistrado = datos[1].trim();
						saldoDisponible = Double.parseDouble(datos[2]); // Obtener saldo actual
						cuentaEncontrada = true;
					}

					lineasActualizadas.add(line);
				}
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, "Error al leer el archivo de cuentas.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (!cuentaEncontrada) {
				JOptionPane.showMessageDialog(null, "Cuenta no encontrada. Verifique el número de cuenta.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Validar que el nombre ingresado coincida con el nombre registrado
			if (!nombreIngresado.equalsIgnoreCase(nombreRegistrado)) {
				JOptionPane.showMessageDialog(null, "El nombre ingresado no coincide con el registrado en la cuenta.",
						"Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Validar los montos y número de cheques
			double montoCheque;
			int numCheque;
			try {
				montoCheque = Double.parseDouble(montoPorCheque.replace(",", "."));
				numCheque = Integer.parseInt(cantidadCheques);

				if (montoCheque <= 0 || numCheque <= 0) {
					JOptionPane.showMessageDialog(null, "El monto y el número de cheques deben ser mayores a 0.",
							"Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Ingrese valores numéricos válidos.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			// **Cálculo del monto total**
			double montoTotal = montoCheque * numCheque;

			// Actualizar saldo en el archivo CSV
			List<String> lineasFinales = new ArrayList<>();
			try (BufferedReader reader = new BufferedReader(
					new FileReader("archivosPantallaTransaccional\\cuentasAutorizadas.csv"))) {
				String line;
				while ((line = reader.readLine()) != null) {
					String[] datos = line.split(",");
					if (datos[0].equals(cuenta)) {
						double nuevoSaldo = saldoDisponible + montoTotal;
						datos[2] = String.valueOf(nuevoSaldo);
						line = String.join(",", datos);
					}
					lineasFinales.add(line);
				}
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, "Error al actualizar el archivo de cuentas.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Escribir los datos actualizados en el CSV
			try (BufferedWriter writer = new BufferedWriter(
					new FileWriter("archivosPantallaTransaccional\\cuentasAutorizadas.csv"))) {
				for (String nuevaLinea : lineasFinales) {
					writer.write(nuevaLinea);
					writer.newLine();
				}
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, "Error al guardar la actualización de saldo.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Confirmación del depósito
			JOptionPane.showMessageDialog(null, "El depósito se realizó con éxito. Monto total: $" + montoTotal, "Éxito",
					JOptionPane.INFORMATION_MESSAGE);

			// Registrar transacción en el cajero
			cajero001.registrarTransaccion(true, montoTotal, intitucionSeleccionada, getOpcionSeleccionada());

			// Limpiar los campos de entrada
			montoCheques.setText("");
			numCheques.setText("");
		});
	}

	/**
	 * Muestra la interfaz y gestiona la operación de depósito mixto (efectivo +
	 * cheques).
	 * Valida y registra ambas formas de depósito.
	 */
	public void depositoMixto() {
		// Etiqueta para el título de la transacción
		JLabel lblNewLabel_1 = new JLabel("Depósito Mixto");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(302, 42, 224, 47);
		rightPanel.add(lblNewLabel_1);

		// Etiquetas de entrada
		JLabel lblCuenta = new JLabel("Número de cuenta destino:");
		lblCuenta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCuenta.setBounds(172, 126, 199, 34);
		rightPanel.add(lblCuenta);

		JLabel lblNombre = new JLabel("Nombre del dueño:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(172, 184, 168, 34);
		rightPanel.add(lblNombre);

		JLabel lblMontoEfectivo = new JLabel("Monto del depósito (efectivo):");
		lblMontoEfectivo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMontoEfectivo.setBounds(172, 302, 217, 34);
		rightPanel.add(lblMontoEfectivo);

		JLabel lblMontoCheques = new JLabel("Monto por cheque:");
		lblMontoCheques.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMontoCheques.setBounds(172, 246, 217, 34);
		rightPanel.add(lblMontoCheques);

		JLabel lblNumCheques = new JLabel("Número de cheques:");
		lblNumCheques.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNumCheques.setBounds(172, 361, 217, 34);
		rightPanel.add(lblNumCheques);

		// Campos de entrada
		JTextField numeroCuenta = new JTextField();
		numeroCuenta.setBounds(385, 131, 199, 29);
		rightPanel.add(numeroCuenta);

		JTextField nombreDueño = new JTextField();
		nombreDueño.setBounds(385, 189, 199, 29);
		rightPanel.add(nombreDueño);

		JTextField montoEfectivo = new JTextField();
		montoEfectivo.setBounds(385, 305, 199, 29);
		rightPanel.add(montoEfectivo);

		JTextField montoCheques = new JTextField();
		montoCheques.setBounds(385, 249, 199, 29);
		rightPanel.add(montoCheques);

		JTextField numCheques = new JTextField();
		numCheques.setBounds(385, 366, 199, 29);
		rightPanel.add(numCheques);

		JButton registrarDepositButton = new JButton("Registrar Depósito");
		registrarDepositButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		registrarDepositButton.setBounds(302, 449, 187, 47);
		rightPanel.add(registrarDepositButton);

		// Acción del botón "Registrar Depósito"
		registrarDepositButton.addActionListener(e -> {
			String cuenta = numeroCuenta.getText().trim();
			String nombreIngresado = nombreDueño.getText().trim();
			String efectivoIngresado = montoEfectivo.getText().trim();
			String chequesIngresado = montoCheques.getText().trim();
			String cantidadCheques = numCheques.getText().trim();

			// Verificar que los campos no estén vacíos
			if (cuenta.isEmpty() || nombreIngresado.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debe ingresar el número de cuenta y el nombre del dueño.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Verificar si la cuenta y el nombre coinciden en cuentasAutorizadas.csv
			boolean cuentaEncontrada = false;
			String nombreRegistrado = "";
			double saldoDisponible = 0.0;
			List<String> lineasActualizadas = new ArrayList<>();

			try (BufferedReader reader = new BufferedReader(
					new FileReader("archivosPantallaTransaccional\\cuentasAutorizadas.csv"))) {
				String line;
				while ((line = reader.readLine()) != null) {
					String[] datos = line.split(",");

					if (datos[0].equals(cuenta)) {
						nombreRegistrado = datos[1].trim();
						saldoDisponible = Double.parseDouble(datos[2]); // Obtener saldo actual
						cuentaEncontrada = true;
					}

					lineasActualizadas.add(line);
				}
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, "Error al leer el archivo de cuentas.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (!cuentaEncontrada) {
				JOptionPane.showMessageDialog(null, "Cuenta no encontrada. Verifique el número de cuenta.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Validar que el nombre ingresado coincida con el nombre registrado
			if (!nombreIngresado.equalsIgnoreCase(nombreRegistrado)) {
				JOptionPane.showMessageDialog(null, "El nombre ingresado no coincide con el registrado en la cuenta.",
						"Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Validar los montos y número de cheques
			double montoEfect, montoCheq, montoTotalCheques;
			int numCheq;
			try {
				montoEfect = Double.parseDouble(efectivoIngresado.replace(",", "."));
				montoCheq = Double.parseDouble(chequesIngresado.replace(",", "."));
				numCheq = Integer.parseInt(cantidadCheques);

				if (montoEfect < 0 || montoCheq < 0 || numCheq < 0) {
					JOptionPane.showMessageDialog(null, "Los valores deben ser positivos.", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (montoEfect == 0 && montoCheq == 0) {
					JOptionPane.showMessageDialog(null, "Debe ingresar al menos un monto en efectivo o en cheques.",
							"Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Ingrese valores numéricos válidos.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			// **Cálculo del monto total en cheques**
			montoTotalCheques = montoCheq * numCheq;

			// Actualizar saldo en el archivo CSV
			List<String> lineasFinales = new ArrayList<>();
			try (BufferedReader reader = new BufferedReader(
					new FileReader("archivosPantallaTransaccional\\cuentasAutorizadas.csv"))) {
				String line;
				while ((line = reader.readLine()) != null) {
					String[] datos = line.split(",");
					if (datos[0].equals(cuenta)) {
						double nuevoSaldo = saldoDisponible + montoEfect + montoTotalCheques;
						datos[2] = String.valueOf(nuevoSaldo);
						line = String.join(",", datos);
					}
					lineasFinales.add(line);
				}
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, "Error al actualizar el archivo de cuentas.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Escribir los datos actualizados en el CSV
			try (BufferedWriter writer = new BufferedWriter(
					new FileWriter("archivosPantallaTransaccional\\cuentasAutorizadas.csv"))) {
				for (String nuevaLinea : lineasFinales) {
					writer.write(nuevaLinea);
					writer.newLine();
				}
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, "Error al guardar la actualización de saldo.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Confirmación del depósito
			JOptionPane.showMessageDialog(null, "El depósito se realizó con éxito.", "Éxito",
					JOptionPane.INFORMATION_MESSAGE);

			// Registrar transacción en el cajero
			cajero001.registrarTransaccion(true, montoEfect + montoTotalCheques, intitucionSeleccionada, getOpcionSeleccionada());

			// Limpiar los campos de entrada
			montoEfectivo.setText("");
			montoCheques.setText("");
			numCheques.setText("");
		});
	}

	/**
	 * Muestra la interfaz y gestiona la operación de pago de cheque.
	 * Verifica la cuenta origen, la firma del emisor y procesa el pago.
	 */
	public void pagoDeCheque() {
		JButton pagarChequeButton = new JButton("Pagar Cheque");
		pagarChequeButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pagarChequeButton.setBounds(172, 489, 187, 47);
		rightPanel.add(pagarChequeButton);
		pagarChequeButton.setEnabled(false);

		JLabel lblNewLabel = new JLabel("Número de cuenta corriente:  ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(172, 126, 199, 34);
		rightPanel.add(lblNewLabel);

		JLabel lblNombre = new JLabel("Nombre del dueño: \r\n");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(172, 184, 168, 34);
		rightPanel.add(lblNombre);

		JLabel lblMonto = new JLabel("Nombre del Beneficiario:");
		lblMonto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMonto.setBounds(172, 246, 217, 34);
		rightPanel.add(lblMonto);

		JLabel lblNewLabel_1 = new JLabel("Pago de Cheques");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(302, 42, 224, 47);
		rightPanel.add(lblNewLabel_1);

		JLabel lblNmeroDeCheques = new JLabel("Número de cheque:");
		lblNmeroDeCheques.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNmeroDeCheques.setBounds(172, 361, 217, 34);
		rightPanel.add(lblNmeroDeCheques);

		JLabel lblCiDelBeneficiario = new JLabel("CI del Beneficiario:");
		lblCiDelBeneficiario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCiDelBeneficiario.setBounds(172, 302, 217, 34);
		rightPanel.add(lblCiDelBeneficiario);

		JLabel lblMontoGirado = new JLabel("Monto girado:");
		lblMontoGirado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMontoGirado.setBounds(172, 421, 217, 34);
		rightPanel.add(lblMontoGirado);

		JTextField numeroCuenta = new JTextField();
		numeroCuenta.setBounds(385, 131, 199, 29);
		rightPanel.add(numeroCuenta);
		numeroCuenta.setColumns(10);

		JTextField nombreDueño = new JTextField();
		nombreDueño.setColumns(10);
		nombreDueño.setEnabled(false);
		nombreDueño.setBounds(385, 189, 199, 29);
		rightPanel.add(nombreDueño);

		JTextField nombreBeneficiado = new JTextField();
		nombreBeneficiado.setColumns(10);
		nombreBeneficiado.setBounds(385, 249, 199, 29);
		nombreBeneficiado.setEnabled(false);
		rightPanel.add(nombreBeneficiado);

		JTextField cedulaBeneficiado = new JTextField();
		cedulaBeneficiado.setColumns(10);
		cedulaBeneficiado.setBounds(385, 305, 199, 29);
		rightPanel.add(cedulaBeneficiado);
		cedulaBeneficiado.setEnabled(false);

		JTextField numeroDeCheque = new JTextField();
		numeroDeCheque.setColumns(10);
		numeroDeCheque.setBounds(385, 366, 199, 29);
		rightPanel.add(numeroDeCheque);
		numeroDeCheque.setEnabled(false);

		JTextField montoGirado = new JTextField("0.0");
		montoGirado.setColumns(10);
		montoGirado.setBounds(385, 426, 199, 29);
		rightPanel.add(montoGirado);
		montoGirado.setEnabled(false);

		JButton revisarFirmaButton = new JButton("Revisar Firma");
		revisarFirmaButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		revisarFirmaButton.setBounds(397, 489, 187, 47);
		rightPanel.add(revisarFirmaButton);

		pagarChequeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String cuenta = numeroCuenta.getText().trim();
				double montoIng = Double.parseDouble(montoGirado.getText());

				if (validarDineroCaja(cajero001, montoIng)) {
					return;
				}

				try (BufferedReader reader = new BufferedReader(
						new FileReader("archivosPantallaTransaccional\\cuentasAutorizadas.csv"))) {

					List<String> lineasActualizadas = new ArrayList<>();
					String line;

					while ((line = reader.readLine()) != null) {
						String[] datos = line.split(",");

						// Verificar si la cuenta es la que estamos buscando
						if (datos[0].equals(cuenta)) {
							nombreDueño.setText(datos[1]); // Establecer el nombre del dueño en el JTextField
							double montoArchivo = Double.parseDouble(datos[2]);
							if (montoArchivo < montoIng) {
								JOptionPane.showMessageDialog(null, "No hay dinero suficiente en la cuenta", "Error",
										JOptionPane.ERROR_MESSAGE);
								return;
							}
							// Calcular el nuevo valor para la posición 2
							double valor = Double.parseDouble(datos[2]);
							double valorNuevo = (valor - Double.parseDouble(montoGirado.getText()));

							// Reemplazar el valor en la posición 2 del arreglo 'datos'
							datos[2] = String.valueOf(valorNuevo); // Reemplazamos el valor en la posición 2

							// Agregar la línea modificada a la lista de líneas actualizadas
							lineasActualizadas.add(String.join(",", datos));
						} else {
							// Si no es la cuenta buscada, agregamos la línea tal cual está
							lineasActualizadas.add(line);
						}
					}

					// Reescribir el archivo CSV con las líneas actualizadas
					try (BufferedWriter writer = new BufferedWriter(
							new FileWriter("archivosPantallaTransaccional\\cuentasAutorizadas.csv"))) {
						for (String nuevaLinea : lineasActualizadas) {
							writer.write(nuevaLinea);
							writer.newLine();
						}
					}

				} catch (IOException ex) {
					JOptionPane.showMessageDialog(null, "Error al leer o escribir el archivo de cuentas.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

				// Validación para el número de cuenta (solo números)
				int numeroCheques = 0;
				String numeroCuentaText = numeroCuenta.getText();
				if (!numeroCuentaText.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(null, "El número de cuenta debe contener solo números.", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				// Validación para el nombre del dueño (solo letras y espacios)
				String nombreDueñoText = nombreDueño.getText();
				if (!nombreDueñoText.matches("[a-zA-Z ]+")) {
					JOptionPane.showMessageDialog(null, "El nombre del dueño solo debe contener letras y espacios.",
							"Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				// Validación para el nombre del beneficiado (solo letras y espacios)
				String nombreBeneficiadoText = nombreBeneficiado.getText();
				if (!nombreBeneficiadoText.matches("[a-zA-Z ]+")) {
					JOptionPane.showMessageDialog(null,
							"El nombre del beneficiado solo debe contener letras y espacios.", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				// Validación para la cédula del beneficiado (solo números)
				String cedulaBeneficiadoText = cedulaBeneficiado.getText();
				if (!cedulaBeneficiadoText.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(null, "La cédula del beneficiado debe contener solo números.",
							"Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				// Validación para el número de cheque (solo números)
				String numeroDeChequeText = numeroDeCheque.getText();

				if (!numeroDeChequeText.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(null, "El número de cheque debe contener solo números.", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				} else {
					numeroCheques = Integer.parseInt(numeroDeChequeText);
				}

				// Validación para el monto girado (solo números y punto decimal)
				String montoGiradoText = montoGirado.getText();
				double montoGirado;
				try {
					montoGirado = Double.parseDouble(montoGiradoText);
					if (montoGirado <= 0) {
						JOptionPane.showMessageDialog(null, "El monto girado debe ser mayor a cero.", "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "El monto girado debe ser un número válido.", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				cajero001.registrarTransaccion(false, montoGirado * numeroCheques, intitucionSeleccionada,
						getOpcionSeleccionada());
				rightPanel.removeAll();
				nominaDeCaja();
				rightPanel.revalidate();
				rightPanel.repaint();
				JOptionPane.showMessageDialog(null,
						"El depósito se realizó con éxito.", null, 1);
			}
		});

		revisarFirmaButton.addActionListener(e -> {
			String cuenta = numeroCuenta.getText().trim();
			// Verificar que la cuenta exista en cuentasAutorizadas.txt
			boolean cuentaEncontrada = false;
			try (BufferedReader reader = new BufferedReader(
					new FileReader("archivosPantallaTransaccional\\cuentasAutorizadas.csv"))) {

				String line;

				while ((line = reader.readLine()) != null) {
					String[] datos = line.split(",");

					// Verificar si la cuenta es la que estamos buscando
					if (datos[0].equals(cuenta)) {
						cuentaEncontrada = true;
						nombreDueño.setText(datos[1]);
					}
				}

			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, "Error al leer o escribir el archivo de cuentas.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}

			if (!cuentaEncontrada) {
				JOptionPane.showMessageDialog(null, "Cuenta no encontrada. Verifique el número de cuenta.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			String imagePath = "archivosPantallaTransaccional\\firmas\\" + cuenta + ".jpg"; // Usa solo el nombre si la
																							// imagen está en la raíz
																							// del
			// proyecto

			// Verificar si la imagen existe en el directorio del proyecto
			File imageFile = new File(imagePath);

			if (!imageFile.exists()) {
				JOptionPane.showMessageDialog(null, "Firma no encontrada para la cuenta " + cuenta, "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Crear ventana emergente para la firma
			JDialog firmaDialog = new JDialog();
			firmaDialog.setTitle("Verificación de Firma");
			firmaDialog.setSize(400, 400);
			firmaDialog.setLayout(new BorderLayout());
			firmaDialog.setLocationRelativeTo(null);

			// Intentar cargar la imagen
			try {
				BufferedImage img = ImageIO.read(imageFile);
				Image dimg = img.getScaledInstance(350, 250, Image.SCALE_SMOOTH);
				ImageIcon firmaIcono = new ImageIcon(dimg);
				JLabel imagenFirma = new JLabel(firmaIcono, JLabel.CENTER);

				// Etiqueta superior
				JLabel label = new JLabel("Firma del titular de la cuenta:", JLabel.CENTER);
				label.setFont(new Font("Tahoma", Font.BOLD, 14));

				// Botón "Firma Correcta"
				JButton btnCorrecta = new JButton("Sí, es correcta");
				btnCorrecta.addActionListener(ev -> {
					JOptionPane.showMessageDialog(null, "Firma validada correctamente.", "Éxito",
							JOptionPane.INFORMATION_MESSAGE);
					pagarChequeButton.setEnabled(true);
					cedulaBeneficiado.setEnabled(true);
					montoGirado.setEnabled(true);
					nombreBeneficiado.setEnabled(true);
					numeroDeCheque.setEnabled(true);
					// WENAAAAAS WENAAAAAS
					firmaDialog.dispose();
				});

				// Botón "Firma Incorrecta"
				JButton btnIncorrecta = new JButton("No, no es correcta");
				btnIncorrecta.addActionListener(ev -> {
					JOptionPane.showMessageDialog(null, "Firma incorrecta. No se puede continuar con el retiro.",
							"Error", JOptionPane.ERROR_MESSAGE);
					pagarChequeButton.setEnabled(false);
					firmaDialog.dispose();
				});

				// Panel para los botones
				JPanel panelBotones = new JPanel();
				panelBotones.add(btnCorrecta);
				panelBotones.add(btnIncorrecta);

				// Agregar componentes a la ventana
				firmaDialog.add(label, BorderLayout.NORTH);
				firmaDialog.add(imagenFirma, BorderLayout.CENTER);
				firmaDialog.add(panelBotones, BorderLayout.SOUTH);

				// Mostrar ventana
				firmaDialog.setVisible(true);

			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, "Error al cargar la firma.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});

	}

	/**
	 * Muestra la interfaz y gestiona la actualización de libreta de ahorro.
	 * Recupera los datos de la cuenta y actualiza el saldo impreso.
	 */
	public void actualizacionLiAho() {
		JLabel lblNewLabel = new JLabel("Número de cuenta:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(172, 126, 199, 34);
		rightPanel.add(lblNewLabel);

		JLabel lblNombre = new JLabel("Último saldo:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(172, 184, 168, 34);
		rightPanel.add(lblNombre);

		JLabel lblMonto = new JLabel("Número de control:");
		lblMonto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMonto.setBounds(172, 246, 217, 34);
		rightPanel.add(lblMonto);

		JTextField numeroCuenta = new JTextField();
		numeroCuenta.setBounds(385, 131, 199, 29);
		rightPanel.add(numeroCuenta);
		numeroCuenta.setColumns(10);

		JTextField ultimoSaldo = new JTextField();
		ultimoSaldo.setColumns(10);
		ultimoSaldo.setBounds(385, 189, 199, 29);
		rightPanel.add(ultimoSaldo);

		JTextField numeroControl = new JTextField();
		numeroControl.setColumns(10);
		numeroControl.setBounds(385, 249, 199, 29);
		rightPanel.add(numeroControl);

		JLabel lblNewLabel_1 = new JLabel("Actualización de Libreta de Ahorro");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(194, 44, 451, 47);
		rightPanel.add(lblNewLabel_1);

		JTextField lineaAImprimir = new JTextField();
		lineaAImprimir.setColumns(10);
		lineaAImprimir.setBounds(385, 305, 199, 29);
		rightPanel.add(lineaAImprimir);

		JLabel lblCiDelBeneficiario = new JLabel("Línea a imprimir:");
		lblCiDelBeneficiario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCiDelBeneficiario.setBounds(172, 302, 217, 34);
		rightPanel.add(lblCiDelBeneficiario);

		JButton actualizarLibretaButton = new JButton("Actualizar Libreta");
		actualizarLibretaButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		actualizarLibretaButton.setBounds(276, 410, 187, 47);
		rightPanel.add(actualizarLibretaButton);

		actualizarLibretaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Validación de monto ingresado
				double montoIngresado;
				try {
					montoIngresado = Double.parseDouble(ultimoSaldo.getText().replace(",", "."));
					if (montoIngresado <= 0) {
						JOptionPane.showMessageDialog(null, "El monto debe ser mayor a 0.", "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Ingrese un monto válido (solo números).", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				// Validación para numeroControl
				if (numeroControl.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "El número de control no puede estar vacío.", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				// Validación para lineaAImprimir
				int lineaImprimir;
				try {
					lineaImprimir = Integer.parseInt(lineaAImprimir.getText());
					if (lineaImprimir <= 2) {
						JOptionPane.showMessageDialog(null, "La linea ingresada ya existe", "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Numero de linea incorrecto",
							"Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				String cuenta = numeroCuenta.getText().trim();
				boolean cuentaEncontrada = false;

				try {
					montoIngresado = Double.parseDouble(ultimoSaldo.getText().replace(",", "."));
					if (montoIngresado <= 0) {
						JOptionPane.showMessageDialog(null, "El monto debe ser mayor a 0.", "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					List<String> lineasActualizadas = new ArrayList<>();

					try (BufferedReader reader = new BufferedReader(
							new FileReader("archivosPantallaTransaccional\\libretaAhorros.csv"))) {
						String line;

						while ((line = reader.readLine()) != null) {
							String[] datos = line.split(",");

							// Verificar si la cuenta es la que estamos buscando
							if (datos[0].equals(cuenta)) {
								cuentaEncontrada = true;

								try {
									double valorActual = Double.parseDouble(datos[1]);
									double valorNuevo = valorActual + montoIngresado;

									// Actualizar valores en las posiciones requeridas
									datos[1] = String.valueOf(valorNuevo);
									datos[2] = numeroControl.getText();
									datos[3] = lineaAImprimir.getText();
									datos[4] = "2025-02-02";

									// Agregar la línea modificada a la lista de líneas actualizadas
									lineasActualizadas.add(String.join(",", datos));
								} catch (NumberFormatException ex) {
									JOptionPane.showMessageDialog(null, "Error en el formato de los valores numéricos.",
											"Error", JOptionPane.ERROR_MESSAGE);
									return;
								}
							} else {
								// Si no es la cuenta buscada, agregamos la línea sin cambios
								lineasActualizadas.add(line);
							}
						}
					}

					if (!cuentaEncontrada) {
						JOptionPane.showMessageDialog(null, "Cuenta no encontrada. Verifique el número de cuenta.",
								"Error", JOptionPane.ERROR_MESSAGE);
						return;
					}

					// Reescribir el archivo CSV con las líneas actualizadas
					try (BufferedWriter writer = new BufferedWriter(
							new FileWriter("archivosPantallaTransaccional\\libretaAhorros.csv"))) {
						for (String nuevaLinea : lineasActualizadas) {
							writer.write(nuevaLinea);
							writer.newLine();
						}
					}

					// Registrar la transacción en el cajero
					cajero001.registrarTransaccion(true, montoIngresado, intitucionSeleccionada,
							getOpcionSeleccionada());

					JOptionPane.showMessageDialog(null, "Libreta actualizada con éxito", "Éxito",
							JOptionPane.INFORMATION_MESSAGE);

				} catch (IOException ex) {
					JOptionPane.showMessageDialog(null, "Error al leer o escribir el archivo de cuentas.", "Error",
							JOptionPane.ERROR_MESSAGE);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Ingrese un monto válido (solo números).", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

	}

	/**
	 * Muestra la interfaz y gestiona el pago de giros.
	 * Verifica la validez del giro y registra la transacción en el sistema.
	 */
	@SuppressWarnings("unchecked")
	public void pagoDeGiros() {
		JLabel lblNewLabel = new JLabel("Corresponsal:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(172, 126, 199, 34);
		rightPanel.add(lblNewLabel);

		JLabel lblNombre = new JLabel("Nombre del remitente:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(172, 184, 168, 34);
		rightPanel.add(lblNombre);

		JLabel cedulaBeneficiario = new JLabel("CI del Beneficiario:");
		cedulaBeneficiario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cedulaBeneficiario.setBounds(172, 246, 217, 34);
		rightPanel.add(cedulaBeneficiario);

		String opcionesCorresponsal[] = { "Globalize", "Western", "Rio" };
		@SuppressWarnings("rawtypes")
		JComboBox opciones = new JComboBox(opcionesCorresponsal);
		rightPanel.add(opciones);
		opciones.setBounds(385, 131, 199, 29);
		opciones.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JTextField remitente = new JTextField();
		remitente.setColumns(10);
		remitente.setBounds(385, 189, 199, 29);
		rightPanel.add(remitente);

		JTextField cedula = new JTextField();
		cedula.setColumns(10);
		cedula.setBounds(385, 249, 199, 29);
		rightPanel.add(cedula);

		JLabel lblNewLabel_1 = new JLabel("Pago de Giros");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(284, 36, 451, 47);
		rightPanel.add(lblNewLabel_1);

		JTextField nombreBenef = new JTextField();
		nombreBenef.setColumns(10);
		nombreBenef.setBounds(385, 305, 199, 29);
		rightPanel.add(nombreBenef);

		JLabel lblCiDelBeneficiario = new JLabel("Nombre del Beneficiario:");
		lblCiDelBeneficiario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCiDelBeneficiario.setBounds(172, 302, 217, 34);
		rightPanel.add(lblCiDelBeneficiario);

		JButton pagarGiroButton = new JButton("Pagar Giro");
		pagarGiroButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pagarGiroButton.setBounds(279, 424, 187, 47);
		rightPanel.add(pagarGiroButton);

		JLabel lblMontoDelGiro = new JLabel("Monto del giro:");
		lblMontoDelGiro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMontoDelGiro.setBounds(172, 358, 217, 34);
		rightPanel.add(lblMontoDelGiro);

		JTextField montoGiro = new JTextField();
		montoGiro.setColumns(10);
		montoGiro.setBounds(385, 361, 199, 29);
		rightPanel.add(montoGiro);

		pagarGiroButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = remitente.getText();
				String cedulaB = cedula.getText();
				String montoTexto = montoGiro.getText();
				// Validar nombre (solo letras y espacios)
				if (!nombre.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$")) {
					JOptionPane.showMessageDialog(null, "Ingrese un nombre válido (solo letras y espacios).", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				// Validar cédula (solo números, entre 6 y 12 dígitos, ajustable según país)
				if (!cedulaB.matches("^\\d{6,12}$")) {
					JOptionPane.showMessageDialog(null, "Ingrese un número de cédula válido (6-12 dígitos).", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (!nombreBenef.getText().matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$")) {
					JOptionPane.showMessageDialog(null, "Ingrese un nombre válido (solo letras y espacios).", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				// Validar monto (número decimal con opcional dos decimales)
				if (!montoTexto.matches("^\\d+(\\.\\d{1,2})?$")) {
					JOptionPane.showMessageDialog(null, "Ingrese correctamente el monto (ejemplo: 100 o 100.50).",
							"Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				// Convertir monto a Double después de la validación
				Double monto = Double.parseDouble(montoTexto);
				cajero001.registrarTransaccion(true, monto, intitucionSeleccionada, getOpcionSeleccionada());
				// Si pasa todas las validaciones
				JOptionPane.showMessageDialog(null, "Pago de giro registrado correctamente.", "Éxito",
						JOptionPane.INFORMATION_MESSAGE);

			}
		});

	}

	/**
	 * Muestra la interfaz y gestiona el retiro con libreta de ahorro.
	 * Valida el número de cuenta, el saldo y permite el retiro en efectivo.
	 */
	public void retiroConLibreta() {
		JLabel lblNewLabel = new JLabel("N° De Cuenta de Ahorros:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(172, 126, 199, 34);
		rightPanel.add(lblNewLabel);

		JLabel lblNombre = new JLabel("Último Saldo:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(172, 184, 168, 34);
		rightPanel.add(lblNombre);

		JLabel cedulaBeneficiario = new JLabel("Número de Control:");
		cedulaBeneficiario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cedulaBeneficiario.setBounds(172, 246, 217, 34);
		rightPanel.add(cedulaBeneficiario);

		JTextField numeroCuenta = new JTextField();
		numeroCuenta.setBounds(385, 131, 199, 29);
		rightPanel.add(numeroCuenta);
		numeroCuenta.setColumns(10);

		JTextField ultimoSaldo = new JTextField();
		ultimoSaldo.setColumns(10);
		ultimoSaldo.setBounds(385, 189, 199, 29);
		ultimoSaldo.setEnabled(false);
		rightPanel.add(ultimoSaldo);

		JTextField numeroControl = new JTextField();
		numeroControl.setColumns(10);
		numeroControl.setBounds(385, 249, 199, 29);
		numeroControl.setEnabled(false);
		rightPanel.add(numeroControl);

		JLabel lblNewLabel_1 = new JLabel("Retiro de Ahorros con Libreta");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(220, 50, 451, 47);
		rightPanel.add(lblNewLabel_1);

		JTextField montoRetiro = new JTextField();
		montoRetiro.setColumns(10);
		montoRetiro.setBounds(385, 305, 199, 29);
		rightPanel.add(montoRetiro);

		JLabel lblCiDelBeneficiario = new JLabel("Monto a Retirar:");
		lblCiDelBeneficiario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCiDelBeneficiario.setBounds(172, 302, 217, 34);
		rightPanel.add(lblCiDelBeneficiario);

		JButton pagarRetirButton = new JButton("Pagar Retiro");
		pagarRetirButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pagarRetirButton.setBounds(397, 434, 187, 47);
		pagarRetirButton.setEnabled(false);
		rightPanel.add(pagarRetirButton);

		JLabel lblMontoDelGiro = new JLabel("Línea a Imprimir:");
		lblMontoDelGiro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMontoDelGiro.setBounds(172, 358, 217, 34);
		rightPanel.add(lblMontoDelGiro);

		JTextField lineaAImprimir = new JTextField();
		lineaAImprimir.setColumns(10);
		lineaAImprimir.setBounds(385, 361, 199, 29);
		rightPanel.add(lineaAImprimir);

		JButton revisarFirmaButton = new JButton("Revisar Firma");
		revisarFirmaButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		revisarFirmaButton.setBounds(172, 434, 187, 47);
		rightPanel.add(revisarFirmaButton);

		numeroCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cuentaIngresada = numeroCuenta.getText();

				try (BufferedReader br = new BufferedReader(
						new FileReader("archivosPantallaTransaccional\\libretaAhorros.csv"))) {
					String line;
					boolean cuentaEncontrada = false;

					// Leer cada línea del CSV
					while ((line = br.readLine()) != null) {
						String[] datos = line.split(",");

						// Verificar si el número de cuenta ingresado coincide
						if (datos[0].equals(cuentaIngresada)) {
							ultimoSaldo.setText(datos[1]);
							numeroControl.setText(datos[2]);
							cuentaEncontrada = true;
							break;
						}
					}

					if (!cuentaEncontrada) {
						ultimoSaldo.setText("");
						numeroControl.setText("");
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});

		revisarFirmaButton.addActionListener(e -> {
			String cuenta = numeroCuenta.getText().trim();
			// Verificar que la cuenta exista en cuentasAutorizadas.txt
			boolean cuentaEncontrada = false;
			try (BufferedReader reader = new BufferedReader(
					new FileReader("archivosPantallaTransaccional\\libretaAhorros.csv"))) {
				String line;
				while ((line = reader.readLine()) != null) {
					String[] datos = line.split(",");
					if (datos[0].equals(cuenta)) {
						cuentaEncontrada = true;
						break;
					}
				}
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, "Error al leer el archivo de cuentas.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (!cuentaEncontrada) {
				JOptionPane.showMessageDialog(null, "Cuenta no encontrada. Verifique el número de cuenta.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			String imagePath = "archivosPantallaTransaccional\\firmas\\" + cuenta + ".jpg";
			// proyecto

			// Verificar si la imagen existe en el directorio del proyecto
			File imageFile = new File(imagePath);

			if (!imageFile.exists()) {
				JOptionPane.showMessageDialog(null, "Firma no encontrada para la cuenta " + cuenta, "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Crear ventana emergente para la firma
			JDialog firmaDialog = new JDialog();
			firmaDialog.setTitle("Verificación de Firma");
			firmaDialog.setSize(400, 400);
			firmaDialog.setLayout(new BorderLayout());
			firmaDialog.setLocationRelativeTo(null);

			// Intentar cargar la imagen
			try {
				BufferedImage img = ImageIO.read(imageFile);
				Image dimg = img.getScaledInstance(350, 250, Image.SCALE_SMOOTH);
				ImageIcon firmaIcono = new ImageIcon(dimg);
				JLabel imagenFirma = new JLabel(firmaIcono, JLabel.CENTER);

				// Etiqueta superior
				JLabel label = new JLabel("Firma del titular de la cuenta:", JLabel.CENTER);
				label.setFont(new Font("Tahoma", Font.BOLD, 14));

				// Botón "Firma Correcta"
				JButton btnCorrecta = new JButton("Sí, es correcta");
				btnCorrecta.addActionListener(ev -> {
					JOptionPane.showMessageDialog(null, "Firma validada correctamente.", "Éxito",
							JOptionPane.INFORMATION_MESSAGE);
					pagarRetirButton.setEnabled(true);
					firmaDialog.dispose();
				});

				// Botón "Firma Incorrecta"
				JButton btnIncorrecta = new JButton("No, no es correcta");
				btnIncorrecta.addActionListener(ev -> {
					JOptionPane.showMessageDialog(null, "Firma incorrecta. No se puede continuar con el retiro.",
							"Error", JOptionPane.ERROR_MESSAGE);
					pagarRetirButton.setEnabled(false);
					firmaDialog.dispose();
				});

				// Panel para los botones
				JPanel panelBotones = new JPanel();
				panelBotones.add(btnCorrecta);
				panelBotones.add(btnIncorrecta);

				// Agregar componentes a la ventana
				firmaDialog.add(label, BorderLayout.NORTH);
				firmaDialog.add(imagenFirma, BorderLayout.CENTER);
				firmaDialog.add(panelBotones, BorderLayout.SOUTH);

				// Mostrar ventana
				firmaDialog.setVisible(true);

			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, "Error al cargar la firma.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});

		pagarRetirButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String cuenta = numeroCuenta.getText();
				String montoIngresado = montoRetiro.getText();
				double monto;

				try {
					monto = Double.parseDouble(montoIngresado.replace(",", "."));
					if (monto <= 0) {
						JOptionPane.showMessageDialog(null, "El monto debe ser mayor a 0.", "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					// **Validar si hay suficiente dinero en el cajero antes de continuar**
					if (validarDineroCaja(cajero001, monto)) {
						return;
					}

					// **Leer y validar el saldo real de la cuenta desde el archivo CSV**
					boolean cuentaEncontrada = false;
					double saldoDisponible = Double.parseDouble(ultimoSaldo.getText().replace(",", "."));
					List<String> lineasActualizadas = new ArrayList<>();

					try (BufferedReader reader = new BufferedReader(
							new FileReader("archivosPantallaTransaccional\\libretaAhorros.csv"))) {
						String line;
						while ((line = reader.readLine()) != null) {
							String[] datos = line.split(",");
							if (datos[0].equals(cuenta)) {
								cuentaEncontrada = true;
								saldoDisponible = Double.parseDouble(datos[1]); // Obtener saldo actual
								if (saldoDisponible < monto) {
									JOptionPane.showMessageDialog(null,
											"No se puede realizar el retiro, saldo insuficiente.",
											"Error", JOptionPane.ERROR_MESSAGE);
									return;
								}
								// Actualizar saldo después del retiro
								datos[1] = String.valueOf(saldoDisponible - monto);
								ultimoSaldo.setText(datos[1]);
							}
							// Guardamos la línea actualizada o sin cambios
							lineasActualizadas.add(String.join(",", datos));
						}

						// Reescribir el archivo CSV con las líneas actualizadas
						try (BufferedWriter writer = new BufferedWriter(
								new FileWriter("archivosPantallaTransaccional\\libretaAhorros.csv"))) {
							for (String nuevaLinea : lineasActualizadas) {
								writer.write(nuevaLinea);
								writer.newLine();
							}
						}
					} catch (IOException ex) {
						JOptionPane.showMessageDialog(null, "Error al leer el archivo de cuentas.", "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					if (!cuentaEncontrada) {
						JOptionPane.showMessageDialog(null, "Cuenta no encontrada. Verifique el número de cuenta.",
								"Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					JOptionPane.showMessageDialog(null, "El retiro se realizó con éxito.", "Éxito",
							JOptionPane.INFORMATION_MESSAGE);

					// **Registrar el egreso en el cajero después de validar**
					cajero001.registrarTransaccion(false, monto, intitucionSeleccionada, getOpcionSeleccionada());

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Ingrese un monto válido (solo números).", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		JLabel lblLineaImpresion = new JLabel(""); // El JLabel para mostrar la línea de impresión
		lblLineaImpresion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLineaImpresion.setBounds(220, 400, 450, 30); // Ajusta la posición según tu diseño
		rightPanel.add(lblLineaImpresion);

		lineaAImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String lineaSeleccionada = lineaAImprimir.getText(); // Si usas un JTextField para la línea a imprimir
				String archivoCsv = "archivosPantallaTransaccional\\libretaAhorros.csv"; // Ruta del archivo CSV

				try (BufferedReader br = new BufferedReader(new FileReader(archivoCsv))) {
					String line;
					boolean cuentaEncontrada = false;

					// Leer cada línea del CSV
					while ((line = br.readLine()) != null) {
						String[] datos = line.split(",");
						// Verificar si el número de cuenta ingresado coincide
						if (datos[3].equals(lineaSeleccionada)) {
							cuentaEncontrada = true;

							// Verificar si la línea seleccionada está dentro de los límites (1-5)
							int linea = Integer.parseInt(lineaSeleccionada);
							if (linea >= 1 && linea <= 15) {
								// Actualizar el JLabel con la línea a imprimir correspondiente
								lblLineaImpresion.setText((datos[3] + "----" + datos[4] + "----" + datos[1]));
							}
							break;
						}
					}

					if (!cuentaEncontrada) {
						lblLineaImpresion.setText("Linea no encontrada.");
					}

				} catch (IOException ex) {
					ex.printStackTrace();
				} catch (NumberFormatException ex) {
					lblLineaImpresion.setText("Número de línea inválido.");
				}
			}
		});

	}

	/**
	 * Muestra la interfaz y gestiona el pago de revisión vehicular.
	 * Consulta la placa del vehículo y permite procesar el pago.
	 */
	public void revisionVehicular() {
		JLabel lblNewLabel = new JLabel("Placa del Vehiculo:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(172, 126, 199, 34);
		rightPanel.add(lblNewLabel);

		JTextField placaDelVehiculo = new JTextField();
		placaDelVehiculo.setBounds(385, 131, 199, 29);
		rightPanel.add(placaDelVehiculo);
		placaDelVehiculo.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Pago de Revisión Vehicular");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(243, 51, 451, 47);
		rightPanel.add(lblNewLabel_1);

		JButton consultarButton = new JButton("Consultar");
		consultarButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		consultarButton.setBounds(172, 476, 187, 47);
		rightPanel.add(consultarButton);

		JButton btnPagarRevisinVehicular = new JButton("Pagar Revisión Vehicular");
		btnPagarRevisinVehicular.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPagarRevisinVehicular.setBounds(385, 476, 199, 47);
		rightPanel.add(btnPagarRevisinVehicular);

		JLabel nombrePropLabel = new JLabel("Propietario: ");
		nombrePropLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nombrePropLabel.setBounds(172, 180, 300, 30);
		rightPanel.add(nombrePropLabel);

		JLabel direccionLabel = new JLabel("Marca: ");
		direccionLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		direccionLabel.setBounds(172, 220, 400, 30);
		rightPanel.add(direccionLabel);

		JLabel categoriaLabel = new JLabel("Modelo: ");
		categoriaLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		categoriaLabel.setBounds(172, 260, 200, 30);
		rightPanel.add(categoriaLabel);

		JLabel anioLabel = new JLabel("Año: ");
		anioLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		anioLabel.setBounds(172, 300, 200, 30);
		rightPanel.add(anioLabel);

		JLabel montoLabel = new JLabel("Monto: ");
		montoLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		montoLabel.setBounds(172, 380, 200, 30);
		rightPanel.add(montoLabel);

		JLabel fechaLabel = new JLabel("Fecha: ");
		fechaLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		fechaLabel.setBounds(172, 340, 200, 30);
		rightPanel.add(fechaLabel);

		consultarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String numeroIngresado = placaDelVehiculo.getText().trim();

				if (numeroIngresado.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.");
					return;
				}

				try (BufferedReader br = new BufferedReader(
						new FileReader("archivosPantallaTransaccional\\vehiculos.csv"))) {
					String linea;
					boolean encontrado = false;
					while ((linea = br.readLine()) != null) {
						String[] datos = linea.split(",");
						if (datos[0].equals(numeroIngresado)) {
							nombrePropLabel.setText("Propietario:       " + datos[1]);
							direccionLabel.setText("Marca:             " + datos[2]);
							categoriaLabel.setText("Modelo:            " + datos[3]);
							anioLabel.setText("Año:                " + datos[4]);
							fechaLabel.setText("Fecha:              " + datos[5]);
							montoLabel.setText("Monto:             " + datos[6]);
							encontrado = true;
						}
					}

					if (!encontrado) {
						JOptionPane.showMessageDialog(null, "No se encontró información para el número ingresado.");
					}
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(null, "Error al leer el archivo de impuestos.");
				}
			}
		});

		btnPagarRevisinVehicular.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String texto = montoLabel.getText();
				Pattern pattern = Pattern.compile("\\d+\\.\\d+"); // Busca un número decimal
				Matcher matcher = pattern.matcher(texto);

				double monto = 0;
				if (matcher.find()) {
					monto = Double.parseDouble(matcher.group()); // Extrae el número y lo convierte
				}

				cajero001.registrarTransaccion(true, monto, intitucionSeleccionada, getOpcionSeleccionada());

				JOptionPane.showMessageDialog(null, "Pago realizado con éxito.");
			}
		});

	}

	/**
	 * Muestra la interfaz y gestiona el pago de planilla eléctrica de EEQ.
	 * Consulta la deuda pendiente y permite realizar el pago correspondiente.
	 */
	public void planillasEEQ() {
		JLabel lblNewLabel = new JLabel("N° De Suministro:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(172, 126, 199, 34);
		rightPanel.add(lblNewLabel);

		JTextField numeroDeSuministro = new JTextField();
		numeroDeSuministro.setBounds(385, 131, 199, 29);
		rightPanel.add(numeroDeSuministro);
		numeroDeSuministro.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Pago de Planillas de EEQ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(243, 51, 451, 47);
		rightPanel.add(lblNewLabel_1);

		JButton consultarButton = new JButton("Consultar");
		consultarButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		consultarButton.setBounds(172, 476, 187, 47);
		rightPanel.add(consultarButton);

		JButton pagarPlanillaButton = new JButton("Pagar Planilla de EEQ");
		pagarPlanillaButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pagarPlanillaButton.setBounds(391, 476, 193, 47);
		rightPanel.add(pagarPlanillaButton);

		JLabel nombrePropLabel = new JLabel("Nombre: ");
		nombrePropLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nombrePropLabel.setBounds(172, 180, 300, 30);
		rightPanel.add(nombrePropLabel);

		JLabel direccionLabel = new JLabel("Dirección: ");
		direccionLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		direccionLabel.setBounds(172, 220, 400, 30);
		rightPanel.add(direccionLabel);

		JLabel categoriaLabel = new JLabel("Tipo Propiedad: ");
		categoriaLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		categoriaLabel.setBounds(172, 260, 200, 30);
		rightPanel.add(categoriaLabel);

		JLabel anioLabel = new JLabel("Mes de pago: ");
		anioLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		anioLabel.setBounds(172, 300, 200, 30);
		rightPanel.add(anioLabel);

		JLabel montoLabel = new JLabel("Monto a pagar: ");
		montoLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		montoLabel.setBounds(172, 340, 200, 30);
		rightPanel.add(montoLabel);

		consultarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String numeroIngresado = numeroDeSuministro.getText().trim();

				if (numeroIngresado.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.");
					return;
				}

				try (BufferedReader br = new BufferedReader(
						new FileReader("archivosPantallaTransaccional\\planillas.csv"))) {
					String linea;
					boolean encontrado = false;
					while ((linea = br.readLine()) != null) {
						String[] datos = linea.split(",");
						if ((datos[0].equals(numeroIngresado))) {
							nombrePropLabel.setText("Nombre:            " + datos[1]);
							direccionLabel.setText("Dirección:           " + datos[2]);
							categoriaLabel.setText("Tipo Propiedad:    " + datos[3]);
							anioLabel.setText("Mes de pago:      " + datos[4]);
							montoLabel.setText("Monto a pagar:    " + datos[5]);
							encontrado = true;
						}
					}

					if (!encontrado) {
						JOptionPane.showMessageDialog(null, "No se encontró información para el número ingresado.");
					}
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(null, "Error al leer el archivo de impuestos.");
				}
			}
		});

		pagarPlanillaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String texto = montoLabel.getText();
				Pattern pattern = Pattern.compile("\\d+\\.\\d+"); // Busca un número decimal
				Matcher matcher = pattern.matcher(texto);

				double monto = 0;
				if (matcher.find()) {
					monto = Double.parseDouble(matcher.group()); // Extrae el número y lo convierte
				}

				cajero001.registrarTransaccion(true, monto, intitucionSeleccionada, getOpcionSeleccionada());

				JOptionPane.showMessageDialog(null, "Pago realizado con éxito.");
			}
		});

	}

	/**
	 * Muestra la interfaz y gestiona el pago de impuesto predial.
	 * Consulta los valores adeudados y permite procesar el pago.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void impuestoPredial() {

		JLabel lblNewLabel = new JLabel("Número de");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(172, 126, 94, 34);
		rightPanel.add(lblNewLabel);

		JTextField numeroConsultado = new JTextField();
		numeroConsultado.setBounds(385, 131, 199, 29);
		rightPanel.add(numeroConsultado);
		numeroConsultado.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Pago de Impuesto Predial");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(229, 51, 451, 47);
		rightPanel.add(lblNewLabel_1);

		JButton consultarButton = new JButton("Consultar");
		consultarButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		consultarButton.setBounds(172, 476, 187, 47);
		rightPanel.add(consultarButton);

		JButton pagarImpuestButton = new JButton("Pagar Impuesto Predial");
		pagarImpuestButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pagarImpuestButton.setBounds(391, 476, 193, 47);
		rightPanel.add(pagarImpuestButton);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Predio", "Cédula" }));
		comboBox.setBounds(260, 132, 95, 22);
		rightPanel.add(comboBox);

		JLabel nombrePropLabel = new JLabel("Nombre: ");
		nombrePropLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nombrePropLabel.setBounds(172, 180, 300, 30);
		rightPanel.add(nombrePropLabel);

		JLabel direccionLabel = new JLabel("Dirección: ");
		direccionLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		direccionLabel.setBounds(172, 220, 400, 30);
		rightPanel.add(direccionLabel);

		JLabel categoriaLabel = new JLabel("Categoría: ");
		categoriaLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		categoriaLabel.setBounds(172, 260, 200, 30);
		rightPanel.add(categoriaLabel);

		JLabel anioLabel = new JLabel("Año: ");
		anioLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		anioLabel.setBounds(172, 300, 200, 30);
		rightPanel.add(anioLabel);

		JLabel montoLabel = new JLabel("Monto: ");
		montoLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		montoLabel.setBounds(172, 340, 200, 30);
		rightPanel.add(montoLabel);

		consultarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String seleccion = comboBox.getSelectedItem().toString();
				String numeroIngresado = numeroConsultado.getText().trim();

				if (numeroIngresado.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.");
					return;
				}

				try (BufferedReader br = new BufferedReader(
						new FileReader("archivosPantallaTransaccional\\impuestos.csv"))) {

					String linea;
					boolean encontrado = false;
					while ((linea = br.readLine()) != null) {
						String[] datos = linea.split(",");
						if ((seleccion.equals("Predio") && datos[0].equals(numeroIngresado)) ||
								(seleccion.equals("Cédula") && datos[1].equals(numeroIngresado))) {
							nombrePropLabel.setText("Nombre:     " + datos[2]);
							direccionLabel.setText("Dirección:    " + datos[3]);
							categoriaLabel.setText("Categoría:    " + datos[4]);
							anioLabel.setText("Año:           " + datos[5]);
							montoLabel.setText("Monto:        " + datos[6]);

							encontrado = true;
						}
					}

					if (!encontrado) {
						JOptionPane.showMessageDialog(null, "No se encontró información para el número ingresado.");
					}
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(null, "Error al leer el archivo de impuestos.");
				}

			}

		});

		pagarImpuestButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String texto = montoLabel.getText();
				Pattern pattern = Pattern.compile("\\d+\\.\\d+"); // Busca un número decimal
				Matcher matcher = pattern.matcher(texto);

				double monto = 0;
				if (matcher.find()) {
					monto = Double.parseDouble(matcher.group()); // Extrae el número y lo convierte
				}

				cajero001.registrarTransaccion(true, monto, intitucionSeleccionada, getOpcionSeleccionada());
				JOptionPane.showMessageDialog(null, "Pago realizado con éxito.");
			}
		});
	}

	/**
	 * Muestra la interfaz y gestiona el proceso de cierre de caja.
	 * Revisa las transacciones realizadas y cierra el turno del cajero.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void cierreDeCaja() {

		LocalTime horaActual = LocalTime.now();
		LocalDate fechaActual = LocalDate.now();

		JLabel lblNewLabel = new JLabel("Fecha:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(236, 143, 92, 19);
		rightPanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Cierre de Caja");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(292, 26, 187, 47);
		rightPanel.add(lblNewLabel_1);

		JButton generarReporteButton = new JButton("Generar Reporte en PDF");
		generarReporteButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		generarReporteButton.setBounds(276, 450, 216, 57);
		rightPanel.add(generarReporteButton);

		JLabel lblNewLabel_2 = new JLabel("Codigo del cajero:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(236, 189, 122, 19);
		rightPanel.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1_2 = new JLabel("Hora:");
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_2.setBounds(236, 287, 92, 19);
		rightPanel.add(lblNewLabel_2_1_2);

		JLabel lblNewLabel_2_1 = new JLabel("Nombre:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(236, 333, 122, 19);
		rightPanel.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("Horario:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1.setBounds(236, 236, 92, 19);
		rightPanel.add(lblNewLabel_2_1_1);

		JTextField fecha = new JTextField();
		fecha.setEnabled(false);
		fecha.setBounds(372, 144, 136, 20);
		rightPanel.add(fecha);
		fecha.setText(fechaActual + "");
		fecha.setColumns(10);

		JTextField horario = new JTextField();
		horario.setEnabled(false);
		horario.setColumns(10);
		horario.setBounds(372, 237, 136, 20);
		rightPanel.add(horario);

		JTextField nombre = new JTextField();
		nombre.setEnabled(false);
		nombre.setColumns(10);
		nombre.setBounds(372, 329, 136, 20);
		rightPanel.add(nombre);

		JTextField hora = new JTextField();
		hora.setEnabled(false);
		hora.setColumns(10);
		hora.setBounds(372, 287, 136, 20);
		rightPanel.add(hora);
		hora.setText(horaActual + "");

		JComboBox codigo = new JComboBox();
		codigo.setModel(new DefaultComboBoxModel(new String[] { "C0001", "C0002" }));
		codigo.setBounds(372, 189, 136, 22);
		rightPanel.add(codigo);

		JLabel lblNewLabel_2_1_3 = new JLabel("Detalles por institución en el PDF");
		lblNewLabel_2_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_3.setBounds(236, 382, 243, 19);
		rightPanel.add(lblNewLabel_2_1_3);

		codigo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Obtener el elemento seleccionado y establecerlo en el JTextField
				if ((codigo.getSelectedItem().equals(cajero001.getCodigo()))) {
					horario.setText(cajero001.getHorario());
					nombre.setText(cajero001.getNombre());

				} else {
					horario.setText(cajero002.getHorario());
					nombre.setText(cajero002.getNombre());
				}

			}
		});

		generarReporteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Cajero cajero = cajero001;
				if ((codigo.getSelectedItem().equals(cajero001.getCodigo()))) {
					cajero = cajero001;
				} else {
					cajero = cajero002;
				}

				Supervisor rep = new Supervisor("Ing. Lopez", "S0001", "Normal", cajero);
				rep.generarReporteCierreCaja("archivosPantallaTransaccional\\transacciones.csv");

			}

		});

	}

	/**
	 * Genera un reporte de nómina basado en las transacciones del día.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void nominaReporte() {
		LocalTime horaActual = LocalTime.now();
		LocalDate fechaActual = LocalDate.now();

		JLabel lblNewLabel = new JLabel("Fecha:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(95, 101, 92, 19);
		rightPanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nómina de Caja");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(292, 26, 187, 47);
		rightPanel.add(lblNewLabel_1);

		JButton generarReporteButton = new JButton("Generar nómina en PDF");
		generarReporteButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		generarReporteButton.setBounds(255, 510, 207, 30);
		rightPanel.add(generarReporteButton);

		JLabel lblNewLabel_2 = new JLabel("Codigo del cajero:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(95, 147, 122, 19);
		rightPanel.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1_2 = new JLabel("Hora:");
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_2.setBounds(421, 105, 92, 19);
		rightPanel.add(lblNewLabel_2_1_2);

		JLabel lblNewLabel_2_1 = new JLabel("Nombre:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(421, 151, 122, 19);
		rightPanel.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("Horario:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1.setBounds(95, 194, 92, 19);
		rightPanel.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("Tot. Disponible:");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1_1.setBounds(95, 238, 122, 19);
		rightPanel.add(lblNewLabel_2_1_1_1);

		JLabel lblNewLabel_2_1_1_2 = new JLabel("Tot. Verificado:");
		lblNewLabel_2_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1_2.setBounds(421, 194, 110, 19);
		rightPanel.add(lblNewLabel_2_1_1_2);

		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Faltante:");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1_1_1.setBounds(421, 238, 92, 19);
		rightPanel.add(lblNewLabel_2_1_1_1_1);

		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("Sobrante:");
		lblNewLabel_2_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1_1_1_1.setBounds(421, 280, 92, 19);
		rightPanel.add(lblNewLabel_2_1_1_1_1_1);

		JLabel lblNewLabel_2_1_1_1_1_1_1 = new JLabel("Detalles del dinero físico:");
		lblNewLabel_2_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1_1_1_1_1.setBounds(95, 284, 187, 19);
		rightPanel.add(lblNewLabel_2_1_1_1_1_1_1);

		JTextField fecha = new JTextField();
		fecha.setEnabled(false);
		fecha.setBounds(231, 102, 136, 20);
		rightPanel.add(fecha);
		fecha.setText(fechaActual + "");
		fecha.setColumns(10);

		JTextField horario = new JTextField();
		horario.setEnabled(false);
		horario.setColumns(10);
		horario.setBounds(231, 195, 136, 20);
		rightPanel.add(horario);

		JTextField totalD = new JTextField();
		totalD.setEnabled(false);
		totalD.setColumns(10);
		totalD.setBounds(231, 239, 136, 20);
		rightPanel.add(totalD);

		JTextField totalV = new JTextField();
		totalV.setEnabled(false);
		totalV.setColumns(10);
		totalV.setBounds(534, 195, 136, 20);
		rightPanel.add(totalV);

		JTextField nombre = new JTextField();
		nombre.setEnabled(false);
		nombre.setColumns(10);
		nombre.setBounds(534, 148, 136, 20);
		rightPanel.add(nombre);

		JTextField hora = new JTextField();
		hora.setEnabled(false);
		hora.setColumns(10);
		hora.setBounds(534, 106, 136, 20);
		rightPanel.add(hora);
		hora.setText(horaActual + "");

		JTextField faltante = new JTextField();
		faltante.setEnabled(false);
		faltante.setColumns(10);
		faltante.setBounds(534, 239, 136, 20);
		rightPanel.add(faltante);

		JTextField sobrante = new JTextField();
		sobrante.setEnabled(false);
		sobrante.setColumns(10);
		sobrante.setBounds(534, 281, 136, 20);
		rightPanel.add(sobrante);

		JComboBox codigo = new JComboBox();
		codigo.setModel(new DefaultComboBoxModel(new String[] { "C0001", "C0002" }));
		codigo.setBounds(231, 147, 136, 22);
		rightPanel.add(codigo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(95, 337, 574, 161);
		rightPanel.add(scrollPane);

		codigo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Obtener el elemento seleccionado y establecerlo en el JTextField
				if ((codigo.getSelectedItem().equals(cajero001.getCodigo()))) {
					horario.setText(cajero001.getHorario());
					nombre.setText(cajero001.getNombre());
					totalD.setText(cajero001.getDineroCaja() + "");
					generarTabla(cajero001, scrollPane);
					totalV.setText(getTotalVerificado() + "");
					faltante.setText(getFaltante() + "");
					sobrante.setText((getTotalVerificado() - cajero001.getDineroCaja()) + "");

				} else {
					horario.setText(cajero002.getHorario());
					nombre.setText(cajero002.getNombre());
					totalD.setText(cajero002.getDineroCaja() + "");
					generarTabla(cajero002, scrollPane);
					totalV.setText(getTotalVerificado() + "");
					faltante.setText(getFaltante() + "");
					sobrante.setText((getTotalVerificado() - cajero002.getDineroCaja()) + "");
				}

			}
		});

		generarReporteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Cajero cajero = cajero001;
				if ((codigo.getSelectedItem().equals(cajero001.getCodigo()))) {
					cajero = cajero001;
				} else {
					cajero = cajero002;
				}

				Supervisor rep = new Supervisor("Ing. Lopez", "S0001", "Normal", cajero);
				rep.generarReporteNomina(cajero);

			}

		});
	}

	/**
	 * Valida si el cajero tiene suficiente dinero en la caja para realizar la
	 * transacción.
	 * Muestra un mensaje de error si los fondos son insuficientes.
	 * y direccioona al metodo Ingreso de Caja
	 * 
	 * @param cajero Cajero que realizará la transacción.
	 * @param monto  Monto que se desea retirar o transferir.
	 * @return true si hay suficiente dinero, false en caso contrario.
	 */

	boolean validarDineroCaja(Cajero caja, Double monto) {
		if (caja.getDineroCaja() < monto) {
			JFrame frame = new JFrame("Error");
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setSize(300, 180);
			frame.setLayout(null); // Usamos diseño absoluto (bounds)

			JLabel errorLabel = new JLabel("Dinero insuficiente en el cajero", SwingConstants.CENTER);
			errorLabel.setBounds(30, 20, 240, 25);

			JButton btnPedirDinero = new JButton("Pedir dinero");
			btnPedirDinero.setBounds(90, 80, 120, 40); // Posición y tamaño exactos

			btnPedirDinero.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					rightPanel.removeAll();
					ingresoDeCaja();
					rightPanel.revalidate();
					rightPanel.repaint();
					frame.setVisible(false);

				}
			});
			frame.add(errorLabel);
			frame.add(btnPedirDinero);

			frame.setLocationRelativeTo(null); // Centrar en la pantalla
			frame.setVisible(true);

		} else {

		}
		return false;
	}

	/**
	 * Genera y muestra una tabla con los datos de transacciones del cajero en el
	 * `JScrollPane` proporcionado.
	 * Extrae la información del cajero y la presenta en un formato tabular dentro
	 * de la interfaz gráfica.
	 *
	 * @param cajero     Objeto `Cajero` del cual se obtendrán los datos de
	 *                   transacción.
	 * @param scrollPane Componente `JScrollPane` donde se insertará la tabla
	 *                   generada.
	 */
	public void generarTabla(Cajero cajero, JScrollPane scrollPane) {
		try {
			String archivoCSV = "archivosPantallaTransaccional/denominaciones.csv";
			File archivo = new File(archivoCSV);

			if (!archivo.exists()) {
				JOptionPane.showMessageDialog(null, "Por favor registre la nómina", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			BufferedReader br = new BufferedReader(new FileReader(archivoCSV));
			String linea;

			List<Object[]> datosTabla = new ArrayList<>();
			double totalVerificado = 0; // Inicializar total verificado

			while ((linea = br.readLine()) != null) {
				String[] datos = linea.split(",");

				if (datos.length != 4) {
					JOptionPane.showMessageDialog(null, "Línea inválida en el CSV", "Error", JOptionPane.ERROR_MESSAGE);
					continue;
				}

				String codigoCajero = datos[0].trim();
				String denominacion = datos[1].trim();
				String valorStr = datos[2].trim();
				String cantidadStr = datos[3].trim();

				if (codigoCajero.equalsIgnoreCase(cajero.getCodigo().trim())) {
					try {
						double valor = Double.parseDouble(valorStr);
						int cantidad = Integer.parseInt(cantidadStr);

						totalVerificado += valor * cantidad;
						datosTabla.add(new Object[] { denominacion, valor, cantidad });
					} catch (NumberFormatException e) {
					}
				}
			}
			br.close();

			// Calcular el faltante
			double faltante = cajero.getDineroCaja() - totalVerificado;

			// Crear tabla con los datos
			String[] columnas = { "Denominación", "Valor", "Cantidad" };
			DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

			for (Object[] fila : datosTabla) {
				modelo.addRow(fila);
			}

			JTable tabla = new JTable(modelo);

			// Actualizar el JScrollPane con la nueva tabla
			scrollPane.setViewportView(tabla);

			setTotalVerificado(totalVerificado);
			setFaltante(faltante);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
