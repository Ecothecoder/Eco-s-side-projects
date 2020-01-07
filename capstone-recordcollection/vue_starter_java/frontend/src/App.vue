<template>
<div id="app">
  <div id="nav">
    <head>
      <meta charset="UTF-8" />
      <meta name="viewport" content="width=device-width, initial-scale=1.0" />
      <meta http-equiv="X-UA-Compatible" content="ie=edge" />
      <title>Document</title>
      <link href="https://unpkg.com/tailwindcss@^1.0/dist/tailwind.min.css" rel="stylesheet" />
    </head>
    <!--
    <div     
      class="flex items-center justify-between flex-wrap bg-white-500 p-10"
    >
      <Slide right width="300" style="white">
        <div class>
          <span>
            <a href="/about" class>About</a>
          </span>
        </div>
        <div>
          <span>
            <a href="/register" class>Register</a>
          </span>
        </div>
        <div>
          <span>
            <a href="/" class>Login</a>
          </span>
        </div>
        <div>
          <span>
            <a href="/allRecords" class>Browse Records</a>
          </span>
        </div>
        <div>
          <span>
            <a href="/allPlaylists" class>Playlists</a>
          </span>
        </div>
        <div>
          <span>
            <a href="/library" class>Library</a>
          </span>
        </div>

        <div>
          <span>
            <a href="/payment" class>
              Upgrade
              to Premium
            </a>
          </span>
        </div>
        <div></div>
        <div></div>
        <div>
          <span>
            <a href="/" class>{{loggedIn()}}</a>
          </span>
        </div>
      </Slide>
    </div>
    -->
    <nav class="flex items-center justify-between flex-wrap bg-indigo-600 p-6">
      <div class="flex items-center flex-shrink-0 text-white mr-6">
        <router-link :to="{ name: 'home' }">
          <img v-if="!defoe"
            class="fill-current h-8 w-8 mr-2"
            width="58"
            height="58"
            viewBox="0 0 54 54"
            src="./img/img_41198.png"
          />
          <img v-if="defoe"
            class="fill-current h-8 w-8 mr-2"
            width="58"
            height="58"
            viewBox="0 0 54 54"
            src="./img/Williem.png"
          />
        </router-link>
        <router-link :to="{ name: 'home' }">
          <span class="font-semibold text-xl tracking-tight">Record Collection</span>
        </router-link>
      </div>

      <div class="w-full block flex-grow lg:flex lg:items-center lg:w-auto">
        <div class="text-sm lg:flex-grow">
          <a
            href="/about"
            class="block mt-4 lg:inline-block lg:mt-0 text-blue-200 hover:text-white mr-4"
          >About</a>
          <a
            href="/register"
            class="block mt-4 lg:inline-block lg:mt-0 text-blue-200 hover:text-white mr-4"
          >Register</a>
          <a
            href="/"
            class="block mt-4 lg:inline-block lg:mt-0 text-blue-200 hover:text-white mr-4"
          >Login</a>
          <a
            href="/allRecords"
            class="block mt-4 lg:inline-block lg:mt-0 text-blue-200 hover:text-white mr-4"
          >Browse Records</a>
          <a
            href="/allPlaylists"
            class="block mt-4 lg:inline-block lg:mt-0 text-blue-200 hover:text-white mr-4"
          >Playlists</a>
          <a
            href="/library"
            class="block mt-4 lg:inline-block lg:mt-0 text-blue-200 hover:text-white"
          >Library</a>
        </div>
        <div>
          <a
            href="/"
            class="block mt-4 lg:inline-block lg:mt-0 text-blue-200 hover:text-white mr-4"
          >{{loggedIn()}}</a>
        </div>
        <div >
          <!--<img class="lg:inline-block lg:mt-0 text-blue-200 hover:text-white" v-if="defoe" style="max-width:5%;" src="@/img/Williem.png"/>-->
          <p class="block mt-4 lg:inline-block lg:mt-0 text-blue-200" v-if="defoe"><b>You are Premium.</b></p>
          <a v-if="williem"
            href="/payment"
            class="inline-block text-sm px-4 py-2 leading-none border rounded text-white border-white hover:border-transparent hover:text-blue-500 hover:bg-white mt-4 lg:mt-0"
          >
            Upgrade
            to Premium
          </a>
        </div>
        <div></div>
      </div>
    </nav>
  </div>

  <router-view />
</div>
</template>

<script>
import auth from "@/auth.js";
//import { Slide } from "vue-burger-menu";

export default {
  // components: {
  //   Slide // Register your component
  // },
  data() {
    return {
      user: auth.getUser(),
      kyle: true,
      williem: false,
      defoe: false
    };
  },
  methods: {
    loggedIn() {
      if (!this.user) {
        return "Sign In";
      } else {
        return "Logged in as " + this.user.sub;
      }
    }
  },
  created(){
    if (!this.user){
      this.williem = false;
      this.defoe = false;
    }
    else if (this.user.rol == 'premium'){
      this.defoe = true;
    }
    else {
      this.williem = true;
    }
  }
};
</script>

<style scoped>
.bm-burger-button {
  position: fixed;
  width: 36px;
  height: 30px;
  left: 36px;
  top: 36px;
  cursor: pointer;
}
.bm-burger-bars {
  background-color: white;
}
.line-style {
  position: absolute;
  height: 20%;
  left: 0;
  right: 0;
}
.cross-style {
  position: absolute;
  top: 12px;
  right: 2px;
  cursor: pointer;
}
.bm-cross {
  background: #4298e1;
}
.bm-cross-button {
  height: 24px;
  width: 24px;
}
.bm-menu {
  height: 100%; /* 100% Full-height */
  width: 0; /* 0 width - change this with JavaScript */
  position: fixed; /* Stay in place */
  z-index: 1000; /* Stay on top */
  top: 0;
  left: 0;
  background-color: #4298e1; /* Black*/
  overflow-x: hidden; /* Disable horizontal scroll */
  padding-top: 60px; /* Place content 60px from the top */
  transition: 0.5s; /*0.5 second transition effect to slide in the sidenav*/
}

.bm-overlay {
  background: rgba(0, 0, 0, 0.3);
}
.bm-item-list {
  color: #4298e1;
  margin-left: 10%;
  font-size: 20px;
}
.bm-item-list > * {
  display: flex;
  text-decoration: none;
  padding: 0.7em;
}
.bm-item-list > * > span {
  margin-left: 10px;
  font-weight: 700;
  color: white;
}
.bm-burger-bars.line-style {
  background-color: blue !important;
}
</style>