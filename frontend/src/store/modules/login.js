import axios from 'axios'
import router from '../../router'

export default {

  state: {
    login: [],
    isFailed: false
  },

  mutations: {
    setLogin (state, list) {
      state.login = list;
    },
    setFailed (state, data) {
      state.isFailed = data
    }
  },

  getters: {
    isFailed: state => state.isFailed
  },

  actions: {
    signIn(context, credentials){
      axios("/login", {
        params: {
          username: credentials.username,
          password: credentials.password
        },
        method: 'POST'
      }).then(response => {
        if (response.status = 200)
          router.push("/game")
        else
          context.commit('setFailed', true)
      })
        .catch(error => {
          context.commit('setFailed', true)
        })
    }

  }

}

