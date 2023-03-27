<script setup lang="ts">
import { RouterLink, RouterView } from 'vue-router'


const isAuthenticated = sessionStorage.getItem("jwtToken");

const showAuthLinks = !isAuthenticated;
</script>

<template>
  <header>
        <a class="typing">echo "the most minimal marketplace"</a>
  </header>

    <nav>
      <RouterLink to="/">feed</RouterLink>
        <template  v-if="showAuthLinks">
          <RouterLink to="/register">register</RouterLink>
          <RouterLink to="/login">login</RouterLink>
        </template>
        <template  v-else="showAuthLinks">
          <RouterLink to="/sell">sell</RouterLink>
          <RouterLink to="/bookmarks">favs</RouterLink>
          <RouterLink to="/messages">chat</RouterLink>
          <RouterLink to="/my-listings">my stuff</RouterLink>
          <RouterLink to="/profile">profile</RouterLink>
          <RouterLink to="/logout">logout</RouterLink>
        </template>
    </nav>

    <section>
      <RouterView />
    </section>
</template>


<style scoped>

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

header {
	grid-area: header;
  height: 10em;
}

nav {
	grid-area: nav; 
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 1rem 2rem;
}

nav a {
  margin: 0 1rem;
  text-decoration: none;
  font-size: 1.2rem;
  font-weight: 400;
  transition: all 0.3s ease;
}

section {
	grid-area: section;    
}

aside {
	grid-area: aside; 
}

footer {
	grid-area: footer;
}

header, nav, section, aside, footer {
	padding: 5px;
}

</style>
