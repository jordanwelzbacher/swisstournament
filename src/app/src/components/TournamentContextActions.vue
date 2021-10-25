<template>
  <main>
    <MDBContainer>
      <div class="mt-4 text-center button-container">
        <MDBBtn color="success">
          Join Event<MDBIcon icon="sign-in-alt" size="lg" />
        </MDBBtn>
        <MDBBtn color="danger">
          Leave Event<MDBIcon icon="sign-out-alt" size="lg" />
        </MDBBtn>
        <MDBBtn color="primary">
          Add Player<MDBIcon icon="user-plus" size="lg" />
        </MDBBtn>
        <MDBBtn color="secondary">
          Edit Event<MDBIcon icon="edit" size="lg" />
        </MDBBtn>
        <MDBBtn @click="isShowAdvanced = !isShowAdvanced" color="info">
          Advanced Options
          <MDBIcon v-show="!isShowAdvanced" icon="chevron-up" size="lg" />
          <MDBIcon v-show="isShowAdvanced" icon="chevron-down" size="lg" />
        </MDBBtn>
      </div>
      <div class="my-4">
        <MDBCollapse
          id="advanced"
          v-model="isShowAdvanced"
          ><div class="text-center button-container">
            <MDBBtn outline="dark" @click="showNextRoundModal()">
              Create Round<MDBIcon
                icon="plus-square"
                size="lg"

              />
            </MDBBtn>
            <MDBBtn outline="primary">
              Add Admin<MDBIcon
                icon="user-shield"
                size="lg"
              />
            </MDBBtn>
            <MDBBtn outline="warning">
              Kick All Pending<MDBIcon
                icon="user-times"
                size="lg"
              />
            </MDBBtn>
            <MDBBtn outline="danger">
              Delete Tournament<MDBIcon
                icon="trash"
                size="lg"
              />
            </MDBBtn>
          </div>
          <div class="outerBox" style="display: flex; justify-content: center">
            <div style="display: flex; justify-content: center">
              <div class="next-round-container"></div>
            </div>
          </div>
        </MDBCollapse>
      </div>
    </MDBContainer>
    <MDBModal
      id="roundModal"
      tabindex="-1"
      labelledby="roundModalLabel"
      v-model="roundModal"
    >
      <MDBModalHeader>
        <MDBModalTitle id="roundModalLabel">
          Create Next Round
        </MDBModalTitle>
      </MDBModalHeader>
      <MDBModalBody>
        <div class="next-round-container">
        <div>
          <MDBRadio
            label="Swiss Round"
            name="nextRoundType"
            v-model="nextRoundType"
            value="swiss"
          />
          <MDBRadio
            label="Top Cut Round"
            name="nextRoundType"
            v-model="nextRoundType"
            value="topCut"
          />
        </div>
        <div>
          <MDBSelect
            v-model:options="countTopPlayers"
            v-model:selected="isCutTopPlayers"
            :disabled="nextRoundType=='swiss'"
            label="Cut to Top:"
          />
        </div>
        <div style="text-align: center">
          <MDBBtn color="success">Create<MDBIcon icon="th-list" size="lg" /></MDBBtn>
        </div>
        </div>
      </MDBModalBody>
      <MDBModalFooter>
        <MDBBtn color="secondary" @click="roundModal = false">Close</MDBBtn>
      </MDBModalFooter>
    </MDBModal>
  </main>
</template>

<script>
import {
  MDBContainer,
  MDBBtn,
  MDBCollapse,
  MDBIcon,
  MDBRadio,
  MDBSelect,
  MDBModal,
  MDBModalHeader,
  MDBModalTitle,
  MDBModalBody,
  MDBModalFooter,
} from "mdb-vue-ui-kit";
import { ref } from "vue";

export default {
  name: "TournamentContextActions",
  components: {
    MDBContainer,
    MDBBtn,
    MDBCollapse,
    MDBIcon,
    MDBRadio,
    MDBSelect,
    MDBModal,
    MDBModalHeader,
    MDBModalTitle,
    MDBModalBody,
    MDBModalFooter,
  },
  methods: {
    showNextRoundModal() {
      this.roundModal = true;
    },
  },
  setup() {
    const isShowAdvanced = ref(false);
    const countTopPlayers = ref([
      { text: "", value: null },
      { text: "2", value: 2 },
      { text: "4", value: 4 },
      { text: "8", value: 8 },
      { text: "16", value: 16 },
      { text: "32", value: 32 },
      { text: "64", value: 64 },
      { text: "128", value: 128 },
      { text: "256", value: 256 },
    ]);
    const nextRoundType = ref('swiss');
    const roundModal = ref(false);
    return {
      isShowAdvanced,
      nextRoundType,
      countTopPlayers,
      roundModal,
    };
  },
};
</script>

<style scoped>
.button-container > * {
  margin-right: 2em;
}
.next-round-container > * {
  margin-bottom: 1.5em;
}
i {
  padding-left: 1em;
}
</style>