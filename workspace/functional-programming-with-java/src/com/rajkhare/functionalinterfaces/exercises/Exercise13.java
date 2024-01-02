package com.rajkhare.functionalinterfaces.exercises;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Exercise13 {

	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		List<Integer> squaredNumbers = createMappedList(numbers, x -> x * x);
		List<Integer> doubleNumbers = createMappedList(numbers, x -> 2 * x);
		System.out.println(squaredNumbers);
		System.out.println(doubleNumbers);

	}

	private static List<Integer> createMappedList(List<Integer> numbers, Function<Integer, Integer> mapper) {
		return numbers.stream().map(mapper).collect(Collectors.toList());
	}

}
