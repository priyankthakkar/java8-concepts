package io.priyank.java;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FindingElements {
	
	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		
		//Problem statement: From list of names, pick the names starting with N
		
		//1. Imperative way of solution
		System.out.println("1. Imperative way of solution");
		
		final List<String> namesStartingWithN = new ArrayList<String>();
		
		// So we can clearly see, the problem with solution is mutating list of string namesStartingWithN
		// This can cause major blocks if we think of parallelizing the solution
		for(String friend: friends) {
			if(friend.startsWith("N")) {
				namesStartingWithN.add(friend);
			}
		}
		
		System.out.println(namesStartingWithN);
		
		//2. Declarative way of solution
		System.out.println("2. Declarative way of solution");
		
		final List<String> filteredNames = friends
											.stream()
											//filter method here, expects a lambda expression which yields a boolean value
											//if the expression returns true, the element in the context will be added to resultant stream else skipped
											.filter(friend -> friend.startsWith("N"))
											//As the filterm method returns the stream of filtered elements, collector will transform it to list
											.collect(Collectors.toList());
		System.out.println(filteredNames);
	}
}