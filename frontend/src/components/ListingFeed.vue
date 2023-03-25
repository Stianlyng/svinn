<script setup lang="ts">
import { ref, onMounted } from 'vue';
import ListingItem from './ListingItem.vue'
import axios from 'axios'

interface Category {
  id: number;
  name: string;
  description: string;
}

interface Location {
  id: number;
  name: string;
  latitude: number;
  longitude: number;
}

interface User {
  id: number;
  firstname: string;
  lastname: string;
  email: string;
  password: string;
  role: string;
  tokens: any[];
  enabled: boolean;
  username: string;
  authorities: { authority: string }[];
  accountNonExpired: boolean;
  accountNonLocked: boolean;
  credentialsNonExpired: boolean;
}

interface Item {
  id: number;
  briefDescription: string;
  fullDescription: string;
  price: number;
  createdAt: string;
  updatedAt: string;
  category: Category;
  location: Location;
  user: User;
}

const items = ref<Item[]>([]);

onMounted(async () => {
  try {
    const response = await axios.get('http://localhost:8080/api/v1/items');
    items.value = response.data;
  } catch (error) {
    console.error('Error fetching items:', error);
  }
});
</script>

<template>

  <ListingItem>
      <div v-for="item in items" :key="item.id">
        <h2>{{ item.briefDescription }}</h2>
        <h4>{{ item.price }} kr - {{ item.location.name }}</h4>
        <p>{{ item.fullDescription }}</p>
      </div>
  </ListingItem>

</template>

