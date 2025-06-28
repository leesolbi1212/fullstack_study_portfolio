class Animal {
  speak() {
    console.log("동물이 소리를 냅니다!");
  }
}

// Dog 클래스는 Animal 클래스를 상속받습니다.
// Dog 클래스는 Animal 클래스의 모든 속성과 메소드를 가집니다.
class Dog extends Animal {
  eat() {
    console.log("강아지가 냠냠쓰~!");
  }
  speak() {
    console.log("강아지 왈왈쓰~!");
  }
}

const animal = new Animal();
animal.speak(); // 동물이 소리를 냅니다!

const dog = new Dog();
dog.speak(); // 동물이 소리를 냅니다!
// Dog 클래스는 Animal 클래스의 메소드를 상속받습니다.
dog.eat(); // 강아지가 냠냠쓰~!
// Dog 클래스는 Animal 클래스의 메소드를 오버라이드합니다.
