<template>
    <div>This is the Tournament Heading component!</div>
</template>

<script>
import http from "../http-common";

export default {
    setup() {
        http
        .get("/tournament", {
         //assign vars
        })
        .then((response) => {
          console.log(response.data);
        })
        .catch((e) => {
          console.log(e);
        });
    }
}
</script>

<style scoped>

</style>