


/**
 *
 * @author Thomas
 */
public class Product {
    
    public static int productCounter = 0;
    
    private String name = "";
    private boolean imported = false;
    private boolean exempt = false; /* true for books, food, medical products*/
    private float priceNoTax = 0.0f;
    private String productString = "";
    private double tax = 0.00;
    /*default parameters for Product*/

    public Product(){
        productCounter++;
            /*default constructor*/
        }
    
    public Product(String productName, boolean exempt, boolean imported, float price){
        this.name = productName;
        this.exempt = exempt;        
        this.imported = imported;
        this.priceNoTax = price;
        this.productString = "";
        productCounter++;
        /*constructor for class Product*/
    }
    //public String
    
    
    public static int numberOfProducts() {
        return productCounter;
    }
    
    public double setTax(){ /*sets the tax for the product*/
        switch(exempt + "-" + imported){
            case "true-true" -> {
                tax = 0.05;
                return tax;
            }
            case "true-false" -> {
                tax = 0.00;
                return tax;
            }
            case "false-false" -> {
                tax = 0.10;
                return tax;
            }
            case "false-true" -> {
                tax = 0.15;
                return tax;
            }
            default -> throw new RuntimeException(
                    "something went wrong with the import/exempt check, exempt:" + exempt + ", imported: " + imported); 
        }
    }
    
    public double calculateFinalPrice(){ /*calculates the final price with tax for the Product object*/
        double finalPrice = this.priceNoTax;
        double salesTax = 0.00f;
        salesTax = setTax()*this.priceNoTax;
        finalPrice += salesTax;
        return finalPrice;
    }
    
    public String buildString() { /*builds the String output for the Product object*/
        if(this.imported == false) {
        this.productString = "1 " + this.name + ": " + this.calculateFinalPrice() +"\n";
        }
        else {
        this.productString = "1 imported " + this.name + ": " + this.calculateFinalPrice() +"\n";    
        }
        return this.productString;
    }
    
    public double calculateSalesTax(){ /*calculates the sales tax for the Product object*/
        double finalPrice = this.priceNoTax;
        double salesTax = setTax()*this.priceNoTax; 
        return salesTax;
    }    
    
    
    
}