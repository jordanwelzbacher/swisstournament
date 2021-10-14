<template>
  <div>
    {{ this.$route.params.username }}
    <NavBar />
    <router-view class="mb-4" />
  </div>
</template>

<script>
import NavBar from "@/components/NavBar.vue";

export default {
  name: "App",
  components: {
    NavBar,
  },
};
</script>

<style>
</style>
