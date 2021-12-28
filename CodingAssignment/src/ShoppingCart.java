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
        float productPrice;
        String input;
        
    System.out.println("\nEnter the name of the product:\n");
    Receipt.input.nextLine(); //consumes the rest of the line
    productName = Receipt.input.nextLine();
    System.out.println("\nChoose the type of product:\n1 book\n2 food\n3 medical product\n4 others\n");
    productType = Receipt.input.nextInt();     
    switch(productType){
        case 1:
            exempt = true;
        //debug output   System.out.println("ProductType set to 1");
            break;
        
        case 2:
            exempt = true;
        //debug output   System.out.println("ProductType set to 2");
            break;
        
        case 3:
            exempt = true;
        //debug output    System.out.println("ProductType set to 3");
            break;
        default:
            exempt = false;
        //debug output    System.out.println("ProductType set to others");
            break;
    }
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
            break;
    }
    System.out.println("Please enter the product's price.\n");
    productPrice = Receipt.input.nextFloat();
    
    Product newProduct = new Product(productName, exempt, imported, productPrice);
    System.out.println("product has been created");
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
    
    public double calcTotalSalesTax(Product[] inCart){ /* iterates over the shoppingCart content array and adds up the sales tax for each product*/
        double totalSalesTax = 0.0f;
        for (Product cartContent : inCart) {
            if(cartContent == null) //break the loop if next array element is null)
                break;
            totalSalesTax += cartContent.calculateSalesTax();
        }
        return totalSalesTax;
    }
    
    public double calcTotal(Product[] inCart) {
        double total = 0.0f;
        for (Product cartContent : inCart) {
            if(cartContent == null) //break the loop if next array element is null)
                break;
            total += cartContent.calculateFinalPrice();
        }
        return total;
    }
    
    
    /*
    public static void removeProduct() {
    }
    */
}
