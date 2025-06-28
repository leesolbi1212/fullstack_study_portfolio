package lesson01;

import java.util.Scanner;

public class Ex07_ArrayInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] scores = new int[3];

        System.out.print("첫 번째 점수를 입력하세요 :");
        scores[0] = sc.nextInt();

        System.out.print("두 번째 점수를 입력하세요 :");
        scores[1] = sc.nextInt();

        System.out.print("세 번째 점수를 입력하세요 :");
        scores[2] = sc.nextInt();

        System.out.println("첫 번째 점수 : "+scores[0]);
        System.out.println("두 번째 점수 : "+scores[1]);
        System.out.println("세 번째 점수 : "+scores[2]);

        sc.close();
    }
}
