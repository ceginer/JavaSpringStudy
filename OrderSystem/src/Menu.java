package OrderSystem;

public class Menu {
    public String name;
    public String price;
    public int quantity;

    @Override
    public String toString() {
        return "Menu{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    public Menu(String name, String price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
