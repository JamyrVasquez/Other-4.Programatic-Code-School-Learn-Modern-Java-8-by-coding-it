package com.java8.e.StreamsApi;

import com.java8.b.LambdasAndFunctionalInterfaces.data.Student;
import com.java8.b.LambdasAndFunctionalInterfaces.data.StudentDataBase;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class dStreamsFlatMap {

    public static List<String> printStudentActivities(){
        List<String> studentActivities = StudentDataBase.getAllStudents().stream() //Stream<Student>
                .map(Student::getActivities)    //Stream<List<String>>
                //.flatMap((activities) -> activities.stream()) //Creamos un "Stream" por cada una de las Listas de Strings
                .flatMap(Collection::stream) //Stream<String>. Los mismo que arriba pero usando method reference
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        return studentActivities;
    }

    public static long getStudentActivitiesCount(){
        long noOfStudentActivities = StudentDataBase.getAllStudents().stream() //Stream<Student>
                .map(Student::getActivities)    //Stream<List<String>>
                //.flatMap((activities) -> activities.stream()) //Creamos un "Stream" por cada una de las Listas de Strings
                .flatMap(Collection::stream) //Stream<String>. Los mismo que arriba pero usando method reference
                .distinct()
                .count();

        return noOfStudentActivities;
    }
    public static void main(String[] args) {
        System.out.println("printStudentActivities: " + printStudentActivities());
        System.out.println("\ngetStudentActivitiesCount: " + getStudentActivitiesCount());
    }
}
