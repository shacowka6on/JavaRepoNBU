import java.util.List;
 
public class Workers {
    private List<Employee> employees;
    private List<Manager> managers;
 
    private int lastEmployeeId = 1;
    private int lastManagerId = 1;
 
    public void addEmployee(Employee employee) {
        this.lastEmployeeId++;
        employee.id = this.lastEmployeeId;
        this.employees.add(employee);
    }
 
    public void addManager(Manager manager) {
        this.lastManagerId++;
        manager.id = this.lastManagerId;
        this.managers.add(manager);
    }
 
    public List<Employee> getEmployees() {
        return this.employees;
    }
 
    public List<Manager> getManagers() {
        return this.managers;
    }
 
    public void fireAllEmployees() {
        this.employees.clear();
    }
 
    public void fireAllManagers() {
        this.managers.clear();
    }
 
    public void fireOneEmployee(int index) {
        this.employees.remove(index);
    }
 
    public void fireOneManager(int index) {
        this.managers.remove(index);
    }
 
    class Employee {
        private String name;
        private double baseSalary;
        public int id;
 
        public Employee(String name, double baseSalary) {
            this.name = name;
            this.baseSalary = baseSalary;
        }
 
        public String getName() {
            return this.name;
        }
 
        public double getBaseSalary() {
            return this.baseSalary;
        }
 
        public int getEmployeeId() {
            return this.id;
        }
    }
 
    class Manager extends Employee {
        private double bonusPercentage;
 
        public Manager(String name, double baseSalary, double bonusPercentage) {
            super(name, baseSalary);
            this.bonusPercentage = bonusPercentage;
        }
 
        public void increaseSalary(double revenue, double revenueThreshold) {
            if (revenue > revenueThreshold) {
                super.baseSalary = super.baseSalary + (super.baseSalary * bonusPercentage / 100);
                return;
            }
            System.out.println("Cant increase Salary of manager");
        }
    }
}
