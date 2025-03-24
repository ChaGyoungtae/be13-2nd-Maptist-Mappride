<template>
  <div class="full">

    <ul class="category-list">
      <li v-for="(category, index) in categories" :key="index" class="category-item">
        <!-- 카테고리 이름 -->
        <a :href="category.url" class="category-link">{{ category.name }}</a>

      <!-- 라디오 버튼 -->
      <div class="radio-container">
        <div  class="radio-option" :class="{ selected: category.selectedOption === 'O' }" 
          @click="category.selectedOption = 'O'">O
        </div>
        <div class="radio-option" :class="{ selected: category.selectedOption === 'X' }" 
          @click="category.selectedOption = 'X'">X
        </div>
        </div>

        <!-- 수정/삭제 버튼 -->
        <div class="button-container">
          <img class="modify-image" src="/src/assets/images/public/image-290.png" @click="deleteCategory(index)" />
          <img class="delete-image" src="/src/assets/images/public/image-230.png" @click="editCategory(index)" />
        </div>
      </li>
    </ul>

    <button class="logout-button">Logout</button>
    <button class="search-button">Search</button>

    <input type="text" class="search-name"  placeholder="   . . ." />

    <div class="search-box">
      <input type="text" class="new-category" placeholder="  카테고리 이름을 입력하세요" /> 
      <div class="new-radio-container">
        <div class="new-radio-option" :class="{ selected: newSelectedOption === 'O' }"
          @click="newSelectOption('O')" >O
        </div>
        <div class="new-radio-option" :class="{ selected: newSelectedOption === 'X' }"
          @click="newSelectOption('X')">X
        </div>
      </div>
    </div>

    <div class="name-box">name</div>

    <div class="top"></div>
    <div class="title">TITLE</div>
    <div class="publish">PUBLISH</div>
   
    <div class="title-dividing-line"></div>
    <div class="publish-dividing-line"></div>

    <img class="plus-image" src="/src/assets/images/myCategoriesComponent/image-250.png" @click="handleClick" />

  </div>
</template>

<script>
import { ref } from "vue";

export default {
  name: "MyCategories",
  setup() {
    const categories = ref([
      { name: "스터디카페 (5)", url: "이동할_페이지_URL", selectedOption: "X" },
      { name: "코인노래방 (3)", url: "이동할_페이지_URL", selectedOption: "X" },
      { name: "혼밥 (40)", url: "이동할_페이지_URL", selectedOption: "X" },
    ]);

    const newSelectedOption = ref(null); // 새로운 O, X 선택 값

    const newSelectOption = (option) => {
      newSelectedOption.value = option; // 선택 값 변경
    };

    const navigateTo = (page) => {
      // 페이지 이동 로직 (Vue Router가 설정되어 있어야 함)
      console.log(`Navigating to: ${page}`);
    };

    const editCategory = (index) => {
      console.log(`수정 버튼 클릭: ${categories.value[index].name}`);
    };

    const deleteCategory = (index) => {
      console.log(`삭제 버튼 클릭: ${categories.value[index].name}`);
    };

    return {
      categories,
      newSelectedOption,
      newSelectOption,
      navigateTo,
      editCategory,
      deleteCategory,
    };
  },
};
</script>




<style scoped>
.full * {
  box-sizing: border-box;
}
.full { /* 왼쪽, 센터 바탕색 */
    position: absolute;  /* 자식 요소는 부모를 기준으로 절대 위치 */
    top: 40px;
    left: 200px;
    height: 100%;
    width: 1600px;
}

.div,
.div * {
box-sizing: border-box; 
}
.div {
  height: 1080px;
  position: relative;
  overflow: hidden;
}

 /* 라디오 버튼 그룹 스타일 */
.radio-container {
  position: absolute;
  left: 835px;
  width: 200px;
  display: flex;
  gap: 50px;
  align-items: center;
  font-size: 20px;
  cursor: pointer;
}

/* 기본 옵션 스타일 */
.radio-option {
  padding: 5px 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
  cursor: pointer;
  transition: all 0.2s ease-in-out;
}

/* 선택된 옵션 스타일 */
.radio-option.selected {
  font-weight: bold;
  background-color: #ddd;
  border-color: #888;
}

input[type="radio"] {
  display: flex;
}

input[type="radio"]:checked + label {
  font-weight: bold;
}


img {
  cursor: pointer;
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
  gap: 8px; 
  background: white;
  border: 1px solid #d9d9d9;
  border-radius: 5px;
  cursor: pointer;
  align-items: center;
  justify-content: center;
  font-size: 16px;
  font-weight: bold;
  color: #333;
  transition: background 0.3s, transform 0.2s ease-in-out;
}

.delete-image:active {
  transform: scale(0.95);
}
.modify-image:active {
  transform: scale(0.95);
}
.plus-image:active {
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

/* 검색창  */
.search-name { 
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

/* 카테고리 이름 입력칸 */
.new-category { 
  background: #ffffff;
  border: 1px solid #d2d2d2;
  width: 708px;
  height: 45px;
  padding: 10px;
  font-size: 16px;
  position: absolute;
  left: 10px;
  top: 20px;
  z-index: 500;
}

.search-box {
  background: #ffffff;
    border-style: solid;
    border-color: #d2d2d2;
    border-width: 1px;
    width: 1550px;
    height: 80px;
    position: absolute;
    left: 335px;
    top: 154px;
}

/* 라디오 버튼 그룹 스타일 */
.new-radio-container {
  position: absolute;
  left: 835px;
  top: 25px;
  display: flex;
  gap: 50px;
  align-items: center;
  font-size: 20px;
  cursor: pointer;
}

/* 선택된 옵션 스타일 */
.new-radio-option {
  padding: 5px 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
  cursor: pointer;
  transition: all 0.2s ease-in-out;
}

.new-radio-option.selected {
  font-weight: bold;
  background-color: #ddd;
  border-color: #888;
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

.top {
    background: #ffffff;
    border-style: solid;
    border-color: #d2d2d2;
    border-width: 1px;
    width: 1550px;
    height: 65px;
    position: absolute;
    left: 335px;
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
  left: 161px;
  top: 74px;
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
  left: 1000px;
  top: 74px;
  width: 150px;
  height: 28px;
}

.category-link {
  color: #000000;
  width: 300px;
  white-space: nowrap;
  overflow: hidden;
  text-align: left;
  text-overflow: ellipsis ;
  font-size: 20px;
  font-weight: 400;
  text-decoration: none;
}

.category-list {
  list-style: none;
  padding: 20px;
  margin-top: 210px;
  margin-left: 315px;
}

.category-item {
  display: flex;           /* 가로 정렬 */
  align-items: center;     /* 세로 중앙 정렬 */
  justify-content: space-between; 
  width: 1550px;             /* 부모 요소 기준으로 전체 너비 사용 */
  padding: 30px;           /* 내부 여백 추가 */
  border-bottom: 1px solid #ddd; /* 각 항목 구분선 */
  border-right: 1px solid #ddd;
  gap: 10px;
  position: relative;
}

.title-dividing-line {
  margin-top: -1px;
  border-style: solid;
  border-color: #d9d9d9;
  border-width: 1px 0 0 0;
  width: 35px;
  height: 0px;
  position: absolute;
  left: 857px;
  top: 69px;
  transform-origin: 0 0;
  transform: rotate(90deg) scale(1, 1);
}
.publish-dividing-line {
  margin-top: -1px;
  border-style: solid;
  border-color: #d9d9d9;
  border-width: 1px 0 0 0;
  width: 35px;
  height: 0px;
  position: absolute;
  left: 1217px;
  top: 69px;
  transform-origin: 0 0;
  transform: rotate(90deg) scale(1, 1);
}

.plus-image {
  width: 27px;
  height: 28px;
  position: absolute;
  left: 1542px;
  top: 135px;
  object-fit: cover;
  cursor: pointer;
  transition: transform 0.2s ease-in-out;
}

.modify-image {
  width: px;
  height: 36px;
  cursor: pointer;
  transition: transform 0.2s ease-in-out; /* 클릭 효과 */
}

.delete-image {
  width: 27px;
  height: 28px;
  cursor: pointer;
  transition: transform 0.2s ease-in-out;
}

&:hover {
    transform: scale(1.1);
}

  /* 클릭 시 살짝 눌리는 효과 */
&:active {
    transform: scale(0.95);
}

.button-container {
  position: absolute;
  display: flex;  
  gap: 20px;           /* 버튼 사이 여백 추가 */
  justify-content: flex-end;
  width: 120px;
  left: 1130px;
}

.button-container img {
  width: 25px;   /* 버튼 크기 조정 */
  height: 25px;  /* 버튼 크기 조정 */
  cursor: pointer; /* 클릭 가능하도록 커서 변경 */
}

</style>
