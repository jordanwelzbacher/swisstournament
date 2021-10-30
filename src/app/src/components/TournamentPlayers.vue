<template>
  <MDBContainer>
    <MDBDatatable
      :dataset="dataset"
      sortField="rank"
      sortOrder="asc"
      defaultValue="0"
      entires="64"
      entiresOptions="[8,16,32,64,128,256]"
      noFoundMessage="No players signed up yet"
    />
  </MDBContainer>
</template>

<script>
import { MDBContainer, MDBDatatable } from "mdb-vue-ui-kit";
import { computed } from "vue";
import _ from "lodash";
import constants from "@/constants/constants.js";

export default {
  name: "TournamentPlayers",
  props: ["data"],
  components: {
    MDBContainer,
    MDBDatatable,
  },
  setup(props) {
    const dataset = computed(() => {
      let table = {
        columns: [
          { label: "Rank", field: "rank" },
          { label: "Name", field: "name" },
          { label: "Match Points", field: "matchPoints", sort: "desc" },
          { label: "Wins", field: "wins" },
          { label: "Losses", field: "losses" },
          { label: "Draws", field: "draws" },
        ],
        rows: props.data.players,
      };

      if (props.data.tournament) {
        addTiebreakerColumn(
          props.data.tournament.firstTiebreaker,
          table.columns.length,
          "firstTiebreaker"
        );
        addTiebreakerColumn(
          props.data.tournament.secondTiebreaker,
          table.columns.length,
          "secondTiebreaker"
        );
        addTiebreakerColumn(
          props.data.tournament.thirdTiebreaker,
          table.columns.length,
          "thirdTiebreaker"
        );
        addTiebreakerColumn(
          props.data.tournament.fourthTiebreaker,
          table.columns.length,
          "fourthTiebreaker"
        );
        addTiebreakerColumn(
          props.data.tournament.fifthTiebreaker,
          table.columns.length,
          "fifthTiebreaker"
        );
      }
      return table;

      function addTiebreakerColumn(tiebreaker, i, which) {
        switch (tiebreaker) {
          case constants.NONE:
            break;
          case constants.OMWP:
            _.set(table.columns, `[${i}]`, {
              label: "OMW %",
              field: which,
            });
            break;
          case constants.GWP:
            _.set(table.columns, `[${i}]`, {
              label: "GW %",
              field: which,
            });
            break;
          case constants.OGWP:
            _.set(table.columns, `[${i}]`, {
              label: "OGW %",
              field: which,
            });
            break;
          case constants.FIRST_CUSTOM:
            _.set(table.columns, `[${i}]`, {
              label: props.data.tournament.firstCustomTiebreakerName,
              field: which,
            });
            break;
          case constants.SECOND_CUSTOM:
            _.set(table.columns, `[${i}]`, {
              label: props.data.tournament.secondCustomTiebreakerName,
              field: which,
            });
            break;
          default:
            break;
        }
      }
    });
    return {
      dataset,
    };
  },
};
</script>

<style scoped>
</style>