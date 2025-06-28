package com.koreait.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//@Controller //이렇게 써주면 컨트롤러의 기능을 갖게됨. 짱쉽죠?
//public class HomeController {
//    @GetMapping("/home") // 이건 주소
//    public String home() {
//        return "home"; //WEB-INF/views/home.jsp를 자동으로 찾게됨. return 뒤 파일명과 일치해야함.
//    }
//}

@Controller //이렇게 써주면 컨트롤러의 기능을 갖게됨. 짱쉽죠?
public class HomeController {
    @GetMapping("/home") // 이건 주소
    public String home(Model model) {
        model.addAttribute("name","김사과");
        return "home"; //WEB-INF/views/home.jsp를 자동으로 찾게됨. return 뒤 파일명과 일치해야함.
    }
}
