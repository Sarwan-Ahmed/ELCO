package sample;

public class Person {
    //person class

        static String ID;
        String name;
        String cnic;
        private String Password;

        //Constructor
        Person(String name,String cnic, String Password){
            this.name = name;
            this.cnic=cnic;
            this.Password=Password;
            ID=name+cnic+Password+"\n";
        }
        //setters and getters
        public String getName(){
            return name;
        }
        public void setName(String nm){
            name =nm;
        }
        public String getPassword(){
            return Password;
        }

        public void setPassword(String p){
            Password=p;
        }

        public String getCnic() {
            return cnic;
        }
        public void setCnic(String cnic) {
            this.cnic = cnic;
        }
    }

