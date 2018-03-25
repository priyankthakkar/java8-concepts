package io.priyank.java;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.List;
import java.util.stream.Collectors;

public class ReusingLambdaExpression {

	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		final List<String> editors = Arrays.asList("Brian", "Jackie", "John", "Mike");
		final List<String> comrades = Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zach");
		
		// Problem statement: from each of list, filter friends whole name will start with N
		
		// The reusable lambda expression for all three filter calls
		// Lambda being concise code, duplicacy of code can easily barge in
		// Which reduces maintainability of the code.
		
		// The principle used here is DRY: Don't repeat yourself
		Predicate<String> nameStartsWithN = name -> name.startsWith("N");
		
		// filter method here, takes a predicate as an argument
		// That means, for a given lambda expression which yields boolean
		// Java compiler here synthesize test() method for Predicate's implementation
		final List<String> friendsStartWithN = friends
												.stream()
												.filter(nameStartsWithN)
												.collect(Collectors.toList());
		
		System.out.println("Friends, name starts with N: " + friendsStartWithN);
		
		final List<String> editorsStartWithN = editors
												.stream()
												.filter(nameStartsWithN)
												.collect(Collectors.toList());
		
		System.out.println("Editors, name starts with N: " + editorsStartWithN);
		
		final List<String> comradesStartWithN = comrades
													.stream()
													.filter(nameStartsWithN)
													.collect(Collectors.toList());
		
		System.out.println("Comrades, name starts with N: " + comradesStartWithN);
	}
}
