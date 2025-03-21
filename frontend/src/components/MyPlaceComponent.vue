<template>
    <div class="_2">
      <div class="rectangle-4"></div>
      <img class="image-15" src="/src/assets/images/public/image-150.png" @click="handleClick" />
      <img class="rectangle-9" src="/src/assets/images/public/rectangle-90.png" />
      <button class="logout-button">Logout</button>
      <button class="search-button">Search</button>

      <input type="text" class="rectangle-5"  placeholder="   . . ." />
      <!-- <div href="이동할_페이지_URL" class="rectangle-6"></div> -->
      <div class="name">name</div>
      <div class="rectangle-10"></div>
      <div class="rectangle-20"></div>
      <div class="rectangle-26"></div>
      <div class="title">TITLE</div>
      <a href="이동할_페이지_URL" class="div2">비에이블</a>

      <div class="line-5"></div>
      <img class="line-6" src="/src/assets/images/public/line-60.png" />
      <img class="line-7" src="/src/assets/images/public/line-60.png" />
      <img class="image-22" src="/src/assets/images/public/image-230.png" @click="handleClick" />
      <img class="image-23" src="/src/assets/images/public/image-230.png" @click="handleClick" />
      <a href="이동할_페이지_URL" class="mappride">Mappride</a>
      <!-- <div class="rectangle-62"></div> -->
      <!-- <a href="이동할_페이지_URL" class="my-categories">My categories</a>
      <a href="이동할_페이지_URL" class="my-page">My page</a>
      <a href="이동할_페이지_URL" class="map">Map</a> -->
      <div class="rectangle-28"></div>
      <button class="map" @click="navigateTo('map')">
          <img class="imgMap" src="/src/assets/images/public/image-120.png" />
          Map</button>
      <button class="my-page" @click="navigateTo('my-page')">
          <img class="imgPage" src="/src/assets/images/public/image-130.png" />
          My Page</button>

      <button class="my-categories" @click="navigateTo('my-categories')">
          <img class="imgCategory" src="/src/assets/images/public/image-140.png" />
          My Categories</button>


      <!-- <img class="image-12" src="/src/assets/images/public/image-120.png" />
      <img class="image-13" src="/src/assets/images/public/image-130.png" />
      <img class="image-14" src="/src/assets/images/public/image-140.png" /> -->
      <a href="이동할_페이지_URL" class="div3">공부인</a>
      <img class="image-27" src="/src/assets/images/public/image-290.png" @click="handleClick" />
      <img class="image-28" src="/src/assets/images/public/image-290.png" @click="handleClick" />
      <div class="rectangle-30"></div>
      <img class="image-33" src="/src/assets/images/public/image-230.png" @click="handleClick" />
      <a href="이동할_페이지_URL" class="div4">단디</a>
      <img class="image-34" src="/src/assets/images/public/image-290.png" @click="handleClick" />
      <div class="rectangle-29"></div>

      <img class="image-31" src="/src/assets/images/public/image-230.png" @click="handleClick" />

      <a href="이동할_페이지_URL" class="div5">랭</a>
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

    </div>

    <div>
      <!-- 색상 드롭다운 -->
    <div class="dropdown-container-color">
    <!-- 선택된 색상 버튼 -->
    <div class="selected-option" @click="toggleColorDropdown">
      <div class="color-circle" :class="selectedClass"></div>
    </div>

    <!-- 드롭다운 메뉴 -->
    <ul v-if="colorDropdownVisible" class="dropdown-menu-color">
      <li v-for="(color, index) in colors" :key="index" @click="selectColor(color.className)">
        <div class="color-circle" :class="color.className"></div>
      </li>
    </ul>
  </div>


  <!-- 정렬 드롭다운 -->
  <div class="rectangle-31" @click="toggleSortDropdown">
      
      <!-- 선택한 정렬 기준 표시 -->
      <span>
        {{ selectedSort }}
        <img :src="selectedSortImage" class="dropdown-image" alt="Selected Option Image" />
      </span>

      <!-- 드롭다운 메뉴 -->
      <div v-if="sortDropdownVisible" class="dropdown-menu">
        <ul>
          <li v-for="(option, index) in sortOptions" :key="index" @click="setSortOrder(option)">
            {{ option.label }}
            <img class="dropdown-image" :src="option.image" alt="Sort Option Image" />
          </li>
        </ul>
      </div>
    </div>
</div>
  </template>
  <script>

  import { ref } from 'vue';

  export default {
    name: "Two",
    components: {},
    props: {},
    
     setup() {
      const colorDropdownVisible = ref(false); // 드롭다운 열림 여부
      const selectedClass = ref("ellipse-2"); // 기본 선택된 색상

      const colors = ref([
        { className: "ellipse-2" },
        { className: "ellipse-3" },
        { className: "ellipse-4" },
        { className: "ellipse-5" },
        { className: "ellipse-6" }
      ]);
      // 드롭다운 열고 닫기
      const toggleColorDropdown  = () => {
        colorDropdownVisible.value = !colorDropdownVisible.value;
      };
      // 색상 선택
      const selectColor = (colorClass) => {
        selectedClass.value = colorClass;
        colorDropdownVisible.value = false; // 선택 후 드롭다운 닫기
      };

      // 정렬 드롭다운 상태
    const sortDropdownVisible = ref(false); 
    const selectedSort = ref("최신순"); // 초기 값
    const selectedSortImage = ref('/src/assets/images/MyPlaceComponent/image-400.png'); // 초기 이미지 설정
    const sortOptions = ref([
      { value: 'date-asc', label: '최신순', image: '/src/assets/images/MyPlaceComponent/image-430.png' },
      { value: 'date-desc', label: '최신순', image: '/src/assets/images/MyPlaceComponent/image-400.png' },
      { value: 'name-asc', label: '이름순', image: '/src/assets/images/MyPlaceComponent/image-430.png' },
      { value: 'name-desc', label: '이름순', image: '/src/assets/images/MyPlaceComponent/image-400.png' }
    ]);
    
    // 정렬 드롭다운 메뉴 토글
    const toggleSortDropdown = () => {
      sortDropdownVisible.value = !sortDropdownVisible.value;
    };
    
    // 정렬 기준 설정
    const setSortOrder = (option) => {
      selectedSort.value = option.label; // 선택된 정렬 기준 바로 반영
      selectedSortImage.value = option.image; // 선택된 옵션에 맞는 이미지 반영
      console.log(`정렬 기준: ${option.value}`);
    };

    return {
      colorDropdownVisible,
      selectedClass,
      colors,
      toggleColorDropdown,
      selectColor,
      sortDropdownVisible,
      selectedSort,
      sortOptions,
      selectedSortImage,
      toggleSortDropdown,
      setSortOrder
    };
  }
}
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
    left: 10.14px;
  }

  .my-categories:hover {
    background-color: #f0f0f0;
  }
  
  /* Hover 상태 */
  button:hover {
    background-color: #f0f0f0;
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
    left: 8px;
    object-fit: cover;
    aspect-ratio: 1;
  }

  .rectangle-31 {
    background: #ffffff;
    border-style: solid;
    border-color: #d9d9d9;
    border-width: 1px;
    width: 125px;
    height: 45px;
    position: absolute;
    left: 1770px;
    top: 110px;
    display: flex;
    justify-content: space-between;
    align-items:center;
    padding: 0 10px;
    cursor: pointer;
    }

  /* 드롭다운 메뉴 스타일 */
.dropdown-menu {
  position: absolute;
  top: 50px;
  left: 0;
  background-color: #ffffff;
  border: 1px solid #d9d9d9;
  width: 125px;
  box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
}

.dropdown-menu ul {
  list-style: none;
  padding: 0;
  margin: 0;
}

.dropdown-menu li {
  padding: 10px;
  cursor: pointer;
}

.dropdown-menu li:hover {
  background-color: #f0f0f0;
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
  /* .rectangle-6 {
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
  } */
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
  .line-7 {
    margin-top: -1px;
    border-style: solid;
    border-color: #d9d9d9;
    border-width: 1px 0 0 0;
    width: 35px;
    height: 0px;
    position: absolute;
    left: 1170px;
    top: 107px;
    transform-origin: 0 0;
    transform: rotate(90deg) scale(1, 1);
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
  /* .image-12 {
    width: 43.83px;
    height: 43.83px;
    position: absolute;
    left: 24.31px;
    top: 365.68px;
    object-fit: cover;
    aspect-ratio: 1;
  } */
  /* .image-13 {
    width: 29.61px;
    height: 29.61px;
    position: absolute;
    left: 31.42px;
    top: 455.06px;
    object-fit: cover;
    aspect-ratio: 1;
  } */
  /* .image-14 {
    width: 30.8px;
    height: 30.8px;
    position: absolute;
    left: 31.49px;
    top: 531.98px;
    object-fit: cover;
    aspect-ratio: 1;
  } */
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

  .image-37 {
    width: 25px;
    height: 25px;
    position: absolute;
    left: 5px;
    top: 10px;
    object-fit: cover;
    aspect-ratio: 1;
  }
  .image-43 {
    width: 25px;
    height: 25px;
    position: absolute;
    left: 100px;
    top: 0px;
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
  
/* 드롭다운 컨테이너 */
.dropdown-container-color {
  position: relative;
  left: 1250px;
  top: -850px;
  display: block;
  cursor: pointer;
}

/* 선택된 색상 버튼 */
.selected-option {
  width: 40px;
  height: 40px;
  border-radius: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
  border: 1px solid #ccc;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
}

/* 드롭다운 메뉴 */
.dropdown-menu-color {
  position: absolute;
  top: 50px;
  left: 0;
  background: white;
  border: 1px solid #d9d9d9;
  border-radius: 10px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
  padding: 10px;
  list-style: none;
  display: block;
  gap: 50px;
  z-index: 100;
}

/* 드롭다운 내부 원형 색상 선택 버튼 */
.color-circle {
  width: 35px;
  height: 35px;
  border-radius: 50%;
  cursor: pointer;
  transition: transform 0.2s ease-in-out;
}

.color-circle:hover {
  transform: scale(1.1);
}


/* 기존 ellipse 색상 유지 */
.ellipse-2 {
  background: #ffc1c1;
}
.ellipse-3 {
  background: #c1ffe9;
}
.ellipse-4 {
  background: #4285f4;
}
.ellipse-5 {
  background: #fbbc05;
}
.ellipse-6 {
  background: #ff0000;
}
  </style>
  