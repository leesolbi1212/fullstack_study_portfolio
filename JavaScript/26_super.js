class Animal {
  constructor(name) {
    this.name = name;
  }
}

const animal = new Animal("고양이");
console.log(animal.name);

class Dog extends Animal {
  constructor(name, color) {
    super(name); // 부모 클래스의 생성자를 호출합니다.
    this.color = color; // 자식 클래스의 속성을 추가합니다.
  }
  showInfo() {
    console.log(`${this.name}는 ${this.color} 강아지입니다.`);
  }
}

const dog = new Dog("루시", "흰색");
dog.showInfo(); // 루시는 흰색 강아지입니다.
