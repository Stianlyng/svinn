<template>
  <div class="login">
    <h1>Login</h1>
    <form @submit.prevent="login">
      <div>
        <label for="email">Email:</label>
        <input type="email" id="email" v-model="email" required />
      </div>
      <div>
        <label for="password">Password:</label>
        <input type="password" id="password" v-model="password" required />
      </div>
      <button type="submit">Login</button>
    </form>
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";

import axios from "@/axiosInstance";

export default defineComponent({
  name: "LoginView",
  data() {
    return {
      email: "",
      password: "",
    };
  },
  methods: {
    async login() {
      try {
        const response = await axios.post("api/auth/authenticate", {
          email: this.email,
          password: this.password,
        });

        console.log("Login successful:", response.data);
        sessionStorage.setItem("jwtToken", response.data.token);
        this.$router.push({ name: "home" });
      } catch (error) {
        console.error("Login failed:", (error as Error).message);
      }
    },
  },
});
</script>

<style>
</style>