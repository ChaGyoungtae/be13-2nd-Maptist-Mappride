<template>
    <div class="_2">
      <div class="rectangle-4"></div>
      <img class="image-15" src="/src/assets/images/public/image-150.png" @click="handleClick" />
      <img class="rectangle-9" src="/src/assets/images/public/rectangle-90.png" />
      <div class="rectangle-31"></div>
      <button class="logout-button">Logout</button>
      <button class="search-button">Search</button>

      <input type="text" class="rectangle-5"  placeholder="   . . ." />
      <div href="이동할_페이지_URL" class="rectangle-6"></div>
      <div class="name">name</div>
      <div class="rectangle-10"></div>
      <div class="rectangle-20"></div>
      <div class="rectangle-26"></div>
      <div class="title">TITLE</div>
      <a href="이동할_페이지_URL" class="div2">비에이블</a>

      <div class="line-5"></div>
      <img class="line-6" src="/src/assets/images/public/line-60.png" />
      <img class="image-22" src="/src/assets/images/public/image-230.png" @click="handleClick" />
      <img class="image-23" src="/src/assets/images/public/image-230.png" @click="handleClick" />
      <a href="이동할_페이지_URL" class="mappride">Mappride</a>
      <div class="rectangle-62"></div>
      <a href="이동할_페이지_URL" class="my-categories">My categories</a>
      <a href="이동할_페이지_URL" class="my-page">My page</a>
      <a href="이동할_페이지_URL" class="map">Map</a>
      <div class="rectangle-28"></div>
      <img class="image-12" src="/src/assets/images/public/image-120.png" />
      <img class="image-13" src="/src/assets/images/public/image-130.png" />
      <img class="image-14" src="/src/assets/images/public/image-140.png" />
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
  ._2,
  ._2 * {
    box-sizing: border-box;
  }
  ._2 {
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
    width: 1582px;
    height: 91px;
    position: absolute;
    left: 337px;
    top: 0px;
  }
  .image-15 {
    width: 45px;
    height: 45px;
    position: absolute;
    left: 1634px;
    top: 27px;
    object-fit: cover;
    aspect-ratio: 1;
    cursor: pointer;
    transition: transform 0.2s ease-in-out;
  }
  .image-15:active {
  transform: scale(0.95);
  }
  .rectangle-9 {
    width: 125px;
    height: 45px;
    position: absolute;
    left: 1758px;
    top: 23px;
    overflow: visible;
  }
  .logout-button {
  width: 125px;
  height: 45px;
  position: absolute;
  left: 1758px;
  top: 23px;
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 8px; 
  background: white;
  border: 1px solid #d9d9d9;
  border-radius: 5px;
  cursor: pointer;
  font-size: 16px;
  font-weight: bold;
  color: #333;
  transition: background 0.3s, transform 0.2s ease-in-out;
}

/* 마우스 호버 효과 */
.logout-button:hover {
  background: #f0f0f0;
}
.search-button:hover {
  background: #f0f0f0;
}

/* 클릭 효과 */
.logout-button:active {
  transform: scale(0.95);
}
.search-button:active {
  transform: scale(0.95);
}
&:hover {
  transform: scale(1.1);
}

/* 클릭 시 살짝 눌리는 효과 */
&:active {
  transform: scale(0.95);
}

  /* .rectangle-31 {
    width: 125px;
    height: 45px;
    position: absolute;
    left: 1778px;
    top: 102px; 높이는 
    overflow: visible;
  } */
  .rectangle-31 {
    background: #ffffff;
    border-style: solid;
    border-color: #d9d9d9;
    border-width: 1px;
    width: 125px;
    height: 45px;
    position: absolute;
    left: 1778px;
    top: 102px;
  }
  .logout {
    color: #000000;
    text-align: left;
    font-family: "Stylish-Regular", sans-serif;
    font-size: 20px;
    font-weight: 400;
    position: absolute;
    left: 1796px;
    top: 34px;
    width: 67px;
    height: 26px;
  }
  .rectangle-5 { /* 검색창  */
  background: #ffffff;
  border-style: solid;
  border-color: #d2d2d2;
  border-width: 1px;
  width: 457px;
  height: 46px;
  position: absolute;
  left: 717px;
  top: 22px;
  outline: none;

}
  .rectangle-6 {
    background: #ffffff;
    border-style: solid;
    border-color: #d2d2d2;
    border-width: 1px;
    width: 164px;
    height: 45px;
    position: absolute;
    left: 535px;
    top: 23px;
    cursor: pointer;
  }
  .name {
    color: #000000;
    text-align: left;
    font-family: "Stylish-Regular", sans-serif;
    font-size: 20px;
    font-weight: 400;
    position: absolute;
    left: 593px;
    top: 32px;
    width: 58px;
    height: 26px;
    -webkit-text-stroke: 1px #d2d2d2;
  }
  .search-button {
  width: 125px;
  height: 45px;
  position: absolute;
  left: 1190px;
  top: 23px;
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 8px; 
  background: white;
  border: 1px solid #d9d9d9;
  border-radius: 5px;
  cursor: pointer;
  font-size: 16px;
  font-weight: bold;
  color: #333;
  transition: background 0.3s, transform 0.2s ease-in-out;
}
  .search {
    color: #000000;
    text-align: left;
    font-family: "Stylish-Regular", sans-serif;
    font-size: 20px;
    font-weight: 400;
    position: absolute;
    left: 1237px;
    top: 33px;
    width: 55px;
    height: 26px;
    -webkit-text-stroke: 1px #d2d2d2;
  }
  .div {
    color: #000000;
    text-align: left;
    font-family: "Inter-Medium", sans-serif;
    font-size: 16px;
    line-height: 150%;
    font-weight: 500;
    position: absolute;
    left: 728px;
    top: 34px;
    width: 446px;
    height: 36px;
  }
  .rectangle-10 {
    background: rgba(217, 217, 217, 0);
    border-style: solid;
    border-color: #d9d9d9;
    border-width: 1px;
    width: 1584px;
    height: 67px;
    position: absolute;
    left: 336px;
    top: 91px;
  }
  .rectangle-20 {
    background: rgba(217, 217, 217, 0);
    border-style: solid;
    border-color: #d9d9d9;
    border-width: 1px;
    width: 1583px;
    height: 67px;
    position: absolute;
    left: 335px;
    top: 219px;
  }
  .rectangle-26 {
    background: rgba(217, 217, 217, 0);
    border-style: solid;
    border-color: #d9d9d9;
    border-width: 1px;
    width: 1584px;
    height: 68px;
    position: absolute;
    left: 335px;
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
    left: 465px;
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
    left: 401px;
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
    left: 699px;
    top: 107px;
    transform-origin: 0 0;
    transform: rotate(90deg) scale(1, 1);
  }
  .line-6 {
    width: 35px;
    height: 0px;
    position: absolute;
    left: 1181.5px;
    top: 107px;
    transform: translate(-0.5px, 0px);
    overflow: visible;
  }
  .image-22 {
    width: 27px;
    height: 28px;
    position: absolute;
    left: 1856px;
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
    left: 1856px;
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
  .mappride {
    color: #000000;
    text-align: left;
    font-family: "Stylish-Regular", sans-serif;
    font-size: 30px;
    font-weight: 400;
    position: absolute;
    left: 96px;
    top: 36px;
    width: 141px;
    height: 40px;
    -webkit-text-stroke: 1px #ffffff;
    
  }
  .rectangle-62 {
    background: #f7f7f7;
    border-style: solid;
    border-color: #ffffff;
    border-width: 0px 1px 0px 0px;
    width: 335.69px;
    height: 84.38px;
    position: absolute;
    left: -1px;
    top: 505.2px;
  }
  .my-categories {
    color: #000000;
    text-align: center;
    font-family: "Stylish-Regular", sans-serif;
    font-size: 25px;
    font-weight: 400;
    position: absolute;
    left: 45.56px;
    top: 494.65px;
    width: 291.34px;
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
    left: 18.95px;
    top: 419.77px;
    width: 315.29px;
    height: 104.41px;
    display: flex;
    align-items: center;
    justify-content: center;
    -webkit-text-stroke: 1px #ffffff;
    cursor: pointer;
  }
  .map {
    color: #000000;
    text-align: center;
    font-family: "Stylish-Regular", sans-serif;
    font-size: 25px;
    font-weight: 400;
    position: absolute;
    left: 18.95px;
    top: 335.39px;
    width: 315.29px;
    height: 104.41px;
    display: flex;
    align-items: center;
    justify-content: center;
    -webkit-text-stroke: 1px #ffffff;
    cursor: pointer;
  }
  .rectangle-28 {
    background: rgba(255, 255, 255, 0);
    border-style: solid;
    border-color: #d9d9d9;
    border-width: 1px;
    width: 336.57px;
    height: 1080px;
    position: absolute;
    left: -1px;
    top: 0px;
  }
  .image-12 {
    width: 43.83px;
    height: 43.83px;
    position: absolute;
    left: 24.31px;
    top: 365.68px;
    object-fit: cover;
    aspect-ratio: 1;
  }
  .image-13 {
    width: 29.61px;
    height: 29.61px;
    position: absolute;
    left: 31.42px;
    top: 455.06px;
    object-fit: cover;
    aspect-ratio: 1;
  }
  .image-14 {
    width: 30.8px;
    height: 30.8px;
    position: absolute;
    left: 31.49px;
    top: 531.98px;
    object-fit: cover;
    aspect-ratio: 1;
  }
  .div3 {
    color: #000000;
    text-align: left;
    font-family: "Stylish-Regular", sans-serif;
    font-size: 20px;
    font-weight: 400;
    text-decoration: underline;
    position: absolute;
    left: 401px;
    top: 304px;
    width: 225px;
    height: 23px;
  }
  .image-27 {
    width: 37px;
    height: 36px;
    position: absolute;
    left: 1741px;
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
    left: 1741px;
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
    width: 1584px;
    height: 68px;
    position: absolute;
    left: 334px;
    top: 489px;
  }
  .image-33 {
    width: 27px;
    height: 27px;
    position: absolute;
    left: 1856px;
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
    left: 400px;
    top: 508px;
    width: 225px;
    height: 23px;
  }
  .image-34 {
    width: 37px;
    height: 37px;
    position: absolute;
    left: 1741px;
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
    width: 1584px;
    height: 68px;
    position: absolute;
    left: 335px;
    top: 421px;
  }
  .image-31 {
    width: 27px;
    height: 27px;
    position: absolute;
    left: 1856px;
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
    left: 401px;
    top: 440px;
    width: 225px;
    height: 23px;
  }
  .image-32 {
    width: 37px;
    height: 37px;
    position: absolute;
    left: 1741px;
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
    width: 1584px;
    height: 68px;
    position: absolute;
    left: 335px;
    top: 353px;
  }
  .image-29 {
    width: 27px;
    height: 27px;
    position: absolute;
    left: 1856px;
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
    left: 401px;
    top: 372px;
    width: 225px;
    height: 23px;
  }
  .image-30 {
    width: 37px;
    height: 37px;
    position: absolute;
    left: 1741px;
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
    left: 354px;
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
    left: 946px;
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
    left: 739px;
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
    left: 739px;
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
    left: 739px;
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
    left: 739px;
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
    left: 739px;
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
    left: 1245px;
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
    left: 1366px;
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
    left: 1266px;
    top: 244px;
  }
  .ellipse-3 {
    background: #c1ffe9;
    border-radius: 50%;
    width: 25px;
    height: 25px;
    position: absolute;
    left: 1266px;
    top: 307px;
  }
  .ellipse-4 {
    background: #4285f4;
    border-radius: 50%;
    width: 25px;
    height: 25px;
    position: absolute;
    left: 1265px;
    top: 373px;
  }
  .ellipse-5 {
    background: #fbbc05;
    border-radius: 50%;
    width: 25px;
    height: 25px;
    position: absolute;
    left: 1265px;
    top: 443px;
  }
  .ellipse-6 {
    background: #ff0000;
    border-radius: 50%;
    width: 25px;
    height: 25px;
    position: absolute;
    left: 1265px;
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
    left: 1778px;
    top: 147px;
  }
  .div8 {
    color: #000000;
    text-align: left;
    font-family: "Inter-Regular", sans-serif;
    font-size: 16px;
    font-weight: 400;
    position: absolute;
    left: 1826px;
    top: 115px;
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
    left: 1822px;
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
    left: 1778px;
    top: 189px;
  }
  .div10 {
    color: #000000;
    text-align: left;
    font-family: "Inter-Regular", sans-serif;
    font-size: 16px;
    font-weight: 400;
    position: absolute;
    left: 1822px;
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
    left: 1822px;
    top: 247px;
    width: 48px;
    height: 19px;
  }
  .image-37 {
    width: 25px;
    height: 25px;
    position: absolute;
    left: 1786px;
    top: 111px;
    object-fit: cover;
    aspect-ratio: 1;
  }
  .image-40 {
    width: 25px;
    height: 25px;
    position: absolute;
    left: 1874px;
    top: 157px;
    object-fit: cover;
    aspect-ratio: 1;
  }
  .image-42 {
    width: 25px;
    height: 25px;
    position: absolute;
    left: 1874px;
    top: 243px;
    object-fit: cover;
    aspect-ratio: 1;
  }
  .image-41 {
    width: 25px;
    height: 25px;
    position: absolute;
    left: 1874px;
    top: 199px;
    object-fit: cover;
    aspect-ratio: 1;
  }
  .image-43 {
    width: 25px;
    height: 25px;
    position: absolute;
    left: 1874px;
    top: 112px;
    object-fit: cover;
    aspect-ratio: 1;
  }
  </style>
  