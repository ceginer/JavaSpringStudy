package com.example;

public class LottoMachineMain {
    public static void main(String[] args) {
        // LottoMachine 인스턴스가 생성된다.
        LottoMachine lottoMachine = new LottoMachineImpl();

        Ball[] balls = new Ball[45];
        for(int i=1; i<45; i++){
            balls[i] = new Ball(i+1);
        }

        lottoMachine.setBalls(balls);
        lottoMachine.mix();
        Ball[] result = lottoMachine.getBalls();

        for(int i=0; i< result.length; i++){
            System.out.println(result[i].getNumber());
        }
    }
}