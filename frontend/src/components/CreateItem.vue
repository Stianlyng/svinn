<template>
  <div class="create-item">
    <h1>Create Item</h1>
    <form @submit.prevent="createItem" class="item-form">
      <div class="input-group">
        <label for="briefDescription">Brief Description:</label>
        <input type="text" id="briefDescription" v-model="briefDescription" required />
      </div>
      <div class="input-group">
        <label for="fullDescription">Full Description:</label>
        <textarea id="fullDescription" v-model="fullDescription" required></textarea>
      </div>
      <div class="input-group">
        <label for="price">Price:</label>
        <input type="number" step="0.01" id="price" v-model="price" required />
      </div>
      <div class="input-group">
        <label for="category">Category:</label>
        <!-- <input type="number" step="1" id="category" v-model="categoryId" required /> -->
        <CategoryDropdown @category-selected="setCategoryId" />
      </div>
      <button type="submit" class="submit-btn">Create Item</button>
    </form>
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import axiosInstance from "@/axiosInstance";
import CategoryDropdown from "@/components/elements/CategoryDropdown.vue";
import { useRouter } from "vue-router";
import router from "@/router";

export default defineComponent({
  components: {
  CategoryDropdown,
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
        console.log("Item created successfully!")
        console.log(this.categoryId)
        router.push("/")
      } catch (error) {
        console.error("Error creating item:", error);
      }
    },
  },
});
</script>

<style scoped>
  .create-item {
    display: flex;
    flex-direction: column;
    align-items: center;
    font-family: 'Roboto', sans-serif;
    max-width: 600px;
    margin: 0 auto;
  }

  h1 {
    color: #333;
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

