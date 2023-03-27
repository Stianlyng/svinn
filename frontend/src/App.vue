<script setup lang="ts">
import { RouterLink, RouterView } from 'vue-router'
import Heading from './components/Heading.vue'


const isAuthenticated = sessionStorage.getItem("jwtToken");

const showAuthLinks = !isAuthenticated;
</script>

<template>
  <header>

    <div class="wrapper">
        <a class="typing">Svinn - the most minimal marketplace...</a>

      <nav class="links">
        <template  v-if="showAuthLinks">
          <RouterLink to="/">feed</RouterLink>
          <RouterLink to="/sell">sell</RouterLink>
          <RouterLink to="/bookmarks">favs</RouterLink>
          <RouterLink to="/messages">chat</RouterLink>
          <RouterLink to="/my-listings">my stuff</RouterLink>
          <RouterLink to="/logout">logout</RouterLink>
        </template>
        
      </nav>
    </div>
  </header>

  <RouterView />
</template>


<style scoped>

.wrappper {
  width: 100vh;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0 2rem;
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

.links {
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 50%; /* adjust this value to your liking */
  margin: 0 auto; /* centers the block horizontally */
  padding-top: 4em;
  padding-bottom: 4em;
}

</style>
