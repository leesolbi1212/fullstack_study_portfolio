package lesson02;

import java.util.Scanner;

public class Ex14_Break {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("문장을 입력하세요 (종료:exit) :");
            String input = sc.nextLine();
            if(input.equals("exit")){
                System.out.println("프로그램을 종료합니다");
                break;
            }
            System.out.println("입력한 문장 :" +input);
        }
        sc.close();
    }
}
