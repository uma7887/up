package com.learnings.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 
 * @author uma.s
 * To demonstrate stream
 * Stream is a Internal iteration, which uses SplitIterator and API in Stream mostly uses functional Interface,
 * so, we can implement lambda on it easily.
 * Streams are Consumable, so no more interaction on data produced by then
 */
public class StreamsSampleImpl implements StreamSample {
	
	List<Employee> employee = Arrays.asList(new Employee(1, "uma", "vpm", "trainee", 20000, 123, "cisco"),
			new Employee(2, "deva", "pondy", "DO", 40000, 456, "cisco"),
			new Employee(3, "lokesh", "chennai", "senior software engg", 40000, 444, "cisco"),
			new Employee(4, "santhoshR", "thrichy", "TL", 80000, 999, "cisco"),
			new Employee(4, "santhosh", "thrichy", "TL", 80000, 999, "cisco"),
			new Employee(5, "akshara", "chennai", "ADO", 10000, 778, "ciox"),
			new Employee(6, "nivetha", "chennai", "software engg", 80000, 900, "ciox")
			);
	/**
	 * Stream.of() is used to create new stream of type
	 * and by chaining we can apply Stream methods
	 */
	public void countEmployee() {
		
		Stream<String> employeeStream = Stream.of("uma", "deva", "santhosh");
		long count = employeeStream.count();
		System.out.println(count);
	}
	
	/**
	 * stream() : produces a sequential split iteration of employee (java.util.Collections)
	 * filter() : gets single object from stream and checks predicate and returns stream of predicate passed value
	 * map() 	: returns stream of current data of any type // useful on using class as type // 
	 * count() 	: returns count the current stream of type Long
	 */
	public void streamDataFilter() {
		List<Boolean> count = employee.stream()
							  		  .filter(i -> i.getSalary() >= 40000)
							  		  .peek(System.out::println)
							  		  .map(i -> i.getProjectName().equals("cisco"))
							  		  .peek(System.out::println)
							  		  .collect(Collectors.toList());
		System.out.println("Filter"+count);
	}
	
	/**
	 * distinct() : uses Object.equals(Object), so we need to override HashCode() and equals()
	 * count() 	: returns count the current stream of type Long
	 */
	public void streamDataDistinct() {
		List<Employee> countDistinct = employee.stream()
				 		.distinct()
				 		.collect(Collectors.toList());
		System.out.println("number of distinct elements: "+countDistinct);
	}
	
	/**
	 * findAny() : works better with parallelStream(), it provides any instances that matches on parallelStream
	 * and sort order is not considered
	 * findFirst() : finds first in sorted stream()
	 */
	public void streamDataFindAny() {
		Optional<Employee> findAny = 
				employee.parallelStream()
						.filter(i -> i.getId() == 4)
				 		.findAny();
		System.out.println("findAny : "+ findAny);

		Optional<Employee> findFirst = 
				employee.stream()
						.filter(i -> i.getId() == 4)
				 		.findFirst();
		System.out.println("findFirst : "+ findFirst);
	}
	
	/**
	 * allMatch() : a stream that returns boolean, whether any the current stream matches the condition
	 */
	public void streamDataMap() {
		boolean isGreaterThanFive = employee.stream()
							 .filter(i -> i.getSalary() >= 40000) //stream of predicates that passed the condition
							 .mapToLong(i -> i.getId()) // stream of long
							 .anyMatch(i -> { // checks if condition matches and returns boolean
								 if(i % 2 == 0) {
									 System.out.println("result for i >= 5 " + i); // lambda-anonymous inner class
									 return true;
								 }
								return false;
							 });							 
		System.out.println(isGreaterThanFive);		
	}
	
	/**
	 * allMatch() : a stream that returns boolean, whether all the current stream matches the condition
	 */
	public void streamDataAllMatch() {
		
		Predicate<Employee>  checkAllMatchPredicate = i -> i.getProjectName().equals("cisco"); 
		
		boolean isAllMatchCisco = employee.stream()
							 			  .filter(i -> i.getProjectName().equals("cisco"))
							 			  .allMatch(checkAllMatchPredicate);
		System.out.println("all match sample"+isAllMatchCisco);	
	}
	
	/**
	 * flatMap() : allows nested stream, useful when having one to many mapping (Stream<Stream<R>>)
	 * flatMap provides flattened streams
	 * 
	 */
	public void streamFlatMap() {
		List<String> flatMapSample = employee.stream()
											 .flatMap(i -> Stream.of(i.getName().toUpperCase()))
											 .collect(Collectors.toList());
		System.out.println(flatMapSample);
	}
	
	/**
	 * flatMapToInt() : flattens integer stream
	 * forEach() : performs action on current stream
	 * limit() 	 : limits the streams to size and truncates other streams 
	 * skip() 	 : skips n elements in stream
	 */
	public void streamForEach() {
		employee.stream()
				.flatMapToInt(i -> IntStream.of((int)i.getId() + 1))
				.limit(4)
				.skip(2)
				.forEach(System.out::println);
				//.forEach(i -> System.out.println(i));
	}
	/**
	 * peek() : useful for debugging
	 */
	public void streamPeek() {
		List<Employee> emp = employee.stream()
				.filter(i -> i.getId() == 1)
				.peek(System.out::println)
				.collect(Collectors.toList());
		System.out.println(emp);
	}

	public void sampleDemo() {
		List<Employee> emp = employee.stream()
									 .filter(i -> i.getName() == "uma")
									 .collect(Collectors.toList());
		System.out.println(emp);
	}
	public static void main(String[] args) {
		StreamsSampleImpl streamSample = new StreamsSampleImpl();
		streamSample.countEmployee();
		streamSample.streamDataFilter();
		streamSample.streamDataMap();
		streamSample.streamDataAllMatch();
		streamSample.streamDataDistinct();
		streamSample.streamDataFindAny();
		streamSample.streamFlatMap();
		streamSample.streamForEach();
		streamSample.streamPeek();
	}
}
