package conector;

import java.util.ArrayList;


import modelo.operaciones.Procesos;
import modelo.vo.EstudianteVO;
import modelo.vo.ModeloDatos;
import vista.gui.VentanaConsulta;
import vista.gui.VentanaConsultaGeneral;
import vista.gui.VentanaConsultaPersonas;
import vista.gui.VentanaOperaciones;

public class Coordinador {

	 private VentanaOperaciones ventanaPpal;
	    private VentanaConsulta miConsulta;
	    private VentanaConsultaGeneral miConsultaAll;
	    private VentanaConsultaPersonas miConsultaP;
	    private ModeloDatos miModelo;
	    private Procesos misProcesos;

	    public Coordinador() {
	        miModelo = new ModeloDatos();
	        misProcesos = new Procesos();
	    }

	    public void registrarEstudiante(EstudianteVO estudiante) {
	        miModelo.agregarEstudiante(estudiante);  
	    }

	    public EstudianteVO obtenerEstudiante(String documento) {
	        return miModelo.consultarEstudiante(documento);  
	    }

	    public ArrayList<EstudianteVO> obtenerTodosEstudiantes() {
	        return new ArrayList<>(miModelo.obtenerTodosEstudiantes());  
	    }

	    public double calcularPromedio(EstudianteVO estudiante) {
	        return misProcesos.calcularPromedio(estudiante); 
	    }

	    public String calcularDefinitiva(EstudianteVO estudiante) {
	        double promedio = calcularPromedio(estudiante);
	        return misProcesos.calcularDefinitiva(promedio);  
	    }

	   
	    public void setVentanaP(VentanaOperaciones ventanaPpal) {
	        this.ventanaPpal = ventanaPpal;
	    }

	    public void setVentanaC(VentanaConsulta miConsulta) {
	        this.miConsulta = miConsulta;
	    }

	    public void setVentanaCA(VentanaConsultaGeneral miConsultaAll) {
	        this.miConsultaAll = miConsultaAll;
	    }

	    public void setVentanaCP(VentanaConsultaPersonas miConsultaP) {
	        this.miConsultaP = miConsultaP;
	    }

	    
	    public VentanaOperaciones getVentanaPpal() {
	        return ventanaPpal;
	    }

	    public VentanaConsulta getMiConsulta() {
	        return miConsulta;
	    }

	    public VentanaConsultaGeneral getMiConsultaAll() {
	        return miConsultaAll;
	    }

	    public VentanaConsultaPersonas getMiConsultaP() {
	        return miConsultaP;
	    }

		public void setModelo(ModeloDatos miModelo) {
			
			this.miModelo = miModelo;
			
		}
		
		 public ModeloDatos getModelo() {
		        return miModelo;
		    }
		
		public boolean actualizarEstudiante(EstudianteVO estudiante) throws Exception {
			
			
			return miModelo.actualizarEstudiante(estudiante);
			
		}

		public void mostrarVentana(int ventana) {
			
			switch(ventana) {
			case 1: miConsulta.setVisible(true); break;
			case 2: miConsultaAll.setVisible(true); break;
			case 3: miConsultaP.setVisible(true); break;
			}
			
		}

}
