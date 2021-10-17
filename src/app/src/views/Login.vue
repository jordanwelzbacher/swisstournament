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
            <form tag="form" @submit.prevent="login()">
              <MDBInput label="Username" v-model="username" required />
              <MDBInput
                class="mt-3"
                label="Password"
                v-model="password"
                type="password"
                required
              />
              <div class="text-center mt-4">
                <MDBBtn
                  color="primary"
                  :disabled="processingRequest"
                  type="submit"
                  >Login</MDBBtn
                >
              </div>
            </form>
          </MDBTabPane>
          <MDBTabPane tabId="create">
            <form
              tag="form"
              @submit.prevent="validateRegister"
              novalidate
              class="needs-validation"
            >
              <MDBInput
                label="Username"
                v-model="username"
                required
              />
              <MDBInput
                label="Password"
                v-model="password"
                type="password"
                class="mt-3"
                required
              />
              <MDBInput
                label="Email Address"
                v-model="email"
                class="mt-3"
                formText="We'll never share your email address."
                required
              />
              <MDBInput
                label="Full Name"
                v-model="fullName"
                class="mt-3"
                formText="May be publicly displayed."
                required
              />
              <div class="text-center mt-4" v-show="!processingRequest">
                <MDBBtn
                  color="primary"
                  :disabled="processingRequest"
                  type="submit"
                >
                  Submit</MDBBtn
                >
              </div>
            </form>
            <div class="text-center mt-4" v-show="processingRequest">
              <MDBSpinner />
            </div>
            <div class="mt-4 fw-bold" v-show="errorMessage">
              <p class="note note-danger">
                <MDBRow>
                  <MDBCol md="1" class="d-flex align-items-center">
                    <span style="color: #f93154">
                    <MDBIcon
                      icon="exclamation-circle"
                      iconStyle="fas"
                      size="lg"
                    /></span>
                  </MDBCol>
                  <MDBCol>Error: {{ errorMessage }} </MDBCol>
                </MDBRow>
              </p>
            </div>
            <div class="mt-4" v-show="success">
              <div class="note note-success">
                <span style="color: #00b74a">
                  <MDBIcon icon="check" iconStyle="fas" size="lg" />
                </span>
                <span class="fw-bold">
                  &nbsp;A verification link has been sent to your email address.
                </span>
                <hr />
                Account created successfully. You will need to verify your email
                address before logging in.
              </div>
            </div>
          </MDBTabPane>
        </MDBTabContent>
        <!-- Tabs content -->
      </MDBTabs>
    </MDBContainer>
  </main>
</template>

<script>
import { mapActions } from "vuex";
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
  MDBRow,
  MDBCol,
  MDBIcon,
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
    MDBRow,
    MDBCol,
    MDBIcon,
  },

  setup() {
    const username = ref("");
    const password = ref("");
    const userTab = ref("login");
    const email = ref("");
    const fullName = ref("");
    const processingRequest = ref(false);
    const errorMessage = ref("");
    const success = ref(false);

    const validateRegister = (e) => {
      e.target.classList.add("was-validated");
      register(e);
    };

    function register(e) {
      processingRequest.value = true;
      errorMessage.value = null;
      success.value = false;
      http
        .post("/user/register", {
          username: username.value,
          fullName: fullName.value,
          emailAddress: email.value,
          password: password.value,
        })
        .then(() => {
          success.value = true;
          username.value = "";
          password.value = "";
          fullName.value = "";
          email.value = "";
          processingRequest.value = false;
          e.target.classList.remove("was-validated")
        })
        .catch((e) => {
          errorMessage.value = e.response.data.message;
          processingRequest.value = false;
        });
    }

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
      errorMessage,
      success,
      validateRegister,
    };
  },
  methods: {
    ...mapActions({
      signIn: "auth/signIn",
    }),
    login() {
      this.signIn({
        username: this.username,
        password: this.password,
      })
        .then(() => {
          this.$router.replace({
            name: "Home",
          });
        })
        .catch(() => {
          console.log("failed");
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