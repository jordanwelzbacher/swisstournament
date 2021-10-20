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
                {{ getStatus(tournament) }}
              </div>
            </div>
            <div class="mt-1">
              <MDBIcon size="lg" icon="calendar-alt" />
              &nbsp;{{tournament.tournamentDate}}&emsp;
              <MDBIcon size="lg" icon="trophy" />
              &nbsp;{{tournament.competitionType}}&emsp;
              <MDBIcon size="lg" icon="users" />&nbsp;20&emsp;
              <MDBIcon size="lg" icon="map-marker-alt" />
              &nbsp;{{tournament.venue}}&emsp;
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

export default {
  name: "tournaments",
  components: {
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
  methods: {
    getStatus(tournament) {
      return tournament.is_completed
        ? "Completed"
        : tournament.countRounds > 0
        ? "In-Progress"
        : tournament.countRounds == 0 && tournament.inTourney
        ? "Registered"
        : tournament.isPlayerRegistrationOn &&
          tournament.isRegistrationOpen &&
          tournament.countRounds == 0 &&
          !tournament.inTourney
        ? "Registration is Open"
        : tournament.isPlayerRegistrationOn ||
          !tournament.isRegistrationOpen ||
          (tournament.countRounds == 0 && !tournament.inTourney)
        ? "Registration is Closed"
        : "You should never see this"; //TODO remove for prod
    },
  },
  setup() {
    //test
    const tournaments = ref(null);
    const loading = ref(true);
    const error = ref(null);

    function fetchData() {
      loading.value = true;
      const uId = store.getters["auth/user"]
        ? store.getters["auth/user"].id
        : "";
      http
        .get("/tournaments/" + uId, {})
        .then((json) => {
          tournaments.value = json.data;
          console.log(json.data);
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
