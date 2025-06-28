const proto = {
  greet: function () {
    console.log(`안녕하세요, 저는 ${this.name}입니다.`);
  },
};

const person = Object.create(proto);
person.name = "안가도";
person.age = 32;

person.greet();
