package lesson06;

public class Ex03_Main {
    public static void main(String[] args) {
        try{
            String s = null;
            System.out.println(s.length());
        } catch (ArithmeticException e) {
            System.out.println("산술 오류 " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("null 오류 " + e.getMessage());
            // 어떤 오류인지 알고 있을 땐 catch로 잡아주면 되지만 만약 어떤 오류인지 모를 때에는 상위 객체로 대체할 수 있다. (java.lang.Exception)
        } catch (Exception e) {
            System.out.println("기타오류 " + e.getMessage());
            // Exception 오류를 최상위에 쓰면 안 됨 (여기서 다 걸려버리기 때문)
        }
    }
}
