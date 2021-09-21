<template>
  <MDBModal
    id="infoModal"
    tabindex="-1"
    labelledby="infoModal"
    v-model="infoModal"
  >
    <MDBModalHeader>
      <MDBModalTitle id="infoModal">
        {{ modalHeaderText }}
      </MDBModalTitle>
    </MDBModalHeader>
    <MDBModalBody>{{ modalBodyText }}</MDBModalBody>
    <MDBModalFooter>
      <MDBBtn color="secondary" @click="infoModal = false">Close</MDBBtn>
    </MDBModalFooter>
  </MDBModal>
</template>

<script>
import {
  MDBModal,
  MDBModalHeader,
  MDBModalTitle,
  MDBModalBody,
  MDBModalFooter,
  MDBBtn,
} from "mdb-vue-ui-kit";
import { ref } from "vue";

export default {
  components: {
    MDBModal,
    MDBModalHeader,
    MDBModalTitle,
    MDBModalBody,
    MDBModalFooter,
    MDBBtn,
  },
  props: [
      modalHeaderText, 
      modalBodyText,
  ],
  setup() {
    const infoModal = ref(false);

    return {
      infoModal,
    };
  },
};
</script>