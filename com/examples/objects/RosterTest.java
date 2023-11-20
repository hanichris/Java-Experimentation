package com.examples.objects;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class RosterTest {
    
    interface CheckPerson {
        boolean test(Person p);
    }

    // 1.) Create methods to search for a person who matches one criteria.
    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }

    // 2.) Create more generalised search methods
    public static void printPersonsWithinRange(
        List<Person> roster, int low, int high
    ) {
        for (Person p : roster) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
            }
        }
    }

    // 3.) Specify the search criteria code in a Local Class.
    // 4.) Specify the search criteria code in an Anonymous Class.
    // 5.) Specify the search criteria code with a Lambda Expression.
    public static void printPersons(
        List<Person> roster, CheckPerson tester
    ) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    // 6.) Using a Standard Functional Interface with Lambda Expressions.
    public static void printPersonsWithPredicate(
        List<Person> roster, Predicate<Person> tester
    ) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    // 7.) Use Lambda Expressions throughout
    public static void processPersons(
        List<Person> roster,
        Predicate<Person> tester,
        Consumer<Person> block
    ) {
        for (Person p : roster) {
            if (tester.test(p)) {
                block.accept(p);
            }
        }
    }

    public static void main(String[] args) {
        List<Person> roster = Person.createRoster();
        
        for (Person p : roster) {
            p.printPerson();
        }

        // Invoke method 1
        System.out.println("\nPersons older than 20:");
        printPersonsOlderThan(roster, 20);
        System.out.println();

        // Invoke method 2
        System.out.println("Persons between the ages of 14 and 30:");
        printPersonsWithinRange(roster, 14, 30);
        System.out.println();

        // Invoke method 3: Using a Local Class.
        System.out.println("Persons who are eligible for Selective Service");
        class CheckPersonEligibleForSelectiveService implements CheckPerson {
            public boolean test(Person p) {
                return p.getGender() == Person.Sex.MALE
                    && p.getAge() >= 18
                    && p.getAge() <= 25;
            }
        }

        printPersons(roster, new CheckPersonEligibleForSelectiveService());

        System.out.println();

        // Invoke method 4: Using an Anonymous class.
        System.out.println("Persons who are eligible for Selective Service " +
            "(anonymous class):");
        printPersons(
            roster,
            new CheckPerson() {
                public boolean test(Person p) {
                    return p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25;
                }
            }
        );
        System.out.println();

        // Invokd method 5: Using a Lamda Expression
        System.out.println("Persons who are eligible for Selective Service " +
            "(Lambda Expression):");
        printPersons(
            roster,
            (Person p) -> p.getGender() == Person.Sex.MALE
                && p.getAge() >= 18
                && p.getAge() <= 25);
        System.out.println();

        // Invoke method 6: Using Standard Functional Interfaces with Lambda Expressions
        System.out.println("Persons who are eligible for Selective Service " +
            "(with Predicate Parameter):");
        printPersonsWithPredicate(
            roster,
            p -> p.getGender() == Person.Sex.MALE
                && p.getAge() >= 18
                && p.getAge() <= 25
        );
        System.out.println();

        // Invoke method 7: Use Lambda Expressions throughout the application
        System.out.println("Persons who are eligible for Selective Service " +
            "(with Predicate and Consumer Parameters):");
        processPersons(
            roster,
            p -> p.getGender() == Person.Sex.MALE
                && p.getAge() >= 18
                && p.getAge() <= 25,
            p -> p.printPerson()
        );
        System.out.println();
    }
}
