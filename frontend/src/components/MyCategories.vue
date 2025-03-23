<template>
  <div class="full">

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

    <input type="text" class="search-category" placeholder="  카테고리 제목을 입력하세요" />    
    <div class="title">TITLE</div>
    <div class="publish">PUBLISH</div>
   
    <div class="title-dividing-line"></div>
    <div class="publish-dividing-line"></div>

    <img class="plus-image" src="/src/assets/images/myCategoriesComponent/image-250.png" @click="handleClick" />

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
  left: 620px;
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

.delete-image:active {
  transform: scale(0.95);
}
.modify-image:active {
  transform: scale(0.95);
}
.plus-image:active {
  transform: scale(0.95);
}

.search-category { /* 카테고리 이름 입력칸 */
  background: #ffffff;
  border: 1px solid #d2d2d2;
  width: 708px;
  height: 45px;
  padding: 10px;
  font-size: 16px;
  position: absolute;
  left: 149px;
  top: 125px;
  outline: none;
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
  font-size: 24px;
  font-weight: 400;
  text-decoration: underline;
}

.category-list {
  list-style: none;
  padding: 20px;
  margin-top: 150px;
  margin-left: 115px;
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
