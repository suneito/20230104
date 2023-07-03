package cat.babot.tests;

import cat.babot.manager.RequestManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.util.HashMap;
import java.util.Map;

public class APIBaseTest {
    protected static RequestManager manager;

    @BeforeAll
    public static void setup() {
        manager = new RequestManager();
        manager.createPlaywright();
        String baseUrl = "https://petstore.swagger.io/v2/";
        Map<String, String> headers = new HashMap<>();
        headers.put("content-type", "application/json");
        manager.setApiRequestContext(baseUrl, headers);
    }

    @AfterAll
    public static void tearDown() {
        manager.disposeAPIRequestContext();
        manager.closePlaywright();
    }
}