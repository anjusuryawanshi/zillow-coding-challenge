zillow-coding-challenge
================

# Build Instructions

To build and run tests:

``` bash
$ ./gradlew clean build
```

# Design trade-offs

Problem: 

> Given a class `Person`, write a solution to sort an `Iterable` of `Person`
> based on any given field by name.

## Current design

This solution is implemented using `java.util.Comparator` which uses a
"field extractor" based on the input field name. The `FIELD_EXTRACTORS` is a map
that maps field name to the corresponding extractor.

Overall complexity: `O(n) + O(nlog(n))`

### Improvement to the current design

`O(n)` can be removed by implementing a binary search based insertion algorithm
 which inserts an instance of `Person` at the right index as determined by the 
 comparator (explained above).

## Alternatives

### Using Reflection

Using java reflection, we can implement the field value extraction logic like this:

``` java
Method getSsn = Person.class.getMethod("getSsn");
Object value = getSsn.invoke(person1);
return (String) value;
```

But, Java's implementation of [reflection is slow](http://stackoverflow.com/questions/1392351/java-reflection-why-is-it-so-slow).
Thus it made more sense to not use it for the solution.

### if-else / switch case

We can also implement the field extraction using a series of if-else or a bunch of
switch case statements. This code will look procedural in nature and will
increase the overall complexity by adding branches. I think the current design
follows most closely to the OOP principles.