<template>
  <MDBContainer class="mt-5">
    <MDBTabs v-if="data.tournament" @show="getTab" v-model="tournamentTab">
      <!-- Tabs navs -->
      <MDBTabNav tabsClasses="mb-3">
        <MDBTabItem tabId="players" href="players">Players</MDBTabItem>
        <MDBTabItem tabId="rounds" href="rounds">Rounds</MDBTabItem>
        <MDBTabItem tabId="results" href="results">Submit Results</MDBTabItem>
        <MDBTabItem tabId="pending" href="pending">Pending Invites</MDBTabItem>
        <MDBTabItem tabId="admins" href="admins">Admins</MDBTabItem>
      </MDBTabNav>
      <!-- Tabs navs -->
      <!-- Tabs content -->
      <MDBTabContent>
        <MDBTabPane tabId="players">
          <TournamentPlayers
            :data="{ players: players, tournament: data.tournament }"
          />
        </MDBTabPane>
        <MDBTabPane tabId="rounds"><TournamentRounds :data="{ rounds: rounds, tournamentId: data.tournament.id }" /></MDBTabPane>
        <MDBTabPane tabId="results">Content #3</MDBTabPane>
        <MDBTabPane tabId="pending">Content #4</MDBTabPane>
        <MDBTabPane tabId="admins">
          <TournamentAdmins
            :data="{ isOwner: data.isOwner, admins: admins }"
          />
        </MDBTabPane>
      </MDBTabContent>
      <!-- Tabs content -->
    </MDBTabs>
  </MDBContainer>
</template>

<script>
import {
  MDBContainer,
  MDBTabs,
  MDBTabNav,
  MDBTabContent,
  MDBTabItem,
  MDBTabPane,
} from "mdb-vue-ui-kit";
import { ref } from "vue";
import TournamentPlayers from "@/components/TournamentPlayers.vue";
import TournamentAdmins from "@/components/TournamentAdmins.vue";
import TournamentRounds from "@/components/TournamentRounds.vue";
import http from "../http-common";

export default {
  name: "TournamentTabs",
  props: ["data"],
  components: {
    TournamentPlayers,
    TournamentAdmins,
    TournamentRounds,
    MDBContainer,
    MDBTabs,
    MDBTabNav,
    MDBTabContent,
    MDBTabItem,
    MDBTabPane,
  },
  data() {
    return {
      players: null,
      admins: null,
      rounds: null,
    };
  },
  methods: {
    getTab(e) {
      if (e.target === e.relatedTarget) return; //if user click the tab they are already on, do nothing
      let tab = e.target.id.substring(4); //target.id will return, as example, "tab-rounds", need to chop off the "tab-"
      http
        .get(tab + "/" + this.data.tournament.id, {})
        .then((json) => {
          this[`${tab}`] = json.data;
        })
        .then(() => {})
        .catch((e) => {
          console.log(e);
        });
    },
  },
  setup() {
    const tournamentTab = ref("players");

    return {
      tournamentTab,
    };
  },
};
</script>

<style scoped></style>
