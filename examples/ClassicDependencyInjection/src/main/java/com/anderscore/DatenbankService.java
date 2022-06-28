package com.anderscore;

import java.util.List;

public class DatenbankService {

    public final String url;

    public DatenbankService(String url) {
        this.url = url;
    }

    public List<Object> findAll(String tableName) {
        //SQL
        return List.of("Max Mustermann"); //Eigentliches Ergebnis
    }

}
