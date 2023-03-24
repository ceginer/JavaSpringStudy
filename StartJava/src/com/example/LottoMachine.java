package com.example;
/*
1. 1~45 까지 써있는 ball을 로또 기계에 넣기
2. 로또 기계에 Ball을 섞고
3. 섞인 Ball 중에 6개 꺼내기
 */

public interface LottoMachine {
    int Max_Ball_Count = 45; // 이거 바꾸면 전체 공 수
    int Return_Ball_Count = 6;
    public abstract void setBalls(Ball[] balls); // alt+enter 로 필요한 클래스 바로 만들기
    public void mix(); //
    public Ball[] getBalls();
}
