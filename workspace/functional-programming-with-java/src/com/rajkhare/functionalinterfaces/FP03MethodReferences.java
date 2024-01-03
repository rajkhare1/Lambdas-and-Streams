package com.rajkhare.functionalinterfaces;

import java.util.List;
import java.util.function.Supplier;

public class FP03MethodReferences {

	private static void print(String str) {
		System.out.println(str);
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {

		List<String> courses = List.of("Spring","Spring Boot","API","Microservices","AWS","PCF"
				,"Azure","Docker","Kubernates");
		
		courses.stream()
			.map(String::toUpperCase)//Method reference works as well on Object references also not only static
			.forEach(FP03MethodReferences::print);
	}
	
//	Supplier<String> supplier = () -> new String();
	Supplier<String> supplier = String::new;//Method reference also works on Constructor Reference.
	

}
