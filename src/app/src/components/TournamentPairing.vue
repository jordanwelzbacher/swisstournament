<template>
  <MDBContainer>
    {{ data.firstPlayer }}
  </MDBContainer>
</template>

<script>
import { MDBContainer } from "mdb-vue-ui-kit";
import { ref } from "vue";

export default {
  name: "TournamentPairing",
  props: ["data"],
  components: {
    MDBContainer,
  },
  computed: {},
  setup() {
    const tournaments = ref(null);
    const loading = ref(true);
    const error = ref(null);

    // function fetchData() {
    //   loading.value = true;
    //   http
    //     .get("/tournaments/" + uId, {})
    //     .then((json) => {
    //       tournaments.value = json.data;
    //     })
    //     .then(() => {
    //       loading.value = false;
    //     })
    //     .catch((e) => {
    //       console.log(e);
    //     });
    // }

    // onMounted(() => {
    //   fetchData();
    // });

    return {
      tournaments,
      loading,
      error,
    };
  },
};
</script>

<style scoped>
</style>