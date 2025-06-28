const http = require("http");

const server = http.createServer((req, res) => {
  const url = req.url; //사용자가 들어올 때 요청정보 중 url 정보를 가져오는 것

  if (url === "/") {
    res.writeHead(200, { "Content-Type": "text/plain" });
    res.end("home");
  } else if (url === "/about") {
    res.writeHead(200, { "Content-Type": "text/plain" });
    res.end("mypage");
  } else {
    res.writeHead(404, { "Content-Type": "text/plain" });
    res.end("not found");
  }
});

//127.0.0.1 || localhost,
server.listen(3000, () => {
  console.log("서버 실행 중 → http://localhost:3000");
});
