/*
* Diet Manager v1.0
* Team E: Ryan Wren, Vignesh Kumar, Vincent Cheng, Efmajackson Rosario
* SWEN.383.01
/*
* Log UI contains the necessary UI components for user to  
* add and view logs necessary for the user to track their Diet.
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

public class Log_UI extends JFrame { 

    // VARIABLES
    private DateFormat df;
    private Date date;
    
    // TEXT FIELDS
    private JTextField jtfDate = new JTextField(10);
    private JTextField jtfDateLog = new JTextField(10);
    private JTextField jtfHomeDate = new JTextField(10);
    private JTextField jtfServings = new JTextField(5);
    private JTextField jtfMinutes = new JTextField(5);
    private JTextField jtfAddWeight = new JTextField(10);
    private JTextField jtfAddCalIntake = new JTextField(10);
    private JTextField jtfAddCalIntakeGoal = new JTextField(10);
    
    // JLISTS
    private DefaultListModel modelLog = new DefaultListModel();
    private JList jListLog = new JList( modelLog );
    private DefaultListModel modelLogs = new DefaultListModel();
    private JList jListLogs = new JList( modelLogs );
    private DefaultListModel modelE = new DefaultListModel();
    private JList jListEc = new JList( modelE );
    private DefaultListModel modelF = new DefaultListModel();
    private JList jListFc = new JList( modelF );
    
    public Log_UI() {
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
        
        // SCROLL PANES
        JScrollPane fcScroll = new JScrollPane(jListFc);
        JScrollPane ecScroll = new JScrollPane(jListEc);
    
        /// ADD LOG ///
        JPanel logContainer = new JPanel();
        JPanel dateContainer = new JPanel();
        JPanel datePanel = new JPanel();
        JPanel logTitle = new JPanel();
        JLabel jlAddLog = new JLabel("Add log to your Diet Manager");
        JLabel jlDate = new JLabel("Select a date to add a log: ex. mm/dd/yyy");
        logTitle.add(jlAddLog);
        datePanel.add(jlDate);
        datePanel.add(jtfDate);
        JButton jbDate = new JButton("Select");
        datePanel.add(jbDate);
        // ACTION LISTENER TO SELECT DATE

        dateContainer.add(datePanel);
        dateContainer.setLayout(new BoxLayout(dateContainer, BoxLayout.Y_AXIS));
        logContainer.add(logTitle);
        logContainer.add(dateContainer);

        JPanel weightContainer = new JPanel();
        JLabel jlAddWeight = new JLabel("Your Current Weight:");
        JLabel jlWeightGoal = new JLabel("Your Weight Goal:");
        JTextField jftWeightGoal = new JTextField(10);
        
        // ADD ALL TO WEIGHT CONTAINER TO LOG
        weightContainer.add(jlAddWeight);
        weightContainer.add(jtfAddWeight);
        weightContainer.add(jlWeightGoal);
        weightContainer.add(jftWeightGoal);          
        logContainer.add(weightContainer);

        JPanel calIntakeContainer = new JPanel();
        JLabel jlCalIntake = new JLabel("Your Calorie Intake:");
        JLabel jlCalIntakeGoal = new JLabel("Your Calorie Intake Goal:");
        
        // ADD ALL TO CALORIE INTAKE CONTAINER
        calIntakeContainer.add(jlCalIntake);
        calIntakeContainer.add(jtfAddCalIntake);
        calIntakeContainer.add(jlCalIntakeGoal);
        calIntakeContainer.add(jtfAddCalIntakeGoal);
        logContainer.add(calIntakeContainer);

        // EXERCISE LOG PANELS
        JPanel exerciseToLogContainer = new JPanel();
        JPanel exerciseToLogTitle= new JPanel();
        JPanel exerciseToLogPanel = new JPanel();
        JPanel exerciseToLogMinutes = new JPanel();
        
        JLabel jlEc = new JLabel("Select an exercise from the exercise collection to log");
        JLabel jlExercises = new JLabel("<html><div style='text-align: center;'>Exercise&nbsp;&nbsp;<br>Collection&nbsp;&nbsp;&nbsp;</div></html>");
        JLabel jlMinutes = new JLabel("Minutes:");
        JButton jbAddExerciseToLog = new JButton("Record Exercise");
        exerciseToLogTitle.add(jlEc);
        exerciseToLogPanel.add(jlExercises);
        exerciseToLogPanel.add(ecScroll);
        exerciseToLogMinutes.add(jlMinutes);
        exerciseToLogMinutes.add(jtfMinutes);
        exerciseToLogMinutes.add(jbAddExerciseToLog);
       
        // ADD ALL TO EXERCISE LOG
        exerciseToLogContainer.add(exerciseToLogTitle);
        exerciseToLogContainer.add(exerciseToLogPanel);
        exerciseToLogContainer.add(exerciseToLogMinutes);
        exerciseToLogContainer.setLayout(new BoxLayout(exerciseToLogContainer, BoxLayout.Y_AXIS));
        logContainer.add(exerciseToLogContainer);

        // FOOD LOG PANELS
        JPanel foodToLogContainer = new JPanel();
        JPanel foodToLogTitle= new JPanel();
        JPanel foodToLogPanel = new JPanel();
        JPanel foodToLogServ = new JPanel();
        JLabel jlFc = new JLabel("Select a food from the food collection to log");
        JLabel jlFoods = new JLabel("<html><div style='text-align: center;'>Food&nbsp;&nbsp;&nbsp;<br>Collection&nbsp;&nbsp;&nbsp;</div></html>");
        foodToLogTitle.add(jlFc);
        foodToLogPanel.add(jlFoods);
        foodToLogPanel.add(fcScroll);

        JLabel jlServings = new JLabel("Servings:");
        JButton jbAddFoodToLog = new JButton("Record Food");
        foodToLogServ.add(jlServings);
        foodToLogServ.add(jtfServings);
        foodToLogServ.add(jbAddFoodToLog);
        
        // GO TO ALL LOGS
        JPanel jpViewAllLogs = new JPanel();
        JLabel jlViewAllLogs = new JLabel("Want to view all your logs?");
        JButton jbViewAllLogs = new JButton("View all logs now!"); //Action listener to go to ADD TO LOG tab
        jpViewAllLogs.add(jlViewAllLogs);
        jpViewAllLogs.add(jbViewAllLogs);
        
        // ADD ALL TO FOOD LOG CONTAINER
        foodToLogContainer.add(foodToLogTitle);
        foodToLogContainer.add(foodToLogPanel);
        foodToLogContainer.add(foodToLogServ);
        foodToLogContainer.setLayout(new BoxLayout(foodToLogContainer, BoxLayout.Y_AXIS));
        logContainer.add(foodToLogContainer);
        logContainer.setLayout(new BoxLayout(logContainer, BoxLayout.Y_AXIS));
        jpViewAllLogs.setLayout(new FlowLayout(2,200,40));
        jpViewAllLogs.setBackground(Color.YELLOW);
        foodToLogContainer.add(jpViewAllLogs);
        jpLog.add(logContainer);
        /// END ADD LOG ///
     
        /// VIEW LOGS ///
        JPanel viewLogContainer = new JPanel();
        JPanel jpViewLogTitle = new JPanel();
        JLabel jlViewLogTitle = new JLabel("Track all your logs");
        jpViewLogTitle.add(jlViewLogTitle);
        JPanel datePanelLog = new JPanel();
        JLabel jlDateLog = new JLabel("Select a date to view log entries: ex. mm/dd/yyyy");
        datePanelLog.add(jlDateLog);
        datePanelLog.add(jtfDateLog);
        JButton jbDate2 = new JButton("View Log Date");
        datePanelLog.add(jbDate2);

        JPanel viewPanel = new JPanel();
        JLabel jlViewLog = new JLabel("<html><div style='text-align: center;'>Daily logs&nbsp;&nbsp;&nbsp;</div></html>");
        viewPanel.add(jlViewLog);
        JScrollPane scrollLog = new JScrollPane(jListLog);
        viewPanel.add(scrollLog);

        JPanel jpDelete = new JPanel();
        JButton jbDelete = new JButton("Delete from your Daily Logs");
        jpDelete.add(jbDelete);
        
        JPanel jpAllLogs = new JPanel();
        JLabel jlAllLogs = new JLabel("<html><div style='text-align: center;'>All Your Logs&nbsp;&nbsp;&nbsp;</div></html>");
        JScrollPane scrollLog2 = new JScrollPane(jListLogs);
        jpAllLogs.add(jlAllLogs);
        jpAllLogs.add(scrollLog2);
        
        JPanel jpDeleteLog = new JPanel();
        JButton jbDeleteLog = new JButton("Delete from All Logs");
        jpDeleteLog.add(jbDeleteLog);
        //SHOW ALL LOG ENTRIES
   
        // GO TO ADD NEW LOGO TAB
        JPanel jpAddalog = new JPanel();
        JLabel jlAddalog = new JLabel("Want to add another log?");
        JButton jbAddalog = new JButton("Add new log now!"); //Action listener to go to ADD TO LOG tab
        jpAddalog.add(jlAddalog);
        jpAddalog.add(jbAddalog);
          
        // ADD ALL TO VIEW LOG CONTAINER
        viewLogContainer.add(jpViewLogTitle);
        viewLogContainer.add(datePanelLog);
        viewLogContainer.add(viewPanel);
        viewLogContainer.add(jpDelete);
        viewLogContainer.add(jpAllLogs);
        viewLogContainer.add(jpDeleteLog);
        viewLogContainer.setLayout(new BoxLayout(viewLogContainer, BoxLayout.Y_AXIS));
        jpAddalog.setLayout(new FlowLayout(2,200,100));
        jpAddalog.setBackground(new Color(240,128,128));
        viewLogContainer.add(jpAddalog);
        jpViewLog.add(viewLogContainer);
        /// END VIEW LOG ////
        
        // STYLES
        jlAddLog.setFont(new Font("Raleway", Font.BOLD, 15));
        jlViewLogTitle.setFont(new Font("Raleway", Font.BOLD, 15));
        jListFc.setFixedCellWidth(400);
        jListEc.setFixedCellWidth(400);
        jListLog.setFixedCellWidth(400);
        jListLogs.setFixedCellWidth(400);
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

        Log_UI gui = new Log_UI();
        
        }
  
}
    