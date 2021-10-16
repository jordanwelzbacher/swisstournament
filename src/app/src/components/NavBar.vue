<template>
  <main>
    <MDBNavbar expand="lg" light bg="light" container="md">
      <MDBNavbarBrand href="/">Swiss Tournament</MDBNavbarBrand>
      <MDBNavbarToggler
        @click="collapse1 = !collapse1"
        target="#navbarSupportedContent"
      ></MDBNavbarToggler>
      <MDBCollapse v-model="collapse1" id="navbarSupportedContent">
        <MDBNavbarNav class="mb-2 mb-lg-0">
          <MDBNavbarItem to="/browse"> Browse </MDBNavbarItem>
          <MDBNavbarItem to="/create"> Create </MDBNavbarItem>
          <MDBNavbarItem to="/login" v-if="!authenticated">
            Login
          </MDBNavbarItem>
          <MDBNavbarItem v-else>
            <!-- Navbar dropdown -->
            <MDBDropdown class="nav-item" v-model="dropdown1">
              <MDBDropdownToggle
                tag="a"
                class="nav-link"
                @click="dropdown1 = !dropdown1"
                >{{ user != null ? user.username : ''}}</MDBDropdownToggle
              >
              <MDBDropdownMenu aria-labelledby="dropdownMenuButton">
                <MDBDropdownItem href="#">My Tournaments</MDBDropdownItem>
                <MDBDropdownItem href="#" @click="signOut()">Log Out</MDBDropdownItem>
              </MDBDropdownMenu>
            </MDBDropdown>
          </MDBNavbarItem>
        </MDBNavbarNav>
        <!-- Search form -->
        <!-- <form class="d-flex input-group w-auto">
        <input
          type="search"
          class="form-control"
          placeholder="Search for anything"
          aria-label="Search"
        />
        <MDBBtn outline="primary">
          Search
        </MDBBtn>
      </form> -->
      </MDBCollapse>
    </MDBNavbar>
  </main>
</template>

<script>
import {
  MDBNavbar,
  MDBNavbarToggler,
  MDBNavbarBrand,
  MDBNavbarNav,
  MDBNavbarItem,
  MDBCollapse,
  MDBDropdown,
  MDBDropdownToggle,
  MDBDropdownMenu,
  MDBDropdownItem,
} from "mdb-vue-ui-kit";
import { ref } from "vue";
import { mapGetters, mapActions } from "vuex";

export default {
  components: {
    MDBNavbar,
    MDBNavbarToggler,
    MDBNavbarBrand,
    MDBNavbarNav,
    MDBNavbarItem,
    MDBCollapse,
    MDBDropdown,
    MDBDropdownToggle,
    MDBDropdownMenu,
    MDBDropdownItem,
  },
  setup() {
    const collapse1 = ref(false);
    const dropdown1 = ref(false);

    return {
      collapse1,
      dropdown1,
    };
  },
  computed: {
    ...mapGetters({
      authenticated: "auth/authenticated",
      user: "auth/user",
    }),
  },
  methods: {
    ...mapActions({
      signOutAction: 'auth/signOut'
    }),

    signOut () {
      this.signOutAction().then(() => {
        this.$router.replace({
          name: 'Home'
        })
      })
    }
  },

};
</script>