package com.lucamartins.dev.consultaveiculofipe.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ModelPrice {
    private String price;
    private int year;

    public ModelPrice(@JsonProperty("Valor") String price, @JsonProperty("AnoModelo") int year) {
        this.price = price;
        this.year = year;
    }

    @Override
    public String toString() {
        return "ModelPrice{" +
                "price='" + price + '\'' +
                ", year=" + year +
                '}';
    }
}
