<template>
  <main class="mt-4">
    <h2 class="mb-4" style="text-align: center">Create Tournament</h2>
    <MDBContainer>
      <!-- BASIC INFORMATION -->
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
            />
            <hr class="my-4" />
            <MDBDatepicker
              class="mt-4"
              v-model="date"
              label="Date"
              format="MMM D, YYYY"
            />
            <MDBTimepicker class="mt-4" label="Time" v-model="time" />
            <MDBInput
              class="mt-4"
              label="Venue"
              v-model="venue"
              formText="Optional"
            />
            <hr class="my-4" />
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
                label="Enable Player-Submitted Results"
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
        <!-- SCORING & TIEBREAKERS -->
        <MDBCol md="6">
          <h4 class="mb-4">Scoring & Tiebreakers</h4>
          <div class="m-4">
            <MDBSelect
              label="Select Preset (Optional)"
              :options="presetOptions"
              :selected="preset"
              @change="presetChange(this.selected)"
            />
            <hr class="my-4" />
            <MDBInput
              class="mt-4"
              v-model="winPoints"
              label="Match Win Points"
              type="number"
            />
            <MDBInput
              class="mt-4"
              v-model="drawPoints"
              label="Match Draw Points"
              type="number"
            />
            <MDBInput
              class="mt-4"
              v-model="lossPoints"
              label="Match Loss Points"
              type="number"
            />
            <MDBInput
              class="mt-4"
              type="number"
              label="Games Per Match"
              v-model="gamesPerMatch"
            />
            <hr class="my-4" />
            <!-- TIEBREAKERS -->
            <MDBSelect
              label="First Tiebreaker"
              ref="tiebreaker1"
              :options="firstTiebreakerOptions"
              :selected="firstTiebreaker"
            />
            <div v-show="numTiebreakers >= 2" style="display: flex">
              <MDBSelect
                class="mt-4"
                label="Second Tiebreaker"
                ref="tiebreaker2"
                :options="secondTiebreakerOptions"
                :selected="secondTiebreaker"
              />
              <MDBBtn
                v-show="numTiebreakers == 2"
                class="mt-4"
                color="danger"
                @click="removeTiebreaker()"
              >
                <MDBIcon icon="times" iconStyle="fas" />
              </MDBBtn>
            </div>
            <div v-show="numTiebreakers >= 3" style="display: flex">
              <MDBSelect
                class="mt-4"
                label="Third Tiebreaker"
                ref="tiebreaker3"
                :options="thirdTiebreakerOptions"
                :selected="thirdTiebreaker"
              />
              <MDBBtn
                v-show="numTiebreakers == 3"
                class="mt-4"
                color="danger"
                @click="removeTiebreaker()"
              >
                <MDBIcon icon="times" iconStyle="fas" />
              </MDBBtn>
            </div>
            <div v-show="numTiebreakers >= 4" style="display: flex">
              <MDBSelect
                class="mt-4"
                label="Third Tiebreaker"
                ref="tiebreaker4"
                :options="fourthTiebreakerOptions"
                :selected="fourthTiebreaker"
              />
              <MDBBtn
                v-show="numTiebreakers == 4"
                class="mt-4"
                color="danger"
                @click="removeTiebreaker()"
              >
                <MDBIcon icon="times" iconStyle="fas" />
              </MDBBtn>
            </div>
            <div v-show="numTiebreakers >= 5" style="display: flex">
              <MDBSelect
                class="mt-4"
                label="Third Tiebreaker"
                ref="tiebreaker5"
                :options="fifthTiebreakerOptions"
                :selected="fifthTiebreaker"
              />
              <MDBBtn
                v-show="numTiebreakers == 5"
                class="mt-4"
                color="danger"
                @click="removeTiebreaker()"
              >
                <MDBIcon icon="times" iconStyle="fas" />
              </MDBBtn>
            </div>
            <MDBBtn
              v-show="numTiebreakers < 5"
              class="mt-4"
              color="info"
              @click="addTiebreaker()"
            >
              <MDBIcon icon="plus" iconStyle="fas" class="me-3" />Add Tiebreaker
            </MDBBtn>
            <!-- CUSTOM TIEBREAKERS -->
          </div>
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
  MDBDatepicker,
  MDBTimepicker,
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
    MDBDatepicker,
    MDBTimepicker,
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
    presetChange(e) {
      console.log(e);
      switch (this.preset) {
        case 2: //Chess
          console.log("here");
          this.winPoints = 1;
          this.drawPoints = 0.5;
          this.lossPoints = "0";
          this.gamesPerMatch = 1;
          this.numTiebreakers = 1;
          this.$refs.tiebreaker1.setOption(2);
          this.$refs.tiebreaker2.setOption(0);
          this.$refs.tiebreaker3.setOption(0);
          this.$refs.tiebreaker4.setOption(0);
          this.$refs.tiebreaker5.setOption(0);
          break;
        case 3: //FFTCG
          this.winPoints = 1;
          this.drawPoints = "0";
          this.lossPoints = "0";
          this.gamesPerMatch = 1;
          break;
        case 4: //MTG
          this.winPoints = 3;
          this.drawPoints = 1;
          this.lossPoints = "0";
          this.gamesPerMatch = 3;
          break;
      }
    },
    addTiebreaker() {
      this.numTiebreakers++;
    },
    removeTiebreaker() {
      this.numTiebreakers--;
    },
  },
  setup() {
    const playerRegistrationOn = ref(false);
    const playerResultsOn = ref(false);
    const infoModal = ref(false);
    const tournamentName = ref("");
    const gamesPerMatch = ref("1");
    const dateAndTime = ref("");
    const competitionType = ref("");
    const date = ref("");
    const time = ref("");
    const venue = ref("");
    const winPoints = ref("");
    const drawPoints = ref("");
    const lossPoints = ref("");
    const presetOptions = ref([
      { text: "", value: 1 },
      { text: "Chess", value: 2 },
      { text: "Final Fantasy Trading Card Game", value: 3 },
      { text: "Magic: the Gathering", value: 4 },
    ]);
    const preset = ref("");
    let numTiebreakers = ref(1);
    const firstTiebreakerOptions = ref([
      { text: "", value: 0 },
      { text: "OMW % / SOS", value: 1 },
      { text: "Median-Buchholz", value: 2 },
      { text: "GW %", value: 3 },
      { text: "OGW %", value: 4 },
      { text: "Custom A", value: 5 },
      { text: "Custom B", value: 6 },
    ]);
    const firstTiebreaker = ref("");
    const secondTiebreakerOptions = ref([
      { text: "", value: 0 },
      { text: "OMW % / SOS", value: 1 },
      { text: "Median-Buchholz", value: 2 },
      { text: "GW %", value: 3 },
      { text: "OGW %", value: 4 },
      { text: "Custom A", value: 5 },
      { text: "Custom B", value: 6 },
    ]);
    const secondTiebreaker = ref("");
    const thirdTiebreakerOptions = ref([
      { text: "", value: 0 },
      { text: "OMW % / SOS", value: 1 },
      { text: "Median-Buchholz", value: 2 },
      { text: "GW %", value: 3 },
      { text: "OGW %", value: 4 },
      { text: "Custom A", value: 5 },
      { text: "Custom B", value: 6 },
    ]);
    const thirdTiebreaker = ref("");
    const fourthTiebreakerOptions = ref([
      { text: "", value: 0 },
      { text: "OMW % / SOS", value: 1 },
      { text: "Median-Buchholz", value: 2 },
      { text: "GW %", value: 3 },
      { text: "OGW %", value: 4 },
      { text: "Custom A", value: 5 },
      { text: "Custom B", value: 6 },
    ]);
    const fourthTiebreaker = ref("");
    const fifthTiebreakerOptions = ref([
      { text: "", value: 0 },
      { text: "OMW % / SOS", value: 1 },
      { text: "Median-Buchholz", value: 2 },
      { text: "GW %", value: 3 },
      { text: "OGW %", value: 4 },
      { text: "Custom A", value: 5 },
      { text: "Custom B", value: 6 },
    ]);
    const fifthTiebreaker = ref("");

    return {
      playerRegistrationOn,
      playerResultsOn,
      infoModal,
      tournamentName,
      gamesPerMatch,
      dateAndTime,
      competitionType,
      venue,
      date,
      time,
      winPoints,
      lossPoints,
      drawPoints,
      presetOptions,
      preset,
      numTiebreakers,
      firstTiebreakerOptions,
      firstTiebreaker,
      secondTiebreaker,
      secondTiebreakerOptions,
      thirdTiebreaker,
      thirdTiebreakerOptions,
      fourthTiebreakerOptions,
      fourthTiebreaker,
      fifthTiebreakerOptions,
      fifthTiebreaker,
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