class MathTool {
  constructor(num1, num2) {
    this.num1 = num1;
    this.num2 = num2;
  }
  // 인스턴스 메서드
  static add(a, b) {
    return a + b;
  }
  subtract() {
    return this.num1 - this.num2;
  }
}

console.log(MathTool.add(10, 4)); // 14
// MathTool 인스턴스를 만들지 않아도 사용 가능
