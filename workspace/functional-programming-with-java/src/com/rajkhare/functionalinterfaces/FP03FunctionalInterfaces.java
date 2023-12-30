package com.rajkhare.functionalinterfaces;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP03FunctionalInterfaces {
    
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		List<Integer> evenNumbers = filterList(numbers, x -> x%2==0);
		List<Integer> oddNumbers = filterList(numbers, x -> x%2==1);
		List<Integer> divisibleBy3Numbers = filterList(numbers, x -> x%3==0);
		System.out.println(evenNumbers);
		System.out.println(oddNumbers);
		System.out.println(divisibleBy3Numbers);
	}

	private static List<Integer> filterList(List<Integer> numbers, Predicate<? super Integer> predicate) {
		return numbers.stream().filter(predicate).collect(Collectors.toList());
	}

}
