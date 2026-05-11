package base;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.Playwright;

public class ApiBase {

    protected APIRequestContext request;

    public void setup(){
        Playwright playwright = Playwright.create();
        APIRequest requestAPI = playwright.request();

        request = requestAPI.newContext(new APIRequest.NewContextOptions()
                .setBaseURL("https://dummy.restapiexample.com/api/v1"));
    }
}
