function Person(name, age) {
  this.name = name;
  this.age = age;
  this.greet = function () {
    console.log(`안녕하세요! 저는 ${this.name} 입니다.`);
  };
}

const p1 = new Person("이메론", 30);
console.log(p1.name);
console.log(p1.age);
p1.greet();

const p2 = new Person("배애리", 27);
p2.greet();
