package programa;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import analisis.AnalizadorECG;
import analisis.LectorECG;
import clasesProyecto.EntradaElectro;
import clasesProyecto.Resultado;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello Wordl!");
		
		try {
			String rutaFichero = "inputs/bradicardia.txt";
			
			// Leer fichero
			EntradaElectro entrada = LectorECG.leerFichero(rutaFichero);
			System.out.println("Fichero " + rutaFichero + " leído correctamente. Ondas totales:" + entrada.getListaondas().size());
			
			//Analizar
			AnalizadorECG analizador = new AnalizadorECG();
			Resultado resultado = analizador.analizar(entrada);
			System.out.println("Procesando Análisis");
	        System.out.println("Número de ciclos: " + resultado.getNumCiclos());
	        System.out.println("Ritmo cardiaco (bpm): " + resultado.getRitmoCardiaco());
	           
			// Conectar con Drools
	        KieServices ks = KieServices.Factory.get();
	        KieContainer kContainer = ks.getKieClasspathContainer();
	        KieSession kSession = kContainer.newKieSession("ksession-rules");
	        
	        kSession.insert(resultado);
	        
	        kSession.fireAllRules();
	        kSession.dispose();
			
			//Mostrar Resultado
	           System.out.println("\n===== RESULTADO DEL ANÁLISIS =====");
	           System.out.println("Enfermedad: " + resultado.getEnfermedad());  // DE MOMENTO NULL
	           System.out.println("===================================");
	            
		} catch (Exception e) {
	        System.err.println("Error procesando el fichero: " + e.getMessage());
            e.printStackTrace();
		}
	}
}
