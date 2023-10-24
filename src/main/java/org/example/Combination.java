package org.example;

import java.util.ArrayList;
import java.util.List;

public class Combination {

    //ArrayList to store the combinations
    private static List<Combination> combinationList = new ArrayList<Combination>();

    //ArrayList to store the prices for faster access
    private static List<Integer> pricelist = new ArrayList<Integer>();

    //variables of a combination
    private int price, quantity, frequency;

    public Combination(int price, int quantity, int frequency) {
        this.price = price;
        this.quantity = quantity;
        this.frequency = frequency;
    }


    public static List<Combination> getCombinationList() {
        return combinationList;
    }

    public static void setCombinationList(List<Combination> combinationList) {
        Combination.combinationList = combinationList;
    }

    public static void addCombinationToList(Combination combination) {
        Combination.combinationList.add(combination);
    }

    public static void clearCombinationList(){
        Combination.combinationList.clear();
    }



    public static void addPriceToList(int price) {
        Combination.pricelist.add(price);
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "Combination{" +
                "price=" + price +
                ", quantity=" + quantity +
                ", frequency=" + frequency +
                '}';
    }

    public static String findByPair(int price, int quantity) {

        int totalOccurencey = 0;
        int highestOccurence = 0;
        double relativeOccurence = 0.0;
        double treshold = 80.0;
        //Combination that match to the input from the user
        Combination combinationToGivenPair = null;
        //Cobination that has the highest Occurence(Frequency)
        Combination combiantionWithHighestOccurence = null;

        //Check if price is contained data
        if (!pricelist.contains(price)) {
            return "Cannot find a representation for price " + price + ". The quantity hasn't been modified.";
        }
        //Iterate through ArrayList
        for (Combination c : combinationList) {
            //Use the combination only if the price is the same
            if (c.getPrice() == price) {
                //Check if there is a matching combination to the input
                if(c.getQuantity() == quantity){
                    combinationToGivenPair = c;
                }
                totalOccurencey = totalOccurencey + c.frequency;
                //set the combination with the highest occurrence
                if (c.frequency >= highestOccurence) {
                    highestOccurence = c.frequency;
                    combiantionWithHighestOccurence = c;
                }
                //calculate the relative occurrence of the combination with the highest occurrence in the given price range
                relativeOccurence = (((double) highestOccurence / (double) totalOccurencey) * 100);
            }
        }
        //Check if there is a Combination that match the input of the user
        if (combinationToGivenPair == null) {
            return "Combination not found";
        }
        //check if the combination with the highest occurrence is also matching with the input combination
        else if (combinationList.indexOf(combiantionWithHighestOccurence) == combinationList.indexOf(combinationToGivenPair)) {
            return "The provided quantity fits the expectation with a safety of " + relativeOccurence + " percent";
        }
        //check if the occurrence is below the threshold
        else if (relativeOccurence <= treshold) {
            return "The provided quantity hasn't been modified. The relative frequency is too low by " + (treshold - relativeOccurence) + " percent";
        }
        //check if the occurrence is above the threshold
        else if (relativeOccurence > treshold) {
            int newQuantity = combiantionWithHighestOccurence.getQuantity();
            int oldQuantity = combinationToGivenPair.getQuantity();
            int index = combinationList.indexOf(combinationToGivenPair);
            combinationToGivenPair.setQuantity(newQuantity);
            combinationList.set(index, combinationToGivenPair);
            return "The provided quantity has been changed from " + oldQuantity + " to " + newQuantity + " with a safety of " + relativeOccurence + " percent";
        }
        //not specified case
        else return "Error";
    }
}
   