package Lesson20;

import Lesson16.Person;
import Lesson16.PersonApi;

import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<Person> personFromApi = PersonApi.getPersonFromApi(20);
        for (Person person : personFromApi) {
            System.out.println(person);


        }
        System.out.println("_________________________________________");

//        List<Person> iran = personFromApi.stream()
//                .filter(person -> person.getCountry().equals("Iran"))
//                .collect(Collectors.toList());
//
//        List<String> collect = personFromApi.stream()
//                .map(person -> person.getUsername())
//                .collect(Collectors.toList());

//        1)вывести женщин старше 20 лет;
//        2)найти мужчин младше 35 лет и вывести значение в виде ФИО дата рождения (пример Мухаметов дамир шокирович 01.01.2222)
//        3)найти всех кто старше 50 и сохранить этих людей в отдельный лист
//        4)вывести всех у кого Длина фио меньше 30 символов.


        System.out.println("_________________________________________");


        personFromApi.stream()
                .filter(person -> person.getAge() > 20 && person.getGender().equals("female"))
                .forEach(System.out::println);

        System.out.println("_________________________________________");

        personFromApi.stream()
                .filter(person -> person.getAge() < 35 && person.getGender().equals("male"))
                .map(person -> person.getLastname() + " " + person.getName() + " " + person.getDob().toString()
                )
                .forEach(System.out::println);

        System.out.println("_________________________________________");

        List<Person> oldman = personFromApi.stream()
                .filter(person -> person.getAge() > 50)
                .collect(Collectors.toList());

        List<String> smallfio = personFromApi.stream()
                .map(person -> person.getLastname() + " " + person.getName())
                .filter(fio -> fio.length() < 15)
                .peek(System.out::println)
                .collect(Collectors.toList());

    }
}


