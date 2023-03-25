<template>
  <div class="register">
    <h1>Register</h1>
    <form @submit.prevent="register">
      <div>
        <label for="firstname">First Name:</label>
        <input type="text" id="firstname" v-model="firstname" required />
      </div>
      <div>
        <label for="lastname">Last Name:</label>
        <input type="text" id="lastname" v-model="lastname" required />
      </div>
      <div>
        <label for="email">Email:</label>
        <input type="email" id="email" v-model="email" required />
      </div>
      <div>
        <label for="password">Password:</label>
        <input type="password" id="password" v-model="password" required />
      </div>
      <button type="submit">Register</button>
    </form>
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
//import axios from "axios";
import axios from "@/axiosInstance";

export default defineComponent({
  name: "RegisterView",
  data() {
    return {
      firstname: "",
      lastname: "",
      email: "",
      password: "",
    };
  },
  methods: {
    async register() {
      try {
        const response = await axios.post("api/v1/auth/register", {
          firstname: this.firstname,
          lastname: this.lastname,
          email: this.email,
          password: this.password,
        });

        // Handle successful registration
        console.log("Registration successful:", response.data);

        // Store the JWT token in sessionStorage
        sessionStorage.setItem("jwtToken", response.data.token);

        // Redirect the user to the home page (or any other page)
        this.$router.push({ name: "home" });
      } catch (error) {
        // Handle registration errors (e.g., show an error message)
        console.error("Registration failed:", (error as Error).message);
      }
    },
  },
});
</script>

<style>
</style>