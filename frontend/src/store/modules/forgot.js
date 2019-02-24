import axios from 'axios'
import router from '../../router'

export default {

  state: {
    email: [],
    forgotStatus: 0
  },

  mutations: {
    setEmail (state, data) {
      state.email = data
    },
    setForgotStatus (state, data) {
      state.forgotStatus = data
    }
  },

  getters: {
    email: state => state.email,
    forgotStatus: state => state.forgotStatus
  },

  actions: {
    forgot(context, data){
      axios("/forgot/password", {
        params: {
          email: data.email
        },
        method: 'POST'
      }).then(response => {
        context.commit('setForgotStatus', response.data)
        if (response.data === 0) {
          context.commit('setForgotStatus', response.data)
          router.push("/forgotMessage")
        }
      })
        .catch(error => {
          console.log(error)
        })
    }

  }

}
