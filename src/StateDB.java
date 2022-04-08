import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/********************************************************************
 Written by: Ari Goldberg

 ASSIGNMENT: Write a program that writes a new State database program
 using OOP and your State class.

 Your program should have a menu method that gives the user the following options:
 print, search, add, delete, exit

 print should print the entire database in the text area we used in your orignial program.
 search should ask for the name of a state and search for it. If it is found the
 information for that state should be printed using the toString() from State.
 add should ask for the name of the state to be added. If that state is already in the
 database you should print a message saying it is already there. Otherwise ask for
 the rest of the information and add the state. You database should remain sorted
 by state name.
 delete should ask for the name of the state to be deleted. If the state is in the database
 it should be deleted.
 The user should be able to continue to run your program until they chooses to exit.

 NOTES:
 You cannot use 51 as the size of the ArrayList since it will be changing.
 You can create a dummy state using the name the user inputs, 4 empty Strings and 0.
 This will be useful in search() & add() although there are other ways to write these
 two methods.
 You MUST use this for delete() - most of the delete method can be written using
 methods from the ArrayList class.
 You shouldn't print the entire database after add and delete. Your program should
 go back to the main menu and the user can choose print from there.
 Your program should be running from your main method but all that should be there
 is declaring variables, a loop to keep the program going and method calls.

 HAND IN: after THOROUGHLY testing your program, copy and paste your code to
 Schoology and submit.
 ********************************************************************/
public class StateDB {
    public static void changeJOP() {
        UIManager um = new UIManager();
        um.put("OptionPane.messageForeground", UIManager.getFont("Arial"));
        um.put("Panel.background", Color.white);
        um.put("Label.font", new FontUIResource(new Font("Times New Roman", Font.BOLD, 58)));
        um.put("OptionPane.messageForeground", new Color(0, 0, 0));
        um.put("TextField.background", Color.white);
        um.put("TextField.font", new FontUIResource(new Font("Dialog", Font.BOLD, 24)));
        um.put("TextField.foreground", Color.black);
        um.put("Panel.background", new Color(215, 214, 214));
        um.put("OptionPane.background", new Color(215, 214, 214));
        um.put("Button.background", new Color(132, 112, 255));
        um.put("Button.foreground", new Color(0, 0, 0));
        um.put("Button.font", new FontUIResource(new Font("Arial", Font.BOLD, 14)));
    }
    public static void main(String[] args) {
        changeJOP();
        ArrayList<State> states = new ArrayList<State>();
        fill(states);
        int choice = menu();
        while (choice != 5) {
            switch(choice) {
                case 0: print(states); break;
                case 1: search(states);	break;
                case 2: add(states); break;
                case 3: delete(states); break;
                case 4: System.exit(0);
            }
            choice= menu();
        }
    }
    public static int menu() {
        String message = "";
        message += "What do you want to do?";
        String[] buttons = {"Print", "Search", "Add", "Delete", "Quit"};

        int choice = JOptionPane.showOptionDialog(null, message, "Choices", 0, 3, null, buttons, null);
        return choice;
    }
    public static void fill(ArrayList<State> states) {
        Scanner inFile;
        try {
            inFile = new Scanner(new File("src/states.txt"));
            while (inFile.hasNext()) {
                for (int r = 0; r < 51; r++) {
                    State s1 = new State(inFile.nextLine(), inFile.nextLine(), inFile.nextLine(), inFile.nextLine(), Integer.parseInt(inFile.nextLine()));
                    states.add(s1);
                }
            }
            inFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void print(ArrayList<State> states) {
        JTextArea area = new JTextArea();
        String answer = String.format("%-23s %-23s %-30s %-30s %s", "STATE NAME", "CAPITAL","FLOWER","BIRD","POPULATION"+"\n\n");
        area.append(answer);
        for (State s : states) {
            answer = String.format("%-23s %-23s %-30s %-30s %s", s.getStateName(), s.getStateCapital(), s.getStateFlower(), s.getStateBird(), s.getStatePopulation() + "\n");
            area.append(answer);
        }
        area.setBackground(new Color(255, 250, 205));
        area.setForeground(new Color(0, 0, 0));
        area.setFont(new Font("Consolas", Font.PLAIN, 15));
        area.setRows(35);
        area.setColumns(115);
        JScrollPane pane = new JScrollPane(area);
        JOptionPane.showMessageDialog(null, pane);
    }
    public static void search(ArrayList<State> states) {
        String state = JOptionPane.showInputDialog("What state would you like to search for?");
        int i = 0;
        String message = "";

        State s = new State(state.toUpperCase(), null, null, null, 0);

        while (i < states.size() && !(s.equals(states.get(i))))
            i++;

        if (i == states.size())
            message += "Sorry - the state " + state + " wasn't found!";
        else {
            message += "Here is the information for " + state  + ":" + "\n\n" + states.get(i).toString();
        }
        JOptionPane.showMessageDialog(null, message);
    }
    public static void add(ArrayList<State> states) {
    String addState = JOptionPane.showInputDialog("Enter the name of the state you want to add:");
    String message = "";
    addState = addState.toUpperCase();

    State s = new State(addState, null, null, null, 0);

    if (states.contains(s)){
        message += "Sorry - that state is already in the database";
    } else {
        String addCapital = JOptionPane.showInputDialog(null, "Enter the name of " + addState + "'s Capital:");
        String addFlower = JOptionPane.showInputDialog(null, "What is " + addState + "'s Flower?");
        String addBird = JOptionPane.showInputDialog(null, "What is " + addState + "'s Bird?");
        String addPopulation = JOptionPane.showInputDialog(null, "How many people live in " + addState + "?");
        State S = new State(addState.toUpperCase(),addCapital.toUpperCase(),addFlower.toUpperCase(),addBird.toUpperCase(),Integer.parseInt(addPopulation));
        states.add(S);
        Collections.sort(states);
        message += "State " + addState + " has been successfully added!";
        }
        JOptionPane.showMessageDialog(null, message);
    }
    public static void delete(ArrayList<State> states){
    String deleteState = JOptionPane.showInputDialog("Enter the name of the state you want to delete:");
    String message = "";
    State s = new State(deleteState.toUpperCase(), null, null, null, 0);

    if (states.contains(s)){
        states.remove(s);
        message += "The state " + deleteState.toUpperCase() + " has been removed";
    } else {
        message += "Sorry - that state didn't exist in the first place!";
    }
    JOptionPane.showMessageDialog(null,message);
    }
}