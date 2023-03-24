public class Car2Exam02 {
    public static void main(String[] args) {
//        Car2 c2 = new Car2();   #Car은 추상클래스로 본인을 인스턴스로 가질 수 없음.
        Bus2 b2 = new Bus2();
        b2.run();

        Car2 c2 = new SuperCar2();
        c2.run();

    }
}
