import express from "express";
import multer from "multer";
import fs from "fs";

const app = express();
const port = 3000;

// 파일 업로드에 대한 세팅
const storage = multer.diskStorage({
  destination: (req, file, cb) => {
    const uploadPath = "uploads/";
    if (!fs.existsSync(uploadPath)) {
      //업로드가 없으면 만들어줘!
      fs.mkdirSync(uploadPath);
    }
    cb(null, uploadPath);
  },
  filename: (req, file, cb) => {
    const uniqueSuffix = Date.now() + "-" + Math.round(Math.random() * 1e9); //10의 9승을 곱해서 정수로 만들어줌
    cb(null, uniqueSuffix + "-" + file.originalname);
  },
});

const upload = multer({ storage }); //실행시켜줌

// test.html의 input / name값이 들어가야함.
app.post("/upload-single", upload.single("file"), (req, res) => {
  console.log(req.file);
  res.json({
    message: "단일 파일 업로드 성공",
    file: req.file,
  });
});

app.post("/upload-multiple", upload.array("files", 5), (req, res) => {
  console.log(req.files);
  res.json({
    message: "다중 파일 업로드 성공",
    files: req.files,
  });
});

app.listen(port, () => [console.log(`${port}번으로 서버 실행 중~!`)]);
