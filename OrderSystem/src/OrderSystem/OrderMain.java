package OrderSystem;

import java.util.Scanner;
public class OrderMain {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Kiosk kiosk = new Kiosk();
        kiosk.menuSetting();
        String inputNext;
        do {
            // 메인 메뉴표시
            kiosk.menuOutput();
            // 메인 메뉴주문 받기
            Menu inputBasicMenu = kiosk.orderInput();
            // 토핑 추가할 것인지 주문 받기
            Topping inputToppingMenu = kiosk.toppingIO();
            if ( inputToppingMenu != null){
                // 토핑 추가 있을 경우에는 메인 주문 + 토핑 주문으로 주문 내역 출력
                Menu totalMenu = new Topping(inputBasicMenu, inputToppingMenu);
                kiosk.orderOutput(totalMenu);
            } else if ( inputToppingMenu == null){
                // 토핑 추가 없을 경우에는 메인 주문으로 주문 내역 출력
                Menu totalMenu = new Topping(inputBasicMenu, null);
                kiosk.orderOutput(totalMenu);
            }
            //토핑입력받고 처리.
            System.out.println("혹시 더 시키실 것이 있다면 1 을 눌러주세요!");
            System.out.println("더 시키실 것이 없다면 아무 키나 눌러주세요");
            inputNext = in.next();
        } while (inputNext.equals("1"));

    }

}
