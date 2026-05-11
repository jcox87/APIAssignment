package tests;

import base.ApiBase;
import client.EmployeeClient;
import com.microsoft.playwright.APIResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import resources.CreateEmployeeRequest;
import resources.CreateEmployeeResponse;
import utils.JsonUtils;

public class EmployeeApiTests extends ApiBase {

    private EmployeeClient employeeClient;

    @BeforeClass
    public void init() {
        setup();
        employeeClient = new EmployeeClient(request);
    }

    @Test
    public void testGetAllEmployees() {
        APIResponse response = employeeClient.getAllEmployees();
        Assert.assertEquals(response.status(), 200);

        System.out.println(response.text());
    }

    @Test
    public void testGetEmployeeById() {
        APIResponse response = employeeClient.getEmployeeById(1);
        Assert.assertEquals(response.status(), 200);

        System.out.println(response.text());
    }

    @Test
    public void testCreateEmployee() {
        CreateEmployeeRequest body = new CreateEmployeeRequest("test", "123", "23");

        APIResponse response = employeeClient.createEmployee(body);
        Assert.assertEquals(response.status(), 200);

        CreateEmployeeResponse respObj =
                JsonUtils.fromJson(response.text(), CreateEmployeeResponse.class);

        Assert.assertEquals(respObj.status, "success");
        Assert.assertEquals(respObj.data.employee_name, "test");
    }

    @Test
    public void testUpdateEmployee() {
        CreateEmployeeRequest body = new CreateEmployeeRequest("updated", "500", "30");

        APIResponse response = employeeClient.updateEmployee(21, body);
        Assert.assertEquals(response.status(), 200);

        System.out.println(response.text());
    }

    @Test
    public void testDeleteEmployee() {
        APIResponse response = employeeClient.deleteEmployee(2);
        Assert.assertEquals(response.status(), 200);

        System.out.println(response.text());
    }

}
