
package conexion_http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionHTTP {

    // Este método obtiene en un String la respuesta del servidor a la petición GET
    public static String peticionHttpGet(String urlParaVisitar) throws IOException {
       StringBuilder lineas = new StringBuilder();
        try {

            URL url = new URI(urlParaVisitar).toURL();
            
            // Abrir la conexión e indicar que será de tipo GET
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");
            
            // Flujo de lectura
            try (BufferedReader flujoEntrada = new BufferedReader(new InputStreamReader(conexion.getInputStream()))) {
                String linea;
                // Mientras el BufferedReader se pueda leer, agregar contenido a resultado
                while ((linea = flujoEntrada.readLine()) != null) {
                    System.out.println(linea);
                    lineas.append(linea);
                }
            }
            
        }   catch (URISyntaxException ex) {
            Logger.getLogger(ConexionHTTP.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lineas.toString();
    }
}
