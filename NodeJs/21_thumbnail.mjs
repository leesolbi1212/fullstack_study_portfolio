import express from "express";
import multer from "multer";
import sharp from "sharp";
import fs from "fs";
import path from "path";

const app = express();
const port = 3000;

const uploadDir = "uploads";
const thumbDir = path.join(uploadDir, "thumb");

if (!fs.existsSync(uploadDir)) fs.mkdirSync(uploadDir);
if (!fs.existsSync(thumbDir)) fs.mkdirSync(thumbDir);

// 파일 업로드에 대한 세팅
const storage = multer.diskStorage({
  destination: (req, file, cb) => {
    cb(null, uploadDir);
  },
  filename: (req, file, cb) => {
    const uniqueSuffix = Date.now() + "-" + file.originalname;
    cb(null, uniqueSuffix);
  },
});

const fileFilter = (req, file, cb) => {
  const allowed = /jpeg|jpg|png|gif/; //확장자명 골라내기
  const ext = path.extname(file.originalname).toLowerCase();
  const mime = file.mimetype;
  if (allowed.test(ext) && allowed.test(mime)) {
    cb(null, true);
  } else {
    cb(new Error("이미지 파일만 업로드 할 수 있습니다"));
  }
};

const upload = multer({
  storage,
  fileFilter,
  limits: { fileSize: 5 * 1024 * 1024 },
});

app.post("/upload-image", upload.single("image"), async (req, res) => {
  if (!req.file) return res.status(400).json({ error: "파일이 없습니다." });

  const { filename, path: filePath } = req.file;

  const baseName = path.parse(filename).name; //파일 이름만 추출
  const thumbnailPngName = `thumb-${baseName}.png`; //바꿔놓은 이름에서 thumb을 붙이고 .png를 붙여준 다음에
  const thumbnailPath = path.join(thumbDir, thumbnailPngName); //

  const width = parseInt(req.query.width) || 100;
  const height = parseInt(req.query.height) || 100;

  try {
    await sharp(filePath)
      .resize(width, height)
      .png() // PNG로 변환
      .toFile(thumbnailPath);

    res.json({
      message: "업로드 및 PNG 썸네일 생성 성공",
      original: `/uploads/${filename}`,
      thumbnail: `/uploads/thumb/${thumbnailPngName}`,
      size: `${width}x${height}`,
    });
  } catch (err) {
    console.error("썸네일 생성 실패:", err);
    res.status(500).json({ error: "썸네일 생성 실패" });
  }
});

app.use("/uploads", express.static(uploadDir));

app.listen(port, () => {
  console.log(`${port}번으로 서버 실행 중~!`);
});
