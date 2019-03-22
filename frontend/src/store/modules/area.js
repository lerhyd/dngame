import axios from 'axios'
import router from '../../router'

export default {

  state: {
    news: [],
    status: [],
    entry: [],
    action: [],
    actionPlace: [],
    noPersons: false,
    numPage: 1,
    entryPages: null,
    entryStatus: null,
    actionId: null,
    actionPlaceId: null,

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
    },
    setEntryPages(state, data) {
      state.entryPages = data
    },
    setEntry(state, data) {
      state.entry = data
    },
    setEntryStatus(state, data) {
      state.entry = data
    },
    setActionId(state, data) {
      state.actionId = data
    },
    setActionPlaceId(state, data) {
      state.actionPlaceId = data
    },
    setAction(state, data) {
      state.action = data
    },
    setActionPlace(state, data) {
      state.actionPlace = data
    },
    setNumPage(state, data) {
      state.numPage = data
    }
  },

  getters: {
    news: state => state.news,
    status: state => state.status,
    noPersons: state => state.noPerson,
    entryPages: state => state.entryPages,
    entry: state => state.entry,
    getEntryStatus: state => state.entryStatus,
    actionId: state => state.actionId,
    actionPlaceId: state => state.actionPlaceId,
    action: state => state.action,
    actionPlace: state => state.actionPlace,
    numPage: state => state.numPage
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
    },
    getEntryPages(context) {
      axios("/game/note/pages", {
        params: {
          userLogin: context.getters.loginName
        },
        method: 'GET'
      }).then(response => {
        context.commit('setEntryPages', response.data)
      })
        .catch(error => {
          console.log(error)
        })
    },
    getEntries(context) {
      axios("/game/entry", {
        params: {
          userLogin: context.getters.loginName,
          numPage: context.getters.numPage
        },
        method: 'GET'
      }).then(response => {
        context.commit('setEntry', response.data)
      })
        .catch(error => {
          console.log(error)
        })
    },
    makeEntry(context, credentials){
      axios.post('/game/entry/add', {
        userLogin: context.getters.loginName,
        actionId: credentials.actionId,
        victimName: credentials.victimName,
        victimSurname: credentials.victimSurname,
        victimPatr: credentials.victimPatr,
        victimSex: credentials.victimSex,
        desc: credentials.desc,
        deathDate: credentials.deathDate,
        actionPlaceId: credentials.actionPlaceId
      }).then(response => {
        console.log(response.data)
        context.commit('setEntryStatus', response.data);
        context.dispatch('getKiraStatus')
      })
        .catch(error => {
          context.commit('setFailed', true);
        })
    },
    getKiraActions(context){
      axios("/game/kira/action", {
        params: {
          userLogin: context.getters.loginName
        },
        method: 'GET'
      }).then(response => {
        console.log(response.data)
        context.commit('setAction', response.data)
      })
        .catch(error => {
          console.log(error)
        })
    },
    getAgentActions(context){
      axios("/game/agent/action", {
        params: {
          userLogin: context.getters.loginName
        },
        method: 'GET'
      }).then(response => {
        context.commit('setAction', response.data)
      })
        .catch(error => {
          console.log(error)
        })
    },
    getKiraActionPlaces(context){
      axios("/game/kira/actionPlaces", {
        params: {
          userLogin: context.getters.loginName
        },
        method: 'GET'
      }).then(response => {
        console.log(response.data)
        context.commit('setActionPlace', response.data)
      })
        .catch(error => {
          console.log(error)
        })
    },
    getAgentActionPlaces(context){
      axios("/game/agent/actionPlaces", {
        params: {
          userLogin: context.getters.loginName
        },
        method: 'GET'
      }).then(response => {
        context.commit('setActionPlace', response.data)
      })
        .catch(error => {
          console.log(error)
        })
    }
  }


}
