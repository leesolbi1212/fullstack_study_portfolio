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
console.log(str1.charAt(7)); //안
