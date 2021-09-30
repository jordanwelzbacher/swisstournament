<template>
  <main class="mt-4">
    <MDBContainer>
      <MDBTable>
        <thead>
          <tr>
            <th scope="col">Name</th>
            <th scope="col">Game</th>
            <th scope="col">Date & Time</th>
            <th scope="col">Players</th>
            <th scope="col">Status</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="tournament in tournaments" :key="tournament.id">
            <td><a :href="'/tournament/'+tournament.id">{{ tournament.tournament_name }}</a></td>
            <td>{{ tournament.competition_type }}</td>
            <td>{{ tournament.tournament_date }}</td>
            <td>TODO</td>
            <td>TODO</td>
          </tr>
        </tbody>
      </MDBTable>
    </MDBContainer>
  </main>
</template>

<script>
import { MDBContainer, MDBTable } from "mdb-vue-ui-kit";
import http from "../http-common";
import { onMounted } from "vue";
import { ref } from "vue";

export default {
  name: "tournaments",
  components: {
    MDBContainer,
    MDBTable,
  },
  setup() {
    const tournaments = ref(null);
    const loading = ref(true);
    const error = ref(null);

    function fetchData() {
      loading.value = true;

      http
        .get("/tournaments", {})
        .then((json) => {
          tournaments.value = json.data;
        })
        .then(() => {
          loading.value = false;
        })
        .catch((e) => {
          console.log(e);
        });
    }

    onMounted(() => {
      fetchData();
    });

    return {
      tournaments,
      loading,
      error,
    };
  },
};
</script>

<style scoped>
</style>
