package com.zillow.sort;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import org.apache.commons.lang3.builder.CompareToBuilder;

import java.util.Comparator;
import java.util.Map;

public class PersonComparator implements Comparator<Person> {

    private static final Map<String, FieldExtractor> FIELD_EXTRACTORS =
            ImmutableMap.<String, FieldExtractor>builder()
                    .put("ssn", Person::getSsn)
                    .put("dateOfBirth", Person::getDateOfBirth)
                    .put("firstName", Person::getFirstName)
                    .put("lastName", Person::getLastName)
                    .put("heightIn", Person::getHeightIn)
                    .put("weightLb", Person::getWeightLb)
                    .build();
    private final FieldExtractor extractor;

    public PersonComparator(String sortField) {
        extractor = FIELD_EXTRACTORS.get(sortField);
        Preconditions.checkArgument(extractor != null, "illegal sort field: " + sortField);
    }

    @Override
    public int compare(Person person1, Person person2) {
        return new CompareToBuilder()
                .append(extractor.extract(person1), extractor.extract(person2))
                .build();
    }

    private interface FieldExtractor {
        Comparable extract(Person person);
    }
}
