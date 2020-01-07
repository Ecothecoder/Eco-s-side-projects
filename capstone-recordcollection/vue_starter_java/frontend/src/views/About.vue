<template>
  <div id="sausage" class="flex flex-wrap -mb-4">
    <div class="w-1/3 mb-4 bg-white-400 h-12"></div>
    <div class="w-1/3 mb-4 bg-white-500 h-12"></div>
    <div class="w-1/3 mb-4 bg-white-400 h-12"></div>
    <div class="w-1/3 mb-4 bg-white-500 h-65"></div>
    <div class="w-1/3 mb-4 bg-white-400 h-65">
      <h1 class="block text-black-700 text-lg font-bold mb-2">About</h1>
      <p
        class="block text-black-700 text-lg font mb-2"
      >This application allows users to track their vinyl record library and create collections of records and share them with other users. Public API data is used to enhance the import and display of collection items.</p>
    </div>
    <div class="w-1/3 mb-4 bg-white-500 h-65"></div>
    <div class="w-1/3 mb-4 bg-white-400 h-12"></div>
    <div class="w-1/3 mb-4 bg-white-500 h-12">
      <router-link :to="{ name: 'register' }">
        <button
          class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-full"
        >Get Started!</button>
      </router-link>
    </div>
    <div class="w-1/3 mb-4 bg-white-400 h-12"></div>
  </div>
</template>

<script>
export default {};
</script>

<style>

</style>