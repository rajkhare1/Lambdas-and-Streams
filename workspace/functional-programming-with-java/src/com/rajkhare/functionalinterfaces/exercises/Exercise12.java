package com.rajkhare.functionalinterfaces.exercises;

import java.util.List;
import java.util.function.BinaryOperator;

public class Exercise12 {

	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		
		BinaryOperator<Integer> sumBinaryOperator = Integer::sum;
		BinaryOperator<Integer> sumBinaryOperator2 = new BinaryOperator<Integer>() {
			
			@Override
			public Integer apply(Integer a, Integer b) {
				return Integer.sum(a, b);
			}
		};
		
		int sum = numbers.stream().reduce(0, sumBinaryOperator2);
		System.out.println(sum);

	}

}
