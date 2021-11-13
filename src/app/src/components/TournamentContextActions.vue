<template>
  <main class="mt-4">
    {{ data }}
    <MDBContainer>
      <div class="text-center button-container">
        <MDBBtn
          color="success"
          v-if="
            !data.inTourney &&
            data.playerRegistrationOn &&
            data.registrationOpen &&
            !data.completed
          "
        >
          Join Event<MDBIcon icon="sign-in-alt" size="lg" />
        </MDBBtn>
        <MDBBtn
          v-if="data.inTourney && countRounds < 1 && !data.completed"
          color="danger"
        >
          Leave Event<MDBIcon icon="sign-out-alt" size="lg" />
        </MDBBtn>
        <MDBBtn
          v-if="(data.isOwner || data.isAdmin) && !data.completed"
          color="primary"
        >
          Add Player<MDBIcon icon="user-plus" size="lg" />
        </MDBBtn>
        <MDBBtn v-if="data.isOwner && !data.completed" color="secondary">
          Edit Event<MDBIcon icon="edit" size="lg" />
        </MDBBtn>
        <MDBBtn
          v-if="data.isOwner || data.isAdmin"
          @click="isShowAdvanced = !isShowAdvanced"
          color="info"
        >
          Advanced Options
          <MDBIcon v-show="!isShowAdvanced" icon="chevron-up" size="lg" />
          <MDBIcon v-show="isShowAdvanced" icon="chevron-down" size="lg" />
        </MDBBtn>
      </div>
      <div>
        <MDBCollapse id="advanced" v-model="isShowAdvanced"
          ><div class="text-center button-container">
            <MDBBtn
              v-if="(data.isOwner || data.isAdmin) && !data.completed"
              outline="dark"
              @click="showNextRoundModal()"
            >
              Create Round<MDBIcon icon="plus-square" size="lg" />
            </MDBBtn>
            <MDBBtn
              v-if="(data.isOwner || data.isAdmin) && !data.completed"
              outline="primary"
              @click="showAddAdminModal()"
            >
              Add Admin<MDBIcon icon="user-shield" size="lg" />
            </MDBBtn>
            <MDBBtn
              v-if="
                (data.isOwner || data.isAdmin) &&
                data.countRounds < 1 &&
                !data.completed
              "
              outline="warning"
            >
              Kick All Pending<MDBIcon icon="user-times" size="lg" />
            </MDBBtn>
            <MDBBtn
              v-if="data.isOwner && data.countRounds > 0 && !data.completed"
              outline="success"
            >
              Finish Tournament<MDBIcon icon="trophy" size="lg" />
            </MDBBtn>
            <MDBBtn v-if="data.isOwner" outline="danger">
              Delete Tournament<MDBIcon icon="trash" size="lg" />
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
        <MDBModalTitle id="roundModalLabel"> Create Next Round </MDBModalTitle>
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
              :disabled="nextRoundType == 'swiss'"
              label="Cut to Top:"
            />
          </div>
          <div style="text-align: center">
            <MDBBtn color="success"
              >Create<MDBIcon icon="th-list" size="lg"
            /></MDBBtn>
          </div>
        </div>
      </MDBModalBody>
      <MDBModalFooter>
        <MDBBtn color="secondary" @click="roundModal = false">Close</MDBBtn>
      </MDBModalFooter>
    </MDBModal>

    <MDBModal
      id="adminModal"
      tabindex="-1"
      labelledby="adminModalLabel"
      v-model="adminModal"
    >
      <MDBModalHeader>
        <MDBModalTitle id="adminModalLabel"> Add Admin </MDBModalTitle>
      </MDBModalHeader>
      <MDBModalBody>
        <MDBInput class="my-4" label="Username" type="text" v-model="adminToAdd" />
      </MDBModalBody>
      <MDBModalFooter>
        <MDBBtn color="primary" @click="addAdmin()" class="me-2">Add</MDBBtn>
        <MDBBtn color="secondary" @click="adminModal = false">Close</MDBBtn>
      </MDBModalFooter>
    </MDBModal>
  </main>
</template>

<script>
import {
  MDBInput,
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
import { useRoute } from 'vue-router'
import http from "../http-common";

export default {
  name: "TournamentContextActions",
  props: ["data"],
  components: {
    MDBInput,
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
    showAddAdminModal() {
      this.adminModal = true;
    },
  },
  setup(props, {emit}) {
    const route = useRoute()
    const isShowAdvanced = ref(false);
    const adminToAdd = ref("");
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
    const nextRoundType = ref("swiss");
    const roundModal = ref(false);
    const adminModal = ref(false);

    function addAdmin() {
      http.post("protected/admins/" + route.params.tournamentId + "?username=" + adminToAdd.value)
      .then((json) => {
        emit('addAdmin', json.data);
      })
      adminToAdd.value = ''
    }

    return {
      isShowAdvanced,
      nextRoundType,
      countTopPlayers,
      roundModal,
      adminToAdd,
      adminModal,
      addAdmin,
      route,
    };
  },
};
</script>

<style scoped>
.button-container > * {
  margin-top: 1em;
  margin-right: 2em;
  margin-bottom: 1em;
}
.next-round-container > * {
  margin-bottom: 1.5em;
}
i {
  padding-left: 1em;
}
</style>