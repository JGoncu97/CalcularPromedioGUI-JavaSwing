package vista.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class VentanaConsultaPersonas extends JFrame implements ActionListener {

	  private JPanel panelPrincipal;
	    private JTable tablaPersonas;
	    DefaultTableModel modelo;
	    private Coordinador miCoordinador;
	    
	    private JTextField txtDocumento;  
	    private JButton btnConsultar;     
	    
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
	        btnConsultar.addActionListener(this);
	        panelPrincipal.add(btnConsultar);
	        
	        JScrollPane scrollPane = new JScrollPane();
	        scrollPane.setBounds(10, 100, 473, 236);
	        panelPrincipal.add(scrollPane);

	        tablaPersonas = new JTable();
	        scrollPane.setViewportView(tablaPersonas);
	        
	        
	        crearModelo();
	        
	        
	    }

	    private void crearModelo() {
	        modelo = new DefaultTableModel();
	        modelo.addColumn("Documento");
	        modelo.addColumn("Nombre");
	        modelo.addColumn("Promedio");
	        tablaPersonas.setModel(modelo);
	    }

	    
	    public void llenarTabla() {
	    	  if (miCoordinador == null) {
		            return;
		        }

	        ArrayList<EstudianteVO> lista = miCoordinador.obtenerTodosEstudiantes();
	        DefaultTableModel model = (DefaultTableModel) tablaPersonas.getModel();
	        model.setRowCount(0);  
	        for (EstudianteVO est : lista) {
	            model.addRow(new Object[]{est.getDocumento(), est.getNombre(), est.getPromedio()});
	        }
	    }

	   
	    private void consultarEstudiantePorDocumento() {
	        String documento = txtDocumento.getText();
	        
	        if (documento.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "Por favor, ingrese un documento.", "Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }

	        
	        EstudianteVO estudiante = miCoordinador.obtenerEstudiante(documento);

	        if (estudiante != null) {
	            
	            DefaultTableModel model = (DefaultTableModel) tablaPersonas.getModel();
	            model.setRowCount(0);  
	            model.addRow(new Object[]{estudiante.getDocumento(), estudiante.getNombre(), estudiante.getPromedio()});
	        } else {
	            
	            JOptionPane.showMessageDialog(this, "Estudiante no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }

	public void setCoordinador(Coordinador miCoordinador) {
		
		this.miCoordinador = miCoordinador;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== btnConsultar) {
			consultarEstudiantePorDocumento();
		}
		
	}
	

}










