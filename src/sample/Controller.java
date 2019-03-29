package sample;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.net.URL;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class Controller {
    @FXML
    private JFXButton btn_signin, btn_register, btn_mainmenu, btn_results, btn_login,btn_attack, btn_cast, btn_reg;
    @FXML
    private AnchorPane pn_register, pn_signin, pn_mainmenu, pn_results, pn_castevote, pn_main, pn_options, pn_verify;
    @FXML
    private Label lb_welcome, lb_invalid, lb_verify,lb_get;
    @FXML
    private TextField field_user;
    @FXML
    private TextField field_CNIC, fild_user, fild_CNIC;
    @FXML
    private PasswordField field_pass, fild_pass, fild_authority;
    @FXML
    private Label lb_ip, lb_im, lb_fz, lb_na, lb_bl;
    @FXML
    private RadioButton rd_1, rd_2, rd_3, rd_4;

    @FXML

    public void initialize(URL location, ResourceBundle resources) {

    }


    private Label label;

    @FXML
    public void handlebuttonaction(ActionEvent event) throws IOException {
        if (event.getSource() == btn_signin) {
            pn_signin.toFront();
            pn_register.toBack();
            pn_results.toBack();
            pn_verify.toBack();
            fild_authority.clear();
            lb_ip.setText("");
            clearregfields();
            //pn_mainmenu.toBack();
        } else if (event.getSource() == btn_register) {

            pn_register.toFront();
            pn_signin.toBack();
            pn_results.toBack();
            fild_authority.clear();
            pn_register.setDisable(true);
            pn_verify.toFront();
            clearloginfields();
            lb_get.setText("");
            lb_invalid.setText("");



            }
            else if (event.getSource()==btn_attack){

            if (fild_authority.getText().equals("24asd987")) {

                pn_register.setDisable(false);
                pn_verify.toBack();
                lb_verify.setText("");
        }
        else {
                lb_verify.setText("Wrong Passcode");
            }
            //   pn_mainmenu.toBack();

        } else if (event.getSource() == btn_mainmenu) {
           // pn_mainmenu.toFront();
            fild_authority.clear();
            pn_verify.toBack();
            clearloginfields();
            clearregfields();


        } else if (event.getSource() == btn_results) {
            pn_results.toFront();
            pn_register.toBack();
            pn_signin.toBack();
            fild_authority.clear();
            clearloginfields();
            clearregfields();
        } else if (event.getSource() == btn_login) {
            pn_castevote.toFront();
        }else if (event.getSource() == rd_1) {
            rd_2.setSelected(false);
            rd_3.setSelected(false);
            rd_4.setSelected(false);
        } else if (event.getSource() == rd_2) {
            rd_1.setSelected(false);
            rd_3.setSelected(false);
            rd_4.setSelected(false);
        } else if (event.getSource() == rd_3) {
            rd_2.setSelected(false);
            rd_1.setSelected(false);
            rd_4.setSelected(false);
        } else if (event.getSource() == rd_4) {
            rd_2.setSelected(false);
            rd_3.setSelected(false);
            rd_1.setSelected(false);
        } else if (event.getSource() == btn_cast) {
            Vote vote = new Vote();
            if (rd_1.isSelected()) {
                vote.vote1("3");
                int[]meg=getresults();
                vote.mna3=(meg[0]+1);
                vote.mna2=meg[1];
                vote.mna4=meg[2];
                vote.mna1=meg[3];
                Addresults(vote.mna3,vote.mna2,vote.mna4,vote.mna1);
                int[] mine=getresults();
                lb_im.setText(String.valueOf(vote.mna1)+" Votes");
                lb_fz.setText(String.valueOf(vote.mna4)+" Votes");
                lb_na.setText(String.valueOf(vote.mna2)+" Votes");
                lb_bl.setText(String.valueOf(vote.mna3)+" Votes");
            } else if (rd_2.isSelected()) {
                vote.vote1("2");
                int[]meg=getresults();
                vote.mna3=meg[0];
                vote.mna2=(meg[1]+1);
                vote.mna4=meg[2];
                vote.mna1=meg[3];
                System.out.println(meg[0]+" "+meg[1]+" "+meg[2]+" "+meg[3]);
                Addresults(vote.mna3,vote.mna2,vote.mna4,vote.mna1);

                int[] mine=getresults();
                System.out.println(mine[0]+" "+mine[1]+" "+mine[2]+" "+mine[3]);
                System.out.println(vote.mna3+" "+vote.mna2+" "+vote.mna4+" "+vote.mna1);
                lb_im.setText(vote.mna1+" Votes");
                lb_fz.setText(vote.mna4+" Votes");
                lb_na.setText(vote.mna2+" Votes");
                lb_bl.setText(vote.mna3+" Votes");
            } else if (rd_3.isSelected()) {
                vote.vote1("4");
                int[]meg=getresults();
                vote.mna3=meg[0];
                vote.mna2=meg[1];
                vote.mna4=(1+meg[2]);
                vote.mna1=meg[3];

                Addresults(vote.mna3,vote.mna2,vote.mna4,vote.mna1);
                int[] mine=getresults();
                lb_im.setText(String.valueOf(vote.mna1)+" Votes");
                lb_fz.setText(String.valueOf(vote.mna4)+" Votes");
                lb_na.setText(String.valueOf(vote.mna2)+" Votes");
                lb_bl.setText(String.valueOf(vote.mna3)+" Votes");
            } else if (rd_4.isSelected()) {
                vote.vote1("1");
                int[]meg=getresults();
                vote.mna3=meg[0];
                vote.mna2=meg[1];
                vote.mna4=meg[2];
                vote.mna1=(1+meg[3]);
                System.out.println(meg[0]+" "+meg[1]+" "+meg[2]+" "+meg[3]);
                Addresults(vote.mna3,vote.mna2,vote.mna4,vote.mna1);
                int[] mine=getresults();
                lb_im.setText(String.valueOf(vote.mna1)+" Votes");
                lb_fz.setText(String.valueOf(vote.mna4)+" Votes");
                lb_na.setText(String.valueOf(vote.mna2)+" Votes");
                lb_bl.setText(String.valueOf(vote.mna3)+" Votes");
            }
            pn_options.toFront();
            pn_main.toFront();

            pn_mainmenu.toFront();
            pn_castevote.toBack();
            lb_welcome.toFront();
        } else if (event.getSource() == btn_reg) {
            fild_authority.clear();

           // Registration registration = new Registration();
            //registration

        }
    }






//    public void handle(KeyEvent keyEvent){
//        if (keyEvent.getKeyCode()== KeyCode.ENTER){
//
//        }
//        else {
//            lb_verify.setText("Wrong Passcode");
//        }
//    }
    @FXML
    public void Exit(){
        System.exit(0);
    }
    @FXML
    public void login(ActionEvent event)throws Exception{
        String name = field_user.getText();
        String cnic = field_CNIC.getText();
        String pass = field_pass.getText();
        if(name.length() != 0 && cnic.length()==13 && pass.length()!=0){
            String filename = "Voterslist.txt";
            try {

                String[] lines = readLines(filename);
                String ID=name+cnic+pass;
                for (String line : lines) {
                    lb_ip.setText("");
                    if (ID.equals(line)) {
                        System.out.println("Login successful!");
                        Vote v1=new Vote();
                        v1.RV(filename, ID);
                        pn_castevote.toFront();
                        clearloginfields();



                    }
                    else if (!(ID.equals(line))) {
                       // System.out.println("Invalid user.");
                        lb_ip.setText("Invalid User");
                    }
                }
                if (lines.length==0){
                    lb_ip.setText("Invalid User");
                }

            } catch (IOException e) {
                // Print out the exception that occurred
                System.out.println("Unable to create " + filename + ": " + e.getMessage());
            }

}

            //try catch block for login
//            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
//                String line;
//                while ((line = br.readLine()) != null) {
//                    if (name+cnic+pass==line) {
//                        System.out.println("Login successful!");
//                        Vote v1 = new Vote();
//
//                        v1.RV(filename,name+cnic+pass);
//                        clearloginfields();
//                        pn_castevote.toFront();
//
//                    }
//
////                    else if ((name+cnic+pass)!=line) {
////                        System.out.println("Invalid user.");
////                        // MainMenu mm = new MainMenu();
////                    }
//                }
//                System.out.println("Invalid User");
//                }
//
//            catch (IOException e) {
//                // Print out the exception that occurred
//                System.out.println("Unable to create " + filename + ": " + e.getMessage());
//            }
        else {


            lb_ip.setText("Login failed/Invalid Data");
        }
    }
    @FXML
    public void Registration() throws IOException {
        String name = fild_user.getText();
        String cnic = fild_CNIC.getText();
        String pass = fild_pass.getText();
        if(name.length() != 0 && cnic.length()==13 && pass.length()!=0){
            lb_invalid.setText("");
            clearregfields();
            clearloginfields();

            File file=new File("CNICList.txt");
            if (file.exists() && !file.isDirectory()){

            try {

                String[] lines = readLines("CNICList.txt");
                boolean me=true;
                for (String line : lines) {
                    System.out.println("done");
                    if (cnic.equals(line)) {
                        lb_get.setText("CNIC already registered.");
                        System.out.println("done1");
                        me=false;
                    }

                }
                 if (me) {
                    Addvoters(name+cnic+pass+"\n",cnic+"\n");
                    pn_mainmenu.toFront();
                }

            } catch (IOException e) {
                // Print out the exception that occurred
                System.out.println("Unable to create " + "CNICList.txt" + ": " + e.getMessage());
            }
            }
            else {
                Addvoters(name+cnic+pass+"\n",cnic+"\n");
            }
//Addvoters(name+cnic+pass+"\n",cnic+"\n");
  //      System.out.println(name+cnic+pass);


        }
    else {
           lb_invalid.setText("Invalid data");
        }
    }
    public void Addresults(int result, int result1, int re, int r) throws IOException {
        String name="Results.txt";
        File file=new File(name);
        FileWriter out=null;
        BufferedWriter ou=null;
        if (file.exists() && !file.isDirectory()) {
         out=new FileWriter(new File(name),false);
         out.write(result+"\n"+result1+"\n"+re+"\n"+r);
        }
        else {
            out=new FileWriter(name);
        }

        out.close();
    }
    public int[] getresults() throws IOException {
        FileReader fileReader = new FileReader("Results.txt");

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int[] mine=new int[7];
        String line = null;
int i=0;
        while ((line = bufferedReader.readLine()) != null)
        {
            mine[i]= Integer.parseInt(line);
            i++;
        }

        bufferedReader.close();

        return mine;
    }

    @FXML
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
    @FXML
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

public void clearloginfields(){
        field_user.clear();
        field_CNIC.clear();
        field_pass.clear();
}
    public void clearregfields(){
        fild_user.clear();
        fild_CNIC.clear();
        fild_pass.clear();
    }

}
