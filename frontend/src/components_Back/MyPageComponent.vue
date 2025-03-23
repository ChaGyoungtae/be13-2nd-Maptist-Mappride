<template>
  <div class="div">

    <div class="rectangle-4"></div>
    <div class="image-15"></div>

    <button>
      <img class="rectangle-9" src="/src/assets/images/public/rectangle-90.png" />
      <div class="logout">logout</div>
    </button>
    
    <button>
      <div class="mappride">Mappride</div>
    </button>
    
    <div class="rectangle-6"></div>

    <button>
      <div class="my-categories">My categories</div>
      <div class="rectangle-2"></div>
    </button>

    <div class="my-page">My page</div>

    <button>
      <div class="map">Map</div>
      <div class="rectangle-1"></div>
    </button>
    
    <!-- <div class="rectangle-28"></div> -->
    <img class="image-12" src="/src/assets/images/public/image-120.png" />
    <img class="image-13" src="/src/assets/images/public/image-130.png" />
    <img class="image-14" src="/src/assets/images/public/image-140.png" />
    <button>
      <img class="image-29" src="/src/assets/images/public/image-150.png" />
    </button>
    <!-- <p>{{ member.nickname }}</p> -->
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
    
    <button>
      <div class="rectangle-49"></div>
      <div class="withdrawal">withdrawal</div>
    </button>
    
    <button>
      <img class="image-27" src="/src/assets/images/public/image-290.png" />
    </button>
    <button>
      <img class="image-30" src="/src/assets/images/public/image-290.png" />
    </button>

  </div>
</template>
<script setup>

import { ref, onMounted } from 'vue';
// import axios from 'axios';

const member = ref({});

onMounted(() => {
  axios.get('/members')
  .then(response => {
    member.value = response.data;
    console.log(member);
  })
  .catch(error => {
    console.error("유저 정보 api get mapping error",error);
  });
});

// export default {
//   name: "MyPage",
//   components: {},
//   props: {},
//   data() {},
//   methods: {
//   handleClick(button) {
//     console.log(`${button} 클릭됨`);
//   }
// }
// };
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
button {
  display: flex;
  align-items: center;
  justify-content: center;
  border: none;
  background: none;
  cursor: pointer;
  
}
button:active *
{
  filter: brightness(0.95); /* 클릭 시 이미지 어둡게 */
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
  display: flex;
  left: 77.64px;
  top: 31.64px;
  width: 185.32px;
  height: 40.08px;
  -webkit-text-stroke: 1px #ffffff;
  z-index: 1;
}
.rectangle-1 {
  background: #ffffff;
  border-style: solid;
  border-color: #ffffff;
  border-width: 0px 1px 0px 0px;
  width: 335.98px;
  height: 84.38px;
  position: absolute;
  left: 0px;
  top: 343.62px;
}
.rectangle-2 {
  background: #ffffff;
  border-style: solid;
  border-color: #ffffff;
  border-width: 0px 1px 0px 0px;
  width: 335.98px;
  height: 84.38px;
  position: absolute;
  left: 0px;
  top: 512.38px;
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
  left: 19.97px;
  top: 500px;
  width: 315.56px;
  height: 104.41px;
  display: flex;
  align-items: center;
  justify-content: center;
  -webkit-text-stroke: 1px #ffffff;
  z-index: 1;
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
  height: 92.41px;
  display: flex;
  align-items: center;
  justify-content: center;
  -webkit-text-stroke: 1px #ffffff;
  border: none; /* 버튼 테두리 */
  cursor: pointer; /* 클릭 시 손 모양 커서 */
  z-index: 1;
}
.rectangle-28 {
  background: rgba(255, 255, 255, 0);
  border-style: solid;
  border-color: #d9d9d9;
  border-width: 1px;
  width: 336.87px;
  height: 1080px;
  position: absolute;
  left: 0px;
  top: 0px;
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
