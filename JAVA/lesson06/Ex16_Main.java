package lesson06;

import java.util.Vector;

public class Ex16_Main {
    public static void main(String[] args) {
        Vector<Integer> scores = new Vector<Integer>();
        scores.add(90);
        scores.add(80);
        scores.add(70);
        scores.add(60);
        scores.add(50);

        System.out.println("전체 학생 점수 : ");
        for ( int i=0; i<scores.size(); i++ ) {
            System.out.println("- "+ getName(i)+" : "+scores.get(i)+"점");
        }
        int sum = 0;
        for(int score : scores) {
            sum += score;
        }
        double average = (double) sum / scores.size();
        System.out.println("\n전체 평균 점수 : "+average);

        scores.set(2,88); //2번 인덱스의 점수를 88점으로 바꾸겠다
        System.out.println("\n오렌지 점수 수정 후 : " +scores.get(2)+"점");

        scores.remove(scores.size()-1);
        System.out.println("\n마지막 학생 삭제 후 학생 수 : " +scores.size());
    }

    public static String getName(int index) {
      switch (index) {
          case 0:return "김사과";
          case 1:return "반하나";
          case 2:return "오렌지";
          case 3:return "이메론";
          case 4:return "채애리";
          default:return "이름없음";

      }
    }
}
