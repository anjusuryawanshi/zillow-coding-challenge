package com.zillow.sort;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

public class Person {

    private String ssn;
    private Date dateOfBirth;
    private String firstName;
    private String lastName;
    private Double heightIn;
    private Double weightLb;

    public String getSsn() {
        return ssn;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Double getHeightIn() {
        return heightIn;
    }

    public Double getWeightLb() {
        return weightLb;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append(ssn)
                .append(dateOfBirth)
                .append(firstName)
                .append(lastName)
                .append(heightIn)
                .append(weightLb)
                .build();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(ssn)
                .append(dateOfBirth)
                .append(firstName)
                .append(lastName)
                .append(heightIn)
                .append(weightLb)
                .build();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Person)) {
            return false;
        }

        Person other = (Person) obj;
        return new EqualsBuilder()
                .append(ssn, other.ssn)
                .append(dateOfBirth, other.dateOfBirth)
                .append(firstName, other.firstName)
                .append(lastName, other.lastName)
                .append(heightIn, other.heightIn)
                .append(weightLb, other.weightLb)
                .build();
    }

    private static final class Builder {

        private final Person person = new Person();

        public Builder ssn(String ssn) {
            person.ssn = ssn;
            return this;
        }

        public Builder dateOfBirth(Date dateOfBirth) {
            person.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder firstName(String firstName) {
            person.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            person.lastName = lastName;
            return this;
        }

        public Builder heightIn(Double heightIn) {
            person.heightIn = heightIn;
            return this;
        }

        public Builder weightLb(Double weightLb) {
            person.weightLb = weightLb;
            return this;
        }

        public Person build() {
            return person;
        }

    }
}
