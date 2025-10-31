package programa;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import analisis.LectorECG;
import clasesProyecto.EntradaElectro;
import clasesProyecto.Onda;
import clasesProyecto.Resultado;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello Wordl!");
		
		try {
			String rutaFichero = "inputs/normal.txt";
			
			// Leer fichero
			EntradaElectro entrada = LectorECG.leerFichero(rutaFichero);
			System.out.println("Fichero " + rutaFichero + " leído correctamente. Ondas totales:" + entrada.getListaOndas().size());
			
			Resultado resultado = new Resultado();
			
			// Conectar con Drools
	        KieServices ks = KieServices.Factory.get(); //inicia servicio drools
	        KieContainer kContainer = ks.getKieClasspathContainer(); //carga config de kmodule.xml
	        KieSession kSession = kContainer.newKieSession("ksession-rules"); //carga sesion trabajo
	        
	        kSession.insert(resultado); //insertamos un hecho, el resultado del diagnostico
	        
	        //Metemos en Drools la lista de ondas de EntradaElectro ONDA A ONDA
	        for (Onda o : entrada.getListaOndas()) {
	        	kSession.insert(o);
	        }
	        
	        kSession.fireAllRules(); //lanzar las reglas
	        kSession.dispose(); //cierra sesion 
			

			//Mostrar Resultado
	           System.out.println("\n===== RESULTADO DEL ANÁLISIS =====");
	           System.out.println("Enfermedad: " + resultado.getEnfermedad());
	           System.out.println("Número de ciclos: " + resultado.getNumCiclos());
	           System.out.println("Ritmo Cardiaco: " + resultado.getRitmoCardiaco());
	           System.out.println("===================================");

			
		} catch (Exception e) {
	        System.err.println("Error procesando el fichero: " + e.getMessage());
            e.printStackTrace();
		}
	}
}
