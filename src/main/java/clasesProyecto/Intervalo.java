package clasesProyecto;

public class Intervalo {
	private String tipo;
	private float duracion;
	private int ciclo;
	
	
	public Intervalo(String tipo, float duracion, int ciclo) {
		this.tipo = tipo;
		this.duracion = duracion;
		this.ciclo = ciclo;
	}

	public Intervalo() {
	}

	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public float getDuracion() {
		return duracion;
	}


	public void setDuracion(float duracion) {
		this.duracion = duracion;
	}


	public int getCiclo() {
		return ciclo;
	}


	public void setCiclo(int ciclo) {
		this.ciclo = ciclo;
	}
	
	
}
