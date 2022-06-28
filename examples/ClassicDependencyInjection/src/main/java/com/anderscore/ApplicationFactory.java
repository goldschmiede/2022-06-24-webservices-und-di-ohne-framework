package com.anderscore;

public class ApplicationFactory {

    //Nicht Threadsafe!

    static DatenbankService datenbankService;
    static PersonenService personenService;

    public static DatenbankService createDatenbankService() {
        if (datenbankService == null) {
            //Zugangsdaten einlesen
            datenbankService = new DatenbankService("url aus zugangsdaten");
        }
        return datenbankService;
    }

    public static PersonenService createPersonenService() {
        if (personenService == null) {
            personenService = new PersonenService(createDatenbankService());
        }
        return personenService;
    }

}
