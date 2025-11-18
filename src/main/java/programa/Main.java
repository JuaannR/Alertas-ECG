package programa;

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
		System.out.println("Hello Wordl!");
		
		try {
			//String rutaFichero = "inputs/bradicardia.txt";
			//String rutaFichero = "inputs/bradicardia2.txt";
			//String rutaFichero = "inputs/hipocalcemia_hipopotasemia.txt";
			//String rutaFichero = "inputs/hipocalcemia_iam.txt";
			//String rutaFichero = "inputs/hipocalcemia_isqcoronaria.txt";
			//String rutaFichero = "inputs/hipocalcemia.txt";
			//String rutaFichero = "inputs/hipopotasemia.txt";
			//String rutaFichero = "inputs/iam.txt";
			//String rutaFichero = "inputs/isq-coronaria.txt";
			//String rutaFichero = "inputs/normal.txt";
			//String rutaFichero = "inputs/normal2.txt";
			//String rutaFichero = "inputs/premat-vent-contr1.txt";
			String rutaFichero = "inputs/premat-vent-contr2.txt";
			//String rutaFichero = "inputs/taquicardia.txt";
			//String rutaFichero = "inputs/taquicardia2.txt";
			
			// Leer fichero
			EntradaElectro entrada = LectorECG.leerFichero(rutaFichero);
			System.out.println("Fichero " + rutaFichero + " leído correctamente. Ondas totales:" + entrada.getListaOndas().size());
			
			
			//CREAR OBJETOS NECESARIOS PARA ANÁLISIS
			//general
			Resultado resultado = new Resultado();
			
			//hipocalcemia
			Intervalo intervalo = new Intervalo();
			
			

			
			//FILTRAMOS SEGMENTOS
			ContadorCiclos contCiclos = new ContadorCiclos();
			

			
			
			// Conectar con Drools
	        KieServices ks = KieServices.Factory.get(); //inicia servicio drools
	        KieContainer kContainer = ks.getKieClasspathContainer(); //carga config de kmodule.xml
	        KieSession kSession = kContainer.newKieSession("ksession-rules"); //carga sesion trabajo
	        
	        //INSERTAMOS HECHOS (OBJETOS CREADOS UTILIZADOS PARA DIAGNÓSTICO)
	        kSession.insert(resultado); 
	        kSession.insert(intervalo);
	        kSession.insert(entrada);
	        kSession.insert(contCiclos);
	        
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

	           //System.out.println(segmentoQT.getListaOndasQT());
	           
	           
	           
		} catch (Exception e) {
	        System.err.println("Error procesando el fichero: " + e.getMessage());
            e.printStackTrace();
		}
	}
}
