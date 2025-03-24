<template>
  <div class="full">
    <div id="map"/>
  </div>
</template>
  
<script setup>
  import { defineProps, onMounted, watch, ref } from 'vue';

  // 부모 컴포넌트로부터 전달된 주소를 받을 prop
  const props = defineProps({
    address: {
      type: String,
      default: ''
    }
  });

  // map 객체를 ref로 정의
  const map = ref(null);

  // 네이버 지도 API 로드 및 지도 생성
  onMounted(() => {
    const script = document.createElement("script");
    script.src = "https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=p5ju3wcg2n&submodules=geocoder";
    script.async = true;
    script.defer = true;
    document.head.appendChild(script);

    script.onload = () => {
      // 네이버 지도 생성
      map.value = new window.naver.maps.Map("map", {
        center: new window.naver.maps.LatLng(37.5112, 127), // 한강 중심으로 하는 지도
        zoom: 13
      });
    };
  });

  // watch로 address 값 변경을 감지하여 실시간으로 지도에 반영
  watch(() => props.address, (newAddress) => {
    if (newAddress && map.value) {
      searchAddressToCoordinate(newAddress, map.value);
    }
  });

  // 주소로 좌표를 찾고 지도의 중심을 해당 좌표로 이동하는 함수
  const searchAddressToCoordinate = (address, map) => {
    window.naver.maps.Service.geocode({
      query: encodeURIComponent(address) // 주소를 인코딩하여 전송
    }, function(status, response) {
      console.log(status);
      console.log(response);

      // API 호출 상태 확인
      if (status === window.naver.maps.Service.Status.ERROR) {
        alert('Something went wrong! Server error');
        return;
      }

      if (response.v2.meta.totalCount === 0) {
        alert('No results found for the address');
        return;
      }

      const item = response.v2.addresses[0];
      const point = new window.naver.maps.Point(item.x, item.y);

      // 지도 중심을 좌표로 이동
      map.setCenter(point);

      // 주소 정보 표시
      const infoWindow = new window.naver.maps.InfoWindow({
        content: [
          '<div style="padding:10px;min-width:200px;line-height:150%;">',
          `<h4 style="margin-top:5px;">검색 주소 : ${address}</h4><br />`,
          `[도로명 주소] ${item.roadAddress || ''}<br />`,
          `[지번 주소] ${item.jibunAddress || ''}<br />`,
          `[영문명 주소] ${item.englishAddress || ''}`,
          '</div>'
        ].join('\n')
      });
      infoWindow.open(map, point);
    });
  };
</script>
  
<style scoped>
  .full * {
    box-sizing: border-box;
  }
  .full {
    position: absolute;
    top: 95px;   
    left: 350px;
  }

  #map {
    width: 1550px;
    height: 990px;
  }  
</style>
  