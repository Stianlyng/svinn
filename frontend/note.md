# Auth

## hide/show pages based on auth:

The guard first checks if the user is already authenticated and is trying to access the login page. If the user is already authenticated and trying to access the login page, then they will be redirected to the home page. Otherwise, the guard will continue with the regular authentication check and redirect the user to the Register view if they are not authenticated.

**router.js**

```js
router.beforeEach((to, from, next) => {
  const requiresAuth = to.matched.some((record) => record.meta.requiresAuth);
  const isAuthenticated = sessionStorage.getItem("jwtToken");

  if (isAuthenticated && to.name === "login") {
    next({ name: "home" }); // Redirect to the Home view if already authenticated
  } else if (requiresAuth && !isAuthenticated) {
    next({ name: "register" }); // Redirect to the Register view if not authenticated
  } else {
    next(); // Continue to the requested route
  }
});
```

