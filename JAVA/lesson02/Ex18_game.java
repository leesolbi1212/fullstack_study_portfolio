package lesson02;

import java.util.Random;
import java.util.Scanner;

public class Ex18_game {
    public static void main(String[] args) {

        final int SIZE = 5;
        char[][] map = new char[SIZE][SIZE];

        // 초기 맵 모두 'o'로 표시
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = 'o';
            }
        }
        // 보물 위치 정하기
        Random rand = new Random();
        int treasureRow = rand.nextInt(SIZE);
        int treasureCol = rand.nextInt(SIZE);

        Scanner sc = new Scanner(System.in);
        boolean found = false;

        while (!found) {
            // 현재 맵 상태 출력
            System.out.println("[맵 상태]");
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    System.out.print(map[i][j]+" ");
                }
                System.out.println();
            }
            System.out.print("행 번호 (0~4) :");
            int row = sc.nextInt();
            System.out.print("열 번호 (0~4) :");
            int col = sc.nextInt();
            
            // 입력 유효성 검사 
            if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
                System.out.println("유효한 좌표를 입력하세요");
                continue;
            }
            // 보물 발견 했니?
            if (row == treasureRow && col == treasureCol) {
                found = true;
                System.out.println("보물 찾았슈");
            } else {
                if (map[row][col]=='x') {
                    System.out.println("이미 시도한 윛ㅣ입니디;ㅁ낭ㅇ럼ㅣㄴ얾ㅣㅏㄴ어ㅐ라");
                } else {
                    map[row][col]='x';
                    System.out.println("땡!!!!!!");
                }
            }
        }

        // 최종 맵 출력
        System.out.println("[최종 맵]");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        sc.close();
    }
}
