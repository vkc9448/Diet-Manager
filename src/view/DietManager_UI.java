/*
* Diet Manager v2.0
* Team E: Ryan Wren, Vignesh Kumar, Vincent Cheng, Efmajackson Rosario
* SWEN.383.01
*/

/*
* Diet Manager UI contains the necessary UI components for user to  
* addding nutritional info and updating info pertaining to the user in the Diet Manager.
*/
package View;
//import controller.*;


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

public class DietManager_UI extends JFrame {

    private Date date;

    //JTextFields
    private JTextField jtfHomeDate = new JTextField(10);
    
    //JPanels
    private JPanel BarChartPanel = new JPanel();
    private JPanel jpWelcome = new JPanel();
    private JPanel jpBarFat = new JPanel();
    private JPanel jpBarCarb = new JPanel();
    private JPanel jpBarPro = new JPanel();

    //JLabels
    private JLabel jlRecipeDetail = new JLabel("");
    private JLabel jlNumWeight = new JLabel("#.##");
    private JLabel jlNumGoal = new JLabel("#.##");

    private JLabel jlNumCalLost = new JLabel("###.##");
    private JLabel jlNumCal = new JLabel("###.##");
    private JLabel jldifference = new JLabel("###.##");

    private JLabel jlNumCalConsumed = new JLabel("##.##");
    private JLabel jlNumExerCal = new JLabel("##.##");
    private JLabel jlCalories = new JLabel("##.##");
    private JLabel jlFat = new JLabel("##.##");
    private JLabel jlCarbs = new JLabel("##.##");
    private JLabel jlPro = new JLabel("##.##");
    private JLabel jlBarFat = new JLabel("");
    private JLabel jlBarCarb = new JLabel("");
    private JLabel jlBarPro = new JLabel("");

    public DietManager_UI() {
        //frame
        setupWindow();
        //Panels and Tabs
        JTabbedPane tabbedPane = new JTabbedPane();
        getContentPane().add(tabbedPane);
        JPanel jpHome = new JPanel();
        jpHome.setBackground(Color.YELLOW);
        tabbedPane.addTab("Home", jpHome);
        JPanel jpAddFood = new JPanel();
        tabbedPane.addTab("Add Basic Food", jpAddFood);
        JPanel jpAddRecipe = new JPanel();
        tabbedPane.addTab("Add Recipe", jpAddRecipe);
        JPanel jpAddExercise = new JPanel();
        tabbedPane.addTab("Add Exercise", jpAddExercise);
        JPanel jpLog = new JPanel();
        tabbedPane.addTab("Add to Log", jpLog);
        JPanel jpViewLog = new JPanel();
        tabbedPane.addTab("View Logs", jpViewLog);
        tabbedPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        tabbedPane.setTabPlacement(JTabbedPane.BOTTOM);
 
        ///HOME 
        
        // Labels
        JLabel jlWelcome = new JLabel("Your Diet Manager");
        JMenuBar mb= new JMenuBar();
        mb.setLayout(new FlowLayout(1,50,0));
        JMenu options = new JMenu("Menu");
        JMenu exit = new JMenu("Exit");
        mb.add(options);
        mb.add(jlWelcome);
        mb.add(exit);
        setJMenuBar(mb);
        
        JPanel homeContainer = new JPanel();
        JPanel homeDetailContainer = new JPanel();

        JPanel dateSelectPanel = new JPanel();
        JLabel jlHomeDate = new JLabel("Select the date to view entry ex. yyyy/mm/dd");
        dateSelectPanel.add(jlHomeDate);
        dateSelectPanel.add(jtfHomeDate);
        JButton jbHomeDate = new JButton("View");
        dateSelectPanel.add(jbHomeDate);
        dateSelectPanel.setLayout(new FlowLayout(1,30,5));
        jpHome.add(dateSelectPanel);

        JPanel weightRecordPanel = new JPanel();
        JLabel jlWeight = new JLabel("Your Weight Recorded: ");
        
        weightRecordPanel.add(jlWeight);
        weightRecordPanel.add(jlNumWeight);
        weightRecordPanel.setLayout(new FlowLayout(1,200,10));
        jpHome.add(weightRecordPanel);

        JPanel calIntakeGoal = new JPanel();
        JLabel jlGoal = new JLabel("Your Calories Intake Goal Set: ");
        calIntakeGoal.add(jlGoal);
        calIntakeGoal.add(jlNumGoal);
        calIntakeGoal.setLayout(new FlowLayout(1,165,10));
        jpHome.add(calIntakeGoal);

        JPanel calConsumed = new JPanel();
        JLabel jlCalConsumed = new JLabel("Your Total Calories Consumed: ");
        calConsumed.add(jlCalConsumed);
        calConsumed.add(jlNumCalConsumed);
        calConsumed.setLayout(new FlowLayout(1,150,10));
        jpHome.add(calConsumed);

        JPanel calLost = new JPanel();
        JLabel jlCalLost = new JLabel("Your Total Calories Lost: ");
        calLost.add(jlCalLost);
        calLost.add(jlNumCalLost);
        calLost.setLayout(new FlowLayout(1,190,10));
        jpHome.add(calLost);

        JPanel netCal = new JPanel();
        JLabel jlnetCal = new JLabel("Your Net Calories: ");
        netCal.add(jlnetCal);
        netCal.add(jlNumCal);
        netCal.setLayout(new FlowLayout(1,220,10));
        jpHome.add(netCal);

        JPanel difference = new JPanel();
        JLabel jldiff = new JLabel("Your Net Calories - Calories Intake Goal: ");
        difference.add(jldiff);
        difference.add(jldifference);
        difference.setLayout(new FlowLayout(1,90,5));
        jpHome.add(difference);

        JPanel BarChartContainer = new JPanel();
        JPanel BarChartTextPanel = new JPanel();
        JLabel barDataTitle = new JLabel("Your Diet Today: ");
        BarChartTextPanel.add(barDataTitle);
        JLabel jlBarFatTitle = new JLabel("Fat: ");
        BarChartTextPanel.add(jlBarFatTitle);
        BarChartTextPanel.add(jlBarFat);
        JLabel jlBarCarbTitle = new JLabel("Carbohydrates: ");
        BarChartTextPanel.add(jlBarCarbTitle);
        BarChartTextPanel.add(jlBarCarb);
        JLabel jlBarProTitle = new JLabel("Protein: ");
        BarChartTextPanel.add(jlBarProTitle);
        BarChartTextPanel.add(jlBarPro);
        BarChartPanel.add(jpBarFat);
        jpBarFat.setBackground(Color.red);

        BarChartPanel.add(jpBarCarb);
        jpBarCarb.setBackground(Color.green);

        BarChartPanel.add(jpBarPro);
        jpBarPro.setBackground(Color.blue);

        BarChartContainer.add(BarChartTextPanel);
        BarChartContainer.add(BarChartPanel);

        homeDetailContainer.setLayout(new BoxLayout(homeDetailContainer, BoxLayout.Y_AXIS));
        homeContainer.setLayout(new BoxLayout(homeContainer, BoxLayout.Y_AXIS));
        BarChartContainer.setLayout(new BoxLayout(BarChartContainer, BoxLayout.Y_AXIS));


        jpHome.add(homeContainer);
        jpHome.add(BarChartContainer);
        ///END HOME

        /// STYLES
        jlWelcome.setFont(new Font("Raleway", Font.BOLD, 30));
        BarChartTextPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.YELLOW));
        BarChartPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.YELLOW));
        BarChartPanel.setPreferredSize(new Dimension(400, 260));
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

        DietManager_UI gui = new DietManager_UI();
        
        }
    
    

}
