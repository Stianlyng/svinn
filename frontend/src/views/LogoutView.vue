<template>
  <div></div>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import axiosInstance from '@/axiosInstance';

export default defineComponent({
  name: 'LogoutView',
  data() {
    return {};
  },
  async mounted() {
    const jwtToken = sessionStorage.getItem('jwtToken');
    console.log('jwtToken:', jwtToken);

    if (jwtToken) {
      try {
        await axiosInstance.post('api/auth/logout', {}, {
          headers: { Authorization: `Bearer ${jwtToken}` },
        });
      } catch (error) {
        console.error('Logout failed:', (error as Error).message);
      } finally {
        sessionStorage.removeItem('jwtToken');
        this.$router.replace({ name: 'login' });
      }
    }
  },
});
</script>