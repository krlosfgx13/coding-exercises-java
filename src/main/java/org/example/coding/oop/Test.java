package org.example.coding.oop;

public class Test {

    public static void main(String[] args){
        Person p = new Person("Antonio Caceres", "Guatemala", 25);
        p.printInfo();
        printDataFromTest(p);
    }

    private static void printDataFromTest(Person p){
        System.out.println(p.getFullName());
        System.out.println(p.getCountry());
        System.out.println(p.getAge());
    }
}
