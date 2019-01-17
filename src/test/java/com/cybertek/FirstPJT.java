package com.cybertek;

import com.github.javafaker.Faker;

public class FirstPJT {
    public static void main(String[] args) {
        Faker fake = new Faker();
        System.out.println(fake.pokemon().name());

    }

}
