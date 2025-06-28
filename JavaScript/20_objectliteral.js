const person = {
  name: "김사과",
  age: 20,
  greet: function () {
    console.log(`안녕! 저는 ${this.name} 입니다.`);
  },
};
console.log(person.name);
console.log(person.greet());
