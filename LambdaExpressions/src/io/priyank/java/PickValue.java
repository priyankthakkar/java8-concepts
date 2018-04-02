package io.priyank.java;

import java.util.Arrays;
import java.util.List;

public class PickValue {
	
	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		
		// Problem Statement: Find the first name in the list which starts with a given letter
		
		// 1. Imperative Solution:
		// First have a variable initialized to null
		// Iterate using external iterator
		// Assign the value when found and break the loop
		// As the resultant variable was assigned null first, null check here is an important step
		// In case, if no name with given letter was available, missing null check will lead to NullPointerException
		String firstNameFound = null;
		
		for(String name: friends) {
			if(name.startsWith("N")) {
				firstNameFound = name;
				break;
			}
		}
		
		System.out.println(String.format("Name found which statrs with N is: %s", firstNameFound));
		
		// 2. Declarative solution
		// Use stream() and filter() method, pass the predicate
		// This will result into a filtered list
		// Use the findFirstMethod() which will return Optional<String>
		// Use the get() method to extract String result out of it
		// But this solution can be improved to take full advantage of Optional<T>
		firstNameFound = friends
							.stream()
							.filter(name -> name.startsWith("S"))
							.findFirst()
							.get();
		System.out.println(String.format("Name found which stats with S is: %s", firstNameFound));
		
		// 3. Taking advantage of Optional<T>
		// With findFirst() method returning Optional<T>, we can take advantage of it
		// We check for the presence of value using isPresent()
		// We can extract value using get()
		// We can return and optional value with orElse, in case the desired result was not found
		// so we can see here, isPresent() or orElse() methods help us to eliminate NullPointerException (null deodorizer)
		// Here, we try to find a name which starts with letter 'Z', but this no name present which starts with letter 'Z'
		// So the expected outcome is: "Name found which stats with Z is: No name found!"
		firstNameFound = friends
							.stream()
							.filter(name -> name.startsWith("Z"))
							.findFirst()
							.orElse("No name found!");
		System.out.println(String.format("Name found which stats with Z is: %s", firstNameFound));
	}
}
