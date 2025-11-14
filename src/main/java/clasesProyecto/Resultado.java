package clasesProyecto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import enums.Enfermedades;


public class Resultado {
	private List<Enfermedades> enfermedad;
	private float numCiclos;
	private float ritmoCardiaco;
	
	private static final int VALOR_POR_DEFECTO = 0;
	
	public Resultado(List<Enfermedades> enfermedad, float numCiclos, float ritmoCardiaco) {
		this.enfermedad = new ArrayList<>();
		this.numCiclos = numCiclos;
		this.ritmoCardiaco = ritmoCardiaco;
	}
	
	public Resultado() {
		this.enfermedad = new ArrayList<>();
		this.numCiclos = VALOR_POR_DEFECTO;
		this.ritmoCardiaco = VALOR_POR_DEFECTO;
	}

	public List<Enfermedades> getEnfermedad() {
		return Collections.unmodifiableList(enfermedad);
	}

	public void setEnfermedad(List<Enfermedades> enfermedad) {
		this.enfermedad = enfermedad;
	}
	
	public void addEnfermedad(Enfermedades enferm) {
		enfermedad.add(enferm);
	}

	public float getNumCiclos() {
		return numCiclos;
	}

	public void setNumCiclos(float numCiclos) {
		this.numCiclos = numCiclos;
	}

	public float getRitmoCardiaco() {
		return ritmoCardiaco;
	}

	public void setRitmoCardiaco(float ritmoCardiaco) {
		this.ritmoCardiaco = ritmoCardiaco;
	}
	

	
}
