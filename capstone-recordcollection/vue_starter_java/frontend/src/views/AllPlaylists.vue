<template>
  <div class="flex flex-wrap -mb-4">
    <div class="w-1/4 mb-4 bg-white-400 h-30"></div>
    <div class="w-1/2 mb-4 bg-white-500 h-30">
      <h1 id="seth" class="block text-black-700 text-lg font-bold mb-2">My Playlists</h1>
    </div>
    <div class="w-1/4 mb-4 bg-white-400 h-30">
      <div style="padding-top: 15px;">
        <input
          v-if="show"
          type="text"
          id="banana"
          v-model="newPlaylist"
          class="border-r border-b border-l border-gray-400 lg:border-l lg:border-t lg:border-gray-400 bg-white rounded-b rounded-l lg:rounded-b lg:rounded-r p-2 flex flex-col justify-between leading-normal max-w-sm w-full lg:max-w-full lg:flex"
        />
        <div>
        <div style="padding-top: 15px;">
          <button
            v-if="show"
            @click="addNewPlaylist(newPlaylist)"
            class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-full"
          >Save Playlist</button>
        </div>
        <div style="padding-top: 15px;">
          <button
            v-if="show"
            @click="toggle"
            class="bg-red-500 hover:bg-red-700 text-white font-bold py-2 px-4 rounded-full"
          >Cancel</button>
        </div>
        </div>
        <button
          v-if="!show"
          @click="toggle()"
          class="bg-blue-500 hover:bg-green-500 text-white font py-1 px-2 rounded-full"
        >Add Playlist</button>
      </div>
    </div>
    <div class="w-1/4 mb-4 bg-white-500 h-65"></div>
    <div id="peanuts" class="w-1/2 mb-4 bg-white-400 h-65">
      <div v-for="play in playlists" :key="play.playlistId">
        <h1 class="block text-black-700 text-lg font mb-2">{{play.playlist_name}}</h1>

        <img id="dan" style="max-width: 200px; max-height: auto;" @click="clickedName(play.playlist_id)" src="../img/hiemma.jpg" />
        <div style="padding: 15px;">
          <button
            @click="deletePlaylist(parseInt(play.playlist_id))"
            class="bg-red-800 hover:bg-red-500 text-white font py-1 px-2 rounded-full"
          >Remove Playlist</button>
        </div>
      </div>
    </div>

    <div class="w-1/4 mb-4 bg-white-500 h-65"></div>
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
      playlists: [],
      show: false,
      newPlaylist: ''
    };
  },
  methods: {
    clickedName(id) {
      this.$router.push({ name: "playlist", params: { id: id } });
    },
    deletePlaylist(id) {
      fetch(process.env.VUE_APP_REMOTE_API + "/api/playlist/" + id, {
        headers: {
          Authorization: "Bearer " + auth.getToken(),
          "Content-Type": "application/json",
          Accept: "application/json"
        },
        method: "DELETE"
      }).then(() => this.$router.push("/Library"));
      window.location.reload();
    },
    toggle() {
      this.show = !this.show;
    },
    addNewPlaylist(name) {
      fetch(process.env.VUE_APP_REMOTE_API + "/api/playlist", {
        headers: {
          Authorization: "Bearer " + auth.getToken(),
          "Content-Type": "application/json",
          Accept: "application/json"
        },
        method: "POST",
        body: (name)
      });

      this.show = !this.show
      window.location.reload();
    }
  },
  computed: {
    filteredRecords() {
      return this.records.filter(test =>
        this.allFavorites.find(l => l.id == test.id)
      );
    }
  },

  created() {
    fetch(process.env.VUE_APP_REMOTE_API + "/api/seth", {
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
#peanuts {
  display: grid;
  grid-template-columns: 1fr 1fr;

  grid-gap: 2 rem;
}
</style>