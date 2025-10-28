package clasesProyecto;

import enums.Enfermedades;

public class Resultado {
	private Enfermedades enfermedad;
	private int numCiclos;
	private int ritmoCardiaco;
	
	public Resultado(Enfermedades enfermedad, int numCiclos, int ritmoCardiaco) {
		super();
		this.enfermedad = enfermedad;
		this.numCiclos = numCiclos;
		this.ritmoCardiaco = ritmoCardiaco;
	}

	public Enfermedades getEnfermedad() {
		return enfermedad;
	}

	public void setEnfermedad(Enfermedades enfermedad) {
		this.enfermedad = enfermedad;
	}

	public int getNumCiclos() {
		return numCiclos;
	}

	public void setNumCiclos(int numCiclos) {
		this.numCiclos = numCiclos;
	}

	public int getRitmoCardiaco() {
		return ritmoCardiaco;
	}

	public void setRitmoCardiaco(int ritmoCardiaco) {
		this.ritmoCardiaco = ritmoCardiaco;
	}
	

	
}
