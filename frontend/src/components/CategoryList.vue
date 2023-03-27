<template>
    <div class="card" v-for="item in categories" :key="item['id']">
      <div class="card-body">
        <h5 class="card-title">~ {{ item['name'] }}</h5>
      </div>
    </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import axiosInstance from "@/axiosInstance";

export default defineComponent({
  props: {
    apiEndpoint: {
      type: String,
      required: true,
    },
  },
  data() {
    return {
      categories: [],
    };
  },
  methods: {
    async fetchItems() {
      try {
        const response = await axiosInstance.get(this.apiEndpoint);
        this.categories = response.data;
      } catch (error) {
        console.error("Error fetching categories:", error);
      }
    },
  },
  created() {
    this.fetchItems();
  },
});
</script>