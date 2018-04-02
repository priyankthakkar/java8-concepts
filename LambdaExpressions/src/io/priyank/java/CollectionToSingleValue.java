package io.priyank.java;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CollectionToSingleValue {

	public static void main(String[] args) {
		// So till now we have seen, filtering collection filter(), finding a value from
		// collection findFirst() and
		// transforming collection map()
		// Now we will see, how to reduce a collection to a single value
		// Scenarios like, sum all the elements, compare and find the longest string out
		// of collection etc

		// Problem Statement One: Sum the length of all the names in a list
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

		// Solution: use stream() on friends collection
		// map it to list of Integer by length of all the names within a list,
		// mapToInt() is a special variation of map() methods
		// Sum over the new list of name length
		// sum() here is a built in method
		// other such methods are min(), max(), average(), sort()
		// this solution is a specific case of MapReduce pattern
		// where mapToInt() does the mapping name to the respective Integer length
		// sum() is the specific case of reducing all the length in to total number of
		// characters
		int sumLengthOfAllTheNames = friends.stream().mapToInt(name -> name.length()).sum();
		System.out.println("Total number of characters in all names: " + sumLengthOfAllTheNames);

		// Problem statement: Find the longest name from the list, if any other name with same length as longest name exist
		// choose the first found name
		// Solution: use the reduce() method
		// Here reduce() method iterates over the list which takes two parameters
		// reduce() method just passes these params, but what we need to achieve with them is up to us
		// it is the light weight application of strategy patter
		// input to reduce() method is a functional interface BinaryOperator<T>
		// which takes two input operands of type String in this case and produces the result of type String
		// output here is the first of the two longest names
		// reduce() method starts here with first two names in the list
		// result of the first iteration is used in the subsequent iterations
		// after the first iteration, name1 is bound the result and name2 is bound to the next element in the list
		
		// Output of reduce method here is an Optional<T> (Optional<String>) in this case
		// output is optional because of the list is empty, we need to make a check on the result
		// if the list has exactly the one element, then it will be returned as a result and lamba expression will be ignored
		
		Optional<String> longestName = friends
										.stream()
										.reduce((name1, name2) -> name1.length() >= name2.length() ? name1 : name2);
		
		longestName.ifPresent(name -> System.out.println("Longest name is: " + name));
		
		// Alternative solution: it is also possible to pass a default value or an optional value to reduce method
		// This helps us to set a base value, or helps us to return a default value in case the list is empty
		// Also, it is worth noting that outcome of reduce() method here is not Optinal<T> because we have supplied default value
		
		List<String> emptyFriendList = new ArrayList<String>();
		String result = emptyFriendList
							.stream()
							.reduce("Given input list is empty.", (name1, name2) -> name1.length() >= name2.length() ? name1 : name2);
		System.out.println("Outcome for emptyFriendList is: " + result);
	}
}
