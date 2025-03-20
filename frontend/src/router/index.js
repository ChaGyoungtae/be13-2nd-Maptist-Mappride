import { createRouter, createWebHistory } from 'vue-router';
import LoginComponent from "../components/LoginComponent.vue";
import MainComponent from "../components/MainComponent.vue";
import MyCategories from "../components/MyCategories.vue";
import MyPlaceComponent from "../components/MyPlaceComponent.vue";
import NewPlaceComponent from "../components/NewPlaceComponent.vue";
import MyPageComponent from "../components/MyPageComponent.vue";
import PlaceDetailComponent from "../components/PlaceDetailComponent.vue";

const routes = [
  { path: '/', component: LoginComponent },
  { path: '/main', component: MainComponent },
  { path: '/categories', component: MyCategories },
  { path: '/places', component: MyPlaceComponent },
  { path: '/new-place', component: NewPlaceComponent },
  { path: '/mypage', component: MyPageComponent },
  { path: '/place/:id', component: PlaceDetailComponent, props: true }
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router;
