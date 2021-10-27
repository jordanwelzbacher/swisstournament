<template>
  <MDBContainer>
    <MDBDatatable
      :dataset="dataset"
      sortField="rank"
      sortOrder="asc"
      defaultValue="0"
      entires=64
      entiresOptions=[8,16,32,64,128,256]
      fixedHeader="true"
      noFoundMessage="No players signed up yet"
    />
  </MDBContainer>
</template>

<script>
import { MDBContainer, MDBDatatable } from "mdb-vue-ui-kit";
import { computed } from "vue";
// import { defineComponent, ref } from 'vue';
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
    // let myObj = ref({
    //   players: props.players,
    // });
    // console.log(myObj);
    const dataset = computed(() => {
      console.log(props.data);
      // if(props.data.tournament) {
      // let tiebreakers = {...props.data.players[0].tiebreakers};
      // console.log(tiebreakers['1']); }
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
          table.columns.length
        );
        addTiebreakerColumn(
          props.data.tournament.secondTiebreaker,
          table.columns.length
        );
        addTiebreakerColumn(
          props.data.tournament.thirdTiebreaker,
          table.columns.length
        );
        addTiebreakerColumn(
          props.data.tournament.fourthTiebreaker,
          table.columns.length
        );
        addTiebreakerColumn(
          props.data.tournament.fifthTiebreaker,
          table.columns.length
        );
      }
      return table;

      function addTiebreakerColumn(tiebreaker, i) {
        switch (tiebreaker) {
          case constants.NONE:
            break;
          case constants.OMWP:
            console.log("here!!!");
            console.log(table.columns);
            _.set(table.columns, `[${i}]`, {
              label: "OMW%",
              field: "firstTiebreaker",
            });
            break;
          case constants.GWP:
            _.set(table, `columns[${i}]`, {
              label: "GW%",
              field: "tiebreakers",
            });
            break;
          default:
            break;
        }
        console.log(table);
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