package Lesson16;

import java.time.LocalDateTime;
import java.util.Objects;

public class Person {
    private String name;
    private String lastname;
    private String country;
    private LocalDateTime dob;
    private String username;
    private String password;
    private String gender;

    public Person() {
    }

    public Person(String name, String lastname, String country, LocalDateTime dob, String username, String password, String gender) {
        this.name = name;
        this.lastname = lastname;
        this.country = country;
        this.dob = dob;
        this.username = username;
        this.password = password;
        this.gender = gender;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(lastname, person.lastname) && Objects.equals(country, person.country) && Objects.equals(dob, person.dob) && Objects.equals(username, person.username) && Objects.equals(password, person.password) && Objects.equals(gender, person.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastname, country, dob, username, password, gender);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", country='" + country + '\'' +
                ", dob=" + dob +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public int getAge(){
        return LocalDateTime.now().getYear()-dob.getYear();
    }


}
