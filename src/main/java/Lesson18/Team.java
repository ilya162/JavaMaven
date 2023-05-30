package Lesson18;

import java.util.ArrayList;
import java.util.Objects;

public class Team <T> {
    private String name;
    ArrayList<T> emploes =new ArrayList<>();

    public Team() {
    }

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void addEmploe(T e){
        emploes.add(e);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(name, team.name) && Objects.equals(emploes, team.emploes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, emploes);
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", emploes=" + emploes +
                '}';
    }
}
