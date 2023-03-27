<!--

<template>
  <form @submit.prevent="onSubmit">
    <label for="address">Enter Address:</label>
    <input type="text" id="address" v-model="address">
    <button type="submit">Submit</button>
  </form>
</template>

<script>
import axios from 'axios'; 

export default {
  data() {
    return {
      address: '', // The user's input for the address
    };
  },
  methods: {
    async onSubmit() {
      const response = await axios.get(`https://maps.googleapis.com/maps/api/geocode/json?address=${this.address}&key=YOUR_API_KEY_HERE`);
      const { lat, lng } = response.data.results[0].geometry.location; // Extract the latitude and longitude from the API response
      console.log(`Latitude: ${lat}, Longitude: ${lng}`);
    },
  },
};
</script>

-->

<template>
  <div>
    <button @click="getLocation">Get Location</button>
    <p v-if="latitude && longitude">
      Your current location is: {{ latitude }}, {{ longitude }}
    </p>
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";

export default defineComponent({
  data() {
    return {
      latitude: NaN,
      longitude: NaN,
    };
  },
  methods: {
    getLocation() {
      if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(
          position => {
            this.latitude = position.coords.latitude;
            this.longitude = position.coords.longitude;
          },
          error => {
            console.error(error);
          }
        );
      } else {
        console.error('Geolocation is not supported by this browser.');
      }
    },
  },
});
</script>