
<template>
  <div class="user-details-container">
    <div v-if="user">
      <h3>User Details</h3>
      <p><strong>ID:</strong> {{ user.id }}</p>
      <p><strong>First Name:</strong> {{ user.firstname }}</p>
      <p><strong>Last Name:</strong> {{ user.lastname }}</p>
      <p><strong>Email:</strong> {{ user.email }}</p>
      <p><strong>Role:</strong> {{ user.role }}</p>
    </div>
    <div v-else>
      <p>Loading user details...</p>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import axiosInstance from "@/axiosInstance";

export default defineComponent({
  data() {
    return {
      user: null as any,
    };
  },
  methods: {
    async fetchUserDetails() {
      try {
        const response = await axiosInstance.get('/api/user/me');
        this.user = response.data;
      } catch (error) {
        console.error("Error fetching user details:", error);
      }
    },
  },
  created() {
    this.fetchUserDetails();
  },
});
</script>
