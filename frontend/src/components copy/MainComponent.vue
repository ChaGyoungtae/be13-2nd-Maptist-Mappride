<template>
  <div class="full">
    <div id="map"/>
  </div>
</template>
  
<script>
  export default {
    name: "MainComponent",
    components: {},
    props: {},
    data() {
      return {};
    },
    methods: {
      handleClick() {
        alert("클릭 이벤트 테스트"); // 클릭 이벤트 테스트
      }
    },
    mounted() {
      // 네이버 지도 API 로드
      const script = document.createElement("script");
      script.src = "https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=p5ju3wcg2n";
      script.async = true;
      script.defer = true;
      document.head.appendChild(script);
  
      script.onload = () => {
        // 네이버 지도 생성
        new window.naver.maps.Map("map", {
          center: new naver.maps.LatLng(37.5112, 127), // 한강 중심으로 하는 지도
          zoom: 13
        });
      };
    }
  };
</script>
  
<style scoped>
  .full,
  .full * {
    box-sizing: border-box;
  }
  .full {
    margin-top: -950px;
    margin-left: 350px;
    background: #ffffff;
    position: relative;
    overflow: hidden;
    height: 1080px;
  }

  #map {
    width: 1600px;
    height: 800px;
  }  
</style>
  