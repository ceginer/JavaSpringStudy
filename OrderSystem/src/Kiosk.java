package OrderSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Kiosk implements KioskInterface {
    public Menu[] menus = new Menu[3];
    @Override
    public void menuSetting() {
        menus[0] = new Menu("Pizza","2000원",3);
        menus[1] = new Menu("Chicken","3000원",6);
        menus[2] = new Menu("Salad","6000원",1);
        System.out.println(Arrays.toString(menus));
    }

    @Override
    public void menuOutput() {
        System.out.println("======= Ceginer Order Kiosk =======");
        System.out.println("Menu-----Name----Price----remaining");
        // menu 클래스에 있는 필드의 nam,price
        for (int i =0; i < menus.length; i++){
            System.out.println("  "+(i+1)+"       "+menus[i].name+"     "+menus[i].price+"     "+menus[i].quantity);
            }
        System.out.println("===================================");

        }

    @Override
    public Menu orderInput() throws Exception{
        while (true) {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("What do you want to eat?");
                String input = in.readLine();
                for (Menu menuList : menus) {
                    if (menuList.name.equalsIgnoreCase(input)) { // 다른 클래스의 필드를 불러오는 경우에는 equals() 를 통해 같음을 비교한다.
                        if (menuList.quantity > 0){
                            menuList.quantity = menuList.quantity - 1;
                            return menuList;
                        } else if (menuList.quantity <= 0){
                            throw new Exception("죄송합니다, 재고가 다 떨어졌네요, 다른걸 시키시겠어요?");
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
    public void orderOutput(Menu orderMenu) {
        System.out.println("주문하신 메뉴는 "+ orderMenu.name);
        System.out.println("접수가 완료되었습니다!");
    }
}
