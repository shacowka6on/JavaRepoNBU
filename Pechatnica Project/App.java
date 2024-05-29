public class App{
   public static void main(String[] args) {
     Pechatnica pechatnica = new Pechatnica(1000);
     pechatnica.buyPapers(20, paperSize.A5);
 
     Workers workers = new Workers();
     Workers.Employee employee = workers.new Employee("Ivo", 20);
 
     pechatnica.workers.addEmployee(employee);
     System.out.println(pechatnica.workers.getEmployees().get(0).getName());
   }
}
 
