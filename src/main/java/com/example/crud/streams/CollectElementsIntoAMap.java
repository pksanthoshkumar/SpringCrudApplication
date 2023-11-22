package com.example.crud.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectElementsIntoAMap {
    public static void main (String args []){
        List<Person> people = Arrays.asList(
                new Person("Alice", 25, "New York"),
                new Person("Bob", 30, "San Francisco"),
                new Person("Charlie", 22, "New York"),
                new Person("David", 28, "San Francisco"),
                new Person("Eve", 35, "Los Angeles")
        );

        Map<String, String> names = people.stream().collect(Collectors.toMap(p->p.getName(), p->p.getCity())) ;                                                                                                                                                                                                                      ;
        System.out.println(names);
    }
}
