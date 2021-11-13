<template>
  <MDBContainer class="mt-4">
    {{data}}
    <MDBTabs v-if="data.rounds != null" @show="getTab" v-model="roundTab">
      <!-- Tabs navs -->
      <MDBTabNav>
        <MDBTabItem
          v-for="round of data.rounds"
          :key="String(round.id)"
          :tabId="String(round.id)"
          :href="String(round.id)"
        >
          {{
            round.topCut
              ? round.topCut == 2
                ? "Finals"
                : round.topCut == 4
                ? "Semifinals"
                : round.topCut == 8
                ? "Quarterfinals"
                : "Top " + round.topCut
              : round.roundNumber
          }}
        </MDBTabItem>
      </MDBTabNav>
      <!-- Tabs content -->
      <MDBTabContent v-if="players">
        <TournamentRound :data="table" />
      </MDBTabContent>
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
} from "mdb-vue-ui-kit";
import { ref } from "vue";
import { watch } from "vue";
import http from "../http-common";
import TournamentRound from "@/components/TournamentRound.vue";

export default {
  components: {
    TournamentRound,
    MDBContainer,
    MDBTabs,
    MDBTabNav,
    MDBTabContent,
    MDBTabItem,
  },
  props: ["data"],
  data() {
    return {
      players: null,
      round: null,
    };
  },
  methods: {
    getTab(e) {
      let tab = e.target.id.substring(4); //target.id will return, as example, "tab-1", need to chop off the "tab-"
      if (this.round == tab) return; //if user click the tab they are already on, do nothing
      this.round = tab; //set round
      this.pairings = null;

      if (this.players == null) {
        //If we have not grabbed the Players yet, grab those too
        const requestPlayers = this.getPlayers(this.data.tournamentId);
        const requestPairings = this.getPairings(tab);

        Promise.all([requestPlayers, requestPairings])
          .then((responses) => {
            this.players = responses[0].data;
            this.table.rows = this.getRows(responses[1].data);
          })
          .catch((e) => {
            console.log(e);
          });
      } else {
        this.getPairings(tab)
          .then((json) => {
            this.table.rows = this.getRows(json.data);
          })
          .catch((e) => {
            console.log(e);
          });
      }
    },
    getPairings(tab) {
      return http.get("pairings/" + tab, {});
    },
    getPlayers(data) {
      return http.get("playernames/" + data, {});
    },
    getRows(data) {
      let rowData = [];
      data.forEach((pairing) => {
        let firstPlayer = this.players.find((x) => x.id === pairing.firstPlayerId)
        firstPlayer = firstPlayer.userId == null ? firstPlayer.displayName : firstPlayer.displayName + " (#" + firstPlayer.userId + ")"
        let secondPlayer = this.players.find((x) => x.id === pairing.secondPlayerId)
        secondPlayer = secondPlayer.userId == null ? secondPlayer.displayName : secondPlayer.displayName + " (#" + secondPlayer.userId + ")"
        rowData.push({
          tableNumber: pairing.tableNumber,
          firstPlayer: firstPlayer,
          matchResultFirstPlayer: pairing.matchResultFirstPlayer,
          matchResultSecondPlayer: pairing.matchResultSecondPlayer,
          secondPlayer: secondPlayer
        });
      });
      return rowData;
    },
  },
  setup(props) {
    const roundTab = ref("undefined");

    watch(props, () => {
      try {
        if (props.data.rounds.length > 0) {
          roundTab.value = props.data.rounds[0].id.toString();
        }
      } catch {roundTab.value = "undefined"}
    });

    const table = ref({
      columns: [
        { label: "Table", field: "tableNumber", left: 0 },
        { label: "Player", field: "firstPlayer", left: 0 },
        { label: "Result", field: "matchResultFirstPlayer", left: 0 },
        { label: "Player", field: "secondPlayer", left: 0 },
        { label: "Result", field: "matchResultSecondPlayer", left: 0 },
      ],
      rows: [],
    });

    return {
      roundTab,
      table,
    };
  },
};
</script>

<style scoped>
i {
  padding-right: 1.5em;
}
.matchResult {
  font-weight: bold;
  padding-left: 30px;
}
</style>