<template>
  <div class="full">
    <ul class="category-list">
      <li v-for="(category, index) in categories" :key="index" class="category-item">
        <!-- 카테고리 이름 -->
         <div v-if="!category.isModify">
          <a :href="category.url" class="category-link">{{ category.name }}</a>
         </div>

        <div v-if="category.isModify">
          <input id="updateName" name="updateName" type="text" class="category-link" v-model="category.name">
          
        </div>
          <!-- 라디오 버튼 -->
          <div class="radio-container">
          <div 
            class="radio-option" 
            :class="{ selected: category.selectedOption === 'O' }" 
            @click="category.selectedOption = 'O'">
            O
          </div>
          <div 
            class="radio-option" 
            :class="{ selected: category.selectedOption === 'X' }" 
            @click="category.selectedOption = 'X'">
            X
          </div>
          
        </div>

        <!-- 수정/삭제 버튼 -->
        <div class="button-container">
          <img class="modify-image" v-if="!category.isModify" src="/src/assets/images/public/image-290.png" @click="modifyCategory(index)" />
          <img class="delete-image" src="/src/assets/images/public/image-230.png" @click="deleteCategory(index)" />
        </div>

        <div v-if="category.isModify">
          <button @click="updateSubmit(category.name, index)" class="modify-submit">완료</button>
          <button @click="resetCategory(index)" class="modify-reset">취소</button>
        </div>
      </li>
    </ul>

    <div class="search-box">

      <form @submit.prevent="handleSubmit">
    <input 
      type="text" 
      class="new-category" 
      placeholder="  카테고리 이름을 입력하세요" 
      v-model="newCategoryName" /> <!-- 입력된 카테고리 이름 -->

    <img 
      class="plus-image" 
      src="/src/assets/images/myCategoriesComponent/image-250.png" 
      @click="handleSubmit" />

      <div class="new-radio-container">
      <div 
        class="new-radio-option" 
        :class="{ selected: newSelectedOption === 'O' }"
        @click="newSelectedOption = 'O'">
        O
      </div>
      <div 
        class="new-radio-option" 
        :class="{ selected: newSelectedOption === 'X' }"
        @click="newSelectedOption = 'X'">
        X
      </div>
    </div>
  </form>
      
      
      
      

    </div>

    <div class="top"></div>
    <div class="title">TITLE</div>
    <div class="publish">PUBLISH</div>

    <div class="title-dividing-line"></div>
    <div class="publish-dividing-line"></div>

    
  </div>
</template>
<script>
import apiClient from '@/api/axios.js';
import { ref, onMounted } from 'vue';

export default {
  name: "MyCategories",
  setup() {
    const newCategoryName = ref('');  // 카테고리 이름 입력
    const newSelectedOption = ref('O');  // 기본적으로 X로 설정
    const categories = ref([]);  // 기존 카테고리 목록
    const updateName = ref('');


    const initializeCategoryOptions = () => {
        categories.value.forEach((category) => {
        category.selectedOption = category.publish === true || category.publish === 'true' ? 'O' : 'X';
        category.isModify = false;
      });
    };
    // 서버에서 카테고리 목록을 가져오는 함수
    onMounted(() => {
      apiClient.get('/categories')
      .then(response => {
        console.log("서버 응답 데이터:", response.data); // 응답 데이터 확인
        categories.value = response.data;
        initializeCategoryOptions(); // 데이터 로딩 후 초기화
        
      }).catch(error => {
        console.error("에러 발생:", error);
      });
    }); 


    // 새 카테고리 추가를 위한 함수
    const handleSubmit = async () => {
      if (!newCategoryName.value.trim()) {
        alert('카테고리 이름을 입력해주세요.');
        return;
      }

      const payload = {
        name: newCategoryName.value,
        publish: newSelectedOption.value === 'O',  // 'O'일 경우 true, 'X'일 경우 false
      };

      try {
        const response = await apiClient.post('/categories', payload);
        // console.log('카테고리 추가 성공:', response.data);

            // 명시적으로 필요한 필드만 추가
        const newCategory = {
          name: response.data.name,
          publish: response.data.publish
        };

        console.log(newCategory);
        
        
        // 서버에서 반환된 카테고리 데이터로 새 카테고리 추가
        // categories.value.push(response.data);
        categories.value.push(newCategory);

        // 추가 후, 입력 필드 초기화
        newCategoryName.value = '';
        newSelectedOption.value = 'X'; // 기본값으로 초기화

        initializeCategoryOptions();
      } catch (error) {
        console.error('카테고리 추가 실패:', error);
      }
    };

    const updateSubmit = async(categoryName, index, publish) => {
      const isDuplicate = categories.value.some((category, idx) => category.name === categoryName && idx !== index);

      if (isDuplicate) {
        alert('이미 존재하는 카테고리 이름입니다.');
        // 수정 전 상태로 돌아가기
        categories.value[index].name = categories.value[index].originalCategory.name;
        categories.value[index].publish = categories.value[index].originalCategory.publish;
        categories.value[index].isModify = false;
        return; // 중복일 경우 수정 작업을 중단
      }


      if(publish === 'O') {
        publish = 'true';
      } else {
        publish = 'false';
      }


      console.log(categoryName);
      
      console.log(categories.value[index]);


      const payload = {
        id: categories.value[index].id,
        name: categoryName,
        publish: publish
      };


      try {
        const response = await apiClient.put('/categories/update', payload);
        categories.value[index].name = categoryName;
        categories.value[index].publish = publish;
      
    } catch(error) {
        console.error('카테고리 수정 실패:', error);
      }

      categories.value[index].isModify = false;
    }



    // 카테고리 수정 함수 (추가 기능을 위해 빈 함수로 유지)
    const modifyCategory = (index) => {
      console.log("수정 버튼");

      // 카테고리 수정 전 상태 백업
  if (!categories.value[index].originalCategory || categories.value[index].isModify === false) {
    categories.value[index].originalCategory = { ...categories.value[index] }; // 수정 전 상태 백업
  }

  categories.value[index].isModify = !categories.value[index].isModify;  // 수정 모드 토글
};

// 수정 취소 버튼 클릭 시 원래 상태로 복원
const resetCategory = (index) => {
  // 수정 전 상태로 복원
  const originalCategory = categories.value[index].originalCategory;
  if (originalCategory) {
    categories.value[index].name = originalCategory.name;
    categories.value[index].publish = originalCategory.publish;
    categories.value[index].isModify = false; // 수정 모드 해제
  } else {
    console.error('원래 카테고리 정보가 존재하지 않습니다.');
  }
};

const deleteCategory = async (index) => {
  const categoryId = categories.value[index].id;

  // 확인 창을 띄워서 사용자가 삭제를 확인하면 삭제를 진행
  const isConfirmed = confirm('진짜 지움?');
  if (isConfirmed) {
    try {
      await apiClient.delete(`/categories/${categoryId}`);
      console.log(`삭제된 카테고리: ${categories.value[index].name}`);
      
      categories.value.splice(index, 1); // 삭제 후 배열에서 제거
    } catch (error) {
      console.error("카테고리 삭제 중 오류 발생:", error);
    }
  } else {
    console.log("삭제 취소");
  }
};

    return {
      newCategoryName,
      newSelectedOption,
      categories,
      handleSubmit,
      modifyCategory,
      deleteCategory,
      updateSubmit,
      updateName,
      resetCategory,
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
    left: 146px;
    top: 114px;
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
    left: 146px;
    top: 50px;
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
.modify-submit {
  color: #000000;
  width: 50px;
  white-space: nowrap;
  overflow: hidden;
  text-align: left;
  text-overflow: ellipsis ;
  font-size: 15px;
  font-weight: 400;
  text-decoration: none;
}
.modify-reset {
  color: #000000;
  width: 50px;
  white-space: nowrap;
  overflow: hidden;
  text-align: left;
  text-overflow: ellipsis ;
  font-size: 15px;
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
  right: 190px;
  bottom: 38px;
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
  left: 1200px;
  top: 25px;
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