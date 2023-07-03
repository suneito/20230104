package cat.babot.tests;

import cat.babot.data.elements.User;
import cat.babot.data.elements.pet.Pet;
import cat.babot.datamanager.translator.Translator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PetRequests extends APIBaseTest {
    static final Logger ATENEA = Logger.getLogger("apiTreatment");

    ArrayList getPetsByStatus() {
        APIResponse response = manager.get("pet/findByStatus?status=sold");
        assertEquals(response.status(), HttpURLConnection.HTTP_OK);
        return getPets(response.text());
    }

    static ArrayList getPets(String json) {
        Pet[] list = null;
        try {
            final ObjectMapper objectMapper = new ObjectMapper();
            list = objectMapper.readValue(json, Pet[].class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new ArrayList(Arrays.asList(list));
    }

    void createUser(User user) {
        RequestOptions params = RequestOptions.create().setData(Translator.objectToJson(user));
        APIResponse response = manager.post("user", params);
        assertEquals(response.status(), HttpURLConnection.HTTP_OK);
        ATENEA.log(Level.INFO, () -> "user created:" + response.text());
    }

    User getUser(String userName) {
        APIResponse response = manager.get("user/"+ userName);
        assertEquals(response.status(), HttpURLConnection.HTTP_OK);
        return Translator.jsonToObject(response.text(), User.class);
    }

}
