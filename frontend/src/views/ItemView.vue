<template>
  <div>
    <h1>Item Details</h1>
    <ul v-if="item">
      <li>Brief Description: {{ item.briefDescription }}</li>
      <li>Full Description: {{ item.fullDescription }}</li>
      <li>Price: {{ item.price }}</li>
      <li>Created At: {{ item.createdAt }}</li>
      <li>Updated At: {{ item.updatedAt }}</li>
      <li>Category: {{ item.category.name }}</li>
      <li>Location: {{ item.location.name }}</li>
      <li>User: {{ item.user.firstname }} {{ item.user.lastname }}</li>
    </ul>
    <p v-else>Loading...</p>
  </div>
</template>

<script lang="ts">
import axios from 'axios';
import { defineComponent } from 'vue';

export default defineComponent({
  data() {
    return {
      item: null as any,
    };
  },
  created() {
    this.fetchItem();
  },
  methods: {
    async fetchItem() {
      const itemId = this.$route.params.id;
      try {
        const response = await axios.get(`http://localhost:8080/api/v1/items/${itemId}`);
        this.item = response.data;
      } catch (error) {
        console.error('Error fetching item:', error);
      }
    },
  },
});
</script>