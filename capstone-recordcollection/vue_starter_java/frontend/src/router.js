import Vue from 'vue'
import Router from 'vue-router'
import auth from './auth'
import Home from './views/Home.vue'
import Login from './views/Login.vue'
import Register from './views/Register.vue'
import Payment from './views/Payment.vue'
import About from './views/About.vue'
import Record from './views/Record.vue'
import AllRecords from './views/AllRecords.vue'
import Library from './views/Library.vue'
import Playlist from './views/Playlist.vue'
import ThankYou from './views/ThankYou.vue'
import AllPlaylists from './views/AllPlaylists.vue'

Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/payment",
      name: "payment",
      component: Payment,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/about",
      name: "about",
      component: About,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/record/:id",
      name: "record",
      component: Record,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/allRecords",
      name: "allRecords",
      component: AllRecords,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/library",
      name: "library",
      component: Library,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/playlist/:id",
      name: "playlist",
      component: Playlist,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/thankYou",
      name: "thankYou",
      component: ThankYou,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/allPlaylists",
      name: "allPlaylists",
      component: AllPlaylists,
      meta: {
        requiresAuth: true
      }
    }
  
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);
  const user = auth.getUser();

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && !user) {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
