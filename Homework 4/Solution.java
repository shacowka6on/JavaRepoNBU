import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

enum Contract {
    PERMANENT,
    PART_TIME,
    TRAINEE;
}

class Employee {
    String Id;
    String Name;
    int WorkedHours;
    BigDecimal AditionalSalary;
    Contract Contract;

    Employee(String name, int workedHours, BigDecimal aditionalSalary, Contract contract) {
        this.Name = name;
        this.WorkedHours = workedHours <= 0 ? 1 : workedHours;
        this.AditionalSalary = aditionalSalary;
        this.Contract = contract;
    }

    BigDecimal Salary(double minSalaryPermanent, double minSalaryPartTime, double minSalaryTrainee) {
        BigDecimal result = BigDecimal.valueOf(0);

        if (this.Contract == Contract.PERMANENT) {
            result = BigDecimal.valueOf(minSalaryPermanent);
        } else if (this.Contract == Contract.PART_TIME) {
            result = BigDecimal.valueOf(minSalaryPartTime);
        } else {
            result = BigDecimal.valueOf(minSalaryTrainee);
        }
        return (result.add(this.AditionalSalary)).multiply(BigDecimal.valueOf(this.WorkedHours));
    }

    void increaseSalaries(BigDecimal increase) {
        BigDecimal increaseFactor = increase
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP)
                .add(BigDecimal.ONE);

        this.AditionalSalary = this.AditionalSalary.multiply(increaseFactor);
    }
}

class Company {
    String CompanyName;
    int CompanySize;
    double minSalaryPermanent;
    double minSalaryPartTime;
    double minSalaryTrainee;
    List<Employee> Employees;

    Company(String name,
            int companySize,
            double minSalaryPERMANENT,
            double minSalaryPART_TIME,
            double minSalaryTRAINEE) 
    {
        this.CompanyName = name;
        this.CompanySize = companySize;
        this.minSalaryPermanent = minSalaryPERMANENT;
        this.minSalaryPartTime = minSalaryPART_TIME;
        this.minSalaryTrainee = minSalaryTRAINEE;
        this.Employees = new ArrayList<>();
    }

    void HireEmployee(Employee employee) {
        if (this.CompanySize == this.Employees.size()) {
            return;
        }
        for (int i = 0; i < this.Employees.size(); i++) {
            if (this.Employees.get(i).Name.equals(employee.Name)) {
                return;
            }
        }

        this.Employees.add(employee);
    }

    BigDecimal AverageSalary() {
        BigDecimal averageSalary = BigDecimal.valueOf(0);
        for (int i = 0; i < this.Employees.size(); i++) {
            averageSalary = averageSalary
                    .add(this.Employees.get(i).Salary(
                            this.minSalaryPermanent,
                            this.minSalaryPartTime,
                            this.minSalaryTrainee));
        }
        if (this.Employees.size() != 0) {
            return averageSalary.divide(BigDecimal.valueOf(this.Employees.size()), 2, RoundingMode.HALF_UP);
        }
        return BigDecimal.valueOf(0);
    }

    void IncreaseSalaries(BigDecimal increasePercentage) {
        if (increasePercentage.compareTo(BigDecimal.ZERO) <= 0) {
            return;
        }
        for (int i = 0; i < this.Employees.size(); i++) {
            this.Employees.get(i).increaseSalaries(increasePercentage);
        }
    }

    void FireEmployee(String name) {
        for (int i = 0; i < this.Employees.size(); i++) {
            if (this.Employees.get(i).Name.equals(name)) {
                this.Employees.remove(i);
                break;
            }
        }
    }

    BigDecimal AverageSalaryByType(Contract contact) {
        BigDecimal result = BigDecimal.valueOf(0);
        int counter = 0;
        for (int i = 0; i < this.Employees.size(); i++) {
            if (this.Employees.get(i).Contract == contact) {
                result = result.add(
                        this.Employees.get(i).Salary(
                                this.minSalaryPermanent,
                                this.minSalaryPartTime,
                                this.minSalaryTrainee));
                counter++;
            }
        }
        if (counter != 0) {
            return result.divide(BigDecimal.valueOf(counter), 2, RoundingMode.HALF_UP);
        }
        return BigDecimal.valueOf(0);
    }
}

/*------------------------------Method used for testing------------------------------*/
class Solution {
    public static void main(String[] args) {
        String companyName = "TechComp";
        int maxNumberOfEmployees = 5;
        List<Double> minSalaryList = Arrays.asList(20.0, 15.0, 10.0);
        List<String> namesList = Arrays.asList("Maria", "Anna", "Pavel", "Monika", "Toni", "Moni");
        List<Integer> workedHoursList = Arrays.asList(60, 100, 150, 80, 150, 80);
        List<String> contractTypeList = Arrays.asList("PERMANENT", "PERMANENT", "PART_TIME", "PERMANENT", "PERMANENT",
                "PART_TIME");
        List<Double> additionalSalaryList = Arrays.asList(20.0, 40.0, 20.0, 20.0, 20.0, 40.0);
        String contractType = "PERMANENT";
        double increasePercentage = 5;

        Company company = new Company(companyName, maxNumberOfEmployees, minSalaryList.get(0), minSalaryList.get(1),
                minSalaryList.get(2));

        for(int i = 0; i < namesList.size(); i++){
            Employee employee = new Employee(
                namesList.get(i), 
                workedHoursList.get(i), 
                BigDecimal.valueOf(additionalSalaryList.get(i)), 
                Contract.valueOf(contractTypeList.get(i)));
         
            company.HireEmployee(employee);
        }
        
        System.out.println(company.AverageSalary());
        company.IncreaseSalaries(BigDecimal.valueOf(increasePercentage));
        System.out.println(company.AverageSalary());
        System.out.println(company.AverageSalaryByType(Contract.valueOf(contractType)));

    }
}

/*------------------------------Method used in Hackerrank------------------------------
public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    String companyName = bufferedReader.readLine();

    int maxNumberOfEmployees = Integer.parseInt(bufferedReader.readLine().trim());

    List<Double> minSalaryList = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Double::parseDouble)
        .collect(toList());

    List<String> namesList = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .collect(toList());

    List<Integer> workedHoursList = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    List<String> contractTypeList = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .collect(toList());

    List<Double> additionalSalaryList = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Double::parseDouble)
        .collect(toList());

    String contractType = bufferedReader.readLine();

    double increasePercentage = Double.parseDouble(bufferedReader.readLine().trim());

    // Set the min salary per hour, that depends on the contract type. Use the values in the minSalaryList: 
    // the first value is for PERMANENT, the second is for PART_TIME, the third is for TRAINEE

    // Create company by using companyName and maxNumberOfEmployees

    // Create 6 employees by using the values in the 
    // namesList, workedHoursList, contractTypeList, and additionalSalaryList. 
    // Example for creating the first employee: 
    // Employee employee1 = new Employee(namesList.get(0), workedHoursList.get(0), BigDecimal.valueOf(additionalSalaryList.get(0)), ContractType.valueOf(contractTypeList.get(0)));

    // Hire all the 6 employees to work at the company

    // Print the result of calling the method averageSalary()

    // Increase the additional salary per hour, by calling the method increaseSalaries(). 
    // Use increasePercentage as an argument: company.increaseSalaries(BigDecimal.valueOf(increasePercentage));

    // Print the result of calling the method averageSalary(), 
    // after increasing the additional salary per hour of all employees.

    // Print the result of calling the method averageSalaryByType(). 
    // Use the string contractType with ContractType.valueOf() method to pass it as argument:
    // System.out.println(company.averageSalaryByType(ContractType.valueOf(contractType)));

    bufferedReader.close();
}
*/