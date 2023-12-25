package com.rajkhare.exercises;
import java.util.List;

public class Exercise1And2 {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
		List<String> courses = List.of("Spring","Spring Boot","API","Microservices","AWS","PCF","Azure","Docker","Kubernates");
		printAllCoursesIndivisually(courses);
		printOddNumbersInListFunctional(numbers);
	}
	

	private static void printAllCoursesIndivisually(List<String> courses) {
    
		courses.stream()
			.forEach(System.out::println);

	}
	
	private static void printOddNumbersInListFunctional(List<Integer> numbers) {
	    
		numbers.stream()
			.filter(number -> number%2 == 1)
			.forEach(System.out::println);

	}

}
