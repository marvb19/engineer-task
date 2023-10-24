package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CSVHandler {

    //character to split the csv-columns
    private static String separation = ";";

    private static String csvString;

    private static String pathToCsvFile = "src/main/resources/prices-quantity.csv";

    //read a csv-file and store in an ArrayList
    static void readFromCSV(){
        try{
            Combination.clearCombinationList();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToCsvFile));
            //jump over column labeling
            if((csvString = bufferedReader.readLine()) != null){

            };
            while ((csvString = bufferedReader.readLine()) != null){
                String[] combination = csvString.split(separation);
                //add a combination to an ArrayList for each line in the csv
                Combination.addCombinationToList(
                        new Combination(
                                Integer.parseInt(combination[0]),
                                Integer.parseInt(combination[1]),
                                Integer.parseInt(combination[2])));
                //add a price to an ArrayList for each line in the csv for faster price-occurrence search
                Combination.addPriceToList(Integer.parseInt(combination[0]));
            }
            bufferedReader.close();
            //System.out.println("Reading the csv-file finished successfully.\n");
        }catch (IOException e){
            System.out.println("Please make sure the file is named correctly or the right path is specified.");
        }
    }

    //store the ArrayList with the combinations back in the csv-file
    static void writeToCSV(){
        try (FileWriter writer = new FileWriter(pathToCsvFile, false)) {
            //add column-labels to csv-file
            writer.write("price;quantity;frequency\n");
            for (Combination c : Combination.getCombinationList()) {
                writer.write(c.getPrice()  + ";"  + c.getQuantity()  +  ";" + c.getFrequency()  + "\n");
            }
            //System.out.println("Writing the csv-file finished successfully.");
        } catch (IOException e) {
            System.out.println("Please make sure the file is named correctly or the right path is specified.");
        }
    }
}
