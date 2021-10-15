import http from "../http-common";

export default {
    namespaced: true,

    state: {
        token: null,
        user: null
    },
    getters: {
        authenticated (state) {
            return state.token && state.user
        },
        user (state) {
            return state.user
        },
    },
    mutations: {
        SET_TOKEN (state, token) {
            state.token = token
        },
        SET_USER (state, data) {
            state.user = data
        },
    },
    actions: {
        async signIn ({ dispatch }, credentials) {
            let response = await http.post("/users/login", credentials)
            dispatch('attempt', response.data)
        },
        async attempt ({ commit }, token) {
            commit('SET_TOKEN', token)
            try {
                let response = await http.get("/users/me", {
                    headers: {
                        'Authorization': 'Bearer ' + token 
                    }
                })
                commit('SET_USER', response.data)
            } catch (e) {
                commit('SET_TOKEN', null)
                commit('SET_USER', null)
            }
        },
    },
};