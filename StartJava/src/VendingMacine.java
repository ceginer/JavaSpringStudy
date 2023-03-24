public class VendingMacine {
    //field (가지는 것들)
    //생성자
    //method (할수 있는 것들)
    public String pushProjectButton(int manuID){
        System.out.println(manuID + "를 전달받았습니다");
        return "콜라";
    }
    public static void printVersion(){
        System.out.println("v1.1");
    }
}
