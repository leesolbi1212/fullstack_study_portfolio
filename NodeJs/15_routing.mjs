import express from "express";
import userRouter from "./routes/user.mjs";
import postRouter from "./routes/posts.mjs";

const app = express();

app.use(express.json());

// http://localhost:3000/users
app.use("/users", userRouter);
// http://localhost:3000/posts
app.use("/posts", postRouter);

app.listen(3000);
