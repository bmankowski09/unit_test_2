package com.company;

import java.util.ArrayList;
import java.util.List;

public class Mama {

    private int id;
    private String name;
    private int age;
    private List<Dziecko> dzieci;

    public Mama(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Dziecko> getDzieci() {
        return dzieci;
    }

    public void addDziecko(Dziecko dziecko) {
        if (dzieci == null) {
            dzieci = new ArrayList<>();
            dzieci.add(dziecko);
        } else {
            dzieci.add(dziecko);
        }
    }

    @Override
    public String toString() {
        return "Mama{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
