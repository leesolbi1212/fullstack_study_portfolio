import express, { application } from "express";

const app = express();
app.use((req, res, next) => {
  // 미들웨어를 만들겠다! express의 기능 중 use안에 넣은 기능을 실행할겜!
  res.setHeader("node-msg", "Hi node.js!");
  next(); //그 다음으로 넘어갈 녀석들을 찾아서 간다.
});

app.get("/", (req, res, next) => {
  res.send("<h2>익스프레스 서버로 만든 첫번째 페이지</h2>");
  next();
});

app.get("/hello", (req, res, next) => {
  res.setHeader("Content-Type", "application/json");
  res.status(200).json({ userid: "apple", name: "김사과", age: 20 });
});

app.listen(3000, () => {
  console.log("서버 실행 중");
});
