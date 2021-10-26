<template>
  <MDBContainer>
    {{ data }}
    <MDBDatatable :dataset="dataset" />
    <div v-for:="player in data.players">{{ player.name }}</div>
  </MDBContainer>
</template>

<script>
import { MDBContainer, MDBDatatable } from "mdb-vue-ui-kit";
// import { defineComponent, ref } from 'vue';
// import _ from 'lodash';
// import constants from '@/constants/constants.js'

export default {
  name: "TournamentPlayers",
  props: ["data"],
  components: {
    MDBContainer,
    MDBDatatable,
  },
  setup(props) {
    console.log(props);
    const copy = JSON.parse(JSON.stringify(props));
    console.log(copy);
    // let myObj = ref({
    //   players: props.players,
    // });
    // console.log(myObj);
    const dataset = {
      columns: [
        { label: "Name", field: "name" },
        { label: "Match Points", field: "matchPoints" },
        { label: "Wins", field: "wins", sort: true },
        { label: "Losses", field: "losses", sort: false },
        { label: "Draws", field: "draws", sort: false },
      ],
      data: props.data,
    };
    // addTiebreakerColumn(props.data.tournament.firstTiebreaker, dataset.columns.length);
    // addTiebreakerColumn(props.data.tournament.secondTiebreaker, dataset.columns.length);
    // addTiebreakerColumn(props.data.tournament.thirdTiebreaker, dataset.columns.length);
    // addTiebreakerColumn(props.data.tournament.fourthTiebreaker, dataset.columns.length);
    // addTiebreakerColumn(props.data.tournament.fifthTiebreaker, dataset.columns.length);

    // function addTiebreakerColumn(tiebreaker, i) {
    //   switch (tiebreaker) {
    //     case constants.OMWP:
    //       _.set(dataset, `columns[${i}]`, {label: "OMW%", field: "tiebreakers", sort: false})
    //       break;
    //     case constants.GWP:
    //       _.set(dataset, `columns[${i}]`, {label: "GW%", field: "tiebreakers", sort: false})
    //       break;
    //     default:
    //       break;
    //   }
    // }
    return {
      dataset,
    };
  },
};
</script>

<style scoped>
</style>