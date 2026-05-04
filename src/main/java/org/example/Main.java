package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        LinkedList<Employee> employees = new LinkedList<>();

        employees.add(new Employee(1, "Ali", "Yılmaz"));
        employees.add(new Employee(2, "Ayşe", "Demir"));
        employees.add(new Employee(3, "Mehmet", "Kaya"));

        employees.add(new Employee(1, "Ali", "Yılmaz"));
        employees.add(new Employee(2, "Ayşe", "Demir"));
    }
    public static List<Employee> findDuplicates(List<Employee> empList){
        Set<Integer> seen = new HashSet<>();
        List<Employee> duplicates = new LinkedList<>();
        for(Employee emp : empList){
            if (emp == null || emp.getId() == 0) continue;
            if (!seen.add(emp.getId())) {
                duplicates.add(emp);
            }
        }
        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> list) {
        Map<Integer, Employee> result = new HashMap<>();
        for (Employee e : list) {
            if (e == null) continue;

            if (!result.containsKey(e.getId())) {
                result.put(e.getId(), e);
            }
        }

        return result;
    }

    public static List<Employee> removeDuplicates(List<Employee> list) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (Employee e : list) {
            if (e == null) continue;
            countMap.put(e.getId(), countMap.getOrDefault(e.getId(), 0) + 1);
        }

        List<Employee> result = new ArrayList<>();

        for (Employee e : list) {
            if (e == null) continue;
            Integer count = countMap.get(e.getId());

            if (count != null && count == 1) {
                result.add(e);
            }
        }

        return result;
    }
}