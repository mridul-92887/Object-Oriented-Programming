import java.util.ArrayList;

class Employee {
    protected String name;
    protected int ID;
    protected double salary;

    public Employee(String name, int ID, double salary) {
        this.name = name;
        this.ID = ID;
        this.salary = salary;
    }

    public double calculateSalary() {
        return salary;
    }

    public void displayDetails() {
        System.out.println("Name: " + name + ", ID: " + ID + ", Salary: $" + salary);
    }
}

abstract class PermanentEmployee extends Employee {
    protected double bonus;

    public PermanentEmployee(String name, int ID, double salary, double bonus) {
        super(name, ID, salary);
        this.bonus = bonus;
    }

    public abstract double calculateSalary();

    public double getBonus() {
        return bonus;
    }

    @Override
    public void displayDetails() {
        System.out.println("Name: " + name + ", ID: " + ID + ", Salary: $" + salary + ", Bonus: $" + bonus);
    }
}

class FullTimeEmployee extends PermanentEmployee {
    public FullTimeEmployee(String name, int ID, double salary, double bonus) {
        super(name, ID, salary, bonus);
    }

    @Override
    public double calculateSalary() {
        return salary + bonus;
    }

    @Override
    public void displayDetails() {
        System.out.println("Name: " + name + ", ID: " + ID + ", Base Salary: $" + salary + ", Bonus: $" + bonus + ", Total Salary: $" + calculateSalary());
    }
}

class ContractEmployee extends Employee {
    private int contractPeriod;

    public ContractEmployee(String name, int ID, double salary, int contractPeriod) {
        super(name, ID, salary);
        this.contractPeriod = contractPeriod;
    }

    @Override
    public double calculateSalary() {
        return salary * contractPeriod;
    }

    public int getContractPeriod() {
        return contractPeriod;
    }

    @Override
    public void displayDetails() {
        System.out.println("Name: " + name + ", ID: " + ID + ", Monthly Salary: $" + salary + ", Contract Period: " + contractPeriod + " months, Total Contract Value: $" + calculateSalary());
    }
}

public class lab_51
 {
    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new FullTimeEmployee("John Doe", 101, 5000, 1000));
        employees.add(new ContractEmployee("Jane Smith", 102, 3000, 6));
        employees.add(new FullTimeEmployee("Alice Brown", 103, 6000, 1500));
        employees.add(new ContractEmployee("Bob Johnson", 104, 3500, 12));

        double totalPayroll = 0;

        for (Employee emp : employees) {
            totalPayroll += emp.calculateSalary();
            if (emp instanceof FullTimeEmployee)
                System.out.println(emp.ID + " - " + emp.name + " (Permanent) : $" + emp.calculateSalary());
            else
                System.out.println(emp.ID + " - " + emp.name + " (Contract) : $" + emp.calculateSalary());
        }

        System.out.println("Total Payroll: $" + totalPayroll);
    }
}
