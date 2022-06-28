package com.anderscore;

import com.anderscore.annotations.Autowired;
import com.anderscore.annotations.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonenService {

    @Autowired
    private DatenbankService datenbankService;

    public List<String> allNames() {
        List<Object> personen =  datenbankService.findAll("personen");
        // Personenobjekte nach Namen konvertieren und zurückgeben
        return personen.stream().map(name -> (String) name).collect(Collectors.toList());
    }
}
