<template>
<!--<template>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Document</title>
    <link href="https://unpkg.com/tailwindcss@^1.0/dist/tailwind.min.css" rel="stylesheet">
  </head>

  <body>
    <Header></Header>
    <nav class="flex items-center justify-between flex-wrap bg-teal-500 p-6">
      <div class="flex items-center flex-shrink-0 text-white mr-6">
        <img
          class="fill-current h-8 w-8 mr-2"
          width="58"
          height="58"
          viewBox="0 0 54 54"
          src="https://cdn.onlinewebfonts.com/svg/img_41198.png"
        />

     
        <span class="font-semibold text-xl tracking-tight">Record Collection</span>
      </div>
      <div class="block lg:hidden">
        <button
          class="flex items-center px-3 py-2 border rounded text-teal-200 border-teal-400 hover:text-white hover:border-white"
        >
          <svg class="fill-current h-3 w-3" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
            <title>Menu</title>
            <path d="M0 3h20v2H0V3zm0 6h20v2H0V9zm0 6h20v2H0v-2z" />
          </svg>
        </button>
      </div>
      <div class="w-full block flex-grow lg:flex lg:items-center lg:w-auto">
        <div class="text-sm lg:flex-grow">
          <a
            href="/about"
            class="block mt-4 lg:inline-block lg:mt-0 text-teal-200 hover:text-white mr-4"
          >Login</a>
          <a
            href="/register"
            class="block mt-4 lg:inline-block lg:mt-0 text-teal-200 hover:text-white mr-4"
          >Register</a>
          <a
            href="/"
            class="block mt-4 lg:inline-block lg:mt-0 text-teal-200 hover:text-white"
          >About</a>
        </div>
        <div>
          <a
            href="#"
            class="inline-block text-sm px-4 py-2 leading-none border rounded text-white border-white hover:border-transparent hover:text-teal-500 hover:bg-white mt-4 lg:mt-0"
          >
            Upgrade
            to Premium
          </a>
        </div>
      </div>
    </nav>
    <div class="flex flex-wrap -mb-4">
      <div class="w-1/3 mb-4 bg-white-400 h-12"></div>
      <div class="w-1/3 mb-4 bg-white-500 h-12 font-bold"></div>
      <div class="w-1/3 mb-4 bg-white-400 h-12"></div>
      <div class="w-1/3 mb-4 bg-white-500 h-80"></div>
      <div class="w-1/3 mb-4 bg-white-400 h-80">
        <div class="w-full max-w-xs">
          <form class="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4">
            <div class="mb-4">
              <label class="block text-gray-700 text-sm font-bold mb-2" for="username">Username</label>
              <input
                class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                id="username"
                type="text"
                placeholder="Username"
              />
            </div>
            <div class="mb-6">
              <label class="block text-gray-700 text-sm font-bold mb-2" for="password">Password</label>
              <input
                class="shadow appearance-none border border-red-500 rounded w-full py-2 px-3 text-gray-700 mb-3 leading-tight focus:outline-none focus:shadow-outline"
                id="password"
                type="password"
                placeholder="***************"
              />
              <p class="text-red-500 text-xs italic">Please choose a password.</p>
            </div>
            <div class="flex items-center justify-between">
              <button
                class="bg-teal-500 hover:bg-teal-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
                type="button"
              >Sign In</button>
              <a
                class="inline-block align-baseline font-bold text-sm text-teal-500 hover:text-teal-800"
                href="#"
              >Forgot Password?</a>
            </div>
          </form>
          <p
            class="text-center text-gray-500 text-xs"
          >&copy;2019 Ethan / Todd / Seth. All rights reserved.</p>
        </div>
      </div>
      <div class="w-1/3 mb-4 bg-white-500 h-80"></div>
      <div class="w-1/3 mb-4 bg-white-400 h-12"></div>
      <div class="w-1/3 mb-4 bg-white-500 h-12"></div>
      <div class="w-1/3 mb-4 bg-white-400 h-12"></div>
    </div>
  </body>
</html>
</template> -->
<div class="flex flex-wrap -mb-4">
  <div class="w-1/3 mb-4 bg-white-400 h-12"></div>
  <div class="w-1/3 mb-4 bg-white-500 h-12"></div>
  <div class="w-1/3 mb-4 bg-white-400 h-12"></div>
  <div class="w-2/5 mb-4 bg-white-500 h-70"></div>
  <div class="w-1/5 mb-4 bg-white-400 h-70">

  <div id="login" class="text-center">
    <form class="form-signin" @submit.prevent="login">
      <div class="block text-gray-700 text-lg font mb-2" role="alert" v-if="this.$route.query.registration">
        Thank you for registering.
      </div>
      <h1 class="block text-gray-700 text-lg font-bold mb-2">Please Sign In</h1>
      <div class="alert alert-danger" role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      
      <label for="username" class="block text-gray-700 text-sm font-bold mb-2">Username</label>
      <input
        type="text"
        id="username"
        class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="block text-gray-700 text-sm font-bold mb-2">Password</label>
      <input
        type="password"
        id="password"
        class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <div id="yes">
      <label for="password" class="block text-gray-700 text-sm font-bold mb-2"></label>
      </div>
      <div id="no" class="inline-flex">
      <button class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-full" type="submit">Sign in</button>
       </div>
       <router-link :to="{ name: 'register' }"><button id="1" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-full">Need an account?</button></router-link>
      
     
    </form>
  </div>
  </div>
  <div class="w-2/5 mb-4 bg-white-500 h-70"></div>
  <div class="w-1/3 mb-4 bg-white-400 h-12"></div>
  <div class="w-1/3 mb-4 bg-white-500 h-12"></div>
  <div class="w-1/3 mb-4 bg-white-400 h-12"></div>
</div>
</template>

<script>
import auth from '../auth';

export default {
  name: 'login',
  components: {},
  data() {
    return {
      user: {
        username: '',
        password: '',
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      fetch(`${process.env.VUE_APP_REMOTE_API}/login`, {
        method: 'POST',
        headers: {
          Accept: 'application/json',
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(this.user),
      })
        .then((response) => {
          if (response.ok) {
            return response.text();
          } else {
            this.invalidCredentials = true;
          }
        })
        .then((token) => {
          if (token != undefined) {
            if (token.includes('"')) {
              token = token.replace(/"/g, '');
            }
            auth.saveToken(token);
            this.$router.push('/');
          }
        })
        .catch((err) => console.error(err));
    }
  },
};
</script>

<style>
#no {
  padding-right: 20px;
}

#yes {
  padding: 10px;
}

button {
  padding: 100px;
}
</style>
