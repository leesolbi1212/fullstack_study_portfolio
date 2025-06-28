class Animal {
  speak() {
    console.log("동물이 소리를 냅니다~");
  }
}

class Cat extends Animal {
  speak() {
    console.log("먀앍!");
  }
}

class Dog extends Animal {
  speak() {
    console.log("왈왈!");
  }
}

const animals = [new Cat(), new Dog()]; // Cat과 Dog 객체를 배열에 담음. 객체자체가 인덱스 0과 1에 들어감.
for (let a of animals) {
  a.speak(); // 각 동물 객체의 speak() 메서드를 호출함.
}
