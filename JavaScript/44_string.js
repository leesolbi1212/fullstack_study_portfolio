const str1 = "안녕하세요 JavaScript";
const str2 = new String("안녕하세요 JavaScript"); //생성자 함수로 생성한 객체
console.log(str1); //안녕하세요 JavaScript
console.log(str2); //String { '안녕하세요 JavaScript' }
console.log(str1 === str2); //false (문자열과 객체는 다르다.)
console.log(str1 == str2); //true (문자열과 객체는 같다고 판단한다.)
// 타입은 다르지만 값은 같다고 판단한다.

//length() 문자열의 길이를 저장
console.log(str1.length); //16 (문자열의 길이)
console.log(str2.length); //16 (문자열의 길이)

//indexOf() 특정 문자열이 몇번째에 있는지 확인 (처음으로 등장하는 위치를 인덱스로 반환)
console.log(str1.indexOf("J")); //6 (0부터 시작)
console.log(str1.indexOf("Java")); //6 (0부터 시작)
console.log(str1.indexOf("자바")); //-1 (존재하지 않음)

//charAt() 특정 인덱스에 있는 문자를 반환
console.log(str1.charAt(7)); //a (7번째 인덱스에 있는 문자)

//includes() 특정 문자열이 포함되어 있는지 확인 (true/false)
console.log(str1.includes("Java")); //true (포함되어 있음)
console.log(str1.includes("자바")); //false (포함되어 있지 않음)

//⭐substring() 특정 인덱스부터 특정 인덱스까지 문자열을 반환 (시작 인덱스 포함, 끝 인덱스 직전까지)
console.log(str1.substring(6)); //JavaScript (6번째 인덱스부터 끝까지)
console.log(str1.substring(6, 10)); //Java (6번째 인덱스부터 10번째 인덱스 직전까지)

//replace() 특정 문자열을 다른 문자열로 치환
console.log(str1.replace("안녕하세요", "hello")); //hello JavaScript (안녕하세요를 hello로 치환)

//split() 특정 문자열을 기준으로 나누기 (배열로 반환)
const str3 = "김사과, 오렌지, 반하나, 이메론, 배애리";
const students = str3.split(", "); //문자열을 배열로 나누기
console.log(students); //['김사과', ' 오렌지', ' 반하나', ' 이메론', ' 배애리']
console.log(students.length); //5 (배열의 길이)
console.log(students[0]); //김사과 (0번째 인덱스)
for (let i in students) {
  console.log(i, students[i]); //0 김사과 1 오렌지 2 반하나 3 이메론 4 배애리
}

//trim() 문자열의 앞뒤 공백 제거
const str4 = "   JavaScript    ";
console.log(`⭐${str4}⭐`);
console.log(`⭐${str4.trim()}⭐`); //⭐JavaScript⭐ (앞뒤 공백 제거)
console.log(`⭐${str4.trimStart()}⭐`); //⭐JavaScript    ⭐ (앞 공백 제거)

//toUpperCase() 대문자로 변환, toLowerCase() 소문자로 변환
console.log(`⭐${str4.trim().toLowerCase()}⭐`);
console.log(`⭐${str4.trim().toUpperCase()}⭐`);
