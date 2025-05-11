import java.util.ArrayList;
import java.util.List;

public class Manager implements Employee{
    private String name;
    private List<Employee> reportees = new ArrayList<>();

    public Manager(String name) {
        this.name = name;
    }

    public void add(Employee employee) {
        this.reportees.add(employee);
    }

    public void remove(Employee employee) {
        this.reportees.remove(employee);
    }

    @Override
    public void showDetails() {
        System.out.println("Manager Name: " + this.name);
        for (Employee employee: reportees) {
            employee.showDetails();
        }
    }
}
