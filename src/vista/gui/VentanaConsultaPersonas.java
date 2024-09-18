package vista.gui;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import conector.Coordinador;
import modelo.operaciones.Procesos;
import modelo.vo.EstudianteVO;

public class VentanaConsultaPersonas extends JFrame {

	  private JPanel panelPrincipal;
	    private JTable tablaPersonas;
	    DefaultTableModel modelo;
	    private Coordinador miCoordinador;
	    
	    private JTextField txtDocumento;  // Campo para ingresar el documento
	    private JButton btnConsultar;     // Botón para consultar un estudiante individual
	    
	    public VentanaConsultaPersonas() {
	        setSize(507, 400);
	        setTitle("CONSULTAR ESTUDIANTES");
	        setLocationRelativeTo(null);
	        setResizable(false);
	        iniciarComponentes();
	    }
	    
	    private void iniciarComponentes() {
	        panelPrincipal = new JPanel();
	        panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(panelPrincipal);
	        panelPrincipal.setLayout(null);

	        JLabel lblTitulo = new JLabel("CONSULTAR PERSONAS");
	        lblTitulo.setBackground(Color.black);
	        lblTitulo.setForeground(Color.white);
	        lblTitulo.setOpaque(true);
	        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
	        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 25));
	        lblTitulo.setBounds(0, 0, 499, 50);
	        panelPrincipal.add(lblTitulo);

	        // Campo de texto para ingresar el documento
	        JLabel lblDocumento = new JLabel("Documento:");
	        lblDocumento.setBounds(10, 60, 100, 30);
	        panelPrincipal.add(lblDocumento);
	        
	        txtDocumento = new JTextField();
	        txtDocumento.setBounds(110, 60, 200, 30);
	        panelPrincipal.add(txtDocumento);
	        
	        // Botón de consulta
	        btnConsultar = new JButton("Consultar");
	        btnConsultar.setBounds(320, 60, 100, 30);
	        panelPrincipal.add(btnConsultar);
	        
	        JScrollPane scrollPane = new JScrollPane();
	        scrollPane.setBounds(10, 100, 473, 236);
	        panelPrincipal.add(scrollPane);

	        tablaPersonas = new JTable();
	        scrollPane.setViewportView(tablaPersonas);
	        
	        // Crear el modelo de la tabla
	        crearModelo();
	        
	        // Acción del botón Consultar
	        btnConsultar.addActionListener(e -> consultarEstudiantePorDocumento());
	    }

	    private void crearModelo() {
	        modelo = new DefaultTableModel();
	        modelo.addColumn("Documento");
	        modelo.addColumn("Nombre");
	        modelo.addColumn("Promedio");
	        tablaPersonas.setModel(modelo);
	    }

	    // Llenar la tabla con la lista completa de estudiantes
	    public void llenarTabla() {
	        ArrayList<EstudianteVO> lista = miCoordinador.obtenerTodosEstudiantes();
	        DefaultTableModel model = (DefaultTableModel) tablaPersonas.getModel();
	        model.setRowCount(0);  
	        for (EstudianteVO est : lista) {
	            model.addRow(new Object[]{est.getDocumento(), est.getNombre(), est.getPromedio()});
	        }
	    }

	    // Método para consultar estudiante por documento
	    private void consultarEstudiantePorDocumento() {
	        String documento = txtDocumento.getText();
	        
	        if (documento.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "Por favor, ingrese un documento.", "Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }

	        // Llamar al método del coordinador para obtener un estudiante por documento
	        EstudianteVO estudiante = miCoordinador.obtenerEstudiante(documento);

	        if (estudiante != null) {
	            // Si el estudiante existe, llenamos la tabla con solo ese estudiante
	            DefaultTableModel model = (DefaultTableModel) tablaPersonas.getModel();
	            model.setRowCount(0);  // Limpiamos la tabla
	            model.addRow(new Object[]{estudiante.getDocumento(), estudiante.getNombre(), estudiante.getPromedio()});
	        } else {
	            // Si el estudiante no existe, mostramos un mensaje de error
	            JOptionPane.showMessageDialog(this, "Estudiante no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }

	public void setCoordinador(Coordinador miCoordinador) {
		
		this.miCoordinador = miCoordinador;
		
	}
	

}










