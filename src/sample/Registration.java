package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Formatter;
import java.util.Scanner;

public class Registration {

        private static Formatter x;
        static Person p;            //composition
        protected  String name;
        protected String cnic;
        protected  String password;
        Scanner input=new Scanner(System.in);
        int i,j,k;

        //Constructor
        public Registration() throws FileNotFoundException {

            i=1;
            while(i==1){

                name =input.nextLine();
                if (name.isEmpty())
                    System.out.println("Invalid name! Try again.");
                else
                    i=-1;
            }
            j=1;
            while(j==1){
                System.out.print("Your CNIC (without dashes): ");
                cnic=input.nextLine();
                if (cnic.length()==13)
                    j=-1;
                else if(cnic.isEmpty())
                    System.out.println("Invalid CNIC! Try again.");
                else
                    System.out.println("Invalid CNIC! Try again.");
            }
            k=1;
            while(k==1){
                System.out.print("Your Password: ");
                password=input.nextLine();
                if (password.isEmpty())
                    System.out.println("Invalid password! Try again.");
                else
                    k=-1; }
            System.out.println("Registered successfully!");

            p=new Person(name,cnic,password);//person object
           // Addvoters(name+cnic+password);
        }

        //add the new registered data to file
        //throws exception if file not found
        public void Addvoters(String ID,String cnic) throws FileNotFoundException {
            String savestr = "Voterslist.txt";
            String s="CNICList.txt";
            File file=new File(s);
            File f = new File(savestr);
            PrintWriter out = null;
            PrintWriter in=null;
            if ( f.exists() && file.exists() && !file.isDirectory() && !f.isDirectory() ) {
                out = new PrintWriter(new FileOutputStream(new File(savestr), true));
                in=new PrintWriter(new FileOutputStream(new File(s),true));
            }
            else {
                out = new PrintWriter(savestr);
                in=new PrintWriter(s);
            }
            out.append(ID);//append the data
            in.append(cnic);
            out.close();        //close the file
            in.close();

        }
    }

