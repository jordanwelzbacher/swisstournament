<template>
  <MDBContainer class="mt-5">
    <MDBTabs v-model="tournamentTab">
      <!-- Tabs navs -->
      <MDBTabNav tabsClasses="mb-3">
        <MDBTabItem tabId="players" href="players">Players</MDBTabItem>
        <MDBTabItem tabId="standings" href="standings">Standings</MDBTabItem>
        <MDBTabItem tabId="rounds" href="rounds">Rounds</MDBTabItem>
        <MDBTabItem tabId="results" href="results">Submit Results</MDBTabItem>
        <MDBTabItem tabId="pending" href="pending">Pending Invites</MDBTabItem>
      </MDBTabNav>
      <!-- Tabs navs -->
      <!-- Tabs content -->
      <MDBTabContent>
        <MDBTabPane tabId="players">Content #1</MDBTabPane>
        <MDBTabPane tabId="standings">Content #5</MDBTabPane>
        <MDBTabPane tabId="rounds">Content #2</MDBTabPane>
        <MDBTabPane tabId="results">Content #3</MDBTabPane>
        <MDBTabPane tabId="pending">Content #4</MDBTabPane>
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

export default {
  name: "TournamentTabs",
  components: {
    MDBContainer,
    MDBTabs,
    MDBTabNav,
    MDBTabContent,
    MDBTabItem,
    MDBTabPane,
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
