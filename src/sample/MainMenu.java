package sample;

import com.sun.javafx.scene.EnteredExitedHandler;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class MainMenu {
    //Main Menu class

        protected String choice;
        boolean flagE=true;

        //Constructor
        public MainMenu() throws FileNotFoundException {
            Scanner obj = new Scanner(System.in);


            //loop through until choice is wrong
            do {
                System.out.print("Enter your choice: ");
                choice = obj.nextLine();
                if (choice.equals("1")) {
                    Registration reg = new Registration();

                    //try catch block for registration
                    //throws exception if file not found
                    try {
                        reg.Addvoters(Person.ID,"");
                    } catch (FileNotFoundException ex) {
                        System.out.println("The file is not present.");
                    }
                    MainMenu mm = new MainMenu();
                    flagE = false;

                }
                else if (choice.equals("2")) {
                    Login rf = new Login();

                    // The text file location of your choice
                    String filename = "VotersList.txt";

                    //try catch block for login
                    try {
                        String[] lines = rf.readLines(filename);

                        for (String line : lines) {
                            if (rf.ID.equals(line)) {
                                System.out.println("Login successful!");
                                Vote v1 = new Vote();
                                v1.RV(filename, rf.ID);
                            }
                            else if (!(rf.ID.equals(line))) {
                                System.out.println("Invalid user.");
                                MainMenu mm = new MainMenu();
                            }
                        }
                    } catch (IOException e) {
                        // Print out the exception that occurred
                        System.out.println("Unable to create " + filename + ": " + e.getMessage());
                    }
                    flagE = false;
                }
                else if (choice.equals("3")) {
                    Result res = new Result();
                    MainMenu mainMenu = new MainMenu();
                    flagE = false;
                }
                else
                    System.out.println("Invalid choice! Try again");
            }
            while (flagE == true);
        }
    }

