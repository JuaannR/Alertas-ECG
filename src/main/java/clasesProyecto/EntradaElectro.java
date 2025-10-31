package clasesProyecto;


import java.util.Collections;
import java.util.List;

public class EntradaElectro {
	
	private List<Onda> listaOndas;

	public EntradaElectro(List<Onda> listaondas) {
		this.listaOndas = listaondas;
	}

	public List<Onda> getListaOndas() {
		return Collections.unmodifiableList(listaOndas);
	}

	
	
	
}
