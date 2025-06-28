class User {
  constructor(name) {
    this._name = name; // _name은 private 변수
  }
  //getter 메서드
  // _name을 반환하는 메서드
  get name() {
    return this._name; // _name을 반환
  }

  //setter 메서드
  // _name을 설정하는 메서드
  set name(newName) {
    if (newName.length < 2) {
      console.log("이름은 2글자 이상이어야 합니다.");
    } else {
      this._name = newName; // _name을 설정
    }
  }
}

const user = new User("김사과");
console.log(user.name); // 김사과
console.log(user.name); // getter 메서드를 호출한 것.
user.name = "반"; // setter 메서드를 호출한 것.
user.name = "반하나"; // setter 메서드를 호출한 것.
console.log(user.name); // 반하나 getter 메서드를 호출한 것.
