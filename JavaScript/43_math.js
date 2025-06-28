//min() 가장 작은 수 반환
console.log(Math.min()); //infinity (무한대)
console.log(Math.min(1, 10, -10, 1000, 0, "-100")); //-100 문자열로 저장하더라도 계산할 수 있다면 자동 형변환 되기 때문에 문자열이라도 계산 가능("천" 이렇게 들어가면 계산 x => NaN)

//max() 가장 큰 수 반환
console.log(Math.max()); //-infinity (무한대)
console.log(Math.max(1, 10, -10, 1000, 0, "-100")); //1000

//round() 소수점 첫번째 자리에서 반올림하여 정수로 만들어줌
console.log(Math.round(10.49)); //10
console.log(Math.round(10.5)); //11
console.log(Math.round(-10.5)); //-10
console.log(Math.round(-10.51)); //-11

//n번째 자리까지 반올림
let num = 123.456789;
// 소수점 2번째 자리까지 반올림 -> 100을 곱한 후 반올림하고 다시 100으로 나누기
console.log(Math.round(num * 100) / 100); //123.46
// 소수점 3번째 자리까지 반올림 -> 1000을 곱한 후 반올림하고 다시 1000으로 나누기
console.log(Math.round(num * 1000) / 1000); //123.457

console.log(num.toFixed(2)); //소수점 2번째 자리까지 반올림 -> 123.46
console.log(num.toFixed(3)); //소수점 3번째 자리까지 반올림 -> 123.457

//floor() 소수점 버림 (내림)
console.log(Math.floor(10.49)); //10
console.log(Math.floor(10.5)); //10
console.log(Math.floor(10.51)); //10
console.log(Math.floor(-10.5)); //-11

//ceil() 소수점 올림 (올림)
console.log(Math.ceil(10.49)); //11
console.log(Math.ceil(10.5)); //11
console.log(Math.ceil(10.51)); //11
console.log(Math.ceil(-10.5)); //-10

// random() 0~1사이의 랜덤한 수를 반환
console.log(Math.random()); //0.123456789 (랜덤한 수)
const r = Math.random(); //랜덤한 수를 변수에 저장
console.log(r); //0.123456789 (랜덤한 수)

//1~10사이의 랜덤한 수를 반환
console.log(Math.ceil(r * 10));
console.log(Math.floor(Math.random() * 10) + 1); //1~10사이의 랜덤한 수 (1~10)
