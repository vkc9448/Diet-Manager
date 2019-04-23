/*
* Diet Manager v1.0
* Team E: Ryan Wren, Vignesh Kumar, Vincent Cheng, Efmajackson Rosario
* SWEN.383.01
*/

/**
*Recipe class will retrive a recipe for a specific food item.
*/
package model;
import java.util.*;

public class Recipe implements Food{
   private String recipeName = "";
   private ArrayList<String> ingredients = new ArrayList<String>();
   private ArrayList<Double> servings = new ArrayList<Double>();

   public Recipe(ArrayList<String> recipeList){
      recipeName = recipeList.get(1);
      //ignore "r" at the start of the array and set the recipe name then start at position 2 for
      for (int i =2; i<recipeList.size();i+=2){
         ingredients.add(recipeList.get(i));
         servings.add(Double.parseDouble(recipeList.get(i+1)));
      }
   }
   
   public void addRecipeItem(String _foodName, double serving) {
      ingredients.add(_foodName);
      servings.add(serving);
   }

   public boolean deleteIngredient(String name){
      for (int i = 0; i<ingredients.size();i++){
         if(ingredients.get(i) == name){
            System.out.println("Ingredient: " + ingredients.get(i) + "(" + ingredients.get(i) + ") was deleted.");
            ingredients.remove(i);
            servings.remove(i);
            return true;
         }
      }
      System.out.println("Ingredient " + name + " not found, unable to remove.");
      return false;
   }

   public boolean changeIngredServing(String name, double newServing){
      for (int i = 0; i<ingredients.size();i++){
         if(ingredients.get(i) == name){
            System.out.println("Ingredient: " + ingredients.get(i) + "(" + ingredients.get(i) + ") was changed to " + ingredients.get(i) + "(" + newServing + ").");
            servings.set(i, newServing);
            return true;
         }
      }
      System.out.println("Ingredient " + name + " not found, unable to update serving.");
      return false;
   }
   
   public String getName(){
      return recipeName;
   }

   public ArrayList<Double> getServings() {
      return servings;
   }

   public ArrayList<String> getIngredients() {
      return ingredients;
   }

   public String printSummary(){
      String summary = recipeName + " Recipe\n";
      for(int i = 0; i<ingredients.size();i++){
         summary += servings.get(i) + " of " + ingredients.get(i);
      }
      return summary;
   }
   
   public String writeOutCSVString(){
      String csvString = "r," + recipeName;
      for(int i = 0 ; i<ingredients.size(); i++){
         csvString.concat(","+ingredients.get(i) + "," + servings.get(i));
      }
      return csvString;
   }


} // Recipe