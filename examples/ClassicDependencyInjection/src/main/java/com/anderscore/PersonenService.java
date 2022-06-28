package com.anderscore;

import java.util.List;
import java.util.stream.Collectors;

public class PersonenService {

    public final DatenbankService datenbankService;

    public PersonenService(DatenbankService datenbankService) {
        this.datenbankService = datenbankService;
    }

    public List<String> allNames() {
        List<Object> personen =  datenbankService.findAll("personen");
        // Personenobjekte nach Namen konvertieren und zurückgeben
        return personen.stream().map(name -> (String) name).collect(Collectors.toList());
    }
}
