package lesson06;

class InvalidScoreException extends Exception {
    public InvalidScoreException(String message) {
        super(message); //  Exception에 message를 super로 보내준다. (많이 씀)
    }
}

public class Ex06_Main {
    public static void checkScore(int score) throws InvalidScoreException {
        if (score < 0 || score > 100) {
            throw new InvalidScoreException("점수는 0~100 여야 합니다");
        }
        System.out.println("유효한 점수입니다");
    }
    public static void main(String[] args) {
        // checked : 예외처리를 무조건 해줘야하는 경우 (exception을 상속받으면 된다)
        try{
            checkScore(150);
        } catch (InvalidScoreException e) {
            System.out.println("예외 처리됨 : " + e.getMessage());
        }
    }
}
