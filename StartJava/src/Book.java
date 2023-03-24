public class Book {
    private int price; // field price

    // private 를 불러내기 위해 setter, getter 필요 -> alt+insert
    // setter, getter 메소드를 프로퍼티(property)라고 함 -> price 프로퍼티라고 부름
    public int getPrice() {
        return this.price; // this는 내 자신 인스턴스 (필드) 참조하는 예약어
    }

    public void setPrice(int price) { //지역변수 price
        this.price = price;
    }

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
