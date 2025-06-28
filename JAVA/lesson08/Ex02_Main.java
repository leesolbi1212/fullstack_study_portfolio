package lesson08;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex02_Main {
    public static void main(String[] args) {
        try ( //리소스를 반환할 때 편하게 하려고, finally 필요없이
            FileInputStream fis = new FileInputStream("src/input.txt");
            FileOutputStream fos = new FileOutputStream("src/output.txt");
        ) { // 실제 우리가 쓸 로직
            int data;
            while((data = fis.read()) != -1) {
                fos.write(data);
            }
            System.out.println("파일 복사 완료 (바이트 스트림)");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

