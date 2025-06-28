package lesson02;

import java.util.Random;
import java.util.Scanner;

public class Ex13_for2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("주사위를 몇 번 던질까요? ");
        int count = sc.nextInt();

        for (int i = 1; i <= count; i++) {
            int dice = rand.nextInt(6) + 1; //0~5까지 랜덤한 가격이 나오니까 +1을 해줘서 6까지 나오도록 함
            System.out.println(i + "번째 주사위 🎲 :"+dice);
        }
    }
}
