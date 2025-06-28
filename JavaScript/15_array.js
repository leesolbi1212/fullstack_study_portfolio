const user = [1, "apple", "김사과", "20", "서울 서초구!"];
console.log(user);
console.log(user[0]);
console.log(user[1]);
console.log(user[2]);
console.log(user[3]);
console.log(user[4]);
console.log(user[5]);

user[7] = "여자";
console.log(user);

user[4] = "서울 강남구";
console.log(user);
console.log(user.length);

for (let i = 0; i <= 7; i++) {
  console.log(user[i]);
}

console.log("---------------------------");

user.push("ENTJ");
console.log(user);

let temp = user.pop(); //제거 하고 temp에 담아줌
console.log(user);
console.log(temp);

temp = user.shift();
console.log(user);
console.log(temp);

const profile = ["a형", "ENTJ"];
result = user.concat(profile);
console.log(result);

result = user.join("🐸");
console.log(result);

const arr = ["apple", "banana", "Apple", "orange", "melon"];
arr.sort();
console.log(arr);

arr.reverse();
console.log(arr);
