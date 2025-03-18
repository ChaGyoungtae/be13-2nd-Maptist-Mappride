<template>
  <div><newPlaceComponent/></div>
  <div><loginComponent/></div>
  <div><mainComponent/></div>
  <div><myCategories/></div>
  <div><myPlaceComponent/></div>
   <div><myPageComponent/></div>
    <div><placeDetailComponent/></div>
</template>

<script>
import NewPlaceComponent from "./components/NewPlaceComponent.vue";
import LoginComponent from "./components/LoginComponent.vue";
import MainComponent from "./components/MainComponent.vue";
import MyCategories from "./components/MyCategories.vue";
import MyPlaceComponent from "./components/MyPlaceComponent.vue";
import MyPageComponent from "./components/MyPageComponent.vue";
import PlaceDetailComponent from "./components/PlaceDetailComponent.vue";
import "./vars.css";
import "./styles.css";

export default {
  name: "App",
  components: {
    newPlaceComponent: NewPlaceComponent,
    loginComponent : LoginComponent,
    mainComponent: MainComponent,
    myCategories: MyCategories,
    myPlaceComponent: MyPlaceComponent,
    myPageComponent: MyPageComponent,
    placeDetailComponent: PlaceDetailComponent
  },
};
</script>

<style></style>
