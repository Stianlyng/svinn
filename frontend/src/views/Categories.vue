<template>
  <div>
    <CategoryList apiEndpoint="api/v1/categories" />
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