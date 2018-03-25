package io.priyank.java;

import java.util.List;
import java.util.function.Consumer;
import java.util.Arrays;

public class Collections {
	
	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		
		//problem statement: Iterate over list and print every name
		
		//1. Imperative way
		// We are mutating an external index variable i here
		System.out.println("1. Imperative way");
		for(int i = 0; i < friends.size(); i++) {
			System.out.println(friends.get(i));
		}
		
		//2. Another imperative way, external iterator
		// lesser code ceremony here, but this loop is still difficult to parallelize
		System.out.println("2. Another imperative way, external iterator");
		for(String friend: friends) {
			System.out.println(friend);
		}
		
		// Three things to notice in loops above
		// 1. loops are sequential and difficult to parallelize
		// 2. These operations are non-polymorphic, we pass collections to for rather than invoking methods on them
		// 3. Violates, Tell Don't ask principle
		
		//Declarative way
		
		// 3. Consumer Way
		System.out.println("3. Consumer Way");
		
		friends // we are invoking forEach on collection, polymorphic way
			.forEach(new Consumer<String>() { // Yet this consumer, still a lot of code ceremony
				@Override
				public void accept(String friend) {
					System.out.println(friend);
				}
			});
		
		//4. Replacing Consumer<T> with lambda-expression
		System.out.println("4. Replacing Consumer<T> with lambda-expression");
		
		friends
			.forEach((final String friend) -> System.out.println(friend));
		
		//5. type inference in Java, let us allow to eliminate type inference for parameters in lambda expression
		System.out.println("5. type inference in Java, let us allow to eliminate type informatin for parameters in lambda expression");
		
		friends // type determination is done based on the context
			.forEach((friend) -> System.out.println(friend));
		
		//6. Also, as a special case, for a type inferred single parameter lambda expression, parenthesis are optional
		System.out.println("6. Also, as a special case, for a type inferred single parameter lambda expression, parenthesis are optional");
		
		friends //caveat: inferred parameters are non-final
			.forEach(friend -> System.out.println(friend));
		
		//7. method reference
		System.out.println("7. method reference");
		friends
			.forEach(System.out::println);
		
	}
}
