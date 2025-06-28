package lesson01;

import java.util.Scanner;

public class Ex05_Scanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 글을 쓸 수 있는 input 객체
        System.out.print("이름을 입력하세요 :");
        String name = sc.nextLine(); // 한 줄을 입력받을거예용!
        System.out.print("나이를 입력하세요 :");
        int age = sc.nextInt();
        System.out.print("안녕하세요, " + name+ "님! 당신의 나이는" + age +"세입니다");
        sc.close();
    }
}
