class Product {
  name = "상품명 없음";
  price = 0;
  static productName = "컴퓨터";
  static productprice = 1000000;

  showInfo() {
    console.log(`${this.name}의 가격은 ${this.price}원 입니다.`);
  }

  static showStaticInfo() {
    console.log(`${this.productName}의 가격은 ${this.productprice}원 입니다.`);
  }
}

const p = new Product();
p.showInfo();
//p.showStaticInfo(); // static 메서드는 인스턴스에서 호출할 수 없음.
Product.showStaticInfo(); // static 메서드는 클래스에서 직접 호출할 수 있음.
