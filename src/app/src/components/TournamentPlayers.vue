<template>
  <MDBContainer>
    <div v-for:="player in data">{{ player.displayName }}</div>
  </MDBContainer>
</template>

<script>
import { MDBContainer } from "mdb-vue-ui-kit";

export default {
  name: "TournamentPlayers",
  props: ["data"],
  components: {
    MDBContainer,
  },
};
</script>

<style scoped>
</style>