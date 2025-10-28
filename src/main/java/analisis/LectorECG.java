package analisis;

import clasesProyecto.EntradaElectro;
import clasesProyecto.Onda;
import enums.Tipos_Ondas;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class LectorECG {

    public static EntradaElectro leerFichero(String rutaFichero) throws IOException {
        List<Onda> ondas = new ArrayList<>();  //Lista vacia

        // Patr�n expresion regular
        Pattern pattern = Pattern.compile("([PQRST])\\((\\d+),(\\d+),(-?\\d+\\.?\\d*)\\)");

        try (BufferedReader br = new BufferedReader(new FileReader(rutaFichero))) {
            String linea;
            while ((linea = br.readLine()) != null) { 
                linea = linea.trim();  //eliminar espacios principio y final linea

                // Saltar l�neas vac�as o con #
                if (linea.isEmpty() || linea.startsWith("#")) {
                	continue; 
                	}

                Matcher matcher = pattern.matcher(linea);
                if (matcher.find()) {
                    Tipos_Ondas tipo = Tipos_Ondas.valueOf(matcher.group(1));
                    int inicio = Integer.parseInt(matcher.group(2));
                    int fin = Integer.parseInt(matcher.group(3));
                    float pico = Float.parseFloat(matcher.group(4));

                    Onda o = new Onda(fin, inicio, pico, tipo);
                    ondas.add(o);
                }
            }
        }

        return new EntradaElectro(ondas);
    }
}
