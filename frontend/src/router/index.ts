import { createRouter, createWebHistory } from "vue-router";
import HomeView from "../views/HomeView.vue";
import RegisterView from "../views/RegisterView.vue";
import LoginView from "../views/LoginView.vue";
import LogoutView from '../views/LogoutView.vue'; // Import the LogoutView component

//todo; hide/show routes based on auth
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    { path: "/", name: "home", component: HomeView, meta: { requiresAuth: false } },
    { path: "/sell", name: "sell", component: () => import("../views/SellView.vue"), meta: { requiresAuth: true } },
    { path: "/bookmarks", name: "bookmarks", component: () => import("../views/BookmarksView.vue"), meta: { requiresAuth: true } },
    { path: "/messages", name: "messages", component: () => import("../views/MessageView.vue"), meta: { requiresAuth: true } },
    { path: "/profile", name: "profile", component: () => import("../views/ProfileView.vue"), meta: { requiresAuth: true } },
    { path: "/my-listings", name: "my-listings", component: () => import("../views/MyListingsView.vue"), meta: { requiresAuth: true } },
    { path: "/register", name: "register", component: RegisterView },
    { path: "/login", name: "login", component: LoginView },
    { path: '/logout', name: 'logout', component: LogoutView }, // Add the LogoutView component here
  ],
});

// Navigation guard to check for authentication
router.beforeEach((to, from, next) => {
  const requiresAuth = to.matched.some((record) => record.meta.requiresAuth);
  const isAuthenticated = sessionStorage.getItem("jwtToken");

  if (requiresAuth && !isAuthenticated) {
    next({ name: "home" }); // Redirect to the Register view if not authenticated
  } else {
    next(); // Continue to the requested route
  }
});

export default router;