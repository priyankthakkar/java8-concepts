package io.priyank.java;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdaExpressionNarrowScope {

	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		final List<String> editors = Arrays.asList("Brian", "Jackie", "John", "Mike");
		final List<String> comrades = Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zach");
		
		// Problem Statement: Unlike ReusingLambdaExpression.java, we will avoid putting method in the static scope
		// Rather than polluting the global scope, we push the reusable lambda expression to local scope
		// This is achievable via Function<T,R> interface
		
		// Before we proceed further, it is important to understand the difference between Function<T, R> & Predicate<T> functional interfaces
		// Predicate<T> takes an argument of type T but always yields a boolean result
		// Function<T, R> takes an argument of type T and returns result of type R which is more useful than predicate in certain context
		// filter() method on collection, uses Predicate<T> as it uses conditional statements to filter records
		// map() method on collection uses Function<T, R>, where it passes and argument of type T and maps it to some other type R
		
		// 1. Verbose solution
		/*
			final Function<String, Predicate<String>> startsWithLetter = 
					(String letter) -> {
						Predicate<String> checkStarts = (String name) -> name.startsWith(letter);
						return checkStarts;
					};
		*/
		
		// 2. Concise solution
		/*
			final Function<String, Predicate<String>> startsWithLetter =
					(String letter) -> (String name) -> name.startsWith(letter);
		*/
		
		// 3. Type inference, here we letter Java compile to decide the type of parameters
		final Function<String, Predicate<String>> startsWithLetter =
				letter -> name -> name.startsWith(letter);
				
		final List<String> friendsStartWithN = friends
												.stream()
												.filter(startsWithLetter.apply("N"))
												.collect(Collectors.toList());
		System.out.println("Friends start with N: " + friendsStartWithN);
		
		final List<String> editorsStartWithJ = editors
												.stream()
												.filter(startsWithLetter.apply("J"))
												.collect(Collectors.toList());
		System.out.println("Editors start with J: " + editorsStartWithJ);
		
		final List<String> comradesStartsWithK = comrades
													.stream()
													.filter(startsWithLetter.apply("K"))
													.collect(Collectors.toList());
		System.out.println("Comrades start with K: " + comradesStartsWithK);
	}
}
