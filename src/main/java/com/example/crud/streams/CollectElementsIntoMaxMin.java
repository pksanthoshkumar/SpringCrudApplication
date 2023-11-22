package com.example.crud.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CollectElementsIntoMaxMin {
    public static void main (String args []){
        List<Person> people = Arrays.asList(
                new Person("Alice", 25, "New York"),
                new Person("Bob", 30, "San Francisco"),
                new Person("Charlie", 22, "New York"),
                new Person("David", 28, "San Francisco"),
                new Person("Eve", 35, "Los Angeles")
        );

        Optional maxPerson = people.stream().collect(Collectors.maxBy(Comparator.comparingInt(p->p.getAge()))) ;
        Optional minPerson = people.stream().collect(Collectors.minBy(Comparator.comparingInt(p->p.getAge()))) ;

        System.out.println(maxPerson.get());
        System.out.println(minPerson.get());
    }
}
