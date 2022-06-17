package _6_DefiningClasses.ex_2_CompanyRoster;

/*
Define a class Employee that holds the following information:
name, salary, position, department, email, and age.
The name, salary, position, and department are mandatory while the rest are optional.
Your task is to write a program that takes N lines of information about employees
from the console and calculates the department with the highest average salary
and prints for each employee in that department his name, salary, email,
and age - sorted by salary in descending order. If an employee doesn’t have
an email – in place of that field you should print "n/a" instead, if he doesn’t
have an age – print "-1" instead. The salary should be printed to two decimal places after the separator.
Hint: you can define a Department class that holds a list of employees.

Examples
Input	                                                                                    Output
4
Peter 120.00 Dev Development peter@abv.bg 28
Tina 333.33 Manager Marketing 33
Sam 840.20 ProjectLeader Development sam@sam.com
George 0.20 Freeloader Nowhere 18	                                                    Highest Average Salary: Development
                                                                                        Sam 840.20 sam@sam.com -1
                                                                                        Peter 120.00 peter@abv.bg 28

 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countOfEmployee = Integer.parseInt(scanner.nextLine());
        ArrayList<Employee> employees = new ArrayList<>();
        //Кой е най-високо платеният отдел???
        //Принтираме служителите в низходящ ред по зплатата от този отдел
        List<Department> departmentList = new ArrayList<>();
        //
        for (int i = 0; i < countOfEmployee; i++) {
            String[] employeeInfo = scanner.nextLine().split(" ");
            String name = employeeInfo[0];
            double salary = Double.parseDouble(employeeInfo[1]);
            String position = employeeInfo[2];
            String department = employeeInfo[3];
            Employee employee = null;
            switch (employeeInfo.length){
                case 4: //NO email, NO age
                    employee = new Employee(name, salary, position, department);
                    break;
                case 6: // HAS email, HAS age
                    String email = employeeInfo[4];
                    int age = Integer.parseInt(employeeInfo[5]);
                    employee = new Employee(name, salary, position, department, email, age);
                    break;
                case 5: // Или email Или age
                    if(employeeInfo[4].matches("\\d+")){
                        int personAge = Integer.parseInt(employeeInfo[4]);
                        employee = new Employee(name, salary, position, department, personAge);
                    } else {
                        String personEmail = employeeInfo[4];
                        employee = new Employee(name, salary, position, department, personEmail);
                    }
                    break;
            }
//            departmentList.putIfAbsent(department, new Department(department));
            boolean departmentExists = departmentList.stream().filter(dep -> dep.getName().equals(department)).count() >= 1;
            if(!departmentExists){
                departmentList.add(new Department(department));
            }
            Department currentDepartment = departmentList.stream().filter(dep -> dep.getName().equals(department)).findFirst().get();
            currentDepartment.getEmployees().add(employee);
        }

        Department highestPaidDepartment = departmentList.stream()
                .max(Comparator.comparingDouble(department -> department.calculateAverageSalary()))
                .get();
        System.out.printf("Highest Average Salary: %s%n", highestPaidDepartment.getName());

        highestPaidDepartment.getEmployees().stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(System.out::println);


    }
}
