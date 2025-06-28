package lesson02;

import java.util.Scanner;

public class Ex07_SwitchMBTI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("당신의 MBTI를 입력하세요 (예: INFP, ENFP, ISTJ 등): ");
        String mbti = sc.nextLine().toUpperCase();  // 대소문자 구분 없이 처리

        switch (mbti) {
            case "INFP" -> {
                System.out.println("🌱 INFP: 이상주의자형");
                System.out.println("조용하고 친절하며, 내면의 세계가 풍부해요.");
                System.out.println("자신만의 가치관을 가지고 살아가는 당신, 멋져요!");
            }
            case "ENFP" -> {
                System.out.println("🔥 ENFP: 재기발랄한 활동가형");
                System.out.println("창의적이고 열정적이며, 주변을 활기차게 만드네요!");
                System.out.println("당신 덕분에 주변이 밝아져요 😄");
            }
            case "INTJ" -> {
                System.out.println("🧠 INTJ: 전략가형");
                System.out.println("분석적이고 독립적인 사고를 가진 당신은 진정한 계획자!");
                System.out.println("미래를 설계하는 당신의 통찰력이 놀라워요.");
            }
            case "ESFP" -> {
                System.out.println("🎉 ESFP: 연예인형");
                System.out.println("항상 즐거움을 추구하고, 사람들과 잘 어울리는 분위기 메이커!");
                System.out.println("당신의 웃음은 모두에게 긍정의 에너지입니다.");
            }
            case "INFJ" -> {
                System.out.println("🌌 INFJ: 옹호자형");
                System.out.println("깊은 직관과 신념을 가진 당신, 조용하지만 강한 리더입니다.");
                System.out.println("세상을 바꾸는 건 당신 같은 사람이에요.");
            }
            default -> {
                System.out.println("😕 아직 해당 MBTI 정보가 없어요.");
                System.out.println("정확히 4자리 영어로 입력해 주세요. 예: INFP, ENTP");
            }
        }
        sc.close();
    }
}

