package billing;

public class Product {

    private static int lastGeneratedID=100;

    private final int id;
    private String name;
    private float price;
    private int quantity;

    public Product( String name, float price, int quantity) {
        this.id = lastGeneratedID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        lastGeneratedID++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
