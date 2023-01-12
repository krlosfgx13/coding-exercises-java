package org.example.coding.examples;

import org.example.coding.oop.ObjectOrientedProgExercises;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class CodeExamples {

    public void findLettersAlphabet() {
        for (int i = 0; i < 26; i++) {
            System.out.println((char) ('a' + i));
        }
    }

    public void testIndexes() {
        int[] arr = {8, 4, 9, 7, 6, 5, 3, 2};
        for (int i = 1; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public int countWordsTokenizer(String input) {
        int count = 0;
        StringTokenizer tokenizer = new StringTokenizer(input);
        return tokenizer.countTokens();
    }

    public void arraysTimeComplexity() {
        int[] arr = {5, 4, 2};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) { //j=0 -> 9. since values are traversed for each value since index 0.
                System.out.println("Hi."); //output = 9.
            }
        }
    }

    public void arraysTimeComplexity2() {
        int[] arr = {5, 4, 2};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) { //j=1 -> 3. since values are traversed for each value since index 1.
                System.out.println("Hi."); //output = 9. Line is printed once per every execution.
            }
        }
    }

    public void arraysTimeComplexity3() {
        int[] arr = {5, 4, 2};
        int[] arr2 = {2, 6};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                System.out.println("Hi."); //output = 9.
            }
        }
    }

    public void arraysTimeComplexity4() {
        int[] arr = {5, 4, 2};
        int[] arr2 = {2, 6};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                for (int k = 0; k < 4; k++) {
                    System.out.println("Hi."); //output = 24.
                }
            }
        }
    }

    public void measureExecutionTimeArrays(int[] arr) {
        long startTime = System.currentTimeMillis();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                System.out.println(arr[i] + "," + arr[j]);
            }
        }
        System.out.println("Time elapsed: " + (System.currentTimeMillis() - startTime) + "ms");
    }

    public void measureExecutionTimeArrays2(int[] arr, int[] arr2) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] < arr2[j]) {
                    System.out.println(arr[i] + "," + arr[j]);
                }
            }
        }
        System.out.println("Time elapsed: " + (System.currentTimeMillis() - startTime) + "ms");
    }

    public void compareStringOptions() {
        long startTime = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer("Java");
        for (int i = 0; i < 10000; i++) {
            sb.append("Tpoint");
        }
        System.out.println("Time taken by StringBuffer: " + (System.currentTimeMillis() - startTime) + "ms");
        startTime = System.currentTimeMillis();

        StringBuilder sb2 = new StringBuilder("Java");
        for (int i = 0; i < 10000; i++) {
            sb2.append("Tpoint");
        }
        System.out.println("Time taken by StringBuilder: " + (System.currentTimeMillis() - startTime) + "ms");
        startTime = System.currentTimeMillis();

        String s = "";
        for (int i = 0; i < 10000; i++) {
            s += "Tpoint";
        }
        System.out.println("Time taken by String: " + (System.currentTimeMillis() - startTime) + "ms");
    }

    public List<String> removeDuplicatesFromListLambda() {
        List<String> list = new ArrayList<>();
        list.add("USA");
        list.add("Canada");
        list.add("Canada");
        list.add("Mexico");
        list.add("England");
        list.add("USA");
        return list.stream().distinct().collect(Collectors.toList());
    }

    public ArrayList<String> removeDuplicatesFromList() {
        List<String> list = new ArrayList<>();
        list.add("USA");
        list.add("Canada");
        list.add("Canada");
        list.add("Mexico");
        list.add("England");
        list.add("USA");
        Set<String> set = new HashSet<>(list);
        return new ArrayList<>(set);
    }

    public Integer[] hashMapToArray() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");

        return map.keySet().toArray(new Integer[0]);
    }

    public String[] hashMapToArray2() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");

        return map.values().toArray(new String[0]);
    }

    public int[] convertListToArray() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(8);
        list.add(4);
        list.add(2);
        list.add(134);
        list.add(19);

        return list.stream().mapToInt(i -> i).toArray();
    }

    public int[] convertListToArray2(int[] input) {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(6);
        list.add(8);
        list.add(1);
        int[] output = new int[list.size()];
        for (int i = 0; i < output.length; i++) {
            output[i] = list.get(i);
        }
        return output;
    }

    public void calculateAgeAndSort() {
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

    public void streamFilterExample() {
        List<Person> persons = new ArrayList<>();
        Person p1 = new Person("Carlos", "Gonzalez", LocalDate.of(1997, 8, 13));
        Person p2 = new Person("Juan", "Perez", LocalDate.of(1994, 4, 1));
        Person p3 = new Person("Luis", "Lopez", LocalDate.of(1986, 7, 24));
        Person p4 = new Person("Kate", "Doe", LocalDate.of(2002, 7, 30));
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.add(p4);
        p1.setAge(LocalDate.now().getYear() - p1.getBirthDate().getYear());
        p2.setAge(LocalDate.now().getYear() - p2.getBirthDate().getYear());
        p3.setAge(LocalDate.now().getYear() - p3.getBirthDate().getYear());
        p4.setAge(LocalDate.now().getYear() - p4.getBirthDate().getYear());

        List<Person> adults = persons.stream().filter((Person per) -> per.getAge() > 21).collect(Collectors.toList());
        for (Person p : adults) {
            System.out.println(p.getLastName() + ", " + p.getFirstName() + ", " + p.getAge());
        }
    }

    public void exampleTokenizer(String sentence) {
        StringTokenizer tokenizer = new StringTokenizer(sentence);
        while (tokenizer.hasMoreTokens()) {
            System.out.println(tokenizer.nextToken());
        }
    }

    public void removeBlankSpaces(String input) {
        String text = "Hello    there this is   a test";
        String pattern = "\\s+";
        String text2 = text.replaceAll(pattern, " ");
        System.out.println(text2);

        //Difference between replace() and replaceAll()? replace() uses Char sequence and replaceAll() can use regex.
        //Use replace() if you just want to replace some char with another char or some String with another String (actually CharSequence).
        //Use replaceAll() if you want to use a regular expression pattern.
    }

    public void getOrDefaultHashMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 10);
        map.put("b", 20);
        map.put("c", 30);
        map.put("d", 40);
        //Is used to get the value mapped with specified key. If no value is mapped with the provided key then
        // the default value is returned.
        System.out.println(map.getOrDefault("a", 11));
        System.out.println(map.getOrDefault("b", 11));
        System.out.println(map.getOrDefault("c", 11));
        System.out.println(map.getOrDefault("d", 11));
        System.out.println(map.getOrDefault("e", 11));
        System.out.println(map);
    }

    public void hashMapVsLinkedHashMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 10);
        map.put("b", 20);
        map.put("c", 30);
        map.put("d", 40);
        map.put("e", 60);
        map.put("f", 70);
        map.put("g", 70);
        map.put("h", 80);
        System.out.println(map);

    }

    public void evenOrOddNumbers(int limit) {
        limit = 100;
        for (int i = 0; i < limit; i++) {
            if (i % 2 == 0) { //i % 2 != 0 for odd numbers.
                System.out.println(i);
            }
        }
    }

    public boolean isPrime(int x) {
        int n = 7;
        int count = 0;
        // Check if number is less than
        // equal to 1
        if (n <= 1)
            return false;

            // Check if number is 2
        else if (n == 2)
            return true;

            // Check if n is a multiple of 2
        else if (n % 2 == 0)
            return false;

        // If not, then just check the odds
        for (int i = 3; i <= Math.sqrt(n); i += 2) { //just numbers less than the square of n.
            if (n % i == 0)
                return false;
        }
        return true;
    }




    public class Person implements Comparable<ObjectOrientedProgExercises.Person> {
        public String firstName;
        public String lastName;
        public LocalDate birthDate;
        public Integer age;

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
        public int compareTo(ObjectOrientedProgExercises.Person o) {
            return 0;
        }
    }
}
