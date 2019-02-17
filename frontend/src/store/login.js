import axios from 'axios'

export default {
  state: {
    login: []
  },

  mutations: {
    setLogin (state, list) {
      state.login = list;
    }
  },

  actions: {
    signIn(context){
      axios('/login', {
        params: {
          login: login,
          password: password
        },
        method: 'POST'
      })
    }
  }

}

