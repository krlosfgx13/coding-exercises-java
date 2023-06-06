package org.example.coding.oop;

public class Person {

    private String fullName;
    private String country;
    private int age;

    public Person(String fullName, String country, int age) {
        this.fullName = fullName;
        this.country = country;
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void printInfo(){
        System.out.println(this.fullName);
        System.out.println(this.country);
        System.out.println(this.age);
    }
}
