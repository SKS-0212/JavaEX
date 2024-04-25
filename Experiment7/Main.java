package University.Java_Using_Project.Experiment7;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


record Employee(int id, String name, int age, double salary) {
    @Override
    public int id() {
        return id;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public int age() {
        return age;
    }

    @Override
    public double salary() {
        return salary;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + age + " " + salary;
    }
}

class EmployeeManagement {

    public void addAnEmployee(Employee employee) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("res/employee.txt", true))) {
            writer.write(employee.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error Occurred!!!");
        }
    }

    public void displayAll() {
        ArrayList<Employee> employees = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("res/employee.txt"))) {
            String data;
            while ((data = reader.readLine()) != null) {
                String[] str = data.split(" ");
                int id = Integer.parseInt(str[0]);
                String name = str[1];
                int age = Integer.parseInt(str[2]);
                double salary = Double.parseDouble(str[3]);
                employees.add(new Employee(id, name, age, salary));

            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error Occurred: " + e.getMessage());
        }
        for (Employee employee : employees) {
            System.out.println("Name: " + employee.name() +
                    " UID: " + employee.id() +
                    " Age: " + employee.age() +
                    " Salary: " + employee.salary());
        }
    }

    void run(Scanner in) {
        while (true) {
            System.out.println("\nEnter 1 for Add an Employee");
            System.out.println("Enter 2 for Display All");
            System.out.println("Enter 3 for Exit\n");
            System.out.print("Enter your choice:");
            int choice = in.nextInt();
            switch (choice) {
                case 1: {
                    System.out.print("Enter the Employee Id: ");
                    int id = in.nextInt();
                    in.nextLine();
                    System.out.print("Enter the Employee Name: ");
                    String name = in.nextLine();
                    System.out.print("Enter the Employee Age: ");
                    int age = in.nextInt();
                    System.out.print("Enter the Employee Salary: ");
                    double salary = in.nextDouble();
                    addAnEmployee(new Employee(id, name, age, salary));
                }
                break;
                case 2: {
                    displayAll();
                }
                break;
                case 3: {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                break;
                default: {
                    System.out.println("Wrong Choice!!!");
                }break;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        EmployeeManagement system = new EmployeeManagement();
        system.run(in);
        in.close();
    }
}
