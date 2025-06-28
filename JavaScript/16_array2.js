// let fruits = ["사과", "바나나", "오렌지"];

// for (let i = 0; i < fruits.lenght; i++) {
//   console.log(fruits[i]);
// }

// for (let fruit of fruits) {
//   console.log(fruits);
// }

// fruits.forEach(function (fruit, index) {
//   console.log(`${index}번째 과일: ${fruit}`);
// });

const users = [1, "apple", "김사과", "20", "서울 서초구!"];

//for 문
for (let i = 0; i < users.length; i++) {
  console.log(users[i]);
}
console.log("----------------------------------");

//for..of 문
for (let user of users) {
  console.log(user);
}

console.log("----------------------------------");

//forEach 문

users.forEach(function (user, index, arr) {
  console.log(user, index, arr); //arr은 가지고 있는 모든 요소
});
