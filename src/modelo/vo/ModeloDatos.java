package modelo.vo;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import conector.Coordinador;

public class ModeloDatos {


    private Coordinador miCoordinador;
    private HashMap<String, EstudianteVO> miPersona = new HashMap<>();
    
    public void agregarEstudiante(EstudianteVO estudiante) {
    	
    	if(!miPersona.containsKey(estudiante.getDocumento())) {
    		miPersona.put(estudiante.getDocumento(), estudiante);
    	}else {
    		JOptionPane.showMessageDialog(null, "Estudiante ya esta registrado");
    	}
        
    }
    
    public boolean actualizarEstudiante(EstudianteVO estudiante) throws Exception {
    	
    	 	if (miPersona.containsKey(estudiante.getDocumento())) {
    	        miPersona.put(estudiante.getDocumento(), estudiante);
    	        return true; 
    	    } else {
    	    	throw new Exception("El estudiante con documento " + estudiante.getDocumento() + " no existe en los registros.");
    	    }
    	        
    	    
    }

    public EstudianteVO consultarEstudiante(String documento) {
        return miPersona.get(documento);
    }

    public boolean eliminarEstudiante(String documento) {
        if (miPersona.containsKey(documento)) {
            miPersona.remove(documento);
            return true; 
        } else {
            return false;
        }
    }

    public ArrayList<EstudianteVO> obtenerTodosEstudiantes() {
        return new ArrayList<>(miPersona.values());  
    }

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }

	/**
	 * @return the miCoordinador
	 */
	public Coordinador getMiCoordinador() {
		return miCoordinador;
	}

}
