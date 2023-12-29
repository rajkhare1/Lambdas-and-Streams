package com.rajkhare.streams;

import java.util.Comparator;
import java.util.List;

public class FP02StreamOperations {

	public static void main(String[] args) {

		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		List<String> courses = List.of("Spring","Spring Boot","API","Microservices","AWS","PCF","Azure","Docker","Kubernates");
		System.out.println("--------forEach()------------");
		showAllTheElementsInTheList(numbers);
		System.out.println("-------distinct()-----------");
		showDistinctNumbersInTheList(numbers);
		System.out.println("--------sorted()----------");
		showSortedList(numbers);
		System.out.println("::::::");
		showSortedListString(courses);
		System.out.println("--------sorted(Comparator.naturalOrder())----------");
		showSortedListInNaturalOrder(courses);
		System.out.println("--------sorted(Comparator.reverseOrder())----------");
		showSortedListInReverseOrder(courses);
		System.out.println("--------sorted(Comparator.comparing(str -> str.length())----------");
		showSortedListInCustomizeOrder(courses);
		System.out.println("-------distinct().sorted()-----------");
		showDistinctSortedList(numbers);
	}
	
	private static void showSortedListInCustomizeOrder(List<String> courses) {
		courses.stream().sorted(Comparator.comparing(str -> str.length())).forEach(System.out::println);
		
	}

	private static void showSortedListInReverseOrder(List<String> courses) {
		courses.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);		
	}

	private static void showSortedListInNaturalOrder(List<String> courses) {
		courses.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);		
	}

	private static void showSortedListString(List<String> courses) {
		courses.stream().sorted().forEach(System.out::println);
		
	}

	private static void showAllTheElementsInTheList(List<Integer> numbers) {
		numbers.stream().forEach(System.out::println);
		
	}

	private static void showDistinctSortedList(List<Integer> numbers) {
		numbers.stream().distinct().sorted().forEach(System.out::println);
		
	}

	private static void showSortedList(List<Integer> numbers) {
		numbers.stream().sorted().forEach(System.out::println);
		
	}

	private static void showDistinctNumbersInTheList(List<Integer> numbers) {
		numbers.stream().distinct().forEach(System.out::println);
		
	}


}
