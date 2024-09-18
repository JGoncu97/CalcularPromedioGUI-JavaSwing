package vista.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import conector.Coordinador;
import modelo.operaciones.Procesos;
import modelo.vo.EstudianteVO;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class VentanaConsultaGeneral extends JFrame implements ActionListener{

	private JPanel panelPrincipal;
	private JTextArea areaInformacion;
	private Coordinador miCoordinador;
	private JButton btnConsultar;


	
	public VentanaConsultaGeneral() {
		
		setSize(527, 400);
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
		
		JLabel lblTitulo = new JLabel("IMPRIMIR INFORMACION");
		lblTitulo.setBackground(Color.black);
		lblTitulo.setForeground(Color.white);
		lblTitulo.setOpaque(true);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTitulo.setBounds(0, 0, 499, 50);
		panelPrincipal.add(lblTitulo);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(10, 60, 489, 250);
		
		btnConsultar = new JButton();
		btnConsultar.setText("Consulta Total");
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConsultar.setBounds(181, 320, 136, 31);
		btnConsultar.addActionListener(this);
		
		
		
		areaInformacion = new JTextArea();
		areaInformacion.setWrapStyleWord(true);
		areaInformacion.setLineWrap(true);
		areaInformacion.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 16));
		areaInformacion.setEditable(false);
		scroll.setViewportView(areaInformacion);
		
		panelPrincipal.add(btnConsultar);
		panelPrincipal.add(scroll);
	}

	
	public void llenarTablaEstudiantes() {
		
		  if (miCoordinador == null) {
		        return;
		    }

		   
		  ArrayList<EstudianteVO> lista = miCoordinador.obtenerTodosEstudiantes();
		    System.out.println("Número de estudiantes obtenidos: " + lista.size());

		    if (lista.isEmpty()) {
		        areaInformacion.setText("No hay estudiantes registrados.");
		        return;
		    }
		  
		    double sumaPromedios = 0;
		    int cantidadEstudiantes = lista.size();
		    
		    StringBuilder texto = new StringBuilder();
		    texto.append("Listado de Estudiantes: \n");
		    texto.append("Número de estudiantes obtenidos: " + lista.size()+"\n\n");

		    for (EstudianteVO estudiante : lista) {
		        sumaPromedios += estudiante.getPromedio();
		        texto.append("Documento: ").append(estudiante.getDocumento()).append("\n");
		        texto.append("Nombre: ").append(estudiante.getNombre()).append("\n");
		        texto.append("Nota1: ").append(estudiante.getNota1()).append("\n");
		        texto.append("Nota2: ").append(estudiante.getNota2()).append("\n");
		        texto.append("Nota3: ").append(estudiante.getNota3()).append("\n");
		        texto.append("Promedio: ").append(estudiante.getPromedio()).append("\n\n");
		    }
		    
		    
		    double averageRounded= miCoordinador.promedioTotalEstudiante(sumaPromedios, cantidadEstudiantes);
		    texto.append("Promedio Total: ").append(averageRounded).append("\n");

		    areaInformacion.setText(texto.toString());
	}


	public void setCoordinador(Coordinador miCoordinador) {
		
		this.miCoordinador = miCoordinador; 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btnConsultar) {
			llenarTablaEstudiantes();
		}
		
	}
}
