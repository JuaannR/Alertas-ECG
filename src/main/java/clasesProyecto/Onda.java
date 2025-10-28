package clasesProyecto;

import enums.Tipos_Ondas;

public class Onda {
	//duracion  -> calcualdo
	private int fin;
	private int inicio;
	private float pico;
	private Tipos_Ondas tipo;
	
	public Onda(int fin, int inicio, float pico, Tipos_Ondas tipo) {
		this.fin = fin;
		this.inicio = inicio;
		this.pico = pico;
		this.tipo = tipo;
	}
	
	public int getDuracion() {
		return fin - inicio;
	}

	public int getFin() {
		return fin;
	}

	public void setFin(int fin) {
		this.fin = fin;
	}

	public int getInicio() {
		return inicio;
	}

	public void setInicio(int inicio) {
		this.inicio = inicio;
	}

	public float getPico() {
		return pico;
	}

	public void setPico(float pico) {
		this.pico = pico;
	}

	public Tipos_Ondas getTipo() {
		return tipo;
	}

	public void setTipo(Tipos_Ondas tipo) {
		this.tipo = tipo;
	}
	
	
	
}