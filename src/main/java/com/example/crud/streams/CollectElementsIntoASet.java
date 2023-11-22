package com.example.crud.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectElementsIntoASet {
    public static void main (String args []){
        List<Person> people = Arrays.asList(
                new Person("Alice", 25, "New York"),
                new Person("Bob", 30, "San Francisco"),
                new Person("Charlie", 22, "New York"),
                new Person("David", 28, "San Francisco"),
                new Person("Eve", 35, "Los Angeles")
        );

        Set<String> cities = people.stream().map(p->p.getCity()).collect(Collectors.toSet());
        System.out.println(cities);
    }
}
