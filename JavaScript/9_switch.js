// let mbti = "ENTJ";

// switch (mbti) {
//   case "ENFP":
//     console.log("대가리 꽃밭");
//     break;
//   case "INFJ":
//     console.log("음침");
//     break;
//   case "ISTJ":
//     console.log("싸패");
//     break;
//   case "ENTJ":
//     console.log("소시오패스");
//     break;
//   default:
//     console.log("제대로 입력해라");
// }

const month = 10;

/*
if (month == 1) {
  console.log(`${month}월의 마지막 일자는 31일입니다.`);
} else if (month == 2) {
  console.log(`${month}월의 마지막 일자는 28일입니다.`);
} else if (month == 3) {
  console.log(`${month}월의 마지막 일자는 31일입니다.`);
} else if (month == 4) {
  console.log(`${month}월의 마지막 일자는 30일입니다.`);
} else if (month == 5) {
  console.log(`${month}월의 마지막 일자는 31일입니다.`);
} else if (month == 6) {
  console.log(`${month}월의 마지막 일자는 30일입니다.`);
} else if (month == 7) {
  console.log(`${month}월의 마지막 일자는 31일입니다.`);
} else if (month == 8) {
  console.log(`${month}월의 마지막 일자는 31일입니다.`);
} else if (month == 9) {
  console.log(`${month}월의 마지막 일자는 30일입니다.`);
} else if (month == 10) {
  console.log(`${month}월의 마지막 일자는 31일입니다.`);
} else if (month == 11) {
  console.log(`${month}월의 마지막 일자는 30일입니다.`);
} else if (month == 12) {
  console.log(`${month}월의 마지막 일자는 31일입니다.`);
}

if (
  month == 1 ||
  month == 3 ||
  month == 5 ||
  month == 7 ||
  month == 8 ||
  month == 10 ||
  month == 12
) {
  console.log(`${month}월의 마지막 일자는 31일입니다.`);
} else if (month == 2) {
  console.log(`${month}월의 마지막 일자는 28일입니다.`);
} else if (month == 4 || month == 6 || month == 9 || month == 11)
  console.log(`${month}월의 마지막 일자는 30일입니다.`);  */

/*
switch (month) {
  case 1:
    console.log(`${month}월의 마지막 일자는 31일입니다.`);
    break;
  case 2:
    console.log(`${month}월의 마지막 일자는 28일입니다.`);
    break;
  case 3:
    console.log(`${month}월의 마지막 일자는 31일입니다.`);
    break;
  case 4:
    console.log(`${month}월의 마지막 일자는 30일입니다.`);
    break;
  case 5:
    console.log(`${month}월의 마지막 일자는 31일입니다.`);
    break;
  case 6:
    console.log(`${month}월의 마지막 일자는 30일입니다.`);
    break;
  case 7:
    console.log(`${month}월의 마지막 일자는 31일입니다.`);
    break;
  case 8:
    console.log(`${month}월의 마지막 일자는 31일입니다.`);
    break;
  case 9:
    console.log(`${month}월의 마지막 일자는 30일입니다.`);
    break;
  case 10:
    console.log(`${month}월의 마지막 일자는 31일입니다.`);
    break;
  case 11:
    console.log(`${month}월의 마지막 일자는 30일입니다.`);
    break;
  case 12:
    console.log(`${month}월의 마지막 일자는 31일입니다.`);
    break;
} */

switch (month) {
  case 1:
  case 3:
  case 5:
  case 7:
  case 8:
  case 10:
  case 12:
    console.log(`${month}월의 마지막 일자는 31일입니다. `);
    break;
  case 2:
    console.log(`${month}월의 마지막 일자는 28일입니다. `);
    break;
  case 4:
  case 6:
  case 9:
  case 10:
    console.log(`${month}월의 마지막 일자는 30일입니다. `);
    break;
}
