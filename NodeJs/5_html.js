const http = require("http");
const fs = require("fs");
const server = http.createServer((req, res) => {
  if (req.url === "/") {
    fs.readFile("test.html", (err, data) => {
      if (err) {
        res.writeHead(500); //서버 오류를 말함
        return res.end("파일 읽기 오류");
      }
      res.writeHead(200, { "content-type": "text/html" });
      //body에 달린 값이 html이야. 그니까 html로 해석해줘
      res.end(data);
    });
  } else {
    res.writeHead(404);
    res.end("Not found");
  }
});

server.listen(3000, () => {
  console.log("서버 실행중");
});
