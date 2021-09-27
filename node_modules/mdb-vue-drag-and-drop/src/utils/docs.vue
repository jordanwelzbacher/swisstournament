<template>
  <div class="container">
    <ul class="nav nav-pills mb-3">
      <li class="nav-item">
        <MDBBtn
          @click="setCurrentTab('overview')"
          class="nav-link"
          :class="activeTab === 'overview' && 'active'"
          >Overview</MDBBtn
        >
      </li>
      <li class="nav-item">
        <MDBBtn
          v-if="!!$slots['api']"
          @click="setCurrentTab('api')"
          class="nav-link"
          :class="activeTab === 'api' && 'active'"
          >API</MDBBtn
        >
      </li>
    </ul>
    <div class="tab-content" v-if="activeTab === 'overview'">
      <div class="row">
        <div class="col-lg-10 col-md-12 mb-4">
          <section>
            <section id="section-introduction">
              <h2 class="h1 font-weight-bold">{{ mainTitle }}</h2>
              <h1 class="h6">
                {{ seoTitle }} - Bootstrap 5 & material Design 2.0
              </h1>
              <p>{{ description }}</p>
            </section>
            <hr class="my-5" />

            <slot name="overview"></slot>
          </section>
        </div>
        <div class="col-lg-2 d-none d-lg-block">
          <ul
            class="nav flex-column nav-pills menu-sidebar sticky-top"
            v-mdb-scrollspy="{ offset: 20 }"
          >
            <slot name="overview-scrollspy"> </slot>
          </ul>
        </div>
      </div>
    </div>
    <div class="tab-content" v-if="activeTab === 'api'">
      <div class="row">
        <div class="col-lg-10 col-md-12 mb-4">
          <section>
            <section id="api-section-introduction">
              <h2 class="h1 font-weight-bold">{{ mainTitle }} - API</h2>
            </section>
            <hr class="my-5" />
            <slot name="api"></slot>
          </section>
        </div>
        <div class="col-lg-2 d-none d-lg-block">
          <ul
            class="nav flex-column nav-pills menu-sidebar sticky-top"
            v-mdb-scrollspy
          >
            <slot name="api-scrollspy"> </slot>
          </ul>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { ref } from "vue";
import { MDBBtn, mdbScrollspy } from "mdb-vue-ui-kit";

export default {
  name: "Docs",
  components: {
    MDBBtn,
  },
  directives: {
    mdbScrollspy,
  },
  props: {
    mainTitle: {
      type: String,
      default: "Main Title",
    },
    seoTitle: {
      type: String,
      default: "Seo Title",
    },
    description: {
      type: String,
      default:
        "Lorem ipsum dolor sit amet consectetur adipisicing elit. Facere mollitia qui aut. Molestias explicabo autem veniam doloribus doloremque numquam odit rem sapiente natus ipsam temporibus voluptates, ab mollitia repellat! Itaque.",
    },
  },
  setup() {
    const activeTab = ref("overview");

    const setCurrentTab = (tab) => {
      activeTab.value = tab;
    };

    return {
      activeTab,
      setCurrentTab,
    };
  },
};
</script>
