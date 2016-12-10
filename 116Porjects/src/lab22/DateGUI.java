package lab22;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * GUI application for Date
 * 
 * @author Jialang Li
 */
public class DateGUI extends JFrame implements ActionListener {
     /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** Label for Month */
    private JLabel monthLabel;
    /** Text field for Month */
    private JTextField monthText;    
    /** Label for 1st denominator */
    private JLabel dayLabel;
    /** Text field for 1st denominator */
    private JTextField dayText;
    /** Label for 2nd numerator */
    private JLabel yearLabel;
    /** Text field for 2nd numerator */
    private JTextField yearText;
    /** Label for 2nd denominator */
    private JLabel month2Label;
    /** Text field for 2nd numerator */
    private JTextField month2Text;
    /** Label for 1st denominator */
    private JLabel day2Label;
    /** Text field for 2nd denominator */    
    private JTextField day2Text;
    /** Label for 2nd numerator */
    private JLabel year2Label;
    /** Text field for 2nd numerator */
    private JTextField year2Text;
    
    private JTextField num1Text;
    
    private JTextField num2Text;
    
    private JTextField den1Text;
    
    private JTextField den2Text;
    /** Label for Answer */
    private JLabel ansLabel;
    /** Text field for Answer */
    private JTextField ansText;   
    
    private JButton addButton;
    
    private JButton subtractButton;
    
    private JButton multiplyButton;
    
    private JButton divideButton;
    /** Button for Subtract */
    private JButton addDays;
    /** Button for nextDay */
    private JButton nextDay;
    /** Button for Multiply */
    private JButton addWeeks;
    /** Button for Divide */
    private JButton daysTo;
    
    /**
     * Default constructor
     */
    public DateGUI() {
        super("Rational Number GUI");
        setSize(500, 500);
        setLocation(100, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Create a JPanel
        JPanel panel = new JPanel(new GridLayout(7, 2));
        // Add JPanel to the frame
        add(panel);
        
        monthLabel = new JLabel("Month");
        panel.add(monthLabel);
        monthText = new JTextField(5);
        panel.add(monthText); 

        dayLabel = new JLabel("Day");
        panel.add(dayLabel);
        dayText = new JTextField(5);
        panel.add(dayText); 

        yearLabel = new JLabel("Year");
        panel.add(yearLabel);
        yearText = new JTextField(5);
        panel.add(yearText);      
  
        month2Label = new JLabel("Another Month");
        panel.add(month2Label);
        month2Text = new JTextField(5);
        panel.add(month2Text); 

        day2Label = new JLabel("Another Day");
        panel.add(day2Label);
        day2Text = new JTextField(5);
        panel.add(day2Text); 

        year2Label = new JLabel("Another Year");
        panel.add(year2Label);
        year2Text = new JTextField(5);
        panel.add(year2Text);  

        ansLabel = new JLabel("Result");
        panel.add(ansLabel);
        ansText = new JTextField(5);
        panel.add(ansText); 

        addDays = new JButton("Add days");
        panel.add(addDays);

        nextDay = new JButton("Next day");
        panel.add(nextDay);
        
        addWeeks = new JButton("Add Weeks");
        panel.add(addWeeks);
        
        daysTo = new JButton("Days to");
        panel.add(daysTo);
        
        addDays = new JButton("Add days");
        panel.add(addDays);
        
        addDays = new JButton("Add days");
        panel.add(addDays);        

        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);
        
        setVisible(true);
    }

    /**
     * Performs specific action(s) based on the event that occurs
     * 
     * @param e event that occurred
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            try {
                int num1 = Integer.parseInt(num1Text.getText());
                int num2 = Integer.parseInt(num2Text.getText());
                int den1 = Integer.parseInt(den1Text.getText());
                int den2 = Integer.parseInt(den2Text.getText());
                RationalNumber first = new RationalNumber(num1, den1);
                RationalNumber second = new RationalNumber(num2, den2);
                ansText.setText(first.add(second).toString());
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Invalid integer.");
            } catch (IllegalArgumentException iae) {
                JOptionPane.showMessageDialog(null,
                                "Denomintor of zero in given number or result of operation.");
            }
            System.out.println("Add clicked");
        }
        if (e.getSource() == subtractButton) {
            try {
                int num1 = Integer.parseInt(num1Text.getText());
                int num2 = Integer.parseInt(num2Text.getText());
                int den1 = Integer.parseInt(den1Text.getText());
                int den2 = Integer.parseInt(den2Text.getText());
                RationalNumber first = new RationalNumber(num1, den1);
                RationalNumber second = new RationalNumber(num2, den2);
                ansText.setText(first.subtract(second).toString());
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Invalid integer.");
            } catch (IllegalArgumentException iae) {
                JOptionPane.showMessageDialog(null,
                                "Denomintor of zero in given number or result of operation.");
            }
            System.out.println("Subtract clicked");
        }
        if (e.getSource() == multiplyButton) {
            try {
                int num1 = Integer.parseInt(num1Text.getText());
                int num2 = Integer.parseInt(num2Text.getText());
                int den1 = Integer.parseInt(den1Text.getText());
                int den2 = Integer.parseInt(den2Text.getText());
                RationalNumber first = new RationalNumber(num1, den1);
                RationalNumber second = new RationalNumber(num2, den2);
                ansText.setText(first.multiply(second).toString());
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Invalid integer.");
            } catch (IllegalArgumentException iae) {
                JOptionPane.showMessageDialog(null,
                                "Denomintor of zero in given number or result of operation.");
            }
            System.out.println("Multiply clicked");
        }
        if (e.getSource() == divideButton) {
            try {
                int num1 = Integer.parseInt(num1Text.getText());
                int num2 = Integer.parseInt(num2Text.getText());
                int den1 = Integer.parseInt(den1Text.getText());
                int den2 = Integer.parseInt(den2Text.getText());
                RationalNumber first = new RationalNumber(num1, den1);
                RationalNumber second = new RationalNumber(num2, den2);
                ansText.setText(first.divide(second).toString());
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Invalid integer.");
            } catch (IllegalArgumentException iae) {
                JOptionPane.showMessageDialog(null,
                                "Denomintor of zero in given number or result of operation.");
            }
            System.out.println("Divide clicked");
        }

    }

    /**
     * Starts the program
     * 
     * @param args array of command line arguments
     */
    public static void main(String[] args) {
        new DateGUI();
    }
}