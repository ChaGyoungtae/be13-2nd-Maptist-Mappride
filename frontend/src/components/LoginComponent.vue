<template>
  <div class="full">
    <img class="image-6" src="../assets/images/public/image-60.png" />
    <div class="user">user</div>

    <div class="line-1"></div>
    <div class="rectangle-12"></div>
    <div class="rectangle-13"></div>
    <!-- <img class="web-light-sq-si-4-x" src="../assets/images/loginComponent/web-light-sq-si-4-x0.png" />
    <img
      class="kakao-login-medium-narrow"
      src="../assets/images/loginComponent/kakao-login-medium-narrow0.png"
    />
    <img class="btn-g" src="../assets/images/loginComponent/btn-g0.png" /> -->

    <button @click="redirectToGoogle()" class="google-login-button">
      <img src="../assets/images/loginComponent/web-light-sq-si-4-x0.png" alt="Web Login" />
    </button>
    
    <button @click="redirectToKakao()" class="kakao-login-button">
      <img src="../assets/images/loginComponent/kakao-login-medium-narrow0.png" alt="Kakao Login" />
    </button>
    
    <button @click="redirectToNaver()" class="naver-login-button">
      <img src="../assets/images/loginComponent/btn-g0.png" alt="Naver Login" />
    </button>
    <div class="line-13"></div>
  </div>
</template>

<script>
  export default {
    name: "Component",
    components: {},
    props: {},
    data() {},
    methods: {
    redirectToGoogle() {
      window.location.href = "http://localhost:8080/oauth2/authorization/google";
    },
    redirectToKakao() {
      window.location.href = "http://localhost:8080/oauth2/authorization/kakao";
    },
    redirectToNaver() {
      window.location.href = "http://localhost:8080/oauth2/authorization/naver";
    }
  }
  };
</script>
  
<style scoped>
  .full * {
    box-sizing: border-box;
  }
  .full {
    top: 10px;
    height: 100%;
    width: 1600px;
  }
  .image-6 {
    position: absolute;
    left: 350px;
    top: 78px;
    object-fit: cover;
    aspect-ratio: 1668/1002;
  }
  .user {
    color: #000000;
    text-align: left;
    font-family: "Stylish-Regular", sans-serif;
    font-size: 20px;
    font-weight: 400;
    position: absolute;
    left: 464px;
    top: 77px;
    -webkit-text-stroke: 1px #d2d2d2;
  }
  .login {
    color: #000000;
    text-align: left;
    font-family: "Stylish-Regular", sans-serif;
    font-size: 20px;
    font-weight: 400;
    position: absolute;
    left: 1804px;
    top: 36px;
    width: 67px;
    height: 26px;
  }
  .group-1 {
    position: absolute;
    inset: 0;
  }
  .line-1 {
    margin-top: -1px;
    border-style: solid;
    border-color: #ffffff;
    border-width: 1px 0 0 0;
    width: 248.38px;
    height: 0px;
    position: absolute;
    left: 0px;
    top: 144.49px;
  }
  .rectangle-12 {
    background: #d9d9d9;
    opacity: 0.8;
    width: 1668px;
    height: 994px;
    position: absolute;
    left: 350px;
    top: 78px;
  }
  .group-2 {
    position: absolute;
    inset: 0;
  }
  .rectangle-13 {
    background: #ffffff;
    width: 303px;
    height: 380px;
    position: absolute;
    left: 865px;
    top: 370px;
  }
  .web-light-sq-si-4-x {
    border-style: solid;
    border-color: #e1e1e1;
    border-width: 1px;
    width: 208px;
    height: 43px;
    position: absolute;
    left: 913px;
    top: 449px;
    object-fit: cover;
  }
  .kakao-login-medium-narrow {
    width: 208px;
    height: 43px;
    position: absolute;
    left: 913px;
    top: 523px;
    object-fit: cover;
  }
  .btn-g {
    width: 208px;
    height: 43px;
    position: absolute;
    left: 913px;
    top: 597px;
    object-fit: cover;
  }

  .google-login-button, .kakao-login-button, .naver-login-button {
    width: 208px;
    height: 43px;
    position: absolute;
    left: 913px;
    border: none;
    cursor: pointer;
    display: flex;
    align-items: center;
    justify-content: center;
    border-radius: 5px;
    padding: 0;
  }
  .google-login-button {
    top: 449px;
    background-color: #e1e1e1;
  }
  .kakao-login-button {
    top: 523px;
    background-color: #ffeb00;
  }
  .naver-login-button {
    top: 597px;
    background-color: #4285F4;
  }
  .naver-login-button img, .kakao-login-button img, .google-login-button img {
    width: 100%;
    height: 100%;
    object-fit: cover;
    border-radius: 5px;
  }
  .line-13 {
    margin-top: -2px;
    border-style: solid;
    border-color: #d9d9d9;
    border-width: 2px 0 0 0;
    width: 933px;
    height: 0px;
    position: absolute;
    left: -662px;
    top: 91px;
    transform-origin: 0 0;
    transform: rotate(89.819deg) scale(1, 1);
  }
</style>
  