package com.lucamartins.dev.consultaveiculofipe.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BrandModelYear {
    private final String code;
    private final String name;

    public BrandModelYear(@JsonProperty("codigo") String code, @JsonProperty("nome") String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return  code + " - " + name;
    }
}
