/*
* Diet Manager v1.0
* Team E: Ryan Wren, Vignesh Kumar, Vincent Cheng, Efmajackson Rosario
* SWEN.383.01
/*
* Exercise UI contains the necessary UI components for user to  
* add excersises necessary to add to a log in the Diet Manager.
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

public class Exercise_UI extends JFrame { 

        // TEXT FIELDS
        private JTextField jtfAeName = new JTextField(10);
        private JTextField jtfAeCal = new JTextField(5);
        private JTextField updateCalExer = new JTextField(5);
        
        // JLABELS
        private JLabel jlNumExerCal = new JLabel("##.##");
        
        // JLISTS
        private DefaultListModel modelE = new DefaultListModel();
        private JList jListEc = new JList( modelE );
        private DefaultListModel modelEc = new DefaultListModel();
        private JList jListEcAdd = new JList( modelEc );

   public Exercise_UI() {
        // FRAME
        setupWindow();
        // PANELS AND TABS
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
        jpAddExercise.setBackground(new Color(0,191,255));
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
        
        /// ADD EXERCISE ///
        JPanel addExerciseContainer = new JPanel();
        
        // TITLE
        JPanel addExercisePanelTitle = new JPanel();
        JLabel jlExercise = new JLabel("Add exercise to exercise collection");
        addExercisePanelTitle.add(jlExercise);
        addExerciseContainer.add(addExercisePanelTitle);

        // MAIN INPUT
        JPanel addExercisePanelInput = new JPanel();
        JLabel jlAeName = new JLabel("Name:");
        addExercisePanelInput.add(jlAeName);
        addExercisePanelInput.add(jtfAeName);
        JLabel jlAeCal = new JLabel("Calories:");
        addExercisePanelInput.add(jlAeCal);
        addExercisePanelInput.add(jtfAeCal);
        JButton jbAddExercise = new JButton("Add");
        addExercisePanelInput.add(jbAddExercise);
        addExerciseContainer.add(addExercisePanelInput);
        
        // SCROLL PANES
        JScrollPane ecScrollAdd = new JScrollPane(jListEcAdd);

        // LIST OF EXERCISES
        JPanel viewExerciseCollection = new JPanel();
        JLabel jlExerciseCollection = new JLabel("<html><div style='text-align: center;'>Exercise&nbsp&nbsp<br>Collection&nbsp;&nbsp;&nbsp;</div></html>");
        viewExerciseCollection.add(jlExerciseCollection);
        viewExerciseCollection.add(ecScrollAdd);

        // VIEW EXERCISE CALORIES
        JPanel exerciseCalories = new JPanel();
        JButton jbviewCal = new JButton("View Exercise Calories");
        JLabel jlAeCals = new JLabel("Cals:");
        exerciseCalories.add(jbviewCal);
        exerciseCalories.add(jlAeCals);
        exerciseCalories.add(jlNumExerCal);
        
        // MODIFY EXERCISE
        JPanel editsExerciseCollection = new JPanel();
        JButton jbUpdateExercise = new JButton("Update Exercise");
        JLabel jlUpdateExerCal = new JLabel("Cals: ");
        editsExerciseCollection.add(jlUpdateExerCal);
        editsExerciseCollection.add(updateCalExer);
        editsExerciseCollection.add(jbUpdateExercise);
        
        // READY
        JPanel jpReadytoGo = new JPanel();
        JLabel jlReadytoGo = new JLabel("Are you ready to start your log?\n");
        JButton jbReadytoGo = new JButton("I am ready!"); //Action listener to go to ADD TO LOG tab
        jpReadytoGo.add(jlReadytoGo);
        jpReadytoGo.add(jbReadytoGo);
        
        // ADD ALL TO EXERCISE CONTAINER
        addExerciseContainer.add(viewExerciseCollection);
        addExerciseContainer.add(exerciseCalories);
        addExerciseContainer.add(editsExerciseCollection);
        
        addExerciseContainer.setLayout(new BoxLayout(addExerciseContainer, BoxLayout.PAGE_AXIS));
        jpReadytoGo.setLayout(new FlowLayout(2,200,150));
        jpReadytoGo.setBackground(new Color(0,191,255));
        addExerciseContainer.add(jpReadytoGo);
        jpAddExercise.add(addExerciseContainer);
        /// ADD EXERCISE END ///
        
       // STYLES
       jlExercise.setFont(new Font("Raleway", Font.BOLD, 15));
       jlExerciseCollection.setFont(new Font("Raleway", Font.BOLD, 15));
       jListEcAdd.setFixedCellWidth(400);
       jlExercise.setFont(new Font("Raleway", Font.BOLD, 15));
       jlReadytoGo.setFont(new Font("Raleway", Font.BOLD, 15));
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

        Exercise_UI gui = new Exercise_UI();
        
        }
  
}