
import java.math.BigDecimal;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Thomas
 */
public class ShoppingCart {
    
    public static int productsInCart = 0;  /*number of products in cart*/
    public static Product[] content = new Product[100]; /*array of products in cart*/
    //private static double totalSalesTax;
    
    
    public static Product addProduct() { /*starts the process to add a product to the shoppingcart*/
        String productName;
        int productType;
        boolean exempt = false;
        boolean imported = false;
        //float productPrice;
        BigDecimal productPrice = new BigDecimal("0.00");
        String input;
        
    System.out.println("\nEnter the name of the product:\n");
    Receipt.input.nextLine(); //consumes the rest of the line
    productName = Receipt.input.nextLine();
    while(true){
    System.out.println("\nChoose the type of product:\n1 book\n2 food\n3 medical product\n4 others\n");
    productType = Receipt.input.nextInt();     
    switch(productType){
        case 1:
            exempt = true;
            break;
        
        case 2:
            exempt = true;
            break;
        
        case 3:
            exempt = true;
            break;
            
        case 4:
            exempt = false;
            break;
        default:
            System.out.println("Error: invalid answer!");
            continue;
        }
        break;
    }
    Receipt.input.nextLine(); //consumes the rest of the line
    while(true){
        System.out.println("\nHas the product been imported?\n");
        Receipt.input.nextLine(); //consumes the rest of the line
        input = Receipt.input.nextLine();
        switch(input){
            case "yes":
                imported = true;
                break;
            case "no":
                imported = false;
                break;
        default:
            System.out.println("Error: invalid answer!");
            continue;
        }
        break;
    }
    System.out.println("Please enter the product's price.\n");
    productPrice = Receipt.input.nextBigDecimal();
    
    Product newProduct = new Product(productName, exempt, imported, productPrice);
    //System.out.println("product has been created");
    return newProduct;
    }
    
    public String createReceipt(Product[] inCart){
        String receiptOutput = "";
        for (Product cartContent : inCart) {
            if(cartContent == null) //break the loop if next array element is null)
                break;
            receiptOutput += cartContent.buildString() + "\n";
            //System.out.println("added:" + cartContent.buildString() + "to the receipt."); //for debugging
        }        
        return receiptOutput;
    }
    
    public BigDecimal calcTotalSalesTax(Product[] inCart){ /* iterates over the shoppingCart content array and adds up the sales tax for each product*/
        BigDecimal totalSalesTax = new BigDecimal("0.00");
        for (Product cartContent : inCart) {
            if(cartContent == null) //break the loop if next array element is null)
                break;
            totalSalesTax.add(cartContent.calculateSalesTax());
        }
        return totalSalesTax;
    }
    
    public BigDecimal calcTotal(Product[] inCart) {
        BigDecimal total = new BigDecimal("0.00");
        for (Product cartContent : inCart) {
            if(cartContent == null) //break the loop if next array element is null)
                break;
            total = total.add(cartContent.calculateFinalPrice());
        }
        return total;
    }
    
    
    /*
    public static void removeProduct() {
    }
    */
}
