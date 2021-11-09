<template>
  <MDBContainer>
    <div class="my-4" style="max-width: 400px">
      <MDBInput :value="input" @input="search" label="Search Table or Player" />
    </div>
    <MDBDatatable
      :dataset="dataset"
      sortField="tableNumber"
      sortOrder="asc"
      :entries="64"
      :entriesOptions="[8, 16, 32, 64, 128, 256]"
      noFoundMessage="No rounds created yet"
      :search="searchPhrase"
      :searchColumns="searchColumns"
    />
  </MDBContainer>
</template>

<script>
import { MDBContainer, MDBDatatable, MDBInput } from "mdb-vue-ui-kit";
import { computed } from "vue";
import { ref } from "vue";

export default {
  name: "TournamentRound",
  props: ["data"],
  components: {
    MDBContainer,
    MDBDatatable,
    MDBInput,
  },
  setup(props) {
    const input = ref("");
    const searchPhrase = ref("");
    const searchColumns = ref(["tableNumber", "firstPlayer", "secondPlayer"]);

    const search = (event) => {
      console.log(event.target.value);
      searchPhrase.value = event.target.value;
    };

    const dataset = computed(() => {
      return props.data;
    });

    return {
      dataset,
      search,
      input,
      searchPhrase,
      searchColumns,
    };
  },
};
</script>

<style scoped>
</style>