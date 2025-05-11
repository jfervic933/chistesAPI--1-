
package serviciojson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

// Clase generica para leer un JSON a un POJO
// Permite pasar de archivo Json a Joke y de Json a ListaChistes
// Cuando se declara la clase JsonService, se le indica el tipo de objeto que se quiere leer 
// en el operador diamante <T>.
public class JsonService<T> {

    public T stringToPojo(String json, Class<T> clase) throws JsonProcessingException {
        ObjectMapper mapeador = new ObjectMapper();

        return mapeador.readValue(json, clase);
    }
    

}
