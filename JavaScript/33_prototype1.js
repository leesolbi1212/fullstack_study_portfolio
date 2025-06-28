function Person(name) {
  this.name = name; // public 변수, 객체를 만드는 게 목적
}

const p1 = new Person("김사과"); // 객체를 생성할 때 name 속성에 접근하여 값을 설정
const p2 = new Person("반하나"); // 객체를 생성할 때 name 속성에 접근하여 값을 설정

console.log(p1.name); // 김사과
console.log(p2.name); // 반하나

Person.prototype.sayHello = function () {
  console.log(`안녕하세요, ${this.name}입니다.`); // 객체를 생성할 때 name 속성에 접근하여 값을 설정
  //prototype에 메서드를 추가하여 객체가 생성될 때마다 접근할 수 있도록 함. Person으로 생성된 객체는 sayHello() 메서드를 사용할 수 있음.
};

p1.sayHello(); // 안녕하세요, 김사과입니다.
p2.sayHello(); // 안녕하세요, 반하나입니다.
