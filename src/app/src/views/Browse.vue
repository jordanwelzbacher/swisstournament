<template>
  <main class="mt-4">
    <MDBContainer>
      This is the Browse page!
      <TournamenstListing />
    </MDBContainer>
  </main>
</template>

<script>
import TournamenstListing from "@/components/TournamentsListing.vue";
import { MDBContainer } from "mdb-vue-ui-kit";

export default {
  name: "Tournaments",
  components: {
    MDBContainer,
    TournamenstListing,
  },
};
</script>