<template>
  <div>
    <div>
      <h1 id="seth" class="block text-gray-700 text-lg font-bold mb-2">Viewing all Records</h1>
    </div>
    <table>
      <div id="ethan" class="grid mb-4">
        <tr v-for="rec in records" :key="rec.id">
          <div
            id="box"
            @click="clickedName(rec.id)"
            class="border-solid border-4 border-blue-300 bg-gray-100 hover:bg-gray-400"
          >
            <img id="art" :src="rec.imgUrl" />
            <td
              id="recordText"
              class="block text-gray-700 text-sm font-bold mb-2"
            >{{rec.title}}</td>
            <td id="recordText" class="block text-gray-700 text-sm font mb-2">{{rec.artist}}</td>
          </div>
        </tr>
      </div>
    </table>
  </div>
</template>

<script>
import auth from "@/auth.js";

export default {
  data() {
    return {
      
      user: auth.getUser(),
      records: []
    };
  },
  methods: {
    logout() {
      auth.logout();
      this.$router.push("/login");
    },
    clickedName(id) {
      this.$router.push({ name: "record", params: { id: id } });
    }
  },
  created() {

       return fetch(process.env.VUE_APP_REMOTE_API + "/api/records", {
      headers: {
        "Content-Type": "application/json",
        Accept: "application/json"
      } })   .then(response => {
        return response.json();
      })
      .then(parseRec => (this.records = parseRec))
}
};
</script>

<style>
#art {
  border-radius: 35px;
  padding: 5px;
}

#ethan {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;

  grid-gap: 2 rem;
}
#box {
  padding: 0px;
  border-radius: 35px;
}

tr {
  padding: 15px;
}
#recordText {
  padding: 10px;
}
#seth {
  padding: 20px;
}
</style>