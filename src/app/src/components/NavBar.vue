<template>
  <MDBNavbar expand="lg" light bg="light" container="md">
    <MDBNavbarBrand href="#">Swiss Tournament</MDBNavbarBrand>
      <MDBNavbarNav class="mb-2 mb-lg-0">
        <MDBNavbarItem href="#">
          Browse
        </MDBNavbarItem>
        <MDBNavbarItem to="/create">
            Create
        </MDBNavbarItem>
        <MDBNavbarItem>
          <!-- Navbar dropdown -->
          <MDBDropdown class="nav-item" v-model="dropdown1">
            <MDBDropdownToggle
              tag="a"
              class="nav-link"
              @click="dropdown1 = !dropdown1"
              >Dropdown</MDBDropdownToggle
            >
            <MDBDropdownMenu aria-labelledby="dropdownMenuButton">
              <MDBDropdownItem href="#">Action</MDBDropdownItem>
              <MDBDropdownItem href="#">Another Action</MDBDropdownItem>
              <MDBDropdownItem href="#"
                >Something else here</MDBDropdownItem
              >
            </MDBDropdownMenu>
          </MDBDropdown>
        </MDBNavbarItem>
        <MDBNavbarItem href="#">
          Login
        </MDBNavbarItem>
      </MDBNavbarNav>
      <!-- Search form -->
      <form class="d-flex input-group w-auto">
        <input
          type="search"
          class="form-control"
          placeholder="Search for anything"
          aria-label="Search"
        />
        <MDBBtn outline="primary">
          Search
        </MDBBtn>
      </form>
  </MDBNavbar>
</template>

<script>
  import {
    MDBBtn,
    MDBNavbar,
    MDBNavbarBrand,
    MDBNavbarNav,
    MDBNavbarItem,
    MDBDropdown,
    MDBDropdownToggle,
    MDBDropdownMenu,
    MDBDropdownItem
  } from 'mdb-vue-ui-kit';
  import { ref } from 'vue';

  export default {
    name: "NavBar",
    components: {
      MDBBtn,
      MDBNavbar,
      MDBNavbarBrand,
      MDBNavbarNav,
      MDBNavbarItem,
      MDBDropdown,
      MDBDropdownToggle,
      MDBDropdownMenu,
      MDBDropdownItem
    },
    setup() {

      const collapse1 = ref(false);
      const dropdown1 = ref(false);

      return {
        collapse1,
        dropdown1
      }
    }
  };
</script>