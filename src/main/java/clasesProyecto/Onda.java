package clasesProyecto;

import enums.Tipos_Ondas;

public class Onda {
	//duracion  -> calcualdo
	private float fin;
	private float inicio;
	private float pico;
	private Tipos_Ondas tipo;
	
	public Onda(float fin, float inicio, float pico, Tipos_Ondas tipo) {
		this.fin = fin;
		this.inicio = inicio;
		this.pico = pico;
		this.tipo = tipo;
	}
	
	public float getDuracion() {
		return fin - inicio;
	}

	public float getFin() {
		return fin;
	}

	public void setFin(float fin) {
		this.fin = fin;
	}

	public float getInicio() {
		return inicio;
	}

	public void setInicio(float inicio) {
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