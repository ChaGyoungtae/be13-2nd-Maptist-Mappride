<template>
  <div class="full">
    <input type="text" class="txtName" v-model="member.name"/>
    <div class="name">Name</div>
    <input type="text" class="txtBirthDay" v-model="member.birthday"  placeholder="YYYY-MM-DD" />
    <div class="birthday">Birthday</div>
    <input type="text" class="txtNickname" v-model="member.nickname"/>
    <div class="nickname">Nickname</div>
    <input type="text" class="txtEmail" v-model="member.email"/>
    <div class="email">Email</div>
    <input type="text" class="txtGrade" v-model="member.gradeName"/>
    <div class="grade">Grade</div>
    <input type="text" class="txtUserType" v-model="member.userRole"/>
    <div class="user-type">User Type</div>


    <button @click="handleUpdate1">
      <img class="image-27" src="/src/assets/images/public/image-290.png" />
    </button>
    <button @click="handleUpdate2">
      <img class="image-30" src="/src/assets/images/public/image-290.png" />
    </button>

    <button @click="handleDelete" class="btnWithDrawal">withdrawal</button>

  </div>
</template>
<script setup>
  import apiClient from '@/api/axios.js';
  import { ref, onMounted } from 'vue';
  import router from '@/router/index.js';

  const member = ref({});

  onMounted(() => {
    apiClient.get('/members').then(response => {
      member.value = response.data;
    }).catch(error => {
      console.error("에러 발생:", error);
      router.push('');
    });
  });


  const handleDelete = async() => {
    try {
      await apiClient.delete('/members');
      alert('withdrawal success!');
      router.push({name:"Login"});
    } catch(error) {
      console.error('withdrawal failed!', error);
      alert("withdrawal failed!");
    }
  }
  const handleUpdate1 = async() => {
      try {await apiClient.put(`/members/update/birthday`, `"${member.value.birthday}"`, {
        headers: {
          'Content-Type': 'application/json',
        },
      })
      alert('update success!');
      console.log("new birthday",member.value.birthday);
      }
      catch (error) {
        console.error("update failed!", error);
      }
    }
    const handleUpdate2 = async() => {
      try {await apiClient.put(`/members/update/nickname`, member.value.nickname, {
        headers:{
          'Content-Type': 'text/plain',
        },
      })
      alert('update success!');
      console.log("new nickname", member.value.nickname);
      }
      catch (error) {
        console.error("update failed!", error);
      }
    }
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

  button {
    display: flex;
    align-items: center;
    justify-content: center;
    border: none;
    background: none;
    cursor: pointer;
  }

  button:active * {
    filter: brightness(0.95); /* 클릭 시 이미지 어둡게 */
  }

  .txtName {
    background: #f7f7f9;
    width: 275px;
    height: 64px;
    position: absolute;
    left: 400px;
    top: 245px;
  }

  .name {
    color: #999895;
    text-align: left;
    font-family: "Inter-Medium", sans-serif;
    font-size: 16px;
    line-height: 150%;
    font-weight: 500;
    position: absolute;
    left: 400px;
    top: 209px;
    width: 51px;
    height: 25px;
  }

  
  .txtBirthDay {
    background: #f7f7f9;
    width: 275px;
    height: 64px;
    position: absolute;
    left: 400px;
    top: 371px;
  }

  .birthday {
    color: #999895;
    text-align: left;
    font-family: "Inter-Medium", sans-serif;
    font-size: 16px;
    line-height: 150%;
    font-weight: 500;
    position: absolute;
    left: 400px;
    top: 335px;
    width: 73px;
    height: 26px;
  }

  .txtNickname {
    background: #f7f7f9;
    width: 275px;
    height: 63px;
    position: absolute;
    left: 400px;
    top: 503px;
  }

  .nickname {
    color: #999895;
    text-align: left;
    font-family: "Inter-Medium", sans-serif;
    font-size: 16px;
    line-height: 150%;
    font-weight: 500;
    position: absolute;
    left: 400px;
    top: 467px;
    width: 87px;
    height: 25px;
  }

  .txtEmail {
    background: #f7f7f9;
    width: 275px;
    height: 64px;
    position: absolute;
    left: 400px;
    top: 629px;
  }

  .email {
    color: #999895;
    text-align: left;
    font-family: "Inter-Medium", sans-serif;
    font-size: 16px;
    line-height: 150%;
    font-weight: 500;
    position: absolute;
    left: 400px;
    top: 593px;
    width: 46px;
    height: 25px;
  }

  .txtGrade {
    background: #f7f7f9;
    width: 275px;
    height: 64px;
    position: absolute;
    left: 400px;
    top: 769px;
  }

  .grade {
    color: #999895;
    text-align: left;
    font-family: "Inter-Medium", sans-serif;
    font-size: 16px;
    line-height: 150%;
    font-weight: 500;
    position: absolute;
    left: 400px;
    top: 733px;
    width: 53px;
    height: 26px;
  }

  .txtUserType {
    background: #f7f7f9;
    width: 275px;
    height: 64px;
    position: absolute;
    left: 400px;
    top: 895px;
  }

  .user-type {
    color: #999895;
    text-align: left;
    font-family: "Inter-Medium", sans-serif;
    font-size: 16px;
    line-height: 150%;
    font-weight: 500;
    position: absolute;
    left: 400px;
    top: 859px;
    width: 88px;
    height: 26px;
  }

  .image-27 {
    width: 37px;
    height: 37px;
    position: absolute;
    left: 730px;
    top: 387px;
    object-fit: cover;
    aspect-ratio: 1;
  }

  .image-30 {
    width: 37px;
    height: 37px;
    position: absolute;
    left: 730px;
    top: 510px;
    object-fit: cover;
    aspect-ratio: 1;
  }

  .btnWithDrawal {
    color: #ff0000;
    text-align: center;
    font-family: "Inter-Regular", sans-serif;
    font-size: 20px;
    font-weight: 400;
    position: absolute;
    left: 1500px;
    top: 1009px;
    width: 155px;
    height: 40px;
    border: 2px solid #f7f7f7;
  }

  .btnWithDrawal:hover {
  background-color: #ff0000; /* 마우스 오버 시 배경 빨간색 */
  color: white; /* 마우스 오버 시 텍스트 흰색 */
  }
</style>
