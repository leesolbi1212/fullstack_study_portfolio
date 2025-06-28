package lesson06;

class InvalidUserException extends RuntimeException {
    // 무조건 try catch를 하는 건 아니고 런타임 시에만!
    public InvalidUserException(String message) {
        super(message);
    }
}

class UncheckedUserException {
    public static void validateUserName(String name){
        if(name == null || name.isEmpty()) {
            throw new InvalidUserException("사용자 이름은 비어있을 수 없습니다");
        }
        System.out.println("사용자 이름 : " + name);
    }
}

public class Ex07_Main {
    public static void main(String[] args) {
//        UncheckedUserException ue = new UncheckedUserException
        try {
            UncheckedUserException.validateUserName("");
        } catch (InvalidUserException e) {
            System.out.println("예외 처리됨 " + e.getMessage());
        }
    }
}
