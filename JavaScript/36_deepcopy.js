function deepCopy(value) {
  if (typeof value !== "object" || value === null) {
    return value; // 원시값은 그대로 반환, 객체도 아니고 배열도 아니면 그냥 return (숫자, 문자열 등은 복사할 필요 없음음)
  }

  // 배열인 경우
  if (Array.isArray(value)) {
    const result = [];
    for (let i = 0; i < value.length; i++) {
      result[i] = deepCopy(value[i]); // 배열이면 하나씩 꺼내서 다시 deepCopy 호출. 배열 안에 객체가 있든 배열이 있든 끝까지 따라가서 복사함 (집착)
    }
    return result;
  }

  // 객체인 경우
  const result = {};
  for (let key in value) {
    result[key] = deepCopy(value[key]); // 객체면 key-value 쌍을 순회하면서 각각 깊은 복사, 안쪽에 또 객체나 배열이 있으면 다시 deepCopy 호출
  }
  return result;
}

const original = {
  name: "오렌지",
  scores: [90, 80, 100],
  address: {
    city: "서울",
    zip: "12345",
  },
};

const copy = deepCopy(original); // 깊은 복사 수행
copy.name = "김사과";
copy.scores[0] = 70;
copy.address.city = "부산";
//copy는 복사본이므로 원본과는 다른 객체임. 원본은 변경되지 않음
//name, scores, address는 모두 깊은 복사됨. 원본과 복사본은 서로 다른 객체임 original과 copy는 서로 다른 주소(배열)를 가짐

console.log(original.name); // 오렌지 (원본은 변경되지 않음)
console.log(original.scores[0]); // 90 (원본은 변경되지 않음)
console.log(original.address.city); // 서울 (원본은 변경되지 않음)
console.log(copy.name); // 김사과 (복사본은 변경됨)
console.log(copy.scores[0]); // 70 (복사본은 변경됨)
console.log(copy.address.city); // 부산 (복사본은 변경됨)
