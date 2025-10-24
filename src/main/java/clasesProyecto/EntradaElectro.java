package clasesProyecto;


import java.util.Collections;
import java.util.List;

public class EntradaElectro {
	
	private List<Onda> listaOndas;

	public EntradaElectro(List<Onda> listaondas) {
		this.listaOndas = listaondas;
	}

	public List<Onda> getListaondas() {
		return Collections.unmodifiableList(listaOndas);
	}

	/*
	public void setListaondas(List<Onda> listaondas) {
		this.listaondas = listaondas;
	}
	 */
	
	
	
}
