package lesson06;

public class Ex09_Main {
    public static void main(String[] args) {
        long start, end;
        // String (느림) : 메모리 낭비의 전형적인 방식. 지웠다가 생성했다가 난리남
        start = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < 10000; i++) {
            str += "a";
        }
        end = System.currentTimeMillis();
        System.out.println("String 시간: " + (end - start) + "ms");

        // StringBuilder (빠름)
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            sb.append("a");
        }
        end = System.currentTimeMillis();
        System.out.println("StringBuilder 시간: " + (end - start) + "ms");
    }
}