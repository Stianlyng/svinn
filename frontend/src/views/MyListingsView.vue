<template>
  <div>
    <ItemList apiEndpoint="api/items/user" />
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import ItemList from '@/components/ItemList.vue'

export default defineComponent({
  components: {
    ItemList,
  },
});
</script>