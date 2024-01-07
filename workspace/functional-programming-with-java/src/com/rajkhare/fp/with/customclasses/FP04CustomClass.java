package com.rajkhare.fp.with.customclasses;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

record Course(String name, String category,int reviewScore, int noOfStudents) {

	@Override
	public String toString() {
		return name +":"+category +":"+ reviewScore +":"+ noOfStudents;
	}
	
};

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
		System.out.println("----sorted(comparingBasedOnNoOfStudentsInIncreaseingOrder)------");
		courses.stream().sorted(comparingBasedOnNoOfStudentsInIncreaseingOrder).collect(Collectors.toList()).forEach(System.out::println);
		System.out.println("----sorted(comparingBasedOnNoOfStudentsInDecreasingOrder)------");
		courses.stream().sorted(comparingBasedOnNoOfStudentsInDecreasingOrder).collect(Collectors.toList()).forEach(System.out::println);
		
		Comparator<Course> comparingNoOfStudentAndReviewReversed = 
				Comparator.comparingInt(Course::noOfStudents)
				.thenComparingInt(Course::reviewScore)
				.reversed();
		System.out.println("---sorted(comparingNoOfStudentAndReviewReversed).limit(5)------");
		courses.stream().sorted(comparingNoOfStudentAndReviewReversed)
		.limit(5)
		.collect(Collectors.toList()).forEach(System.out::println);
		
		System.out.println("-------sorted(comparingNoOfStudentAndReviewReversed.skip(3)---------");
		courses.stream().sorted(comparingNoOfStudentAndReviewReversed)
		.skip(3)
		.collect(Collectors.toList()).forEach(System.out::println);
		
		System.out.println("-------sorted(comparingNoOfStudentAndReviewReversed).skip(3).limit(2)---------");
		courses.stream().sorted(comparingNoOfStudentAndReviewReversed)
		.skip(3)
		.limit(2)
		.collect(Collectors.toList()).forEach(System.out::println);
		System.out.println("-----full course-----------");
		courses.stream().forEach(System.out::println);
		System.out.println("-------takeWhile()--------");
		courses.stream().takeWhile(course -> course.reviewScore()>=95).forEach(System.out::println);
		System.out.println("-----full course-----------");
		courses.stream().forEach(System.out::println);
		System.out.println("-------dropWhile()--------");
		courses.stream().dropWhile(course -> course.reviewScore()>=95).forEach(System.out::println);
		
		// find-out the single element from the list
		System.out.println("--------max()--------");
		System.out.println(
				courses.stream()
					.max(comparingNoOfStudentAndReviewReversed)
				);
		
		System.out.println("--------min()--------");
		System.out.println(
				courses.stream()
					.min(comparingNoOfStudentAndReviewReversed)
					.orElse(new Course("Kubernates","DevOps",91,20000))
				);
		
		
		//Optinal.empty
		System.out.println(
				courses.stream()
				.filter(course -> course.reviewScore()<90)
				.min(comparingNoOfStudentAndReviewReversed)
				.orElse(new Course("Kubernates","DevOps",91,20000))
				);
		
		System.out.println("---findFirst()");
		System.out.println(
				courses.stream()
				.filter(course -> course.reviewScore()>90)
				.findFirst()
				);
		
		System.out.println("---findAny()");
		System.out.println(
				courses.stream()
				.filter(course -> course.reviewScore()>90)
				.findAny()
				);
		
		System.out.println("---sum()");
		System.out.println(
				courses.stream()
				.filter(course -> course.reviewScore()>90)
				.mapToInt(Course::noOfStudents)
				.sum()//181000
				);
		
		System.out.println("---average()");
		System.out.println(
				courses.stream()
				.filter(course -> course.reviewScore()>90)
				.mapToInt(Course::noOfStudents)
				.average()//OptionalDouble[20111.11111111111
				);
		
		System.out.println("---count()");
		System.out.println(
				courses.stream()
				.filter(course -> course.reviewScore()>90)
				.mapToInt(Course::noOfStudents)
				.count()//9
				);

		System.out.println("---max()");
		System.out.println(
				courses.stream()
				.filter(course -> course.reviewScore()>90)
				.mapToInt(Course::noOfStudents)
				.max()//OptionalInt[25000]
				);
		
		System.out.println("---min()");
		System.out.println(
				courses.stream()
				.filter(course -> course.reviewScore()>90)
				.mapToInt(Course::noOfStudents)
				.min()//OptionalInt[14000]
				);
		
		//group-by courses based on some field
		System.out.println(
		courses.stream()
		.collect(Collectors.groupingBy(Course::category))
				);
//		{DevOps=[Course[name=AWS, category=DevOps, reviewScore=92, noOfStudents=21000], Course[name=azure, category=DevOps, reviewScore=99, noOfStudents=21000], Course[name=Docker, category=DevOps, reviewScore=92, noOfStudents=20000], Course[name=Kubernates, category=DevOps, reviewScore=91, noOfStudents=20000]], 
//		FullStack=[Course[name=FullStack, category=FullStack, reviewScore=91, noOfStudents=14000]], 
//		Microservices=[Course[name=API, category=Microservices, reviewScore=97, noOfStudents=22000], Course[name=Microservices, category=Microservices, reviewScore=96, noOfStudents=25000]], 
//		Framework=[Course[name=Spring, category=Framework, reviewScore=98, noOfStudents=20000], Course[name=Spring Boot, category=Framework, reviewScore=95, noOfStudents=18000]]}
		
		System.out.println(
				courses.stream()
				.collect(Collectors.groupingBy(Course::category, Collectors.counting()))
						);
		//{DevOps=4, FullStack=1, Microservices=2, Framework=2}
		
		System.out.println(
				courses.stream()
				.collect(Collectors.groupingBy(Course::category, 
						Collectors.maxBy(Comparator.comparing(Course::reviewScore))))
						);
		System.out.println(
				courses.stream()
				.collect(Collectors.groupingBy(Course::category,
						Collectors.mapping(Course::name, Collectors.toList())))
				);
//{DevOps=[AWS, azure, Docker, Kubernates], FullStack=[FullStack], Microservices=[API, Microservices], 
//		Framework=[Spring, Spring Boot]}
		
	}
	
	


}
