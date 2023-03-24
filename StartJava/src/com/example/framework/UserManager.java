package com.example.framework;

import java.util.Scanner;

public class UserManager {
    public User addUser(){
        Scanner in = new Scanner(System.in);
        System.out.println("Please 회원가입 let's go");
        System.out.println("Please enter your ID");
        String ID = in.next();
        System.out.println("Please enter your PW");
        String PW = in.next();

        User user = new User(ID, PW);
        return user;

        //++ 리스트 배열에 uid 와 password 추가
    }
    public void login(){
        Scanner in = new Scanner(System.in);
        System.out.println("Please login");
        System.out.println("ID:");
        String ID = in.next();
        System.out.println("Password:");
        String PW = in.next();
//        if (배열 id,pw 가 맞으면){
//            System.out.println("Login success, input 1 to continue");
//            // ++ 메인페이지로 이동
//        } else {
//            System.out.println("Login filed, input 1 to continue");
//            //++ 처음으로 돌아가서 반복
//        }
    }
}
