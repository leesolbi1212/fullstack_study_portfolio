package lesson08;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Ex05_Main {
    public static void main(String[] args) {
        try(
                FileInputStream fis = new FileInputStream("student.ser");
                ObjectInputStream ois = new ObjectInputStream(fis);
                ) {
            Student s = (Student) ois.readObject(); //역직렬화
            System.out.println("복원된 객체" + s );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
