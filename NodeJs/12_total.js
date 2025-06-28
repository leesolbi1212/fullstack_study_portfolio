const express = require("express");
const path = require("path");
const app = express();
const port = 3000;

app.use(express.urlencoded({ extended: true }));
//app.use(express.static("public")); //실제 폴더 이름, css파일이나 이미지 찾을 때 이렇게 루트를 입력하면 된다.
app.use("/static", express.static("public")); //이해 잘 안되네..
// static URL 접근, public 실제 폴더

app.set("view engine", "ejs"); //화면이 보이는 것을 ejs로 세팅하겠당
app.set("views", path.join(__dirname, "views"));

//
app.get("/", (req, res) => {
  res.send("<h2>홈페이지입니다. 다양한 기능 테스트 하쇼</h2>");
});

app.get("/user/:id", (req, res) => {
  res.send(`요청한 사용자 아이디는 ${req.params.id} 입니다.`);
});

app.get("/search", (req, res) => {
  const { keyword, number } = req.query;
  res.send(`검색어 : ${keyword}, 숫자: ${number}`);
});

app.post("/submit", (req, res) => {
  const { name, age } = req.body;
  res.send(`이름:${name}, 나이:${age}`);
});

app.get("/hello", (req, res) => {
  res.render("hello", { name: "김사과" });
});

app.get("/posts", (req, res) => {
  const posts = [
    { title: "첫 번째 글", content: "내용" },
    { title: "두 번째 글", content: "익스프레스 편해용 " },
  ];
  res.render("posts", { posts });
});

app.listen(port, () => {
  console.log("서버 실행 중");
});
