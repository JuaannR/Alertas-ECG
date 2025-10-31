package clasesProyecto;

import enums.Enfermedades;


public class Resultado {
	private Enfermedades enfermedad;
	private float numCiclos;
	private float ritmoCardiaco;
	
	private static final int VALOR_POR_DEFECTO = 0;
	
	public Resultado(Enfermedades enfermedad, float numCiclos, float ritmoCardiaco) {
		this.enfermedad = enfermedad;
		this.numCiclos = numCiclos;
		this.ritmoCardiaco = ritmoCardiaco;
	}
	
	public Resultado() {
		this.enfermedad = null;
		this.numCiclos = VALOR_POR_DEFECTO;
		this.ritmoCardiaco = VALOR_POR_DEFECTO;
	}

	public Enfermedades getEnfermedad() {
		return enfermedad;
	}

	public void setEnfermedad(Enfermedades enfermedad) {
		this.enfermedad = enfermedad;
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
