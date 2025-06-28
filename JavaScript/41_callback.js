// console.log("물 끓이기 시작!");
// setTimeout(function () {
//   console.log("면 넣기");
// }, 3000);
// console.log("계란 준비하기");

// function greet(name, callback) {
//   console.log(`안녕하세요, ${name}님!`);
//   callback(); // 콜백 함수 호출
// }

// function sayBye() {
//   console.log("안녕히 가세요!");
// }

// greet("김사과", sayBye); // greet 함수 호출, sayBye는 콜백 함수로 전달됨
// // greet 함수가 sayBye를 콜백으로 호출함

// const numbers = [1, 2, 3, 4];
// const doubled = numbers.map((n) => n * 2); // 각 요소를 2배로 만드는 콜백 함수
// console.log(doubled); // [2, 4, 6, 8]

// function doSomething(callback) {
//   console.log("작업 시작...");
//   callback(); // 콜백 함수 호출
// }

// doSomething(() => {
//   console.log("작업 완료!"); // 익명 함수로 콜백 전달
// });

const calc_add = (a, b) => a + b;
const calc_multiply = (a, b) => a * b;

function calculater(num1, num2, action) {
  if (num1 < 0 || num2 < 0) return; // 음수는 계산할 수 없다.

  const result = action(num1, num2); // action은 콜백 함수
  return result; // 결과를 반환
}

console.log(calculater(10, 3, calc_add)); //13
console.log(calculater(10, 3, calc_multiply)); //30
console.log(calculater(-10, 3, calc_add)); //undefined

/*
    회문을 체크하는 함수를 만들어보쟝!
    재귀함수를 통해서 구현해보쟝!

    함수 이름 : isPalindrome <-Ture/False
    매개변수 : str (문자열)
    반환값 : boolean (true/false)

*/

function isPalindrome(str) {
  if (str.length <= 1) return true; // 길이가 0 또는 1인 경우 회문
  if (str[0] !== str[str.length - 1]) return false; // 첫 문자와 마지막 문자가 다르면 false
  return isPalindrome(str.slice(1, str.length - 1)); // 재귀 호출
}
console.log(isPalindrome("역삼역"));
