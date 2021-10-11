<template>
  <MDBContainer>
    <div class="mt-4 text-center button-container">
      <MDBBtn color="success">
        Join Event&nbsp;&nbsp;&nbsp;<MDBIcon icon="sign-in-alt" size="lg" />
      </MDBBtn>
      <MDBBtn color="danger">
        Leave Event&nbsp;&nbsp;&nbsp;<MDBIcon icon="sign-out-alt" size="lg" />
      </MDBBtn>
      <MDBBtn color="primary">
        Add Player&nbsp;&nbsp;&nbsp;<MDBIcon icon="user-plus" size="lg" />
      </MDBBtn>
      <MDBBtn color="secondary">
        Edit Event&nbsp;&nbsp;&nbsp;<MDBIcon icon="edit" size="lg" />
      </MDBBtn>
      <MDBBtn
        @click="isShowAdvanced = !isShowAdvanced"
        aria-controls="advanced"
        :aria-expanded="isShowAdvanced"
        color="info"
      >
        Advanced Options&nbsp;&nbsp;&nbsp;
        <MDBIcon v-show="!isShowAdvanced" icon="chevron-up" size="lg" />
        <MDBIcon v-show="isShowAdvanced" icon="chevron-down" size="lg" />
      </MDBBtn>
    </div>
    <div class="mt-4 text-center">
      <MDBCollapse class="button-container" id="advanced" v-model="isShowAdvanced">
        <MDBBtn outline="primary">
          Add Admin&nbsp;&nbsp;&nbsp;<MDBIcon icon="user-shield" size="lg" />
        </MDBBtn>
        <MDBBtn outline="warning">
          Kick All Pending&nbsp;&nbsp;&nbsp;<MDBIcon icon="user-times" size="lg" />
        </MDBBtn>
        <MDBBtn outline="danger">
          Delete Tournament&nbsp;&nbsp;&nbsp;<MDBIcon icon="trash" size="lg" />
        </MDBBtn>
      </MDBCollapse>
    </div>
  </MDBContainer>
</template>

<script>
import { MDBContainer, MDBBtn, MDBCollapse, MDBIcon } from "mdb-vue-ui-kit";
import { ref } from "vue";

export default {
  name: "TournamentContextActions",
  components: {
    MDBContainer,
    MDBBtn,
    MDBCollapse,
    MDBIcon,
  },
  setup() {
    const isShowAdvanced = ref(false);

    return {
      isShowAdvanced,
    };
  },
};
</script>

<style scoped>
.button-container > * {
  margin-right: 2em;
}
</style>