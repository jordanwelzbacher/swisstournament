<template>
  <main class="mt-4">
    <MDBContainer>
       <MDBAccordion v-model="activeItem">
        <MDBAccordionItem
          headerTitle="Filter Results"
          collapseId="collapseOne"
          >
          put filters here
        </MDBAccordionItem>
      </MDBAccordion>
      <TournamenstListing />
    </MDBContainer>
  </main>
</template>

<script>
import TournamenstListing from "@/components/TournamentsListing.vue";
import { MDBContainer, MDBAccordion, MDBAccordionItem } from "mdb-vue-ui-kit";
import { ref } from "vue";

export default {
  name: "Tournaments",
  components: {
    MDBContainer,
    MDBAccordion,
    MDBAccordionItem,
    TournamenstListing,
  },
  setup() {
    const activeItem = ref('!collapseOne');
    return {
      activeItem
    }
  }
};
</script>
