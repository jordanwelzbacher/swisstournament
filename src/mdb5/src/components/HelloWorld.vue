<template>
  <MDBContainer>{{msg}}</MDBContainer>
</template>

<script>
import { MDBContainer } from "mdb-vue-ui-kit";

export default {
  name: "HelloWorld",
  components: {
    MDBContainer,
  },
  data() {
    return {
      msg: ''
    }
  },
  mounted() {
    fetch("/api/message/hello")
    .then((response) => response.text())
    .then((data => {this.msg = data;}))
  }
}
</script>

<style scoped></style>
