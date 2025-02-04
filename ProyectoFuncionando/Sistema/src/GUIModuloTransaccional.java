import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;

/**
 * Interfaz gráfica del módulo transaccional del sistema bancario.
 * Permite la navegación y ejecución de diversas operaciones financieras
 * mediante un menú interactivo.
 * Integra cajeros y una bóveda para la gestión de dinero en efectivo.
 * 
 * @author Grupo 3
 * @version 1.0.0
 */

public class GUIModuloTransaccional extends JFrame {
	private DefaultMutableTreeNode root;
	private DefaultTreeModel treeModel;
	private JPanel rightPanel;
	private JLabel infoLabel;
	private String institucionSeleccionada = "Banco de los Andes"; // Institución por defecto
	private Institucion institucion = new Institucion(institucionSeleccionada);
	private String categoriaSeleccionada = "Todas"; // Filtro del menú horizontal
	private JLabel lblEstado; // Muestra (institución / opción seleccionada)
	private JTree menuVertical;
	private Boveda boveda = new Boveda(1000000);
	private Cajero cajero = new Cajero("C0001", LoginLogic.getUser(), "Normal", 10000);
	private Cajero cajeroDos = new Cajero("C0002", "Juan Maldonado", "Diferido", 10000);

	/**
	 * Constructor de la clase GUIModuloTransaccional.
	 * Inicializa la interfaz gráfica, configura el menú y los eventos de
	 * interacción.
	 * Crea instancias de cajeros y una bóveda con valores iniciales.
	 */
	public GUIModuloTransaccional() {
		setTitle("Módulo Transaccional");
		setSize(1000, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// Menú horizontal con botones
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		agregarBotonMenu(toolBar, "Todas");
		agregarBotonMenu(toolBar, "Caja");
		agregarBotonMenu(toolBar, "Pagos");
		agregarBotonMenu(toolBar, "Cobros");
		agregarBotonMenu(toolBar, "Reportes");

		// Panel para mostrar el estado actual
		JPanel panelEstado = new JPanel(new FlowLayout(FlowLayout.LEFT));
		lblEstado = new JLabel(institucionSeleccionada + " / "); // Inicializar con la institución
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblEstado.setForeground(Color.GRAY);
		panelEstado.add(lblEstado);

		// Agregar el panelEstado a la parte superior
		getContentPane().add(panelEstado, BorderLayout.SOUTH);

		// Botón de salir
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBorderPainted(false); // Quita el borde
		btnSalir.setFocusPainted(false);
		btnSalir.addActionListener(e -> {
			SwingUtilities.invokeLater(() -> {
				new PantallaInicial().setVisible(true);
				this.dispose();
			});
		});

		getContentPane().add(toolBar, BorderLayout.NORTH);

		// Panel principal dividido
		JSplitPane mainSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		mainSplitPane.setDividerLocation(255);
		getContentPane().add(mainSplitPane);

		// Panel izquierdo
		JPanel leftPanel = new JPanel(new BorderLayout());
		mainSplitPane.setLeftComponent(leftPanel);

		// Lista de instituciones financieras
		String[] instituciones = { "Banco de los Andes", "Banco Continental", "Banco del Progreso",
				"Banco la Previsora",
				"Mutualista Benalcázar", "Mutualista Sol Naciente", "Cooperativa Unión Solidaria",
				"Cooperativa Agrícola Ganadera", "Cooperativa 20 de Julio" };
		JList<String> listaInstituciones = new JList<>(instituciones);
		leftPanel.add(new JScrollPane(listaInstituciones), BorderLayout.NORTH);

		// Menú vertical con árbol
		root = new DefaultMutableTreeNode("Menú");
		treeModel = new DefaultTreeModel(root);
		menuVertical = new JTree(treeModel);
		leftPanel.add(new JScrollPane(menuVertical), BorderLayout.CENTER);

		// Panel derecho (contenido dinámico)
		rightPanel = new JPanel(new BorderLayout());
		infoLabel = new JLabel("Seleccione una opción del menú");
		infoLabel.setBounds(300, 220, 187, 47);
		rightPanel.add(infoLabel);
		rightPanel.setLayout(null);
		mainSplitPane.setRightComponent(rightPanel);

		// Cargar menú inicial
		cargarMenuPorInstitucion(institucionSeleccionada);

		// Evento: Cambio de institución
		listaInstituciones.addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) {
				institucionSeleccionada = listaInstituciones.getSelectedValue();
				lblEstado.setText(institucionSeleccionada + " / "); // Actualiza el label
				cargarMenuPorInstitucion(institucionSeleccionada);
			}
		});

		// Evento: Selección en el menú vertical
		menuVertical.addTreeSelectionListener(e -> {
			DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) menuVertical.getLastSelectedPathComponent();
			if (selectedNode != null && selectedNode.isLeaf()) {
				String opcionSeleccionada = selectedNode.getUserObject().toString();
				lblEstado.setText(institucionSeleccionada + " / " + opcionSeleccionada); // Actualiza el label
				actualizarPanelDerecho(opcionSeleccionada);
			}
		});

	}

	/**
	 * Agrega un botón al menú horizontal de categorías.
	 * Permite cambiar la vista de las transacciones disponibles según la categoría
	 * seleccionada.
	 *
	 * @param toolBar Barra de herramientas donde se agregará el botón.
	 * @param nombre  Nombre de la categoría representada por el botón.
	 */
	private void agregarBotonMenu(JToolBar toolBar, String nombre) {
		JButton boton = new JButton(nombre);
		boton.setBorderPainted(false); // Quita el borde
		boton.setFocusPainted(false); // Quita el borde al enfocarse
		boton.addActionListener(e -> {
			categoriaSeleccionada = nombre;
			cargarMenuPorInstitucion(institucionSeleccionada);
		});
		toolBar.add(boton);
	}

	/**
	 * Carga las opciones del menú vertical según la institución financiera
	 * seleccionada.
	 * Agrupa las transacciones en categorías como Caja, Pagos, Cobros y Reportes.
	 * 
	 * @param institucion Nombre de la institución financiera seleccionada.
	 */
	private void cargarMenuPorInstitucion(String institucion) {
		root.removeAllChildren(); // Limpiar el menú

		// Sección fija del menú (siempre visible)
		DefaultMutableTreeNode caja = new DefaultMutableTreeNode("Transacciones de Caja");
		DefaultMutableTreeNode pagos = new DefaultMutableTreeNode("Transacciones de Pagos");
		DefaultMutableTreeNode cobros = new DefaultMutableTreeNode("Transacciones de Cobros");
		DefaultMutableTreeNode reportes = new DefaultMutableTreeNode("Reportes");
		// DefaultMutableTreeNode reportes = new DefaultMutableTreeNode("Reportes");

		caja.add(new DefaultMutableTreeNode("Ingreso de Caja"));
		caja.add(new DefaultMutableTreeNode("Egreso de Caja"));
		caja.add(new DefaultMutableTreeNode("Nómina"));
		reportes.add(new DefaultMutableTreeNode("Cierre de Caja"));
		reportes.add(new DefaultMutableTreeNode("Nómina (Reporte)"));

		// Filtrar según la opción seleccionada en el menú horizontal
		if (categoriaSeleccionada.equals("Todas") || categoriaSeleccionada.equals("Caja"))
			root.add(caja);
		if (categoriaSeleccionada.equals("Todas") || categoriaSeleccionada.equals("Pagos"))
			root.add(pagos);
		if (categoriaSeleccionada.equals("Todas") || categoriaSeleccionada.equals("Cobros"))
			root.add(cobros);
		if (categoriaSeleccionada.equals("Todas") || categoriaSeleccionada.equals("Reportes"))
			root.add(reportes);

		switch (institucion) {
			case "Banco de los Andes":
				agregarDepositos(cobros, true, true, true);
				agregarPagos(pagos, true, true, true);
				agregarRetiros(pagos, true, false);
				agregarCobranzas(cobros, true, false, true, true);
				break;
			case "Banco Continental":
				agregarDepositos(cobros, true, true, true);
				agregarPagos(pagos, true, false, true);
				agregarRetiros(pagos, true, true);
				agregarCobranzas(cobros, true, true, true, false);
				break;

			case "Banco del Progreso":
				agregarDepositos(cobros, true, true, true);
				agregarPagos(pagos, true, true, true);
				agregarRetiros(pagos, true, true);
				agregarCobranzas(cobros, true, false, true, false);
				break;

			case "Banco la Previsora":
				agregarDepositos(cobros, true, true, true);
				agregarPagos(pagos, true, true, true);
				agregarRetiros(pagos, true, true);
				agregarCobranzas(cobros, true, false, true, true);
				break;

			case "Mutualista Benalcázar":
				agregarDepositos(cobros, true, true, true);
				agregarPagos(pagos, true, true, true);
				agregarRetiros(pagos, true, false);
				agregarCobranzas(cobros, false, false, true, false);
				break;

			case "Mutualista Sol Naciente":
				agregarDepositos(cobros, true, true, true);
				agregarPagos(pagos, true, false, true);
				agregarRetiros(pagos, true, false);
				agregarCobranzas(cobros, false, false, true, false);
				break;

			case "Cooperativa Unión Solidaria":
				agregarDepositos(cobros, true, true, true);
				agregarPagos(pagos, false, false, true);
				agregarRetiros(pagos, true, false);
				agregarCobranzas(cobros, true, false, true, false);
				break;

			case "Cooperativa Agrícola Ganadera":
				agregarDepositos(cobros, true, true, true);
				agregarPagos(pagos, false, false, false);
				agregarRetiros(pagos, false, false);
				agregarCobranzas(cobros, false, false, true, false);
				break;

			case "Cooperativa 20 de Julio":
				agregarDepositos(cobros, true, true, true);
				agregarPagos(pagos, false, false, false);
				agregarRetiros(pagos, false, false);
				agregarCobranzas(cobros, false, false, true, true);
				break;

		}

		treeModel.reload();
		for (int i = 0; i < menuVertical.getRowCount(); i++) {
			menuVertical.expandRow(i);
		}
	}

	/**
	 * Agrega las opciones de depósito (efectivo, cheque, mixto) al menú de
	 * transacciones.
	 *
	 * @param parent   Menu padre donde se insertarán las opciones.
	 * @param efectivo Indica si se permite depósito en efectivo.
	 * @param cheques  Indica si se permite depósito en cheques.
	 * @param mixto    Indica si se permite depósito mixto.
	 */
	private void agregarDepositos(DefaultMutableTreeNode parent, boolean efectivo, boolean cheques, boolean mixto) {
		DefaultMutableTreeNode depositos = new DefaultMutableTreeNode("Depósito");
		if (efectivo)
			depositos.add(new DefaultMutableTreeNode("Depósito en Efectivo"));
		if (cheques)
			depositos.add(new DefaultMutableTreeNode("Depósito en Cheques"));
		if (mixto)
			depositos.add(new DefaultMutableTreeNode("Depósito Mixto"));
		if (depositos.getChildCount() > 0)
			parent.add(depositos);
	}

	/**
	 * Agrega las opciones de pago al menú de transacciones.
	 *
	 * @param parent               Menu padre donde se insertarán las opciones.
	 * @param pagoCheques          Indica si se permite el pago de cheques.
	 * @param actualizacionLibreta Indica si se permite la actualización de libreta
	 *                             de ahorro.
	 * @param pagoGiros            Indica si se permite el pago de giros.
	 */
	private void agregarPagos(DefaultMutableTreeNode parent, boolean pagoCheques, boolean actualizacionLibreta,
			boolean pagoGiros) {
		if (pagoCheques)
			parent.add(new DefaultMutableTreeNode("Pago de Cheques"));
		if (actualizacionLibreta)
			parent.add(new DefaultMutableTreeNode("Actualización de Libreta de Ahorro"));
		if (pagoGiros)
			parent.add(new DefaultMutableTreeNode("Pago de Giros"));
	}

	/**
	 * Agrega las opciones de retiro al menú de transacciones.
	 *
	 * @param parent           Menu padre donde se insertarán las opciones.
	 * @param retiroConLibreta Indica si se permite retiro con libreta.
	 * @param retiroSinLibreta Indica si se permite retiro sin libreta.
	 */
	private void agregarRetiros(DefaultMutableTreeNode parent, boolean retiroConLibreta, boolean retiroSinLibreta) {
		DefaultMutableTreeNode retiros = new DefaultMutableTreeNode("Retiro de Ahorros");
		if (retiroConLibreta)
			retiros.add(new DefaultMutableTreeNode("Retiro con Libreta"));
		if (retiroSinLibreta)
			retiros.add(new DefaultMutableTreeNode("Retiro sin Libreta"));
		if (retiros.getChildCount() > 0)
			parent.add(retiros);
	}

	/**
	 * Agrega las opciones de cobros al menú de transacciones.
	 *
	 * @param parent                 Menu padre donde se insertarán las opciones.
	 * @param revisionVehicular      Indica si se permite el pago de revisión
	 *                               vehicular.
	 * @param matriculacionVehicular Indica si se permite el pago de matriculación
	 *                               vehicular.
	 * @param planillasEEQ           Indica si se permite el pago de planilla de
	 *                               EEQ.
	 * @param impuestoPredial        Indica si se permite el pago de impuesto
	 *                               predial.
	 */
	private void agregarCobranzas(DefaultMutableTreeNode parent, boolean revisionVehicular,
			boolean matriculacionVehicular, boolean planillasEEQ, boolean impuestoPredial) {
		DefaultMutableTreeNode cobranzas = new DefaultMutableTreeNode("Cobranzas");
		if (revisionVehicular)
			cobranzas.add(new DefaultMutableTreeNode("Pago de Revisión Vehicular"));
		if (matriculacionVehicular)
			cobranzas.add(new DefaultMutableTreeNode("Pago de Matriculación Vehicular"));
		if (planillasEEQ)
			cobranzas.add(new DefaultMutableTreeNode("Pago de Planilla de EEQ"));
		if (impuestoPredial)
			cobranzas.add(new DefaultMutableTreeNode("Pago de Impuesto Predial"));
		if (cobranzas.getChildCount() > 0)
			parent.add(cobranzas);
	}

	/**
	 * Actualiza el panel derecho de la interfaz según la opción seleccionada en
	 * elmenú.
	 * Llama a la clase `GUIAccionesDeTransaccion` para ejecutar la operación
	 * correspondiente.
	 *
	 * @param opcionSeleccionada Opción elegida por el usuario en el menú vertical.
	 */
	private void actualizarPanelDerecho(String opcionSeleccionada) {
		rightPanel.removeAll(); // Limpiar contenido anterior
		GUIAccionesDeTransaccion accionTransaccion = new GUIAccionesDeTransaccion(opcionSeleccionada, rightPanel,
				institucion, cajero, cajeroDos, boveda);
		accionTransaccion.accionDeLaOpcion();
		rightPanel.revalidate();
		rightPanel.repaint();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new GUIModuloTransaccional().setVisible(true));
	}
}
