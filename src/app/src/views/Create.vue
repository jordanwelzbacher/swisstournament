<template>
  <main class="mt-4">
    <MDBContainer>
      <h1 class="mb-4" style="text-align: center">Create Tournament</h1>
      <!-- BASIC INFORMATION -->
      <MDBRow>
        <MDBCol>
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
              formText="Examples: Chess, Shuffleboard, Magic: The Gathering"
            />
            <div class="mt-4">
              Display competitors by:
              <br />
              <MDBRadio
                label="Username"
                value="false"
                v-model="isUseFirstLast"
                inline
                name="isUseFirstLast"
              />
              <MDBRadio
                label="Full Name"
                value="true"
                v-model="isUseFirstLast"
                inline
                name="isUseFirstLast"
              />
            </div>
            <hr class="my-4" />
            <MDBDatepicker
              class="mt-4"
              v-model="date"
              label="Tournament Date"
              format="YYYY-MM-DD"
            />
            <MDBTimepicker
              class="mt-4"
              label="Tournament Time"
              v-model="time"
            />
            <MDBInput
              class="mt-4"
              label="Venue"
              v-model="venue"
              formText="Optional"
            />
            <hr class="my-4" />
            <div class="d-inline-block">
              <MDBCheckbox
                label="Enable Player Registration"
                v-model="playerRegistrationOn"
              />
            </div>
            <div class="d-inline-block">
              <MDBIcon
                @click="showModal('userRegistration')"
                class="ms-2 helpIcon"
                icon="info-circle"
                iconStyle="fas"
              />
            </div>

            <div v-show="playerRegistrationOn" class="mt-4">
              <MDBInput
                label="Registration Closes"
                class="mt-4"
                v-model="registrationCloseTime"
                type="number"
              />
            </div>
            <div v-show="playerRegistrationOn" class="mt-1">
              <MDBRadio
                inline
                label="Minutes"
                name="registrationCloseFormat"
                v-model="registrationCloseFormat"
                value="minutes"
              />
              <MDBRadio
                inline
                label="Hours Before Start"
                name="registrationCloseFormat"
                v-model="registrationCloseFormat"
                value="hours"
              />
            </div>
            <div v-show="playerRegistrationOn" class="mt-1">
              <MDBInput
                label="Player Limit"
                class="mt-4"
                v-model="playerLimit"
                type="number"
                formText="Optional"
              />
            </div>
            <div></div>
            <div class="my-4 d-inline-block">
              <MDBCheckbox
                label="Enable Player-Submitted Results"
                v-model="playerResultsOn"
              />
            </div>
            <div class="d-inline-block">
              <MDBIcon
                @click="showModal('userResults')"
                class="ms-2 helpIcon"
                icon="info-circle"
                iconStyle="fas"
              />
            </div>
          </div>
        </MDBCol>
        <!-- SCORING & TIEBREAKERS -->
        <MDBCol>
          <h4 class="mb-4">Scoring & Tiebreakers</h4>
          <div class="m-4">
            <MDBSelect
              label="Select Preset (Optional)"
              ref="presetSelect"
              v-model:options="presetOptions"
              v-model:selected="preset"
              @change="presetChange()"
            />
            <hr class="my-4" />
            <MDBInput
              class="mt-4"
              v-model="winPoints"
              label="Match Win Points"
              type="number"
              :disabled="preset != 0"
            />
            <MDBInput
              ref="mdp"
              class="mt-4"
              v-model="drawPoints"
              label="Match Draw Points"
              type="number"
              :disabled="preset != 0"
            />
            <MDBInput
              ref="mlp"
              class="mt-4"
              v-model="lossPoints"
              label="Match Loss Points"
              type="number"
              :disabled="preset != 0"
            />
            <MDBInput
              class="mt-4"
              type="number"
              label="Games Per Match"
              v-model="gamesPerMatch"
              :disabled="preset != 0"
            />
            <hr class="my-4" />
            <!-- TIEBREAKERS -->
            <MDBSelect
              label="First Tiebreaker"
              ref="tiebreaker1"
              v-model:options="firstTiebreakerOptions"
              v-model:selected="firstTiebreaker"
              :disabled="preset != 0"
            />
            <div
              class="mt-4"
              v-show="numTiebreakers >= 2"
              style="display: flex"
            >
              <MDBSelect
                label="Second Tiebreaker"
                ref="tiebreaker2"
                v-model:options="secondTiebreakerOptions"
                v-model:selected="secondTiebreaker"
                :disabled="preset != 0"
                style="width: calc(100% - 55px)"
              />
              <div class="d-inline-block">
                <MDBBtn
                  v-show="numTiebreakers == 2"
                  color="danger"
                  @click="removeTiebreaker()"
                  :disabled="preset != 0"
                >
                  <MDBIcon icon="times" iconStyle="fas" />
                </MDBBtn>
              </div>
            </div>
            <div
              class="mt-4"
              v-show="numTiebreakers >= 3"
              style="display: flex"
            >
              <MDBSelect
                label="Third Tiebreaker"
                ref="tiebreaker3"
                v-model:options="thirdTiebreakerOptions"
                v-model:selected="thirdTiebreaker"
                :disabled="preset != 0"
                style="width: calc(100% - 55px)"
              />
              <MDBBtn
                v-show="numTiebreakers == 3"
                color="danger"
                @click="removeTiebreaker()"
                :disabled="preset != 0"
              >
                <MDBIcon icon="times" iconStyle="fas" />
              </MDBBtn>
            </div>
            <div
              class="mt-4"
              v-show="numTiebreakers >= 4"
              style="display: flex"
            >
              <MDBSelect
                label="Fourth Tiebreaker"
                ref="tiebreaker4"
                v-model:options="fourthTiebreakerOptions"
                v-model:selected="fourthTiebreaker"
                :disabled="preset != 0"
                style="width: calc(100% - 55px)"
              />
              <MDBBtn
                v-show="numTiebreakers == 4"
                color="danger"
                @click="removeTiebreaker()"
                :disabled="preset != 0"
              >
                <MDBIcon icon="times" iconStyle="fas" />
              </MDBBtn>
            </div>
            <div
              class="mt-4"
              v-show="numTiebreakers >= 5"
              style="display: flex"
            >
              <MDBSelect
                label="Fifth Tiebreaker"
                ref="tiebreaker5"
                v-model:options="fifthTiebreakerOptions"
                v-model:selected="fifthTiebreaker"
                :disabled="preset != 0"
                style="width: calc(100% - 55px)"
              />
              <MDBBtn
                v-show="numTiebreakers == 5"
                color="danger"
                @click="removeTiebreaker()"
                :disabled="preset != 0"
              >
                <MDBIcon icon="times" iconStyle="fas" />
              </MDBBtn>
            </div>
            <MDBBtn
              v-show="numTiebreakers < 5"
              class="mt-4"
              color="info"
              @click="addTiebreaker()"
              :disabled="preset != 0"
            >
              <MDBIcon icon="plus" iconStyle="fas" class="me-3" />Add Tiebreaker
            </MDBBtn>
            <!-- CUSTOM TIEBREAKERS -->
            <div
              v-show="
                firstTiebreaker == CUSTOM_A ||
                secondTiebreaker == CUSTOM_A ||
                thirdTiebreaker == CUSTOM_A ||
                fourthTiebreaker == CUSTOM_A ||
                fifthTiebreaker == CUSTOM_A
              "
            >
              <MDBInput
                class="mt-4"
                label="Custom Tiebreaker A Name"
                v-model="customAName"
                :disabled="preset != 0"
              />
              <div class="ms-4 mt-2">
                <MDBCheckbox
                  label="Lower Is Better"
                  v-model="customALowerIsBetter"
                  :disabled="preset != 0"
                />
              </div>
            </div>
            <div
              v-show="
                firstTiebreaker == CUSTOM_B ||
                secondTiebreaker == CUSTOM_B ||
                thirdTiebreaker == CUSTOM_B ||
                fourthTiebreaker == CUSTOM_B ||
                fifthTiebreaker == CUSTOM_B
              "
            >
              <MDBInput
                class="mt-4"
                label="Custom Tiebreaker B Name"
                v-model="customBName"
                :disabled="preset != 0"
              />
              <div class="ms-4 mt-2">
                <MDBCheckbox
                  label="Lower Is Better"
                  v-model="customBLowerIsBetter"
                  :disabled="preset != 0"
                />
              </div>
            </div>
          </div>
        </MDBCol>
      </MDBRow>
      <MDBRow>
        <MDBCol>
          <div class="my-4" style="text-align: center">
            <MDBBtn size="lg" color="primary" @click="submitTournament()">
              Create Tournament
            </MDBBtn>
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
import http from "../http-common";

const CHESS = 1;
const FFTCG = 2;
const MTG = 3;

const NONE = 0;
const OMWP = 1;
const MEDIAN_BUCHHOLZ = 2;
const GWP = 3;
const OGWP = 4;
const CUSTOM_A = 5;
const CUSTOM_B = 6;

const TIEBREAKERS = [
  { text: "", value: NONE },
  { text: "OMW % / SOS", value: OMWP },
  { text: "Median-Buchholz", value: MEDIAN_BUCHHOLZ },
  { text: "GW %", value: GWP },
  { text: "OGW %", value: OGWP },
  { text: "Custom A", value: CUSTOM_A },
  { text: "Custom B", value: CUSTOM_B },
];

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
  MDBRadio,
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
    MDBRadio,
  },
  data() {
    return {
      modalHeaderText: "",
      modalBodyText: "",
    };
  },
  methods: {
    showModal(e) {
      console.log(this.isUseFirstLast);
      switch (e) {
        case "userRegistration":
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
    presetChange() {
      switch (this.preset) {
        case CHESS:
          this.winPoints = 1;
          this.drawPoints = 0.5;
          this.lossPoints = "0";
          this.gamesPerMatch = 1;
          this.numTiebreakers = 1;
          this.$refs.tiebreaker1.setOption(MEDIAN_BUCHHOLZ);
          this.$refs.tiebreaker2.setOption(NONE);
          this.$refs.tiebreaker3.setOption(NONE);
          this.$refs.tiebreaker4.setOption(NONE);
          this.$refs.tiebreaker5.setOption(NONE);
          break;
        case FFTCG:
          this.winPoints = 1;
          this.drawPoints = "0";
          this.lossPoints = "0";
          this.gamesPerMatch = 1;
          this.numTiebreakers = 3;
          this.$refs.tiebreaker1.setOption(OMWP);
          this.$refs.tiebreaker2.setOption(CUSTOM_A);
          this.$refs.tiebreaker3.setOption(CUSTOM_B);
          this.$refs.tiebreaker4.setOption(NONE);
          this.$refs.tiebreaker5.setOption(NONE);
          this.customAName = "Damage Dealt";
          this.customBName = "Damage Received";
          this.customALowerIsBetter = false;
          this.customBLowerIsBetter = true;
          break;
        case MTG:
          this.winPoints = 3;
          this.drawPoints = 1;
          this.lossPoints = "0";
          this.gamesPerMatch = 3;
          this.numTiebreakers = 3;
          this.$refs.tiebreaker1.setOption(OMWP);
          this.$refs.tiebreaker2.setOption(GWP);
          this.$refs.tiebreaker3.setOption(OGWP);
          this.$refs.tiebreaker4.setOption(NONE);
          this.$refs.tiebreaker5.setOption(NONE);
          break;
      }
    },
    addTiebreaker() {
      this.numTiebreakers++;
    },
    removeTiebreaker() {
      this.numTiebreakers--;
      if (this.numTiebreakers < 5) this.$refs.tiebreaker5.setOption(NONE);
      if (this.numTiebreakers < 4) this.$refs.tiebreaker4.setOption(NONE);
      if (this.numTiebreakers < 3) this.$refs.tiebreaker3.setOption(NONE);
      if (this.numTiebreakers < 2) this.$refs.tiebreaker2.setOption(NONE);
    },
    submitTournament() {
      console.log(
        "Not sending the date: " +
          this.date +
          " " +
          this.time +
          " " +
          Intl.DateTimeFormat().resolvedOptions().timeZone
      );
      http
        .post("/protected/tournament", {
          tournament_name: this.tournamentName,
          owner_user_id: "admin", // TODO
          competition_type: this.competitionType,
          // tournament_date: this.date + " " + this.time + " " + Intl.DateTimeFormat().resolvedOptions().timeZone,
          venue: this.venue,
          is_player_registration_on: this.playerRegistrationOn,
          is_player_results_on: this.playerResultsOn,
          player_limit: this.playerLimit,
          win_points: this.winPoints,
          loss_points: this.lossPoints,
          draw_points: this.drawPoints,
          first_tiebreaker: this.firstTiebreaker,
          second_tiebreaker: this.secondTiebreaker,
          third_tiebreaker: this.thirdTiebreaker,
          fourth_tiebreaker: this.fourthTiebreaker,
          fifth_tiebreaker: this.fifthTiebreaker,
          custom_a_name: this.customAName,
          custom_b_name: this.customBName,
          is_lower_better_for_custom_a: this.customALowerIsBetter,
          is_lower_better_for_custom_b: this.customBLowerIsBetter,
          is_use_first_last: this.isUseFirstLast,
          //created_date: [timestamp] TODO
        })
        .then((response) => {
          console.log(response.data);
        })
        .catch((e) => {
          console.log(e);
        });
    },
  },
  setup() {
    const CHESS = 1;
    const FFTCG = 2;
    const MTG = 3;

    const NONE = 0;
    const OMWP = 1;
    const MEDIAN_BUCHHOLZ = 2;
    const GWP = 3;
    const OGWP = 4;
    const CUSTOM_A = 5;
    const CUSTOM_B = 6;

    const playerRegistrationOn = ref(false);
    const playerResultsOn = ref(false);
    const infoModal = ref(false);
    const tournamentName = ref("");
    const gamesPerMatch = ref("1");
    const competitionType = ref("");
    const isUseFirstLast = ref(false);
    const date = ref("");
    const time = ref("");
    const registrationCloseTime = ref("10");
    const registrationCloseFormat = ref("minutes");
    const venue = ref("");
    const playerLimit = ref("");
    const winPoints = ref("");
    const drawPoints = ref("");
    const lossPoints = ref("");
    const presetOptions = ref([
      { text: "None", value: 0 },
      { text: "Chess", value: CHESS },
      { text: "Final Fantasy Trading Card Game", value: FFTCG },
      { text: "Magic: the Gathering", value: MTG },
    ]);
    const preset = ref("");
    let numTiebreakers = ref(1);
    const firstTiebreakerOptions = ref(JSON.parse(JSON.stringify(TIEBREAKERS)));
    const firstTiebreaker = ref("");
    const secondTiebreakerOptions = ref(
      JSON.parse(JSON.stringify(TIEBREAKERS))
    );
    const secondTiebreaker = ref("");
    const thirdTiebreakerOptions = ref(JSON.parse(JSON.stringify(TIEBREAKERS)));
    const thirdTiebreaker = ref("");
    const fourthTiebreakerOptions = ref(
      JSON.parse(JSON.stringify(TIEBREAKERS))
    );
    const fourthTiebreaker = ref("");
    const fifthTiebreakerOptions = ref(JSON.parse(JSON.stringify(TIEBREAKERS)));
    const fifthTiebreaker = ref("");
    const customAName = ref("");
    const customBName = ref("");
    const customALowerIsBetter = ref(false);
    const customBLowerIsBetter = ref(false);

    return {
      playerRegistrationOn,
      playerResultsOn,
      infoModal,
      tournamentName,
      gamesPerMatch,
      competitionType,
      isUseFirstLast,
      venue,
      date,
      time,
      registrationCloseTime,
      registrationCloseFormat,
      playerLimit,
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
      customAName,
      customBName,
      customALowerIsBetter,
      customBLowerIsBetter,
      CHESS,
      FFTCG,
      MTG,
      NONE,
      OMWP,
      MEDIAN_BUCHHOLZ,
      GWP,
      OGWP,
      CUSTOM_A,
      CUSTOM_B,
    };
  },
};
</script>

<style lang="scss" scoped>
.helpIcon {
  cursor: help;
}
.helpIcon:hover {
  color: darkblue;
}
</style>
