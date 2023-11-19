package com.examples.objects;

public class TopLevelClass {
    
    void accessMembers(OuterClass outer) {
        System.out.println(outer.outerField);
        System.out.println(OuterClass.staticOuterField);
    }
}
