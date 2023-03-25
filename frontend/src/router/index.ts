import { createRouter, createWebHistory } from 'vue-router';
import HomeView from '../views/HomeView.vue';
import { useAuthStore } from '../stores/authStore';

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
  ],
});

router.beforeEach((to, from, next) => {
  const authStore = useAuthStore();
  const isAuthenticated = !!authStore.token;
  const protectedRoutes = [
    'sell',
    'bookmarks',
    'messages',
    'profile',
    'my-listings',
  ];

  if (protectedRoutes.includes(to.name) && !isAuthenticated) {
    // Redirect to the login or register page if the user is not authenticated
    next({ name: 'home' });
  } else {
    next();
  }
});

export default router;
