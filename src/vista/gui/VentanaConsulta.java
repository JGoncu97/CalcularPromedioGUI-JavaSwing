package vista.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import conector.Coordinador;
import modelo.operaciones.Procesos;
import modelo.vo.EstudianteVO;
import modelo.vo.ModeloDatos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class VentanaConsulta extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtNota1;
	private JTextField txtNota2;
	private JTextField txtNota3;
	private JTextField txtDoc;
	private JButton btnConsultar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JLabel lblResultado;
	private JLabel lblResPromedio;
	private JLabel lblResActualizacion;
	private JTable tablaEstudiantes;
	private Coordinador miCoordinador;
	private JTextArea instructivo;
	private ModeloDatos miModelo;
	DefaultTableModel modelo;

	
	public VentanaConsulta() {
		
		setSize(800, 600);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		iniciarComponentes();
		
		
		
	}


	public void iniciarComponentes() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(null);
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelPrincipal.setBounds(0, 0, 477, 379);
		getContentPane().add(panelPrincipal);
		
		JLabel lblConsultar = new JLabel("CONSULTAR");
		lblConsultar.setOpaque(true);
		lblConsultar.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultar.setForeground(Color.WHITE);
		lblConsultar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblConsultar.setBackground(Color.BLACK);
		lblConsultar.setBounds(0, 0, 777, 50);
		panelPrincipal.add(lblConsultar);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(31, 104, 100, 23);
		panelPrincipal.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNombre.setColumns(10);
		txtNombre.setBounds(95, 98, 332, 39);
		panelPrincipal.add(txtNombre);
		
		JLabel lblNota1 = new JLabel("Nota1:");
		lblNota1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNota1.setBounds(31, 153, 100, 23);
		panelPrincipal.add(lblNota1);
		
		txtNota1 = new JTextField();
		txtNota1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNota1.setColumns(10);
		txtNota1.setBounds(95, 147, 63, 39);
		panelPrincipal.add(txtNota1);
		
		JLabel lblNota2 = new JLabel("Nota2:");
		lblNota2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNota2.setBounds(168, 153, 100, 23);
		panelPrincipal.add(lblNota2);
		
		txtNota2 = new JTextField();
		txtNota2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNota2.setColumns(10);
		txtNota2.setBounds(232, 147, 63, 39);
		panelPrincipal.add(txtNota2);
		
		JLabel lblNota3 = new JLabel("Nota3:");
		lblNota3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNota3.setBounds(300, 153, 100, 23);
		panelPrincipal.add(lblNota3);
		
		txtNota3 = new JTextField();
		txtNota3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNota3.setColumns(10);
		txtNota3.setBounds(364, 147, 63, 39);
		panelPrincipal.add(txtNota3);
		
		JLabel lblPromedio = new JLabel("Promedio:");
		lblPromedio.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPromedio.setBounds(31, 196, 127, 31);
		panelPrincipal.add(lblPromedio);
		
		lblResPromedio = new JLabel("");
		lblResPromedio.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblResPromedio.setBounds(156, 196, 271, 31);
		panelPrincipal.add(lblResPromedio);
		
		lblResultado = new JLabel("Resultado:");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblResultado.setBounds(31, 237, 396, 31);
		panelPrincipal.add(lblResultado);
		
		btnConsultar = new JButton("Consultar Tabla");
		
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnConsultar.setBounds(454, 278, 250, 31);
		btnConsultar.addActionListener(this);
		panelPrincipal.add(btnConsultar);
		
		JLabel lblDoc = new JLabel("Documento");
		lblDoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDoc.setBounds(195, 65, 100, 23);
		panelPrincipal.add(lblDoc);
		
		txtDoc = new JTextField();
		txtDoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDoc.setColumns(10);
		txtDoc.setBounds(300, 60, 127, 31);
		panelPrincipal.add(txtDoc);
		
		btnActualizar = new JButton();
		btnActualizar.setText("Actualizar");
		btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnActualizar.setBounds(31, 278, 184, 31);
		btnActualizar.addActionListener(this);
		panelPrincipal.add(btnActualizar);
		
		btnEliminar = new JButton();
		btnEliminar.setText("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEliminar.setBounds(243, 278, 184, 31);
		btnEliminar.addActionListener(this);
		panelPrincipal.add(btnEliminar);
		
		lblResActualizacion = new JLabel("");
		lblResActualizacion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblResActualizacion.setBounds(28, 325, 396, 31);
		panelPrincipal.add(lblResActualizacion);
		
		   
        tablaEstudiantes = new JTable();
        JScrollPane scroll = new JScrollPane(tablaEstudiantes);
        scroll.setBounds(10, 350, 750, 200);
        panelPrincipal.add(scroll);
        
        instructivo = new JTextArea();
        instructivo.setBounds(450,60,250,150);
        instructivo.setText("Instrucciones: \n\n"
        		+ "Eliminar: Si desea eliminar debe ingresar \n"
        		+ "(Solamente el numero de documento) del \n"
        		+ "estudiante \n\n"
        		+ "Actualizar: Consulte la tabla y ingrese los\n"
        		+ "datos de la persona que desea modificar \n"
        		+ "(Debe ingresar todos los campos)");
        instructivo.setEditable(false);
        instructivo.setBorder(BorderFactory.createLineBorder(Color.black));
        panelPrincipal.add(instructivo);
        		
        
        crearModelo();
	}
       

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnConsultar) {
			llenarTablaEstudiantes();
		}else if(e.getSource()==btnActualizar) {
			actualizarEstudiante();
			limpiarCampos();
			 
		}else if( e.getSource()== btnEliminar) {
			eliminarEstudiante();
			limpiarCampos();
		}
			
	}
	
	 private void crearModelo() {
	        modelo = new DefaultTableModel();
	        modelo.addColumn("Documento");
	        modelo.addColumn("Nombre");
	        modelo.addColumn("Nota1");
	        modelo.addColumn("Nota2");
	        modelo.addColumn("Nota3");
	        modelo.addColumn("Promedio");
	        tablaEstudiantes.setModel(modelo);
	    }
	
	  private void llenarTablaEstudiantes() {
	        if (miCoordinador == null) {
	            return;
	        }

	        ArrayList<EstudianteVO> lista = miCoordinador.obtenerTodosEstudiantes();
	        DefaultTableModel model = (DefaultTableModel) tablaEstudiantes.getModel();
	        model.setRowCount(0); 

	        for (EstudianteVO estudiante : lista) {
	            model.addRow(new Object[]{
	                estudiante.getDocumento(),
	                estudiante.getNombre(),
	                estudiante.getNota1(),
	                estudiante.getNota2(),
	                estudiante.getNota3(),
	                estudiante.getPromedio()
	            });
	        }
	    }
	  
	  public void actualizarEstudiante() {
		  try {
			  
			  lblResActualizacion.setText("");
		        String documento = txtDoc.getText().trim();
		        String nombre = txtNombre.getText().trim();
		        double nota1 = Double.parseDouble(txtNota1.getText().trim());
		        double nota2 = Double.parseDouble(txtNota2.getText().trim());
		        double nota3 = Double.parseDouble(txtNota3.getText().trim());
		        
		        
		        if (nota1 < 0 || nota1 > 5 || nota2 < 0 || nota2 > 5 || nota3 < 0 || nota3 > 5) {
		            JOptionPane.showMessageDialog(this, "Las notas deben estar entre 0 y 5.", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        EstudianteVO estudiante = new EstudianteVO();
		        estudiante.setDocumento(documento);
		        estudiante.setNombre(nombre);
		        estudiante.setNota1(nota1);
		        estudiante.setNota2(nota2);
		        estudiante.setNota3(nota3);
		        
		        double promedio = miCoordinador.calcularPromedio(estudiante); 
		        if (miCoordinador.obtenerEstudiante(estudiante.getDocumento()) != null) {
		        	 lblResPromedio.setText(String.valueOf(promedio));

		 	        String resultado = miCoordinador.calcularDefinitiva(estudiante);
		 	        lblResultado.setText(resultado);
		 	        
		 	       boolean exito = miCoordinador.getModelo().actualizarEstudiante(estudiante);
			        if (exito) {
			            lblResActualizacion.setText("Estudiante actualizado.");
			        } else {
			            lblResActualizacion.setText("Error al actualizar el estudiante.");
			        }
			        
			        llenarTablaEstudiantes();
		 	        
		 	        if (resultado.equals("Aprobado")) {
		 	            lblResultado.setForeground(Color.GREEN);
		 	        } else {
		 	            lblResultado.setForeground(Color.RED);
		 	        }
		            return; 
		        
		        } 
		        
		       
		    } catch (NumberFormatException ex) {
		        JOptionPane.showMessageDialog(this, "Las notas deben ser números válidos.");
		    } catch (Exception ex) {
		        JOptionPane.showMessageDialog(this, "Error al actualizar el estudiante : " + ex.getMessage());
		    }
	  }
	  
	  public void eliminarEstudiante() {
		    try {
		        String documento = txtDoc.getText().trim();
		        
		        if (documento.isEmpty()) {
		            JOptionPane.showMessageDialog(this, "El campo de documento está vacío, Ingreselo primero", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        
		        boolean exito = miCoordinador.getModelo().eliminarEstudiante(documento);
		        if (exito) {
		            lblResActualizacion.setText("Estudiante eliminado.");
		        } else {
		            lblResActualizacion.setText("Error al eliminar el estudiante.");
		        }
		        
		        
		        llenarTablaEstudiantes();
		    } catch (Exception ex) {
		        JOptionPane.showMessageDialog(this, "Error al eliminar el estudiante: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		    }
		}

	  
	
	public void limpiarCampos() {
		txtDoc.setText("");
		txtNombre.setText("");
		txtNota1.setText("");
		txtNota2.setText("");
		txtNota3.setText("");
	}


	public void setCoordinador(Coordinador miCoordinador) {
		
		this.miCoordinador = miCoordinador;
		
	}
}
