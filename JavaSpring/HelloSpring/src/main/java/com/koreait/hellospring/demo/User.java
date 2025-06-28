package com.koreait.hellospring.demo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String name; //자동으로 getter setter가 만들어지게 됨 lombok이 만들어줌!
    private int age; //자동으로 getter setter가 만들어지게 됨 lombok이 만들어줌!
}
// 객체 생성해서 진짜 만들어졌는지 알아보자 test를 통해 알아보자