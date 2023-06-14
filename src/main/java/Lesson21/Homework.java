package Lesson21;

import Lesson16.Person;
import Lesson16.PersonApi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Homework {
    public static void main(String[] args) {
//        дз)
//        1) запросить 100 персонажей.
//        2) раскидать гендерно и получить 2 листа с мужчинами и женщинами.
//        3) от этих листов, так же найти самого/самую взрослого и самого молодого, вывести.
//        4)посчитать количество в каждом списке.
//        5)вывести средний возраст мужчин и отдельно средний возраст женщин.
//        6) посчитать общий возраст мужчин,
//         посчитать общий возраст женщин

        List<Person> persons = PersonApi.getPersonFromApi(100);


        persons.stream()
                .filter(person1 -> person1.getGender().equals("female"))//женщины
                .collect(Collectors.toList())
                .forEach(System.out::println);


        System.out.println("--------------------------------------------");

        persons.stream()
                .filter(person1 -> person1.getGender().equals("male"))//мужчины
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("--------------------------------------------");

        List<Person> youngfemale = persons.stream()// самая молодая женщина
                .sorted((o1, o2) -> {
                    if (o1.getAge() == o2.getAge())
                        return o1.getName().compareTo(o2.getName());
                    else if (o1.getAge() > o2.getAge())
                        return 1;
                    else return -1;
                })
                .filter(person1 -> person1.getGender().equals("female"))
                .limit(1)
                .collect(Collectors.toList());


        youngfemale.forEach(System.out::println);

        System.out.println("--------------------------------------------");

        List<Person> oldfemale = persons.stream()// самая пожилая женщина
                .sorted((o1, o2) -> {
                    if (o1.getAge() == o2.getAge())
                        return o1.getName().compareTo(o2.getName());
                    else if (o1.getAge() < o2.getAge())
                        return 1;
                    else return -1;
                })
                .filter(person1 -> person1.getGender().equals("female"))
                .limit(1)
                .collect(Collectors.toList());


        oldfemale.forEach(System.out::println);

        System.out.println("--------------------------------------------");

        List<Person> youngman = persons.stream()// самый молодой мужчина
                .sorted((o1, o2) -> {
                    if (o1.getAge() == o2.getAge())
                        return o1.getName().compareTo(o2.getName());
                    else if (o1.getAge() > o2.getAge())
                        return 1;
                    else return -1;
                })
                .filter(person1 -> person1.getGender().equals("male"))
                .limit(1)
                .collect(Collectors.toList());


        youngman.forEach(System.out::println);

        System.out.println("--------------------------------------------");

        List<Person> oldman = persons.stream()// самый пожилой мужчина
                .sorted((o1, o2) -> {
                    if (o1.getAge() == o2.getAge())
                        return o1.getName().compareTo(o2.getName());
                    else if (o1.getAge() < o2.getAge())
                        return 1;
                    else return -1;
                })
                .filter(person1 -> person1.getGender().equals("male"))
                .limit(1)
                .collect(Collectors.toList());


        oldman.forEach(System.out::println);

        System.out.println("--------------------------------------------");

        System.out.println(persons.stream().filter(person1 -> person1.getGender().equals("female")).count());// количество женщин в списке

        System.out.println("--------------------------------------------");

        System.out.println(persons.stream().filter(person1 -> person1.getGender().equals("male")).count());// количество мужчин в списке


        System.out.println("--------------------------------------------");

        Double averagefemale = persons.stream().filter(person1 -> person1.getGender().equals("female")) // средний возраст женщин
                .collect(Collectors.averagingInt(Person::getAge));
        System.out.println(averagefemale);

        System.out.println("--------------------------------------------");

        Double averagemale = persons.stream().filter(person1 -> person1.getGender().equals("male")) // средний возраст мужчин
                .collect(Collectors.averagingInt(Person::getAge));
        System.out.println(averagemale);

        System.out.println("--------------------------------------------");

       persons.stream().filter(person1 -> person1.getGender().equals("female")).map(person -> person.getAge())// общий возраст женщин
                .reduce((acc, x) -> acc + x)
                .ifPresent(System.out::println);


        System.out.println("--------------------------------------------");

        persons.stream().filter(person1 -> person1.getGender().equals("male")).map(person -> person.getAge())// общий возраст мужчин
                .reduce((acc, x) -> acc + x)
                .ifPresent(System.out::println);

    }
}
