package controlador;

import conector.Coordinador;
import modelo.vo.ModeloDatos;
import vista.gui.VentanaConsulta;
import vista.gui.VentanaConsultaGeneral;
import vista.gui.VentanaConsultaPersonas;
import vista.gui.VentanaOperaciones;

public class Principal {

	public static void main(String[] args) {
		//Declaracion de las clases
		Coordinador miCoordinador = new Coordinador();
		VentanaConsulta miConsulta = new VentanaConsulta();
		VentanaConsultaGeneral miConsultaAll = new VentanaConsultaGeneral(); 
		VentanaConsultaPersonas miConsultaP = new VentanaConsultaPersonas();
		VentanaOperaciones ventanaPpal = new VentanaOperaciones();
		ModeloDatos miModelo = new ModeloDatos();
		
		//Establecer Relaciones
		miConsulta.setCoordinador(miCoordinador);
		miConsultaAll.setCoordinador(miCoordinador);
		ventanaPpal.setCoordinador(miCoordinador);
		miModelo.setCoordinador(miCoordinador);
		miConsultaP.setCoordinador(miCoordinador);
		
		// Enviarle una instancia de cada clase al coordinador;
		miCoordinador.setVentanaP(ventanaPpal);
		miCoordinador.setVentanaC(miConsulta);
		miCoordinador.setVentanaCA(miConsultaAll);
		miCoordinador.setVentanaCP(miConsultaP);
		miCoordinador.setModelo(miModelo);
		
		
		
		ventanaPpal.setVisible(true);
		
	}
	

	

}
