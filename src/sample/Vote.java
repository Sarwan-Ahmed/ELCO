package sample;

import javafx.fxml.FXML;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

//Vote class
public class Vote{

    //variables vote counters for each party
    public static int mna1=0;
    public static int mna2=0;
    public static int mna3=0;
    public static int mna4=0;

    //file handling
    public static void RV(String file, String lineToRemove) throws FileNotFoundException {

        //try catch block
        try {
            File inFile = new File(file);
            if (!inFile.isFile()) {
                System.out.println("Parameter is not an existing file");
            }

            //Construct the new file that will later be renamed to the original filename.
            File tempFile = new File(inFile.getAbsolutePath() + ".tmp");
            BufferedReader br = new BufferedReader(new FileReader(file));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile,true));
            String line = null;

            //Read from the original file and write to the new
            //unless content matches data to be removed.
            while ((line = br.readLine()) != null) {
                if (!line.trim().equals(lineToRemove)) {
                    pw.println(line);
                    pw.flush();
                }
            }
            pw.close();
            br.close();

            //Delete the original file
            if (!inFile.delete()) {
                System.out.println("Could not delete file");
                return;
            }

            //Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(inFile))
                System.out.println("Could not rename file");
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    //Constructor
    public Vote(){
        System.out.println("\n\t\t\tWelcome To Voting Page ");
        //vote1();
    }

    //loop through until wrong option is entered
    //count votes of each party

    public  void vote1(String input1){

        String voteFor1;
        boolean flag2;

        System.out.println("1=Vote for PTI(Pakistan Tehreek-e-Insaf)\n" +
                "2=Vote for PMLN(Pakistan Muslim League (N))\n" +
                "3=Vote for PPP(Pakistan Peoples Party)\n" +
                "4=Vote for JUI(Jamiat Ulema-e Islam)");
        do {
            System.out.print("Enter your choice: ");

            if (input1.equals("1")) {
                mna1++;
                flag2=false;
            } else if (input1.equals("2")) {
                mna2++;
                flag2=false;
            } else if (input1.equals("3")) {
                mna3++;
                flag2=false;
            } else if (input1.equals("4")) {
                mna4++;
                flag2=false;
            } else
            {flag2=true;
                System.out.println("Invalid choice! please enter valid choice"); }
        } while (flag2);
        System.out.println("Successfully voted!");
    }
}
