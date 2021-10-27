<template>
  <main>
    <MDBContainer class="mt-4">
      <div class="text-center mt-8" v-show="data.tournamentName == null">
        <MDBSpinner />
      </div>
      <div v-show="data.tournamentName != null">
        <div style="display: flex">
          <h1 class="mt-4 text-uppercase">{{ data.tournamentName }}</h1>
          <div class="fs-6" style="margin-left: auto; margin-top: auto">
            <h3><TournamentStatus :data="data" /></h3>
          </div>
        </div>
        <div class="mt-2 iconContainer">
          <MDBIcon size="lg" icon="calendar-alt" />&nbsp;{{
            data.dateTime
          }}&emsp; <MDBIcon size="lg" icon="trophy" />&nbsp;{{
            data.competitionType
          }}&emsp; <MDBIcon size="lg" icon="users" />&nbsp;{{data.countPlayers}}<span
            v-show="data.playerLimit > 0"
          >
            / {{ data.playerLimit }}</span
          >&emsp; <MDBIcon size="lg" icon="map-marker-alt" />&nbsp;{{
            data.venue
          }}&emsp;
        </div>
      </div>
    </MDBContainer>
  </main>
</template>

<script>
import { MDBContainer, MDBIcon, MDBSpinner } from "mdb-vue-ui-kit";
import TournamentStatus from '@/components/TournamentStatus'

export default {
  components: {
    TournamentStatus,
    MDBContainer,
    MDBIcon,
    MDBSpinner,
  },
  props: ["data"],
};
</script>

<style scoped>
.iconContainer {
  color: #777777;
}
</style>
