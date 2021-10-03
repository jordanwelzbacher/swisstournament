<template>
  <main>
    <MDBContainer>
      <div style="display: flex"><h1 class="mt-4 text-uppercase">Chess at Jordan's</h1>
      <div class="fs-6" style="margin-left: auto; margin-top: auto;">
        <h3>Registration Open</h3>
      </div></div>
      <h3 class="text-uppercase fw-bold">Chess</h3>
      <div class="mt-4">
        <MDBIcon size="lg" icon="calendar-alt" />&nbsp;10-10-2021 9:00PM&emsp;
        <MDBIcon size="lg" icon="trophy" />&nbsp;Chess&emsp;
        <MDBIcon size="lg" icon="users" />&nbsp;20 / 128&emsp;
        <MDBIcon size="lg" icon="map-marker-alt" />&nbsp;Jordan's House&emsp;
      </div>
    </MDBContainer>
  </main>
</template>

<script>
import { MDBContainer, MDBIcon } from "mdb-vue-ui-kit";

export default {
  components: {
    MDBContainer,
    MDBIcon,
  },
};
</script>

<style scoped>
</style>