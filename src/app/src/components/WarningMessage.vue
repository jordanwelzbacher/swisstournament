<template>
  <div class="mt-4 fw-bold" v-show="data">
    <p class="note note-danger">
      <MDBRow>
        <MDBCol md="1" class="d-flex align-items-center">
          <span style="color: #f93154">
            <MDBIcon icon="exclamation-circle" iconStyle="fas" size="lg"
          /></span>
        </MDBCol>
        <MDBCol>Error: {{ data }} </MDBCol>
      </MDBRow>
    </p>
  </div>
</template>

<script>
import { MDBRow, MDBCol, MDBIcon } from "mdb-vue-ui-kit";

export default {
  name: "WarningMessage",
  props: ["data"],
  components: {
    MDBRow,
    MDBCol,
    MDBIcon,
  },
};
</script>