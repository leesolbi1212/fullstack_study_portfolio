package lesson08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex01_Main {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "banana", "orange", "apple");
        System.out.println(fruits);
        /*
            String :: toUpperCase
            - 메서드 참조
            - s -> s.toUpperCase()와 같은 람다식을 더 간단하게 표현
            - String 클래스의 toUpperCase() 인스턴스 메서드를 현재 스트림의 각 요소에 대해 호출하겠다는 뜻

        */
        fruits.stream()
                // a로 시작하는 걸 찾아내서 stream 객체로 반환
                .filter(f -> f.startsWith("a"))
                // 대문자로 바꿔서 반환하세요 (중간연산, 아직 안꺼냄)
                .map(String::toUpperCase)
                // 중복 제거
                .distinct()
                // 반복하면서 찍어줘!
                .forEach(System.out::println); // APPLE
    }
}
