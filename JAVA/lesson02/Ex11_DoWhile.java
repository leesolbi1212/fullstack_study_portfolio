package lesson02;

import java.util.Scanner;

public class Ex11_DoWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "";

        do {
            System.out.print("문장을 입력하세요 (종료:exit) :");
            input = sc.nextLine();
            System.out.println("입력한 내용 :" + input);
        } while (!input.equals("exit"));
        System.out.println("프로그램을 종료합니다");
        sc.close();
    }
}
