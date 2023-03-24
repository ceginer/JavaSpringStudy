package OrderSystem;


/*
메뉴 키오스크의 기능들
0. 상품메뉴 세팅
1. 상품메뉴 출력
2. 입력받기
3. 입력받은 상품 (quantity - 1)
4. 주문 내역 출력
*/
public interface KioskInterface {
    public void menuSetting(); // Menu 클래스에 이름,가격,수량을 정하는 것은 마치 글자를 새기는 것과 같으므로 parameter 가 필요하다.
    public void menuOutput(); // 하지만 각인된 글자가 새겨진, 즉 정보가 이미 새겨진 Menu클래스를 출력만 하는 것이므로 parameter는 필요 없다.
    public abstract Menu orderInput() throws Exception;
    public abstract void orderOutput(Menu totalMenu);
}
