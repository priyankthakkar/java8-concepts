package io.priyank.java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JoiningElements {
	public static void main(String[] args) {
		
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		
		// Problem statement: Print all the names in the list, separated by comma in a single line
		
		// 1. Traditional solution
		// We can achieve the desired output but the result is not as expected
		// We can see a trailing comma at the end of the list
		System.out.println("1. Traditional solution");
		for(int i = 0; i < friends.size(); i++) {
			System.out.print(friends.get(i) + ", ");
		}
		
		// 2. Traditional solution with dangling comma eliminated
		// Now this solves the problem but the solution is not elegant
		// We have to ensure that we do not iterate over the last element
		// and print the last element separately
		System.out.println("\n2. Traditional solution with dangling comma eliminated");
		for(int i = 0; i < friends.size() - 1; i++) {
			System.out.print(friends.get(i) + ", ");
		}
		
		if (friends.size() > 0) {
			System.out.print(friends.get(friends.size() - 1));
		}
		
		// 3. The miraculous one-liner from Java 8
		System.out.println("\n3. The miraculous one-liner from Java 8");
		System.out.println(String.join(", ", friends));
		
		// Let's evolve the problem statement now
		// Updated Problem Statement: Convert every element in the list to upper case, join all the elements by a comma and produce a single string
		// use the map() method over the given list, and convert all the elements to upper case
		// collect the new list with upper case members to a single string
		// Collectors here act as a sink object
		// Collector will decide the outcome of the given input list
		// In this case, collector produces a single string for the input list with given delimiter
		System.out.println(
				friends
					.stream()
					.map(String::toUpperCase)
					.collect(Collectors.joining(", "))
		);
	}
}