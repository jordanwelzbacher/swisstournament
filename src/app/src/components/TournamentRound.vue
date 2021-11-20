<template>
  <MDBContainer>
    {{data}}
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
              <th scope="col">{{ selectedPairing.firstPlayer }}</th>
              <th scope="col">{{ selectedPairing.secondPlayer }}</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>
                Match Result:
                <MDBSelect
                  ref="select1"
                  v-model:options="matchResultFirst"
                  v-model:selected="firstPlayerResult"
                />
              </td>
              <td>
                Match Result:
                <MDBSelect
                  ref="tiebreaker1"
                  v-model:options="matchResultSecond"
                  v-model:selected="secondPlayerResult"
                />
              </td>
            </tr>
            <tr v-if="data.tournament.gamesPerMatch > 1">
              <td>
                Game Wins:
                <MDBInput v-model="gamewinsFirstPlayer" />
              </td>
              <td>
                Game Wins:
                <MDBInput v-model="gamewinsSecondPlayer" />
              </td>
            </tr>
            <tr v-if="usingFirstCustomTiebreaker">
              <td>
                {{ data.tournament.firstCustomTiebreakerName }}:
                <MDBInput v-model="firstCustomTiebreakerFirstPlayer" />
              </td>
              <td>
                {{ data.tournament.firstCustomTiebreakerName }}:
                <MDBInput v-model="firstCustomTiebreakerSecondPlayer" />
              </td>
            </tr>
            <tr v-if="usingSecondCustomTiebreaker">
              <td>
                {{ data.tournament.secondCustomTiebreakerName }}:
                <MDBInput v-model="secondCustomTiebreakerFirstPlayer" />
              </td>
              <td>
                {{ data.tournament.secondCustomTiebreakerName }}:
                <MDBInput v-model="secondCustomTiebreakerSecondPlayer" />
              </td>
            </tr>
          </tbody>
        </MDBTable>
      </MDBModalBody>
      <MDBModalFooter>
        <MDBBtn color="secondary" @click="resultModal = false">Close</MDBBtn>
        <MDBBtn color="primary">Save changes</MDBBtn>
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
  methods: {
    toggleModal(e) {
      this.selectedPairing = this.dataset.rows[e];
      console.log(this.selectedPairing)
      this.resultModal = true;

      this.matchResultFirst.forEach((possibleResult) => {
        possibleResult.selected = false;
        if (possibleResult.value == this.selectedPairing.matchResultFirstPlayer)
          possibleResult.selected = true;
      });
      
      this.matchResultSecond.forEach((possibleResult) => {
        possibleResult.selected = false;
        if (possibleResult.value == this.selectedPairing.matchResultSecondPlayer)
          possibleResult.selected = true;
      });
    },
  },
  setup(props) {
    const input = ref("");
    const searchPhrase = ref("");
    const searchColumns = ref(["tableNumber", "firstPlayer", "secondPlayer"]);
    const selectedPairing = ref("");

    const resultModal = ref(false);

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

    const firstCustomTiebreakerFirstPlayer = ref("");
    const firstCustomTiebreakerSecondPlayer = ref("");
    const secondCustomTiebreakerFirstPlayer = ref("");
    const secondCustomTiebreakerSecondPlayer = ref("");

    const dataset = computed(() => {
      console.log(props.data.table)
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
      searchPhrase,
      searchColumns,
      resultModal,
      selectedPairing,
      firstPlayerResult,
      secondPlayerResult,
      matchResultFirst,
      matchResultSecond,
      usingFirstCustomTiebreaker,
      usingSecondCustomTiebreaker,
      firstCustomTiebreakerFirstPlayer,
      firstCustomTiebreakerSecondPlayer,
      secondCustomTiebreakerFirstPlayer,
      secondCustomTiebreakerSecondPlayer,
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
</style>