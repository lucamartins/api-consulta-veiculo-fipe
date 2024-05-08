package com.lucamartins.dev.consultaveiculofipe.principal;

import com.lucamartins.dev.consultaveiculofipe.model.VehicleTypeEnum;
import com.lucamartins.dev.consultaveiculofipe.service.VehicleConsultService;

import java.util.Scanner;

public class Principal {
    final Scanner scanner = new Scanner(System.in);
    final VehicleConsultService vehicleConsultService = new VehicleConsultService();

    private VehicleTypeEnum mapVehicleTypeInputToEnum(int vehicleTypeInput) throws Exception {
        VehicleTypeEnum vehicleType;

        if (vehicleTypeInput == 1) {
            vehicleType = VehicleTypeEnum.CAR;
        } else if (vehicleTypeInput == 2) {
            vehicleType = VehicleTypeEnum.MOTORCYCLE;
        } else if (vehicleTypeInput == 3) {
            vehicleType = VehicleTypeEnum.TRUCK;
        } else {
            throw new Exception();
        }

        return vehicleType;
    }

    public void handleSearchVehicleOperation() throws Exception {
        System.out.println();
        System.out.println("# Busca de veículo");
        System.out.println("1 - Carro");
        System.out.println("2 - Moto");
        System.out.println("3 - Caminhão");
        System.out.print("Digite que tipo de veículo você deseja buscar (número): ");

        var vehicleTypeInput = scanner.nextInt();
        scanner.nextLine();

        VehicleTypeEnum vehicleType = mapVehicleTypeInputToEnum(vehicleTypeInput);

        var vehicleBrands = vehicleConsultService.getVehicleBrands(vehicleType);
        System.out.println();
        System.out.println("# Marcas de veículos disponíveis:");
        vehicleBrands.forEach(System.out::println);

        System.out.print("Digite o cóigo da marca buscada: ");
        var brandCode = scanner.nextInt();
        scanner.nextLine();

        var brandModels = vehicleConsultService.getBrandModels(vehicleType, brandCode);
        System.out.println();
        System.out.println("# Modelos da marca disponíveis para busca:");
        brandModels.forEach(System.out::println);

        System.out.print("Digite o código do modelo buscado: ");
        var modelCode = scanner.nextInt();
        scanner.nextLine();

        var brandModelYears = vehicleConsultService.getBrandModelYears(vehicleType, brandCode, modelCode);
        System.out.println();
        System.out.println("# Anos disponíveis para o modelo:");
        brandModelYears.forEach(brandModelYear -> {
            var modelPrice = vehicleConsultService.getModelPrice(vehicleType, brandCode, modelCode,
                    brandModelYear.getCode());

            System.out.println(modelPrice);
        });
    }

    public void startCLIMenu() {
        System.out.println();
        System.out.println("###");
        System.out.println("### Tabela FIPE - Consultar veículo");
        System.out.println("###");

        while (true) {
            try {
                System.out.println();
                System.out.println("# Menu");
                System.out.println("1 - Consultar veículo");
                System.out.println("0 - Sair");
                System.out.print("Digite a operação desejada (número): ");

                var operation = scanner.nextInt();
                scanner.nextLine();

                if (operation == 1) {
                    handleSearchVehicleOperation();
                } else {
                    break;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
