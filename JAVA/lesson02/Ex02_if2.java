package lesson02;

import java.util.Scanner;

public class Ex02_if2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 입력하세요 : ");
        int number = sc.nextInt();
        if(number >= 0) {
            System.out.println("0 또는 양수입니다");
        } else {
            System.out.println("음수입니다");
        }
        sc.close();
    }
}
