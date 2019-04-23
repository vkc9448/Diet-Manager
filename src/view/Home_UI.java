/*
* Diet Manager v1.0
* Team E: Ryan Wren, Vignesh Kumar, Vincent Cheng, Efmajackson Rosario
* SWEN.383.01
/*
* Home UI contains the necessary UI components for user to  
* view info of the last log to the user in the Diet Manager.
*/

package View;
import controller.DatePicker;


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

public class Home_UI extends JFrame {

    public Date date;

    // TEXT FIELDS
    public JTextField jtfHomeDate = new JTextField(10);
    
    // JPANELS
    public JPanel BarChartPanel = new JPanel();
    public JPanel jpWelcome = new JPanel();
    public JPanel jpBarFat = new JPanel();
    public JPanel jpBarCarb = new JPanel();
    public JPanel jpBarPro = new JPanel();

    // JLABELS
    public JLabel jlNumWeight = new JLabel("#.##");
    public JLabel jlNumGoal = new JLabel("#.##");
    public JLabel jlNumCalLost = new JLabel("###.##");
    public JLabel jlNumCal = new JLabel("###.##");
    public JLabel jldifference = new JLabel("###.##");
    public JLabel jlNumCalConsumed = new JLabel("##.##");
    public JLabel jlNumExerCal = new JLabel("##.##");
    public JLabel jlCalories = new JLabel("##.##");
    public JLabel jlFat = new JLabel("##.##");
    public JLabel jlCarbs = new JLabel("##.##");
    public JLabel jlPro = new JLabel("##.##");
    public JLabel jlBarFat = new JLabel("");
    public JLabel jlBarCarb = new JLabel("");
    public JLabel jlBarPro = new JLabel("");

    public Home_UI() {
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
 
        /// HOME ///
        
        // LABELS
        // MENU
        JLabel jlWelcome = new JLabel("Your Diet Manager");
        JMenuBar mb= new JMenuBar();
        mb.setLayout(new FlowLayout(1,50,0));
        JMenu options = new JMenu("Menu");
        JMenu exit = new JMenu("Exit");
        mb.add(options);
        mb.add(jlWelcome);
        mb.add(exit);
        setJMenuBar(mb);
        
        // HOME CONTAINER
        JPanel homeContainer = new JPanel();
        JPanel homeDetailContainer = new JPanel();

        JPanel dateSelectPanel = new JPanel();
        JLabel jlHomeDate = new JLabel("Select the date to view entry ex. mm-dd-yyyy");
        dateSelectPanel.add(jlHomeDate);
        dateSelectPanel.add(jtfHomeDate);
        JButton jbHomeDate = new JButton("View");
        jbHomeDate.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e){  
                DatePicker dp= new DatePicker(jtfHomeDate.getText(),jlNumWeight,jlNumGoal,jlNumCalLost,jlNumCal,jldifference,jlNumCalConsumed,jlNumExerCal,jlCalories);
         } 
         });

        dateSelectPanel.add(jbHomeDate);
        dateSelectPanel.setLayout(new FlowLayout(1,30,5));
        jpHome.add(dateSelectPanel);
         
        // WEIGHT
        JPanel weightRecordPanel = new JPanel();
        weightRecordPanel.setBackground(new Color(152,251,152));
        JLabel jlWeight = new JLabel("Your Weight Recorded: ");
        
        weightRecordPanel.add(jlWeight);
        weightRecordPanel.add(jlNumWeight);
        weightRecordPanel.setLayout(new FlowLayout(1,200,10));
        jpHome.add(weightRecordPanel);

        // CALORIE GOAL
        JPanel calIntakeGoal = new JPanel();
        calIntakeGoal.setBackground(new Color(152,251,152));
        JLabel jlGoal = new JLabel("Your Calories Intake Goal Set: ");
        calIntakeGoal.add(jlGoal);
        calIntakeGoal.add(jlNumGoal);
        calIntakeGoal.setLayout(new FlowLayout(1,165,10));
        jpHome.add(calIntakeGoal);

        // CONSUMER CALORIES
        JPanel calConsumed = new JPanel();
        calConsumed.setBackground(new Color(0,191,255));
        JLabel jlCalConsumed = new JLabel("Your Total Calories Consumed: ");
        calConsumed.add(jlCalConsumed);
        calConsumed.add(jlNumCalConsumed);
        calConsumed.setLayout(new FlowLayout(1,150,10));
        jpHome.add(calConsumed);

        // CALORIES LOST
        JPanel calLost = new JPanel();
        JLabel jlCalLost = new JLabel("Your Total Calories Lost: ");
        calLost.setBackground(new Color(0,191,255));
        calLost.add(jlCalLost);
        calLost.add(jlNumCalLost);
        calLost.setLayout(new FlowLayout(1,190,10));
        jpHome.add(calLost);

        // NET CALORIES
        JPanel netCal = new JPanel();
        JLabel jlnetCal = new JLabel("Your Net Calories: ");
        netCal.setBackground(new Color(240,128,128));   
        netCal.add(jlnetCal);
        netCal.add(jlNumCal);
        netCal.setLayout(new FlowLayout(1,220,10));
        jpHome.add(netCal);

        // TOTAL CALORIES
        JPanel difference = new JPanel();
        JLabel jldiff = new JLabel("Your Net Calories - Calories Intake Goal: ");
        difference.setBackground(new Color(240,128,128));
        difference.add(jldiff);
        difference.add(jldifference);
        difference.setLayout(new FlowLayout(1,90,5));
        jpHome.add(difference);

        // BAR GRAPH
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
        jpBarFat.setBackground(new Color(240,128,128));
        BarChartPanel.add(jpBarCarb);
        jpBarCarb.setBackground(new Color(152,251,152));
        BarChartPanel.add(jpBarPro);
        jpBarPro.setBackground(new Color(0,191,255));
        BarChartContainer.add(BarChartTextPanel);
        BarChartContainer.add(BarChartPanel);
        homeDetailContainer.setLayout(new BoxLayout(homeDetailContainer, BoxLayout.Y_AXIS));
        homeContainer.setLayout(new BoxLayout(homeContainer, BoxLayout.Y_AXIS));
        BarChartContainer.setLayout(new BoxLayout(BarChartContainer, BoxLayout.Y_AXIS));

        // ADDING ALL TO HOME CONTAINER
        jpHome.add(homeContainer);
        jpHome.add(BarChartContainer);
        /// END HOME ///

        /// STYLES
        jlWelcome.setFont(new Font("Raleway", Font.BOLD, 30));
        BarChartTextPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.YELLOW));
        BarChartPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.YELLOW));
        BarChartPanel.setPreferredSize(new Dimension(400, 260));
        this.setVisible(true);
        
          
    
    }
    public static void setText(JLabel jl,String text)
    {
      jl.setText(text);
    
    }
    
    
    public void setupWindow() {
        this.setTitle("Diet Manager");
        this.setSize(550,700);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      
    }
    
    public static void main(String[] args) throws ParseException {

        Home_UI gui = new Home_UI();
        
        }
  
}
