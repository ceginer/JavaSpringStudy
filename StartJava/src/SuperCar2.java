public class SuperCar2 extends Car2{
    public SuperCar2(){
        super("SuperCar@@");
    }

    @Override
    public void run() {
        System.out.println("사륜구동으로 작동");
    }
}
