/*
 * Diet Manager v1.0
 * Team E: Ryan Wren, Vignesh Kumar, Vincent Cheng, Efmajackson Rosario
 * SWEN.383.01
 *
 * Food Hub Class
 * The foodhub class will work with the csv files to retrive and delete data at the prompt of DietManager
 *
 */
package model;
import java.util.*;

public class FoodHub {
    ArrayList<FoodItem> foodList;
    ArrayList<Recipe> recipeList;
   
    public FoodHub(){
    ArrayList<FoodItem> foodList = new ArrayList<FoodItem>();
    ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
    }

    /**
     * Add a new food to the collection
     */
    public void addFood(Food food){
        
    }

    /**
     * Remove a food from the collection
     */
    public void removeFood(Food food){
        
    }
   
   public ArrayList<FoodItem> returnFoodList()
   {
      return foodList;
   }

    public String showFoodList(){
        String allFoods = "";
        for(FoodItem f:foodList){
            allFoods += f.printSummary();
            allFoods += "\n\n";
        }
        return allFoods;
    }

    public String getFood(String foodName){
        for(FoodItem f:foodList){
            if(foodName == f.getName()){
                return f.printSummary();
            }
        }
        return "There is no food item with that exact name. Try again or add the new food to our list.";
    }

    public ArrayList<double[]> getFoodData(String foodName){
        ArrayList<double[]> foodData = new ArrayList<double[]>();
        for (FoodItem food:foodList) {
                foodData.add(food.getFoodData());
            }
        return foodData;
        }
    

    /*public double[] getItemInfo(String foodName) {

    }*/

    public void parseCSV(){
        String bFile = "model/basicfoods.csv";
        CSVParser parser = new CSVParser();
        ArrayList<ArrayList<String>> tempList = parser.parseCSV(bFile);
        for(ArrayList<String> food:tempList){
            FoodItem f = new FoodItem(food);
            //System.out.println(f.ToString());
            foodList.add(f);
        }
    }



    //todo
    public void writeOutToCSV(){
        String foodFile = "basicfoods.csv";
        String recipeFile = "recipefoods.csv";
        
        ArrayList<String> tempArray = new ArrayList<String>();
        for(int i = 0; i < foodList.size(); i++){
            tempArray.add(foodList.get(i).writeOutCSVString());
        }
        CSVParser parser = new CSVParser();
        parser.writeCSV(tempArray, foodFile);
        
        tempArray.clear();
        for(int i = 0; i < recipeList.size(); i++){
            tempArray.add(recipeList.get(i).writeOutCSVString());
        }
        parser.writeCSV(tempArray, recipeFile);
    }
} // FoodHub