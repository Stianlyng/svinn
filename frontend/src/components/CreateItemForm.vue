
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
      briefDesc: briefDescription.value,
      longDesc: fullDescription.value,
      price: price.value,
      categoryId: 1,
      locationId: 1
    }, {
      headers: {
        'Authorization': `Bearer ${localStorage.getItem('token')}`
      }
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