function add1(a, b) {
  return a + b;
}

const add2 = (a, b) => a + b; // 화살표 함수 : 무조건 return형태

//매개변수가 1개일 때 괄호를 생략할 수 있다.
const square = (x) => x * x; // x의 제곱을 반환하는 화살표 함수

//코드 블록이 있는 경우 중괄호+return을 사용해야 한다. -> 블록으로 여러줄을 작성하려면 중괄호를 사용해야 한다.
const add3 = (a, b) => {
  return a + b;
};

// const obj = {
//   name: "김사과",
//   sayHello: function () {
//     setTimeout(function () {
//       console.log(`안녕! 나는 ${this.name}이야!`); // undefined
//     }, 1000);
//   },
// };

// obj.sayHello(); // 1초 후 "안녕! 나는 undefined이야!" 출력

const obj = {
  name: "김사과",
  sayHello: function () {
    setTimeout(() => {
      console.log(`안녕! 나는 ${this.name}이야!`);
    }, 1000);
  },
};

obj.sayHello(); // 1초 후 "안녕! 나는 김사과이야!" 출력
