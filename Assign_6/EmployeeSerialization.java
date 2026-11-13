
import java.io.*;
import java.util.ArrayList;

class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    int empId;
    String name;
    String department;
    double salary;

    Employee(int empId, String name, String department, double salary) {

        this.empId = empId;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    void display() {

        System.out.println("Employee ID: " + empId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);

        System.out.println("---------------------");
    }
}

public class EmployeeSerialization {

    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Employee(101, "Sparsh", "IT", 50000));
        employees.add(new Employee(102, "Rahul", "HR", 45000));
        employees.add(new Employee(103, "Aman", "Finance", 60000));

        try (
                ObjectOutputStream oos = new ObjectOutputStream(
                        new FileOutputStream("employees.dat"))) {

            oos.writeObject(employees);

            System.out.println("Employees serialized successfully!");

        } catch (IOException e) {

            System.out.println("Serialization Error: " + e.getMessage());

        }

        try (
                ObjectInputStream ois = new ObjectInputStream(
                        new FileInputStream("employees.dat"))) {

            ArrayList<Employee> retrievedEmployees = (ArrayList<Employee>) ois.readObject();

            System.out.println("\nRetrieved Employee Records:");

            for (Employee emp : retrievedEmployees) {

                emp.display();
            }

        } catch (IOException | ClassNotFoundException e) {

            System.out.println("Deserialization Error: " + e.getMessage());

        }
    }
}
