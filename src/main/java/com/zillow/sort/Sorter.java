package com.zillow.sort;

import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sorter {

    static List<Person> sort(Iterable<Person> people, String sortField, String ascending){
        Preconditions.checkNotNull(people, "people is null");
        Preconditions.checkNotNull(sortField, "sort field is null");
        Preconditions.checkNotNull(ascending, "ascending is null");

        List<Person> persons = new ArrayList<>();
        people.forEach(persons::add);
        Comparator<Person> comparator = new PersonComparator(sortField);
        if ("false".equals(ascending)) {
            comparator = comparator.reversed();
        }
        Collections.sort(persons, comparator);
        return persons;
    }
}
