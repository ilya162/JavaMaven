package Lesson21;

import Lesson16.Person;
import Lesson16.PersonApi;

import java.util.List;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        List<Person> persons = PersonApi.getPersonFromApi(10);
        for (Person person : persons) {
            System.out.println(person);

        }
        System.out.println("_________________________________________");

        persons.stream().map(person -> person.getAge())
                .reduce((acc, x) -> acc + x);

        Stream.of(1,2,3,4,5,6)
                .reduce((accumulyator, peremennaya_lista)->
        accumulyator+peremennaya_lista)
       .ifPresent(System.out::println);
        System.out.println("_________________________________________");


        persons.stream().sorted((o1, o2) -> {
                    if (!o1.getName().equals(o2.getName()))
                        return o1.getName().compareTo(o2.getName());
                    return 0;
                })
                .forEach(System.out::println);
        System.out.println("_________________________________________");


        Stream<Integer>integerStream = Stream.of(1,2,3,4,5,6);
        Stream<Integer>integerStream1 = Stream.of(11,12,13,14,15,16,6);
        Stream.concat(integerStream,integerStream1).distinct().forEach(System.out::println);
        //distinct убрать дубли, concat объединение,count количество

    }
}


