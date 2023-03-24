public class Car {

    // 생성자
    public Car(){
        System.out.println("자동차 생성");
    }


    public void run(){
        System.out.println("움직인다");
    }
    public void moveBack(){
        System.out.println("Back");
    }

    // object 오버라이딩

    @Override
    public String toString() {
        return "자동차";
    }
}
