import React, { useState } from "react";
import { useNavigate, Link } from "react-router-dom";
import { loginUser } from "../api/member";

// import { Routes, Route, Navigate } from 'react-router-dom'

export default function Login() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [message, setMessage] = useState("");
  const navigate = useNavigate();
  const handleLogin = async () => {
    try {
      const token = await loginUser(username, password);
      localStorage.setItem("token", token);
      navigate("/mypage");
    } catch (e) {
      setMessage("로그인 실패");
    }
  };
  return (
    <div>
      <h2>로그인</h2>
      <p>
        아이디:{" "}
        <input value={username} onChange={(e) => setUsername(e.target.value)} />
      </p>
      <p>
        비밀번호:{" "}
        <input
          type="password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
      </p>
      <button onClick={handleLogin}>로그인</button>
      <p>{message}</p>
      <p>
        아직 회원이 아니신가요?<Link to="/register">회원가입</Link>
      </p>
    </div>
  );
}
