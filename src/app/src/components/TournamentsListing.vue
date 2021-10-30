<template>
  <main class="mt-4">
    <MDBContainer>
      <MDBListGroup flush class="mt-4">
        <div v-for="tournament in tournaments" :key="tournament.id">
          <MDBListGroupItem>
            <div class="text-uppercase fs-5 fw-bold" style="display: flex">
              <router-link
                :to="{
                  name: 'Tournament',
                  params: { tournamentId: `${tournament.id}` },
                }"
              >
                {{ tournament.tournamentName }}
              </router-link>
              <div class="fs-6" style="margin-left: auto; margin-top: auto">
                <TournamentStatus :data="tournament" />
              </div>
            </div>
            <div class="mt-1">
              <MDBIcon size="lg" icon="calendar-alt" />
              &nbsp;{{ tournament.tournamentDate }}&emsp;
              <MDBIcon size="lg" icon="trophy" />
              &nbsp;{{ tournament.competitionType }}&emsp;
              <MDBIcon size="lg" icon="users" />&nbsp;{{
                tournament.countPlayers
              }}&emsp;
              <MDBIcon size="lg" icon="map-marker-alt" />
              &nbsp;{{ tournament.venue }}&emsp;
            </div>
          </MDBListGroupItem>
        </div>
      </MDBListGroup>
    </MDBContainer>
  </main>
</template>

<script>
import {
  MDBContainer,
  MDBListGroup,
  MDBListGroupItem,
  MDBIcon,
} from "mdb-vue-ui-kit";
import http from "../http-common";
import { onMounted } from "vue";
import { ref } from "vue";
import { mapGetters } from "vuex";
import store from "@/store";
import TournamentStatus from "@/components/TournamentStatus";

export default {
  name: "tournaments",
  components: {
    TournamentStatus,
    MDBContainer,
    MDBListGroup,
    MDBListGroupItem,
    MDBIcon,
  },
  computed: {
    ...mapGetters({
      user: "auth/user",
    }),
  },
  setup() {
    //test
    const tournaments = ref(null);
    const loading = ref(true);
    const error = ref(null);

    function fetchData() {
      loading.value = true;
      loading.value = true;
      const uId = store.getters["auth/user"]
        ? store.getters["auth/user"].id
        : "";
      http
        .get("/tournaments/" + uId, {})
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
div {
  color: #777777;
}
</style>
