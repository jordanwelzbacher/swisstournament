<template>
  <main class="mt-4">
    <h2 class="mb-4" style="text-align: center">Create Tournament</h2>
    <MDBContainer>
      <MDBRow>
        <MDBCol md="6">
          <h4 class="mb-4">Basic Information</h4>
          <div class="mx-4 me-8">
            <MDBInput
              class="mt-4"
              label="Tournament Name"
              v-model="tournamentName"
            />
            <MDBInput
              class="mt-4"
              label="Competition Type"
              v-model="competitionType"
              formText='Example: "Chess"'
            />
            Date & Time:
            <input
              class="mt-4 ms-1"
              label="Name"
              v-model="dateAndTime"
              type="datetime-local"
            />
            <MDBInput
              class="mt-4"
              label="Venue"
              v-model="venue"
              formText="Optional"
            />
            <div class="my-4 single-container">
              <MDBCheckbox
                label="Enable Player Registration"
                v-model="playerRegistrationOn"
              />
              <span
                ><MDBIcon
                  @click="showModal('userRegistration')"
                  class="ms-2 helpIcon"
                  icon="info-circle"
                  iconStyle="fas"
              /></span>
            </div>
            <div class="my-4 single-container">
              <MDBCheckbox
                label="Enable Player Results"
                v-model="playerResultsOn"
              />
              <span
                ><MDBIcon
                  @click="showModal('userResults')"
                  class="ms-2 helpIcon"
                  icon="info-circle"
                  iconStyle="fas"
              /></span>
            </div>
          </div>
        </MDBCol>
        <MDBCol md="6">
          <h4 class="mb-4">Scoring & Tiebreakers</h4>
          <div class="m-4">
            <MDBSelect
              v-model:options="options1"
              v-model:selected="selected1"
            />
            <MDBInput class="mt-4" label="Match Win Points" type="number" />
            <MDBInput class="mt-4" label="Match Draw Points" type="number" />
            <MDBInput class="mt-4" label="Match Loss Points" type="number" />
            <MDBInput
              class="mt-4"
              label="Games Per Match"
              v-model="gamesPerMatch"
            />
          </div>
          <MDBSortable>
            <MDBSortableItem>Item 1</MDBSortableItem>
            <MDBSortableItem>Item 2</MDBSortableItem>
            <MDBSortableItem>Item 3</MDBSortableItem>
            <MDBSortableItem>Item 4</MDBSortableItem>
            <MDBSortableItem>Item 5</MDBSortableItem>
          </MDBSortable>
        </MDBCol>
      </MDBRow>
    </MDBContainer>

    <MDBModal
      id="infoModal"
      tabindex="-1"
      labelledby="infoModalLabel"
      v-model="infoModal"
    >
      <MDBModalHeader>
        <MDBModalTitle id="infoModalLabel">
          {{ modalHeaderText }}
        </MDBModalTitle>
      </MDBModalHeader>
      <MDBModalBody>{{ modalBodyText }}</MDBModalBody>
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
  MDBCol,
  MDBRow,
  MDBCheckbox,
  MDBModal,
  MDBModalHeader,
  MDBModalTitle,
  MDBModalBody,
  MDBModalFooter,
  MDBBtn,
  MDBIcon,
  MDBInput,
  MDBSelect,
  MDBSortable,
  MDBSortableItem,
} from "mdb-vue-ui-kit";
import { ref } from "vue";

export default {
  name: "Create",
  components: {
    MDBContainer,
    MDBCol,
    MDBRow,
    MDBCheckbox,
    MDBModal,
    MDBModalHeader,
    MDBModalTitle,
    MDBModalBody,
    MDBModalFooter,
    MDBBtn,
    MDBIcon,
    MDBInput,
    MDBSelect,
    MDBSortable,
    MDBSortableItem,
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
          this.modalBodyText =
            "text text text text text text text text text text text text text text text text text text text text text text text text";
          break;
        case "userResults":
          this.modalHeaderText = "Enable Player Results";
          this.modalBodyText =
            "text text text text text text text text text text text text text text text text text text text text text text text text";
          break;
      }
      this.infoModal = true;
    },
  },
  setup() {
    const playerRegistrationOn = ref(false);
    const playerResultsOn = ref(false);
    const infoModal = ref(false);
    const tournamentName = ref("");
    const gamesPerMatch = ref("Best of 1");
    const dateAndTime = ref("");
    const competitionType = ref("");
    const venue = ref("");
    const options1 = ref([
      { text: "One", value: 1 },
      { text: "Two", value: 2 },
      { text: "Three", value: 3 },
      { text: "Four", value: 4 },
      { text: "Five", value: 5 },
      { text: "Six", value: 6 },
      { text: "Seven", value: 7 },
      { text: "Eight", value: 8 },
    ]);
    const selected1 = ref("");

    return {
      playerRegistrationOn,
      playerResultsOn,
      infoModal,
      tournamentName,
      gamesPerMatch,
      dateAndTime,
      competitionType,
      venue,
      options1,
      selected1,
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