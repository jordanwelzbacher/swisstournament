<template>
  <main>
    <MDBContainer>
      This is the tournament view page.
      <br />Let's get tournament id number:
      {{ this.$route.params.tournamentId }}
      <TournamentHeading />
    </MDBContainer>
  </main>
</template>

<script>
import http from "../http-common";
import { ref } from "vue";
// import { onMounted } from "vue";
import { MDBContainer } from "mdb-vue-ui-kit";
import TournamentHeading from "@/components/TournamentHeading.vue";

export default {
  name: "Tournament",
  components: {
    TournamentHeading,
    MDBContainer,
  },
  data() {
    return {
      tournamentId: this.$route.params.tournamentId,
    };
  },
  created() {
    const tournament = ref(null);
    const loading = ref(true);
    const error = ref(null);

    loading.value = true;

    http
      .get("/tournament/" + this.tournamentId, {})
      .then((json) => {
        tournament.value = json.data;
        console.log(tournament.value);
      })
      .then(() => {
        loading.value = false;
      })
      .catch((e) => {
        console.log(e);
      });

    return {
      tournament,
      loading,
      error,
    };
  },
};
</script>