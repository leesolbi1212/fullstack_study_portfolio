import { defineConfig } from "vite";
import react from "@vitejs/plugin-react";

export default defineConfig({
  // ◼️ Vite 플러그인 등록
  plugins: [
    react(), // → React(JSX) 지원 + Fast Refresh
  ],

  server: {
    proxy: {
      // 단축형(문자열)도 동작은 하지만…
      // "/api": "http://localhost:8080",

      // 권장형: 옵션 지정 가능
      "/api": {
        target: "http://localhost:8080", // 백엔드 주소
        changeOrigin: true, // 호스트 헤더 변경
        rewrite: (path) => path.replace(/^\/api/, ""), // /api 제거
      },
    },
  },
});
