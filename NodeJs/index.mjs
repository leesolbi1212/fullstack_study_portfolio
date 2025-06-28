import {
  createUser,
  deleteUser,
  getUsers,
  updateUserEmail,
} from "./userRepository.mjs";
import { db } from "./db.mjs";

async function main() {
  // select
  //   const users = await getUsers();
  //   console.log("사용자 목록 :", users);

  // insert
  /*
  const newUserID = await createUser(
    "solbi",
    "1209",
    "솔비",
    "010-1234-1234",
    "ehql@naver.com",
    "여자",
    "000000",
    "0000000",
    "11111",
    "서울시 서초구 양재동",
    "at센터",
    "(양재동)"
  );
  console.log("새 사용자 id:", newUserID);
 

  // update
  const updateCount = await updateUserEmail(1, "apple@naver.com");
  console.log("수정된 사용자 수 :", updateCount); */

  //delete
  const deletedCount = await deleteUser(10);
  console.log("삭제된 사용자 수:", deletedCount);

  await db.end(); //풀 종료하기 (보통 사용 잘 안해용~!)
}

main();
