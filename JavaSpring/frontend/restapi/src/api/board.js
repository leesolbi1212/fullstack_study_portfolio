import axios from "axios";

const BASE_URL = "http://localhost:8080/api/posts";

export const createPost = async (post, token) => {
  const res = await axios.post(BASE_URL, post, {
    headers: { Authorization: `Bearer ${token}` },
    withCredentials: true,
  });
  return res.data;
};

export const getPosts = async (page = 1, size = 10) => {
  const token = localStorage.getItem("token");
  const res = await axios.get(`${BASE_URL}?size=${size}`, {
    headers: {
      Authorization: `Bearer : ${token}`,
    },
    withCredentials: true,
  });
  return res.data;
};
