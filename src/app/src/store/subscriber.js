import store from '@/store'
import http from "../http-common";

store.subscribe((mutation) => {
    switch (mutation.type) {
        case 'auth/SET_TOKEN':
            if (mutation.payload) {
                http.defaults.headers.common['Authorization'] = `Bearer ${mutation.payload}`
                localStorage.setItem('token', mutation.payload)
            } else {
                http.defaults.headers.common['Authorization'] = null
                localStorage.removeItem('token')
            }
            break;
    }
})