package com.anderscore;

public class Main {

    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ApplicationContext(ApplicationConfig.class);
        PersonenService personenService = applicationContext.getInstance(PersonenService.class);
        System.out.println(personenService.allNames());
    }

}
