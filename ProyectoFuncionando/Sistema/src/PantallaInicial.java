
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

public class PantallaInicial extends javax.swing.JFrame {
    /**
     * Constructor de la clase PantallaInicial.
     * Inicializa los componentes de la interfaz gráfica y carga una imagen en jLabel2.
     */
    public PantallaInicial() {
        initComponents();
        jLabel2.setIcon(new ImageIcon(new ImageIcon("archivosPrestamos\\click1.png").getImage()
                .getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_SMOOTH)));
    }
    /**
     * Método para inicializar y configurar los componentes de la interfaz gráfica.
     * Define el diseño de la ventana, sus botones, etiquetas y paneles.
     */
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(1000, 650);
        setLocationRelativeTo(null);

        jPanel1.setBackground(new java.awt.Color(204, 203, 189));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Elephant", 1, 95));
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("ClickPago");
        jLabel1.setBounds(150, 140, 550, 150);
        jPanel1.add(jLabel1);

        jLabel2.setBounds(700, 140, 120, 120);
        jPanel1.add(jLabel2);

        jButton1.setFont(new java.awt.Font("Dialog", 1, 22));
        jButton1.setText("Módulo Transaccional");
        jButton1.setBounds(80, 350, 280, 55);
        jButton1.addActionListener(evt -> jButton1ActionPerformed(evt));
        jPanel1.add(jButton1);

        jButton2.setFont(new java.awt.Font("Dialog", 1, 22));
        jButton2.setText("Módulo de Préstamos");
        jButton2.setBounds(380, 350, 280, 55);
        jButton2.addActionListener(evt -> jButton2ActionPerformed(evt));
        jPanel1.add(jButton2);

        jButton3.setFont(new java.awt.Font("Dialog", 1, 22));
        jButton3.setText("Salir");
        jButton3.setBounds(700, 350, 180, 55);
        jButton3.addActionListener(evt -> jButton3ActionPerformed(evt));
        jPanel1.add(jButton3);

        getContentPane().setLayout(null);
        jPanel1.setBounds(0, 0, 1000, 650);
        getContentPane().add(jPanel1);
    }
    /**
     * Método que se ejecuta cuando se presiona el botón "Módulo Transaccional".
     * Abre la ventana GUIModuloTransaccional y cierra la pantalla actual.
     *
     * @param evt Evento de acción generado al presionar el botón.
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

        SwingUtilities.invokeLater(() -> {
            new GUIModuloTransaccional().setVisible(true);
            this.dispose();
        });

    }
    /**
     * Método que se ejecuta cuando se presiona el botón "Módulo de Préstamos".
     * Abre la ventana Prestamo y cierra la pantalla actual.
     *
     * @param evt Evento de acción generado al presionar el botón.
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        SwingUtilities.invokeLater(() -> {
            new Prestamo().setVisible(true);
            this.dispose();
        });
    }

    /**
     * Método que se ejecuta cuando se presiona el botón "Salir".
     * Abre la ventana de Login y cierra la pantalla actual.
     *
     * @param evt Evento de acción generado al presionar el botón.
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        Login lg = new Login();
        lg.setVisible(true);
        this.dispose();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new PantallaInicial().setVisible(true));
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
}
