<template>
  <div class="full">
    <div class="top"></div>
    <div class="title">TITLE</div>
    <div class="address">ADDRESS</div>
    <div class="color">COLOR</div>

    <div class="title-dividing-line"></div>
    <div class="address-dividing-line"></div>
    <div class="color-dividing-line"></div>

    <ul class="place-list" >
      <li v-for="(place, index) in places" :key="index" class="place-item">
        <a :href="place.url" class="place-link">{{ place.name }}</a>
        <div class="place-address">{{ place.placeAddress }}</div>
        <div class="button-container">
          <img class="modify-image" src="/src/assets/images/public/image-290.png" @click="editPlace(index)" />
          <img class="delete-image" src="/src/assets/images/public/image-230.png" @click="deletePlace(index)" />
        </div>

        <!-- 색상 드롭다운 -->
        <div class="dropdown-container-color" :class="{ open: colorDropdownVisible[index] }">
          <div class="selected-option" @click="toggleColorDropdown(index)">
            <div class="color-circle" :class="selectedClass[index]"></div>
          </div>

          <ul v-show="colorDropdownVisible[index]" class="dropdown-menu-color">
            <li v-for="(color, colorIndex) in colors" :key="colorIndex" @click="selectColor(index, color.className)">
              <div class="color-circle" :class="color.className"></div>
            </li>
          </ul>
        </div>
      </li>
    </ul>

    <!-- 정렬 드롭다운 -->
    <div class="sortDropdown" @click="toggleSortDropdown">
      <span class="selected-container">
        <img :src="selectedSortImage" class="dropdown-image" alt="Selected Option Image" />
        <span class="selected-text"> {{ selectedSort }}</span>
      </span>
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
  import { ref, onMounted } from "vue";
  import axios from "axios";
  
  export default {
    name: "Two",
    setup() {
      const places = ref([]);
      const colorDropdownVisible = ref(new Array(places.value.length).fill(false));
      const selectedClass = ref(new Array(places.value.length).fill("ellipse-2"));
      const colors = ref([
        { className: "ellipse-2" },
        { className: "ellipse-3" },
        { className: "ellipse-4" },
        { className: "ellipse-5" },
        { className: "ellipse-6" }
      ]);
  
      const sortDropdownVisible = ref(false);
      const selectedSortImage = ref("/src/assets/images/MyPlaceComponent/filter.png");
      const selectedSort = ref("Filter");
      const sortOptions = ref([
        { value: "date-asc", label: "최신순", image: "/src/assets/images/MyPlaceComponent/image-430.png" },
        { value: "date-desc", label: "최신순", image: "/src/assets/images/MyPlaceComponent/image-400.png" },
        { value: "name-asc", label: "이름순", image: "/src/assets/images/MyPlaceComponent/image-430.png" },
        { value: "name-desc", label: "이름순", image: "/src/assets/images/MyPlaceComponent/image-400.png" }
      ]);
  
      // Axios로 데이터 받아오기
      const fetchPlaces = async () => {
        try {
          const response = await axios.get("API_URL"); // 여기에 실제 API URL을 넣어주세요
          console.log("받은 데이터:", response.data);
          places.value = response.data; // API에서 반환된 데이터로 places 값을 업데이트
        } catch (error) {
          console.error("데이터를 가져오는 데 실패했습니다:", error);
        }
      };
  
      // 페이지가 마운트되면 장소 데이터를 받아옴
      onMounted(() => {
        fetchPlaces();
      });
  
      // 수정 및 삭제 기능
      const editPlace = (index) => {
        console.log(`수정 버튼 클릭: ${places.value[index].name}`);
        alert(`장소 수정: ${places.value[index].name}`);
      };
  
      const deletePlace = (index) => {
        console.log(`삭제 버튼 클릭: ${places.value[index].name}`);
      };
  
      // 색상 드롭다운 관련 함수
      const toggleColorDropdown = (index) => {
        colorDropdownVisible.value[index] = !colorDropdownVisible.value[index];
        colorDropdownVisible.value = colorDropdownVisible.value.map((_, i) => (i === index ? colorDropdownVisible.value[index] : false));
      };
  
      const selectColor = (index, colorClass) => {
        selectedClass.value[index] = colorClass;
        colorDropdownVisible.value[index] = false;
      };
  
      // 정렬 드롭다운 관련 함수
      const toggleSortDropdown = () => {
        sortDropdownVisible.value = !sortDropdownVisible.value;
      };
  
      const setSortOrder = (option) => {
        selectedSort.value = option.label;
        selectedSortImage.value = option.image;
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
        setSortOrder,
        places,
        editPlace,
        deletePlace
      };
    }
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

.alarm-image {
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

.alarm-image:active {
transform: scale(0.95);
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

.dropdown-image{
  display: inline;
  margin-left:auto;
  width: 30px;
  height: 30px;
}

.sortDropdown {
  background: #ffffff;
  border: 1px solid #d9d9d9;
  width: 120px;
  height: 45px;
  position: absolute;
  left: 1730px;
  top: 100px;
  display: flex;
  justify-content: space-between;
  align-items:center;
  padding: 0 10px;
  cursor: pointer;
  }

.selected-text {
  font-size: 19px;
  text-align: center;
  margin-left: 10px; 
}

/* 드롭다운 메뉴 스타일 */
.dropdown-menu {
  position: absolute;
  top: 50px;
  font-size: 16px;
  left: 0;
  background-color: #ffffff;
  border: 1px solid #d9d9d9;
  width: 120px;
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

.search-box { 
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

.name-box { 
  background: #ffffff;
  border-style: solid;
  border-color: #d2d2d2;
  border-width: 1px;
  width: 164px;
  height: 45px;
  position: absolute;
  left: 535px;
  top: 23px;
  align-items: center;
  justify-content: center;
  font-size:20px;
  font-weight: bold;
  color: #333;
  display: flex;
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

.top{
  background: #ffffff;
  border-style: solid;
  border-color: #d2d2d2;
  border-width: 1px;
  width: 1550px;
  height: 65px;
  position: absolute;
  left: 346px;
  top: 90px;
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

.title-dividing-line {
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

.address {
  color: #000000;
  text-align: left;
  font-family: "Inter-Medium", sans-serif;
  font-size: 16px;
  line-height: 150%;
  font-weight: 500;
  position: absolute;
  left: 970px;
  top: 110px;
  width: 111px;
  height: 30px;
}

.address-dividing-line {
  margin-top: -1px;
  border-style: solid;
  border-color: #d9d9d9;
  border-width: 1px 0 0 0;
  width: 35px;
  height: 0px;
  position: absolute;
  left: 1300px;
  top: 107px;
  transform-origin: 0 0;
  transform: rotate(90deg) scale(1, 1);
}

.color {
  color: #000000;
  text-align: left;
  font-family: "Inter-Medium", sans-serif;
  font-size: 16px;
  line-height: 150%;
  font-weight: 500;
  position: absolute;
  left: 1400px;
  top: 111px;
  width: 92px;
  height: 26px;
}

.color-dividing-line {
  margin-top: -1px;
  border-style: solid;
  border-color: #d9d9d9;
  border-width: 1px 0 0 0;
  width: 35px;
  height: 0px;
  position: absolute;
  left: 1550px;
  top: 105px;
  transform-origin: 0 0;
  transform: rotate(90deg) scale(1, 1);
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

.left-sidebox {
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

/* 링크 박스 스타일 */
.category-link-box {
  position: absolute;
  left: 335px;
  top: 155px;
  width: 1550px;
  height: 65px;
  display: flex;
  border-bottom: 1px solid #ddd;
  border-right: 1px solid #ddd;
}

/* 링크 스타일 (글씨만 클릭 가능하도록) */
.category-link {
  color: #000000;
  text-align: center;
  font-family: "Stylish-Regular", sans-serif;
  font-size: 20px;
  font-weight: 400;
  text-decoration: underline;
  display: inline; /* 글씨만 클릭되게 설정 */
  padding-left: 10px;
  padding-top: 20px;
  white-space: nowrap; /* 텍스트가 줄바꿈되지 않도록 */
}
    
/* 드롭다운 컨테이너 */
.dropdown-container-color {
  position: relative; 
  display: inline-block;
  cursor: pointer;
  left: -460px;
  top: 0px;
  /* z-index: 500; */
}

/* 선택된 색상 버튼 */
.selected-option {
  width: 50px;
  height: 50px;
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
  top: 60px;
  left: -5px;
  background: white;
  border: 1px solid #d9d9d9;
  border-radius: 10px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
  padding: 10px;
  list-style: none;
  display: none;
  z-index: 300;
  /* gap: 50px; */
}

.dropdown-menu-color li {
  padding: 5px;
  cursor: pointer;
}

/* 드롭다운 내부 원형 색상 선택 버튼 */
.color-circle {
  width: 35px;
  height: 35px;
  border-radius: 50%;
  cursor: pointer;
  transition: transform 0.2s ease-in-out;
}

.dropdown-container-color.open .dropdown-menu-color {
  display: block;
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

.place-list {
  list-style: none;
  padding: 20px;
  margin-top: 200px;
  margin-left: 315px;
}

.place-item {
  display: flex;           /* 가로 정렬 */
  align-items: center;     /* 세로 중앙 정렬 */
  justify-content: space-between; 
  width: 1550px;             /* 부모 요소 기준으로 전체 너비 사용 */
  padding: 15px;           /* 내부 여백 추가 */
  border-bottom: 1px solid #ddd; /* 각 항목 구분선 */
  border-right: 1px solid #ddd;
  position: relative;
  bottom: 1155px;
  left: 5px;
}

/* 📍 place-link 폰트 크기 조정 */
.place-link {
  color: #000000;
  width: 250px;
  white-space: nowrap;
  overflow: hidden;
  text-align: left;
  text-overflow: ellipsis;
  font-size: 20px; 
  font-weight: 400;
  text-decoration: none;
}

.place-address {
  color: #000000;
  text-align: left;
  font-family: "Inter-Medium", sans-serif;
  font-size: 16px;
  line-height: 150%;
  font-weight: 500;
  position: relative;
  width: 600px; 
  height: auto;
  white-space: nowrap; 
  overflow: hidden; 
  text-overflow: ellipsis; 
}

.button-container{
  position: relative;
}

.modify-image {
  width: 37px;
  height: 36px;
  position: absolute;
  left: 100px;
  top: -10px;
  cursor: pointer;
  transition: transform 0.2s ease-in-out; /* 클릭 효과 */
}

.delete-image {
  width: 27px;
  height: 28px;
  position: absolute;
  left: 170px;
  top: -10px;
  cursor: pointer;
  transition: transform 0.2s ease-in-out;
}

.modify-image:active {
  transform: scale(0.95);
}

.delete-image:active {
  transform: scale(0.95);
}

</style>