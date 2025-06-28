package lesson04;

class Book {
    String title;

    public Book(String title) {
        this.title = title;
    }
    public void read() {
        System.out.println("책\""+title+"\"을 읽습니다.");
    }
}

public class Ex03_Main {
    public static void main(String[] args) {
        /* Object[] items = new Object[3];
        items[0] = "안녕하세요";
        items[1] = 100;
        items[2] = new Book("자바의 정석");

        for (Object obj : items){
            if(obj instanceof String){
                //instanceof : 객체가 특정 클래스의 인스턴스인지 확인하는 연산자.
                // 객체가 어떤 클래스 또는 그 하위 타입으로부터 생성되었는지를 판별할 때 사용
                System.out.println("문자열 :" +obj);
            } else if(obj instanceof Integer){
                System.out.println("정수 :"+obj);
            } else if(obj instanceof Book){ //다운캐스티
                Book book = (Book)obj;
                book.read();
            }
        } */
        Object[] items = new Object[3];

        items[0] = "안녕하세요";            // String
        items[1] = 100;                   // Integer (오토박싱)
        items[2] = new Book("자바의 정석"); // 사용자 정의 클래스

        // 배열 순회하며 타입 확인 및 처리
        for (Object obj : items) {
            if (obj instanceof String str) {
                System.out.println("문자열: " + str);
            } else if (obj instanceof Integer num) {
                System.out.println("정수: " + num);
            } else if (obj instanceof Book book) {
                book.read();  // 자동으로 Book 타입으로 다운캐스팅됨
            }
        }
    }

}
