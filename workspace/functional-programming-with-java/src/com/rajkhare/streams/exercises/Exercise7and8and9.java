package com.rajkhare.streams.exercises;

import java.util.List;

public class Exercise7and8and9 {

	public static void main(String[] args) {

		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		int sumOfSquares = sumOfSquaresOfNumbersInTheList(numbers);
		System.out.println("sumOfSquares: "+sumOfSquares);
		int sumOfCubes = sumOfCubesOfNumbersInTheList(numbers);
		System.out.println("sumOfCubes: "+sumOfCubes);
		int sumOfOddNumbers = sumOfOddNumbersInTheList(numbers);
		System.out.println("sumOfOddNumbers: "+sumOfOddNumbers);
	}

	private static int sumOfSquaresOfNumbersInTheList(List<Integer> numbers) {
		return numbers.stream().map(number -> number * number).reduce(0, Integer::sum);
	}
	
	private static int sumOfCubesOfNumbersInTheList(List<Integer> numbers) {
		return numbers.stream().map(number -> number * number * number).reduce(0, Integer::sum);
	}
	
	private static int sumOfOddNumbersInTheList(List<Integer> numbers) {
		return numbers.stream().filter(number -> number % 2 == 1).reduce(0, Integer::sum);
	}

}
