package org.example.coding.oop;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ObjectOrientedProgExercises {

    private static void calculateAgeAndSort() {
        //accurately calculate age: https://www.javatpoint.com/java-calculate-age
        List<Person> persons = new ArrayList<>();
        Person p1 = new Person("Carlos", "Gonzalez", LocalDate.of(1997, 12, 13));
        Person p2 = new Person("Juan", "Perez", LocalDate.of(1994, 4, 1));
        Person p3 = new Person("Luis", "Lopez", LocalDate.of(1986, 7, 24));
        Person p4 = new Person("Kate", "Doe", LocalDate.of(2002, 11, 30));

        p1.setAge(Period.between(p1.getBirthDate(), LocalDate.now()).getYears());
        p2.setAge(Period.between(p2.getBirthDate(), LocalDate.now()).getYears());
        p3.setAge(Period.between(p3.getBirthDate(), LocalDate.now()).getYears());
        p4.setAge(Period.between(p4.getBirthDate(), LocalDate.now()).getYears());
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.add(p4);

        //persons.sort((p11, p21) -> p21.getAge().compareTo(p11.getAge())); //descending order
        persons.sort(Comparator.comparing(Person::getAge)); //ascending order

        for (Person p : persons) {
            System.out.println(p.getLastName() + ", " + p.getFirstName() + ", " + p.getAge());
        }

        /*
        Old-fashioned way
           Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p2.getAge().compareTo(p1.getAge());
            }
        });
        * */
    }

    public static class Person implements Comparable<Person> {
        private String firstName;
        private String lastName;
        private LocalDate birthDate;
        private Integer age;

        public Person(String firstName, String lastName, LocalDate birthDate) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.birthDate = birthDate;
        }

        public Person() {

        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public LocalDate getBirthDate() {
            return birthDate;
        }

        public void setBirthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public int compareTo(Person o) {
            return 0;
        }
    }

}
