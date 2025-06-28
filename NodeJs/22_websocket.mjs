/*
    웹소켓 
    서버가 존재할 때 서버 소켓이라는 걸 만듦.
    이걸 띄워놔. 그럼 클라이언트가 아이피와 포트를통해서 서버에 접속하게 되면 핸드쉐이크를 통해 연결됨. 다른 클라이언트가 생기면 또 소켓을 만듦 
    서버가 먼저 대화를 걸 수 없어요. 클라이언트가 먼저 웹사이트에 접속(req)을 하고 응답해야한다. 
    핑퐁핑퐁~ 을 이용해서 연결이 되어있는지 
    
    웹 브라우저와 서버 사이에 지속적으로 연결을 유지하면서 실시간으로 데이터를 주고 받을 수 있는 통신 방식 

    http처럼 요청-응답이 아니라 한 번 연결되면 서버와 클라이언트가 자유롭게 메시지를 주고 받는다. (실시간 채팅, 알림, 실시간 데이터 앱에 적합)

    socket.io : 일반적인 소켓 기술을 웹에서 구현하기 위한 모듈 

    일단 http가 있어야 한다. 

    
*/

import express from "express";
import { createServer } from "http";
import path from "path";
import { Server } from "socket.io";
import { fileURLToPath } from "url";
import fs from "fs";

const app = express();
const server = createServer(app);
const io = new Server(server);
// ES(.mjs)에서는 __dirname, __filename이 없음
// import.meta.url: 현재 파일의 경로
// fileURLToPath: 실제 경로를 문자열로 변환
// path.dirname: 디렉토리 이름만 추출
const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

app.use(express.static(path.join(__dirname, "public")));

const users = {};

io.on("connection", (socket) => {
  socket.on("join", ({ nickname, channel }) => {
    socket.nickname = nickname;
    socket.channel = channel;
    users[socket.id] = { nickname, channel };
    socket.join(channel);

    const msg = { user: "system", text: `${nickname}님이 입장했습니다.` };
    io.to(channel).emit("message", msg);
    console.log("nickname: ", nickname, "channel :", channel);

    updateUserList();
  });

  socket.on("chat", ({ text, to }) => {
    const sender = users[socket.id];
    if (!sender) return;
    const payload = { user: sender.nickname, text };

    if (to) {
      const receiverSocket = Object.entries(users).find(
        ([id, u]) => u.nickname === to
      )?.[0]; // [0] 소켓id, ?.(옵셔널 체이닝): 값이 undefined일 경우 에러 없이 넘어가게 함(사용자가 없을 수도 있으니 안전하게 접근)
      if (receiverSocket) {
        io.to(receiverSocket).emit("whisper", payload);
        socket.emit("whisper", payload);
      }
    } else {
      io.to(sender.channel).emit("message", payload);
      // console.log("sender.channel: ", sender.channel, "payload: ", payload);
    }
  });

  socket.on("changeChannel", ({ newChannel }) => {
    const oldChannel = socket.channel;
    const nickname = socket.nickname;
    socket.leave(oldChannel);
    io.to(oldChannel).emit("message", {
      user: "system",
      text: `${nickname}님이 ${newChannel} 채널로 이동했습니다`,
    });
    socket.channel = newChannel;
    users[socket.id].channel = newChannel;
    socket.join(newChannel);

    const joinMsg = { user: "system", text: `${nickname}님이 입장했습니다` };
    io.to(newChannel).emit("message", joinMsg);
    updateUserList();
  });

  socket.on("disconnect", () => {
    const user = users[socket.id];
    if (user) {
      const msg = {
        user: "system",
        text: `${user.nickname}님이 퇴장했습니다.`,
      };
      io.to(user.channel).emit("message", msg);
      delete users[socket.id];

      updateUserList();
    }
  });

  function updateUserList() {
    const userList = Object.values(users); // [{nickname, channel}, .. ]
    io.emit("userList", userList);
  }
});

server.listen(3000, () => {
  console.log("서버 실행 중");
});
