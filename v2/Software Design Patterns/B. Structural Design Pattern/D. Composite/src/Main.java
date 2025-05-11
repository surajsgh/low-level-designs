public class Main {
    public static void main(String[] args) {
        Employee suraj = new Developer("Suraj");
        Employee mansi = new Developer("Mansi");

        suraj.showDetails();

        Manager manager = new Manager("Rekha");
        manager.add(suraj);
        manager.add(mansi);
        manager.showDetails();
    }
}