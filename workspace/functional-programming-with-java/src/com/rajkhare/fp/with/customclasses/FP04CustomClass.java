package com.rajkhare.fp.with.customclasses;

import java.util.List;

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
				new Course("Azure","DevOps",99,21000),
				new Course("Docker","DevOps",92,20000),
				new Course("Kubernates","DevOps",91,20000)
				);

	}

}
