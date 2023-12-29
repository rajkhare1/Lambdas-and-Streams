package com.rajkhare.streams;

import java.util.List;
import java.util.stream.Collectors;

public class FP02CollectingStreamElements {

	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		List<String> courses = List.of("Spring","Spring Boot","API","Microservices","AWS","PCF","Azure","Docker","Kubernates");
		List<Integer> evenNumbers = evenNumberList(numbers);
		System.out.println("evenNumberList: "+evenNumbers);
		List<String> lengthOfCourses = lengthOfCourseList(courses);
		System.out.println("lengthOfCourses: "+lengthOfCourses);

	}

	private static List<String> lengthOfCourseList(List<String> courses) {
		return courses.stream().map(course -> course+" "+course.length()).collect(Collectors.toList());
	}

	private static List<Integer> evenNumberList(List<Integer> numbers) {
		return numbers.stream().filter(number -> number%2==0).collect(Collectors.toList());
	}


}
