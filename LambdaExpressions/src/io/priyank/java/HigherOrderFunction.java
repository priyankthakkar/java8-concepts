package io.priyank.java;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HigherOrderFunction {

	// Problem statement, filter string from collection, which starts with a particular letter
	// This letter is different for all the list, but the logic is same
	// We need a lambda expression, that can accept parameters and eliminate duplication
	// A letter being different, doesn't change the underlying functionality
	
	// A higher order function
	// String parameter letter here, is cached in the lexical scope
	// When the filter() method will invoke the Predicate<T> return by the higher order function
	// It is clear that name will one of the element from the list in the context
	// But letter, with what value it will be binding to whenever the Predicate<T> is executed?
	// Java, reaches over to the scope of the definition of this lambda expression and figure out the value
	// This is called lexical scoping
	public static Predicate<String> nameStartsWithLetter(final String letter) {
		return name -> name.startsWith(letter);
	}
	
	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		final List<String> editors = Arrays.asList("Brian", "Jackie", "John", "Mike");
		final List<String> comrades = Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zach");
		
		// filter() method here is accepting a function as an argument
		// But any arbitrary function is not acceptable because filter expects a predicate
		// nameStartsWithLetter() method here, accepts a String argument named as letter
		// and returns a Predicate<T> which is nothing but a lambda expression yielding boolean
		// nameStartsWithLetter() method is returning an anonymous function, thus a higher order function
		// The lambda expression here will access to local variables in the scope of nameStartsWithLetter()
		// Though Java doesn't enforce, the local variables have to be final or effectively final
		// effectively final means, if we try to alter the local variables accessed by lambda expression
		// it will throw a compile time error
		final List<String> friendsStartWithB = friends
												.stream()
												.filter(nameStartsWithLetter("B"))
												.collect(Collectors.toList());
		System.out.println("Friends, name starts with B: " + friendsStartWithB );
		
		final List<String> editorsStartWithJ = editors
												.stream()
												.filter(nameStartsWithLetter("J"))
												.collect(Collectors.toList());
		System.out.println("Editors, name starts with J: " + editorsStartWithJ);
		
		final List<String> comaradesStartWithK = comrades
													.stream()
													.filter(nameStartsWithLetter("K"))
													.collect(Collectors.toList());
		System.out.println("Comrades, name starts with K: " + comaradesStartWithK);
	}
}
