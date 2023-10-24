package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {


        while(true){

            //Read all combinations from csv-Input file
            CSVHandler csvHandler = new CSVHandler();
            csvHandler.readFromCSV();

            //Wait for user-input of price-quantity-pair
            System.out.print("Please enter price and quanity with the format: \"<price>, <quantity>\": ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            // Reading price-quantity-pair
            String[] input = null;
            try {
                //split input into price and quantity
                input = reader.readLine().split(",");
                System.out.println(Combination.findByPair(Integer.parseInt(input[0]), Integer.parseInt(input[1])));

            } catch (IOException e) {
                System.out.println("Input not valid. Please check your Input\n");
            } catch (NumberFormatException nfe){
                System.out.println("Input not valid. Please check your Input\n");
            }
            csvHandler.writeToCSV();

        }


    }
}


