<script setup lang="ts">
defineProps<{
  msg: string
}>()
</script>

<template>
  <div class="greetings">
      <div class="typing"> {{ msg }}</div>
      <div>asdasd</div>
  </div>  
</template>

<style scoped>
.greetings {
  display: flex;
  flex-direction: row;
  width: 100vh;
  text-align: left;
}

.typing {
  width: 39ch;
  animation: typing 2s steps(22), blink .5s step-end infinite alternate;
  white-space: nowrap;
  overflow: hidden;
  border-right: 3px solid;
  font-family: monospace;
  font-size: 1.2em;
}

@keyframes typing {
  from {
    width: 0
  }
}
    
@keyframes blink {
  50% {
    border-color: transparent
  }
}
</style>
