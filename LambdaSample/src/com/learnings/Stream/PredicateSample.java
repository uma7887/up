/**
 * @author uma.s
 */
package com.learnings.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
/**
 * 
 * @author uma.s
 * To understand predicate which returns true or false
 */
public class PredicateSample {

	List<Employee> employee = Arrays.asList(new Employee(1, "uma", "vpm", "trainee", 20000, 123, "cisco"),
			new Employee(1, "deva", "pondy", "DO", 40000, 456, "cisco"),
			new Employee(2, "lokesh", "chennai", "senior software engg", 40000, 444, "cisco"),
			new Employee(3, "santhosh", "thrichy", "TL", 80000, 999, "cisco"),
			new Employee(4, "akshara", "chennai", "ADO", 10000, 778, "ciox"),
			new Employee(5, "nivetha", "chennai", "software engg", 80000, 900, "ciox")
			);	
	/**
	 * find employee's in cisco and their salary greater than 40000
	 * predicates: predicates are conditions, returns boolean based on condition
	 * predicates.and() : chaining multiple condition, returns true only if all condition is passed (logical AND)
	 * predicates.or() : chaining multiple condition, returns true only if anyone or all condition is passed (logical OR)
	 * predicates.negate() : returns negation of predicate value
	 * predicate.isEqual() : object.isEquals(), checks equality of two objects
	 */

	private void predicateDemo() {
		Predicate<Employee> isCisco = i -> i.getProjectName().equals("cisco");
		Predicate<Employee> checkSalaryGreater = i -> i.getSalary() >= 40000;

		List<Employee> predicatesAnd = processData (employee, checkSalaryGreater.and(isCisco));
		System.out.println("Predicate And"+predicatesAnd);

		List<Employee> predicatesOr = processData (employee, checkSalaryGreater.or(isCisco));
		System.out.println("Predicate OR"+predicatesOr);

		System.out.println(Predicate.isEqual(predicatesOr).test(predicatesAnd));
		System.out.println(Predicate.isEqual(predicatesOr).negate().test(predicatesAnd));
	}

	/**
	 * 
	 * @param employeeList
	 * @param predicateUser
	 * @return
	 * Evaluates this predicate on the given argument
	 */

	private List<Employee> processData(List<Employee> employeeList, Predicate<Employee> predicateUser) {
		List<Employee> result = new ArrayList<Employee>();
		for (Employee user : employeeList)        
			if (predicateUser.test(user))
				result.add(user);
		return result;
	}

	public static void main(String[] args) {
		PredicateSample predicateSample = new PredicateSample();
		predicateSample.predicateDemo();
	}
}
