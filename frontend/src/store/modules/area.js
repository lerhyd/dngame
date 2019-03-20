import axios from 'axios'
import router from '../../router'

export default {

  state: {
    news: [],
    status: []
  },

  mutations: {
    setNews(state, data){
      state.news = data
    },
    setStatus(state, data) {
      state.status = data
    }
  },

  getters: {
    news: state => state.news,
    status: state => state.status
  },

  actions: {
    getKiraStatus(context) {
      axios("/game/kira/status", {
        params: {
          userLogin: context.getters.loginName
        },
        method: 'GET'
      }).then(response => {
        console.log(response.data)
        context.commit('setStatus', response.data)
      })
        .catch(error => {
          console.log(error)
        })
    },
    getAgentStatus(context) {
      axios("/game/agent/status", {
        params: {
          userLogin: context.getters.loginName
        },
        method: 'GET'
      }).then(response => {
        console.log(response.data)
        context.commit('setStatus', response.data)
      })
        .catch(error => {
          console.log(error)
        })
    },
  }


}
