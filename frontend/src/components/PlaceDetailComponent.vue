<template>
    <div class="div">
      <div class="rectangle-4"></div>
      <div class="image-15"></div>

      <img class="rectangle-9" src="/src/assets/images/public/rectangle-90.png" />
      <!-- logout 버튼 -->
      <!-- <div class="logout">logout</div> -->
      <button @click="logoutClick">
      <div class="logout">logout</div>
      </button>

      <div class="mappride">Mappride</div>
      <div class="rectangle-6"></div>

      <div class="my-categories">My categories</div>
      <div class="my-page">My page</div>
      <div class="map">Map</div>

      <!-- <button @click="mapClick"><div class="map">Map</div></button> -->

      <!-- <button class="map" @click="navigateTo('map')">
          <img class="imgMap" src="/src/assets/images/public/image-120.png" />
          Map</button>
      <button class="my-page" @click="navigateTo('my-page')">
          <img class="imgPage" src="/src/assets/images/public/image-130.png" />
          My Page</button>
      <button class="my-categories" @click="navigateTo('my-categories')">
          <img class="imgCategory" src="/src/assets/images/public/image-140.png" />
          My Categories</button> -->

      <div class="rectangle-28"></div>
      <img class="image-12" src="/src/assets/images/public/image-120.png" />
      <img class="image-13" src="/src/assets/images/public/image-130.png" />
      <img class="image-14" src="/src/assets/images/public/image-140.png" />
      <!-- 상단 알림 버튼 -->
      <!-- <img class="image-29" src="/src/assets/images/public/image-150.png" /> -->
      <button @click="image29Click">
      <img class="image-29" src="/src/assets/images/public/image-150.png" />
      </button>

      <div class="comment">Comment</div>
      <div class="rectangle-50"></div>
      <!-- 우측 빈 별 -->
      <!-- <img class="image-46" src="/src/assets/images/placeDetailComponent/image-460.png" /> -->
      <button @click="image46Click">
      <img class="image-46" src="/src/assets/images/placeDetailComponent/image-460.png" />
      </button>

      <img class="image-47" src="/src/assets/images/placeDetailComponent/image-470.png" />
      <div class="div2">메가커피 신대방삼거리역점</div>
      <img class="image-35" src="/src/assets/images/placeDetailComponent/image-350.png" />
      <img class="line-13" src="/src/assets/images/public/line-60.png" />
      <img class="line-14" src="/src/assets/images/public/line-60.png" />
      <div class="div3">분좋카</div>
      <div class="line-16"></div>
      <!-- 카테고리 드롭 다운 -->
      <!-- <img class="group-10" src="/src/assets/images/placeDetailComponent/group-100.png" /> -->
      <div class="dropdown-group-10">
      <select v-model="selectedColor" @change="onColorChange">
        <option value="red">red</option>
        <option value="blue">blue</option>
        <option value="green">green</option>
        <option value="yellow">yellow</option>
        <option value="purple">purple</option>
      </select>
      </div>
      <div class="rectangle-23"></div>

      <!-- 카테고리 드롭다운 사진 -->
      <!-- <img class="ellipse-2" src="/src/assets/images/public/ellipse-20.png" /> -->

      <!-- 장소 컨텐츠 수정 입력창창 -->
      <!-- <div class="div4">
        좌석이 넓어서 수다 떨기 좋아요 메뉴들 퀄리티도 일정하고요~
      </div> -->
      <div class="div4">
      <textarea class="textarea-div4"></textarea>
      </div>
      <!-- <img class="image-33" src="/src/assets/images/public/image-230.png" /> -->
      <button @click="image33Click">
      <img class="image-33" src="/src/assets/images/public/image-230.png" />
      </button>

      <!-- <img class="image-34" src="/src/assets/images/public/image-290.png" /> -->
      <button @click="image34Click">
      <img class="image-34" src="/src/assets/images/public/image-290.png" />
      </button>
      
      <img class="image-39" src="/src/assets/images/placeDetailComponent/image-390.png" />
      <div class="rectangle-51"></div>
      <!-- <img class="image-49" src="/src/assets/images/public/image-290.png" /> -->
      <button @click="image49Click">
      <img class="image-49" src="/src/assets/images/public/image-290.png" />
      </button>

      <!-- <img class="image-50" src="/src/assets/images/public/image-230.png" /> -->
      <button @click="image50Click">
      <img class="image-50" src="/src/assets/images/public/image-230.png" />
      </button>

      <div class="line-21"></div>
      <div class="div5">내가 작성한 댓글</div>
      <div class="div6">사장님이 친절해요</div>
      <div class="comment2">Comment</div>
      <!-- <div class="rectangle-5"></div> -->
      <div class="rectangle-5">
      <textarea class="textarea-rectangle-5"></textarea>
      </div>
      <div class="line-18"></div>
      <div class="line-19"></div>
      <div class="line-20"></div>
      <div class="div7">권지민</div>
      <div class="div8">내공냠냠</div>
      <div class="_2025-03-18-15-22">2025. 03.18 15:22</div>
      <div class="div9">수연공주</div>
      <div class="div10">웅냥냥</div>
      <div class="_2025-03-18-15-52">2025. 03.18 15:52</div>
      <div class="div11">커피러버</div>
      <div class="_2025-03-18-18-01">2025. 03.18 18:01</div>
      <div class="div12">커피러버</div>
      <div class="div13">내용을 입력하세요. . .</div>
      <!-- <img class="image-44" src="/src/assets/images/placeDetailComponent/image-460.png" /> -->
      <button @click="image44Click">
      <img class="image-44" src="/src/assets/images/placeDetailComponent/image-460.png" />
      </button>

      <img class="image-45" src="/src/assets/images/placeDetailComponent/image-470.png" />
      <!-- <img class="image-48" src="/src/assets/images/placeDetailComponent/image-480.png" /> -->
      <button @click="image48Click">
      <img class="image-48" src="/src/assets/images/placeDetailComponent/image-480.png" />
      </button>

      <img class="rectangle-42" src="/src/assets/images/placeDetailComponent/rectangle-420.png" />
      <!-- <div class="write">Write</div> -->
      <button @click="writeClick">
      <div class="write">Write</div>
      </button>
      <!-- <img class="frame" src="/src/assets/images/placeDetailComponent/Frame.png" /> -->
      <button @click="frameClick">
      <img class="frame" src="/src/assets/images/placeDetailComponent/Frame.png" />
      </button>
    </div>
  </template>

  <script>
  export default {
    name: "Component",
    components: {},
    props: {},
    data() {
      return {
      selectedColor: "red", // 기본 색상 설정
    };
    },
    methods: {
      image29Click(event) {
      console.log("image-29 버튼 클릭됨!");
      console.log("클릭된 요소:", event.target);
    },
      image33Click(event) {
      console.log("image-33 버튼 클릭됨!");
      console.log("클릭된 요소:", event.target);
    },
      image34Click(event) {
      console.log("image-34 버튼 클릭됨!");
      console.log("클릭된 요소:", event.target);
    },
      image44Click(event) {
      console.log("image-44 버튼 클릭됨!");
      console.log("클릭된 요소:", event.target);
    },
      image46Click(event) {
      console.log("image-46 버튼 클릭됨!");
      console.log("클릭된 요소:", event.target);
    },
      image48Click(event) {
      console.log("image-48 버튼 클릭됨!");
      console.log("클릭된 요소:", event.target);
    },
      image49Click(event) {
      console.log("image-49 버튼 클릭됨!");
      console.log("클릭된 요소:", event.target);
    },
      image50Click(event) {
      console.log("image-50 버튼 클릭됨!");
      console.log("클릭된 요소:", event.target);
    },
    // rectangle23Click(event) {
      //   console.log("rectangle-23 버튼 클릭됨!");
      //   console.log("클릭된 요소:", event.target);
      // },

      frameClick(event) {
      console.log("frame 버튼 클릭됨!");
      console.log("클릭된 요소:", event.target);
    },
      logoutClick(event) {
      console.log("logout 버튼 클릭됨!");
      console.log("클릭된 요소:", event.target);
    },
    onColorChange(event) {
      console.log("선택된 색상:", this.selectedColor);
      
    },
      writeClick(event) {
      console.log("write 버튼 클릭됨!");
      console.log("클릭된 요소:", event.target);
    
    },
    },
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

  /* .map, .my-page, .my-categories {
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
    border: none; 
    cursor: pointer; 
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
  
  
  button:hover {
    background-color: #f0f0f0;
  } */

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
  .rectangle-6 {
    background: #f7f7f7;
    border-style: solid;
    border-color: #ffffff;
    border-width: 0px 1px 0px 0px;
    width: 335.98px;
    height: 84.38px;
    position: absolute;
    left: 0px;
    top: 505.2px;
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
  .comment {
    color: #454545;
    text-align: left;
    font-family: "Inter-Regular", sans-serif;
    font-size: 24px;
    font-weight: 400;
    position: absolute;
    left: 1460px;
    top: 122px;
    width: 150px;
    height: 74px;
  }
  .rectangle-50 {
    background: #ffffff;
    width: 1095px;
    height: 1385px;
    position: absolute;
    left: 338px;
    top: 94px;
  }
  .image-46 {
    width: 26px;
    height: 26px;
    position: absolute;
    left: 1245px;
    top: 814px;
    object-fit: cover;
    aspect-ratio: 1;
  }
  .image-47 {
    width: 25px;
    height: 25px;
    position: absolute;
    left: 1278px;
    top: 814px;
    object-fit: cover;
    aspect-ratio: 1;
  }
  .div2 {
    color: #000000;
    text-align: left;
    font-family: "Inter-Regular", sans-serif;
    font-size: 30px;
    font-weight: 400;
    position: absolute;
    left: 684px;
    top: 161px;
    width: 380px;
    height: 38px;
  }
  .image-35 {
    width: 300px;
    height: 399px;
    position: absolute;
    left: 491px;
    top: 352px;
    object-fit: cover;
    aspect-ratio: 300/399;
  }
  .line-13 {
    width: 48px;
    height: 0px;
    position: absolute;
    left: 614px;
    top: 161px;
    transform: translate(-0.5px, 0px);
    overflow: visible;
  }
  .line-14 {
    width: 48px;
    height: 0px;
    position: absolute;
    left: 1084px;
    top: 162px;
    transform: translate(-0.5px, 0px);
    overflow: visible;
  }
  .div3 {
    color: #000000;
    text-align: left;
    font-family: "Inter-Regular", sans-serif;
    font-size: 30px;
    font-weight: 400;
    position: absolute;
    left: 461px;
    top: 164px;
    width: 100px;
    height: 43px;
  }
  .line-16 {
    margin-top: -1px;
    border-style: solid;
    border-color: #d9d9d9;
    border-width: 1px 0 0 0;
    width: 881px;
    height: 0px;
    position: absolute;
    left: 434px;
    top: 260px;
    transform-origin: 0 0;
    transform: rotate(0.065deg) scale(1, 1);
  }
  /* .group-10 {
    height: auto;
    position: absolute;
    left: 1151px;
    top: 157px;
    overflow: visible;
  } */

  .dropdown-group-10 {
  position: absolute;
  left: 1151px;
  top: 157px;
  }

  select {
  width: 150px;
  height: 40px;
  font-size: 16px;
  padding: 5px;
  }

  .group-11 {
    position: absolute;
    inset: 0;
  }
  .rectangle-23 {
    background: #f7f7f9;
    border-style: solid;
    border-color: #d9d9d9;
    border-width: 1px;
    width: 57px;
    height: 57px;
    position: absolute;
    left: 1366px;
    top: 97px;
  }
  .ellipse-2 {
    width: 31px;
    height: 31px;
    position: absolute;
    left: 1166px;
    top: 171px;
    overflow: visible;
  }
  .div4 {
    color: #000000;
    text-align: left;
    font-family: "Inter-Regular", sans-serif;
    font-size: 24px;
    font-weight: 400;
    position: absolute;
    left: 488px;
    top: 910px;
    width: 776px;
    height: 95px;
  }
  .textarea-div4 {
    width: 100%;
    height: 100%;
    border: none;
    resize: none; /* 크기 조절 비활성화 */
    outline: none; /* 포커스 시 테두리 제거 */
    padding: 10px; /* 내부 여백 추가 */
    font-family: "Inter-Regular", sans-serif;
    font-size: 15px;
    color: #000000;
    background-color: #ffffff;
    box-sizing: border-box; /* 패딩 포함 크기 계산 */
    overflow: scroll;
  }
  .image-33 {
    width: 40px;
    height: 40px;
    position: absolute;
    left: 1375px;
    top: 976px;
    object-fit: cover;
    aspect-ratio: 1;
  }
  .image-34 {
    width: 42px;
    height: 42px;
    position: absolute;
    left: 1314px;
    top: 976px;
    object-fit: cover;
    aspect-ratio: 1;
  }
  .image-39 {
    width: 447px;
    height: 503px;
    position: absolute;
    left: 856px;
    top: 301px;
    object-fit: cover;
    aspect-ratio: 447/503;
  }
  .rectangle-51 {
    background: #ffffff;
    width: 484px;
    height: 1209px;
    position: absolute;
    left: 1433px;
    top: 91px;
  }
  .image-49 {
    width: 18px;
    height: 18px;
    position: absolute;
    left: 1831px;
    top: 505px;
    object-fit: cover;
    aspect-ratio: 1;
  }
  .image-50 {
    width: 18px;
    height: 18px;
    position: absolute;
    left: 1798px;
    top: 505px;
    object-fit: cover;
    aspect-ratio: 1;
  }
  .line-21 {
    margin-top: -1px;
    border-style: solid;
    border-color: #d9d9d9;
    border-width: 1px 0 0 0;
    width: 419px;
    height: 0px;
    position: absolute;
    left: 1470px;
    top: 380px;
  }
  .div5 {
    color: #4285f4;
    text-align: left;
    font-family: "Inter-Regular", sans-serif;
    font-size: 12px;
    font-weight: 400;
    position: absolute;
    left: 1760px;
    top: 403px;
    width: 112px;
    height: 24px;
  }
  .div6 {
    color: #000000;
    text-align: left;
    font-family: "Inter-Regular", sans-serif;
    font-size: 20px;
    font-weight: 400;
    position: absolute;
    left: 1485px;
    top: 452px;
    width: 207px;
    height: 23px;
  }
  .comment2 {
    color: #000000;
    text-align: left;
    font-family: "Inter-Regular", sans-serif;
    font-size: 20px;
    font-weight: 400;
    position: absolute;
    left: 1455px;
    top: 128px;
    width: 150px;
    height: 74px;
  }
  .rectangle-5 {
    background: #ffffff;
    border-style: solid;
    border-color: #d2d2d2;
    border-width: 1px;
    width: 369px;
    height: 262px;
    position: absolute;
    left: 1489px;
    top: 922px;
    
  }
  .textarea-rectangle-5 {
    width: 100%;
    height: 100%;
    border: none;
    resize: none; /* 크기 조절 비활성화 */
    outline: none; /* 포커스 시 테두리 제거 */
    padding: 10px; /* 내부 여백 추가 */
    font-family: "Inter-Regular", sans-serif;
    font-size: 15px;
    color: #000000;
    background-color: #ffffff;
    box-sizing: border-box; /* 패딩 포함 크기 계산 */
    overflow: scroll;
  }
  
  /* 플레이스홀더 색상 
  .textarea-rectangle-5::placeholder {
    color: #d9d9d9;  
  }
  */
  .line-18 {
    margin-top: -1px;
    border-style: solid;
    border-color: #d9d9d9;
    border-width: 1px 0 0 0;
    width: 419px;
    height: 0px;
    position: absolute;
    left: 1470px;
    top: 873px;
  }
  .line-19 {
    margin-top: -1px;
    border-style: solid;
    border-color: #d9d9d9;
    border-width: 1px 0 0 0;
    width: 419.01px;
    height: 0px;
    position: absolute;
    left: 1465px;
    top: 717.5px;
  }
  .line-20 {
    margin-top: -1px;
    border-style: solid;
    border-color: #d9d9d9;
    border-width: 1px 0 0 0;
    width: 419px;
    height: 0px;
    position: absolute;
    left: 1465px;
    top: 540px;
  }
  .div7 {
    color: #000000;
    text-align: left;
    font-family: "Inter-Bold", sans-serif;
    font-size: 25px;
    font-weight: 700;
    position: absolute;
    left: 1485px;
    top: 742.5px;
    width: 101px;
    height: 19px;
  }
  .div8 {
    color: #000000;
    text-align: left;
    font-family: "Inter-Regular", sans-serif;
    font-size: 20px;
    font-weight: 400;
    position: absolute;
    left: 1485px;
    top: 795.5px;
    width: 207px;
    height: 23px;
  }
  ._2025-03-18-15-22 {
    color: #000000;
    text-align: left;
    font-family: "Inter-Regular", sans-serif;
    font-size: 15px;
    font-weight: 400;
    position: absolute;
    left: 1485px;
    top: 839.5px;
    width: 201px;
    height: 19px;
  }
  .div9 {
    color: #000000;
    text-align: left;
    font-family: "Inter-Bold", sans-serif;
    font-size: 25px;
    font-weight: 700;
    position: absolute;
    left: 1485px;
    top: 568.5px;
    width: 101px;
    height: 19px;
  }
  .div10 {
    color: #000000;
    text-align: left;
    font-family: "Inter-Regular", sans-serif;
    font-size: 20px;
    font-weight: 400;
    position: absolute;
    left: 1485px;
    top: 621.5px;
    width: 207px;
    height: 23px;
  }
  ._2025-03-18-15-52 {
    color: #000000;
    text-align: left;
    font-family: "Inter-Regular", sans-serif;
    font-size: 15px;
    font-weight: 400;
    position: absolute;
    left: 1485px;
    top: 665.5px;
    width: 201px;
    height: 19px;
  }
  .div11 {
    color: #000000;
    text-align: left;
    font-family: "Inter-Bold", sans-serif;
    font-size: 25px;
    font-weight: 700;
    position: absolute;
    left: 1485px;
    top: 403px;
    width: 101px;
    height: 19px;
  }
  ._2025-03-18-18-01 {
    color: #000000;
    text-align: left;
    font-family: "Inter-Regular", sans-serif;
    font-size: 15px;
    font-weight: 400;
    position: absolute;
    left: 1485px;
    top: 500px;
    width: 201px;
    height: 19px;
  }
  .div12 {
    color: #000000;
    text-align: left;
    font-family: "Inter-Regular", sans-serif;
    font-size: 15px;
    font-weight: 400;
    position: absolute;
    left: 1503px;
    top: 935px;
    width: 165px;
    height: 38px;
  }
  .div13 {
    color: #d9d9d9;
    text-align: left;
    font-family: "Inter-Regular", sans-serif;
    font-size: 15px;
    font-weight: 400;
    position: absolute;
    left: 1503px;
    top: 959px;
    width: 201px;
    height: 35px;
  }
  .image-44 {
    width: 26px;
    height: 26px;
    position: absolute;
    left: 725px;
    top: 762px;
    object-fit: cover;
    aspect-ratio: 1;
  }
  .image-45 {
    width: 25px;
    height: 25px;
    position: absolute;
    left: 758px;
    top: 762px;
    object-fit: cover;
    aspect-ratio: 1;
  }
  .image-48 {
    width: 37px;
    height: 37px;
    position: absolute;
    left: 438px;
    top: 277px;
    object-fit: cover;
    aspect-ratio: 1;
  }
  .rectangle-42 {
    width: 51px;
    height: 33px;
    position: absolute;
    left: 1807px;
    top: 881px;
    overflow: visible;
  }
  .write {
    color: #000000;
    text-align: left;
    font-family: "Inter-Regular", sans-serif;
    font-size: 15px;
    font-weight: 400;
    position: absolute;
    left: 1814px;
    top: 889px;
  }
  .frame {
    width: 50px;
    height: 50px;
    position: absolute;
    left: 1370px;
    top: 97px;
    overflow: visible;
  }
  </style>
  