package OrderSystem;

import java.util.Scanner;

public class OrderMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Kiosk kiosk = new Kiosk();
        kiosk.menuSetting();
        String inputNext;
        do {
            kiosk.menuOutput();
            try {
                Menu inputMenu = kiosk.orderInput();
                kiosk.orderOutput(inputMenu);
            } catch (Exception noMore){
                System.out.println(noMore.getMessage());
            }
            System.out.println("혹시 더 시키실 것이 있다면 1 을 눌러주세요!");
            System.out.println("더 시키실 것이 없다면 아무 키나 눌러주세요");
            inputNext = in.next();
        } while (inputNext.equals("1"));


    }



}
