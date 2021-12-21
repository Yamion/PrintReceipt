/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Thomas
 */
public class ShoppingCart {
    
    private static int productsInCart;
    private static Product[] content = {};
    /**
     * @param args the command line arguments
     */
    
    
    public static void addProduct() {
        String productName;
        int productType;
        boolean exempt;
        boolean imported;
        float productPrice;
        String input;
        
    System.out.println("Enter the name of the product:\n");
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
    System.out.println("Has the product been imported?");
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
    
    content[Product.productCounter] = new Product();
    }
    
    public static void removeProduct() {
    }
}
