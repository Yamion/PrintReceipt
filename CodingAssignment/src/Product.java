
import java.math.BigDecimal;
import java.math.RoundingMode;




/**
 *
 * @author Thomas
 */
public class Product {
    
    public static int productCounter = 0;
    
    public String name = "";
    private boolean imported = false;
    private boolean exempt = false; /* true for books, food, medical products*/
    //private float priceNoTax = 0.0f;
    private BigDecimal priceNoTax = new BigDecimal("0.00");
    private String productString = "";
    //private BigDecimal tax = new BigDecimal(0.00);
    private BigDecimal salesTax = new BigDecimal("0.00");
    /*default parameters for Product*/

    public Product(){
        productCounter++;
            /*default constructor*/
        }
    
    /*constructor for class Product*/
    public Product(String productName, boolean exempt, boolean imported, BigDecimal price){
        this.name = productName;
        this.exempt = exempt;        
        this.imported = imported;
        this.priceNoTax = price;
        this.productString = "";
        productCounter++;

    }
    
    /* returns the current number of products in the shopping cart*/
    public static int numberOfProducts() {
        return productCounter;
    }
    
    /*sets the tax for the product*/
    public BigDecimal setTax(){ 
        BigDecimal tax = new BigDecimal("0.00");
        switch(exempt + "-" + imported){
            case "true-true" -> {
                tax = new BigDecimal("0.05");
                return tax;
            }
            case "true-false" -> {
                tax = new BigDecimal("0.00");
                return tax;
            }
            case "false-false" -> {
                tax = new BigDecimal("0.10");
                return tax;
            }
            case "false-true" -> {
                tax = new BigDecimal("0.15");
                return tax;
            }
            default -> throw new RuntimeException(
                    "something went wrong with the import/exempt check, exempt:" + exempt + ", imported: " + imported); 
        }
    }
    
    /*calculates the final price with rounded salestax for the Product*/
    public BigDecimal calculateFinalPrice(){ 
        salesTax = this.priceNoTax.multiply(setTax());
        salesTax = this.roundTax(salesTax);
        BigDecimal finalPrice = new BigDecimal("0.00");
        finalPrice = this.priceNoTax.add(salesTax);
        return finalPrice;
    }
    
    /*builds the output string for the product*/
    public String buildString() { 
        if(this.imported == false) {
        this.productString = "1 " + this.name + ": " + this.calculateFinalPrice() +"\n";
        return this.productString;
        }
        else {
        this.productString = "1 imported " + this.name + ": " + this.calculateFinalPrice() +"\n";    
        return this.productString;
        }
        
    }
    
    /*calculates the sales tax for the Product object*/
    public BigDecimal calculateSalesTax(){ 
        return this.priceNoTax.multiply(setTax());
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
    
}