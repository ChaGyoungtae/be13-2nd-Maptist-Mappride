<template>
  <a class="_1">
    
    <!-- <div class="dropdown-container" :class="{ open: isDropdownOpen }"> -->
      <!-- 드롭다운 버튼 -->
      <!-- <div class="dropdown-toggle" @click="toggleDropdown">
        {{ selectedOption }}
        <img class="polygon-6" src="/src/assets/images/public/polygon-60.png" />
      </div> -->

      <!-- 드롭다운 메뉴 -->
      <!-- <div v-if="isDropdownOpen" class="dropdown-menu">
        <div class="dropdown-option" @click="selectOption('O')">O</div>
        <div class="dropdown-option" @click="selectOption('X')">X</div>
      </div>
    </div> -->

    <div v-for="(option, index) in dropdowns" :key="index" class="dropdown-container" :class="{ open: option.isDropdownOpen }">
      <!-- 드롭다운 버튼 -->
      <div class="dropdown-toggle" @click="toggleDropdown(index)">
        {{ option.selectedOption }}
        <img class="polygon-6" src="/src/assets/images/public/polygon-60.png" />
      </div>


      <!-- 드롭다운 메뉴 -->
      <div v-if="option.isDropdownOpen" class="dropdown-menu">
        <div class="dropdown-option" @click="selectOption(index, 'O')">O</div>
        <div class="dropdown-option" @click="selectOption(index, 'X')">X</div>
      </div>
    </div>



    <div class="rectangle-27"></div>
    <div class="rectangle-25"></div>
    <div class="rectangle-4"></div>
    <img class="image-15" src="/src/assets/images/public/image-150.png" />

    <button class="logout-button">Logout</button>
    <button class="search-button">Search</button>

    <input type="text" class="rectangle-5"  placeholder="   . . ." />
    <input type="text" class="rectangle-17" placeholder="  카테고리 제목을 입력하세요" />    
    <div class="rectangle-6"></div>
    <div class="name">name</div>
    <!-- <div class="div">카페</div> -->
    <div class="rectangle-10"></div>
    <div class="rectangle-11"></div>
    <div class="rectangle-20"></div>
    <div class="rectangle-26"></div>
    <div class="title">TITLE</div>
    <div class="publish">PUBLISH</div>
    <a href="이동할_페이지_URL" class="_5">스터디카페 ( 5 )</a>
    <a href="이동할_페이지_URL" class="_3">코인노래방 ( 3 )</a>
    <div class="line-2"></div>
    <div class="line-3"></div>
    <div class="line-4"></div>
    <div class="line-7"></div>
    <div class="line-8"></div>
    <div class="line-9"></div>
    <div class="line-10"></div>
    <div class="line-11"></div>
    <div class="line-12"></div>
    <div class="line-5"></div>
    <div class="line-13"></div>
    <img class="image-22" src="/src/assets/images/public/image-230.png" @click="handleClick" />
    <img class="image-24" src="/src/assets/images/public/image-230.png" @click="handleClick" />
    <img class="image-23" src="/src/assets/images/public/image-230.png" @click="handleClick" />
    <img class="image-25" src="/src/assets/images/myCategoriesComponent/image-250.png" />
    <div class="mappride">Mappride</div>
    <div class="rectangle-62"></div>
    <div class="my-categories">My categories</div>
    <div href="이동할_페이지_URL" class="my-page">My page</div>
    <div href="이동할_페이지_URL" class="map">Map</div>
    <div class="rectangle-28"></div>
    <img class="image-12" src="/src/assets/images/public/image-120.png" />
    <img class="image-13" src="/src/assets/images/public/image-130.png" />
    <img class="image-14" src="/src/assets/images/public/image-140.png" />
    <a href="이동할_페이지_URL" class="_40">혼밥 ( 40 )</a>
    <img class="image-26" src="/src/assets/images/public/image-290.png" @click="handleClick" />
    <img class="image-27" src="/src/assets/images/public/image-290.png" @click="handleClick" />
    <img class="image-28" src="/src/assets/images/public/image-290.png" @click="handleClick" />
    <div class="rectangle-282"></div>
  </a>
</template>



<script>
export default {
  name: "DropdownComponent",  
  components: {},
  props: {},
  data() {
    return {
      dropdowns: [
        { isDropdownOpen: false, selectedOption: "X", },
        { isDropdownOpen: false, selectedOption: "X", },
        { isDropdownOpen: false, selectedOption: "X", },
        { isDropdownOpen: false, selectedOption: "X", }
      ]
      // isDropdownOpen: false,
      // selectedOption: "X"
    };
  },
  // methods: {
  //   toggleDropdown() {
  //     this.isDropdownOpen = !this.isDropdownOpen;
  //   },
  methods: {
    // toggleDropdown() {
    //   this.isDropdownOpen = !this.isDropdownOpen;
    // },
    toggleDropdown(index) {
      this.dropdowns[index].isDropdownOpen = !this.dropdowns[index].isDropdownOpen;
    },
    // selectOption(option) {
    //       this.selectedOption = option;
    //       this.isDropdownOpen = false; // 선택 후 닫기
    // }
    selectOption(index, option) {
      this.dropdowns[index].selectedOption = option;
      this.dropdowns[index].isDropdownOpen = false; // 선택 후 닫기
    }
  }
};
</script>



<style scoped>
._1,
._1 * {
  box-sizing: border-box;
}
._1 { /* 왼쪽, 센터 바탕색 */
  background: #ffffff;
  height: 1080px;
  position: relative;
  overflow: hidden;
}
/* .rectangle-21 { /* 스터디카페 publish 드롭다운 
  background: #ffffff;
  border-style: solid;
  border-color: #d9d9d9;
  border-width: 1px;
  width: 130px;
  height: 45px;
  position: relative;
  left: 1174px;
  top: 233px;
} */

/* 드롭다운 컨테이너 */
.dropdown-container {
  position: relative;
  left: 1174px;
  top: 167px;
  width: 129px;
  height: 45px;
  background: #ffffff;
  border: 1px solid #d9d9d9;
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 0 10px;
  cursor: pointer;
  font-family: "Inter-Medium", sans-serif;
  font-size: 16px;
  font-weight: 500;
  z-index: 100; /* 다른 요소보다 위에 표시 */
  margin-bottom: 22px;
}

/* 드롭다운 버튼 내부 삼각형 */
/* .polygon-6 {
  width: 23px;
  height: 15px;
  left: 1200px;
  top: 225px;
  transition: transform 0.3s ease;
} */

/* 드롭다운이 열릴 때 아이콘 회전 */
.dropdown-container.open .polygon-6 {
  transform: rotate(180deg);
}

/* 드롭다운 메뉴 */
.dropdown-menu {
  position: absolute;
  left: 0;
  top: 100%;
  width: 100%;
  background: #ffffff;
  border: 1px solid #d9d9d9;
  box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
  z-index: 2000; /* 다른 요소보다 위에 표시 */
}

/* 드롭다운 옵션 */
.dropdown-option {
  padding: 10px;
  text-align: center;
  cursor: pointer;
}

.dropdown-option:hover {
  background: #f0f0f0;
}

/* 드롭다운 컨테이너 */
/* .dropdown-container {
  position: relative;
  left: 1174px;
  top: 168px; 
  width: 129px;
  height: 45px;
  background: #ffffff;
  border: 1px solid #d9d9d9;
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 0 10px;
  cursor: pointer;
  font-family: "Inter-Medium", sans-serif;
  font-size: 16px;
  font-weight: 500;
} */

/* 드롭다운 버튼 내부 삼각형 이미지 */
 /* .polygon-6 {
  width: 23px;
  height: 15px;
  transition: transform 0.3s ease;
}  */

/* 삼각형 아이콘 위치 조정 */
.polygon-6 {
  width: 23px;
  height: 15px;
  position: absolute;
  right: 10px; /* 오른쪽 정렬 */
  top: 50%;
  transform: translateY(-50%);
  transition: transform 0.3s ease;
}

/* 드롭다운이 열릴 때 아이콘 회전 */
/* .dropdown-container.open .polygon-6 {
  transform: rotate(180deg);
} */

/* 드롭다운 메뉴 스타일 */
/* .dropdown-menu {
  position: absolute;
  left: 0;
  top: 100%;
  width: 100%;
  background: #ffffff;
  border: 1px solid #d9d9d9;
  box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
  z-index: 10;
} */

/* 드롭다운 옵션 스타일 */
/* .dropdown-option {
  padding: 10px;
  text-align: center;
  cursor: pointer;
}

.dropdown-option:hover {
  background: #f0f0f0;
} */

/*  카테고리 생성라인 publish_box */
/* .rectangle-24 { 
  background: #ffffff;
  border-style: solid;
  border-color: #d9d9d9;
  border-width: 1px;
  width: 129px;
  height: 45px;
  position: absolute;
  left: 1174px;
  top: 168px;
}  */




.rectangle-4 { /* 최상단 검색창 바탕  */
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
.image-15 { /* 알림종  */
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


.image-22:active {
  transform: scale(0.95);
}
.image-23:active {
  transform: scale(0.95);
}
.image-24:active {
  transform: scale(0.95);
}
.image-26:active {
  transform: scale(0.95);
}
.image-27:active {
  transform: scale(0.95);
}
.image-28:active {
  transform: scale(0.95);
}
.image-15:active {
  transform: scale(0.95);
}
.image-25:active {
  transform: scale(0.95);
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

.rectangle-17 { /* 카테고리 이름 입력칸 */
  background: #ffffff;
  border: 1px solid #d2d2d2;
  width: 708px;
  height: 45px;
  padding: 10px;
  font-size: 16px;
  position: absolute;
  left: 349px;
  top: 165px;
  outline: none;
}

.rectangle-6 { /* name box */
  background: #ffffff;
  border-style: solid;
  border-color: #d2d2d2;
  border-width: 1px;
  width: 164px;
  height: 45px;
  position: absolute;
  left: 535px;
  top: 23px;
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

.div { /* 카페 라는 글씨(검색창) */
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

.rectangle-11 { /* 카테고리 생성란 배경상자 */
  background: rgba(217, 217, 217, 0);
  border-style: solid;
  border-color: #d9d9d9;
  border-width: 1px;
  width: 1583px;
  height: 68px;
  position: absolute;
  left: 336px;
  top: 221px;
}
.rectangle-20 { /* 코인노래방 바탕 상자 */
  background: rgba(217, 217, 217, 0);
  border-style: solid;
  border-color: #d9d9d9;
  border-width: 1px;
  width: 1583px;
  height: 67px;
  position: absolute;
  left: 336px;
  top: 288px;
}
.rectangle-26 { /* 혼밥 바탕상자 */
  background: rgba(217, 217, 217, 0);
  border-style: solid;
  border-color: #d9d9d9;
  border-width: 1px;
  width: 1584px;
  height: 68px;
  position: absolute;
  left: 336px;
  top: 354px;
}
.title {
  color: #000000;
  text-align: left;
  font-family: "Inter-Medium", sans-serif;
  font-size: 16px;
  line-height: 150%;
  font-weight: 500;
  position: absolute;
  left: 361px;
  top: 114px;
  width: 407px;
  height: 25px;
}
.publish {
  color: #000000;
  text-align: left;
  font-family: "Inter-Medium", sans-serif;
  font-size: 16px;
  line-height: 150%;
  font-weight: 500;
  position: absolute;
  left: 1200px;
  top: 114px;
  width: 150px;
  height: 28px;
}
._5 { /* 스터디카페 (5) 링크 */
  color: #000000;
  text-align: left;
  font-family: "Stylish-Regular", sans-serif;
  font-size: 24px;
  font-weight: 400;
  text-decoration: underline;
  position: absolute;
  left: 369px;
  top: 243px;
  width: 225px;
  height: 22px;
  cursor: pointer; /* 클릭 가능한 링크처럼 보이게 변경 */
}
._3 { /* 코인노래방 글씨 */
  color: #000000;
  text-align: left;
  font-family: "Stylish-Regular", sans-serif;
  font-size: 24px;
  font-weight: 400;
  text-decoration: underline;
  position: absolute;
  left: 369px;
  top: 306px;
  width: 225px;
  height: 22px;
  cursor: pointer;
}
.o { /* 스터디카페 publish O*/
  color: #000000;
  text-align: left;
  font-family: "Inter-Medium", sans-serif;
  font-size: 16px;
  line-height: 150%;
  font-weight: 500;
  position: absolute;
  left: 1212px;
  top: 245px;
  width: 38px;
  height: 23px;
}
.div2 {
  color: #000000;
  text-align: left;
  font-family: "Inter-Medium", sans-serif;
  font-size: 16px;
  line-height: 150%;
  font-weight: 500;
  position: absolute;
  left: 369px;
  top: 179px;
  width: 299px;
  height: 25px;
}
.line-2 { /* 스카 자리이동 맨윗줄 */
  margin-top: -1px;
  border-style: solid;
  border-color: #000000;
  border-width: 1px 0 0 0;
  width: 38px;
  height: 0px;
  position: absolute;
  left: 1846px;
  top: 249px;
}
.line-3 { /* 스카 자리이동 중간줄 */
  margin-top: -1px;
  border-style: solid;
  border-color: #000000;
  border-width: 1px 0 0 0;
  width: 38px;
  height: 0px;
  position: absolute;
  left: 1846px;
  top: 257px;
}
.line-4 { /* 스카 자리이동 아랫줄 */
  margin-top: -1px;
  border-style: solid;
  border-color: #000000;
  border-width: 1px 0 0 0;
  width: 38px;
  height: 0px;
  position: absolute;
  left: 1846px;
  top: 266px;
  transform-origin: 0 0;
  transform: rotate(0deg) scale(1, 1);
}
.line-7 { /*  코노 자리이동 윗줄*/
  margin-top: -1px;
  border-style: solid;
  border-color: #000000;
  border-width: 1px 0 0 0;
  width: 38px;
  height: 0px;
  position: absolute;
  left: 1846px;
  top: 314px;
}
.line-8 { /*  코노 자리이동 중간줄*/
  margin-top: -1px;
  border-style: solid;
  border-color: #000000;
  border-width: 1px 0 0 0;
  width: 38px;
  height: 0px;
  position: absolute;
  left: 1846px;
  top: 323px;
}
.line-9 { /*  코노 자리이동 중간줄*/
  margin-top: -1px;
  border-style: solid;
  border-color: #000000;
  border-width: 1px 0 0 0;
  width: 38px;
  height: 0px;
  position: absolute;
  left: 1846px;
  top: 331px;
  transform-origin: 0 0;
  transform: rotate(0deg) scale(1, 1);
}
.line-10 { /* 혼밥 맨윗줄 */
  margin-top: -1px;
  border-style: solid;
  border-color: #000000;
  border-width: 1px 0 0 0;
  width: 38px;
  height: 0px;
  position: absolute;
  left: 1846px;
  top: 380px;
}
.line-11 { /* 혼밥 중간줄 */
  margin-top: -1px;
  border-style: solid;
  border-color: #000000;
  border-width: 1px 0 0 0;
  width: 38px;
  height: 0px;
  position: absolute;
  left: 1846px;
  top: 388px;
}
.line-12 { /* 혼밥 맨아래줄 */
  margin-top: -1px;
  border-style: solid;
  border-color: #000000;
  border-width: 1px 0 0 0;
  width: 38px;
  height: 0px;
  position: absolute;
  left: 1846px;
  top: 397px;
  transform-origin: 0 0;
  transform: rotate(0deg) scale(1, 1);
}


.x {
  color: #000000;
  text-align: left;
  font-family: "Inter-Medium", sans-serif;
  font-size: 16px;
  line-height: 150%;
  font-weight: 500;
  position: absolute;
  left: 1218px;
  top: 179px;
  width: 51px;
  height: 17px;
}
.o2 {
  color: #000000;
  text-align: left;
  font-family: "Inter-Medium", sans-serif;
  font-size: 16px;
  line-height: 150%;
  font-weight: 500;
  position: absolute;
  left: 1214px;
  top: 373px;
  width: 51px;
  height: 17px;
}
.x2 {
  color: #000000;
  text-align: left;
  font-family: "Inter-Medium", sans-serif;
  font-size: 16px;
  line-height: 150%;
  font-weight: 500;
  position: absolute;
  left: 1214px;
  top: 309px;
  width: 51px;
  height: 17px;
}
.line-5 {
  margin-top: -1px;
  border-style: solid;
  border-color: #d9d9d9;
  border-width: 1px 0 0 0;
  width: 35px;
  height: 0px;
  position: absolute;
  left: 1057px;
  top: 109px;
  transform-origin: 0 0;
  transform: rotate(90deg) scale(1, 1);
}
.line-13 {
  margin-top: -1px;
  border-style: solid;
  border-color: #d9d9d9;
  border-width: 1px 0 0 0;
  width: 35px;
  height: 0px;
  position: absolute;
  left: 1417px;
  top: 109px;
  transform-origin: 0 0;
  transform: rotate(90deg) scale(1, 1);
}


.image-22 {
  width: 27px;
  height: 28px;
  position: absolute;
  left: 1742px;
  top: 305px;
  object-fit: cover;
  aspect-ratio: 27/28;
  cursor: pointer;
  transition: transform 0.2s ease-in-out;
}
.image-24 {
  width: 27px;
  height: 27px;
  position: absolute;
  left: 1742px;
  top: 240px;
  object-fit: cover;
  aspect-ratio: 1;
  cursor: pointer;
  transition: transform 0.2s ease-in-out;
}
.image-23 {
  width: 27px;
  height: 27px;
  position: absolute;
  left: 1742px;
  top: 374px;
  object-fit: cover;
  aspect-ratio: 1;
  cursor: pointer;
  transition: transform 0.2s ease-in-out;

}
.image-25 {
  width: 32px;
  height: 32px;
  position: absolute;
  left: 1847px;
  top: 173px;
  object-fit: cover;
  aspect-ratio: 1;
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
._40 {
  color: #000000;
  text-align: left;
  font-family: "Stylish-Regular", sans-serif;
  font-size: 24px;
  font-weight: 400;
  text-decoration: underline;
  position: absolute;
  left: 369px;
  top: 373px;
  width: 225px;
  height: 23px;
  cursor: pointer;
}
.image-26 {
  width: 37px;
  height: 37px;
  position: absolute;
  left: 1627px;
  top: 233px;
  object-fit: cover;
  aspect-ratio: 1;
  cursor: pointer;
  transition: transform 0.2s ease-in-out;
}
.image-27 {
  width: 37px;
  height: 36px;
  position: absolute;
  left: 1627px;
  top: 302px;
  cursor: pointer;
  object-fit: cover;
  aspect-ratio: 37/36;
  transition: transform 0.2s ease-in-out; /* 클릭 효과 */
}

&:hover {
    transform: scale(1.1);
  }

  /* 클릭 시 살짝 눌리는 효과 */
  &:active {
    transform: scale(0.95);
  }


.image-28 {
  width: 37px;
  height: 37px;
  position: absolute;
  left: 1627px;
  top: 368px;
  object-fit: cover;
  aspect-ratio: 1;
  cursor: pointer;
  transition: transform 0.2s ease-in-out;
}


</style>
