package modelo.operaciones;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.vo.EstudianteVO;

public class Procesos {

	
	private ArrayList<EstudianteVO> listaEstudiantes = new ArrayList<>();

	
	public double calcularPromedio(EstudianteVO estudiante) {
		
		 double nota1 = estudiante.getNota1();
		 double nota2 = estudiante.getNota2();
		 double nota3 = estudiante.getNota3();
	
		 
		 double average= (nota1 + nota2 + nota3) / 3;
		 
		 double factor = Math.pow(10, 2);
		 double averageRounded = Math.round(average * factor) / factor;
		 
		 estudiante.setPromedio(averageRounded);
		 return averageRounded;
	}

	public String calcularDefinitiva(double promedio) {

		if (promedio >= 3.6) {
	        return "Aprobado";
	    } else {
	        return "Reprobado";
	    }
	}

	

	public ArrayList<EstudianteVO> imprimirListaEstudiantes() {

        ArrayList<EstudianteVO> listaEstudiantes = new ArrayList<>();

      

        return listaEstudiantes;
    
	}
	


	 public EstudianteVO obtenerEstudiante(String documento) {
	        for (EstudianteVO estudiante : listaEstudiantes) {
	            if (estudiante.getDocumento().equals(documento)) {
	                return estudiante;
	            }
	        }
	        return null;  
	    }

	 public double promedioTotal(double sumaPromedio, int cantEstudiante) {
		 
		 double promedioTotal = sumaPromedio / cantEstudiante;
		 double factor = Math.pow(10, 2);
		 double averageRounded = Math.round(promedioTotal * factor) / factor;
		return averageRounded;
		 
	 }
	 
	 public ArrayList<EstudianteVO> obtenerTodosEstudiantes() {
	        return listaEstudiantes;
	    }

	
	
}
