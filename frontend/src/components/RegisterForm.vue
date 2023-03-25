<template>
  <form @submit.prevent="register">
    <div>
      <label for="firstname">First Name:</label>
      <input type="text" id="firstname" v-model="user.firstname" required />
    </div>
    <div>
      <label for="lastname">Last Name:</label>
      <input type="text" id="lastname" v-model="user.lastname" required />
    </div>
    <div>
      <label for="email">Email:</label>
      <input type="email" id="email" v-model="user.email" required />
    </div>
    <div>
      <label for="password">Password:</label>
      <input type="password" id="password" v-model="user.password" required />
    </div>
    <button type="submit">Register</button>
  </form>
</template>

<script lang="ts">
import { defineComponent, reactive } from 'vue';
import axios from 'axios';
import { useAuthStore } from '../stores/authStore';

export default defineComponent({
  setup() {
    const user = reactive({
      firstname: '',
      lastname: '',
      email: '',
      password: '',
    });

    const authStore = useAuthStore();

    async function register() {
      try {
        const response = await axios.post('http://localhost:8080/api/v1/auth/register', user);
        console.log('Registration successful. JWT token:', response.data);

        // Store JWT token for future use
        authStore.setToken(response.data);

        // Redirect user to a protected route
        // router.push({ name: 'dashboard' });
      } catch (error) {
        if (error.response) {
          console.error('Registration failed:', error.response.data);
        } else {
          console.error('Registration failed:', error.message);
        }
      }
    }

    return { user, register };
  },
});
</script>

