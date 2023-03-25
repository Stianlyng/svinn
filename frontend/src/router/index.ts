import { createRouter, createWebHistory } from 'vue-router';
import HomeView from '../views/HomeView.vue';
import RegisterView from "../views/RegisterView.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView,
    },
    {
      path: '/sell',
      name: 'sell',
      component: () => import('../views/SellView.vue'),
    },
    {
      path: '/bookmarks',
      name: 'bookmarks',
      component: () => import('../views/BookmarksView.vue'),
    },
    {
      path: '/messages',
      name: 'messages',
      component: () => import('../views/MessageView.vue'),
    },
    {
      path: '/profile',
      name: 'profile',
      component: () => import('../views/ProfileView.vue'),
    },
    {
      path: '/my-listings',
      name: 'my-listings',
      component: () => import('../views/MyListingsView.vue'),
    },
    {
      path: '/register',
      name: 'register',
      component: RegisterView,
    },
  ],
});


export default router;
