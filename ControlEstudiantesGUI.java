import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlEstudiantesGUI extends JFrame {
    private JTextField txtCarnet, txtMaterias, txtCreditos;
    private JTable tableEstudiantes;
    private DefaultTableModel tableModel;
    private ControlEstudiantes control;

    public ControlEstudiantesGUI() {
        control = new ControlEstudiantes();

        // Configuración de la ventana
        setTitle("Control de Estudiantes");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Etiquetas y campos de texto
        JLabel lblCarnet = new JLabel("Carnet:");
        lblCarnet.setBounds(20, 20, 100, 25);
        add(lblCarnet);

        txtCarnet = new JTextField();
        txtCarnet.setBounds(120, 20, 150, 25);
        add(txtCarnet);

        JLabel lblMaterias = new JLabel("Materias:");
        lblMaterias.setBounds(20, 60, 100, 25);
        add(lblMaterias);

        txtMaterias = new JTextField();
        txtMaterias.setBounds(120, 60, 150, 25);
        add(txtMaterias);

        JLabel lblCreditos = new JLabel("Créditos:");
        lblCreditos.setBounds(20, 100, 100, 25);
        add(lblCreditos);

        txtCreditos = new JTextField();
        txtCreditos.setBounds(120, 100, 150, 25);
        add(txtCreditos);

        // Botones
        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(300, 20, 100, 25);
        add(btnAgregar);

        JButton btnResumen = new JButton("Resumen");
        btnResumen.setBounds(300, 60, 100, 25);
        add(btnResumen);

        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(300, 100, 100, 25);
        add(btnLimpiar);

        // Tabla
        tableModel = new DefaultTableModel(new Object[]{"Carnet", "Materias", "Créditos", "Monto a Pagar"}, 0);
        tableEstudiantes = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tableEstudiantes);
        scrollPane.setBounds(20, 150, 540, 200);
        add(scrollPane);

        // Acciones
        btnAgregar.addActionListener(e -> agregarEstudiante());
        btnResumen.addActionListener(e -> mostrarResumen());
        btnLimpiar.addActionListener(e -> limpiarRegistros());
    }

    private void agregarEstudiante() {
        try {
            String carnet = txtCarnet.getText();
            int materias = Integer.parseInt(txtMaterias.getText());
            int creditos = Integer.parseInt(txtCreditos.getText());

            Estudiante estudiante = new Estudiante(carnet, materias, creditos);
            control.agregarEstudiante(estudiante);

            // Agregar a la tabla
            tableModel.addRow(new Object[]{
                    estudiante.getCarnet(),
                    estudiante.getMateriasInscritas(),
                    estudiante.getCreditosInscritos(),
                    estudiante.getMontoPagar()
            });

            // Limpiar campos
            txtCarnet.setText("");
            txtMaterias.setText("");
            txtCreditos.setText("");

            JOptionPane.showMessageDialog(this, "Estudiante agregado correctamente.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese datos válidos.");
        }
    }

    private void mostrarResumen() {
        JOptionPane.showMessageDialog(this, control.generarResumen());
    }

    private void limpiarRegistros() {
        tableModel.setRowCount(0);
        int confirm = JOptionPane.showConfirmDialog(this,
                "¿Desea limpiar también los datos en la base de datos?",
                "Confirmar limpieza",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            control.limpiarBaseDeDatos();
            JOptionPane.showMessageDialog(this, "Registros eliminados correctamente.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ControlEstudiantesGUI().setVisible(true));
    }
}
