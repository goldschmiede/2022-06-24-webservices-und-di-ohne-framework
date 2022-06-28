package com.anderscore;

import com.anderscore.annotations.Component;

import java.util.List;

@Component
public class DatenbankService {

    public final String url = "Url mit Zugangsdaten";

    public List<Object> findAll(String tableName) {
        //SQL
        return List.of("Max Mustermann"); //Eigentliches Ergebnis
    }

}
