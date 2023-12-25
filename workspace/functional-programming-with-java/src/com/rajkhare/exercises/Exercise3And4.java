package com.rajkhare.exercises;
import java.util.List;

public class Exercise3And4 {

	public static void main(String[] args) {
		List<String> courses = List.of("Spring","Spring Boot","API","Microservices","AWS","PCF","Azure","Docker","Kubernates");
		printAllCoursesContaingWordSpring(courses);
		System.out.println("---------------------------");
		printAllCoursesWhooseNameAtleast4letters(courses);
	}
	

	private static void printAllCoursesContaingWordSpring(List<String> courses) {
    
		courses.stream()
		    .filter(course -> course.contains("Spring"))
			.forEach(System.out::println);

	}
	
	private static void printAllCoursesWhooseNameAtleast4letters(List<String> courses) {
	    
		courses.stream()
		    .filter(course -> course.length()>=4)
			.forEach(System.out::println);

	}
	
	
	

}
