<template>
  <div class="register">
    <h1>Register</h1>
    <form @submit.prevent="register" class="item-form">
      <div class="input-group">
        <label for="firstname">First Name:</label>
        <input type="text" id="firstname" v-model="firstname" required />
      </div>
      <div class="input-group">
        <label for="lastname">Last Name:</label>
        <input type="text" id="lastname" v-model="lastname" required />
      </div>
      <div class="input-group">
        <label for="email">Email:</label>
        <input type="email" id="email" v-model="email" required />
      </div>
      <div class="input-group">
        <label for="password">Password:</label>
        <input type="password" id="password" v-model="password" required />
      </div>
      <button class="submit-btn" type="submit">Register</button>
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
        const response = await axios.post("api/auth/register", {
          firstname: this.firstname,
          lastname: this.lastname,
          email: this.email,
          password: this.password,
        });

        // Handle successful registration
        console.log("Registration successful:", response.data);

        // JWT token in sessionStorage
        sessionStorage.setItem("jwtToken", response.data.token);

        //this.$router.push({ name: "home" });
        window.location.href = "/";

      } catch (error) {
        // Handle registration errors (e.g., show an error message)
        console.error("Registration failed:", (error as Error).message);
      }
    },
  },
});
</script>

<style scoped>
  .register {
    display: flex;
    flex-direction: column;
    align-items: center;
    font-family: 'Roboto', sans-serif;
    max-width: 600px;
    margin: 0 auto;
  }

  h1 {
    margin-bottom: 20px;
  }

  .item-form {
    padding: 20px;
    border-radius: 5px;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    width: 100%;
  }

  .input-group {
    display: flex;
    flex-direction: column;
    margin-bottom: 15px;
  }

  label {
    font-size: 14px;
    font-weight: 500;
    margin-bottom: 5px;
  }

  input,
  textarea {
    font-size: 14px;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 3px;
    outline: none;
    resize: vertical;
  }

  input:focus,
  textarea:focus {
    border-color: #56a3eb;
  }

  .submit-btn {
    font-size: 16px;
    background-color: #56a3eb;
    color: #fff;
    border: none;
    border-radius: 3px;
    padding: 10px 20px;
    cursor: pointer;
    transition: all 0.3s ease;
  }

  .submit-btn:hover {
    background-color: #3f8ad8;
  }
</style>
