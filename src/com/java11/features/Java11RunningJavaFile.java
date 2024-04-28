 package com.java11.features;

import java.util.function.BiFunction;

public class Java11RunningJavaFile {

	/**
	 * Before Java11 if we have to execute our code from CMD First we had to compile
	 * our code by javac FileName.java Then we get Class and we execute java
	 * ClassName But from java 11 we just have to provide java FileName.java that's
	 * it
	 */

	public static void main(String[] args) {
		localVariableSyntexForLambda();
	}

	private static void localVariableSyntexForLambda() {
		/**
		 * Before Java 11, we wrote a lambda expression to add two integers, and we had
		 * to mention the types of the parameters explicitly as (Integer x, Integer y).
		 * 
		 * With Java 11, we use the var keyword for the lambda parameters, letting the
		 * compiler figure out the types of x and y from the context
		 */

		// Before Java 11
		BiFunction<Integer, Integer, Integer> adderOld = (Integer x, Integer y) -> x + y;
		System.out.println("Result (before Java 11): " + adderOld.apply(10, 20));

		// With Java 11
		BiFunction<Integer, Integer, Integer> adderNew = (var x, var y) -> x + y;
		System.out.println("Result (Java 11): " + adderNew.apply(10, 20));
	}
}
