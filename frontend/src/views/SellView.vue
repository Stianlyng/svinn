<template>
  <div>
    <!-- Other content -->
    <CreateItem />
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import CreateItem from '@/components/CreateItem.vue';

export default defineComponent({
  components: {
    CreateItem,
  },
});
</script>