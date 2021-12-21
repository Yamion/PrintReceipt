


/**
 *
 * @author Thomas
 */
public class Product {
    
    public static int productCounter;
    
    private String name = "";
    private boolean imported = false;
    private boolean exempt = false; /* true for books, food, medical products*/
    private double priceNoTax = 0.0;
    /*default parameters for Product*/

    public Product(){
        productCounter++;
            /*default constructor*/
        }
    
    public Product(String productName, boolean imported, boolean exempt, float price){
        this.name = productName;
        this.imported = imported;
        this.exempt = exempt;
        this.priceNoTax = price;
        productCounter++;
        /*constructor for class Product*/
    }
    
    public static int numberOfProducts() {
        return productCounter;
    }
    
    
    
}