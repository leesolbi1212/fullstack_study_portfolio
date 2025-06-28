package lesson01;

import java.io.IOException;

public class Ex06_SystemIn {
    public static void main(String[] args) throws IOException {
        System.out.print("문자 하나를 입력하세요 :");
        int input = System.in.read(); // 한 글자(바이트)를 읽음
        System.out.println("입력한 문자 :" + (char)input);

    }
}
