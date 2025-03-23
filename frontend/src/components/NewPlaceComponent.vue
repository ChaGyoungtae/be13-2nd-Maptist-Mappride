<template>
  <div class="full">
    
    <label><input type="text" class="rectangle-29"></label>
    <div class="place-name">Place Name</div>
    <textarea class="rectangle-32"/>
    <div class="content">Content</div>

    <!-- 색상 선택 드롭다운 -->
    <div class="dropdown-container" @click="toggleDropdown">
      <!-- 선택된 색상 표시 -->
      <div class="selected-option">
        <div class="color-circle" :class="selectedClass"></div>
      </div>

      <!-- 드롭다운 메뉴 -->
      <ul v-if="isOpen" class="dropdown-menu">
        <li v-for="(color, index) in colors" :key="index" @click="selectColor(color.className)">
          <div class="color-circle" :class="color.className"></div>
        </li>
      </ul>
    </div>

    <button class="btnSave">save</button>
    <button class="btnCancel">cancel</button>

    <div class="rectangle-33"></div>

    <label for="thumbnailInput" class="add-thumbnail">
      + add thumbnail<br>
      <input id="thumbnailInput" type="file" @change="addImage"/> <br>
      <img :src="src" />
    </label>
  
    <div class="rectangle-34"></div>

    <label for="photosInput" class="add-photos">
      + add photos..<br>
      <input id="photosInput" type="file" @change="addImages" multiple /> <br>
      <img v-for="(item, index) in src" :key="index" :src="item" />
    </label>
  </div>
</template>
<script>
import { ref } from 'vue';

const src = ref();

const addImage = (e) => {
  const [file] = e.target.files;
  console.log(e.target.files);
  if (file) {
    src.value = URL.createObjectURL(file);
  }
};

const addImages = (e) => {
  const file = (e.target).files;
  const fileLength = file.length;
  let newList = [];
  for (let i = 0; i < fileLength; i++) {
    newList.push(URL.createObjectURL(file[i]));
  }
  src.value = newList;
};

export default {
  name: "Component",
  components: {},
  props: {},
  methods: {
    handleClick() {
      alert("클릭 이벤트 테스트"); // 클릭 이벤트 테스트
    }
  },
  data() {},
  setup() {
    const isOpen = ref(false); // 드롭다운 열림 여부
    const selectedClass = ref("ellipse-2"); // 기본 선택된 색상

    const colors = ref([
      { className: "ellipse-2" },
      { className: "ellipse-3" },
      { className: "ellipse-4" },
      { className: "ellipse-5" },
      { className: "ellipse-6" }
    ]);
     // 드롭다운 열고 닫기
     const toggleDropdown = () => {
      isOpen.value = !isOpen.value;
    };

    // 색상 선택
    const selectColor = (colorClass) => {
      selectedClass.value = colorClass;
      isOpen.value = false; // 선택 후 드롭다운 닫기
    };

    return { isOpen, selectedClass, colors, toggleDropdown, selectColor };
  }
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
.group-12 {
  width: 248.36px;
  height: 104.41px;
  position: static;
}
.group-13 {
  width: 248.36px;
  height: 104.41px;
  position: static;
}
.rectangle-9 {
  width: 132px;
  height: 44px;
  position: absolute;
  left: 1555px;
  top: 23px;
  overflow: visible;
}
/* .logout {
  color: #000000;
  text-align: left;
  font-family: "Stylish-Regular", sans-serif;
  font-size: 20px;
  font-weight: 400;
  position: absolute;
  left: 1787px;
  top: 31px;
  width: 70px;
  height: 27px;
} */

  .btnSave {
    color: #000000;
    text-align: left;
    font-family: "Stylish-Regular", sans-serif;
    font-size: 20px;
    font-weight: 400;
    position: absolute;
    width: 97px;
    height: 60px;
    left: 1090px;
    top: 952px;
    background-color: transparent; /* 배경을 투명하게 설정 */
    border: 2px solid #d2d2d2; /* 테두리 추가 (두께 2px, 색상 #d2d2d2) */
    cursor: pointer; /* 마우스를 올렸을 때 커서가 포인터로 바뀌게 설정 */
    display: flex;
    align-items: center;
    justify-content: center;
  }
  .btnCancel {
    color: #000000;
    text-align: left;
    font-family: "Stylish-Regular", sans-serif;
    font-size: 20px;
    font-weight: 400;
    position: absolute;
    width: 97px;
    height: 60px;
    left: 1202px;
    top: 952px;
    background-color: transparent; /* 배경을 투명하게 설정 */
    border: 2px solid #d2d2d2; /* 테두리 추가 (두께 2px, 색상 #d2d2d2) */
    cursor: pointer; /* 마우스를 올렸을 때 커서가 포인터로 바뀌게 설정 */
    display: flex;
    align-items: center;
    justify-content: center;
  }

.rectangle-29 {
  background: #f7f7f9;
  width: 244px;
  height: 60px;
  position: absolute;
  left: 180px;
  top: 237px;
  font-size: medium;
}
.place-name {
  color: #999895;
  text-align: left;
  font-family: "Inter-Medium", sans-serif;
  font-size: 16px;
  line-height: 150%;
  font-weight: 500;
  position: absolute;
  left: 180px;
  top: 201px;
}
.rectangle-32 {
  background: #f7f7f9;
  width: 1100px;
  height: 544px;
  position: absolute;
  left: 180px;
  top: 371px;
  font-size: medium;
}
.content {
  color: #999895;
  text-align: left;
  font-family: "Inter-Medium", sans-serif;
  font-size: 16px;
  line-height: 150%;
  font-weight: 500;
  position: absolute;
  left: 180px;
  top: 318px;
}
/* .rectangle-23 {
  background: #f7f7f9;
  border-style: solid;
  border-color: #d9d9d9;
  border-width: 1px;
  width: 97px;
  height: 60px;
  position: absolute;
  left: 1402px;
  top: 237px;
} */
/* .polygon-5 {
  width: 24px;
  height: 18px;
  position: absolute;
  left: 1492.08px;
  top: 276px;
  transform: translate(-22.45px, -13.49px);
  overflow: visible;
}
.ellipse-2 {
  width: 33px;
  height: 33px;
  position: absolute;
  left: 1418px;
  top: 250px;
  overflow: visible;
} */

.rectangle-23 {
  background: #f7f7f9;
  border: 1px solid #d9d9d9;
  width: 100px;
  height: 35px;
  position: absolute;
  left: 1202px;
  top: 237px;
  padding: 5px;
  font-size: 14px;
  border-radius: 5px;
  cursor: pointer;
}

/* 드롭다운 컨테이너 */
.dropdown-container {
  width: 50px;
  height: 50px;
  border: 1px solid #d9d9d9;
  border-radius: 50%;
  position: absolute;
  left: 1066px;
  top: 237px;
  background: #ffffff;
  display: flex;
  align-items: center;
  justify-content: center;
  cursor: pointer;
  user-select: none;
}

/* 선택된 색상 표시 */
.selected-option {
  display: flex;
  align-items: center;
  justify-content: center;
}

/* 드롭다운 메뉴 */
.dropdown-menu {
  position: absolute;
  top: 60px;
  left: 0;
  background: white;
  border: 1px solid #d9d9d9;
  border-radius: 5px;
  padding: 5px 0;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
  list-style: none;
  margin: 0;
  padding: 0;
  z-index: 10;
}

/* 드롭다운 항목 */
.dropdown-menu li {
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 5px 0;
  cursor: pointer;
}

.dropdown-menu li:hover {
  background: #f0f0f0;
}

/* 색상 원 */
.color-circle {
  width: 25px;
  height: 25px;
  border-radius: 50%;
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

.rectangle-35 {
  background: #f7f7f9;
  border-style: solid;
  border-color: #d9d9d9;
  border-width: 1px;
  width: 97px;
  height: 60px;
  position: absolute;
  left: 1202px;
  top: 952px;
}
.rectangle-36 {
  background: #f7f7f9;
  border-style: solid;
  border-color: #d9d9d9;
  border-width: 1px;
  width: 97px;
  height: 60px;
  position: absolute;
  left: 1067px;
  top: 952px;
}
.save {
  color: #000000;
  text-align: left;
  font-family: "Stylish-Regular", sans-serif;
  font-size: 24px;
  font-weight: 400;
  position: absolute;
  left: 1095px;
  top: 967px;
}
.cancel {
  color: #000000;
  text-align: left;
  font-family: "Stylish-Regular", sans-serif;
  font-size: 24px;
  font-weight: 400;
  position: absolute;
  left: 1221px;
  top: 967px;
}

.rectangle-33 {
  background: #f7f7f9;
  border-style: solid;
  border-color: #f7f7f9;
  border-width: 0px 0px 1px 0px;
  width: 355px;
  height: 355px;
  position: absolute;
  left: 1365px;
  top: 89px;
}
.add-thumbnail {
  color: #55595c;
  text-align: left;
  font-family: "Inter-Medium", sans-serif;
  font-size: 16px;
  line-height: 150%;
  font-weight: 500;
  position: absolute;
  left: 1482px;
  top: 253px;
}
.rectangle-34 {
  background: #eceeef;
  width: 355px;
  height: 471px;
  position: absolute;
  left: 1365px;
  top: 444px;
}
.add-photos {
  color: #55595c;
  text-align: left;
  font-family: "Inter-Medium", sans-serif;
  font-size: 16px;
  line-height: 150%;
  font-weight: 500;
  position: absolute;
  left: 1487px;
  top: 721px;
}
.group-4 {
  position: absolute;
  inset: 0;
}
/* .rectangle-6 {
  background: #f7f7f7;
  border-style: solid;
  border-color: #ffffff;
  border-width: 0px 1px 0px 0px;
  width: 248.36px;
  height: 84.38px;
  position: absolute;
  left: 0px;
  top: 346px;
}
.my-categories {
  color: #000000;
  text-align: center;
  font-family: "Stylish-Regular", sans-serif;
  font-size: 25px;
  font-weight: 400;
  position: absolute;
  left: 34.45px;
  top: 494.65px;
  width: 215.55px;
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
  left: 14.76px;
  top: 419.77px;
  width: 233.27px;
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
  left: 14.76px;
  top: 335.39px;
  width: 233.27px;
  height: 104.41px;
  display: flex;
  align-items: center;
  justify-content: center;
  -webkit-text-stroke: 1px #ffffff;
} */
  /* Hover 상태 */
  button:hover {
    background-color: #f0f0f0;
  }


.rectangle-28 {
  background: rgba(255, 255, 255, 0);
  border-style: solid;
  border-color: #d9d9d9;
  border-width: 1px;
  width: 249.02px;
  height: 1080px;
  position: absolute;
  left: 0px;
  top: 0px;
}
</style>
