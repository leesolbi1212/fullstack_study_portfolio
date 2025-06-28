package lesson07;

import java.util.Objects;
import java.util.Scanner;

record Ex09_Point(int x, int y) {
    public double distance(Ex09_Point other) {
        int dx = this.x - other.x;
        int dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

class Ex09_StoreService{
    private final Point storeLocation = new Point(0, 0);
    public boolean canDeliver(Point customerLocation) {
        double distance = storeLocation.distance(customerLocation);
        System.out.println("거리계산 : " + distance);
        return distance <= 5.0;
    }
}

public class Ex09_Main {
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
