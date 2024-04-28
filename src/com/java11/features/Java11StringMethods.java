package com.java11.features;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Java11StringMethods {

	public static void main(String[] args) throws Exception {
	//stringMethods();
		//filesMethod();
		//collectionImprovements();
		predicateNegate();
	}

	private static void predicateNegate() {
		//Now we have negate method in predicate which can be used if we want things not to be true
		List<String> sampleList = Arrays.asList("Naresh","Ajay","Amar","Rajesh");
		List<String> withoutBlanks = sampleList.stream()
		  .filter(Predicate.not(str->str.startsWith("A")))
		  .collect(Collectors.toList());
		System.out.println(withoutBlanks);
		
	}

	private static void collectionImprovements() {
		//We can convert Array to list anytime but conveting list to array is not that easy or simple
		//but from java11 it's 1 method call away
		List<String> list = Arrays.asList("HI ", "Naresh");
		String[] array = list.toArray(String[]::new);
		System.out.println("list:"+list);
		System.out.println("Array:"+Arrays.toString(array));
		
	}

	private static void filesMethod() throws Exception {
		Path fileDir = Paths.get("D:\\YouTubeVideos\\Part1\\Java-Projects\\JavaFeaturesByVersion");
		Path filePath = Files.writeString(Files.createTempFile(fileDir, "sample", ".txt"), "Please subscribe to my channel!");
		String fileContent = Files.readString(filePath);
		System.out.println("file Content:"+fileContent);
	}

	private static void stringMethods() {
		//1.) repeat words 
				String str="Hi ";
			String finalString=	str.repeat(3)+"Naresh";
			System.out.println("finalString:"+finalString);
			
			//2.) strip() it removes all leadin and trailing whtespaces
			String stripExample=" hi naresh   ";
			System.out.println("Before strip:"+stripExample);
			System.out.println("After strip:"+stripExample.strip());
			
			//3.) isBlank method
			
			System.out.println("isBlank:"+"".isBlank());
			System.out.println("isBlank:"+"  \n".isBlank());
			System.out.println("isBlank:"+" \t".isBlank());
			System.out.println("isBlank:"+"\\".isBlank());
			System.out.println("isBlank:"+"abcd".isBlank());
			
			//4.) lines method
			String linesMethod="Hi \nNaresh \nMakhija\n";
			linesMethod.lines().forEach(System.out::println);
			
			
			//5.) StripTrailing and StripLeading
		     System.out.println("  Hello, World!     ".stripTrailing());
		     
		     System.out.println("   Hello, World!     ".stripLeading());
		
	}
}
