package lesson02;

import java.util.*;

public class Mini_Lunch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 메뉴 카테고리별 데이터
        Map<String, List<String>> menuMap = new HashMap<>();

        menuMap.put("한식", Arrays.asList(
                "비빔밥", "김치찌개", "된장찌개", "불고기", "제육볶음",
                "갈비탕", "육개장", "김밥", "떡볶이",
                "냉면", "순두부찌개", "부대찌개", "편의점 털기", "연가", "육회비빔밥"
        ));
        menuMap.put("중식", Arrays.asList(
                "짜장면", "짬뽕", "탕수육", "마라탕", "깐풍기",
                "유산슬", "양장피", "팔보채", "마파두부", "볶음밥",
                "고추잡채", "딤섬", "꿔바로우"
        ));
        menuMap.put("양식", Arrays.asList(
                "파스타", "피자", "햄버거", "리조또", "스테이크",
                "샐러드", "치킨스테이크", "클럽샌드위치",
                "샌드위치","서브웨이"
        ));
        menuMap.put("일식", Arrays.asList(
                "초밥", "라멘", "우동", "가츠동", "규동",
                "오므라이스", "텐동", "야키소바", "스시롤", "타코야끼",
                "사케동", "가라아게", "미소시루"
        ));

        System.out.print("오늘 점심 고를 사람?");
        Random rand  = new Random();
        String choice = rand.nextInt() + "";

        System.out.print("점심 메뉴 카테고리 선택 (한식/중식/양식/일식): ");
        String input = sc.nextLine().trim();

        if (!menuMap.containsKey(input)) {
            System.out.println("유효한 카테고리가 아닙니다. 한식, 중식, 양식, 일식 중에서 입력하세요.");
        } else {
            List<String> menuList = menuMap.get(input);
//            Random rand = new Random();
            String selectedMenu = menuList.get(rand.nextInt(menuList.size()));
            System.out.println("오늘의 추천 " + input + " 메뉴는 👉 [" + selectedMenu + "] 입니다!");
        }

        sc.close();
    }
}