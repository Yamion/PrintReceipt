
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import javax.xml.transform.OutputKeys;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Thomas
 */
public class Receipt {

    private static void printReceipt() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    private String receiptOutput;
    private String content;
    public static Scanner input = new Scanner(System.in);
    
    
    
    public static void main(String[] args) {
        /*  TODO    get user Input
                    create Product objects with user input
                    put objects in array
                    calculate tax
                    create String 
                    output String
        */
    ShoppingCart cart = new ShoppingCart();
    System.out.println("Please select an action: \n1 Add product to cart\n2 Remove product from cart\n3 Print receipt.\r" ); /*command line User interface*/
    int option = input.nextInt();
    switch(option) {
        case 1:
            ShoppingCart.addProduct();
        case 2:
            //ShoppingCart.removeProduct();
        case 3:
            Receipt.printReceipt();
        
        default:
            System.out.println("Error: Undefined action!");
                                break;
    }
    
    
            

    //System.out.println("You have chosen option " + option);

    }
    
}
