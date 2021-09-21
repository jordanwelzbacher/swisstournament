<template>
  <main class="mt-4">
    <MDBContainer>
      <h2>Create Tournament</h2>
      <div class="m-4 border-start border-2">
        <div class="single-container">
          <MDBCheckbox class="ms-1" label="Enable Player Registration" v-model="playerRegistration" />
          <span><MDBIcon @click="showModal('userRegistration');" class="ms-2 helpIcon" icon="info-circle" iconStyle="fas"/></span>
        </div>
      </div>
      <div class="m-4 border-start border-2">
        <div class="single-container">
          <MDBCheckbox class="ms-1" label="Enable Player Results" v-model="playerResults" />
          <span><MDBIcon @click="showModal('userResults');" class="ms-2 helpIcon" icon="info-circle" iconStyle="fas"/></span>
        </div>
      </div>
    </MDBContainer>

    <MDBModal
      id="infoModal"
      tabindex="-1"
      labelledby="infoModalLabel"
      v-model="infoModal"
    >
      <MDBModalHeader>
        <MDBModalTitle id="infoModalLabel"> {{modalHeaderText}} </MDBModalTitle>
      </MDBModalHeader>
      <MDBModalBody>{{modalBodyText}}</MDBModalBody>
      <MDBModalFooter>
        <MDBBtn color="secondary" @click="infoModal = false">Close</MDBBtn>
      </MDBModalFooter>
    </MDBModal>
  </main>
</template>

<script>
// @ is an alias to /src
import {
  MDBContainer,
  MDBCheckbox,
  MDBModal,
  MDBModalHeader,
  MDBModalTitle,
  MDBModalBody,
  MDBModalFooter,
  MDBBtn,
  MDBIcon,
} from "mdb-vue-ui-kit";
import { ref } from "vue";

export default {
  name: "Create",
  components: {
    MDBContainer,
    MDBCheckbox,
    MDBModal,
    MDBModalHeader,
    MDBModalTitle,
    MDBModalBody,
    MDBModalFooter,
    MDBBtn,
    MDBIcon,
  },
  data() {
    return {
      modalHeaderText: "",
      modalBodyText: "",
    };
  },
  methods: {
    showModal(e) {
      console.log(e);
      switch (e) {
        case "userRegistration":
          console.log("here");
          this.modalHeaderText = "Enable Player Registration";
          this.modalBodyText = "text text text text text text text text text text text text text text text text text text text text text text text text";
          break;
        case "userResults":
          this.modalHeaderText = "Enable Player Results";
          this.modalBodyText = "text text text text text text text text text text text text text text text text text text text text text text text text";
          break;
      }
      this.infoModal = true;
    },
  },
  setup() {
    const playerRegistration = ref(false);
    const playerResults = ref(false);
    const infoModal = ref(false);

    return {
      playerRegistration,
      playerResults,
      infoModal,
    };
  },
};
</script>

<style scoped>
.helpIcon {
  cursor: help;
}
.helpIcon:hover {
  color: darkblue;
}
.single-container {
  display: flex;
}
</style>