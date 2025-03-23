<template>
    <div class="full">

      <div href="이동할_페이지_URL" class="rectangle-6"></div>
      <div class="rectangle-10"></div>
      <div class="rectangle-20"></div>
      <div class="rectangle-26"></div>
      <div class="title">TITLE</div>
      <a href="이동할_페이지_URL" class="div2">비에이블</a>

      <div class="line-5"></div>
      <img class="line-6" src="/src/assets/images/public/line-60.png" />
      <img class="image-22" src="/src/assets/images/public/image-230.png" @click="handleClick" />
      <img class="image-23" src="/src/assets/images/public/image-230.png" @click="handleClick" />

      <div class="rectangle-28"></div>
      <a href="이동할_페이지_URL" class="div3">공부인</a>
      <img class="image-27" src="/src/assets/images/public/image-290.png" @click="handleClick" />
      <img class="image-28" src="/src/assets/images/public/image-290.png" @click="handleClick" />
      <div class="rectangle-30"></div>
      <img class="image-33" src="/src/assets/images/public/image-230.png" @click="handleClick" />
      <a href="이동할_페이지_URL" class="div4">단디</a>
      <img class="image-34" src="/src/assets/images/public/image-290.png" @click="handleClick" />
      <div class="rectangle-29"></div>
      <img class="image-31" src="/src/assets/images/public/image-230.png" @click="handleClick" />
      <<a href="이동할_페이지_URL" class="div5">랭</a>
      <img class="image-32" src="/src/assets/images/public/image-290.png" @click="handleClick" />
      <div class="rectangle-282"></div>
      <img class="image-29" src="/src/assets/images/public/image-230.png" @click="handleClick" />
      <a href="이동할_페이지_URL" class="div6">작심</a>
      <img class="image-30" src="/src/assets/images/public/image-290.png" @click="handleClick" />
      <a href="이동할_페이지_URL" class="div7">. . / 스터디카페</a>
      <div class="address">ADDRESS</div>
      <div class="_1551-6">서울특별시 노원구 동일로 1551, 6층</div>
      <div class="_1547-5">서울특별시 노원구 동일로 1547 5층</div>
      <div class="_361-1">서울특별시 노원구 중계동 361-1</div>
      <div class="_357-2-3">서울특별시 노원구 상계동 357-2 3층</div>
      <div class="_746-3-6">서울특별시 노원구 상계동 746-3 랑은빌딩 6층</div>
      <div class="color">COLOR</div>
      <div class="line-22"></div>
      <div class="ellipse-2"></div>
      <div class="ellipse-3"></div>
      <div class="ellipse-4"></div>
      <div class="ellipse-5"></div>
      <div class="ellipse-6"></div>
      <div class="div8">최신순</div>
      <img class="image-37" src="/src/assets/images/MyPlaceComponent/image-370.png" />
      <img class="image-43" src="/src/assets/images/MyPlaceComponent/image-430.png" />
    </div>
  </template>

<script>
  export default {
    name: "Two",
    components: {},
    props: {},
    data() {},
  };
</script>
  
<style scoped>
  .full * {
    box-sizing: border-box;
  }
  .full {
    position: absolute;  /* 자식 요소는 부모를 기준으로 절대 위치 */
    top: 40px;
    left: 200px;
    height: 100%;
    width: 1600px;
  }

  &:hover {
    transform: scale(1.1);
  }

  /* 클릭 시 살짝 눌리는 효과 */
  &:active {
    transform: scale(0.95);
  }
  .div {
    color: #000000;
    text-align: left;
    font-family: "Inter-Medium", sans-serif;
    font-size: 16px;
    line-height: 150%;
    font-weight: 500;
    position: absolute;
    left: 528px;
    top: 34px;
    width: 446px;
    height: 36px;
  }
  .rectangle-10 {
    background: rgba(217, 217, 217, 0);
    border-style: solid;
    border-color: #d9d9d9;
    border-width: 1px;
    width: 1550px;
    height: 67px;
    position: absolute;
    left: 150px;
    top: 91px;
  }
  .rectangle-20 {
    background: rgba(217, 217, 217, 0);
    border-style: solid;
    border-color: #d9d9d9;
    border-width: 1px;
    width: 1550px;
    height: 67px;
    position: absolute;
    left: 150px;
    top: 219px;
  }
  .rectangle-26 {
    background: rgba(217, 217, 217, 0);
    border-style: solid;
    border-color: #d9d9d9;
    border-width: 1px;
    width: 1550px;
    height: 68px;
    position: absolute;
    left: 150px;
    top: 285px;
  }
  .title {
    color: #000000;
    text-align: left;
    font-family: "Inter-Medium", sans-serif;
    font-size: 16px;
    line-height: 150%;
    font-weight: 500;
    position: absolute;
    left: 265px;
    top: 112px;
    width: 70px;
    height: 25px;
  }
  .div2 {
    color: #000000;
    text-align: left;
    font-family: "Stylish-Regular", sans-serif;
    font-size: 20px;
    font-weight: 400;
    text-decoration: underline;
    position: absolute;
    left: 201px;
    top: 237px;
    width: 225px;
    height: 22px;
  }
  .line-5 {
    margin-top: -1px;
    border-style: solid;
    border-color: #d9d9d9;
    border-width: 1px 0 0 0;
    width: 35px;
    height: 0px;
    position: absolute;
    left: 499px;
    top: 107px;
    transform-origin: 0 0;
    transform: rotate(90deg) scale(1, 1);
  }
  .line-6 {
    width: 35px;
    height: 0px;
    position: absolute;
    left: 981px;
    top: 107px;
    transform: translate(-0.5px, 0px);
    overflow: visible;
  }
  .image-22 {
    width: 27px;
    height: 28px;
    position: absolute;
    left: 1656px;
    top: 241px;
    object-fit: cover;
    aspect-ratio: 27/28;
    cursor: pointer;
    transition: transform 0.2s ease-in-out;
  }
  .image-22:active {
  transform: scale(0.95);
  }
  .image-23 {
    width: 27px;
    height: 27px;
    position: absolute;
    left: 1656px;
    top: 310px;
    object-fit: cover;
    aspect-ratio: 1;
    cursor: pointer;
    transition: transform 0.2s ease-in-out;
  }
  .image-23:active {
  transform: scale(0.95);
  }
  .group-4 {
    position: absolute;
    inset: 0;
  }

  .div3 {
    color: #000000;
    text-align: left;
    font-family: "Stylish-Regular", sans-serif;
    font-size: 20px;
    font-weight: 400;
    text-decoration: underline;
    position: absolute;
    left: 201px;
    top: 304px;
    width: 225px;
    height: 23px;
  }
  .image-27 {
    width: 37px;
    height: 36px;
    position: absolute;
    left: 1541px;
    top: 238px;
    object-fit: cover;
    aspect-ratio: 37/36;
    cursor: pointer;
    transition: transform 0.2s ease-in-out;
  }
  .image-27:active {
  transform: scale(0.95);
  }

  .image-28 {
    width: 37px;
    height: 37px;
    position: absolute;
    left: 1541px;
    top: 304px;
    object-fit: cover;
    aspect-ratio: 1;
    cursor: pointer;
    transition: transform 0.2s ease-in-out;
  }
  .image-28:active {
  transform: scale(0.95);
  }
  .rectangle-30 {
    background: rgba(217, 217, 217, 0);
    border-style: solid;
    border-color: #d9d9d9;
    border-width: 1px;
    width: 1550px;
    height: 68px;
    position: absolute;
    left: 150px;
    top: 489px;
  }
  .image-33 {
    width: 27px;
    height: 27px;
    position: absolute;
    left: 1656px;
    top: 515px;
    object-fit: cover;
    aspect-ratio: 1;
    cursor: pointer;
    transition: transform 0.2s ease-in-out;
  }
  .image-33:active {
  transform: scale(0.95);
  }
  .div4 {
    color: #000000;
    text-align: left;
    font-family: "Stylish-Regular", sans-serif;
    font-size: 20px;
    font-weight: 400;
    text-decoration: underline;
    position: absolute;
    left: 200px;
    top: 508px;
    width: 225px;
    height: 23px;
  }
  .image-34 {
    width: 37px;
    height: 37px;
    position: absolute;
    left: 1541px;
    top: 509px;
    object-fit: cover;
    aspect-ratio: 1;
    cursor: pointer;
    transition: transform 0.2s ease-in-out;
  }
  .image-34:active {
  transform: scale(0.95);
  }
  .rectangle-29 {
    background: rgba(217, 217, 217, 0);
    border-style: solid;
    border-color: #d9d9d9;
    border-width: 1px;
    width: 1550px;
    height: 68px;
    position: absolute;
    left: 150px;
    top: 421px;
  }
  .image-31 {
    width: 27px;
    height: 27px;
    position: absolute;
    left: 1656px;
    top: 445px;
    object-fit: cover;
    aspect-ratio: 1;
    cursor: pointer;
    transition: transform 0.2s ease-in-out;
  }
  .image-31:active {
  transform: scale(0.95);
  }
  .div5 {
    color: #000000;
    text-align: left;
    font-family: "Stylish-Regular", sans-serif;
    font-size: 20px;
    font-weight: 400;
    text-decoration: underline;
    position: absolute;
    left: 201px;
    top: 440px;
    width: 225px;
    height: 23px;
  }
  .image-32 {
    width: 37px;
    height: 37px;
    position: absolute;
    left: 1541px;
    top: 439px;
    object-fit: cover;
    aspect-ratio: 1;
    cursor: pointer;
    transition: transform 0.2s ease-in-out;
  }
  .image-32:active {
  transform: scale(0.95);
  }
  .rectangle-282 {
    background: rgba(217, 217, 217, 0);
    border-style: solid;
    border-color: #d9d9d9;
    border-width: 1px;
    width: 1550px;
    height: 68px;
    position: absolute;
    left: 150px;
    top: 353px;
  }
  .image-29 {
    width: 27px;
    height: 27px;
    position: absolute;
    left: 1656px;
    top: 379px;
    object-fit: cover;
    aspect-ratio: 1;
    cursor: pointer;
    transition: transform 0.2s ease-in-out;
  }
  .image-29:active {
  transform: scale(0.95);
  }
  .div6 {
    color: #000000;
    text-align: left;
    font-family: "Stylish-Regular", sans-serif;
    font-size: 20px;
    font-weight: 400;
    text-decoration: underline;
    position: absolute;
    left: 201px;
    top: 372px;
    width: 225px;
    height: 23px;
  }
  .image-30 {
    width: 37px;
    height: 37px;
    position: absolute;
    left: 1541px;
    top: 373px;
    object-fit: cover;
    aspect-ratio: 1;
    cursor: pointer;
    transition: transform 0.2s ease-in-out;
  }
  .image-30:active {
  transform: scale(0.95);
  }
  .div7 {
    color: #000000;
    text-align: left;
    font-family: "Stylish-Regular", sans-serif;
    font-size: 24px;
    font-weight: 400;
    text-decoration: underline;
    position: absolute;
    left: 154px;
    top: 174px;
  }
  .address {
    color: #000000;
    text-align: left;
    font-family: "Inter-Medium", sans-serif;
    font-size: 16px;
    line-height: 150%;
    font-weight: 500;
    position: absolute;
    left: 746px;
    top: 110px;
    width: 111px;
    height: 30px;
  }
  ._1551-6 {
    color: #000000;
    text-align: left;
    font-family: "Stylish-Regular", sans-serif;
    font-size: 20px;
    font-weight: 400;
    position: absolute;
    left: 539px;
    top: 242px;
    width: 399px;
    height: 28px;
  }
  ._1547-5 {
    color: #000000;
    text-align: left;
    font-family: "Stylish-Regular", sans-serif;
    font-size: 20px;
    font-weight: 400;
    position: absolute;
    left: 539px;
    top: 304px;
    width: 520px;
    height: 28px;
  }
  ._361-1 {
    color: #000000;
    text-align: left;
    font-family: "Stylish-Regular", sans-serif;
    font-size: 20px;
    font-weight: 400;
    position: absolute;
    left: 539px;
    top: 373px;
    width: 438px;
    height: 31px;
  }
  ._357-2-3 {
    color: #000000;
    text-align: left;
    font-family: "Stylish-Regular", sans-serif;
    font-size: 20px;
    font-weight: 400;
    position: absolute;
    left: 539px;
    top: 439px;
    width: 402px;
    height: 25px;
  }
  ._746-3-6 {
    color: #000000;
    text-align: left;
    font-family: "Stylish-Regular", sans-serif;
    font-size: 20px;
    font-weight: 400;
    position: absolute;
    left: 539px;
    top: 509px;
    width: 411px;
    height: 34px;
  }
  .color {
    color: #000000;
    text-align: left;
    font-family: "Inter-Medium", sans-serif;
    font-size: 16px;
    line-height: 150%;
    font-weight: 500;
    position: absolute;
    left: 1045px;
    top: 111px;
    width: 92px;
    height: 26px;
  }
  .line-22 {
    margin-top: -1px;
    border-style: solid;
    border-color: #d9d9d9;
    border-width: 1px 0 0 0;
    width: 35px;
    height: 0px;
    position: absolute;
    left: 1166px;
    top: 105px;
    transform-origin: 0 0;
    transform: rotate(90deg) scale(1, 1);
  }
  .ellipse-2 {
    background: #ffc1c1;
    border-radius: 50%;
    width: 25px;
    height: 25px;
    position: absolute;
    left: 1066px;
    top: 244px;
  }
  .ellipse-3 {
    background: #c1ffe9;
    border-radius: 50%;
    width: 25px;
    height: 25px;
    position: absolute;
    left: 1066px;
    top: 307px;
  }
  .ellipse-4 {
    background: #4285f4;
    border-radius: 50%;
    width: 25px;
    height: 25px;
    position: absolute;
    left: 1065px;
    top: 373px;
  }
  .ellipse-5 {
    background: #fbbc05;
    border-radius: 50%;
    width: 25px;
    height: 25px;
    position: absolute;
    left: 1065px;
    top: 443px;
  }
  .ellipse-6 {
    background: #ff0000;
    border-radius: 50%;
    width: 25px;
    height: 25px;
    position: absolute;
    left: 1065px;
    top: 509px;
  }
  .rectangle-41 {
    background: #ffffff;
    border-style: solid;
    border-color: #d9d9d9;
    border-width: 1px;
    width: 125px;
    height: 45px;
    position: absolute;
    left: 1578px;
    top: 147px;
  }
  .div8 {
    color: #000000;
    text-align: left;
    font-family: "Inter-Regular", sans-serif;
    font-size: 16px;
    font-weight: 400;
    position: absolute;
    left: 1590px;
    top: 112px;
    width: 48px;
    height: 19px;
  }
  .div9 {
    color: #000000;
    text-align: left;
    font-family: "Inter-Regular", sans-serif;
    font-size: 16px;
    font-weight: 400;
    position: absolute;
    left: 1622px;
    top: 160px;
    width: 48px;
    height: 19px;
  }
  .rectangle-43 {
    background: #ffffff;
    border-style: solid;
    border-color: #d9d9d9;
    border-width: 1px;
    width: 125px;
    height: 45px;
    position: absolute;
    left: 1578px;
    top: 189px;
  }
  .div10 {
    color: #000000;
    text-align: left;
    font-family: "Inter-Regular", sans-serif;
    font-size: 16px;
    font-weight: 400;
    position: absolute;
    left: 1622px;
    top: 202px;
    width: 48px;
    height: 19px;
  }

  .div11 {
    color: #000000;
    text-align: left;
    font-family: "Inter-Regular", sans-serif;
    font-size: 16px;
    font-weight: 400;
    position: absolute;
    left: 1622px;
    top: 247px;
    width: 48px;
    height: 19px;
  }
  .image-37 {
    width: 25px;
    height: 25px;
    position: absolute;
    left: 1550px;
    top: 111px;
    object-fit: cover;
    aspect-ratio: 1;
  }
  .image-40 {
    width: 25px;
    height: 25px;
    position: absolute;
    left: 1674px;
    top: 157px;
    object-fit: cover;
    aspect-ratio: 1;
  }
  .image-42 {
    width: 25px;
    height: 25px;
    position: absolute;
    left: 1674px;
    top: 243px;
    object-fit: cover;
    aspect-ratio: 1;
  }
  .image-41 {
    width: 25px;
    height: 25px;
    position: absolute;
    left: 1674px;
    top: 199px;
    object-fit: cover;
    aspect-ratio: 1;
  }
  .image-43 {
    width: 25px;
    height: 25px;
    position: absolute;
    left: 1650px;
    top: 112px;
    object-fit: cover;
    aspect-ratio: 1;
  }
</style>
  