import axios from 'axios'
import router from '../../router'

export default {

  state: {
    login: [],
    isFailed: false,
    loginStatus: true,
    role: null,
    logged: undefined
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
    },
    setLogged (state, data){
      state.logged = data
    },
    setRole (state, date){
      state.role = date
    }
  },

  getters: {
    isFailed: state => state.isFailed,
    login: state => state.login,
    loginStatus: state => state.loginStatus,
    role: state => state.role,
    logged: state => state.logged
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
          userLogin: context.getters.loginName,
        },
        method: 'GET'
      }).then(response => {
        context.commit('setLoginStatus', response.data)
      })
        .catch(error => {
          console.log(error)
        })
    },

    checkIfLoggedIn(context) {
      axios("/get", {
        method: 'GET'
      }).then(response => {
        context.commit('setRole', response.data);
        if (context.getters.role[0].authority == "vk" || context.getters.role[0].authority == "google") {
          context.commit('setLogged', true);
          console.log(context.state.logged)
        }
        else {
          context.commit('setLogged', false)
        }
      })
        .catch(error => {
          console.log(error)
        })
    },

    checkIfLogged(context) {
      axios("/auth/check", {
        method: 'GET'
      }).then(response => {
        context.commit('setLogged', response.data);
      })
        .catch(error => {
          console.log(error)
        })
    }
  }

}

