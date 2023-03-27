<template>
  <div class="items-container">
    <div class="card" v-for="item in items" :key="item['id']">
      <router-link class="img-holder" :to="{ name: 'item', params: { id: item['id'] } }">
        <img src="https://images.unsplash.com/photo-1494256997604-768d1f608cac?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTd8fGNhdHxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=600&q=60" alt="Placeholder Image">
      </router-link>
      <div class="card-body">
        <h5 class="card-title">
          <router-link :to="{ name: 'item', params: { id: item['id'] } }">
            ~ {{ item['briefDescription'] }}
          </router-link>
        </h5>
        <p class="card-text">{{ item['fullDescription'] }}</p>
        <p class="card-text">
          <strong>Price:</strong> {{ item['price'] }}
        </p>
        <p class="card-text">
          <strong>Location:</strong> {{ item['location']['name'] }}
        </p>
        <p class="card-text">
          <strong>Seller:</strong> {{ item['user']['firstname'] }} {{ item['user']['lastname'] }}
        </p>
        <p class="card-text">
        <template  v-if="isAuth">
          <button class="f-btn" @click="addToFavourites(item['id'])">Add to favourites</button>
        </template>
        </p>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import axiosInstance from "@/axiosInstance";

import { RouterLink, RouterView } from 'vue-router'

export default defineComponent({
  props: {
    apiEndpoint: {
      type: String,
      required: true,
    },
  },
  data() {
    const isAuthenticated = sessionStorage.getItem("jwtToken");
    const showAuthLinks = !!(isAuthenticated);
    return {
      items: [],
      isAuth: showAuthLinks,
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
    async addToFavourites(itemId: number) {
      try {
        await axiosInstance.post(`/api/bookmarks/${itemId}`);
        console.log("Item added to favourites!");
      } catch (error) {
        console.error("Error adding item to favourites:", error);
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
  display: grid;
  grid-template-columns: 1fr; 
  font-family: Source Code Pro, monospace;
  grid-gap: 1rem;
  padding: 1rem;
  margin: 0 auto;
}

.card {
  background-color: var(--color-background-soft);
  border-radius: 4px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  overflow: hidden;
  display: flex;
  flex-direction: row-reverse;
  align-items: stretch;
  height: 100%;
  border: 1px solid var(--color-border);
  height: 20em;
}

.card:hover {
  outline: 4px solid hsla(160, 100%, 37%, 1);
}
.card .img-holder {
  width: auto;
  height: 100%;
  max-width: 50%;
  object-fit: cover;
}

.card-body {
  padding: 1rem;
  flex-grow: 1;
  display: flex;
  flex-direction: column;
}

.card-title {
  font-size: 1.2rem;
  margin-bottom: 0.5rem;
}

.card-text {
  margin-bottom: 0.5rem;
}

.card-text strong {
  font-weight: 600;
}

.f-btn {
  background-color: transparent;
  border: 2px solid #006400; /* dark green */
  color: #006400;
  padding: 10px 20px;
  transition: background-color 0.2s ease-in-out, color 0.2s ease-in-out;
}

.f-btn:hover {
  background-color: #006400;
  color: #fff;
}
</style>



