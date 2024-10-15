package com.company.AssociativeArrays;

import java.util.*;

public class Orders {
    static class Product {
        String name;
        double price;
        double totalPrice;
        double quantity;

        public Product(String name, double price, double quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public void setQuantity(double quantity) {
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public double getQuantity() {
            return quantity;
        }

        public double getTotalPrice() {
            return this.price * this.quantity;
        }

        @Override
        public String toString() {
            return String.format("%s -> %.2f%n",this.name, this.totalPrice);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Product> products = new LinkedHashMap<>();
        String line = scanner.nextLine();

        while (!line.equals("buy")) {
            String[] data = line.split("\\s+");
            String productName = data[0];
            double productPrice = Double.parseDouble(data[1]);
            double productQuantity = Integer.parseInt(data[2]);
            if (products.containsKey(productName)) {
                products.get(productName).setPrice(productPrice);
                products.get(productName).setQuantity(products.get(productName).getQuantity() + productQuantity);
            }else {
                products.put(productName, new Product(productName, productPrice, productQuantity));
            }
            line = scanner.nextLine();
        }
        //print
        products.forEach((k, v) -> System.out.printf("%s -> %.2f%n", k, v.getTotalPrice()));

    }
}
