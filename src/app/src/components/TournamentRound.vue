<template>
  <MDBContainer>
    <div class="my-4" style="max-width: 400px">
      <MDBInput :value="input" @input="search" label="Search Table or Player" />
    </div>
    <MDBDatatable
      :dataset="dataset"
      sortField="tableNumber"
      sortOrder="asc"
      clickableRows
      @row-click="toggleModal"
      :entries="64"
      :entriesOptions="[8, 16, 32, 64, 128, 256]"
      noFoundMessage="No rounds created yet"
      :search="searchPhrase"
      :searchColumns="searchColumns"
    />

    <MDBModal
      id="resultModal"
      tabindex="-1"
      labelledby="resultModalLabel"
      v-model="resultModal"
    >
      <MDBModalHeader>
        <MDBModalTitle id="resultModalLabel"
          >Table {{ selectedPairing.tableNumber }}</MDBModalTitle
        >
      </MDBModalHeader>
      <MDBModalBody>
        <MDBTable borderless>
          <thead>
            <tr>
              <th scope="col">
                <h5>{{ selectedPairing.firstPlayer }}</h5>
              </th>
              <th scope="col">
                <h5>{{ selectedPairing.secondPlayer }}</h5>
              </th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>
                Match Result:
                <MDBSelect
                  :disabled="!userCanEdit"
                  ref="select1"
                  v-model:options="matchResultFirst"
                  v-model:selected="firstPlayerResult"
                />
              </td>
              <td>
                Match Result:
                <MDBSelect
                  :disabled="!userCanEdit"
                  ref="tiebreaker1"
                  v-model:options="matchResultSecond"
                  v-model:selected="secondPlayerResult"
                />
              </td>
            </tr>
            <tr v-if="data.tournament.gamesPerMatch > 1">
              <td>
                Game Wins:
                <MDBInput
                  :disabled="!userCanEdit"
                  type="number"
                  v-model="gameWinsFirstPlayer"
                />
              </td>
              <td>
                Game Wins:
                <MDBInput
                  :disabled="!userCanEdit"
                  type="number"
                  v-model="gameWinsSecondPlayer"
                />
              </td>
            </tr>
            <tr v-if="data.tournament.gamesPerMatch > 1">
              <td class="draws text-center" colspan="2">
                Game Draws:
                <MDBInput
                  :disabled="!userCanEdit"
                  type="number"
                  v-model="gameDraws"
                />
              </td>
            </tr>
            <tr v-if="usingFirstCustomTiebreaker">
              <td>
                {{ data.tournament.firstCustomTiebreakerName }}:
                <MDBInput
                  :disabled="!userCanEdit"
                  type="number"
                  v-model="firstCustomFirstPlayer"
                />
              </td>
              <td>
                {{ data.tournament.firstCustomTiebreakerName }}:
                <MDBInput
                  :disabled="!userCanEdit"
                  type="number"
                  v-model="firstCustomSecondPlayer"
                />
              </td>
            </tr>
            <tr v-if="usingSecondCustomTiebreaker">
              <td>
                {{ data.tournament.secondCustomTiebreakerName }}:
                <MDBInput
                  :disabled="!userCanEdit"
                  type="number"
                  v-model="secondCustomFirstPlayer"
                />
              </td>
              <td>
                {{ data.tournament.secondCustomTiebreakerName }}:
                <MDBInput
                  :disabled="!userCanEdit"
                  type="number"
                  v-model="secondCustomSecondPlayer"
                />
              </td>
            </tr>
          </tbody>
        </MDBTable>
      </MDBModalBody>
      <MDBModalFooter>
        <MDBBtn color="secondary" @click="resultModal = false">Close</MDBBtn>
        <MDBBtn v-if="userCanEdit" @click="submitResult" color="primary">Save changes</MDBBtn>
      </MDBModalFooter>
    </MDBModal>
  </MDBContainer>
</template>

<script>
import {
  MDBContainer,
  MDBDatatable,
  MDBInput,
  MDBModal,
  MDBModalHeader,
  MDBModalTitle,
  MDBModalBody,
  MDBModalFooter,
  MDBBtn,
  MDBSelect,
  MDBTable,
} from "mdb-vue-ui-kit";
import { computed } from "vue";
import { ref } from "vue";
import Constants from "@/constants/constants.js";
import { mapGetters } from "vuex";
import store from "@/store";

export default {
  name: "TournamentRound",
  props: ["data"],
  components: {
    MDBContainer,
    MDBDatatable,
    MDBInput,
    MDBModal,
    MDBModalHeader,
    MDBModalTitle,
    MDBModalBody,
    MDBModalFooter,
    MDBBtn,
    MDBSelect,
    MDBTable,
  },
  computed: {
    ...mapGetters({
      user: "auth/user",
    }),
  },
  methods: {
    toggleModal(e) {
      this.selectedPairing = this.dataset.rows[e];
      console.log(this.selectedPairing);
      this.resultModal = true;

      this.userCanEdit = this.canEdit(this.selectedPairing);

      this.matchResultFirst.forEach((possibleResult) => {
        possibleResult.selected = false;
        if (possibleResult.value == this.selectedPairing.matchResultFirstPlayer)
          possibleResult.selected = true;
      });

      this.matchResultSecond.forEach((possibleResult) => {
        possibleResult.selected = false;
        if (
          possibleResult.value == this.selectedPairing.matchResultSecondPlayer
        )
          possibleResult.selected = true;
      });

      this.gameWinsFirstPlayer = this.selectedPairing.gameWinsFirstPlayer;
      this.gameWinsSecondPlayer = this.selectedPairing.gameWinsSecondPlayer;
      this.gameDraws = this.selectedPairing.gameDrawsFirstPlayer;

      this.firstCustomFirstPlayer = this.selectedPairing.firstCustomFirstPlayer;
      this.firstCustomSecondPlayer = this.selectedPairing.firstCustomSecondPlayer;

      this.secondCustomFirstPlayer = this.selectedPairing.secondCustomFirstPlayer;
      this.secondCustomSecondPlayer = this.selectedPairing.secondCustomSecondPlayer;
    },
    canEdit(pairing) {
      //if not logged in, or tournament is completed, can't edit
      if (!store.getters["auth/user"] || this.data.tournament.completed) return false;
      //if admin or owner, can edit
      if (this.data.isAdmin || this.data.isOwner) return true;
      //if pairing already has results, can't edit
      if (pairing.matchResultFirstPlayer) return false;
      //if user is a player in the selected pairing, they can edit
      let userId = store.getters["auth/user"].id
      return pairing.firstPlayerId == userId || pairing.secondPlayerId == userId
    },
  },
  setup(props) {
    const input = ref("");
    const searchPhrase = ref("");
    const searchColumns = ref(["tableNumber", "firstPlayer", "secondPlayer"]);
    const selectedPairing = ref("");

    const resultModal = ref(false);

    const userCanEdit = ref(false);

    const search = (event) => {
      searchPhrase.value = event.target.value;
    };

    const matchResultFirst = ref([
      { text: "", value: "", selected: true },
      { text: "Win", value: "WIN", selected: false },
      { text: "Loss", value: "LOSS", selected: false },
      { text: "Draw", value: "DRAW", selected: false },
    ]);
    const matchResultSecond = ref([
      { text: "", value: "", selected: true },
      { text: "Win", value: "WIN", selected: false },
      { text: "Loss", value: "LOSS", selected: false },
      { text: "Draw", value: "DRAW", selected: false },
    ]);
    const firstPlayerResult = ref("");
    const secondPlayerResult = ref("");

    const gameWinsFirstPlayer = ref("");
    const gameWinsSecondPlayer = ref("");

    const gameDraws = ref("");

    const firstCustomFirstPlayer = ref("");
    const firstCustomSecondPlayer = ref("");
    const secondCustomFirstPlayer = ref("");
    const secondCustomSecondPlayer = ref("");

    const dataset = computed(() => {
      console.log(props.data.table);
      return props.data.table;
    });

    const usingFirstCustomTiebreaker = computed(() => {
      if (props.data.tournament.firstTiebreaker == Constants.FIRST_CUSTOM)
        return true;
      if (props.data.tournament.secondTiebreaker == Constants.FIRST_CUSTOM)
        return true;
      if (props.data.tournament.thirdTiebreaker == Constants.FIRST_CUSTOM)
        return true;
      if (props.data.tournament.fourthTiebreaker == Constants.FIRST_CUSTOM)
        return true;
      if (props.data.tournament.fifthTiebreaker == Constants.FIRST_CUSTOM)
        return true;
      return false;
    });

    const usingSecondCustomTiebreaker = computed(() => {
      if (props.data.tournament.firstTiebreaker == Constants.SECOND_CUSTOM)
        return true;
      if (props.data.tournament.secondTiebreaker == Constants.SECOND_CUSTOM)
        return true;
      if (props.data.tournament.thirdTiebreaker == Constants.SECOND_CUSTOM)
        return true;
      if (props.data.tournament.fourthTiebreaker == Constants.SECOND_CUSTOM)
        return true;
      if (props.data.tournament.fifthTiebreaker == Constants.SECOND_CUSTOM)
        return true;
      return false;
    });

    return {
      dataset,
      search,
      input,
      userCanEdit,
      searchPhrase,
      searchColumns,
      resultModal,
      selectedPairing,
      firstPlayerResult,
      secondPlayerResult,
      matchResultFirst,
      matchResultSecond,
      gameWinsFirstPlayer,
      gameWinsSecondPlayer,
      gameDraws,
      usingFirstCustomTiebreaker,
      usingSecondCustomTiebreaker,
      firstCustomFirstPlayer,
      firstCustomSecondPlayer,
      secondCustomFirstPlayer,
      secondCustomSecondPlayer,
    };
  },
};
</script>

<style scoped>
th:nth-child(2) {
  display: flex;
  flex-direction: column;
  align-items: flex-end;
}

td:nth-child(2) {
  display: flex;
  flex-direction: column;
  align-items: flex-end;
}

.draws {
  padding-left: 30%;
  padding-right: 30%;
}
</style>