package lesson02;

import java.util.Scanner;

public class Ex08_SwitchYield {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("과일 이름을 영어로 입력하세요(apple, banana, grape) :");
            String fruit = sc.nextLine().toLowerCase();

            String result = switch (fruit) {
                case "apple" -> {
                    System.out.println("사과를 선택하셨습니다!");
                    yield "사과";
                }
                case "banana" -> {
                    System.out.println("바나나 어쩌구");
                    yield "바나나";
                }
                case "grape" ->{
                    System.out.println("포도 어쩌고");
                    yield "포도";
                }

                default -> {
                    System.out.println("등록되지 않은 과일입니다");
                    yield "알 수 없는 과일입니다";
                }
            };
            System.out.println("입력한 과일의 한글 : " + result);
            sc.close();
        }
    }


