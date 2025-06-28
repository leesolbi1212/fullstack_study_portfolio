package lesson02;

import java.util.Scanner;

public class Ex17_Coord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("맵의 행 수를 입력하세요 :");
        int row = sc.nextInt();
        System.out.println("맵의 열 수를 입력하세요 :");
        int cols = sc.nextInt();

        System.out.println("[맵 좌표 출력]");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("("+i+","+j+")");
            }
            System.out.println();
        }
        sc.close();
    }
}
