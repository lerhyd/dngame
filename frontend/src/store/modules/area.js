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
        context.commit('setStatus', response.data)
      })
        .catch(error => {
          console.log(error)
        })
    },
    getKiraNews(context) {
      axios("/game/kira/news/get", {
        params: {
          userLogin: context.getters.loginName
        },
        method: 'GET'
      }).then(response => {
        console.log(response.data)
        context.commit('setNews', response.data)
        console.log(context.getters.news)
        context.dispatch('getKiraNews')
      })
        .catch(error => {
          console.log(error)
        })
    },
    getAgentNews(context) {
      axios("/game/agent/news/get", {
        params: {
          userLogin: context.getters.loginName
        },
        method: 'GET'
      }).then(response => {
        console.log(response.data)
        context.commit('setNews', response.data)
        console.log(context.getters.news)
        context.dispatch('getAgentNews')
      })
        .catch(error => {
          console.log(error)
        })
    }
  }


}
