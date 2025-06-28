import express from "express";

const app = express();

app
  .route("/posts")
  .get((req, res) => {
    res.status(200).send("/posts Get 호출");
  })
  .post((req, res) => {
    res.status(201).send("/posts Post 호출");
  })
  .put((req, res) => {
    res.status(201).send("/posts Put 호출");
  })
  .delete((req, res) => {
    res.status(204).send("/post Delete 호출");
  });

app.listen(3000, () => {
  console.log("서버실행듕~! 뀨잉~!");
});
