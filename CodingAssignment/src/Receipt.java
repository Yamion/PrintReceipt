
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import javax.xml.transform.OutputKeys;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Thomas
 */
public class Receipt {

    private static void printReceipt(ShoppingCart cart) {
    System.out.println("Your shopping receipt:\n");
    System.out.println(cart.createReceipt(cart.content));
    System.out.println("Sales Taxes: " + cart.calcTotalSalesTax(cart.content) + "\n");
    System.out.println("Total: " + cart.calcTotal(cart.content));
        
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
    while(true){
    System.out.println("Please select an action: \n1 Add product to cart\n2 Remove product from cart\n3 Print receipt.\n" ); /*command line User interface*/
    int option = input.nextInt();
    switch(option) {
        case 1 -> {
            ShoppingCart.content[ShoppingCart.productsInCart] = ShoppingCart.addProduct();
            ShoppingCart.productsInCart++;
            //cart.addProduct();
            continue;
            }
        case 2 -> {
            System.out.println("Action not yet implemented!");
            //ShoppingCart.removeProduct();
            continue;
            }
        case 3 -> {
            Receipt.printReceipt(cart);
            continue;
            }
        default -> {
                System.out.println("Error: Undefined action!");
                continue;
            }
        }
    }
    
            

    //System.out.println("You have chosen option " + option);

    }
    
}
