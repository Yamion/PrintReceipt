/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Thomas
 */
public class ShoppingCart {
    
    private static int productsInCart;  /*number of products in cart*/
    private static Product[] content = {}; /*array of products in cart, to make them removable in the future*/
    private static double totalSalesTax;
    
    
    public static void addProduct() {
        String productName;
        int productType;
        boolean exempt;
        boolean imported = false;
        float productPrice;
        String input;
        
    System.out.println("Enter the name of the product:\r");
    productName = Receipt.input.nextLine();
    System.out.println("Choose the type of product:\n1 book\n2 food\n3 medical product\4 others\r");
    productType = Receipt.input.nextInt();
    switch(productType){
        case 1:
            exempt = true;
        case 2:
            exempt = true;
        case 3:
            exempt = true;
        default:
            exempt = false;
        break;
    }
    System.out.println("Has the product been imported?\r");
    input = Receipt.input.nextLine();
    switch(input){
        case "yes":
            imported = true;
        case "no":
            imported = false;
        default:
            System.out.println("Error: invalid answer!");
        break;
    }
    System.out.println("Please enter the product's price.\r");
    productPrice = Receipt.input.nextFloat();
    
    content[Product.productCounter] = new Product(productName, exempt, imported, productPrice);
    productsInCart++;
    }
    
    public String createReceipt(){
        String receiptOutput = "";
        System.out.println(content);
        
        
        
        
        return receiptOutput;
    }
    
    public double calcTotalSalesTax(Product[] cartContent){
        double totalSalesTax = cartContent[1].calculateSalesTax();
        return totalSalesTax;
    }
    
    
    /*
    public static void removeProduct() {
    }
    */
}
