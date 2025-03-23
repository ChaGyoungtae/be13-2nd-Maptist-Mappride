<template>
  <div class="full">
    <!-- 상단 알림 버튼 -->
    <!-- <img class="image-29" src="/src/assets/images/public/image-150.png" /> -->

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
  .full * {
  box-sizing: border-box;
  }
  .full {
    position: absolute;  /* 자식 요소는 부모를 기준으로 절대 위치 */
    top: 10px;
    left: 200px;
    height: 100%;
    width: 1600px;
  }
  .group-5 {
    position: absolute;
    inset: 0;
  }
  .comment {
    color: #454545;
    text-align: left;
    font-family: "Inter-Regular", sans-serif;
    font-size: 24px;
    font-weight: 400;
    position: absolute;
    left: 1260px;
    top: 122px;
    width: 150px;
    height: 74px;
  }
  .rectangle-50 {
    background: #ffffff;
    width: 1095px;
    height: 1385px;
    position: absolute;
    left: 138px;
    top: 94px;
  }
  .image-46 {
    width: 26px;
    height: 26px;
    position: absolute;
    left: 1045px;
    top: 814px;
    object-fit: cover;
    aspect-ratio: 1;
  }
  .image-47 {
    width: 25px;
    height: 25px;
    position: absolute;
    left: 1078px;
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
    left: 484px;
    top: 161px;
    width: 380px;
    height: 38px;
  }
  .image-35 {
    width: 300px;
    height: 399px;
    position: absolute;
    left: 291px;
    top: 352px;
    object-fit: cover;
    aspect-ratio: 300/399;
  }
  .line-13 {
    width: 48px;
    height: 0px;
    position: absolute;
    left: 414px;
    top: 161px;
    transform: translate(-0.5px, 0px);
    overflow: visible;
  }
  .line-14 {
    width: 48px;
    height: 0px;
    position: absolute;
    left: 884px;
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
    left: 261px;
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
    left: 234px;
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
  left: 951px;
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
    left: 1166px;
    top: 97px;
  }
  .ellipse-2 {
    width: 31px;
    height: 31px;
    position: absolute;
    left: 966px;
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
    left: 288px;
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
    left: 1175px;
    top: 976px;
    object-fit: cover;
    aspect-ratio: 1;
  }
  .image-34 {
    width: 42px;
    height: 42px;
    position: absolute;
    left: 1114px;
    top: 976px;
    object-fit: cover;
    aspect-ratio: 1;
  }
  .image-39 {
    width: 447px;
    height: 503px;
    position: absolute;
    left: 656px;
    top: 301px;
    object-fit: cover;
    aspect-ratio: 447/503;
  }
  .rectangle-51 {
    background: #ffffff;
    width: 484px;
    height: 1209px;
    position: absolute;
    left: 1233px;
    top: 91px;
  }
  .image-49 {
    width: 18px;
    height: 18px;
    position: absolute;
    left: 1631px;
    top: 505px;
    object-fit: cover;
    aspect-ratio: 1;
  }
  .image-50 {
    width: 18px;
    height: 18px;
    position: absolute;
    left: 1598px;
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
    left: 1270px;
    top: 380px;
  }
  .div5 {
    color: #4285f4;
    text-align: left;
    font-family: "Inter-Regular", sans-serif;
    font-size: 12px;
    font-weight: 400;
    position: absolute;
    left: 1560px;
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
    left: 1285px;
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
    left: 1255px;
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
    left: 1289px;
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
    left: 1270px;
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
    left: 1265px;
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
    left: 1265px;
    top: 540px;
  }
  .div7 {
    color: #000000;
    text-align: left;
    font-family: "Inter-Bold", sans-serif;
    font-size: 25px;
    font-weight: 700;
    position: absolute;
    left: 1285px;
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
    left: 1285px;
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
    left: 1285px;
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
    left: 1285px;
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
    left: 1285px;
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
    left: 1285px;
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
    left: 1285px;
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
    left: 1285px;
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
    left: 1303px;
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
    left: 1303px;
    top: 959px;
    width: 201px;
    height: 35px;
  }
  .image-44 {
    width: 26px;
    height: 26px;
    position: absolute;
    left: 525px;
    top: 762px;
    object-fit: cover;
    aspect-ratio: 1;
  }
  .image-45 {
    width: 25px;
    height: 25px;
    position: absolute;
    left: 558px;
    top: 762px;
    object-fit: cover;
    aspect-ratio: 1;
  }
  .image-48 {
    width: 37px;
    height: 37px;
    position: absolute;
    left: 238px;
    top: 277px;
    object-fit: cover;
    aspect-ratio: 1;
  }
  .rectangle-42 {
    width: 51px;
    height: 33px;
    position: absolute;
    left: 1607px;
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
    left: 1614px;
    top: 889px;
  }
  .frame {
    width: 50px;
    height: 50px;
    position: absolute;
    left: 1170px;
    top: 97px;
    overflow: visible;
  }
</style>
  