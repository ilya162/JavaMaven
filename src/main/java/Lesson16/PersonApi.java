package Lesson16;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class PersonApi {
    public static Person getPersonFromApi() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://randomuser.me/api")).
                GET().
                build();
        try {
            HttpResponse<String> responsex = client.send(request, HttpResponse.BodyHandlers.ofString());
            Person person = parseJsonToPerson(responsex);
            return person;

        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    public static Person parseJsonToPerson(HttpResponse<String> responsex) {
        JSONObject object = new JSONObject(responsex.body())
                .getJSONArray("results").getJSONObject(0);
        Person res = new Person();
        res.setName(object.getJSONObject("name").getString("first"));
        res.setLastname(object.getJSONObject("name").getString("last"));
        res.setCountry(object.getJSONObject("location").getString("country"));
        res.setPassword(object.getJSONObject("login").getString("password"));
        res.setUsername(object.getJSONObject("login").getString("username"));
        LocalDateTime dob =
                ZonedDateTime.parse(object.getJSONObject("dob").getString("date")).toLocalDateTime();
        res.setGender(object.getString("gender"));
        res.setDob(dob);


        return res;
    }

    public static List<Person> getPersonFromApi(int count) {
        List<Person> persons = new ArrayList<>();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder().
                GET().
                uri(URI.create("https://randomuser.me/api")).
                build();
        try {
            for (int i = 0; i < count; i++) {
                HttpResponse<String> responsex = client.send(request, HttpResponse.BodyHandlers.ofString());
                Person person = parseJsonToPerson(responsex);
                persons.add(person);
            }
            return persons;

        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    public static List<Person> getPersons(int count) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(String.format("https://randomuser.me/api?results=%d", count))).
                GET().
                build();
        try {
            HttpResponse<String> responsex = client.send(request, HttpResponse.BodyHandlers.ofString());
            List<Person> people = jsonParser(responsex);
            return people;

        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    public static List<Person> jsonParser(HttpResponse<String> response) {
        List<Person> res = new ArrayList<>();

        int count = new JSONObject(response.body()).getJSONObject("info").getInt("results");
        for (int i = 0; i < count; i++) {
            JSONObject object
                    = new JSONObject(response.body()).
                    getJSONArray("results").getJSONObject(i);
            Person person = new Person();
            person.setName(object.getJSONObject("name").getString("first"));
            person.setLastname(object.getJSONObject("name").getString("last"));
            person.setCountry(object.getJSONObject("location").getString("country"));
            person.setPassword(object.getJSONObject("login").getString("password"));
            person.setUsername(object.getJSONObject("login").getString("username"));
            person.setDob(ZonedDateTime.parse(object.getJSONObject("dob").getString("date")).toLocalDateTime());                    ;
            person.setGender(object.getString("gender"));



            res.add(person);
        }


        return res;
    }


}

