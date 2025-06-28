let count = 0;

function increase() {
  count++;
}

function getcount() {
  return count;
}

module.exports.getCount = getcount;
// 외부에 등록할게~ getcount라는 함수를 getCount를 호출하면 사용할 수 있게끔 할게!
module.exports.increase = increase;
// 외부에서는 접근할 수가 없다. #같은 느낌!
// 외부에서는 increase(), getCount() 함수만 사용할 수 있다.
// 캡슐화 가능!
