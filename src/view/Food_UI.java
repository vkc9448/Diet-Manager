/*
* Diet Manager v1.0
* Team E: Ryan Wren, Vignesh Kumar, Vincent Cheng, Efmajackson Rosario
* SWEN.383.01
/*
* Basic Food UI contains the necessary UI components for user to  
* add or modify an existing basic food and recipt to the collection of basic foods and recipe in the Diet Manager.
*/
package View;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.security.spec.ECField;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.awt.BorderLayout;

public class Food_UI extends JFrame {

        // JLISTS
        // ADD FOOD LISTS
        private DefaultListModel modelF = new DefaultListModel();
        private JList jListFc = new JList( modelF );
        private DefaultListModel modelFcF = new DefaultListModel();
        private JList jListFcFood = new JList( modelFcF );
        
        private DefaultListModel modelEc = new DefaultListModel();
        private JList jListEcAdd = new JList( modelEc );
        
        // ADD RECIPE LISTS
        private DefaultListModel modelFcR = new DefaultListModel();
        private JList jListFcRecipe = new JList( modelFcR );
        private DefaultListModel modelER = new DefaultListModel();
        private JList jListSubRecipe = new JList (modelER);
        
        // TEXT FIELDS
        // ADD FOOD TEXTFIELDS
        private JTextField jtfAfFood = new JTextField(5);
        private JTextField jtfAfCal = new JTextField(5);
        private JTextField jtfAfCarb = new JTextField(5);
        private JTextField jtfAfProtein = new JTextField(5);
        private JTextField jtfAfFat = new JTextField(5);
        private JTextField updateCal = new JTextField(5);
        private JTextField updatePro = new JTextField(5);
        private JTextField updateCarb = new JTextField(5);
        private JTextField updateFat = new JTextField(5);
        
        // ADD RECIPE TEXTFIELDS
        private JTextField jtfRecipeName = new JTextField(5);
        private JTextField jtfSubRecipeFoodName = new JTextField(5);
        private JTextField jtfSubRecipeFoodCount = new JTextField(5);
        private JTextField jtfSubRecipeFoodName1 = new JTextField(5);
        private JTextField jtfSubRecipeFoodCount1 = new JTextField(5);
        
        // JLABELS
        // ADD FOOD LABELS
        private JLabel jlCals = new JLabel("##.##");
        private JLabel jlFat = new JLabel("##.##");
        private JLabel jlCarbs = new JLabel("##.##");
        private JLabel jlPro = new JLabel("##.##");
        
        // ADD RECIPE LABELS
        private JLabel jlRecipeDetail = new JLabel("");


        public Food_UI() {
        /// FRAME
        setupWindow();
        
        /// MAIN PANELS AND TABS
        JTabbedPane tabbedPane = new JTabbedPane();
        getContentPane().add(tabbedPane);
        JPanel jpHome = new JPanel();
        jpHome.setBackground(Color.YELLOW);
        tabbedPane.addTab("HOME", jpHome);
        JPanel jpAddFood = new JPanel();
        jpAddFood.setBackground(new Color(152,251,152));
        tabbedPane.addTab("Add Basic Food", jpAddFood);
        JPanel jpAddRecipe = new JPanel();
        tabbedPane.addTab("Add Recipe", jpAddRecipe);
        jpAddRecipe.setBackground(new Color(152,251,152));
        JPanel jpAddExercise = new JPanel();
        tabbedPane.addTab("Add Exercise", jpAddExercise);
        jpAddExercise.setBackground(new Color(0,191,255));;
        JPanel jpViewLog = new JPanel();
        tabbedPane.addTab("View Logs", jpViewLog);
        jpViewLog.setBackground(new Color(240,128,128));
         JPanel jpLog = new JPanel();
        tabbedPane.addTab("ADD TO LOG", jpLog);
        jpLog.setBackground(Color.YELLOW);
        tabbedPane.setBackgroundAt(0, Color.YELLOW);
        tabbedPane.setBackgroundAt(1, new Color(152,251,152));
        tabbedPane.setBackgroundAt(2, new Color(152,251,152));
        tabbedPane.setBackgroundAt(3, new Color(0,191,255));
        tabbedPane.setBackgroundAt(4, new Color(240,128,128));
        tabbedPane.setBackgroundAt(5, Color.YELLOW);
        tabbedPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        tabbedPane.setTabPlacement(JTabbedPane.BOTTOM);
        
        /// ADD BASIC FOOD ///
        
        JPanel addFoodContainer = new JPanel();
        addFoodContainer.setBackground(new Color(152,251,152));
        JPanel addFoodPanelTitle = new JPanel();
        
        // TITLE
        JLabel jlAddFood = new JLabel("Add basic food to basic foods collection");
        addFoodPanelTitle.add(jlAddFood);
        addFoodContainer.add(addFoodPanelTitle);
        
        // MAIN INPUT PANEL
        JPanel addFoodPanelInput = new JPanel();
        JLabel jlAfFood = new JLabel("Name:");
        addFoodPanelInput.add(jlAfFood);
        addFoodPanelInput.add(jtfAfFood);
        JLabel jlAfCal = new JLabel("Cals:");
        addFoodPanelInput.add(jlAfCal);
        addFoodPanelInput.add(jtfAfCal);
        JLabel jlAfCarb = new JLabel("Carbs:");
        addFoodPanelInput.add(jlAfCarb);
        addFoodPanelInput.add(jtfAfCarb);
        JLabel jlAfFat = new JLabel("Fat:");
        addFoodPanelInput.add(jlAfFat);
        addFoodPanelInput.add(jtfAfFat);
        JLabel jlAfProtein = new JLabel("Pro:");
        addFoodPanelInput.add(jlAfProtein);
        addFoodPanelInput.add(jtfAfProtein);
        
        /// SCROLL PANES
        JScrollPane fcScroll = new JScrollPane(jListFc);
        JScrollPane fcScrollAdd = new JScrollPane(jListFcFood);
        JScrollPane fcScrollAddRecipe = new JScrollPane(jListFcRecipe);
        JScrollPane rcScrollEditRecipe = new JScrollPane(jListSubRecipe);
        
        
        /// BUTTONS
        JButton jbAddFood = new JButton("Add");
        JButton jbviewNutri = new JButton("View Nutritional Values");
        JButton jbUpdateFood = new JButton("Update Basic Food");
        addFoodPanelInput.add(jbAddFood);
        addFoodContainer.add(addFoodPanelInput);

        // FOOD COLLECTION LIST
        JPanel viewFoodCollection = new JPanel();
        JLabel jlFoodCollection = new JLabel("<html><div style='text-align: center;'>Basic <br>Food <br>Collection&nbsp;</div></html>");
        viewFoodCollection.add(jlFoodCollection);
        viewFoodCollection.add(fcScrollAdd);
        addFoodContainer.add(viewFoodCollection);
        
        /// NUTRITIONAL PANEL
        JPanel editsFoodCollection = new JPanel();
        
        /// NUTRITIONAL VALUES
        editsFoodCollection.add(jbviewNutri);
        JPanel nutFoodCals = new JPanel();
        JLabel jlnutFoodCals = new JLabel("Cals:");
        nutFoodCals.add(jlnutFoodCals);
        nutFoodCals.add(jlCals);
        editsFoodCollection.add(nutFoodCals);

        JPanel nutFoodCarbs = new JPanel();
        JLabel jlnutFoodCarbs = new JLabel("Carbs:");
        nutFoodCarbs.add(jlnutFoodCarbs);
        nutFoodCarbs.add(jlCarbs);
        editsFoodCollection.add(nutFoodCarbs);

        JPanel nutFoodFat = new JPanel();
        JLabel jlnutFoodFat = new JLabel("Fat:");
        nutFoodFat.add(jlnutFoodFat);
        nutFoodFat.add(jlFat);
        editsFoodCollection.add(nutFoodFat);

        JPanel nutFoodPro = new JPanel();
        JLabel jlnutFoodPro = new JLabel("Pro:");
        nutFoodPro.add(jlnutFoodPro);
        nutFoodPro.add(jlPro);
        editsFoodCollection.add(nutFoodPro);
        
        /// MODIFY BASIC FOOD
        JPanel editBasicFood = new JPanel();
        JLabel jlCal = new JLabel("Cals:");
        editBasicFood.add(jlCal);
        editBasicFood.add(updateCal);
        JLabel jlCarbs = new JLabel("Carbs:");
        editBasicFood.add(jlCarbs);
        editBasicFood.add(updateCarb);
        JLabel jlFat = new JLabel("Fat:");
        editBasicFood.add(jlFat);
        editBasicFood.add(updateFat);
        JLabel jlPro = new JLabel("Pro:");
        editBasicFood.add(jlPro);
        editBasicFood.add(updatePro);
        editBasicFood.add(jbUpdateFood);

        // ADDING ALL TO FOOD CONTAINER
        addFoodContainer.add(editsFoodCollection);
        addFoodContainer.add(editBasicFood);
        addFoodContainer.setLayout(new BoxLayout(addFoodContainer, BoxLayout.PAGE_AXIS));
        jpAddFood.add(addFoodContainer);
        /// ADD BASIC FOOD END ///
        
        /// ADD RECIPE
        JPanel addRecipeContainer = new JPanel();
        
        JPanel addRecipePanelTitle = new JPanel();
        JLabel jlAddRecipeTitle = new JLabel("Add recipe to recipes collection");
        addRecipePanelTitle.add(jlAddRecipeTitle);

        JPanel addRecipePanel = new JPanel();
        JLabel jlRecipe = new JLabel("Name: ");
        addRecipePanel.add(jlRecipe);
        addRecipePanel.add(jtfRecipeName);

        JLabel jlSubRecipeFoodName = new JLabel("Sub-recipe name: ");
        addRecipePanel.add(jlSubRecipeFoodName);
        addRecipePanel.add(jtfSubRecipeFoodName);
        JLabel jlSubRecipeFoodCount = new JLabel("Number of servings: ");
        addRecipePanel.add(jlSubRecipeFoodCount);
        addRecipePanel.add(jtfSubRecipeFoodCount);

        JPanel addRecipeButtonPanel = new JPanel();
        JButton jbAddRecipe = new JButton("Add");
        addRecipePanel.add(jbAddRecipe);

        JPanel viewFoodCollectionRecipe = new JPanel();

        JLabel jlRecipeCollection = new JLabel("<html><div style='text-align: center;'>Recipe<br>Collection&nbsp;&nbsp;&nbsp;</div></html>");
        viewFoodCollectionRecipe.add(jlRecipeCollection);
        viewFoodCollectionRecipe.add(fcScrollAddRecipe);

        // ADD ALL TO RECIPE CONTAINTER
        addRecipeContainer.add(addRecipePanelTitle);
        addRecipeContainer.add(addRecipePanel);
        addRecipeContainer.add(viewFoodCollectionRecipe);

        JPanel jpEditRecipe = new JPanel();
        JLabel jlRecipeIngCollection = new JLabel("<html><div style='text-align: center;'>Recipe<br>Ingredients&nbsp;<br>Collection</div></html>");
        JPanel jpEditRecipe2 = new JPanel();
        JButton jbEditRecipeView  = new JButton("View Recipe's Ingredients");
        JButton jbEditRecipeRemove  = new JButton("Remove Recipe Ingredient");
        //jpeditRecipe.add(jbEditRecipe);
        jpEditRecipe.add(jlRecipeIngCollection);
        jpEditRecipe.add(rcScrollEditRecipe);
        jpEditRecipe2.add(jbEditRecipeView);
        jpEditRecipe2.add(jbEditRecipeRemove);

        
        //jpeditRecipe.add(jbEditRecipeRemove);

        JPanel jpEditRecipe3 = new JPanel();
        JPanel addSubRecipePanel1 = new JPanel();
        JLabel jlSubRecipeFoodName1 = new JLabel("Sub-recipe name: ");
        addSubRecipePanel1.add(jlSubRecipeFoodName1);
        addSubRecipePanel1.add(jtfSubRecipeFoodName1);
        JLabel jlSubRecipeFoodCount1 = new JLabel("Number of servings: ");
        addSubRecipePanel1.add(jlSubRecipeFoodCount1);
        addSubRecipePanel1.add(jtfSubRecipeFoodCount1);
        JButton jbAddSubRecipe1 = new JButton("Update Recipe");
        addSubRecipePanel1.add(jbAddSubRecipe1);

        JPanel addRecipeDetail1 = new JPanel();
        JLabel jlRecipeDetail1 = new JLabel("");
        
        // ADD ALL TO RECIPE CONTAINER
        addRecipeContainer.add(jpEditRecipe);
        addRecipeContainer.add(jpEditRecipe2);
        addRecipeContainer.add(addSubRecipePanel1);
        addRecipeContainer.add(addRecipeDetail1);
        addRecipeContainer.setLayout(new BoxLayout(addRecipeContainer, BoxLayout.PAGE_AXIS));
        jpAddRecipe.add(addRecipeContainer);
        /// ADD RECIPE END ///
        
        /// STYLES
        jlAddFood.setFont(new Font("Raleway", Font.BOLD, 15));
        jlAddRecipeTitle.setFont(new Font("Raleway", Font.BOLD, 15));
        jlRecipeIngCollection.setFont(new Font("Raleway", Font.BOLD, 15));
        jlFoodCollection.setFont(new Font("Raleway", Font.BOLD, 15));
        jlRecipeCollection.setFont(new Font("Raleway", Font.BOLD, 15));
        jListFc.setFixedCellWidth(400);
        jListFcFood.setFixedCellWidth(400);
        jListFcRecipe.setFixedCellWidth(400);
        jListFcRecipe.setFixedCellHeight(10);
        jListSubRecipe.setFixedCellWidth(400);
        jListSubRecipe.setFixedCellHeight(5);
        this.setVisible(true);
        
        }
        
        private void setupWindow() {
        this.setTitle("Diet Manager");
        this.setSize(550,700);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      
        }
        
        public static void main(String[] args) throws ParseException {

        Food_UI gui = new Food_UI();
        
        }
}