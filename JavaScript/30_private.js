class User {
  // #password; // public 변수, #을 붙이지 않아서 public으로 설정
  // private 변수, #을 붙여서 private으로 설정
  #password; // private 변수, #을 붙여서 private으로 설정
  constructor(userid, password) {
    this.userid = userid; // public 변수
    this.#password = password; // private 변수
  }

  checkPassword(input) {
    return this.#password === input; // private 변수에 접근
  }
}

const user = new User("apple", "1111");
console.log(user.userid); // apple
console.log(user.checkPassword("1111")); // true
console.log(user.checkPassword("2222")); // false

console.log(user.#password); // SyntaxError: Private field '#password' must be declared in an enclosing class
// private 변수에 접근할 수 없음
