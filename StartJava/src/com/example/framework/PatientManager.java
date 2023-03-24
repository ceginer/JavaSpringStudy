package com.example.framework;

import java.util.Scanner;

public class PatientManager {
//    List patientList = new ArrayList<patient>() // 이런 식으로
    public void managePatients(){
        System.out.println("====Welcome to patient management system======");
        System.out.println("1 - Add patient");
        System.out.println("2 - Delete patient");
        System.out.println("3 - Update patient");
        System.out.println("4 - Find patient");
        System.out.println("5 - Exit");
        System.out.println("Please enter your choice");
        // return 1~5 숫자
    }
    public void addPatient(){
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter patient ID");
        String pid = in.next();

        if (PatientManager.doesExist(pid)){
            // ++ return 값이 1(환자 존재)인 경우 main 화면으로 돌아가기
        }else {
            System.out.println("Please enter patient name");
            String name = in.next();
            System.out.println("Please enter patient age");
            int age = in.nextInt();
            System.out.println("Please enter patient status");
            String status = in.next();
            // ++ 읽어들인 값 배열에 저장

            System.out.println("Add patient completed, input 1 to continue");
            //++ input 1 입력받고 입력받았다면,
            // ++ addPatient 종료되었으므로 main 화면으로 돌아가기
        }

    }

    public static boolean doesExist(String patientId){
        // ++ 환자 배열에서 id 를 읽어와 일치하는지 판단
        // ++ doesExist() 환자 존재 -> 1, 환자 존재 안함 -> 0
        return false; // -> 오류 없애려고 넣은거, 강의 도중에 못적었나 봄.
    }
    public void outputAllPatients(){
//        if(배열 존재){
//            System.out.println("배열 출력"); // Patient 객체의 pid, name, age, status 출력
//        } else {
//            System.out.println("No such information, please add new information");
//        }
//        // ++ 메인화면으로 돌아가기
    }
    public void deletePatients(){
        System.out.println("Please enter the ID of the patient you want to delete");
        Scanner in = new Scanner(System.in);
        String deleteID = in.next();

        if (PatientManager.doesExist(deleteID)){
            PatientManager.delete(deleteID);
            System.out.println("Delete patient information completed, input 1 to continue");
            // ++ 1 입력받는다면 메인화면으로 돌아가기
        } else{
            System.out.println("This ID does not exist!");
            //++ 메인화면으로 돌아가기
        }
    }
    public void updatePatients(){
        System.out.println("Please enter the ID of the patient you want to change: ");
        Scanner in = new Scanner(System.in);
        String updateID = in.next();

        if (PatientManager.doesExist(updateID)){
            System.out.println("Please enter new name of the patient:");
            //++ 입력받은 id의 patient 배열의 name 부분 수정
            System.out.println("Please enter new age of the patient:");
            //++ 입력받은 id의 patient 배열의 age 부분 수정
            System.out.println("Please enter new status of the patient:");
            //++ 입력받은 id의 patient 배열의 status 부분 수정
            System.out.println("Modify patient information completed, input 1 to continue.");
            //++ 1을 입력받으면 메인으로 돌아가기
        }

    }
    public static void delete(String pid){
        // ++ 파라미터로 입력받은 id의 환자정보 삭제
    }

}
