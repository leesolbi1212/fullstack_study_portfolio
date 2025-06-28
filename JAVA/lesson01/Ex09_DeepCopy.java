package lesson01;

public class Ex09_DeepCopy {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        int[] b = new int[3];

        b[0] = a[0];
        b[1] = a[1];
        b[2] = a[2];

        System.out.println("a[0] =" + a[0]);
        System.out.println("b[0] =" + b[0]);
        System.out.println("-------b[0] 값 바꿈----------");

        // b 배열 값 변경
        b[0] = 99;

        // 결과 출력
        System.out.println("a[0] =" + a[0]);
        System.out.println("b[0] =" + b[0]);

    }
}
