package Lesson21;

import Lesson16.Person;
import Lesson16.PersonApi;

import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Person> personFromApi = PersonApi.getPersonFromApi(10);
        for (Person person : personFromApi) {
           System.out.println(person);
        }
        System.out.println("___________________________________________");
        Stream.of(1,2,3,45,6,7,35335,67,455,9)
                .skip(5) // пропускает заданное количество значений
                .limit(3) // ограничивает количество значений
                .forEach(System.out::println);
    }
}
