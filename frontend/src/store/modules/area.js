import axios from 'axios'
import router from '../../router'

export default {

  state: {
    news: [],
    status: [],
    noPersons: false
  },

  mutations: {
    setNews(state, data){
      state.news = data
    },
    setStatus(state, data) {
      state.status = data
    },
    setNoPersons(state, data) {
      state.noPerson = data
    }
  },

  getters: {
    news: state => state.news,
    status: state => state.status,
    noPersons: state => state.noPerson
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
        context.commit('setNews', response.data)
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
        if (response.data === null)
          context.commit('setNoPersons', true)
        context.commit('setNews', response.data)
        context.dispatch('getAgentNews')
      })
        .catch(error => {
          console.log(error)
        })
    }
  }


}
