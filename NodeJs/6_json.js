const http = require("http");

const server = http.createServer((req, res) => {
  if (req.url === "/api/user") {
    const user = {
      name: "김사과",
      age: 20,
      job: "개발자",
    };
    res.writeHead(200, { "Content-Type": "application/json" });
    res.end(JSON.stringify(user)); //문자열로 바꿔 보내기!
  } else {
    res.writeHead(404);
    res.end("Not Found");
  }
});

server.listen(3000, () => {
  console.log("서버 실행 중 → http://localhost:3000");
});

// 클라이언트는 이 주소를 fetch 함수를 통해 접근
//
