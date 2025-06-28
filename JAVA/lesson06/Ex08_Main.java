package lesson06;
// 일반적인 string보다는 긴 로직에서는 문자열 쓸 때 이 클래스를 이용하는 게 좋음
public class Ex08_Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("Hello");
        sb.append(" ");
        sb.append("World");
        sb.insert(6,"Java");
        sb.delete(0,6);
        sb.reverse();

        System.out.println(sb.toString());

        StringBuffer sb2 = new StringBuffer("Hello");
        sb2.append(" Thread");
        sb2.insert(5, " Safe");

        System.out.println(sb2.toString());
    }
}
