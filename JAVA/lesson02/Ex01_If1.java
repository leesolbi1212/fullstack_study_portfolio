package lesson02;

import java.util.Scanner;

public class Ex01_If1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 입력하세요 : ");
        int number = sc.nextInt();
        if(number > 0) {
            System.out.println("양수입니다");
        }
        sc.close();
    }
}
