package lesson08;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex03_Main {
    public static void main(String[] args) {
        try (
                FileReader reader = new FileReader("src/input.txt");
                FileWriter writer = new FileWriter("output2.txt");
                ) {
            int ch;
            while((ch=reader.read())!= -1) {
                writer.write(ch);
            }
            System.out.println("파일 복사 완료(문자 스트림)");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
