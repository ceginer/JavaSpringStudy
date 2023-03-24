public class MathBeanTest {
    public static void main(String[] args){
        MathBean math = new MathBean(); // 인스턴스는 heap 메모리로 올라감

        math.printClassName(); // 메소드 호출
        math.printNumber(5000);
        int x = math.getOne();
        System.out.println(x);
        int value = math.plus(200,300);
        System.out.println(value);
    }
}
