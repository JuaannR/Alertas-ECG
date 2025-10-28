package programa;

import analisis.AnalizadorECG;
import analisis.LectorECG;
import clasesProyecto.EntradaElectro;
import clasesProyecto.Resultado;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello Wordl!");
		
		try {
			String rutaFichero = "inputs/normal.ecg";
			
			// Leer fichero
			EntradaElectro entrada = LectorECG.leerFichero(rutaFichero);
			System.out.println("Fichero le�do correctamente. Ondas totales:" + entrada.getListaondas().size());
			
			//Analizar
			AnalizadorECG analizador = new AnalizadorECG();
			Resultado resultado = analizador.analizar(entrada);
			System.out.println("An�lisis Completado");
			
			//Mostrar Resultado
	           System.out.println("\n===== RESULTADO DEL AN�LISIS =====");
	           System.out.println("N�mero de ciclos: " + resultado.getNumCiclos());
	           System.out.println("Ritmo cardiaco (bpm): " + resultado.getRitmoCardiaco());
	           System.out.println("Enfermedad: " + resultado.getEnfermedad());  // DE MOMENTO NULL
	           System.out.println("===================================");
	            
		} catch (Exception e) {
	        System.err.println("Error procesando el fichero: " + e.getMessage());
            e.printStackTrace();
		}
	}
}
