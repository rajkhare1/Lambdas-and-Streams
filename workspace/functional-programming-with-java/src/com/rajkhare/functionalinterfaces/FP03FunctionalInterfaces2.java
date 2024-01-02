package com.rajkhare.functionalinterfaces;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class FP03FunctionalInterfaces2 {
    
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		List<Integer> evenNumbers = filterList(numbers, x -> x%2==0);
		List<Integer> oddNumbers = filterList(numbers, x -> x%2==1);
		List<Integer> divisibleBy3Numbers = filterList(numbers, x -> x%3==0);
		System.out.println(evenNumbers);
		System.out.println(oddNumbers);
		System.out.println(divisibleBy3Numbers);
		
		//No input > Return something	
		Supplier<Integer> randomIntegerSupplier = () -> {
			Random random = new Random();
			return random.nextInt(1000);
		};
		System.out.println("randomIntegerSupplier: "+randomIntegerSupplier.get());
		
		//take one parameter and return the result of same type
		UnaryOperator<Integer> unaryOperator = x -> 3 * x;
		System.out.println("unaryOperator: "+unaryOperator.apply(3));
		
		//BiPredicate
		BiPredicate<Integer,String> biPredicate = (n, s) ->  s.length()==n;
		System.out.println(biPredicate.test(3, "Raj"));
		//BiFunction
		BiFunction<Integer, Integer, Integer> biFunction = (num1, num2) -> num1 * num2; 
		System.out.println(biFunction.apply(2, 2));
		//BiConsumer
		BiConsumer<String, String> biConsumer =(s1,s2) -> System.out.println(s1+s2); 
		biConsumer.accept("Raj ", "Khare");
		
	}

	private static List<Integer> filterList(List<Integer> numbers, Predicate<? super Integer> predicate) {
		return numbers.stream().filter(predicate).collect(Collectors.toList());
	}

}
