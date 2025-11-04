package segmentosOndas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import clasesProyecto.EntradaElectro;
import clasesProyecto.Onda;
import enums.Tipos_Ondas;

public class RelacionTR {
	private List<Onda> ondasTR;
	
	private static final int DOS = 2;
	
	public RelacionTR() {
		this.ondasTR = new ArrayList<>();
	}
	
	public List<Onda> getListaRelacionTR() {
		return Collections.unmodifiableList(ondasTR);
	}
	
	public void filtrarRelacionTR(EntradaElectro entrada) {
		List<Onda> todas = entrada.getListaOndas();
		
		todas.stream()
		.filter(onda ->
			onda.getTipo() == Tipos_Ondas.R ||
			onda.getTipo() == Tipos_Ondas.T 
				)
		.forEach(onda -> ondasTR.add(onda));
	
		//Eliminamos una posible Onda R suelta para no tener ciclo incompleto
		int resto = ondasTR.size() % DOS;
		
		if(resto != 0) {
			ondasTR.remove(ondasTR.size()-1);
		}
	}
}
