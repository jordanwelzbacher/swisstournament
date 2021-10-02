<template>
  <main class="mt-4">
    <MDBContainer>
      <MDBListGroup flush>
        <div v-for="tournament in tournaments" :key="tournament.id">
          <MDBListGroupItem>
            <div class="text-uppercase fs-5 fw-bold" style="display: flex;">
              <a href="#"> {{ tournament.tournament_name }}</a>
              <div class="fs-6" style="margin-left:auto; margin-top:auto;">
                Registration Open
              </div>
            </div>
            <div>
              <MDBIcon icon="calendar-alt" />&nbsp;10-10-2021 9:00 PM&emsp;
              <MDBIcon icon="trophy" />&nbsp;{{
                tournament.competition_type
              }}&emsp; <MDBIcon icon="users" />&nbsp;20&emsp;
              <MDBIcon icon="map-marker-alt" />&nbsp;{{
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

export default {
  name: "tournaments",
  components: {
    MDBContainer,
    MDBListGroup,
    MDBListGroupItem,
    MDBIcon,
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
