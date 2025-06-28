package lesson02;

import java.util.Scanner;

public class Ex04_Login {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String correctId = "apple";
        String correctPw = "1111";

        System.out.print("아이디를 입력하세요 :");
        String inputId = sc.nextLine();

        System.out.print("비밀번호를 입력하세요 :");
        String inputPw = sc.nextLine();

//      일치하는지 확인하기
        if(inputId.equals(correctId) && inputPw.equals(correctPw)) {
            System.out.println("로그인 성공");
        } else {
            System.out.println("아이디 또는 비밀번호가 틀렸습니다");
        }
        sc.close();




    }
}
