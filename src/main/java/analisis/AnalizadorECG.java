package analisis;

import clasesProyecto.EntradaElectro;
import clasesProyecto.Onda;
import clasesProyecto.Resultado;


import java.util.List;

public class AnalizadorECG {

	public Resultado analizar(EntradaElectro entrada) {
		List<Onda> ondas = entrada.getListaondas();
		
		if (ondas == null || ondas.isEmpty()) {
			return new Resultado(null, 0, 0);
		}
		
		// numero de ciclos
		float numCiclos = (float) ondas.size() / 5;
		
		// ritmo cardiaco en BMP
		float inicioPrimeraOnda = ondas.get(0).getInicio();
		float finUltimaOnda = ondas.get(ondas.size()-1).getFin();
		
		float duracionTotalMs = finUltimaOnda - inicioPrimeraOnda;
		
		float duracionMediaPorCiclo = duracionTotalMs / numCiclos;
		
		float ritmoCardiacoBMP =  1000 * 60 / duracionMediaPorCiclo;
		
		// Resultado, con enferemedad aun sin diagnosticar
		Resultado resultado = new Resultado (null, numCiclos, ritmoCardiacoBMP);
		
		return resultado;
	
	}
}
