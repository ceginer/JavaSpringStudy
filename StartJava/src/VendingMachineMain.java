public class VendingMachineMain {
    public static void main(String[] args) {
        VendingMacine.printVersion(); // static 한 메소드는 레퍼런스 변수명.static 메소드()
        VendingMacine vm1 = new VendingMacine();
        VendingMacine vm2 = new VendingMacine();

        String product = vm1.pushProjectButton(100);
        System.out.println(product);
    }
}
