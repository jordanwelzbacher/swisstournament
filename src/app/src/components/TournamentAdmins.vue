<template>
  <MDBTable>
    <thead>
      <tr>
        <th scope="col">Username</th>
        <th scope="col">Actions</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="admin in data" :key="admin.id">
        <td>{{ admin.username }}</td>
         <td><MDBBtn outline="danger" rounded size="sm">Remove Admin</MDBBtn></td>
      </tr>
    </tbody>
  </MDBTable>
</template>

<script>
import { MDBTable, MDBBtn } from "mdb-vue-ui-kit";
import { ref } from "vue";

export default {
  name: "TournamentAdmins",
  props: ["data"],
  components: {
    MDBTable,
    MDBBtn,
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