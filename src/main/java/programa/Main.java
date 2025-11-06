package programa;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import analisis.LectorECG;
import clasesProyecto.EntradaElectro;
import clasesProyecto.Onda;
import clasesProyecto.Resultado;
import segmentosOndas.OndasT;
import segmentosOndas.RelacionTR;
import segmentosOndas.SegmentoQT;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello Wordl!");
		
		try {
			String rutaFichero = "inputs/iam.txt";
			
			// Leer fichero
			EntradaElectro entrada = LectorECG.leerFichero(rutaFichero);
			System.out.println("Fichero " + rutaFichero + " leído correctamente. Ondas totales:" + entrada.getListaOndas().size());
			
			
			//CREAR OBJETOS NECESARIOS PARA ANÁLISIS
			//general
			Resultado resultado = new Resultado();
			
			//hipocalcemia
			SegmentoQT segmentoQT = new SegmentoQT();
			
			//hipopotasemia
			OndasT ondasT = new OndasT();
			
			//hipopotasemia
			RelacionTR relacionTR = new RelacionTR();
			
			//FILTRAMOS SEGMENTOS
			
			

			
			
			// Conectar con Drools
	        KieServices ks = KieServices.Factory.get(); //inicia servicio drools
	        KieContainer kContainer = ks.getKieClasspathContainer(); //carga config de kmodule.xml
	        KieSession kSession = kContainer.newKieSession("ksession-rules"); //carga sesion trabajo
	        
	        //INSERTAMOS HECHOS (OBJETOS CREADOS UTILIZADOS PARA DIAGNÓSTICO)
	        kSession.insert(resultado); 
	        kSession.insert(segmentoQT);
	        kSession.insert(ondasT);
	        kSession.insert(relacionTR);
	        kSession.insert(entrada);
	        
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

	           System.out.println(segmentoQT.getListaOndasQT());
	           
	           
	           
		} catch (Exception e) {
	        System.err.println("Error procesando el fichero: " + e.getMessage());
            e.printStackTrace();
		}
	}
}
