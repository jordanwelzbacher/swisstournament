<template>
  <main>
    {{ status }}
  </main>
</template>

<script>
//Tournament Status Component
//Requires tournamentAtAGlance as prop, or these fields:
//  completed
//  inTourney
//  playerRegistrationOn
//  registrationOpen
//  countRounds
export default {
  name: "TournamentStatus",
  props: ["data"],
  data() {
    return {
      status,
    };
  },
  mounted() {
      console.log(this.data)
    this.status = this.data.completed
      ? "Completed"
      : this.data.countRounds > 0
      ? "In-Progress"
      : this.data.countRounds == 0 && this.data.inTourney
      ? "Registered"
      : this.data.playerRegistrationOn &&
        this.data.registrationOpen &&
        this.data.countRounds == 0 &&
        !this.data.inTourney
      ? "Registration is Open"
      : this.data.playerRegistrationOn ||
        !this.data.registrationOpen ||
        (this.data.countRounds == 0 && !this.data.inTourney)
      ? "Registration is Closed"
      : "You should never see this"; //TODO remove for prod
  },
};
</script>