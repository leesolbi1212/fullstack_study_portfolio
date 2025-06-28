package lesson02;

import java.util.Scanner;

public class Ex05_SwitchGrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 엽력하세요 (0~100) :");
        int score = sc.nextInt();
        int grade = score / 10;

        switch (grade) {
            case 10:
            case 9:
                System.out.println("A학점입니다");
                break;
            case 8:
                System.out.println("B학점입니다");
                break;
            case 7:
                System.out.println("C학점입니다");
                break;
            case 6:
                System.out.println("D학점입니다");
                break;
            default:
                System.out.println("재시험 대상입니다");

        }
        sc.close();
    }
}
