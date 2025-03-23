<template>
  <div class="_1"> 

    <ul class="category-list">
    <li v-for="(category, index) in categories" :key="index" class="category-item">
      <!-- 카테고리 이름 -->
      <a :href="category.url" class="category-link">{{ category.name }}</a>

      <!-- 라디오 버튼 -->
      <div class="radio-container">
        <div class="radio-group">
          <input type="radio" :id="'optionO' + index" 
            :name="'option' + index" value="O" v-model="category.selectedOption">
          <label :for="'optionO' + index">O</label>

          <input type="radio" :id="'optionX' + index" 
            :name="'option' + index" value="X" v-model="category.selectedOption">
          <label :for="'optionX' + index">X</label>
        </div>
      </div>

      <!-- 수정/삭제 버튼 -->
      <div class="button-container">
        <img class="modify-image" src="/src/assets/images/public/image-290.png" @click="deleteCategory(index)" />
        <img class="delete-image" src="/src/assets/images/public/image-230.png" @click="editCategory(index)" />
      </div>
    </li>
  </ul>
    <img class="alarm-image" src="/src/assets/images/public/image-150.png" />

    <button class="logout-button">Logout</button>
    <button class="search-button">Search</button>

    <input type="text" class="search-name"  placeholder="   . . ." />
    <input type="text" class="search-category" placeholder="  카테고리 제목을 입력하세요" />    
    <div class="name-box"></div>
    <div class="name">name</div>
    <div class="title">TITLE</div>
    <div class="publish">PUBLISH</div>
   
    <div class="title-dividing-line"></div>
    <div class="publish-dividing-line"></div>

    <img class="plus-image" src="/src/assets/images/myCategoriesComponent/image-250.png" @click="handleClick" />
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

    <div class="left-side-box"></div>
    </div>
</template>



<script>
export default {
  name: "RadioButtonComponent", 
  data() {
    return {
      categories: [
        { name: "스터디카페 (5)", url: "이동할_페이지_URL", selectedOption: "X" },
        { name: "코인노래방 (3)", url: "이동할_페이지_URL", selectedOption: "X" },
        { name: "혼밥 (40)", url: "이동할_페이지_URL", selectedOption: "X" }
      ],
    };
  },

  methods: {
    navigateTo(page) {
      this.$router.push(`/${page}`);
    },
    editCategory(index) {
      console.log(`수정 버튼 클릭: ${this.categories[index].name}`);
    },
    deleteCategory(index) {
      console.log(`삭제 버튼 클릭: ${this.categories[index].name}`);
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

/* 라디오 버튼 그룹 스타일 */
.radio-container {
  position: absolute;
  left: 820px;
  width: 200px;
}

.radio-group {
  display: flex;
  gap: 20px;
  align-items: center;
  /* font-family: "Inter-Medium", sans-serif; */
  font-size: 30px;
  /* font-weight: 500; */
}

input[type="radio"] {
  display: flex;
}

input[type="radio"]:checked + label {
  font-weight: bold;
}

label {
  cursor: pointer;
  font-size: 20px;
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


.search-name { /* 검색창  */
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

.search-category { /* 카테고리 이름 입력칸 */
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

.category-link {
  color: #000000;
  width: 300px;
  white-space: nowrap;
  overflow: hidden;
  text-align: left;
  text-overflow: ellipsis ;
  font-size: 24px;
  font-weight: 400;
  text-decoration: underline;
}

.category-list {
  list-style: none;
  padding: 20px;
  margin-top: 180px;
  margin-left: 315px;
}

.category-item {
  display: flex;           /* 가로 정렬 */
  align-items: center;     /* 세로 중앙 정렬 */
  justify-content: space-between; 
  width: 1550px;             /* 부모 요소 기준으로 전체 너비 사용 */
  padding: 15px;           /* 내부 여백 추가 */
  border-bottom: 1px solid #ddd; /* 각 항목 구분선 */
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
  left: 1057px;
  top: 109px;
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
  left: 1417px;
  top: 109px;
  transform-origin: 0 0;
  transform: rotate(90deg) scale(1, 1);
}

.plus-image {
  width: 27px;
  height: 28px;
  position: absolute;
  left: 1742px;
  top: 175px;
  object-fit: cover;
  cursor: pointer;
  transition: transform 0.2s ease-in-out;
}

.modify-image {
  width: 37px;
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
.left-side-box {
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
  left: 1330px;
}

.button-container img {
  width: 25px;   /* 버튼 크기 조정 */
  height: 25px;  /* 버튼 크기 조정 */
  cursor: pointer; /* 클릭 가능하도록 커서 변경 */
}


</style>
