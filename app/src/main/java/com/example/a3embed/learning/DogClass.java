package com.example.a3embed.learning;

import android.view.View;
import android.view.ViewGroup;

public class DogClass extends AnimalClass {

    int age;
    String name;


    DogClass(int age, String name) {
        this.age = age;
        this.name = name;
    }

    DogClass(String name) {
        this.name = name;
    }

    DogClass(int age) {
        this.age = age;
    }

    public String dogDetails() {
        return "Dog Name: " + this.name + " and Age: " + this.age;
    }

    public  String dogName() {
        return  "Dog Name: " + this.name + " and Age is not known";
    }

    public  String dogAge() {
        return  "Dog Name is not known  and Age: " + this.age;
    }

    @Override
    public String makeSound() {
        return "Makes a noise of Bark. Because every dog makes that noise.";
    }

}
