package Lesson16;

import java.util.List;

public class


Main {
    public static void main(String[] args) {
       Person pesrsonFromApi= PersonApi.getPersonFromApi();
        System.out.println(pesrsonFromApi);
        List<Person> personFromApi = PersonApi.getPersonFromApi(100);
        for (Person person : personFromApi) {
            System.out.println(person);

        }


    }
        }



