package io.priyank.java;

import java.math.BigDecimal;
import java.util.List;
import java.util.Arrays;

public class LambdaExpression {

	public static void main(String[] args) {
		final List<BigDecimal> prices = Arrays.asList(
				new BigDecimal("10"), new BigDecimal("30"), new BigDecimal("17"),
				new BigDecimal("20"), new BigDecimal("15"), new BigDecimal("18"),
				new BigDecimal("45"), new BigDecimal("12")
		);
		
		/*
		 * Problem Statement: Total all the prices greater than 20, discounted by 10% 
		 */
		
		//imperative way
		
		BigDecimal totalDiscountedPrice = BigDecimal.ZERO;
		
		for(BigDecimal price: prices) {
			if(price.compareTo(BigDecimal.valueOf(20)) > 0) {
				totalDiscountedPrice = totalDiscountedPrice
						.add(price.multiply(BigDecimal.valueOf(0.9)));
			}
		}
		
		System.out.println("Total Discounted Price: " + totalDiscountedPrice);
		
		//declarative way
		
		totalDiscountedPrice = prices
									.stream()
									//Compare price great than 20
									.filter(price -> price.compareTo(BigDecimal.valueOf(20)) > 0)
									//map discounted prices by 10 percent
									.map(price -> price.multiply(BigDecimal.valueOf(0.9)))
									//total the discounted prices
									.reduce(BigDecimal.ZERO, BigDecimal::add);
									// expanded version of reduce is
									// .reduce(BigDecimal.ZERO, (total, price) -> total.add(price))
		
		System.out.println("Total Discounted Price: " + totalDiscountedPrice);
	}
}
