<template>
  <div>
    This is the Browse page!
    <TournamenstListing />
  </div>
</template>

<script>
import TournamenstListing from "@/components/TournamentsListing.vue";

export default {
  name: "Tournaments",
  components: {
    TournamenstListing,
  }
};
</script>