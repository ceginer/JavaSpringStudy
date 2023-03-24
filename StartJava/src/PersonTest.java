public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person();

        p1.name = "홍길동"; // 스트링은 따로 인스턴스를 안 받고도 실행가능
        p2.name = "조조";

        System.out.println(p1.count); // static 필드 불러옴
        p1.count++; // 1회 증가
        System.out.println(p1.name);
        System.out.println(p1.address);
        System.out.println(p1.isVip);
    }
}
