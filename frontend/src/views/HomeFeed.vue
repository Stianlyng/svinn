<template>
  <div>
    <LocationForm />
    <ItemList apiEndpoint="api/v1/items" />
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import ItemList from '@/components/ItemList.vue'
import LocationForm from '@/components/LocationForm.vue'


export default defineComponent({
  components: {
    ItemList,
    LocationForm,
  },
});
</script>