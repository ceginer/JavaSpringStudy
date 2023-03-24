package OrderSystem;

public class Topping extends Menu{
    Menu menu;

    private String name;
    private int price;
    public Topping(String name, int price){
        super();
        this.name = name;
        this.price = price;
    }

    public Topping(Menu mainMenu, Topping toppingMenu){
        super();
        this.menu = mainMenu;
        if (toppingMenu != null){
            this.name = toppingMenu.getName();
            this.price = toppingMenu.getPrice();
        }
    }

    public String presentMenu() {
        if (menu != null && this.name != null){
            return ("주문하신 메뉴는 " +  menu.presentMenu() + " 과 " + this.name + " 입니다.");
        }
        else if (menu == null && this.name != null){
            return ("주문하신 메뉴는 " + this.name + " 입니다.");
        }
        else if (menu != null && this.name == null){
            return ("주문하신 메뉴는 " + menu.presentMenu() + " 입니다.");
        } else {
            return ("주문하신 메뉴가 없습니다.");
        }

    }

    @Override
    public int presentPrice() {
        if (menu == null && this.price == 0){
            return 0;
        } else if (menu == null && this.price != 0) {
            return this.price;
        } else{
            return menu.presentPrice() + this.price;
        }

    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
