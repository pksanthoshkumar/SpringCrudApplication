package com.example.crud.streams;

import java.util.*;
import java.util.stream.Collectors;

public class CollectElementsIntoGroupBy {
    public static void main (String args []){
        List<Person> people = Arrays.asList(
                new Person("Alice", 25, "New York"),
                new Person("Bob", 30, "San Francisco"),
                new Person("Charlie", 22, "New York"),
                new Person("David", 28, "San Francisco"),
                new Person("Eve", 35, "Los Angeles")
        );

        Map<String, List<Person>> group = people.stream().collect(Collectors.groupingBy(p->p.getCity())) ;

        System.out.println(group);
    }
}
