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
      <ul class="listCard" v-for="item in items" :key="item.id">
        <li> Item Brief Description: {{ item.briefDescription }}</li>
        <li> Item Full Description: {{ item.fullDescription }}</li>
        <li> Item Price: {{ item.price }}</li>
        <li> Item Created At: {{ item.createdAt }}</li>
        <li> Item Updated At: {{ item.updatedAt }}</li>
        <li> Item Category: {{ item.category.name }}</li>
        <li> Item Location: {{ item.location.name }}</li>
        <li> Item User: {{ item.user.firstname }} {{ item.user.lastname }}</li>
        <li> Item User Email: {{ item.user.email }}</li>
        <li> Item User Role: {{ item.user.role }}</li>
        <li> Item User Enabled: {{ item.user.enabled }}</li>
        <li> Item User Username: {{ item.user.username }}</li>
        <li> Item User Authorities: {{ item.user.authorities }}</li>
        <li> Item User Account Non Expired: {{ item.user.accountNonExpired }}</li>
        <li> Item User Account Non Locked: {{ item.user.accountNonLocked }}</li>
        <li> Item User Credentials Non Expired: {{ item.user.credentialsNonExpired }}</li>
        <li> Item User Tokens: {{ item.user.tokens }}</li>
        <li> Item User Password: {{ item.user.password }}</li>
        <li> Item User ID: {{ item.user.id }}</li>
        <li> Item Location ID: {{ item.location.id }}</li>
        <li> Item Location Name: {{ item.location.name }}</li>
        <li> Item Location Latitude: {{ item.location.latitude }}</li>
        <li> Item Location Longitude: {{ item.location.longitude }}</li>
        <li> Item Category ID: {{ item.category.id }}</li>
        <li> Item Category Name: {{ item.category.name }}</li>
        <li> Item Category Description: {{ item.category.description }}</li>
        <li> Item ID: {{ item.id }}</li>
      </ul>
  </ListingItem>

</template>

<style scoped>
.listCard {
  padding: 20px;
  margin: 20px;
  border-radius: 5px;
  border: 1px solid #ccc;
}
</style>
