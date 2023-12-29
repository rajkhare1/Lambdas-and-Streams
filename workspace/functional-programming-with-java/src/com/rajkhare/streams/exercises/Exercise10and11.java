package com.rajkhare.streams.exercises;

import java.util.List;
import java.util.stream.Collectors;

public class Exercise10and11 {

	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		List<Integer> squaredNumbers = squareList(numbers);
		System.out.println(squaredNumbers);

	}

	private static List<Integer> squareList(List<Integer> numbers) {
		return numbers.stream().map(number -> number * number).collect(Collectors.toList());
	}

}
