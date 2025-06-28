// 접속자를 구분하기 위해서 사용자에게 고유의 아이디를 부여한다.

const express = require("express");
const session = require("express-session");

const app = express();
app.use(express.json()); //값을 json으로 주고 받자

/*
secret : 세션 ID 서명용 키 
resave : 매 요청시 저장 여부
saveUninitialized : 초기 빈 세션 저장 여부 (익명인데 세션 만들거니?)
cookie.secure : https에서만 전송

*/
app.use(
  session({
    secret: "!@#$%^&*()", //특정 암호화 키를 추가해서 섞어서 만들어용!
    resave: false,
    saveUninitialized: false, //로그인 할 때만 저장할겜
    cookie: { secure: false },
  })
);

app.post("/login", (req, res) => {
  const { userid, password } = req.body;

  // 로그인 성공 시 !
  req.session.user = { userid }; // session에 user라는 이름으로 값이 들어가있는 것
  res.send(`로그인 성공 : ${userid}`); // 메모리에 아이디가 살아있는 겨
});

app.get("/me", (req, res) => {
  if (req.session.user) {
    res.json(req.session.user);
  } else {
    res.status(401).send("로그인 필요");
  }
});

app.get("/logout", (req, res) => {
  req.session.destroy(() => {
    res.send("로그아웃됨");
  });
});

app.listen(3000, () => console.log("서버 실행 중"));
