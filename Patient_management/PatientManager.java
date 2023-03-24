package Patient_management;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PatientManager {
    public static List<Patient> patientList = new ArrayList<>(); // 이런 식으로
    public int managePatients(){
        Scanner in = new Scanner(System.in);
        System.out.println("====Welcome to patient management system======");
        System.out.println("1 - Add patient");
        System.out.println("2 - Delete patient");
        System.out.println("3 - Update patient");
        System.out.println("4 - Find patient == Print All patient ");
        System.out.println("5 - Exit");
        System.out.println("Please enter your choice");

        String inputMenu = in.next();
        int Menu = Integer.parseInt(inputMenu);
        return Menu;
    }

    public void addPatient(){
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter patient ID");
        String pid = in.next();

        if (PatientManager.doesExist(pid)){
            System.out.println("이미 아이디가 존재하네요...");
            //++ 메인페이지로 돌아가기
        }else {
            System.out.println("Please enter patient name");
            String name = in.next();
            System.out.println("Please enter patient age");
            String age = in.next();
            System.out.println("Please enter patient status");
            String status = in.next();

            patientList.add(new Patient(pid,name,age,status));

            //input 1 입력받고 입력받았다면,
            do {
                System.out.println("Add patient completed, input 1 to continue");
            } while (in.nextInt() != 1);
            // addPatient 종료되었으므로 main 화면으로 돌아가기
        }

    }

    public static boolean doesExist(String patientId){
        // 환자 배열에서 id 를 읽어와 일치하는지 판단
        for (int i =0; i < patientList.size(); i++){
            Patient patients = patientList.get(i);
            if (patients.getPid().equals(patientId)){
                return true;
            }
        }
        return false;
    }
    public void outputAllPatients(){
        if(patientList.size() > 0){
            System.out.println("Patient ID     Name    Age    Status");
            for (Patient patient : patientList){
                System.out.println(patient.toString());
            }
        } else if (patientList.size() == 0){
            System.out.println("No such information, please add new information");
        }
        // 메인화면으로 돌아가기
    }
    public void deletePatients(){
        System.out.println("Please enter the ID of the patient you want to delete");
        Scanner in = new Scanner(System.in);
        String deleteID = in.next();

        if (PatientManager.doesExist(deleteID)){
            delete(deleteID);
            do{
                System.out.println("Delete patient information completed, input 1 to continue");
            } while (in.nextInt() != 1);
            // 1 입력받는다면 메인화면으로 돌아가기
        } else{
            System.out.println("This ID does not exist!");
            // 메인화면으로 돌아가기
        }
    }
    public void updatePatients(){
        System.out.println("Please enter the ID of the patient you want to change: ");
        Scanner in = new Scanner(System.in);
        String updateID = in.next();

        if (PatientManager.doesExist(updateID)){
            System.out.println("Please enter new name of the patient:");
            //입력받은 id의 patient 배열의 name 부분 수정
            String updateName = in.next();
            System.out.println("Please enter new age of the patient:");
            //입력받은 id의 patient 배열의 age 부분 수정
            String updateAge = in.next();
            System.out.println("Please enter new status of the patient:");
            //입력받은 id의 patient 배열의 status 부분 수정
            String updateStatus = in.next();

            delete(updateID);
            Patient updatePatient = new Patient(updateID, updateName, updateAge, updateStatus);
            patientList.add(updatePatient);

            do {
                System.out.println("Modify patient information completed, input 1 to continue.");
            } while (in.nextInt() != 1);
            // 1을 입력받으면 메인으로 돌아가기
        } else {
            System.out.println("This ID does not exist!");
            //  메인으로 돌아가기
        }


    }
    public static void delete(String pid){
        // 파라미터로 입력받은 id의 환자정보 삭제
        for(int i=0; i < patientList.size(); i++){
            Patient delPatient = patientList.get(i);
            if (delPatient.getPid().equals(pid)){
                patientList.remove(delPatient);
            }
        }
    }
}
