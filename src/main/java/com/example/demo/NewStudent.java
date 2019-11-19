package com.example.demo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NewStudent {

    @JsonProperty ("name") String name;
    @JsonProperty("numer") String numer;
    @JsonProperty ("grupa") String grupa;

    @JsonCreator
    public NewStudent(String name, String numer, String grupa) {
        this.name = name;
        this.numer = numer;
        this.grupa = grupa;
    }
}
