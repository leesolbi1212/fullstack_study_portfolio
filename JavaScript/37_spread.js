// const fruits = ["사과", "바나나"];
// const newFruits = [...fruits, "포도"];
// console.log(newFruits); // ['사과', '바나나', '포도']
//얕은 복사 -> 새로운 배열을 만들고, 기존 배열의 요소를 복사하여 새로운 배열에 추가

// const arr1 = [1, 2, 3];
// const arr2 = [...arr1]; // 얕은 복사
// console.log(arr2); // [1, 2, 3]

// const a = [1, 2];
// const b = [3, 4];
// const c = [...a, ...b]; // [1, 2, 3, 4]
// console.log(c); // [1, 2, 3, 4]

// function add(x, y,z) {
//   return x + y + z;
// }
// const nums = [1, 2, 3]; //nums 배열을 add에 넣고 싶다!
// console.log(add(...nums)); // 6

const person = { name: "김사과", age: 20 };
const copy = { ...person }; // 얕은 복사
console.log(copy); // { name: '김사과', age: 20 }

const a = { name: "김사과" };
const b = { age: 20 };
const merged = { ...a, ...b }; // { name: '김사과', age: 20 }
console.log(merged); // { name: '김사과', age: 20 }
