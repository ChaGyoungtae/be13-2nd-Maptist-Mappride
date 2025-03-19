<template>
    <div class="div">
      <div class="rectangle-4"></div>
      <div class="image-15"></div>

      <img class="rectangle-9" src="/src/assets/images/public/rectangle-90.png" />
      <button class="rectangle-9" @click="handleClick('logout')"></button>
      <div class="logout">logout</div>
      <button class="logout" @click="handleClick('logout')"></button>

      <button class="rectangle-1" @click="handleClick('mappride')"></button>
      <div class="mappride">Mappride</div>
      <button class="mappride" @click="handleClick('mappride')"></button>

      <button class="rectangle-2" @click="handleClick('rectangle-2')"></button>
      <div class="my-categories">My categories</div>
      <button class="my-categories" @click="handleClick('my-categories')"></button>

      <div class="my-page">My page</div>

      <button class="rectangle-3" @click="handleClick('map')"></button>
      <div class="map">Map</div>
      <button class="map" @click="handleClick('map')"></button>


      <img class="image-12" src="/src/assets/images/public/image-120.png" />
      <img class="image-13" src="/src/assets/images/public/image-130.png" />
      <img class="image-14" src="/src/assets/images/public/image-140.png" />
      <!-- <div class="rectangle-28"></div> -->
      <div class="line-335"></div>

      <img class="image-29" src="/src/assets/images/public/image-150.png" />
      <button class="image-29" @click="handleClick('notification')"></button>

      <input type="text" class="rectangle-29" value=""/>
      <div class="nickname">Nickname</div>
      <input type="text" class="rectangle-30" value=""/>
      <div class="email">Email</div>
      <input type="text" class="rectangle-33" value=""/>
      <div class="name">Name</div>
      <input type="text" class="rectangle-34" value=""/>
      <div class="birthday">Birthday</div>
      <input type="text" class="rectangle-31" value=""/>
      <div class="grade">Grade</div>
      <input type="text" class="rectangle-32" value=""/>
      <div class="user-type">User Type</div>

      <button class="rectangle-49" @click="handleClick('rec')"></button>
      <div class="withdrawal">withdrawal</div>
      <button class="withdrawal" @click="handleClick('withdrawal')"></button>

      <img class="image-27" src="/src/assets/images/public/image-290.png" />
      <button class="image-27" @click="handleClick('modify')"></button>
      <img class="image-30" src="/src/assets/images/public/image-290.png" />
      <button class="image-30" @click="handleClick('modify')"></button>

    </div>
  </template>
  <script>
  export default {
    name: "Component",
    components: {},
    props: {},
    data() {},
    methods: {
    handleClick(button) {
      console.log(`${button} 클릭됨`);
    }
  }
  };
  </script>
  <style scoped>
  .div,
  .div * {
    box-sizing: border-box;
  }
  .div {
    background: #ffffff;
    height: 1080px;
    position: relative;
    overflow: hidden;
  }
  .rectangle-4 {
    background: #ffffff;
    border-style: solid;
    border-color: #d3d3d3;
    border-width: 0px 0px 1px 0px;
    width: 1583px;
    height: 91px;
    position: absolute;
    left: 337px;
    top: 0px;
  }
  .image-15 {
    width: 48px;
    height: 61px;
    position: absolute;
    left: 1632px;
    top: 30px;
  }
  .rectangle-9 {
    width: 125px;
    height: 45px;
    position: absolute;
    left: 1760px;
    top: 23px;
    overflow: visible;
  }
  .logout {
    color: #000000;
    text-align: left;
    font-family: "Stylish-Regular", sans-serif;
    font-size: 20px;
    font-weight: 400;
    position: absolute;
    left: 1790px;
    top: 32px;
    width: 66px;
    height: 26px;
  }
  .group-5 {
    position: absolute;
    inset: 0;
  }
  .mappride {
    color: #000000;
    text-align: left;
    font-family: "Stylish-Regular", sans-serif;
    font-size: 30px;
    font-weight: 400;
    position: absolute;
    left: 77.64px;
    top: 31.64px;
    width: 185.32px;
    height: 40.08px;
    -webkit-text-stroke: 1px #ffffff;
  }
  .rectangle-1 {
    background: #f7f7f7;
    border-style: solid;
    border-color: #b9adad;
    border-width: 0px 1px 0px 0px;
    width: 335.98px;
    height: 104px;
    position: absolute;
    left: 0px;
    top: 0px;
  }  .rectangle-2 {
    background: #f5f4f4;
    border-style: solid;
    border-color: #e8e7e7;
    border-width: 0px 1px 0px 0px;
    width: 335.98px;
    height: 84.38px;
    position: absolute;
    left: 0px;
    top: 512.38px;
  }  .rectangle-3 {
    background: #f3f3f3;
    border-style: solid;
    border-color: #ffffff;
    border-width: 0px 1px 0px 0px;
    width: 335.98px;
    height: 84.38px;
    position: absolute;
    left: 0px;
    top: 343.62px;
  }
  .rectangle-6 {
    background: #f7f7f7;
    border-style: solid;
    border-color: #ffffff;
    border-width: 0px 1px 0px 0px;
    width: 335.98px;
    height: 84.38px;
    position: absolute;
    left: 0px;
    top: 428px;
  }
  .my-categories {
    color: #000000;
    text-align: center;
    font-family: "Stylish-Regular", sans-serif;
    font-size: 25px;
    font-weight: 400;
    position: absolute;
    left: 46.6px;
    top: 494.65px;
    width: 291.6px;
    height: 104.41px;
    display: flex;
    align-items: center;
    justify-content: center;
    -webkit-text-stroke: 1px #ffffff;
  }
  .my-page {
    color: #000000;
    text-align: center;
    font-family: "Stylish-Regular", sans-serif;
    font-size: 25px;
    font-weight: 400;
    position: absolute;
    left: 19.97px;
    top: 419.77px;
    width: 315.56px;
    height: 104.41px;
    display: flex;
    align-items: center;
    justify-content: center;
    -webkit-text-stroke: 1px #ffffff;
  }
  .map {
    color: #000000;
    text-align: center;
    font-family: "Stylish-Regular", sans-serif;
    font-size: 25px;
    font-weight: 400;
    position: absolute;
    left: 19.97px;
    top: 335.39px;
    width: 315.56px;
    height: 104.41px;
    display: flex;
    align-items: center;
    justify-content: center;
    -webkit-text-stroke: 1px #ffffff;
  }
  .rectangle-28 {
    background: rgba(255, 255, 255, 0);
    border-style: solid;
    border-color: #d9d9d9;
    border-width: 1px;
    width: 336.87px;
    height: 1080px;
    position: relative;
    left: 0px;
    top: 0px;
  }
  .line-335{
    position: absolute;
    left: 335.98px;
    top: 0;
    width: 2px;
    height: 100vh;
    background-color: rgba(255, 255, 255, 0);
    z-index: 1;
  }
  .image-12 {
    width: 43.85px;
    height: 43.85px;
    position: absolute;
    left: 25.34px;
    top: 365.67px;
    object-fit: cover;
    aspect-ratio: 1;
  }
  .image-13 {
    width: 29.63px;
    height: 29.63px;
    position: absolute;
    left: 32.45px;
    top: 455.05px;
    object-fit: cover;
    aspect-ratio: 1;
  }
  .image-14 {
    width: 30.81px;
    height: 30.81px;
    position: absolute;
    left: 32.53px;
    top: 531.98px;
    object-fit: cover;
    aspect-ratio: 1;
  }
  .image-29 {
    width: 45px;
    height: 45px;
    position: absolute;
    left: 1632px;
    top: 22px;
    object-fit: cover;
    aspect-ratio: 1;
  }
  .rectangle-29 {
    background: #f7f7f9;
    width: 275px;
    height: 63px;
    position: absolute;
    left: 523px;
    top: 503px;
  }
  .nickname {
    color: #999895;
    text-align: left;
    font-family: "Inter-Medium", sans-serif;
    font-size: 16px;
    line-height: 150%;
    font-weight: 500;
    position: absolute;
    left: 523px;
    top: 467px;
    width: 87px;
    height: 25px;
  }
  .rectangle-30 {
    background: #f7f7f9;
    width: 275px;
    height: 64px;
    position: absolute;
    left: 523px;
    top: 629px;
  }
  .email {
    color: #999895;
    text-align: left;
    font-family: "Inter-Medium", sans-serif;
    font-size: 16px;
    line-height: 150%;
    font-weight: 500;
    position: absolute;
    left: 523px;
    top: 593px;
    width: 46px;
    height: 25px;
  }
  .rectangle-33 {
    background: #f7f7f9;
    width: 275px;
    height: 64px;
    position: absolute;
    left: 523px;
    top: 245px;
  }
  .name {
    color: #999895;
    text-align: left;
    font-family: "Inter-Medium", sans-serif;
    font-size: 16px;
    line-height: 150%;
    font-weight: 500;
    position: absolute;
    left: 523px;
    top: 209px;
    width: 51px;
    height: 25px;
  }
  .rectangle-34 {
    background: #f7f7f9;
    width: 275px;
    height: 64px;
    position: absolute;
    left: 523px;
    top: 371px;
  }
  .birthday {
    color: #999895;
    text-align: left;
    font-family: "Inter-Medium", sans-serif;
    font-size: 16px;
    line-height: 150%;
    font-weight: 500;
    position: absolute;
    left: 523px;
    top: 335px;
    width: 73px;
    height: 26px;
  }
  .rectangle-31 {
    background: #f7f7f9;
    width: 275px;
    height: 64px;
    position: absolute;
    left: 523px;
    top: 769px;
  }
  .grade {
    color: #999895;
    text-align: left;
    font-family: "Inter-Medium", sans-serif;
    font-size: 16px;
    line-height: 150%;
    font-weight: 500;
    position: absolute;
    left: 523px;
    top: 733px;
    width: 53px;
    height: 26px;
  }
  .rectangle-32 {
    background: #f7f7f9;
    width: 275px;
    height: 64px;
    position: absolute;
    left: 523px;
    top: 895px;
  }
  .user-type {
    color: #999895;
    text-align: left;
    font-family: "Inter-Medium", sans-serif;
    font-size: 16px;
    line-height: 150%;
    font-weight: 500;
    position: absolute;
    left: 523px;
    top: 859px;
    width: 88px;
    height: 26px;
  }
  .rectangle-49 {
    background: #f7f7f7;
    width: 143px;
    height: 36px;
    position: absolute;
    left: 1710px;
    top: 1004px;
  }
  .withdrawal {
    color: #ff0000;
    text-align: left;
    font-family: "Inter-Regular", sans-serif;
    font-size: 20px;
    font-weight: 400;
    position: absolute;
    left: 1730px;
    top: 1009px;
    width: 155px;
    height: 31px;
  }
  .image-27 {
    width: 37px;
    height: 37px;
    position: absolute;
    left: 857px;
    top: 387px;
    object-fit: cover;
    aspect-ratio: 1;
  }
  .image-30 {
    width: 37px;
    height: 37px;
    position: absolute;
    left: 857px;
    top: 510px;
    object-fit: cover;
    aspect-ratio: 1;
  }
  </style>
  