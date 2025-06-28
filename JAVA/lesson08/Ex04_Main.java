package lesson08;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Student implements Serializable {
    // serialVersionUID : 직렬화된 객체의 클래스 버전을 식별, 직렬화 당시 클래스 구조를 구분하는 역할을 함. 직렬화된 객체를 읽어올 때 원래 클래스와 구조가 같아야 역직렬화 가능한데, 이 버전이 일정하면 같은 클래스야~ 라고 설정해주는 것.
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    //toString으로 오버라이딩한다는 것?
    @Override
    public String toString() {
        return "학생 이름 : " + name + ", 나이 : " + age;
    }
}

public class Ex04_Main {
    public static void main(String[] args) {
        Student s = new Student("김사과", 20);
        try( //안닫아도 될 것들만 소괄호 안에 작성
                FileOutputStream fos = new FileOutputStream("student.ser"); //직렬화 해서 넣을 거라서 .ser
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                // fos를 갖다가 object형으로 내보내는 것
                ){
            oos.writeObject(s); //직렬화 되어 파일로 저장됐음
            System.out.println("객체를 파일에 저장했습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
