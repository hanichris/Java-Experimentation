package com.examples.objects;

public class OuterClass {
    String outerField = "Outer field";
    static String staticOuterField = "Static outer field";

    class InnerClass {
        void accessMembers() {
            System.out.println(outerField);
            System.out.println(staticOuterField);
        }
    }

    /**
     * Interacts with the instance members of its outer class like any other
     * top-level class
    */
    static class StaticNestedClass {
        void accessMembers(OuterClass outer) {
            System.out.println(outer.outerField);
            System.out.println(staticOuterField);
        }
    }

    public static void main(String[] args) {
        System.out.println("Inner class:");
        System.out.println("------------");

        OuterClass outerObject = new OuterClass();
        OuterClass.InnerClass innerObject = outerObject.new InnerClass();

        innerObject.accessMembers();

        System.out.println("\nStatic nested class:");
        System.out.println("----------------------");
        StaticNestedClass staticNestedObject = new StaticNestedClass();

        staticNestedObject.accessMembers(outerObject);

        System.out.println("\nTop-Level class:");
        System.out.println("------------------");
        TopLevelClass topLevelObject = new TopLevelClass();
        topLevelObject.accessMembers(outerObject);
    }
}
