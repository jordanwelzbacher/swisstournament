<template>
  <main>
    {{ status }}
  </main>
</template>

<script>
import { computed } from "vue";
//Tournament Status Component
//Requires tournamentAtAGlance as prop, or these fields:
//  completed
//  inTourney
//  playerRegistrationOn
//  registrationOpen
//  countRounds


//TODO currently inTourney is NOT AVAILABLE
export default {
  name: "TournamentStatus",
  props: ["data"],
  setup(props) {
    const status = computed(() => {
      return props.data.completed
        ? "Completed"
        : props.data.countRounds > 0
        ? "In-Progress"
        : props.data.countRounds == 0 && props.data.inTourney
        ? "Registered"
        : props.data.playerRegistrationOn &&
          props.data.registrationOpen &&
          props.data.countRounds == 0 &&
          !props.data.inTourney
        ? "Registration is Open"
        : props.data.playerRegistrationOn ||
          !props.data.registrationOpen ||
          (props.data.countRounds == 0 && !props.data.inTourney)
        ? "Registration is Closed"
        : "You should never see this"; //TODO remove for prod
    })
    return {
      status
    }
  },
};
</script>