package programa;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import analisis.LectorECG;
import clasesProyecto.EntradaElectro;
import clasesProyecto.Onda;
import clasesProyecto.Resultado;
import segmentosOndas.SegmentoQT;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello Wordl!");
		
		try {
			String rutaFichero = "inputs/hipocalcemia_isqcoronaria.txt";
			
			// Leer fichero
			EntradaElectro entrada = LectorECG.leerFichero(rutaFichero);
			System.out.println("Fichero " + rutaFichero + " leído correctamente. Ondas totales:" + entrada.getListaOndas().size());
			
			
			//CREAR OBJETOS NECESARIOS PARA ANÁLISIS
			Resultado resultado = new Resultado();
			SegmentoQT segmentoQT = new SegmentoQT();
			
			//FILTRAMOS SEGMENTOS
			segmentoQT.filtrarOndasQT(entrada);
			
			
			
			//PRUEBA HIPOCALCEMIA
			float sumaDuraciones = 0;
			int ciclos = segmentoQT.getListaOndasQT().size() / 4;
			
			for (int i = 0; i < segmentoQT.getListaOndasQT().size(); i = i + 4) {
				float inicioQ = segmentoQT.getListaOndasQT().get(i).getInicio();
				float finT = segmentoQT.getListaOndasQT().get(i+3).getFin();
				System.out.println("for: " + sumaDuraciones);
				sumaDuraciones = sumaDuraciones + (finT - inicioQ);
				
			}
			System.out.println("final: " + sumaDuraciones);
			System.out.println("ciclos: " + ciclos);
			float duracionMedia = sumaDuraciones / ciclos;
			
			
			System.out.println("duracion media " + duracionMedia);
			if (duracionMedia > 450) {
				System.out.println("Mayor a 450");
			} else {
				System.out.println("Menor a 450");
			}
			
			
			
			// Conectar con Drools
	        KieServices ks = KieServices.Factory.get(); //inicia servicio drools
	        KieContainer kContainer = ks.getKieClasspathContainer(); //carga config de kmodule.xml
	        KieSession kSession = kContainer.newKieSession("ksession-rules"); //carga sesion trabajo
	        
	        //INSERTAMOS HECHOS (OBJETOS CREADOS UTILIZADOS PARA DIAGNÓSTICO)
	        kSession.insert(resultado); 
	        kSession.insert(segmentoQT);
	        
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
