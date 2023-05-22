//package Lesson16;
//
//import org.json.JSONObject;
//
//import java.io.IOException;
//import java.net.URI;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//
//public class PersonApi {
//    public static Person getPersonFromApi() {
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://randomuser.me/api")).
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
//    public static Person parseJsonToPerson(HttpResponse<String> responsex) {
//        JSONObject object = new JSONObject(responsex.body())
//                .getJSONArray("results").getJSONObject(0);
//        Person res = new Person();
//        res.setName(object.getJSONObject("name").getString("first"));
//        res.setLastname(object.getJSONObject("name").getString("last"));
//        res.setCountry(object.getJSONObject("location").getString("country"));
//        res.setPassword(object.getJSONObject("login").getString("password"));
//        res.setUsername(object.getJSONObject("login").getString("username"));
//        res.setDob();
//
//
//
//        return res;
//    }
//
//}
