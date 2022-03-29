package com.company;

import java.util.Date;

public class Dziecko {

    private int id;
    private String sex;
    private String name;
    private Date bornDate;
    private int weight;
    private int height;
    private Mama mama;

    public Dziecko(int id, String sex, String name, Date bornDate, int weight, int height, Mama mama) {
        this.id = id;
        this.sex = sex;
        this.name = name;
        this.bornDate = bornDate;
        this.weight = weight;
        this.height = height;
        this.mama = mama;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Mama getMama() {
        return mama;
    }

    public void setMama(Mama mama) {
        this.mama = mama;
    }

    @Override
    public String toString() {
        return "Dziecko{" +
                "id=" + id +
                ", sex='" + sex + '\'' +
                ", name='" + name + '\'' +
                ", bornDate='" + bornDate + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", mama=" + mama +
                "}\n";
    }
}
