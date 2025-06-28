function Dog(name, age, color) {
  this.name = name; // public 변수, 객체를 만드는 게 목적
  this.age = age; // public 변수, 객체를 만드는 게 목적
  this.color = color; // public 변수, 객체를 만드는 게 목적
}

const Rucy = new Dog("Rucy", 15, "white"); // 객체를 생성할 때 name 속성에 접근하여 값을 설정
console.log(Rucy);

console.log(`이름: ${Rucy.name}, 나이: ${Rucy.age}, 색상: ${Rucy.color}`); // 이름: Rucy, 나이: 15, 색상: white

const PPomi = new Dog("뽀미", 7, "white"); // 객체를 생성할 때 name 속성에 접근하여 값을 설정
console.log(PPomi);
console.log(`이름: ${PPomi.name}, 나이: ${PPomi.age}, 색상: ${PPomi.color}`); // 이름: 뽀미, 나이: 7, 색상: white

Rucy.family = "포메귀요미이익!!!"; // Rucy 객체에 family 속성을 추가함.
Rucy.getFamily = function () {
  return this.family; // family 속성을 반환하는 메서드
};

console.log(`종 : ${Rucy.family}`); // 포메귀요미이익!!!
console.log(`getFamily : ${Rucy.getFamily()}`); // getFamily : 포메귀요미이익!!!
console.log(`종 : ${PPomi.family}`);
//console.log(`getFamily : ${PPomi.getFamily()}`); // 에러남

console.log("------------------------------");

Dog.prototype.owner = "김사과";
Dog.prototype.run = function () {
  return `${this.name}가 달려요!!!!`;
}; // 객체를 생성할 때 name 속성에 접근하여 값을 설정
console.log(`Rucy 소유자 : ${Rucy.owner}`); // Rucy 소유자 : 김사과
console.log(`PPomi 소유자 : ${PPomi.owner}`); // PPomi 소유자 : 김사과

console.log(Rucy.run()); // Rucy가 달려요!!!!
console.log(PPomi.run()); // 뽀미가 달려요!!!!
