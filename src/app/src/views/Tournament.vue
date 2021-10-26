<template>
  <MDBContainer>
    <TournamentHeading :data="tournamentHeadingData" />
    <hr />
    <TournamentContextActions :data="tournamentContextActionsData" />
    <hr />
    <TournamentTabs :data="tournamentTabsData" />
  </MDBContainer>
</template>

<script>
import http from "../http-common";
import { MDBContainer } from "mdb-vue-ui-kit";
import TournamentHeading from "@/components/TournamentHeading.vue";
import TournamentContextActions from "@/components/TournamentContextActions.vue";
import TournamentTabs from "@/components/TournamentTabs.vue";
import { mapGetters } from "vuex";
import store from "@/store";

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
        countPlayers: null,
      },
      tournamentContextActionsData: {
        isOwner: null,
        isAdmin: null,
        isInTournament: null,
        isPlayerRegistrationOn: null,
        isRegistrationOpen: null,
      },
      tournamentTabsData: {
        tournament: null,
        players: null,
        pairings: null,
        rounds: null,
      },
    };
  },
  mounted() {
    console.log("do we have id here?" + store.getters["auth/user"].id);
    http
      .get("/tournament/" + this.tournamentId)
      .then((response) => {
        //Box up data for the tournamentHeading component
        this.tournamentHeadingData.tournamentName =
          response.data.tournament.tournamentName;
        this.tournamentHeadingData.competitionType =
          response.data.tournament.competitionType;
        this.tournamentHeadingData.dateTime =
          response.data.tournament.tournamentDate;
        this.tournamentHeadingData.venue = response.data.tournament.venue;
        this.tournamentHeadingData.playerLimit =
          response.data.tournament.playerLimit;
        this.tournamentHeadingData.countPlayers = response.data.players.length
        //End tournamentHeading data

        //Box up data for the tournamentContextActions component
        this.tournamentContextActionsData.isOwner = false;
        this.tournamentContextActionsData.isAdmin = false;
        this.tournamentContextActionsData.isInTournament = false;
        //Is user logged in?
        if (store.getters["auth/user"]) {
          //check isOwner
          if (response.data.tournament.ownerUserId == store.getters["auth/user"].id) {
            this.tournamentContextActionsData.isOwner = true;
          }
          console.log("is the user the tournament owner? " + this.tournamentContextActionsData.isOwner);

          //check isAdmin
          for (let admin in response.data.admins) {
            if (admin.userId == store.getters["auth/user"].id) {
              this.tournamentContextActionsData.isAdmin = true;
            }
          }
          console.log("is the user a tournament admin? " + this.tournamentContextActionsData.isAdmin);

          //check isInTournament
          for (let player in response.data.players) {
            if (player.userId == store.getters["auth/user"].id) {
              this.tournamentContextActionsData.isInTournament = true;
            }
          }
          console.log(
            "is the user a player in the tournament? " + this.tournamentContextActionsData
          );
        }
        this.tournamentContextActionsData.isPlayerRegistrationOn = response.data.tournament.playerRegistrationOn;
        this.tournamentContextActionsData.isRegistrationOpen = response.data.tournament.registrationOpen;
        //End tournamentContextActions data

        this.tournamentTabsData.tournament = response.data.tournament;
        this.tournamentTabsData.players = response.data.players;
        this.tournamentTabsData.rounds = response.data.rounds;
        this.tournamentTabsData.pairings = response.data.rounds;
      })
      .catch((e) => {
        console.log(e);
      });
  },

  updated() {},
  computed: {
    ...mapGetters({
      user: "auth/user",
    }),
  },
};
</script>
