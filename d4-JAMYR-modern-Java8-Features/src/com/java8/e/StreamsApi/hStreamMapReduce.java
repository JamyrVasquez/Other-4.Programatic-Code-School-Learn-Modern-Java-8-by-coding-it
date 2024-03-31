package com.java8.e.StreamsApi;

import com.java8.b.LambdasAndFunctionalInterfaces.data.StudentDataBase;

public class hStreamMapReduce {

    private static int noOfNoteBooks(){
        Integer noOfNoteBooks = StudentDataBase.getAllStudents().stream()   //Stream<Student>
                .filter((student) -> student.getGradeLevel()>=3)
                .filter((student) -> student.getGender().equals("female"))
                //.map(Student::getNoteBooks) //Stream<Integer>
                .map((s) -> s.getNoteBooks())
                //.reduce(0, (a, b) -> a + b)
                .reduce(0, Integer::sum);



        return noOfNoteBooks;
    }
    public static void main(String[] args) {
        System.out.println("noOfNoteBooks: " + noOfNoteBooks());
    }
}
