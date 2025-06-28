const path = require("path");

// 경로 알아내기 //

console.log(__dirname); //현재 디렉토리
console.log(__filename); //현재 파일
console.log(path.sep); //현재 디렉토리를 나눌 때 뭘 기준으로 나누니?
console.log(path.sep); //현재 디렉토리를 나눌 때 뭘 기준으로 나누니?
console.log(path.delimiter); //마침표 출력..

console.log(path.basename(__filename)); //파일이름만 추출할 수 있다.
console.log(path.basename(__filename, ".js")); //확장자를 제외하고 추출
console.log(path.dirname(__filename)); //폴더(디렉토리)만 추출
console.log(path.extname(__filename)); //확장명만 출력
