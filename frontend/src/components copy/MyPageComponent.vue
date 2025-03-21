<template>
  <div class="full">

    <input type="text" class="rectangle-29" value=""/>
    <div class="nickname">Nickname</div>
    <input type="text" class="rectangle-30" value=""/>
    <div class="email">Email</div>
    <input type="text" class="rectangle-33" value=""/>
    <div class="name">Name</div>
    <input type="text" class="rectangle-34" value=""/>
    <div class="birthday">Birthday</div>
    <input type="text" class="rectangle-31" value=""/>
    <div class="grade">Grade</div>
    <input type="text" class="rectangle-32" value=""/>
    <div class="user-type">User Type</div>
    
    <button>
      <img class="image-27" src="/src/assets/images/public/image-290.png" />
    </button>
    <button>
      <img class="image-30" src="/src/assets/images/public/image-290.png" />
    </button>

    <button>
      <div class="rectangle-49"></div>
      <div class="withdrawal">withdrawal</div>
    </button>

  </div>
</template>
<script>

</script>
<style scoped>
  .full,
  .full * {
    box-sizing: border-box;
  }
  .full {
    margin-top: -950px;
    margin-left: 300px;
    background: #ffffff;
    position: relative;
    overflow: hidden;
    height: 1080px;
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

  .rectangle-29 {
    background: #f7f7f9;
    width: 275px;
    height: 63px;
    position: absolute;
    left: 523px;
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
    left: 523px;
    top: 467px;
    width: 87px;
    height: 25px;
  }

  .rectangle-30 {
    background: #f7f7f9;
    width: 275px;
    height: 64px;
    position: absolute;
    left: 523px;
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
    left: 523px;
    top: 593px;
    width: 46px;
    height: 25px;
  }

  .rectangle-33 {
    background: #f7f7f9;
    width: 275px;
    height: 64px;
    position: absolute;
    left: 523px;
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
    left: 523px;
    top: 209px;
    width: 51px;
    height: 25px;
  }

  .rectangle-34 {
    background: #f7f7f9;
    width: 275px;
    height: 64px;
    position: absolute;
    left: 523px;
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
    left: 523px;
    top: 335px;
    width: 73px;
    height: 26px;
  }

  .rectangle-31 {
    background: #f7f7f9;
    width: 275px;
    height: 64px;
    position: absolute;
    left: 523px;
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
    left: 523px;
    top: 733px;
    width: 53px;
    height: 26px;
  }

  .rectangle-32 {
    background: #f7f7f9;
    width: 275px;
    height: 64px;
    position: absolute;
    left: 523px;
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
    left: 523px;
    top: 859px;
    width: 88px;
    height: 26px;
  }

  .image-27 {
    width: 37px;
    height: 37px;
    position: absolute;
    left: 857px;
    top: 387px;
    object-fit: cover;
    aspect-ratio: 1;
  }

  .image-30 {
    width: 37px;
    height: 37px;
    position: absolute;
    left: 857px;
    top: 510px;
    object-fit: cover;
    aspect-ratio: 1;
  }

  .rectangle-49 {
    background: #f7f7f7;
    width: 143px;
    height: 36px;
    position: absolute;
    left: 1710px;
    top: 1004px;
  }

  .withdrawal {
    color: #ff0000;
    text-align: left;
    font-family: "Inter-Regular", sans-serif;
    font-size: 20px;
    font-weight: 400;
    position: absolute;
    left: 1730px;
    top: 1009px;
    width: 155px;
    height: 31px;
  }
</style>
