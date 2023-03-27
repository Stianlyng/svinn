<template>
  <div class="category-list">
    <h2>Categories</h2>
    <ul>
      <li v-for="category in categories" :key="category.id">
        {{ category.name }}
      </li>
    </ul>
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import axiosInstance from "@/axiosInstance";

interface Category {
  id: number;
  name: string;
}

export default defineComponent({
  props: {
    apiEndpoint: {
      type: String,
      required: true,
    },
  },
  data() {
    return {
      categories: [] as Category[],
    };
  },
  methods: {
    async fetchCategories() {
      try {
        const response = await axiosInstance.get("api/v1/categories");
        this.categories = response.data;
      } catch (error) {
        console.error("Error fetching categories:", error);
      }
    },
  },
  created() {
    this.fetchCategories();
  },
});
</script>

<style scoped>
.category-list {
  max-width: 600px;
  margin: 0 auto;
}

ul {
  list-style-type: none;
  padding: 0;
  margin: 0;
}

li {
  margin-bottom: 10px;
}
</style>