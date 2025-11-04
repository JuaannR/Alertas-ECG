package segmentosOndas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import clasesProyecto.EntradaElectro;
import clasesProyecto.Onda;
import enums.Tipos_Ondas;

public class OndasT {
	private List<Onda> ondasT;
	
	public OndasT() {
		this.ondasT = new ArrayList<>();
	}
	
	public List<Onda> getListaOndasT() {
		return Collections.unmodifiableList(ondasT);
	}
	
	public void filtrarOndasT(EntradaElectro entrada) {
		List<Onda> todas = entrada.getListaOndas();
		
		todas.stream()
		.filter(onda -> onda.getTipo() == Tipos_Ondas.T)
		.forEach(onda -> ondasT.add(onda));
	}

}
