import { createRouter, createWebHistory } from "vue-router";
import HomeView from "../views/HomeView.vue";
import RegisterView from "../views/RegisterView.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    { path: "/", name: "home", component: HomeView, meta: { requiresAuth: true } },
    { path: "/sell", name: "sell", component: () => import("../views/SellView.vue"), meta: { requiresAuth: true } },
    { path: "/bookmarks", name: "bookmarks", component: () => import("../views/BookmarksView.vue"), meta: { requiresAuth: true } },
    { path: "/messages", name: "messages", component: () => import("../views/MessageView.vue"), meta: { requiresAuth: true } },
    { path: "/profile", name: "profile", component: () => import("../views/ProfileView.vue"), meta: { requiresAuth: true } },
    { path: "/my-listings", name: "my-listings", component: () => import("../views/MyListingsView.vue"), meta: { requiresAuth: true } },
    { path: "/register", name: "register", component: RegisterView },
  ],
});

// Navigation guard to check for authentication
router.beforeEach((to, from, next) => {
  const requiresAuth = to.matched.some((record) => record.meta.requiresAuth);
  const isAuthenticated = sessionStorage.getItem("jwtToken");

  if (requiresAuth && !isAuthenticated) {
    next({ name: "register" }); // Redirect to the Register view if not authenticated
  } else {
    next(); // Continue to the requested route
  }
});

export default router;