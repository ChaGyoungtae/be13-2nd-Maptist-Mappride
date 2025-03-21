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

// import { createRouter, createWebHistory } from 'vue-router';

// import BaseLayout from '@/components copy/common/BaseLayout.vue';

// import LoginComponent from "../components copy/LoginComponent.vue";
// import MainComponent from "../components copy/MainComponent.vue";
// import MyPageComponent from "../components copy/MyPageComponent.vue";
// import MyCategories from "../components copy/MyCategories.vue";
// import MyPlaceComponent from "../components copy/MyPlaceComponent.vue";
// import NewPlaceComponent from "../components copy/NewPlaceComponent.vue";
// import PlaceDetailComponent from "../components copy/PlaceDetailComponent.vue";

// const routes = [
//   {
//     path: '/', name: 'BaseLayout',component: BaseLayout,
//     children: 
//     [
//       { path: 'main', name: 'Main', component: MainComponent },             // dropbutton, txtSearch, btnSearch, 알림, btnLogout
//       { path: 'mypage', name: 'Mypage', component: MyPageComponent },       //  알림, btnLogout
//       { path: 'categories', name: 'Categories', component: MyCategories },  // txtName, txtSearch, btnSearch, 알림, btnLogout
//       { path: 'places', name: 'Place', component: MyPlaceComponent },                     // txtName, txtSearch, btnSearch, 알림, btnLogout
//       { path: 'new-place', name: 'NewPlace', component: NewPlaceComponent },                 //  알림, btnLogout
//       { path: 'place/:id', name: 'PlaceById', component: PlaceDetailComponent, props: true }  //  알림, btnLogout
//     ]
//   },
//   { path: '/login', component: LoginComponent }, // dropbutton, txtSearch, btnSearch, 알림, btnLogout
// ];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router;
