<template>
  <div class="create-item">
    <h1>Create Item</h1>
    <form @submit.prevent="createItem">
      <div>
        <label for="briefDescription">Brief Description:</label>
        <input type="text" id="briefDescription" v-model="briefDescription" required />
      </div>
      <div>
        <label for="fullDescription">Full Description:</label>
        <textarea id="fullDescription" v-model="fullDescription" required></textarea>
      </div>
      <div>
        <label for="price">Price:</label>
        <input type="number" step="0.01" id="price" v-model="price" required />
      </div>
      <div>
        <label for="category">Category:</label>
        <input type="number" step="1" id="category" v-model="categoryId" required />
      </div>
      <button type="submit">Create Item</button>
    </form>
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import axiosInstance from "@/axiosInstance";

export default defineComponent({
  components: {
  //  CategoryDropdown,
  },
  data() {
    return {
      briefDescription: "",
      fullDescription: "",
      price: 0,
      categoryId: 0,
    };
  },
  methods: {
    setCategoryId(categoryId: number) {
      this.categoryId = categoryId;
    },
    async createItem() {
      try {
        await axiosInstance.post("api/v1/items", {
          briefDescription: this.briefDescription,
          fullDescription: this.fullDescription,
          price: this.price,
          categoryId: this.categoryId,
          locationId: 1,
        });
        // Redirect or show success message after creating the item
      } catch (error) {
        console.error("Error creating item:", error);
      }
    },
  },
});
</script>
