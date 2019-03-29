package sample;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Login {


    //Login class

        Scanner input=new Scanner(System.in);
        String ID;
        protected String name;
        protected String cnic;
        protected String Password;
        //method which will read the data from file, if already registered then give access for login
        //throws exception if file not found
        public String[] readLines(String filename) throws IOException
        {
            FileReader fileReader = new FileReader(filename);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            List<String> lines = new ArrayList<String>();
            String line = null;

            while ((line = bufferedReader.readLine()) != null)
            {
                lines.add(line);
            }

            bufferedReader.close();

            return lines.toArray(new String[lines.size()]);
        }
        // Constructor
        public void  Login(String name,String CNIC,String password) {
            System.out.println("\n\t\t\tWelcome To Login Page");

            int i=1;
            while(i==1){
                System.out.print("Name: ");


                if (name.isEmpty())
                    System.out.println("Invalid name! Try again.");
                else
                    i=-1;
            }

            int j=1;
            while(j==1){
                System.out.print("CNIC (without dashes): ");

                if (CNIC.length()==13)
                    j=-1;
                else if(cnic.isEmpty())
                    System.out.println("Invalid CNIC! Try again.");
                else
                    System.out.println("Invalid CNIC! Try again.");
            }

            int k=1;
            while(k==1){
                System.out.print("Password: ");

                if (password.isEmpty())
                    System.out.println("Invalid password! Try again.");
                else
                    k=-1; }

            ID=name+cnic+Password;
        }
    }

