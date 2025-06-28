// const obj = { name: "김사과", age: 20 };
// const { name, age } = obj; // 구조 분해 할당
// //key 이름을 맞춰서 적어줘야함.
// console.log(name); // 김사과
// console.log(age); // 20

// function display({ name, age, address, job }) {
//   console.log(name, age, address, job);
// }

// const apple = {
//   name: "김사과",
//   age: 20,
//   address: { si: "서울시", gu: "서초구", dong: "양재동" },
// };

// console.log(apple);
// const new_apple = { ...apple, job: "개발자" }; // apple을 shallow copy하여 new_apple에 저장
// console.log(new_apple); // { name: '김사과', age: 20, address: { si: '서울시', gu: '서초구', dong: '양재동' }, job: '개발자' }
// display(new_apple); // 김사과 20 { si: '서울시', gu: '서초구', dong: '양재동' } 개발자

// const { pet = "루시" } = new_apple; // pet이 없으면 '루시'로 초기화
// console.log(pet); // 루시

// const { job: hobby } = new_apple; // job을 hobby로 변경
// console.log(new_apple); // { name: '김사과', age: 20, address: { si: '서울시', gu: '서초구', dong: '양재동' }, hobby: '개발자' }

const component = {
  name: "Button",
  styles: { size: 20, color: "black" },
};

function changeColor({ styles: { color } }) {
  console.log(color); // black
}
changeColor(component); // black
// styles.color를 구조 분해 할당하여 color 변수에 저장
// styles는 객체이므로, styles.color는 shallow copy가 됨. color는 원본과 다른 주소를 참조함
