<template>
  <div class="flex flex-wrap -mb-4">
    <div class="w-1/3 mb-4 bg-white-400 h-50"></div>
    <div class="w-1/3 mb-4 bg-white-500 h-50">
      <h1 id="seth" class="block text-gray-700 text-lg font-bold mb-2"> Playlist</h1>

      <div v-for="play in playlists" :key="play.albumId">
        <h1 class="block text-gray-700 text-lg font mb-2">{{play.title}}</h1>
      <h1 class="block text-gray-700 text-lg font mb-2">{{play.artist}}</h1>

      <img style="padding-bottom: 15px;" id="dan" @click="clickedName(play.id)" :src="play.img" />
      <div style="padding-top: 15px;">
              <button
                @click="deleteFromPlaylist(parseInt(play.albumId))"
                class="bg-gray-500 hover:bg-red-500 text-white font py-1 px-2 rounded-full"
              >Remove from Playlist</button>
            </div>
            
    </div>


    </div>
    <div class="w-1/3 mb-4 bg-white-400 h-50"></div>
    <div class="w-1/3 mb-4 bg-white-500 h-65"></div>
    <div class="w-1/3 mb-4 bg-white-400 h-65"></div>

    <div class="w-1/3 mb-4 bg-white-500 h-65"></div>
    <div class="w-1/3 mb-4 bg-white-400 h-12"></div>
    <div class="w-1/3 mb-4 bg-white-500 h-12">
      <router-link :to="{ name: 'library' }">
        <button
          class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-full"
        >Go to Library</button>
      </router-link>
    </div>
    <div class="w-1/3 mb-4 bg-white-400 h-12"></div>
  </div>
</template>

<script>
import auth from "@/auth.js";

export default {
  data() {
    return {
      user: auth.getUser(),
      playlists: []
    };
  },
  methods: {
      deleteFromPlaylist(albumId) {
      fetch(process.env.VUE_APP_REMOTE_API + "/api/playlistInsides/" + albumId, {
        headers: {
          Authorization: "Bearer " + auth.getToken(),
          "Content-Type": "application/json",
          Accept: "application/json"
        },
        body: JSON.stringify(this.$route.params.id),
        method: "DELETE"
      });
        window.location.reload();
    }
  },
  created() {
    fetch(process.env.VUE_APP_REMOTE_API + "/api/seth/" + this.$route.params.id, {
      headers: {
        Authorization: "Bearer " + auth.getToken(),
        "Content-Type": "application/json",
        Accept: "application/json"
      }
    })
      .then(response => {
        return response.json();
      })
      .then(parseRec => (this.playlists = parseRec));
  }
};
</script>

<style>
#dan {
  border-radius: 25px;
  padding: 15px;
}
</style>