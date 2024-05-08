package com.lucamartins.dev.consultaveiculofipe.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BrandModel {
    private final int code;
    private final String name;

    public BrandModel(@JsonProperty("codigo") int code, @JsonProperty("nome") String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return code + " - " + name;
    }
}
