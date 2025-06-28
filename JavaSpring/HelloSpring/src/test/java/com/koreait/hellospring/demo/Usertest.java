package com.koreait.hellospring.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Usertest {

    @Test
    void testUserGetterSetter() {
        User user = new User();
        user.setName("김사과"); // GetterSetter 어노테이션 작동
        user.setAge(22); // GetterSetter 어노테이션 작동
        assertEquals("김사과", user.getName());
        assertEquals(22, user.getAge());
        //내가 지금 어떤 문자열 또는 어떤 값과 비교해보고 싶을 때 test, Junit 구간에서만 쓸 수 있는 assertEquals 만약 김사과 아니라 다른 이름이 들어가면 에러남. (test 실패)

        // 특정 메서드가 정확한 값을 반환하는지 확인할 때
        // 코드의 로직이나 값 변경이 있을 때, 기존 코드가 깨지지 않고 잘 유지되는 지 확인할 때
        // 코드 정리 예쁘게 할 때 안깨지는지 확인할 때 사용

    }
}
