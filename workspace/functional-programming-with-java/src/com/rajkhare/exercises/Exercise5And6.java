package com.rajkhare.exercises;
import java.util.List;

public class Exercise5And6 {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
		List<String> courses = List.of("Spring","Spring Boot","API","Microservices","AWS","PCF","Azure","Docker","Kubernates");
		printCubesOfTheOddNumbersInListFunctional(numbers);
		System.out.println("----------------------------");
		printNumberOfCharactersInEachCourseName(courses);
	}
	

	private static void printNumberOfCharactersInEachCourseName(List<String> courses) {
    
		courses.stream()
		.map(course -> course+" "+course.length())
			.forEach(System.out::println);

	}
	
	private static void printCubesOfTheOddNumbersInListFunctional(List<Integer> numbers) {
	    
		numbers.stream()
			.filter(number -> number%2 == 1)
			.map(number -> number * number * number)
			.forEach(System.out::println);

	}

}
