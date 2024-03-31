package com.java8.i.Optional;

import java.util.Optional;

public class bOptional_Of_empty_ofNullable {

	public static Optional<String> ofNullable() {
//		Optional<String> stringOptional = Optional.ofNullable("Hello"); //If we are not sure that the String parameter will always be different of null, then use "ofNullable" 
		Optional<String> stringOptional = Optional.ofNullable(null);
		return stringOptional;
	}
	
	public static Optional<String> of(){
		Optional<String> stringOptional = Optional.of("Hello");
//		Optional<String> stringOptional = Optional.of(null);	//This method always expect a valid value, which is not null
		return stringOptional;
	}
	
	public static Optional<String> empty(){
		Optional<String> stringOptional = Optional.empty();
		return stringOptional;
	}

	public static void main(String[] args) {
		System.out.println("ofNullable: \n" + ofNullable());
		System.out.println(ofNullable().isPresent());
		System.out.println(ofNullable().isEmpty());
//		System.out.println(ofNullable().get()); //This could throw and exception
		
		System.out.println("\n\nof: \n" + of());
		System.out.println(of().isPresent());
		System.out.println(of().isEmpty());
		System.out.println(of().get());
		
		System.out.println("\n\nempty: \n" + empty());
		System.out.println(empty().isPresent());
		System.out.println(empty().isEmpty());
//		System.out.println(empty().get()); //it throws: "java.util.NoSuchElementException: No value present"
	}

}
