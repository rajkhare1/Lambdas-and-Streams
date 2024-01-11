package com.rajkhare.morestreamops;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlayingWithStream {
	
	public static void main(String[] args) {
		
		//map to BigInteger for big operations result
/*
 * LongStream.rangeClosed(1,50).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE,BigInteger::multiply)
$9 ==> 30414093201713378043612608166064768844377641568960512000000000000
 * */		
		
		
		List<String> courses = List.of("Spring","Spring Boot","API","Microservices","AWS","PCF","Azure","Docker","Kubernates");
		List<String> courses2 = List.of("Spring","Spring Boot","API","Microservices","AWS","PCF","Azure","Docker","Kubernates");
		
		// use of flatMap
		  courses.stream().map(course -> course.split("")).flatMap(Arrays::stream).collect(Collectors.toList());
	//$20 ==> [S, p, r, i, n, g, S, p, r, i, n, g,  , B, o, o, t, A, P, I, M, i, c, r, o, s, e, r, v, i, c, e, s, A, W, S, P, C, F, A, z, u, r, e, D, o, c, k, e, r, K, u, b, e, r, n, a, t, e, s]
		  
		  
		  //tuples with same length
/*
 * courses.stream().flatMap(course -> courses2.stream().map(course2 -> List.of(course,course2)))
 * .collect(Collectors.toList())
$24 ==> [[Spring, Spring], [Spring, Spring Boot], [Spring, API], [Spring, Microservices], [Spring, AWS], [Spring, PCF], 
[Spring, Azure], [Spring, Docker], [Spring, Kubernates], [Spring Boot, Spring], [Spring Boot, Spring Boot], 
[Spring Boot, API], [Spring Boot, Microservices], [Spring Boot, AWS], [Spring Boot, PCF], [Spring Boot, Azure], 
[Spring Boot, Docker], [Spring Boot, Kubernates], [API, Spring], [API, Spring Boot], [API, API], [API, Microservices], 
[API, AWS], [API, PCF], [API, Azure], [API, Docker], [API, Kubernates], [Microservices, Spring], 
[Microservices, Spring Boot], [Microservices, API], [Microservices, Microservices], [Microservices, AWS], [Microse ... ], 
[Docker, API], [Docker, Microservices], [Docker, AWS], [Docker, PCF], [Docker, Azure], [Docker, Docker], 
[Docker, Kubernates], [Kubernates, Spring], [Kubernates, Spring Boot], [Kubernates, API], [Kubernates, Microservices], 
[Kubernates, AWS], [Kubernates, PCF], [Kubernates, Azure], [Kubernates, Docker], [Kubernates, Kubernates]]
 * */		
		  
		//Eliminated same elements repeated twice
/*
 * courses.stream().flatMap(course -> courses2.stream().map(course2 -> List.of(course,course2))).filter(list ->!list.get(0).equals(list.get(1))).collect(Collectors.toList())
$5 ==> [[Spring, Spring Boot], [Spring, API], [Spring, Microservices], [Spring, AWS], [Spring, PCF], [Spring, Azure], [Spring, Docker], [Spring, Kubernates], [Spring Boot, Spring], [Spring Boot, API], [Spring Boot, Microservices], [Spring Boot, AWS], [Spring Boot, PCF], [Spring Boot, Azure], [Spring Boot, Docker], [Spring Boot, Kubernates], [API, Spring], [API, Spring Boot], [API, Microservices], [API, AWS], [API, PCF], [API, Azure], [API, Docker], [API, Kubernates], [Microservices, Spring], [Microservices, Spring Boot], [Microservices, API], [Microservices, AWS], [Microservices, PCF], [Microservices, Azure], [Microservices, Docker], [Microservices, Kubernates] ... tes], [Docker, Spring], [Docker, Spring Boot], [Docker, API], [Docker, Microservices], [Docker, AWS], [Docker, PCF], [Docker, Azure], [Docker, Kubernates], [Kubernates, Spring], [Kubernates, Spring Boot], [Kubernates, API], [Kubernates, Microservices], [Kubernates, AWS], [Kubernates, PCF], [Kubernates, Azure], [Kubernates, Docker]]
 * */		
		  
		//Filter tuples with same length
/*
 * courses.stream().flatMap(course -> courses2.stream().filter(course2->course2.length()==course.length()).map(course2 -> List.of(course,course2))).filter(list ->!list.get(0).equals(list.get(1))).collect(Collectors.toList())
$6 ==> [[Spring, Docker], [API, AWS], [API, PCF], [AWS, API], [AWS, PCF], [PCF, API], [PCF, AWS], [Docker, Spring]]
 * */	
		  
		
	}
	
	

}
