package com.learnings.Stream;

import java.util.Arrays;
import java.util.List;

public class LambdaSample {
	
	List<Employee> employee = Arrays.asList(new Employee(1, "uma", "vpm", "trainee", 20000, 123, "cisco"),
			new Employee(2, "deva", "pondy", "DO", 40000, 456, "cisco"),
			new Employee(3, "lokesh", "chennai", "senior software engg", 40000, 444, "cisco"),
			new Employee(4, "santhoshR", "thrichy", "TL", 80000, 999, "cisco"),
			new Employee(4, "santhosh", "thrichy", "TL", 80000, 999, "cisco"),
			new Employee(5, "akshara", "chennai", "ADO", 10000, 778, "ciox"),
			new Employee(6, "nivetha", "chennai", "software engg", 80000, 900, "ciox")
			);
	
	public void simpleLambdaExample () {
		int total = employee.stream()
                .filter(i -> i.getSalary() >= 20000)
                .mapToInt(LambdaSample::getAmount)
                .sum();
		System.out.println(total);
	}
	
	public static int getAmount(Employee emp) {
		int i = emp.getSalary();
		return i;
	}
	
	public static void main(String[] args) {
		LambdaSample lambdaSample = new LambdaSample();
		lambdaSample.simpleLambdaExample();
	}
}
