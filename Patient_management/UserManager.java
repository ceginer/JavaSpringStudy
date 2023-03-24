package Patient_management;

import java.rmi.server.UID;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class UserManager {
    List<User> userList = new ArrayList<>();

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
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println("Please login");
            System.out.println("ID:");
            String ID = in.next();
            System.out.println("Password:");
            String PW = in.next();
            User loginUser = new User(ID, PW);

            // toString 이 아닌 클래스의 id,pw 대조하고 싶었는데 어떻게 할지를 몰라서 이렇게 했습니다ㅜㅜ
            if (userList.get(0).toString().equals(loginUser.toString())) {
                do {
                    System.out.println("Login success, input 1 to continue");
                } while (in.nextInt() != 1);
                break;
                // ++ 메인페이지로 이동
            } else {
                do {
                    System.out.println("Login failed, input 1 to continue");
                } while (in.nextInt() != 1);
                //처음으로 돌아가서 반복
            }
        }
    }
}
