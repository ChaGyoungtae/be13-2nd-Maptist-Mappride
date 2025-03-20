<template>
  <div class="div">   
      <div class="mappride">Mappride</div>
  
      <button class="map" @click="navigateTo('map')">
          <img class="imgMap" src="/src/assets/images/public/image-120.png" />
          Map</button>
      <button class="my-page" @click="navigateTo('my-page')">
          <img class="imgPage" src="/src/assets/images/public/image-130.png" />
          My Page</button>
      <button class="my-categories" @click="navigateTo('my-categories')">
          <img class="imgCategory" src="/src/assets/images/public/image-140.png" />
          My Categories</button>    
  
      <select class="btnDD">
          <option value="address">Address</option>
          <option value="user">User</option>
      </select>
  
      <input class="txtSearch" type="text" placeholder="Search..." />
      <button class="btnSearch">search</button>
      <button class="btnLogout">logout</button>
  
      <img class="image-6" src="/src/assets/images/public/image-60.png" />
  
  </div>
  </template>
  
  <script>
  export default {
  name: "Component",
  components: {},
  props: {},
  data() {},
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
  
  
  .mappride {
    color: #000000;
    text-align: left;
    font-family: "Stylish-Regular", sans-serif;
    font-size: 30px;
    font-weight: 400;
    position: absolute;
    left: 78.27px;
    top: 31.64px;
    width: 186.84px;
    height: 40.08px;
    -webkit-text-stroke: 1px #ffffff;
  }
  
  .map, .my-page, .my-categories {
    color: #000000;
    text-align: center;
    font-family: "Stylish-Regular", sans-serif;
    font-size: 25px;
    font-weight: 400;
    position: absolute;
    width: 318.14px;
    height: 104.41px;
    display: flex;
    align-items: center;
    justify-content: center;
    -webkit-text-stroke: 1px #ffffff;
    background-color: transparent;
    border: none; /* 버튼 테두리 */
    cursor: pointer; /* 클릭 시 손 모양 커서 */
  }
  
  .map {
    top: 335.39px;
    left: 20.14px;
  }
  
  .my-page {
    top: 439.80px;
    left: 20.14px;
  }
  
  .my-categories {
    top:  544.21px;
    left: 20.14px;
  }
  
  /* Hover 상태 */
  button:hover {
    background-color: #f0f0f0;
  }
  
  .btnDD {
    background: #ffffff;
    border-style: solid;
    border-color: #d2d2d2;
    border-width: 1px;
    width: 165px;
    height: 45px;
    position: absolute;
    left: 568px;
    top: 27px;
    padding: 5px 10px; /* 텍스트와 경계선 사이에 여백을 추가 */
    font-size: 16px; /* 텍스트 크기 설정 */
    color: #000000; /* 텍스트 색상 설정 */
    cursor: pointer; /* 드롭다운 클릭 시 포인터 커서 */
  }
  
  .btnDD option {
    padding: 10px; /* 옵션 항목에 여백 추가 */
  }
  
  .btnSearch {
  color: #000000;
  text-align: center; /* 텍스트를 중앙 정렬 */
  font-family: "Stylish-Regular", sans-serif;
  font-size: 20px;
  font-weight: 400;
  position: absolute;
  left: 1267px;
  top: 27px;
  border-width: 1px;
  width: 165px;
  height: 45px;
  background-color: transparent; /* 배경을 투명하게 설정 */
  border: 2px solid #d2d2d2; /* 테두리 추가 (두께 2px, 색상 #d2d2d2) */
  cursor: pointer; /* 마우스를 올렸을 때 커서가 포인터로 바뀌게 설정 */
  -webkit-text-stroke: 1px #d2d2d2;
  display: flex;
  align-items: center;
  justify-content: center;
  }
  
  .btnSearch:hover {
    background-color: #f0f0f0; /* 버튼에 마우스를 올리면 배경색 변경 */
  }
  
  .txtSearch {
  background: #ffffff;
  border-style: solid;
  border-color: #d2d2d2;
  border-width: 1px;
  width: 460px;
  height: 46px;
  position: absolute;
  left: 752px;
  top: 26px;
  padding: 10px 15px; /* 텍스트와 경계선 사이에 여백을 추가 */
  font-size: 16px; /* 텍스트 크기 설정 */
  color: #000000; /* 텍스트 색상 설정 */
  }
  
  .txtSearch::placeholder {
    color: #d2d2d2; /* placeholder 텍스트 색상 설정 */
  }
  
  .btnLogout {
    color: #000000;
    text-align: left;
    font-family: "Stylish-Regular", sans-serif;
    font-size: 20px;
    font-weight: 400;
    position: absolute;
    left: 1804px;
    top: 27px;
    width: 120px;
    height: 45px;
    background-color: transparent; /* 배경을 투명하게 설정 */
    border: 2px solid #d2d2d2; /* 테두리 추가 (두께 2px, 색상 #d2d2d2) */
    cursor: pointer; /* 마우스를 올렸을 때 커서가 포인터로 바뀌게 설정 */
    display: flex;
    align-items: center;
    justify-content: center;
  }
  
  .btnLogout:hover {
    background-color: #f0f0f0; /* 마우스를 올리면 배경색 변경 */
  }
  
  .imgMap {
    width: 44.02px;
    height: 44.02px;
    position: absolute;
    left: 25.64px;
    object-fit: cover;
    aspect-ratio: 1;
  }
  .imgPage {
    width: 29.75px;
    height: 29.75px;
    position: absolute;
    left: 32.78px;
    object-fit: cover;
    aspect-ratio: 1;
  }
  .imgCategory {
    width: 30.94px;
    height: 30.94px;
    position: absolute;
    left: 32.86px;
    object-fit: cover;
    aspect-ratio: 1;
  }
  
  .image-6 {
    width: 1595px;
    height: 998px;
    position: absolute;
    left: 338px;
    top: 82px;
    object-fit: cover;
  }
  
  
  </style>
  