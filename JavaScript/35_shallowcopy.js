// const obj1 = { name: "사과", age: 20 };
// const obj2 = Object.assign({}, obj1); // obj1을 shallow copy하여 obj2에 저장

// obj2.name = "오렌지";
// console.log(obj1.name); // 사과
// //name, age는 복사는 됐으나 obj1은 바뀌지 않았음
// console.log(obj2.name); // 오렌지

// const obj1 = { name: "사과", age: 20 };
// const obj2 = { ...obj1 }; // obj1을 shallow copy하여 obj2에 저장

// obj2.age = 30;
// console.log(obj1.age); // 20
// // age는 복사는 됐으나 obj1은 바뀌지 않았음
// console.log(obj2.age); // 30
// console.log(obj1); // { name: '사과', age: 20 }
// console.log(obj2); // { name: '사과', age: 30 }

const obj1 = {
  name: "김사과",
  address: { city: "서울" },
};
const obj2 = { ...obj1 }; // obj1을 shallow copy하여 obj2에 저장
obj2.address.city = "부산"; // obj2의 address.city를 "부산"으로 변경
console.log(obj1.address.city); // 부산
console.log(obj2.address.city); // 부산
// obj1과 obj2는 같은 주소를 참조하고 있음
// obj1의 address.city도 "부산"으로 변경됨
//address는 shallow copy가 됐으나, address.city는 shallow copy가 안됨. address는 객체이기 때문
