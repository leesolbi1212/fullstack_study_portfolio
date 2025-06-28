class Account {
  static accountCount = 0; //시작하자마자 객체를 만들지 않아도 접근할 수 있는 static 속성
  #balance = 0; // private 속성(잔액액)
  constructor(owner) {
    this.owner = owner; // public 속성
    //객체를 생성할 때마다 자동으로 호출
    Account.accountCount++; // static 속성에 접근하여 1 증가시킴
  }

  get balance() {
    return this.#balance; // private 속성에 접근&호출 (balance는 바로 접근할 수 없으니까 읽기 전용으로 설정)
  }

  set balance(value) {
    console.log("잔액은 수정할 수 없습니다.");
  }
  //입금//
  deposit(amount) {
    if (amount > 0) {
      this.#balance += amount; // private 속성에 접근하여 입금
      console.log(`${this.owner}님, ${amount}원이 입금되었습니다.`);
    } else {
      console.log("입금액은 0보다 커야 합니다.");
    }
  }

  //출금//
  withdraw(amount) {
    if (amount > 0 && amount <= this.#balance) {
      this.#balance -= amount; // private 속성에 접근하여 출금
      console.log(`${this.owner}님, ${amount}원이 출금되었습니다.`);
    } else {
      console.log("잔액이 부족합니다.");
    }
  }

  static getAccountCount() {
    return `총 계좌수 : ${Account.accountCount}`; // static 속성에 접근하여 계좌 수 반환
  }
}

const a1 = new Account("김사과");
a1.deposit(10000); // 입금
console.log(a1.balance); // 잔액 확인
a1.balance = 5000; // 잔액 수정 시도
console.log(a1.balance); // 잔액 확인
a1.withdraw(3000); // 출금

const a2 = new Account("반하나");
a2.deposit(20000); // 입금
console.log(a2.balance); // 잔액 확인

console.log(Account.getAccountCount()); // 총 계좌 수 확인
// class의 static 메서드를 호출하여 총 계좌 수 확인
