<template>
  <main class="mt-4">
    <MDBContainer class="userBox">
      <MDBTabs v-model="userTab">
        <!-- Tabs navs -->
        <MDBTabNav tabsClasses="mb-4">
          <MDBTabItem tabId="login" href="login">Login</MDBTabItem>
          <MDBTabItem tabId="create" href="create">Register</MDBTabItem>
        </MDBTabNav>
        <!-- Tabs navs -->
        <!-- Tabs content -->
        <MDBTabContent>
          <MDBTabPane tabId="login">
            <MDBInput label="Username" v-model="username" />
            <MDBInput
              label="Password"
              v-model="password"
              type="password"
              class="mt-3"
            />
            <div class="text-center mt-4">
              <MDBBtn
                color="primary"
                :disabled="processingRequest"
                @click="login()"
                >Login</MDBBtn
              >
            </div>
          </MDBTabPane>
          <MDBTabPane tabId="create">
            <MDBInput label="Username" v-model="username" />
            <MDBInput
              label="Password"
              v-model="password"
              type="password"
              class="mt-3"
            />
            <MDBInput
              label="Email Address"
              v-model="email"
              class="mt-3"
              formText="We'll never share your email with anyone else."
            />
            <MDBInput
              label="Full Name"
              v-model="fullName"
              class="mt-3"
              formText="Will be publicly displayed if tournament organizer chooses to display by name instead of username."
            />
            <div class="text-center mt-4" v-show="!processingRequest">
              <MDBBtn
                color="primary"
                :disabled="processingRequest"
                @click="register()"
              >
                Submit</MDBBtn
              >
            </div>
            <div class="text-center mt-4" v-show="processingRequest">
              <MDBSpinner />
            </div>
          </MDBTabPane>
        </MDBTabContent>
        <!-- Tabs content -->
      </MDBTabs>
    </MDBContainer>
  </main>
</template>

<script>
import { mapActions } from 'vuex'
import http from "../http-common";
import {
  MDBContainer,
  MDBInput,
  MDBTabs,
  MDBTabNav,
  MDBTabContent,
  MDBTabItem,
  MDBTabPane,
  MDBBtn,
  MDBSpinner,
} from "mdb-vue-ui-kit";
import { ref } from "vue";

export default {
  name: "Login",
  components: {
    MDBContainer,
    MDBInput,
    MDBTabs,
    MDBTabNav,
    MDBTabContent,
    MDBTabItem,
    MDBTabPane,
    MDBBtn,
    MDBSpinner,
  },

  setup() {
    const username = ref("");
    const password = ref("");
    const userTab = ref("login");
    const email = ref("");
    const fullName = ref("");
    const processingRequest = ref(false);
    return {
      username,
      password,
      email,
      fullName,
      MDBTabs,
      MDBTabNav,
      MDBTabContent,
      MDBTabItem,
      MDBTabPane,
      userTab,
      processingRequest,
    };
  },
  methods: {
    ...mapActions({
      signIn: 'auth/signIn'
    }),
    login() {
      this.signIn({
        username: this.username,
        password: this.password
        })
    },
    register() {
      this.processingRequest = true;
      http
        .post("/users/register", {
          username: this.username,
          fullName: this.fullName,
          emailAddress: this.email,
          password: this.password,
        })
        .then((response) => {
          console.log(response.data);
          this.processingRequest = false;
        })
        .catch((e) => {
          console.log(e);
          this.processingRequest = false;
        });
    },
  },
};
</script>

<style scoped>
.userBox {
  max-width: 500px;
  min-height: 400px;
  border: 3px solid gray;
  border-radius: 5px;
  padding: 20px 20px 20px 20px;
}
</style>