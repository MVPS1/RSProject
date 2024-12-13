
package rsproject;


public class Order {
    
    private String id;
    private String name;
    private float price;
    
    
    public Order(String id, String name, float price)
    {
        this.id = id;
        this.name = name;
        this.price = price;
        
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }
}
