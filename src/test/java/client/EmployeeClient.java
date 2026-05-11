package client;

import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import resources.CreateEmployeeRequest;

public class EmployeeClient {

    private final APIRequestContext request;

    public EmployeeClient(APIRequestContext request) {
        this.request = request;
    }

    public APIResponse getAllEmployees() {
        return request.get("/employees");
    }

    public APIResponse getEmployeeById(int id) {
//        return request.get("/employee/" + id);
        return request.get("/employee/" + id,
                RequestOptions.create()
                        .setHeader("User-Agent", "Mozilla/5.0"));
    }

    public APIResponse createEmployee(CreateEmployeeRequest body) {
//        return request.post("/create",
//                RequestOptions.create().setData(body));
        return request.post("/create",
                RequestOptions.create()
                        .setHeader("Content-Type", "application/json")
                        .setHeader("User-Agent", "Mozilla/5.0")
                        .setData(body));
    }

    public APIResponse updateEmployee(int id, CreateEmployeeRequest body) {
        return request.put("/update/" + id,
                RequestOptions.create().setData(body));
    }

    public APIResponse deleteEmployee(int id) {
        return request.delete("/delete/" + id);
    }
}
