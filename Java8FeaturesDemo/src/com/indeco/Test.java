//package com.example.java8demo;
//
//import java.util.List;
//import java.util.NoSuchElementException;
//import java.util.Optional;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
////import org.junit.jupiter.api.Test;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class Java8demoApplicationTests {
//	
//	public Java8demoApplicationTests(){
//		
//	}
//
//	@Test
//	public void contextLoads() {
//	}
//
//	
//	@Autowired
//	EmployeeRepository repository;
//	
//	
////	@Test
//	public void findAllEmployees() {
//		List<Employee> employees = repository.findAll();
////		repository.findById
//		System.out.println(employees);
//		
//	}
//	
////	@Test
//	public void sortEmployees(){
//		Integer[] empIds = { 5, 6, 7, 8};
//		
//		List<Optional<Employee>> employees = Stream.of(empIds)
//		// Fetch All Employee with IDs
//		.map(repository::findById)
//		// Sort
//		.sorted((e1, e2) -> e1.get().getFirstName().compareTo(e2.get().getFirstName()))
//		// Print or store them in a collection
//		.collect(Collectors.toList());
//		
//		
//		System.out.println(employees);
//	
//	}
//	
//	
////	@Test
//	public void findEmployeeWithMinimumSalary(){
//		
//		Integer[] empIds = { 5, 6, 7, 8};
//		
//		Optional<Employee> employee = Stream.of(empIds)
//		.map(repository::findById)
//		.min((e1, e2) -> e1.get().getSalary().intValue() - e2.get().getSalary().intValue() )
//		.orElseThrow(NoSuchElementException::new);
//		
//		System.out.println(employee);
//		
//	}
//	
//	@Test
//	public void findEmployeeWithMinimumSalaryWithNumericStreams(){
//		
//		List<Employee> employees =  repository.findAll();
//		
//		Double empWithMinSalary = employees.stream()
////		.min( (e1, e2) -> e1.getSalary().intValue() - e2.getSalary().intValue() )
//		.mapToDouble(Employee::getSalary)
//		.min()
//		.orElseThrow(NoSuchElementException::new);
//		
//		System.out.println(empWithMinSalary);
//		
//	}
//	
//
//	
//
//	
//	
//
//}
