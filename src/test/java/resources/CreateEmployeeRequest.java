package resources;

public class CreateEmployeeRequest {
    public String name;
    public String salary;
    public String age;

    public CreateEmployeeRequest(String name, String salary, String age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }
}
