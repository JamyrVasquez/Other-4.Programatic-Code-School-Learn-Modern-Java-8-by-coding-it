package com.java8.b.LambdasAndFunctionalInterfaces.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.java8.i.Optional.Bike;

public class Student {
	private String name;
	private int gradeLevel;
	private double gpa;
	private String gender;
	List<String> activities = new ArrayList<>();
	private int noteBooks;

	private Optional<Bike> bike = Optional.empty(); // Not all the student will have a bike. This is not a mandatory
													// property

	public Student(String name, int gradeLevel, double gpa, String gender, List<String> activities, int noteBooks) {
		this.name = name;
		this.gradeLevel = gradeLevel;
		this.gpa = gpa;
		this.gender = gender;
		this.activities = activities;
		this.noteBooks = noteBooks;
	}

	public Student(String name, int gradeLevel, double gpa, String gender, List<String> activities) {
		this.name = name;
		this.gradeLevel = gradeLevel;
		this.gpa = gpa;
		this.gender = gender;
		this.activities = activities;
	}

	public Student() {				//Using this constructor in the class "com.java8.c.ContructorAndMethodReference" to show the "Constructor reference"  

	}

	public Student(String s) {		//Using this constructor in the class "com.java8.c.ContructorAndMethodReference" to show the "Constructor reference" 
		this.name = s;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGradeLevel() {
		return gradeLevel;
	}

	public void setGradeLevel(int gradeLevel) {
		this.gradeLevel = gradeLevel;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public void printListOfActivities() {
		System.out.println(activities);
	}

	public List<String> getActivities() {
		return activities;
	}

	public void setActivities(List<String> activities) {
		this.activities = activities;
	}

	public int getNoteBooks() {
		return noteBooks;
	}

	public void setNoteBooks(int noteBooks) {
		this.noteBooks = noteBooks;
	}

	public Optional<Bike> getBike() {
		return bike;
	}

	public void setBike(Optional<Bike> bike) {
		this.bike = bike;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", gradeLevel=" + gradeLevel + ", gpa=" + gpa + ", gender=" + gender
				+ ", activities=" + activities + ", noteBooks=" + noteBooks + ", bike=" + bike + "]";
	}

	

}
