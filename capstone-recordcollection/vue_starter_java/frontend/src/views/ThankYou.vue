<template>
    <div class="flex flex-wrap -mb-4">
  <div class="w-1/3 mb-4 bg-white-400 h-12"></div>
  <div class="w-1/3 mb-4 bg-white-500 h-12"></div>
  <div class="w-1/3 mb-4 bg-white-400 h-12"></div>
  <div class="w-1/3 mb-4 bg-white-500 h-65"></div>
  <div class="w-1/3 mb-4 bg-white-400 h-65">
  <h1 class="block text-black-700 text-lg font-bold mb-2">
      Thank You!
  </h1>
  <p class="block text-black-700 text-lg font mb-2">
  Enjoy your upgrade to Premium. Sign out to see your upgrades.
  </p>
  </div>
  <div class="w-1/3 mb-4 bg-white-500 h-65"></div>
  <div class="w-1/3 mb-4 bg-white-400 h-12"></div>
  <div class="w-1/3 mb-4 bg-white-500 h-12">
  <router-link :to="{ name: 'home' }"><button class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-full">
  Go To Home
</button></router-link>
  </div>
  <div class="w-1/3 mb-4 bg-white-400 h-12"></div>
</div>
</template>

<script>
export default {

}
</script>

<style>

</style>