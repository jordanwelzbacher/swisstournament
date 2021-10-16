import 'mdb-vue-ui-kit/css/mdb.min.css'

import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

require('@/store/subscriber')

store.dispatch('auth/attempt', localStorage.getItem('token')).then(() => {
    createApp(App)
        .use(router)
        .use(store)
        .mount('#app')
})

// createApp(App)
// .use(router)
// .use(store)
// .mount('#app')
