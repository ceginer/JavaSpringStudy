package Patient_management;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class MainEntry {
    public static void main(String[] args) {
        // usermanagement 인스턴스 생성 후, 새로운 uid pw 입력 받는 과정
        UserManager userManager = new UserManager();
        User userAdd1 = userManager.addUser();
        userManager.userList.add(userAdd1);

        // 회원 가입된 ID, PW 알려주기
        User user = userManager.userList.get(0);
        System.out.println("Your id : " + user.getUid() + ", Your pw : " + user.getPassword());

        //로그인
        userManager.login();
        PatientManager patientManager = new PatientManager();
        Scanner in = new Scanner(System.in);

        int breakKey = 0;
        // 메뉴 실행
        while(breakKey != 1) {
            int menuID = patientManager.managePatients(); // 실행되면서 return 되는 menuID 받음
            switch (menuID) {
                case 1:
                    patientManager.addPatient();
                    break;
                case 2:
                    patientManager.deletePatients();
                    break;
                case 3:
                    patientManager.updatePatients();
                    break;
                case 4:
                    patientManager.outputAllPatients();
                    break;
                case 5:
                    System.out.println("수고하셨슴돠~");
                    breakKey = 1;
                    break;
            }
        }

    }
}
