package ritu.Java8;

import ritu.EmployeeTest;

import java.util.*;
import java.util.stream.Collectors;

public class Employee {

    private  int id;
    private String name;
    private String gender;
    private String department;
    private int age;
    private double salary;
    private List<String> skills;

    // Original constructor (kept for backward compatibility)
    public Employee(int id, String name, String gender,
                    String department, int age, double salary) {
        this(id, name, gender, department, age, salary, new ArrayList<>());
    }

    // New constructor including skills
    public Employee(int id, String name, String gender,
                        String department, int age, double salary,
                        List<String> skills) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.department = department;
        this.age = age;
        this.salary = salary;
        this.skills = skills;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", department='" + department + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", skills=" + skills +
                '}';
    }
}

class EmployeeAge {
    public static void main(String[] args) {

        List<Employee> emp = Arrays.asList(
                new Employee(0, "Kapur", "M", "OP", 25, 45000,
                        Arrays.asList("Operations", "Excel")),
                new Employee(1, "Kunal", "M", "HR", 28, 55000,
                        Arrays.asList("Recruitment", "Communication")),
                new Employee(2, "Kunali", "F", "IT", 24, 60000,
                        Arrays.asList("Java", "SQL")),
                new Employee(3, "Ritu", "F", "IT", 31, 85000,
                        Arrays.asList("Java", "Spring Boot", "AWS")),
                new Employee(4, "Deepak", "M", "HR", 30, 70000,
                        Arrays.asList("Payroll", "Negotiation")),
                new Employee(5, "Dileep", "M", "Chemistry", 35, 90000,
                        Arrays.asList("Lab Analysis", "Research")),
                new Employee(6, "Shubham", "M", "Physics", 27, 65000,
                        Arrays.asList("Thermodynamics", "Python")),
                new Employee(7, "Pallavi", "F", "HR", 29, 75000,
                        Arrays.asList("Training", "Onboarding")));
        Map<String, Map<String, Long>> gendercount = emp.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.groupingBy(
                                Employee::getGender,
                                Collectors.counting()
                        )
                ));

        System.out.println("Gender count by department: " + gendercount);


        // Group employees by department and calculate average salary
        Map<String, Double> averageSalaryByDepartment = emp.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

        System.out.println("Average salary by department: " + averageSalaryByDepartment);


    // Group employees by department and highest salry in each department


    // Group employees by department and highest salary in each department
    Map<String , Optional<Employee>> highestSalaryByDepartment = emp.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment,
                    Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
        System.out.println(highestSalaryByDepartment);


     //second highest salary by department
        Map<String, Optional<Employee>> secondHighestSalaryByDepartment = emp.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream()
                                        .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                                        .skip(1)
                                        .findFirst()
                        )
                ));

        System.out.println("Second highest salary by department: " + secondHighestSalaryByDepartment);


        // max skill in each department
        Map<String, Employee> maxSkillByDepartment = emp.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt((Employee e )-> e.getSkills().size())
                                        .thenComparingDouble(Employee::getSalary)),
                                Optional::get
                        )
                ));

        System.out.println("Max skill by department: " + maxSkillByDepartment);


        // //Convert List<Employee> to Map<dept, Map<name, salary>>.

        Map<String,Map<Double, String>> result = emp.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.toMap(Employee::getSalary, Employee::getName)));
        System.out.println(result
        );
}}
