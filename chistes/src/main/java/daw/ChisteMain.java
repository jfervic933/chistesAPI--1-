
package daw;

import java.io.IOException;

import conexion_http.ConexionHTTP;
import modelos.Joke;
import modelos2.ListaChistes;
import serviciojson.JsonService;

/**
 *
 * @author Juan Carlos Fernández Vico
 */
public class ChisteMain {

    public static void main(String[] args) throws IOException {
        // URL de la API de chistes
        String urlBase = "https://v2.jokeapi.dev/joke/Programming?lang=es";
        String urlBase2 = "https://v2.jokeapi.dev/joke/Any?lang=es&amount=5";

        // Realizamos la petición HTTP GET a la API de chistes y guardamos la respuesta
        // en un String
        String fichero = ConexionHTTP.peticionHttpGet(urlBase);
        String fichero2 = ConexionHTTP.peticionHttpGet(urlBase2);

        // A partir del String con el JSON, lo convertimos a un objeto de la clase Joke
        // y lo mostramos por pantalla
        JsonService<Joke> jSonService = new JsonService<>();
        Joke chiste = jSonService.stringToPojo(fichero, Joke.class);
        System.out.println(chiste);
        System.out.println("-------------");

        // A partir del String con el JSON, lo convertimos a un objeto de la clase ListaChistes
        // y lo mostramos por pantalla
        JsonService<ListaChistes> jSonService2 = new JsonService<>();
        ListaChistes lista = jSonService2.stringToPojo(fichero2, ListaChistes.class);
        lista.getJokes().forEach(System.out::println);
    }
}
