package OrderSystem;

public class BasicMenu extends Menu{

    private String name;
    private int price;
    private int quantity;

    @Override
    public String presentMenu() {
        return this.name;
    }

    @Override
    public int presentPrice() {
        return this.price;
    }

    public BasicMenu(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "BasicMenu{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
