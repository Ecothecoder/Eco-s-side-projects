<template>
  <div style="padding-left: 50px;">
    <h1 id="seth" class="block text-black-700 text-lg font-bold mb-2">My Library</h1>
    <h2
      style="padding-left: 20px;"
      class="block text-black-600 text-lg font mb-2"
    >Total Albums in My Library: {{count()}}</h2>
    <div>
      <div
        id="rob"
        class="grid favoritesItem"
        v-for="(favorite, index) in filteredRecords"
        :key="index"
      >
        <img id="david" @click="clickedName(favorite.id)" :src="favorite.imgUrl" />
        <!--make this into a component-->
        <div id="mouse">
          <p>
            <b>{{favorite.title}}</b>
          </p>
          <p>{{favorite.artist}}</p>
          <details>
            <p id="moon">Genre | {{favorite.genre}}</p>
            <p id="moon">Year Released | {{favorite.yearReleased}}</p>
          </details>
          <h4>
            <b>
              <br />My Notes
            </b>

            <!--<span class="label">Full Name:</span> <input type="text" v-model="review.name" placeholder="Enter Full Name">-->
            <span></span>
            <input
              v-if="show"
              type="text"
              id="banana"
              v-model="newNotes"
              class="border-r border-b border-l border-gray-400 lg:border-l lg:border-t lg:border-gray-400 bg-white rounded-b rounded-l lg:rounded-b lg:rounded-r p-2 flex flex-col justify-between leading-normal max-w-sm w-full lg:max-w-full lg:flex"
            />
            <p
              id="banana"
              v-if="!show"
              @click="toggle"
              class="border-r border-b border-l border-gray-400 lg:border-l lg:border-t lg:border-gray-400 bg-white rounded-b rounded-l lg:rounded-b lg:rounded-r p-2 flex flex-col justify-between leading-normal max-w-sm w-full lg:max-w-full lg:flex"
            >{{notes(favorite.id)}}</p>
            <div style="padding-top: 15px;">
              <button
                v-if="show"
                @click="toggle"
                v-on:click="saveNotes(parseInt(favorite.id),newNotes)"
                class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-full"
              >Save Notes</button>
            </div>
            <div style="padding-top: 15px;">
              <button
                v-if="show"
                @click="toggle"
                class="bg-red-500 hover:bg-red-700 text-white font-bold py-2 px-4 rounded-full"
              >Cancel</button>
            </div>
            <div style="padding-top: 15px;">
              <button
                @click="deleteFavorite(favorite)"
                class="bg-red-800 hover:bg-red-500 text-white font py-1 px-2 rounded-full"
              >Remove from Library</button>
            </div>
            <div style="padding-top: 15px;">
              <button
                @click="toggle2()"
                class="bg-blue-500 hover:bg-green-500 text-white font py-1 px-2 rounded-full"
              >Add to a Playlist</button>

              <div class="p-10">
                <div v-if="hey" class="dropdown inline-block relative">
                  <button
                    class="bg-gray-300 text-gray-700 font-semibold py-2 px-4 rounded inline-flex items-center"
                  >
                    <span class="mr-1">Add to a Playlist</span>
                    <svg
                      class="fill-current h-4 w-4"
                      xmlns="http://www.w3.org/2000/svg"
                      viewBox="0 0 20 20"
                    >
                      <path
                        d="M9.293 12.95l.707.707L15.657 8l-1.414-1.414L10 10.828 5.757 6.586 4.343 8z"
                      />
                    </svg>
                  </button>
                  <div v-if="hey">
                    <ul class="dropdown-menu absolute hidden text-gray-700 pt-1">
                      <li v-for="list in playlists" :key="list.playlistId">
                        <p
                          class="rounded-t bg-gray-200 hover:bg-gray-400 py-2 px-4 block whitespace-no-wrap"
                          @click="addToPlaylist(list, parseInt(favorite.id))"
                        >{{list.playlist_name}}</p>
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
            </div>
          </h4>
        </div>
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
      allFavorites: [],
      records: [],
      show: false,
      hey: false,
      playlists: []
    };
  },
  methods: {
    notes(albumId) {
      let notespot = this.allFavorites.find(Key => Key.id == albumId);
      if (!notespot.notes) {
        return "Add notes...";
      } else {
        let a = notespot.notes.substr(1,notespot.notes.length-2)
        console.log(notespot.notes);
        return a;
      }
    },

    clickedName(id) {
      this.$router.push({ name: "record", params: { id: id } });
    },

    deleteFavorite(rec) {
      fetch(process.env.VUE_APP_REMOTE_API + "/api/library/" + rec.id, {
        headers: {
          Authorization: "Bearer " + auth.getToken(),
          "Content-Type": "application/json",
          Accept: "application/json"
        },
        method: "DELETE"
      }).then(() => this.$router.push("/Library"));
      window.location.reload();
    },
    saveNotes(id, notes) {
      fetch(process.env.VUE_APP_REMOTE_API + "/api/library/" + id, {
        headers: {
          Authorization: "Bearer " + auth.getToken(),
          "Content-Type": "application/json",
          Accept: "application/json"
        },
        body: JSON.stringify(notes),
        method: "PUT"
      }).then(() => this.$router.push("/Library"));
      window.location.reload();
    },
    toggle() {
      this.show = !this.show;
    },
    toggle2() {
      this.hey = !this.hey;
    },
    count() {
      let counter = 0;
      for (let i = 0; i < this.allFavorites.length; i++) {
        counter++;
      }
      return counter;
    },
    addToPlaylist(playlist, album) {
      fetch(process.env.VUE_APP_REMOTE_API + "/api/playlistInsides/" + album, {
        headers: {
          Authorization: "Bearer " + auth.getToken(),
          "Content-Type": "application/json",
          Accept: "application/json"
        },
        body: JSON.stringify(playlist),
        method: "POST"
      }).then(() => this.$router.push("/Library"));
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
    fetch(process.env.VUE_APP_REMOTE_API + "/api/library", {
      headers: {
        Authorization: "Bearer " + auth.getToken(),
        "Content-Type": "application/json",
        Accept: "application/json"
      }
    })
      .then(response => response.json())
      .then(data => (this.allFavorites = data));

    fetch(process.env.VUE_APP_REMOTE_API + "/api/records", {
      headers: {
        Authorization: "Bearer " + auth.getToken(),
        "Content-Type": "application/json",
        Accept: "application/json"
      }
    })
      .then(response => {
        return response.json();
      })
      .then(parseRec => (this.records = parseRec));

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
#david {
  border-radius: 25px;
}

#rob {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;

  grid-gap: 2rem;
  padding-left: 50px;
  padding-bottom: 25px;
}
#moon {
  padding-left: 25px;
}

.dropdown:hover .dropdown-menu {
  display: block;
}
</style>