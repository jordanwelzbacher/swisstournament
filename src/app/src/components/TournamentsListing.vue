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
                {{ tournament.tournament_name }}
              </router-link>
              <div class="fs-6" style="margin-left: auto; margin-top: auto">
                Registration Open
              </div>
            </div>
            <div class="mt-1">
              <MDBIcon size="lg" icon="calendar-alt" />&nbsp;{{tournament.tournament_date}}&emsp; <MDBIcon size="lg" icon="trophy" />&nbsp;{{
                tournament.competition_type
              }}&emsp; <MDBIcon size="lg" icon="users" />&nbsp;20&emsp;
              <MDBIcon size="lg" icon="map-marker-alt" />&nbsp;{{
                tournament.venue
              }}&emsp;
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
import { mapGetters } from 'vuex';
import store from '@/store'

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
  setup() {

    const tournaments = ref(null);
    const loading = ref(true);
    const error = ref(null);

    function fetchData() {
      loading.value = true;
      const uname = store.getters['auth/user'] ? (store.getters['auth/user'].username) : "";
      console.log(uname);
      http
        .get("/tournaments/" + uname, {})
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
