package com.rajkhare.fp.with.customclasses;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

record Course(String name, String category,int reviewScore, int noOfStudents) {};

public class FP04CustomClass {

	public static void main(String[] args) {
		
		List<Course> courses = List.of(
				new Course("Spring","Framework",98,20000),
				new Course("Spring Boot","Framework",95,18000),
				new Course("API","Microservices",97,22000),
				new Course("Microservices","Microservices",96,25000),
				new Course("FullStack","FullStack",91,14000),
				new Course("AWS","DevOps",92,21000),
				new Course("azure","DevOps",99,21000),
				new Course("Docker","DevOps",92,20000),
				new Course("Kubernates","DevOps",91,20000)
				);

		//allMatch, noneMatch, anyMatch
		boolean allMatch = courses.stream().allMatch(course -> course.reviewScore()>90);
		System.out.println(allMatch);
		
		boolean noneMatch = courses.stream().noneMatch(course -> course.reviewScore()<90);
		System.out.println(noneMatch);
		
		boolean anyMatch = courses.stream().anyMatch(course -> course.reviewScore()<90);
		System.out.println(anyMatch);
		boolean anyMatchGreaterThan95ReviewScore = courses.stream().anyMatch(course -> course.reviewScore()>95);
		System.out.println(anyMatchGreaterThan95ReviewScore);
		
		Comparator<Course> comparingBasedOnNoOfStudentsInIncreaseingOrder = Comparator.comparingInt(Course::noOfStudents);
		Comparator<Course> comparingBasedOnNoOfStudentsInDecreasingOrder = Comparator.comparingInt(Course::noOfStudents).reversed();
		courses.stream().sorted(comparingBasedOnNoOfStudentsInIncreaseingOrder).collect(Collectors.toList()).forEach(System.out::println);
		System.out.println("-----------------------------");
		courses.stream().sorted(comparingBasedOnNoOfStudentsInDecreasingOrder).collect(Collectors.toList()).forEach(System.out::println);
		
		Comparator<Course> comparingNoOfStudentAndReviewReversed = 
				Comparator.comparingInt(Course::noOfStudents)
				.thenComparingInt(Course::reviewScore)
				.reversed();
		System.out.println("-----------------------------");
		courses.stream().sorted(comparingNoOfStudentAndReviewReversed)
		.limit(5)
		.collect(Collectors.toList()).forEach(System.out::println);
		
		System.out.println("-------skip()---------");
		courses.stream().sorted(comparingNoOfStudentAndReviewReversed)
		.skip(3)
		.collect(Collectors.toList()).forEach(System.out::println);
		
		System.out.println("-------skip().limit()---------");
		courses.stream().sorted(comparingNoOfStudentAndReviewReversed)
		.skip(3)
		.limit(2)
		.collect(Collectors.toList()).forEach(System.out::println);
		
	}

}
