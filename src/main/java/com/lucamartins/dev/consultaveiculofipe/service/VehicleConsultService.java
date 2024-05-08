package com.lucamartins.dev.consultaveiculofipe.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucamartins.dev.consultaveiculofipe.model.*;

import java.util.List;

public class VehicleConsultService {
    final HttpService httpService = new HttpService();
    final String apiCommonPrefix = "https://parallelum.com.br/fipe/api/v1/";
    final ObjectMapper jacksonObjectMapper = new ObjectMapper();

    private String mapVehicleTypeToEndpointResource(VehicleTypeEnum vehicleType) {
        String vehicleTypeResource = "";

        switch (vehicleType) {
            case CAR -> vehicleTypeResource = "carros";
            case MOTORCYCLE -> vehicleTypeResource = "motos";
            case TRUCK -> vehicleTypeResource = "caminhoes";

        }

        return vehicleTypeResource;
    }

    public List<VehicleBrand> getVehicleBrands(VehicleTypeEnum vehicleType) {
        String fetchUrl = apiCommonPrefix + this.mapVehicleTypeToEndpointResource(vehicleType) + "/marcas";

        var httpResponse = httpService.sendRequest(fetchUrl);

        try {
            return jacksonObjectMapper.readValue(
                    httpResponse.body(),
                    new TypeReference<List<VehicleBrand>>() {
                    }
            );
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public List<BrandModel> getBrandModels(VehicleTypeEnum vehicleType, int brandCode) {
        String fetchUrl = apiCommonPrefix
                + this.mapVehicleTypeToEndpointResource(vehicleType)
                + "/marcas/"
                + brandCode
                + "/modelos";

        var httpResponse = httpService.sendRequest(fetchUrl);

        try {
            BrandModelsDto brandModelsResponse = jacksonObjectMapper.readValue(httpResponse.body(), BrandModelsDto.class);

            return brandModelsResponse.modelos();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public List<BrandModelYear> getBrandModelYears(VehicleTypeEnum vehicleType, int brandCode, int brandModelCode) {
        String fetchUrl = apiCommonPrefix
                + this.mapVehicleTypeToEndpointResource(vehicleType)
                + "/marcas/"
                + brandCode
                + "/modelos/"
                + brandModelCode
                + "/anos";

        var httpResponse = httpService.sendRequest(fetchUrl);

        try {
            return jacksonObjectMapper.readValue(
                    httpResponse.body(),
                    new TypeReference<List<BrandModelYear>>() {
                    }
            );
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public ModelPrice getModelPrice(VehicleTypeEnum vehicleType, int brandCode, int brandModelCode,
                                    String yearCode) {
        String fetchUrl = apiCommonPrefix
                + this.mapVehicleTypeToEndpointResource(vehicleType)
                + "/marcas/"
                + brandCode
                + "/modelos/"
                + brandModelCode
                + "/anos/"
                + yearCode;

        var httpResponse = httpService.sendRequest(fetchUrl);

        try {
            return jacksonObjectMapper.readValue(
                    httpResponse.body(),
                    ModelPrice.class
            );
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
