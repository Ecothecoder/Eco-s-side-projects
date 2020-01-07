<template>


<div class="flex flex-wrap -mb-4">
  <div class="w-1/3 mb-4 bg-white-400 h-12"></div>
  <div class="w-1/3 mb-4 bg-white-500 h-12"></div>
  <div class="w-1/3 mb-4 bg-white-400 h-12"></div>
  <div class="w-2/5 mb-4 bg-white-500 h-60"></div>
  <div class="w-1/5 mb-4 bg-white-400 h-60">
  
  <div id="register" class="text-center">
    <form class="form-register" @submit.prevent="register">
      <h1 class="block text-gray-700 text-lg font-bold mb-2">Create Account</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        There were problems registering this user.
      </div>
      <label for="username" class="block text-gray-700 text-sm font-bold mb-2">Username</label>
      <label for="username" class="sr-only">Username</label>
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
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <label for="password" class="block text-gray-700 text-sm font-bold mb-2">Confirm Password</label>
      <input
        type="password"
        id="confirmPassword"
        class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />
      <div id="todd"></div>
      <button class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-full" type="submit">
        Create Account
      </button>
      <div id="todd"></div>
      <router-link :to="{ name: 'login' }">
        <button class="bg-gray-500 hover:bg-gray-700 text-white font-bold py-2 px-4 rounded-full">
        Have an account?
        </button>
      </router-link>
      
      
    
    </form>
  </div>
  
  </div>
  <div class="w-2/5 mb-4 bg-white-500 h-60"></div>
  <div class="w-1/3 mb-4 bg-white-400 h-12"></div>
  <div class="w-1/3 mb-4 bg-white-500 h-12"></div>
  <div class="w-1/3 mb-4 bg-white-400 h-12"></div>
</div>

  
</template>

<script>
export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
    };
  },
  methods: {
    register() {
      fetch(`${process.env.VUE_APP_REMOTE_API}/register`, {
        method: 'POST',
        headers: {
          Accept: 'application/json',
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(this.user),
      })
        .then((response) => {
          if (response.ok) {
            return (response.json());
          } else {
            this.registrationErrors = true;
            throw 'Register returned: ' + response.status;
          }
        })
        .then ((parsedData) => {
            if (parsedData.success) {
              this.$router.push({ path: '/login', query: { registration: 'success' } });
            } else {
              this.registrationErrors = true;
            }
        })
        .catch((err) => console.log(err));
    },
  },
};
</script>

<style>
#todd {
  padding: 10px;
}
</style>
