
<template>
  <div>
    <h2>Create Item</h2>
    <form @submit.prevent="submitForm">
      <div>
        <label for="briefDescription">Brief Description:</label>
        <input v-model="briefDescription" type="text" id="briefDescription" required />
      </div>
      <div>
        <label for="fullDescription">Full Description:</label>
        <textarea v-model="fullDescription" id="fullDescription" required></textarea>
      </div>
      <div>
        <label for="price">Price:</label>
        <input v-model.number="price" type="number" id="price" required />
      </div>
      <button type="submit">Create Item</button>
    </form>
  </div>
</template>

<script lang="ts">
import { ref } from 'vue';
import axiosInstance from '../axiosInstance';

export default {
  setup() {
    const briefDescription = ref('');
    const fullDescription = ref('');
    const price = ref(0);

    const submitForm = async () => {
      try {
        const response = await axiosInstance.post('/api/v1/items', {
          briefDescription: briefDescription.value,
          fullDescription: fullDescription.value,
          price: price.value,
          // Add category_id, location_id, and user_id according to your app logic
          category_id: 1,
          location_id: 2,
          user_id: 3,
          createdAt: new Date().toISOString(),
          updatedAt: new Date().toISOString(),
        });

        console.log(response.data);
        alert('Item created successfully');
      } catch (error) {
        console.error(error);
        alert('Error creating item');
      }
    };

    return {
      briefDescription,
      fullDescription,
      price,
      submitForm,
    };
  },
};
</script>

<style scoped>
  /* Add any styles you want for the form */
</style>