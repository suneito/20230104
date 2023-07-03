package cat.babot.tests;

import cat.babot.data.elements.User;
import org.junit.jupiter.api.Test;
import java.util.logging.Level;

public class ApiTests extends PetRequests {
    /**
     * 1. Crea tu usuario mediante petición HTTP y posteriormente recupera sus datos llamando al
     * servicio correspondiente. */
    @Test
    public void apiTreatment1() {
        User userTBC = new User();
        createUser(userTBC);
        User userARC = getUser(userTBC.getUsername());
        ATENEA.log(Level.INFO, () -> "obtained user:" + userARC.toString());
    }

    /**
     * 2. Recoge mediante petición HTTP, el JSON que retorna el endpoint /pet/findByStatus y lista mediante una función los nombres de las mascotas que se hayan vendido.
     * - El formato de salida deberá estar formado por la tupla {id, name}.
     * - Puedes utilizar la estructura de datos que prefieras.
     * */
    @Test
    public void apiTreatment2() {
        StringBuilder soldPets = new StringBuilder();
        getPetsByStatus().forEach(x ->  soldPets.append(x.toString()).append("\n"));
        ATENEA.log(Level.INFO, () -> "sold pets:" + soldPets.toString());
    }

    /**
     * 3.Crea una clase cuyo constructor requiera de la estructura de datos anterior y realiza un método que pueda
     *  recorrerla para poder identificar cuantas mascotas se llaman igual.
     * - Ejemplo de salida: {“William”: 11, “ Floyd”: 2}
     */
    @Test
    public void apiTreatment3() {


    }

}


