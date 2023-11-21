package com.examples.objects;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public class MethodReferencesTest {

    public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>>
        DEST transferElements(
            SOURCE sourceCollection,
            Supplier<DEST> collectionFactory
    ){
        DEST result = collectionFactory.get();
        for (T t : sourceCollection) {
            result.add(t);
        }
        return result;
    }
    
    public static void main(String[] args) {
        List<Person> roster = Person.createRoster();

        for (Person p : roster) {
            p.printPerson();
        }

        Person[] rosterAsArray = roster.toArray(new Person[roster.size()]);

        class PersonAgeComparator implements Comparator<Person> {
            public int compare(Person a, Person b) {
                return a.getBirthday().compareTo(b.getBirthday());
            }
        }

        Arrays.sort(rosterAsArray, new PersonAgeComparator());
        System.out.println();
        for (Person p : rosterAsArray) {
            p.printPerson();
        }
        // Because the Comparator interface is a functional interface, the alternative
        // approach would be to use a lambda expression instead of defining and creating
        // a new instance of a class that implements this interface.
        // Arrays.sort(
        //     rosterAsArray,
        //     (Person a, Person b) -> a.getBirthday().compareTo(b.getBirthday())
        // );

        // There already exists a method that does this age comparison.
        // Invoke this method instead of the lambda expression.
        // Arrays.sort(
        //     rosterAsArray,
        //     (a, b) -> Person.compareByAge(a, b)
        // );

        // Because th above lambda expression involves invoking a method that already
        // exists, employ a method reference instead of the lambda expression.
        Arrays.sort(rosterAsArray, Person::compareByAge);

        // Reference to an instance method of a particular object.
        class ComparisonProvider {
            public int compareByName(Person a, Person b) {
                return a.getName().compareTo(b.getName());
            }

            public int compareByAge(Person a, Person b) {
                return a.getBirthday().compareTo(b.getBirthday());
            }
        }

        ComparisonProvider myComparisonProvider = new ComparisonProvider();
        Arrays.sort(rosterAsArray, myComparisonProvider::compareByName);
        System.out.println();
        for (Person p : rosterAsArray) {
            p.printPerson();
        }
        System.out.println();

        // Reference to an instance method of an arbitrary object of a
        // particular type
        String[] stringArray = { "Barbara", "James", "Mary", "John",
        "Patricia", "Robert", "Michael", "Linda" };
        for (String name : stringArray) {
            System.out.println(name);
        }
        Arrays.sort(stringArray, String::compareToIgnoreCase);
        System.out.println();
        for (String name : stringArray) {
            System.out.println(name);
        }

        // Set<Person> rosterSetLambda = transferElements(roster, () -> { return new HashSet<>();});

        // Reference to a constructor.
        Set<Person> rosterSet = transferElements(roster, HashSet::new);
        // or
        // Set<Person> rosterSet = transferElements(roster, HashSet<People>::new);
        System.out.println("\nPrinting rosterSet:");
        rosterSet.stream().forEach(p -> p.printPerson());

        
    }
}
