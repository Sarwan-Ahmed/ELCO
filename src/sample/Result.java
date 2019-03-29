package sample;

public class Result {
    //Constructor
    public Result(){
        System.out.println("\n\t\t\tWelcome To Results Page");
        result();
    }

    //print votes of each party
    public static void result(){

        System.out.println("* PTI (Pakistan Tehreek-e-Insaf) "+Vote.mna1+" votes");
        System.out.println("* PMLN (Pakistan Muslim League (N)) "+Vote.mna2+" votes");
        System.out.println("* PPP (Pakistan Peoples Party) "+Vote.mna3+" votes");
        System.out.println("* JUI (Jamiat Ulema-e Islam) "+Vote.mna4+" votes");
    }
}
