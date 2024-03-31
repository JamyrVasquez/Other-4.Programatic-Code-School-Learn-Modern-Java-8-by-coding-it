package com.java8.j.Defaults;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class aDefaultsMethods {
	public static void main(String[] args) {
		/*Sort the list names in alphabetical order*/
		
		/*Prior Java 8*/
		List<String> stringList =  Arrays.asList("Adam", "Janny", "Alex", "Dan", "Mike", "Eric");
		Collections.sort(stringList);
		System.out.println("Sorted list using Collections.Sort(): " + stringList);
		
		/*Java 8*/
		List<String> stringList_2 =  Arrays.asList("Adam", "Janny", "Alex", "Dan", "Mike", "Eric");
		stringList_2.sort(Comparator.naturalOrder());
//		stringList.sort(Comparator.comparing((string) -> string));
//		stringList.sort(Comparator.comparing((string) -> ((String) string)).reversed());
		System.out.println("Sorted list using List.Sort(): " + stringList_2);
		stringList_2.sort(Comparator.reverseOrder());
		System.out.println("Sorted list using List.reverseOrder(): " + stringList_2);
		
//		List<String> newStringList = stringList.stream().sorted(Comparator.comparing((string)->string)).collect(Collectors.toList());
//		List<String> newStringList = stringList.stream().sorted(Comparator.comparing((string) -> ((String) string)).reversed()).collect(Collectors.toList());
//		System.out.println(newStringList);
	}
}
