import React, { useEffect, useMemo, useState } from "react";
import { getUserInfo, logoutUser } from "../api/member";
import { Link, useNavigate } from "react-router-dom";
export default function Mypage() {
  // 객체를 저장하고 싶다면 useState에 null을 넣어줌
  const [user, setUser] = useState(null);
  const [message, setMessage] = useState("");
  //   const token = localStorage.getItem("token");
  const navigate = useNavigate();
  const token = useMemo(() => localStorage.getItem("token"));
  // useEffect(함수 , 의존성배열[])
  // 파라미터   설명
  //첫 번째 인자 실행할 함수 (Effect)
  //두 번째 인자 의존성 배열 (Dependency Array)
  // → 생략 시 모든 렌더링 후 실행
  // → 빈 배열 []  한 번만 실행 (mount 시)
  // → [변수] 해당 변수 변경 시만 실행
  useEffect(() => {
    getUserInfo(token)
      .then((res) => setUser(res))
      .catch(() => setMessage("사용자 정보를 불러오지 못했습니다."));
  }, [token]);
  if (!user) return <div>로딩 중 ...</div>;
  const handleLogout = async () => {
    await logoutUser(token);
    localStorage.removeItem("token");
    navigate("/login");
  };
  return (
    <div>
      <h2>마이페이지</h2>
      <p>아이디: {user.username} </p>
      <p>이름: {user.name}</p>
      <button onClick={handleLogout}>로그아웃</button>
      <hr></hr>
      <h3>메뉴</h3>
      <p>
        <Link to="/editprofile">회원정보 수정</Link>
      </p>
      <p>
        <Link to="/board">게시판</Link>
      </p>
      <p>{message}</p>
    </div>
  );
}
