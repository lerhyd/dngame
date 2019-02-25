import axios from 'axios'
import router from '../../router'

export default {

  state: {
    login: [],
    isFailed: false,
    loginStatus: true
  },

  mutations: {
    setLogin (state, list) {
      state.login = list;
    },
    setFailed (state, data) {
      state.isFailed = data
    },
    setLoginStatus (state, data){
      state.loginStatus = data
    }
  },

  getters: {
    isFailed: state => state.isFailed,
    login: state => state.login,
    loginStatus: state => state.loginStatus
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
    },

    sendToken(context) {
      axios("/resendEmail", {
        params: {
          userLogin: context.state.login.username,
        },
        method: 'POST'
      }).then(response => {
        if (response.status = 200)
          context.commit('setLoginStatus', true)
        else
          context.commit('setLoginStatus', false)
      })
        .catch(error => {
          context.commit('setLoginStatus', false)
        })
    },

    checkIfConfirmed(context) {
      axios("/confirm/check", {
        params: {
          userLogin: context.state.login.username,
        },
        method: 'GET'
      }).then(response => {
        context.commit('setLoginStatus', response.data)
      })
        .catch(error => {
          console.log(error)
        })
    }
  }

}

