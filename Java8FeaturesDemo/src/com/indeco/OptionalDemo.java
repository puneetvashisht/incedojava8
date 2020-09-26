package com.indeco;

import java.util.Optional;

public class OptionalDemo {

	public static void main(String[] args) {
		Optional<String> empty =  Optional.empty();
		System.out.println(empty.isPresent());
		
		
		String value = "puneet";
		Optional<String> opt = Optional.of(value);
		System.out.println(opt.isPresent());
		
		value = null;
		Optional<String> opt1 = Optional.ofNullable(value);
		System.out.println(opt1.isPresent());
		
//		String name = Optional.ofNullable(value).orElse("Puneet");
		String name = Optional.ofNullable(value).orElseGet(()->"Vashisht");
		System.out.println(name);
		
		
		String name1 = opt.get();
		System.out.println(name1);
		
		Integer year = null;
		Optional<Integer> yearOptional = Optional.of(year);
		boolean flag= yearOptional.filter(y -> y == 2020).isPresent();
		System.out.println(flag);
		year.intValue();
		

	}

}
