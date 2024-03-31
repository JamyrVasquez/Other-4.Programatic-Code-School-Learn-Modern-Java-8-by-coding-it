package com.java8.i.Optional;

import java.util.Optional;

public class dOptional_ifPresent_isPresent {

	public static void main(String[] args) {
		//isPresent
//		Optional<String> optional = Optional.ofNullable("hello Optional");
		Optional<String> optional = Optional.ofNullable(null);
		
		System.out.println("isPresent: " + optional.isPresent());
		if (optional.isPresent()) {
			System.out.println(optional.get());
		}
		
		//ifPresent
		System.out.println("\n\nifPresent: ");
		optional.ifPresent((string) -> System.out.println(string));
		
		System.out.println("\n\nifPresentOrElse: ");
		optional.ifPresentOrElse((string) -> System.out.println(string), () -> System.out.println("Not found value"));
		

	}

}
