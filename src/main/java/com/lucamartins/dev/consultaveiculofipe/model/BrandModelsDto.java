package com.lucamartins.dev.consultaveiculofipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BrandModelsDto(@JsonAlias("modelos") List<BrandModel> modelos) {
}
