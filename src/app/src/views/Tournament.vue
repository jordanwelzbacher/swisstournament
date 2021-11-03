<template>
  <MDBContainer>
    <TournamentHeading :data="tournamentHeadingData" />
    <TournamentContextActions :data="tournamentContextActionsData" />
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
        completed: null,
        inTourney: null,
        playerRegistrationOn: null,
        registrationOpen: null,
        countRounds: null,
      },
      tournamentContextActionsData: {
        isOwner: null,
        isAdmin: null,
        inTourney: null,
        playerRegistrationOn: null,
        registrationOpen: null,
        countRounds: null,
        completed: null,
      },
      tournamentTabsData: {
        tournament: null,
      },
    };
  },
  mounted() {
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
        this.tournamentHeadingData.countPlayers = response.data.players.length;
        this.tournamentHeadingData.completed = response.data.tournament.completed;
        this.tournamentHeadingData.inTourney = false;
        if (store.getters["auth/user"]) {
           for (let player in response.data.players) {
            if (player.userId == store.getters["auth/user"].id) {
              this.tournamentHeadingData.inTourney = true;
            }
          }
        } 
        this.tournamentHeadingData.playerRegistrationOn = response.data.tournament.playerRegistrationOn;
        this.tournamentHeadingData.registrationOpen = response.data.tournament.registrationOpen;
        this.tournamentHeadingData.countRounds = response.data.tournament.countRounds;

        //End tournamentHeading data

        //Box up data for the tournamentContextActions component
        this.tournamentContextActionsData.isOwner = false;
        this.tournamentContextActionsData.isAdmin = false;
        this.tournamentContextActionsData.inTourney = false;
        //Is user logged in?
        if (store.getters["auth/user"]) {
          //check isOwner
          if (response.data.tournament.ownerUsername == store.getters["auth/user"].username) {
            this.tournamentContextActionsData.isOwner = true;
            this.tournamentTabsData.isOwner = true;
          }
     //     console.log("is the user the tournament owner? " + this.tournamentContextActionsData.isOwner);

          //check isAdmin
          for (let admin of response.data.admins) {
       //     console.log("this admin is " + admin)
            if (admin.userId == store.getters["auth/user"].id) {
              this.tournamentContextActionsData.isAdmin = true;
            }
          }
     //     console.log("is the user a tournament admin? " + this.tournamentContextActionsData.isAdmin);

          //check isInTournament
          for (let player of response.data.players) {
            if (player.userId == store.getters["auth/user"].id) {
              this.tournamentContextActionsData.inTourney = true;
            }
          }
     //     console.log("is the user a player in the tournament? " + this.tournamentContextActionsData.inTourney);
        }
        this.tournamentContextActionsData.playerRegistrationOn = response.data.tournament.playerRegistrationOn;
        this.tournamentContextActionsData.registrationOpen = response.data.tournament.registrationOpen;
        this.tournamentContextActionsData.countRounds = response.data.tournament.countRounds;
        this.tournamentContextActionsData.completed = response.data.tournament.completed;
        //End tournamentContextActions data

        this.tournamentTabsData.tournament = response.data.tournament;
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
