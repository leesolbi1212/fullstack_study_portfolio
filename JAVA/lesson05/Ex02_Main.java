package lesson05;

abstract class Shape {
    abstract double getArea(); // 추상 메서드만 만들어 놓음
}

class Circle extends Shape {
    double radius;
    Circle(double radius) {
        this.radius = radius; // Circle 생성자로 값이 넘어오면 radius로 저장해줌
    }

    @Override
    double getArea() {
        return radius * radius * Math.PI;
    }
}

class Rectangle extends Shape {
    double width, height;
    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    double getArea() {
        return width * height;
    }
}

public class Ex02_Main {
    public static void main(String[] args) {
        Shape s1 = new Circle(5);
        System.out.println("원 면적 :" + s1.getArea());
        Shape s2 = new Rectangle(5, 6);
        System.out.println("사각형 면적 :" + s2.getArea());
    }
}
