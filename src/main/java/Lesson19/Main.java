package Lesson19;

import Lesson16.Person;
import Lesson16.PersonApi;

import java.time.LocalDateTime;
import java.util.List;
// Слева находится то,что передается,справа результат.
// То что слева : 1 тип можно без скобок,если больше одно,то круглые скобки нужны
//Затем идет магическая стрелка ->
// Если есть фигурные скобки,надо поставить return,скобки нужны,если надо выполнить несколько действий.


public class
Main {
    public static void main(String[] args) {
        List<Person> persons = PersonApi.getPersons(10);
        for (Person person : persons) {
            System.out.println(person);

        }
//        System.out.println("____________________________________________");
//        LamdaExample.sortLamda(persons, new Predicato<Person>() {
//            @Override
//            public boolean test(Person person) {
//                return LocalDateTime.now().getYear()
//                        - person.getDob().getYear() < 30;
//               // persons.stream().filter(p->p.getCountry().equals("Spain")).forEach(System.out::println); тоже самое через Stream
//            }
//        });
//        LamdaExample.sortLamda(persons,
//                (Person person)->{return person.getCountry().equals("Spain");}); второй вид записи
//        LamdaExample.sortLamda(persons,
//                p->p.getCountry().equals("Spain")); третий вид записи
        LamdaExample.sortLamda(persons,p-> p.getCountry().equals("Iran"),
                pp-> System.out.println(pp));

    }
}

interface Predicato<T> {
    boolean test(T t);
}
interface Consumerito<T>{
    void accept(T t);
}

class LamdaExample {
    public static void sortLamda(List<Person> list, Predicato<Person> p,Consumerito<Person> c) {
        for (Person person : list) {
            if (p.test(person)) c.accept(person);
        }
    }

}
