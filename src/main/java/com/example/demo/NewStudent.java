package com.example.demo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NewStudent {
    public final String name;
    public final String number;
    public final String group;

    @JsonCreator
    public NewStudent(@JsonProperty("name")String name, @JsonProperty("number") String number, @JsonProperty("group") String group) {
        this.name = name;
        this.number = number;
        this.group = group;
    }
}
