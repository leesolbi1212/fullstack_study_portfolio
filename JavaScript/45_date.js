const now = new Date(); // 객체임. 현재 시간을 담아서 저장
console.log("현재 :", now.toString()); //윈도우에서 설정된 현재 시간

console.log("년:", now.getFullYear()); //2025 (4자리 연도)
console.log("월:", now.getMonth() + 1); //0~11 (0부터 시작하므로 +1 해줘야 함)
console.log("일:", now.getDate()); //1~31 (1일부터 시작)
console.log("요일:", now.getDay()); //0~6 (0:일요일, 1:월요일, 2:화요일, 3:수요일, 4:목요일, 5:금요일, 6:토요일)

const birthday = new Date(1997, 11, 9);
console.log("생일", birthday.toDateString()); //월이 +1 되어있음

const nowTime = now.getTime(); //1970년 1월 1일 00:00:00부터 현재까지의 밀리초
console.log(nowTime); //현재 시간 (밀리초) 실행속도 계산할 때 사용

const birthTime = birthday.getTime();
const diffDays = Math.floor(nowTime - birthTime) / (1000 * 60 * 60 * 24); //밀리초를 일로 변환
console.log(`태어난지 ${diffDays}일 지남~`);
