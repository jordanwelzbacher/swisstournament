<template>
  <MDBContainer>
    <TournamentHeading :data="tournamentHeadingData" />
    <hr />
    <TournamentContextActions />
    <hr />
    <TournamentTabs />
  </MDBContainer>
</template>

<script>
import http from "../http-common";
import { MDBContainer, } from "mdb-vue-ui-kit";
import TournamentHeading from "@/components/TournamentHeading.vue";
import TournamentContextActions from "@/components/TournamentContextActions.vue";
import TournamentTabs from "@/components/TournamentTabs.vue";

export default {
  name: "Tournament",
  components: {
    TournamentHeading,
    TournamentContextActions,
    TournamentTabs,
    MDBContainer,
    
  },
  data() {
    return {
      tournamentId: this.$route.params.tournamentId,
      tournamentHeadingData: {
        tournamentName: null,
        competitionType: null,
        dateTime: null,
        venue: null,
        playerLimit: null,
      },
    };
  },
  mounted() {
    http
      .get("/tournament/" + this.tournamentId)
      .then((response) => {
        this.tournamentHeadingData.tournamentName =
          response.data.tournament_name;
        this.tournamentHeadingData.competitionType =
          response.data.competition_type;
        this.tournamentHeadingData.dateTime = "10-10-2021 9:00PM"; //TODO
        this.tournamentHeadingData.venue = response.data.venue;
        this.tournamentHeadingData.playerLimit = response.data.player_limit;
      })
      .catch((e) => {
        console.log(e);
      });
  },
};
</script>
