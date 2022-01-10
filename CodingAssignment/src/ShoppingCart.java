

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

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
        case 1 -> exempt = true;
        
        case 2 -> exempt = true;
        
        case 3 -> exempt = true;
            
        case 4 -> exempt = false;
        default -> {
                System.out.println("Error: invalid answer!");
                continue;
                }
        }
        break;
    }
    Receipt.input.nextLine(); //consumes the rest of the line
    while(true){
        System.out.println("\nHas the product been imported?\n");
        input = Receipt.input.nextLine();
        switch(input){
            case "yes" -> imported = true;
            case "no" -> imported = false;
        default -> {
                System.out.println("Error: invalid answer!");
                continue;
                }
        }
        break;
    }
    System.out.println("\nPlease enter the product's price.(e.g. 1,99)\n");
    productPrice = Receipt.input.nextBigDecimal();
    
    Product newProduct = new Product(productName, exempt, imported, productPrice);
    //System.out.println("product has been created");
    return newProduct;
    }
    
    /*builds the output String for all products in the cart */
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
    
    /* iterates over the shoppingCart content array and adds up the sales tax for each product*/
    public BigDecimal calcTotalSalesTax(Product[] inCart){ 
        BigDecimal totalSalesTax = new BigDecimal("0.00");
        for (Product cartContent : inCart) {
            if(cartContent == null) //break the loop if next array element is null)
                break;
            totalSalesTax = totalSalesTax.add(cartContent.calculateSalesTax());
        }
        totalSalesTax = this.roundTax(totalSalesTax);
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
    
    /*rounding the tax up to 0.05 */
    public BigDecimal roundTax(BigDecimal input){
        BigDecimal rounded = input.setScale(2, RoundingMode.HALF_UP);
        BigDecimal moved = rounded.movePointRight(2);
        BigDecimal remainder = moved.remainder(BigDecimal.TEN);
        if(remainder.equals(new BigDecimal("0")))
            return rounded;
        if(remainder.equals(new BigDecimal("1"))){
            moved=moved.add(new BigDecimal("4"));
            moved=moved.movePointLeft(2);
            return moved;
        }
        if(remainder.equals(new BigDecimal("2"))){
            moved=moved.add(new BigDecimal("3"));
            moved=moved.movePointLeft(2);
            return moved;            
        }
        if(remainder.equals(new BigDecimal("3"))){
            moved=moved.add(new BigDecimal("2"));
            moved=moved.movePointLeft(2);
            return moved;
        }
        if(remainder.equals(new BigDecimal("4"))){
            moved=moved.add(new BigDecimal("1"));
            moved=moved.movePointLeft(2);
            return moved;            
        }
        if(remainder.equals(new BigDecimal("5"))){
            return rounded;
        }
        if(remainder.equals(new BigDecimal("6"))){
            moved=moved.add(new BigDecimal("4"));
            moved=moved.movePointLeft(2);
            return moved;            
        }
        if(remainder.equals(new BigDecimal("7"))){
            moved=moved.add(new BigDecimal("3"));
            moved=moved.movePointLeft(2);
            return moved;            
        }
        if(remainder.equals(new BigDecimal("8"))){
            moved=moved.add(new BigDecimal("2"));
            moved=moved.movePointLeft(2);
            return moved;            
        }
        if(remainder.equals(new BigDecimal("9"))){
            moved=moved.add(new BigDecimal("1"));
            moved=moved.movePointLeft(2);
            return moved;            
        }
        else
            System.out.println("Error in roundTax!!!");
            return input;
    }

      
            
        
    
    
    /* remove a product from the shopping cart */
    public static void removeProduct() {
        int counter = 0;
        System.out.println("Choose which product to remove:");
        for (Product cartContent : content) {
            if(cartContent == null) //break the loop if next array element is null)
                break;
            System.out.println(counter+1 + ": " + cartContent.name);
            counter++;
        }
        int option = Receipt.input.nextInt();
        for(int i = option; i < productsInCart; i++){
            content[i-1] = content[i];
        }
        content[productsInCart-1] = null;
        
                
    }
    
    
    
}
