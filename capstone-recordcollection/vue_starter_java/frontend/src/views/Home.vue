<template>
  <div class="home">
    <div class="flex flex-wrap -mb-4">
  <div class="w-1/3 mb-4 bg-white-400 h-12"></div>
  <div class="w-1/3 mb-4 bg-white-500 h-60">
  
  </div>
  <div class="w-1/3 mb-4 bg-white-400 h-12"></div>
  <div class="w-1/3 mb-4 bg-white-500 h-65"></div>
  <div class="w-1/3 mb-4 bg-white-400 h-65">
    <h1 class="block text-black-700 text-lg font-bold mb-2">Home</h1>
    <p class="block text-black-700 text-lg font mb-2">Welcome! You are logged in as <b>{{user.sub}}</b>.</p>
    <div>
      <p class="block text-black-700 text-lg font mb-2">Use the tabs to search <b>Browse Records</b>, create <b>Playlists</b>, or view/modify your <b>Library</b>.</p>
    </div>
    <button @click="logout" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-full">Sign Out</button>
 
   
    
  </div>

  </div>
  <div class="w-2/5 mb-4 bg-white-500 h-70"></div>
  <div class="w-1/3 mb-4 bg-white-400 h-12"></div>
  <div class="w-1/3 mb-4 bg-white-500 h-12">
  
  </div>
  <div class="w-1/3 mb-4 bg-white-400 h-12">
  </div>
</div>
</template>

<script>
import auth from '@/auth.js'


export default {
  name: 'home',
  data() {
    return {
      user: auth.getUser(),
    }
    
  },
  methods: {
    logout() {
      auth.logout();
      this.$router.push('/login');
    }
  }
}
</script>
<style>
html{
  background-image: url("../img/bg.jpg");
  }
</style>