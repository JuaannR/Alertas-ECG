package segmentosOndas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import clasesProyecto.EntradaElectro;
import clasesProyecto.Onda;
import enums.Tipos_Ondas;

public class SegmentoQT {
	
    private List<Onda> ondasQT;
    
    public static final int CUATRO = 4;

    public SegmentoQT() {
        this.ondasQT = new ArrayList<>();
    }
    
    public List<Onda> getListaOndasQT() {
    	return Collections.unmodifiableList(ondasQT);
    }
    
    public void setListaOndasQT(List<Onda> lista) {
    	for (Onda onda : lista) {
    		ondasQT.add(onda);
    	}
    }
    
    /*
    public void filtrarOndasQT(EntradaElectro entrada) {
    	List<Onda> todas = entrada.getListaOndas();
    	
    	todas.stream()
    	.filter(onda -> 
        onda.getTipo() == Tipos_Ondas.Q ||
        onda.getTipo() == Tipos_Ondas.R ||
        onda.getTipo() == Tipos_Ondas.S ||
        onda.getTipo() == Tipos_Ondas.T
    		)
    		.forEach(onda -> ondasQT.add(onda));
    	
    	//eliminamos ondas cuyo ciclo es incompleto
    	int resto = ondasQT.size() % CUATRO;
    	
    	if (resto != 0) {
    		for(int i = 0; i < resto; i++) {
    			ondasQT.remove(ondasQT.size() -1);
    		}
    	}
    }
    */
    
    
}
