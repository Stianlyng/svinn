<template>
  <div>
    <CategoryList apiEndpoint="api/categories" />
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import CategoryList from '@/components/CategoryList.vue'


export default defineComponent({
  components: {
    CategoryList,
  },
});
</script>