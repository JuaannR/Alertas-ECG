package programa;

import java.util.Scanner;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import analisis.LectorECG;
import clasesProyecto.ContadorCiclos;
import clasesProyecto.EntradaElectro;
import clasesProyecto.Intervalo;
import clasesProyecto.Onda;
import clasesProyecto.Resultado;

public class Main {

	public static void main(String[] args) {
		
		try {
			
			String inputs = "inputs/";
			String txt = ".txt";
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("Introduce el nombre del fichero a evaluar: ");
			
			String nombreFichero = scanner.nextLine();
			String rutaFichero = inputs + nombreFichero + txt;
			
			// Leer fichero
			EntradaElectro entrada = LectorECG.leerFichero(rutaFichero);
			System.out.println("Fichero " + rutaFichero + " leído correctamente. Ondas totales:" + entrada.getListaOndas().size());
			System.out.println("Iniciando el diagnostico...");
			
			// Objetos necesarios para análisis
			Resultado resultado = new Resultado();
			Intervalo intervalo = new Intervalo();
			ContadorCiclos contCiclos = new ContadorCiclos();
			

			// Conectar con Drools
	        KieServices ks = KieServices.Factory.get(); 
	        KieContainer kContainer = ks.getKieClasspathContainer(); 
	        KieSession kSession = kContainer.newKieSession("ksession-rules"); 
	        
	        // Inserción de hechos
	        kSession.insert(resultado); 
	        kSession.insert(intervalo);
	        kSession.insert(entrada);
	        kSession.insert(contCiclos);
	        
	        
	        for (Onda o : entrada.getListaOndas()) {
	        	kSession.insert(o);
	        }
	        
	        kSession.fireAllRules(); 
	        kSession.dispose(); 
			

			//Mostrar Resultado
	           System.out.println("\n===== RESULTADO DEL ANÁLISIS =====");
	           System.out.println("Enfermedad: " + resultado.getEnfermedad());
	           System.out.println("Número de ciclos: " + resultado.getNumCiclos());
	           System.out.println("Ritmo Cardiaco: " + resultado.getRitmoCardiaco());
	           System.out.println("===================================");
	           
	           
	           scanner.close();
          
	           
	           
		} catch (Exception e) {
	        System.err.println("Error procesando el fichero: " + e.getMessage());
            e.printStackTrace();
		}
	}
}
