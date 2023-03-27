<template>
  <div>
    <input
      type="text"
      class="search-input"
      v-model="searchTerm"
      @input="searchCategories"
      placeholder="Search categories"
    />
    <ul v-show="searchTerm" class="dropdown">
      <li v-for="category in filteredCategories" :key="category.id" @click="selectCategory(category)">
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
  description: string;
}

export default defineComponent({
  data() {
    return {
      categories: [] as Category[],
      filteredCategories: [] as Category[],
      searchTerm: "",
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
    searchCategories() {
      this.filteredCategories = this.categories.filter((category: Category) =>
        category.name.toLowerCase().includes(this.searchTerm.toLowerCase())
      );
    },
    selectCategory(category: Category) {
      this.searchTerm = category.name;
      this.filteredCategories = [];
      this.$emit("category-selected", category.id);
    },
  },
  created() {
    this.fetchCategories();
  },
});
</script>

<style scoped>
  /* ... */
</style>