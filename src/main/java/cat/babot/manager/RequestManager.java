package cat.babot.manager;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;

import java.util.Map;

public class RequestManager {
    private Playwright playwright;
    private APIRequestContext apiRequestContext;

    public void createPlaywright() {
        playwright = Playwright.create();
    }

    public void setApiRequestContext(String baseUrl, Map<String, String> headers) {
        apiRequestContext = playwright.request()
                .newContext(new APIRequest.NewContextOptions().setBaseURL(baseUrl)
                        .setExtraHTTPHeaders(headers));
    }

    //GET
    public APIResponse get(String endpoint) {
        return apiRequestContext.get(endpoint);
    }

    //POST
    public APIResponse post(String endpoint, RequestOptions options) {
        return apiRequestContext.post(endpoint, options);
    }

    public void disposeAPIRequestContext() {
        apiRequestContext.dispose();
    }

    public void closePlaywright() {
        playwright.close();
    }

}
