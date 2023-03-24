public class MyMath {
    // 기본 생성자는 생성자가 없을 경우 컴파일할 때 자동으로 생성됨.
    public static int abs(int x){
        if(x < 0)
            return x * -1;
        else
            return x;
    }
}
