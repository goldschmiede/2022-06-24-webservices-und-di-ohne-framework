package com.anderscore;

public class Main {

    public static void main(String[] args) {
        PersonenService personenService = ApplicationFactory.createPersonenService();
        System.out.println(personenService.allNames());
    }

}
