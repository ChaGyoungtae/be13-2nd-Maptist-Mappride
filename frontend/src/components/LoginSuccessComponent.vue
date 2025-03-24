<script setup>
import { onMounted } from "vue";
import { useRouter } from "vue-router";

const router = useRouter();

onMounted(async () => {
  try {
    // 백엔드에서 로그인 성공 후 토큰을 보내는 API 호출
    const response = await fetch("http://localhost:8080/api/v1/auth/login-success", {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
      },
      credentials: "include", // 쿠키 기반 인증이 필요하다면 추가
    });

    if (!response.ok) {
      throw new Error("서버 응답 오류");
    }

    // JSON 응답 파싱
    const data = await response.json();
    const accessToken = data.accessToken;

    if (accessToken) {
      // 토큰을 localStorage에 저장
      localStorage.setItem("accessToken", accessToken);

      // 알림창 띄우기
      alert("로그인 성공! 🎉");

      // /main 페이지로 이동
      router.push({name:"Main"});

    } else {
      throw new Error("토큰을 받지 못했습니다.");
    }
  } catch (error) {
    console.error("로그인 처리 중 오류 발생:", error);
    alert("로그인 실패! 다시 시도해주세요.");
    router.push("/login"); // 로그인 실패 시 로그인 페이지로 이동
  }
});
</script>

<template>
  <div>로그인 중...</div>
</template>
