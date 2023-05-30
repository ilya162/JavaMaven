//package Lesson19;
//
//import Lesson16.Person;
//import Lesson16.PersonApi;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//public class
//Main {
//    public static void main(String[] args) {
//        List<Person> persons = PersonApi.getPersons(10);
//        for (Person person : persons) {
//            System.out.println(person);
//
//        }
//        System.out.println("____________________________________________");
//        LamdaExample.sortLamda(persons, new Predicato<Person>() {
//            @Override
//            public boolean test(Person person) {
//                return LocalDateTime.now().getYear()
//                        -person.getDob().getYear()<30;
//            }
//        });
//
//    }
//}
//interface Predicato <T>{
//    boolean test(T t);
//}
//class LamdaExample{
//    public static void sortLamda(List<Person> list,Predicato<Person> p){
//        for (Person person : list) {
//            if (p.test(person)) System.out.println(person);
//        }
//    }
//}
