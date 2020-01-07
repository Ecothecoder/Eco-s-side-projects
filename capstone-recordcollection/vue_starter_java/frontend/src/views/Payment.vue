<template>
  <div class="flex flex-wrap -mb-4">
    <div class="w-1/3 mb-4 bg-white-400 h-12"></div>
    <div class="w-1/3 mb-4 bg-white-500 h-12"></div>
    <div class="w-1/3 mb-4 bg-white-400 h-12"></div>
    <div class="w-1/3 mb-4 bg-white-400 h-30"></div>
    <div class="w-1/3 mb-4 bg-white-500 h-30">
      <h1 class="block text-gray-700 text-lg font-bold mb-2">Why Premium?</h1>
      <p
        class="block text-gray-700 text-lg font mb-2"
      >As a premium user, your screen will show Willem Defoe. Always.</p>
      <p class="block text-gray-700 text-lg font mb-2">
        Only
        <b style="color: green;">$24.99</b>.
      </p>
    </div>
    <div class="w-1/3 mb-4 bg-white-400 h-30"></div>
    <div class="w-1/4 mb-4 bg-white-500 h-70"></div>
    <div class="w-1/2 mb-4 bg-white-400 h-70">
      <div class="bg-white my-4 shadow p-8 rounded-lg">
        <div class="flex items-center mb-4">
          <div class="border-2 border-blue px-3 py-2 rounded-full font-bold text-blue mr-2">1</div>
          <h2 class="text-lg">Your Payment Information</h2>
        </div>

        <div class="w-full">
          <label for="payment" class="block text-sm mb-2">Credit Card</label>
          <div class="flex">
            <input
              type="text"
              id="payment"
              class="w-5/6 flex-1 text-sm bg-grey-light text-grey-darkest rounded-l p-3 focus:outline-none"
              placeholder="Card Number"
            />
            <input
              type="text"
              id="payment"
              class="w-1/6 inline-block text-sm bg-grey-light text-grey-darkest p-3 focus:outline-none"
              placeholder="MM / YY"
            />
            <input
              type="text"
              id="payment"
              class="w-1/6 inline-block text-sm bg-grey-light text-grey-darkest rounded-r p-3 focus:outline-none"
              placeholder="CVC"
            />
          </div>
        </div>
          <button @click="upgradeUser()"
            class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-full"
          >Sign Up!</button>
      </div>
    </div>
  </div>
</template>

<script>
import auth from "@/auth.js";

export default {
  data() {
    return {
      user: auth.getUser(),
    }
  },
  methods:{
    upgradeUser(){
        fetch(process.env.VUE_APP_REMOTE_API + "/api/userPremium", {
        headers: {
          Authorization: "Bearer " + auth.getToken(),
          "Content-Type": "application/json",
          Accept: "application/json"
        },
        method: "PUT"
      }).then(() => this.$router.push("/thankYou"));
    },
    }
  }
</script>

<style>
</style>