/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Thomas
 */
public class Product {
    private String name = "";
    private boolean imported = false;
    private int type = 0;
    private double price = 0.0;
    /*default parameters for Product*/

    public Product(){
            /*default constructor*/
        }
    
    public Product(String name, boolean imported, int type, float price){
        this.name = name;
        this.imported = imported;
        this.type = type;
        this.price = price;
        /*constructor for class Product*/
    }
    
    
}