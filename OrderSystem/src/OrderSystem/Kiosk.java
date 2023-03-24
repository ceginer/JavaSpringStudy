package OrderSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;
import java.util.Scanner;


public class Kiosk implements KioskInterface {
    public BasicMenu[] menus = new BasicMenu[3]; // 리스트는 저번에 썼기 때문에 배열로 한번 만들어보았음.
    public Topping[] toppings = new Topping[3]; // 리스트는 저번에 썼기 때문에 배열로 한번 만들어보았음.
    @Override
    public void menuSetting() {
        menus[0] = new BasicMenu("PizzaBurger",2000,3);
        menus[1] = new BasicMenu("ChickenBurger",30000,6);
        menus[2] = new BasicMenu("SaladBurger",6000,0);
        toppings[0] = new Topping("Pickle",1000);
        toppings[1] = new Topping("HotSource",500);
        toppings[2] = new Topping("PotatoChip",2000);
    }

    @Override
    public void menuOutput() {
        System.out.println("=========== Ceginer Order Kiosk ===========");
        System.out.println("========------- Main Menu ---------========");
        System.out.println("Menu------Name------------Price---remaining");
        for (int i =0; i < menus.length; i++){
            System.out.println("  "+(i+1)+"       "+menus[i].getName()+"        "+menus[i].getPrice()+"       "+menus[i].getQuantity());
            }
        System.out.println("===========================================");
        }

    public Topping toppingIO(){
        Scanner in = new Scanner(System.in);
        System.out.println("추가 토핑에는 이런 메뉴가 있어요~");
        while (true){
            System.out.println("======------ Topping --------======");
            System.out.println("Menu---------Name--------Price-----");
            for (int i =0; i < toppings.length; i++){
                System.out.println("  "+(i+1)+"          "+toppings[i].getName()+"        "+toppings[i].getPrice()+"     ");
            }
            System.out.println("===================================");
            System.out.println("추가를 원하시지 않으면 0을 눌러주시고, 원하시는 토핑메뉴가 있으면 메뉴이름을 적어주세요");
            String inputTopping = in.next();
            Optional<Topping> optional = Optional.empty();
            if(inputTopping.equals("0")){
                return null;
            } else {
                for (Topping toppingList : toppings) {
                    if (toppingList.getName().equalsIgnoreCase(inputTopping)) {
                        return toppingList;
                    }
                }
                System.out.println("There is no such thing in this Ceginer Kiosk");
                System.out.println("Please order one more time");

            }
        }
    }


    @Override
    public Menu orderInput(){
        while (true) {
            try {
                Menu[] nullArray = new Menu[1];
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("What do you want to eat?");
                String input = in.readLine();
                for (BasicMenu menuList : menus) {
                    if (menuList.getName().equalsIgnoreCase(input)) {
                        int remaining = menuList.getQuantity();
                        if (remaining > 0){
                            menuList.setQuantity(remaining - 1);
                            // topping 질문
                            return menuList;
                        } else if (remaining <= 0){
                            System.out.println("죄송합니다, 재고가 다 떨어졌네요, 다른걸 시키시겠어요?");
                            return null;
                        }
                    }
                }
                System.out.println("There is no such thing in this Ceginer Kiosk");
                System.out.println("Please order one more time");
            } catch (IOException e) {
                System.out.println("Error : " + e);
            }
        }
    }
    @Override
    public void orderOutput(Menu totalMenu) {
        System.out.println(totalMenu.presentMenu());
        System.out.println("주문하신 총 가격은 "+ (totalMenu.presentPrice())+" 원 입니다");
        System.out.println("접수가 완료되었습니다!");
    }

}
