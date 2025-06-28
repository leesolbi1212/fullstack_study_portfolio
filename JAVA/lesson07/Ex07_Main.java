package lesson07;

import java.util.Objects;
import java.util.Scanner;

class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point other) {
        // 현재 내가 저장하고 있는 x값과 받은 x값을 빼서 dx가 나옴
        int dx = this.x - other.x;
        int dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy); // 거리 구하는 피타고라스 공식
    }
    public int getX() {return x;}
    public int getY() {return y;}

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; //메모리 위치가 같으면 true
        if (!(obj instanceof Point)) return false; // 클래스 자체가 다른 걸로 만들어졌다면 비교할 것도 없어요! 같은 클래스거나 얘를 상속받아 만든거면 true가 나오게 되어있는데 그게 아니라면 false라고 나옴
        Point other = (Point) obj; // 다운 캐스팅
        return x == other.x && y == other.y; //x값이 other.x와 같고.... 둘다 완벽하게 맞았을 때만 true, 아니면 false
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

class StoreService{
    private final Point storeLocation = new Point(0, 0);
    public boolean canDeliver(Point customerLocation) {
        double distance = storeLocation.distance(customerLocation);
        System.out.println("거리계산 : " + distance);
        return distance <= 5.0;
    }
}

public class Ex07_Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StoreService service = new StoreService();
        System.out.println("가게 기준점은 (0,0)입니다.");
        System.out.print("고객 위치 x 좌표를 입력 : ");
        int x = Integer.parseInt(sc.nextLine());
        System.out.print("고객 위치 y 좌표를 입력 :  ");
        int y = Integer.parseInt(sc.nextLine());

        Point customer = new Point(x, y);
        System.out.println("고객 위치 : " + customer);

        if(service.canDeliver(customer)) {
            System.out.println("배달 가능 지역입니다.");
        } else {
            System.out.println("배달 불가능 지역입니다.");
        }
        sc.close();
    }
}
