package Lesson16;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
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
//        res.setDob(ZonedDateTime.parse(object.getJSONObject("dob").getString("date"))).toLocaleDateTime;


        return res;
    }

    public static List<Person> getPersonFromApi(int count) {
        List<Person> persons = new ArrayList<>();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://randomuser.me/api")).
                GET().
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

//    public static List<Person> getPersons(int count) {
//
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(String.format("https://randomuser.me/api?results=%d", count))).
//                GET().
//                build();
//        try {
//            HttpResponse<String> responsex = client.send(request, HttpResponse.BodyHandlers.ofString());
//            Person person = parseJsonToPerson(responsex);
//            return person;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
//        return null;
//    }
//
//    public List <Person> jsonParser(HttpResponse<String> response) {
//        int count = new JSONObject(response.body()).getJSONObject("info").getInt("results");
//        JSONObject object = new JSONObject(response.body())
//                .getJSONArray("results").getJSONObject(0);
//        Person res = new Person();
//        res.setName(object.getJSONObject("name").getString("first"));
//        res.setLastname(object.getJSONObject("name").getString("last"));
//        res.setCountry(object.getJSONObject("location").getString("country"));
//        res.setPassword(object.getJSONObject("login").getString("password"));
//        res.setUsername(object.getJSONObject("login").getString("username"));
//
//    }
}

