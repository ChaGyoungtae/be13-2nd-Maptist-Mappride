// import { createRouter, createWebHistory } from 'vue-router';
// import LoginComponent from "../components/LoginComponent.vue";
// import MainComponent from "../components/MainComponent.vue";
// import MyCategories from "../components/MyCategories.vue";
// import MyPlaceComponent from "../components/MyPlaceComponent.vue";
// import NewPlaceComponent from "../components/NewPlaceComponent.vue";
// import MyPageComponent from "../components/MyPageComponent.vue";
// import PlaceDetailComponent from "../components/PlaceDetailComponent.vue";

// const routes = [
//   { path: '/', component: LoginComponent },
//   { path: '/main', component: MainComponent },
//   { path: '/categories', component: MyCategories },
//   { path: '/places', component: MyPlaceComponent },
//   { path: '/new-place', component: NewPlaceComponent },
//   { path: '/mypage', component: MyPageComponent },
//   { path: '/place/:id', component: PlaceDetailComponent, props: true }
// ];

import { createRouter, createWebHistory } from 'vue-router';

import BaseLayout from '@/components/common/BaseLayout.vue';

import LoginComponent from "../components/LoginComponent.vue";
import MainComponent from "../components/MainComponent.vue";
import MyPageComponent from "../components/MyPageComponent.vue";
import MyCategories from "../components/MyCategories.vue";
import MyPlaceComponent from "../components/MyPlaceComponent.vue";
import NewPlaceComponent from "../components/NewPlaceComponent.vue";
import PlaceDetailComponent from "../components/PlaceDetailComponent.vue";
import LoginSuccessComponent from '@/components/LoginSuccessComponent.vue';

const routes = [
  {
    path: '/api/v1/', name: 'BaseLayout',component: BaseLayout,
    children: 
    [
      { path: '', name: 'Login', component: LoginComponent },                                 // 알림, btnLogin,  txtSearch, btnSearch, dropbutton
      { path: 'main', name: 'Main', component: MainComponent },                               // 알림, btnLogout, txtSearch, btnSearch, dropbutton
      { path: 'mypage', name: 'Mypage', component: MyPageComponent },                         // 알림, btnLogout
      { path: 'categories', name: 'Categories', component: MyCategories },                    // 알림, btnLogout, txtSearch, btnSearch, txtName
      { path: 'places', name: 'Place', component: MyPlaceComponent },                         // 알림, btnLogout, txtSearch, btnSearch, txtName
      { path: 'new-place', name: 'NewPlace', component: NewPlaceComponent },                  // 알림, btnLogout
      { path: 'place/:id', name: 'PlaceById', component: PlaceDetailComponent, props: true },  // 알림, btnLogout
      { path: "auth/login-success", component: LoginSuccessComponent },                       // 로그인 성공 처리

    ]
  },  
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router;
