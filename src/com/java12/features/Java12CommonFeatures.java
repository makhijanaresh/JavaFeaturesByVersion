package com.java12.features;

import java.nio.file.Files;
import java.nio.file.Path;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Java12CommonFeatures {

	public static void main(String[] args) throws Exception {
		// stringExamples();
		 //filesMismatch();
		 //teeingMethod();
		// compactNumber();
		// instanceofChanges();
		switchExpression();
	}

	private static void switchExpression() {
		
		//befor Java 12
		 int dayOfWeek = 5;
	        String dayName;

	        // Using switch statement to get the name of the day
	        switch (dayOfWeek) {
	            case 1:
	                dayName = "Monday";
	                break;
	            case 2:
	                dayName = "Tuesday";
	                break;
	            case 3:
	                dayName = "Wednesday";
	                break;
	            case 4:
	                dayName = "Thursday";
	                break;
	            case 5:
	                dayName = "Friday";
	                break;
	            case 6:
	                dayName = "Saturday";
	                break;
	            case 7:
	                dayName = "Sunday";
	                break;
	            default:
	                throw new IllegalArgumentException("Invalid day of the week: " + dayOfWeek);
	        }

	        System.out.println("Before Java 12 Day of the week: " + dayName);
		
		
		//From Java 12
		 dayOfWeek = 5;
//it's a preview feature means it's out for testing and it's 100% available from java14
	
		// Using switch expression to get the name of the day
		 dayName = switch (dayOfWeek) {
		case 1 -> "Monday";
		case 2 -> "Tuesday";
		case 3 -> "Wednesday";
		case 4 -> "Thursday";
		case 5 -> "Friday";
		case 6 -> "Saturday";
		case 7 -> "Sunday";
		default -> throw new IllegalArgumentException("Invalid day of the week: " + dayOfWeek);
		};

		System.out.println("From java 12 Day of the week: " + dayName);

	}

	private static void instanceofChanges() {
		// Before java12
		Object obj = "I hope you like my videos";
		if (obj instanceof String) {
			String s = (String) obj;
			int length = s.length();
			System.out.println("Subscribe to my channel:" + length);
		}

		// From Java 12
//it's a preview feature means it's out for testing and it's 100% available from java14
		if (obj instanceof String s) {
			int length = s.length();
			System.out.println("Hit like if this video: " + length);
		}

	}

	private static void compactNumber() {

		NumberFormat likesShort = NumberFormat.getCompactNumberInstance(new Locale("en", "US"),
				NumberFormat.Style.SHORT);
		likesShort.setMaximumFractionDigits(3);
		System.out.println(likesShort.format(2076000));

		NumberFormat likesLong = NumberFormat.getCompactNumberInstance(new Locale("en", "US"), NumberFormat.Style.LONG);
		likesLong.setMaximumFractionDigits(3);
		System.out.println(likesLong.format(20760000));

	}

	private static void teeingMethod() {
		/**
		 * Suppose you have a list of integers, and you want to find both the sum and
		 * the maximum value of these integers using Collectors.teeing()
		 */
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		

		// Using Collectors.teeing to find sum and max simultaneously
		Object[] result = numbers.stream().collect(Collectors.teeing(Collectors.summingInt(Integer::intValue),
				Collectors.maxBy(Integer::compareTo), (sum, max) -> new Object[] { sum, max.orElse(null) }));

		int sum = (int) result[0];
		Integer max = (Integer) result[1];

		System.out.println("Sum: " + sum);
		System.out.println("Max: " + max);

	}

	private static void filesMismatch() throws Exception {
		Path filePath1 = Files.createTempFile("file1", ".txt");
		Path filePath2 = Files.createTempFile("file2", ".txt");
		Files.writeString(filePath1, "Hello World");
		Files.writeString(filePath2, "Hello World");

		long mismatch = Files.mismatch(filePath1, filePath2);
		System.out.println("Mismatch1:" + mismatch);

		Files.writeString(filePath1, "Hello World");
		Files.writeString(filePath2, "Hello Wor!d");

		mismatch = Files.mismatch(filePath1, filePath2);
		System.out.println("Mismatch2:" + mismatch);

	}

	private static void stringExamples() {
		//stringIndentExample();
		//transformExample();
	}

	private static void transformExample() {
		String str = "Hello world";

		String transformedString = str.transform(String::toLowerCase);
		System.out.println(transformedString);

	}

	private static void stringIndentExample() {
		String text = "Hello\nWorld\nJava\n";
		System.out.println("Original Text:\n" + text);

		// Indent each line by 3 spaces
		String indentedText = text.indent(10);
		System.out.println("Indented Text:\n" + indentedText);

	}
}
