package io.priyank.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TransformCollection {

	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		
		// Problem statement: Convert each name in the list to all caps letters
		
		//1. Imperative way to solve the problem
		// As the list is final, create a new collection. Iterate over friends collection, convert each name to
		// upper case and add it to the new collection
		
		System.out.println("1. Imperative way to solve the problem");
		
		// This collection here is a drawback
		// As it is getting mutated with each iteration
		// This code will become the bottleneck when we will try to parallelize this piece of code
		List<String> upperCaseNames = new ArrayList<String>();
		
		for(String friend: friends) {
			upperCaseNames.add(friend.toUpperCase());
		}
		
		System.out.println(upperCaseNames);
		
		// 2. Using the internal iterators
		
		System.out.println("2. Using the internal iterators");
		
		final List<String> finalUpperCaseNames = new ArrayList<String>();
		
		//In this case, we have an internal iterator, but the mutating list is still present
		friends
			.forEach(friend -> finalUpperCaseNames.add(friend.toUpperCase()));
		System.out.println(finalUpperCaseNames);
		
		// 3. Using the map function
		System.out.println("3. Using the map function");
		
		upperCaseNames = friends
							.stream()
							.map(friend -> friend.toUpperCase()) //map method here converts each element to upper case and returns a new list
							.collect(Collectors.toList()); // the stream returned by map is collected here as list
		System.out.println(upperCaseNames);
		
		// 4. Enhancing a bit more with method reference
		System.out.println("4. Enhancing a bit more with method reference");
		
		upperCaseNames = friends
							.stream()
							.map(String::toUpperCase)
							.collect(Collectors.toList());
		
		System.out.println(upperCaseNames);
		
	}
}
