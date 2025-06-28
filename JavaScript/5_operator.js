let num = 10;
num++;
console.log(num); //11

++num;
console.log(num); //12

let result = 0;
result = ++num; // ++가 num에 먼저 적용되고 그 값이 result로 저장됨.
console.log(result); //13

result = num++; //++가 저장되기 전에 result로 입력되기 때문에 13이 찍힘. num은 14가 되는게 맞음
console.log(result); //13

console.log("---------------------------");

let a = 23; //10111
let b = 14; //01110

console.log(a & b);
console.log(a | b);
console.log(a ^ b);
console.log(~a);
console.log(a << 1);
console.log(a >> 1);
