<template>
  <div class="flex mb-4">
    <div class="w-1/2 bg-white-400 h-12">
      <div id="paul">
        <div
          id="mouse"
          class="border-r border-b border-l border-gray-400 lg:border-l lg:border-t lg:border-gray-400 bg-white rounded-b lg:rounded-b lg:rounded-r p-4 flex flex-col justify-between leading-normal max-w-sm w-full lg:max-w-full lg:flex"
        >
          <div
            class="h-48 lg:h-auto lg:w-35 flex-none bg-cover rounded-t lg:rounded-t lg:rounded-l text-center overflow-hidden"
            style="background-image: url('/img/card-left.jpg')"
          >
            <img id="art" :src="records.imgUrl" />
          </div>
          <div
            id="mouse"
            class="border-r border-b border-l border-gray-400 lg:border-l lg:border-t lg:border-gray-400 bg-white rounded-b lg:rounded-b lg:rounded-r p-4 flex flex-col justify-between leading-normal"
          >
            <div class="mb-8">
              <div class="text-gray-900 font-bold text-xl mb-2">{{records.title}}</div>
              <p class="text-gray-700 text-base">{{records.artist}}</p>
              <p class="text-gray-700 text-base">Genre | {{records.genre}}</p>
              <div>
              <p class="text-gray-700 text-base">
                <br> 
                 {{tracks.titleString}}</p>
                 <tr v-for="track in tracks" :key="track.id">
                   <td class="text-gray-700 text-base">{{track.titleString}}</td>
                 </tr>
              </div>
              <br> 
              <p class="text-gray-700 text-base">Length | {{records.lengthInMin}} min</p>
            </div>
            <div class="flex items-center">
              <div class="text-sm"></div>
            </div>
          </div>
        </div>
        <div id="todd">
          
            <button @click="addFavorite()"
              class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-full"
            >Add to library</button>
          
        </div>
      </div>
      <div class="w-1/2 bg-white-500 h-12"></div>
    </div>
  </div>
</template>



<script>
import auth from "@/auth.js";

export default {
  data() {
    return {
      user: auth.getUser(),
      records: [],
      tracks: []
    };
  },
  methods: {
    addFavorite() {
      fetch(process.env.VUE_APP_REMOTE_API + "/api/library", {
        headers: {
          Authorization: "Bearer " + auth.getToken(),
          "Content-Type": "application/json",
          Accept: "application/json"
        },
        method: "POST",
        body: JSON.stringify({ user_id: this.user.id, id: this.records.id })
      }).then(() => this.$router.push("/Library"));
    }
  },
  created() {
      fetch(process.env.VUE_APP_REMOTE_API + "/api/album/" + this.$route.params.id, {
      headers: {Authorization: "Bearer " + auth.getToken(),
        "Content-Type": "application/json",
        Accept: "application/json"
      } })   .then(response => {
        return response.json();
      })
      .then(parseRec => (this.records = parseRec))

     fetch(process.env.VUE_APP_REMOTE_API + "/api/records/" + this.$route.params.id, {
      headers: {Authorization: "Bearer " + auth.getToken(),
        "Content-Type": "application/json",
        Accept: "application/json"
      } })   .then(response => {
        return response.json();
      })
      .then(parseRec => (this.tracks = parseRec))
}

};
</script>

<style>
#art {
  border-radius: 75px;
}

#paul {
  padding: 50px;
}
#mouse {
  border-radius: 35px;
}
</style>