public class Bus2 extends Car2{
    // 상속했는데 Car2 에는 기본생성자가 아닌 따로 생성자 지정했으므로 super 사용
    public Bus2(){
        super("Bus!!");
        System.out.println("Bus2 기본생성자");
    }

    @Override
    public void run() {
        System.out.println("후륜구동으로 동작");
    }
}
