package lesson01;

public class Ex04_FloatLong {
    public static void main(String[] args) {
        long bigNumber = 100000000000L;  // long 타입
        float converted = bigNumber;     // long → float (자동 형 변환, 정밀도 손실)
        System.out.println("long → float 변환: " + converted);

        float pi = 3.14159f;
        long piToLong = (long) pi;
        System.out.println("float -> long 변환:" + piToLong);
    }
}
