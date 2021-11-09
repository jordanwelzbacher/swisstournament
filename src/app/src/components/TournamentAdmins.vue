<template>
  <MDBTable>
    <thead>
      <tr>
        <th scope="col">Username</th>
        <th scope="col"><span v-if="data.isOwner">Actions</span></th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="admin in data.admins" :key="admin.id">
        <td>{{ admin.username }}</td>
        <td>
          <span v-if="data.isOwner">
            <MDBPopconfirm v-on:confirm="deleteAdmin(data.tournamentId, admin.id)">Remove Admin</MDBPopconfirm>
          </span>
        </td>
      </tr>
    </tbody>
  </MDBTable>
</template>

<script>
import { MDBTable, MDBPopconfirm } from "mdb-vue-ui-kit";
import http from "../http-common";
import { ref } from "vue";


export default {
  name: "TournamentAdmins",
  props: ["data"],
  components: {
    MDBTable,
    MDBPopconfirm,
  },
  setup(props, {emit}) {
    const adminTooltip = ref(false);
    function deleteAdmin(tournamentId, adminId) {
      http.delete("/protected/admins/" + tournamentId + "/" + adminId, {})
      .then(
        emit('deleteAdmin', adminId)
      )
    }
    return {
      adminTooltip,
      deleteAdmin,
    };
  },
};
</script>

<style scoped>
</style>