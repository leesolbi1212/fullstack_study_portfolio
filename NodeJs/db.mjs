import mysql from "mysql2";
import { config } from "./config.mjs";

// 미리 접속함 (속도 빠름)
const pool = mysql.createPool({
  host: config.db.host,
  user: config.db.user,
  database: config.db.database,
  password: config.db.password,
});

export const db = pool.promise();

// 그 때 그 때 접속함
// mysql.createConnection;
