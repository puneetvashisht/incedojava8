package com.indeco;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EmployeeTest {

	public static void main(String[] args) {
		
		List<Employee> employees = new ArrayList<>();
		
		Employee emp1 = new Employee(23, "Amit", "Sharma", 34534.33);
		Employee emp2 = new Employee(3, "Ravi", "Kumar", 54534.33);
		Employee emp3 = new Employee(43, "Venkat", "Raju", 44534.33);
		Employee emp4 = new Employee(49, "Karthik", "Kumar", 24534.33);
		
		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
		employees.add(emp4);
		
		// Sort operation
		System.out.println(employees);
		
//		Collections.sort(employees, new Comparator<Employee>() {
//
//			@Override
//			public int compare(Employee o1, Employee o2) {
//				// TODO Auto-generated method stub
//				return o1.salary.compareTo(o2.salary);
//			}
//		});
		// Print operation
//		print(employees, new Condition(){
//
//			@Override
//			public boolean test(Employee e) {
//
//				return true;
//			}
//			
//		});
//		print(employees, (e)->true);
		// Conditional Print
//		print(employees, new Condition(){
//
//			@Override
//			public boolean test(Employee e) {
//				return e.firstName.startsWith("A");
//			}
//			
//		});
		
		Collections.sort(employees, (o1, o2) -> o1.salary.compareTo(o2.salary));
		System.out.println(employees);
		print(employees, (e)->true, (e)->System.out.println(e));
		print(employees, (e)->e.firstName.startsWith("A"), System.out::println);
		print(employees, (e)->e.lastName.startsWith("K"), System.out::println);
		
	
		


	}
	
	static void print(List<Employee> employees, Predicate<Employee> predicate, Consumer<Employee> consumer){
		for(Employee e : employees){
			if(predicate.test(e)){
//				System.out.println(e);
				consumer.accept(e);
			}
			
		}
	}

}
@FunctionalInterface
interface Condition{
	boolean test(Employee e);
}
