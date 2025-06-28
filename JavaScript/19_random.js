console.log(Math.random());

// 0~9까지의 정수중 하나를 랜덤하게 뽑기
console.log(parseInt(Math.random() * 10));

//floor() : 소수점 버림
const randomNumber = Math.floor(Math.random() * 10);
console.log(randomNumber);

//음식 자동 판매기
const menu = ["치킨", "피자", "햄버거", "김밥"];
const randomIndex = Math.floor(Math.random() * menu.length);
const randomMenu = menu[randomIndex];
console.log("내일의 점심은" + randomMenu);
