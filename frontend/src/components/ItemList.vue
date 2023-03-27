<!--

-->
<template>
  <div class="items-container">
    <div class="card" v-for="item in items" :key="item['id']">
      <img src="https://images.unsplash.com/photo-1494256997604-768d1f608cac?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTd8fGNhdHxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=600&q=60" alt="Placeholder Image">
      <div class="card-body">
        <h5 class="card-title">{{ item['briefDescription'] }}</h5>
        <p class="card-text">{{ item['fullDescription'] }}</p>
        <p class="card-text">
          <strong>Price:</strong> ${{ item['price'] }}
        </p>
        <p class="card-text">
          <strong>Category:</strong> {{ item['category']['name'] }}
        </p>
        <p class="card-text">
          <strong>Location:</strong> {{ item['location']['name'] }}
        </p>
        <p class="card-text">
          <strong>Seller:</strong> {{ item['user']['firstname'] }} {{ item['user']['lastname'] }}
        </p>
      </div>
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
      items: [],
    };
  },
  methods: {
    async fetchItems() {
      try {
        const response = await axiosInstance.get(this.apiEndpoint);
        this.items = response.data;
      } catch (error) {
        console.error("Error fetching items:", error);
      }
    },
  },
  created() {
    this.fetchItems();
  },
});
</script>

<style scoped>
.items-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}

.card {
  width: 300px;
  margin: 10px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  border: none;
}

.card-body {
  padding: 15px;
}
</style>


