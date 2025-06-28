// const numbers = [1, 2, 3, 4, 5];
// const [first, second, ...rest] = numbers; // 나머지 연산자
// console.log(first); // 1
// console.log(second); // 2
// console.log(rest); // [3, 4, 5]

function sum(...nums) {
  let total = 0;
  for (let n of nums) {
    total += n;
  }
  return total;
}

console.log(sum(1, 2, 3)); // 6
console.log(sum(10, 20, 30, 40, 50)); // 150

const user = {
  name: "김사과",
  age: 20,
  city: "서울",
};

const { name, ...rest } = user; // 나머지 연산자
console.log(name); // 김사과
console.log(rest); // { age: 20, city: '서울' }
