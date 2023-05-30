package Lesson18;

import java.util.Objects;

public abstract class Emploe {
    private String name;
    private int age;

    public Emploe() {
    }

    public Emploe(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emploe emploe = (Emploe) o;
        return age == emploe.age && Objects.equals(name, emploe.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Emploe{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
