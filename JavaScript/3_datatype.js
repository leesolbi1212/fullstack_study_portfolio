// 기본형 (Primitive Type)
let num = 20;
let str = "Hello JS!!";
let isReady = true;
let nothing = null;
let notDefined;
let bigNumber = 12345678901234567890n;
let unique = Symbol("id");

console.log("기본형 타입 출력하기");
console.log("num :", num);
console.log("str :", str);
console.log("isReady :", isReady);
console.log("nothing :", nothing);
console.log("notDefined :", notDefined);
console.log("bigNumber :", bigNumber);
console.log("unique :", unique);

let obj1 = { name: "apple" }; //name이라는 키를 가지고 있고, apple이라는 값을 가지고 있다.
console.log(obj1.name);
let obj2 = obj1;
obj2.name = "banana";
console.log(obj2.name);
console.log(obj1.name);

// 참조형 (Reference Type)

let person = { name: "apple", age: 20 };
let numbers = [1, 2, 3, 4, 5];
let greet = function () {
  return "안녕안녕~";
};
let now = new Date();

console.log("참조형 타입 출력하기!!");
console.log("person :", person);
console.log("numbers :", numbers);
console.log("greet :", greet()); //함수를 실행하라는 뜻()
console.log("now :", now);
