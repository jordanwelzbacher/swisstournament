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
            <MDBPopconfirm confirm="doTheThing()"> Remove Admin </MDBPopconfirm>
          </span>
        </td>
      </tr>
    </tbody>
  </MDBTable>
</template>

<script>
import { MDBTable, MDBPopconfirm } from "mdb-vue-ui-kit";
import { ref } from "vue";

export default {
  name: "TournamentAdmins",
  props: ["data"],
  components: {
    MDBTable,
    MDBPopconfirm,
  },
  setup() {
    const adminTooltip = ref(false);
    return {
      adminTooltip,
    };
  },
};
</script>

<style scoped>
</style>