package Lesson21;

import Lesson16.Person;
import Lesson16.PersonApi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Homework {
    public static void main(String[] args) {
//        дз)
//        1) запросить 100 персонажей.
//        2) раскидать гендерно и получить 2 листа с мужчинами и женщинами.
//        3) от этих листов, так же найти самого/самую взрослого и самого молодого, Вывести .
//        4)посчитать количество в каждом списке.
//        5)вывести средний возраст мужчин и отдельно срежний возраст жегщин.
//        6) посчитать общий возраст мужчин.
//        женщин посчитать общий возраст

        List<Person> persons = PersonApi.getPersonFromApi(100);






            persons.stream()
                    .filter(person1 -> person1.getGender().equals("female"))
                    .collect(Collectors.toList())
                    .forEach(System.out::println);


//
//            persons.stream()
//                    .filter(person1 -> person1.getGender().equals("male"))
//                    .collect(Collectors.toList())
//                    .forEach(System.out::println);

        System.out.println("--------------------------------------------");
    }
}
