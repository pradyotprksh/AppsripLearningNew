package com.example.a3embed.learning;

import android.util.Log;

public class AnimalClass {

    private static final String TAG = "MyActivity";

    int age;
    String name;

    AnimalClass() {
        Log.v(TAG, "Animal is created");
    }

    AnimalClass(int age, String name) {
        Log.v(TAG, "Animal is created with name: " + name + " and Age: " + age);
        this.age = age;
        this.name = name;
    }

    public String makeSound() {
        return this.name + " makes a noise. Because every animal makes a noise. And his age is " + this.age;
    }

}
