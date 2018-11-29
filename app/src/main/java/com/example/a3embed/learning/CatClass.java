package com.example.a3embed.learning;

public class CatClass extends AnimalClass {

    int age;
    String name;

    CatClass(int age, String name) {
        super(age, name);
        this.age = age;
        this.name = name;
    }

    public String catDetails() {
        return "Cat Name: " + this.name + " and Age: " + this.age;
    }

}
