public class CarExam {
    public static void main(String[] args) {
        Bus b1 = new Bus(); // Bus는 Car 을 상속받음 (참조 중)
        b1.run(); // 오버라이딩 된 자식의 후륜구동이다 로 나옴
        b1.안내방송(); // Bus 의 메소드

        Car c1 = new Bus(); // 버스는 자동차다(상속), 버스는 후륜구동이다 (오버라이딩)
        c1.run(); // 그럼 자식인 버스는 후륜구동이다로 나타남
//        c1.안내방송(); // 컴파일 에러 --> 이것도 쓰고 싶어!

        Bus b2 = (Bus)c1;
        b2.안내방송();

        Car c2 = new SuperCar(); //
        c2.run();
    }
}

