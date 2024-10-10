package com.company.ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class VehicleCatalogue {
    static class Vehicle {
        String type;
        String model;
        String color;
        int horsePower;

        public Vehicle(String type, String model, String color, int horsePower) {
            this.type = type;
            this.model = model;
            this.color = color;
            this.horsePower = horsePower;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public void setHorsePower(int horsePower) {
            this.horsePower = horsePower;
        }

        public String getType() {
            return type;
        }

        public String getModel() {
            return model;
        }

        public String getColor() {
            return color;
        }

        public int getHorsePower() {
            return horsePower;
        }

        public String toString() {
            return String.format("Type: %s%n" + "Model: %s%n" + "Color: %s%n" + "Horsepower: %d",
                    getType().toUpperCase().charAt(0) + getType().substring(1),
                    this.model, this.color, this.horsePower);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Vehicle> vehicles = new ArrayList<>();

        String line = scanner.nextLine();
        while (!line.equals("End")) {
            String[] data = line.split("\\s+");
            Vehicle vehicle = new Vehicle(data[0], data[1], data[2], Integer.parseInt(data[3]));
            vehicles.add(vehicle);

            line = scanner.nextLine();
        }

        line = scanner.nextLine();
        while (!line.equals("Close the Catalogue")) {
            String model = line;

            vehicles.stream().filter(vehicle -> vehicle.getModel().equals(model))
                    .forEach(vehicle -> System.out.println(vehicle));

            line = scanner.nextLine();
        }
        List<Vehicle> cars = vehicles.stream().filter(vehicle -> vehicle.getType().equals("car")).collect(Collectors.toList());
        List<Vehicle> trucks = vehicles.stream().filter(vehicle -> vehicle.getType().equals("truck")).collect(Collectors.toList());

        double carsAvgHp = averageHp(cars);
        double trucksAvgHp = averageHp(trucks);

        System.out.printf("Cars have average horsepower of: %.2f", carsAvgHp);
        System.out.printf("Trucks have average horsepower of: %.2f", trucksAvgHp);
    }

    static double averageHp(List<Vehicle> vehicles) {
        if (vehicles.size() == 0) return 0;
        return vehicles.stream().mapToDouble(Vehicle::getHorsePower).sum() / vehicles.size();

    }
}
