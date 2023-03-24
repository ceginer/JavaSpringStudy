package com.example.Main;

import com.example.util.Calculator;
public class CalculatorMain {
    public static void main(String[] args){
        Calculator cal = new Calculator();
        // import 사용했을 때는 그냥 Calculator 로 인스턴스 생성
        // util 의 Calculator
        int value = cal.plus(50,100);
        System.out.println(value);

        com.example.util2.Calculator cal2 = new com.example.util2.Calculator();
        // import 사용하지 않았을 때는 package 명까지 함께 적어 인스턴스 생성
        int value2 = cal2.divide(100, 50);
        System.out.println(value2);
    }
}
