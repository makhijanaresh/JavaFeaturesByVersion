package com.java10.features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Java10Features {
	


	public static void main(String[] args) {

		//collectionImprovements();
		optionalImprovent();
	}


	private static void optionalImprovent() {
		// The classes java.util.Optional, java.util.OptionalDouble,
		// java.util.OptionalInt, and java.util.OptionalLong have each received a new
		// method called orElseThrow(). This method, when called without any arguments,
		// throws a NoSuchElementException if no value is present.
		
		List<Integer> intList=Arrays.asList(1,3,5,7);
		intList.stream().filter(i->i%2==0).findAny().orElseThrow();
		System.out.println("Neet end");
	}

	private static void collectionImprovements() {
		List<String> oldList = new ArrayList<>();
		oldList.add("A");
		oldList.add("ab");
		oldList.add("c");
		oldList.add("cd");

		// 1
		// java.util.List, java.util.Map and java.util.Set each got a new static method
		// copyOf(Collection).
		// This method now provides an unmodifiable copy of the specified Collection
		List<String> newList = List.copyOf(oldList);
		System.out.println("New list1:"+newList);
		oldList.add("ddd");
		System.out.println("New list2:"+newList);
		 newList.add("d");// uncomment this

		// 2
		// Additional methods have been introduced in java.util.stream.Collectors for
		// collecting a Stream into unmodifiable List, Map, or Set.
		List<String> evenList = oldList.stream().filter(str -> str.startsWith("c"))
				.collect(Collectors.toUnmodifiableList());
		// evenList.add("e"); uncomment this

		// Diff b/w Collections.unmodifiableList(list) and
		// Collectors.toUnmodifiableList()
		// If we call Collections.unmodifiableList(list) to get unmodifiable collection
		// then if we make change in main collection that will be reflected in list
		// which we get from Collections.unmodifiableList(list)
		// and if we get list from Collectors.toUnmodifiableList() then changes to main
		// list are not reflected here
		// example

//		List<String> list = Collections.unmodifiableList(oldList);
//		System.out.println(list);
//		oldList.add("z");
//		System.out.println("end:" + list);

	}
	
	
}
