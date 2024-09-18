package vista.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import conector.Coordinador;
import modelo.operaciones.Procesos;
import modelo.vo.EstudianteVO;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class VentanaOperaciones extends JFrame implements ActionListener {

	private JPanel panelPrincipal;
	private JTextField txtNombre;
	private JTextField txtNota1;
	private JTextField txtNota2;
	private JTextField txtNota3;
	private JButton btnCalcular;
	private JLabel lblResPromedio,lblResultado;
	private JTable miTabla;
	
	
	private JButton btnImprimirTotal;
	private JButton btnConsultarestudiante;
	private JTextField txtDocumento;
	private JButton btnConsultarLista;
	private Coordinador miCoordinador;


	public VentanaOperaciones() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(486, 531);
		setTitle("CALCULO DE PROMEDIO");
		setLocationRelativeTo(null);
		setResizable(false);
		iniciarComponentes();
		
		
	}
	
	private void iniciarComponentes(){
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		JLabel lblTitulo = new JLabel("CALCULAR PROMEDIO");
		lblTitulo.setBackground(Color.black);
		lblTitulo.setForeground(Color.white);
		lblTitulo.setOpaque(true);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTitulo.setBounds(0, 0, 477, 50);
		panelPrincipal.add(lblTitulo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(31, 86, 100, 23);
		panelPrincipal.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(95, 80, 200, 39);
		panelPrincipal.add(txtNombre);
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNombre.setColumns(10);
		
		JLabel lblNota1 = new JLabel("Nota1:");
		lblNota1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNota1.setBounds(31, 135, 100, 23);
		panelPrincipal.add(lblNota1);
		
		txtNota1 = new JTextField();
		txtNota1.setColumns(10);
		txtNota1.setBounds(95, 129, 63, 39);
		txtNota1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelPrincipal.add(txtNota1);
		
		JLabel lblNota2 = new JLabel("Nota2:");
		lblNota2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNota2.setBounds(168, 135, 100, 23);
		panelPrincipal.add(lblNota2);
		
		txtNota2 = new JTextField();
		txtNota2.setColumns(10);
		txtNota2.setBounds(232, 129, 63, 39);
		txtNota2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelPrincipal.add(txtNota2);
		
		JLabel lblNota3 = new JLabel("Nota3:");
		lblNota3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNota3.setBounds(300, 135, 100, 23);
		panelPrincipal.add(lblNota3);
		
		txtNota3 = new JTextField();
		txtNota3.setColumns(10);
		txtNota3.setBounds(364, 129, 63, 39);
		txtNota3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelPrincipal.add(txtNota3);
		
		JLabel lblPromedio = new JLabel("Promedio:");
		lblPromedio.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPromedio.setBounds(31, 245, 127, 31);
		panelPrincipal.add(lblPromedio);
		
		lblResPromedio = new JLabel("");
		lblResPromedio.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblResPromedio.setBounds(156, 245, 271, 31);
		panelPrincipal.add(lblResPromedio);
		
		lblResultado = new JLabel("Resultado:");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblResultado.setBounds(31, 286, 396, 31);
		panelPrincipal.add(lblResultado);
		
		btnCalcular = new JButton();
		btnCalcular.setText("Calcular");
		btnCalcular.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCalcular.setBounds(310, 190, 117, 31);
		btnCalcular.addActionListener(this);
		panelPrincipal.add(btnCalcular);
		
		btnImprimirTotal = new JButton();
		btnImprimirTotal.setText("Imprimir total");
		btnImprimirTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnImprimirTotal.setBounds(28, 365, 136, 31);
		btnImprimirTotal.addActionListener(this);
		panelPrincipal.add(btnImprimirTotal);
		
		btnConsultarestudiante = new JButton();
		btnConsultarestudiante.setText("Consultar");
		btnConsultarestudiante.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConsultarestudiante.setBounds(327, 365, 100, 31);
		btnConsultarestudiante.addActionListener(this);
		panelPrincipal.add(btnConsultarestudiante);
		
		txtDocumento = new JTextField();
		txtDocumento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDocumento.setColumns(10);
		txtDocumento.setBounds(364, 78, 63, 39);
		panelPrincipal.add(txtDocumento);
		
		JLabel lblDoc = new JLabel("CC: ");
		lblDoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDoc.setBounds(312, 86, 42, 23);
		panelPrincipal.add(lblDoc);
		
		btnConsultarLista = new JButton();
		btnConsultarLista.setText("Consulta Total");
		btnConsultarLista.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConsultarLista.setBounds(181, 365, 136, 31);
		btnConsultarLista.addActionListener(this);
		panelPrincipal.add(btnConsultarLista);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnCalcular) {
			registrarEstudiante();
			
		}
		else if (e.getSource()==btnImprimirTotal) {
			
			miCoordinador.mostrarVentana(1);
		}
		else if (e.getSource()==btnConsultarestudiante) {
			
			miCoordinador.mostrarVentana(3);
		}
		else if (e.getSource()==btnConsultarLista) {
			
			
			miCoordinador.mostrarVentana(2);
			
		}
	}

	private void registrarEstudiante() {
	    String nombre = txtNombre.getText();
	    String documento = txtDocumento.getText();
	    
	    if (nombre.isEmpty() || documento.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Por favor ingrese un nombre y un documento.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    try {
	    	
	    	double nota1 = Double.parseDouble(txtNota1.getText().trim());
	        double nota2 = Double.parseDouble(txtNota2.getText().trim());
	        double nota3 = Double.parseDouble(txtNota3.getText().trim());
	        
	        if (nota1 < 0 || nota1 > 5 || nota2 < 0 || nota2 > 5 || nota3 < 0 || nota3 > 5) {
	            JOptionPane.showMessageDialog(this, "Las notas deben estar entre 0 y 5.", "Error", JOptionPane.ERROR_MESSAGE);
	            limparNotas();
	            return;
	        }
	    	
	        EstudianteVO estudiante = new EstudianteVO();
	        estudiante.setDocumento(documento);
	        estudiante.setNombre(nombre);
	        estudiante.setNota1(nota1);
	        estudiante.setNota2(nota2);
	        estudiante.setNota3(nota3);

	        double promedio = miCoordinador.calcularPromedio(estudiante); 
	        
	       
	        miCoordinador.registrarEstudiante(estudiante);
	        
	        if (miCoordinador.obtenerEstudiante(estudiante.getDocumento()) != null) {
	        	 lblResPromedio.setText(String.valueOf(promedio));

	 	        
	 	        String resultado = miCoordinador.calcularDefinitiva(estudiante);
	 	        lblResultado.setText(resultado);
	 	        
	 	        if (resultado.equals("Aprobado")) {
	 	            lblResultado.setForeground(Color.GREEN);
	 	        } else {
	 	            lblResultado.setForeground(Color.RED);
	 	        }
	 	       limpiarCampos();
	            return; 
	        
	        } 
	       
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(this, "Por favor ingrese notas válidas.", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	public void limpiarCampos() {
		txtDocumento.setText("");
		txtNombre.setText("");
		txtNota1.setText("");
		txtNota2.setText("");
		txtNota3.setText("");
	}
	
	public void limparNotas() {
		txtNota1.setText("");
		txtNota2.setText("");
		txtNota3.setText("");
	}

	public void setCoordinador(Coordinador miCoordinador) {
		
		this.miCoordinador = miCoordinador;
		
	}

	

}
