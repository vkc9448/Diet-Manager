/*
 * Diet Manager v1.0
 * Team E: Ryan Wren, Vignesh Kumar, Vincent Cheng, Efmajackson Rosario
 * SWEN.383.01
 */
package model; 

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

class CSVParser{
   /**
    * parseCSV returns an arraylist of arraylists that cointain the days/fooditems/recipe fromt he csv (each line from csv is an array)
    */


   public static ArrayList<ArrayList<String>> parseCSV(String fileName){
      FileReader file;
      BufferedReader reader;
      ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
      String csvLine;
      String[] splitLine;
      ArrayList<String> tempList = new ArrayList<String>();

      try{
         file = new FileReader(fileName);
         reader = new BufferedReader(file);

         while ((csvLine = reader.readLine()) != null){
            splitLine = csvLine.split("\\,"); //split into arraylist instead of an array?
            //System.out.println(splitLine.length + "  -  String: " + csvLine + "\n");

            for(String item:splitLine){
               tempList.add(item);
            }

            //System.out.println(tempList);
            list.add((ArrayList<String>)tempList.clone()); //if you just add tempList to list its a reference (shallow copy) and the next line (clear) will delete templist and remove the item from the list.
            tempList.clear();
            splitLine = null;
         }
      }
      catch(FileNotFoundException fnfe){
         System.out.println(fileName);
         fnfe.printStackTrace();
      }
      catch(NullPointerException npe){
         npe.printStackTrace();
      }
      catch(Exception e){
         e.printStackTrace();
      }
      //System.out.println(list);
      return list;
   } //end of parseCSV()

   public void writeCSV(ArrayList<String> tempList, String fileName){
      FileWriter file;
      BufferedWriter writer;
      try{
         file = new FileWriter(fileName);
         writer = new BufferedWriter(file);

         for(String line:tempList){
            writer.write(line);
            System.out.println(line);
         }
         writer.flush();

      } catch (IOException ioe){
         System.out.println("Error " + ioe.getMessage() + " in writing out to CSV: " + fileName);
         ioe.printStackTrace();
      } catch (Exception e){
         System.out.println("Error " + e.getMessage() + "in writing out to CSV: " + fileName);
         e.printStackTrace();
      }
   }//end of writeCSV()

}//end of CSVParser class