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
    actionId: null,
    actionPlaceId: null,
    entryStatus: 0,
    kiraWinStatus: null,
    matchEnded: false,
    isKiraWin: undefined,
    isGameDrawn: false
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
      state.entryStatus = data
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
    },
    setKiraWinStatus(state, data) {
      state.kiraWinStatus = data
    },
    setMatchEnded(state, data) {
      state.matchEnded = data
    },
    setIsKiraWin(state, data) {
      state.isKiraWin = data
    },
    setIsGameDrawn(state, data) {
      state.isGameDrawn = data
    }
  },

  getters: {
    news: state => state.news,
    status: state => state.status,
    noPersons: state => state.noPerson,
    entryPages: state => state.entryPages,
    entry: state => state.entry,
    entryStatus: state => state.entryStatus,
    actionId: state => state.actionId,
    actionPlaceId: state => state.actionPlaceId,
    action: state => state.action,
    actionPlace: state => state.actionPlace,
    numPage: state => state.numPage,
    kiraWinStatus: state => state.kiraWinStatus,
    matchEnded: state => state.matchEnded,
    isKiraWin: state => state.isKiraWin,
    isGameDrawn: state => stte.isGameDrawn
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
        console.log(response.data)
        context.commit('setEntryPages', response.data)
      })
        .catch(error => {
          console.log(error)
        })
    },
    getRequestPages(context) {
      axios("/game/request/pages", {
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
    getRequests(context) {
      axios("/game/request", {
        params: {
          userLogin: context.getters.loginName,
          numPage: context.getters.numPage
        },
        method: 'GET'
      }).then(response => {
        console.log(response.data)
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
        if (response.data === 7)
          context.dispatch('gameDrawn')
        if (response.data === 8 || response.data === 11 || response.data === 12)
          context.dispatch('agentWin')
        if (response.data === 666)
          context.dispatch('kiraWin')
        context.commit('setEntryStatus', response.data);
        context.dispatch('getKiraStatus')
      })
        .catch(error => {
          console.log(error)
        })
    },

    makeRequest(context, credentials){
      axios.post('/game/request/add', {
        userLogin: context.getters.loginName,
        personName: credentials.victimName,
        personSurname: credentials.victimSurname,
        personPatr: credentials.victimPatr,
        personSex: credentials.victimSex,
      }).then(response => {
        console.log(response.data)
        if (response.data === 6)
          context.dispatch('gameDrawn')
        if (response.data === 9)
          context.dispatch('kiraWin')
        if (response.data === 666)
          context.dispatch('agentWin')
        context.commit('setEntryStatus', response.data);
        context.dispatch('getAgentStatus')
      })
        .catch(error => {
          console.log(error)
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
    },
    kiraWin(context){
      axios.post('game/kira/win', {
        userLogin: context.getters.loginName,
        isKira: context.getters.isKira
      }).then(response => {
        console.log(response.data)
        context.commit('setKiraWinStatus', response.data);
        context.commit('setMatchEnded', true)
        context.commit('setIsKiraWin', true)
      })
        .catch(error => {
          console.log(error)
        })
    },

    agentWin(context){
      axios.post('game/agent/win', {
        userLogin: context.getters.loginName,
        isKira: context.getters.isKira
      }).then(response => {
        console.log(response.data)
        context.commit('setKiraWinStatus', response.data);
        context.commit('setMatchEnded', true)
        context.commit('setIsKiraWin', false)
      })
        .catch(error => {
          console.log(error)
        })
    },

    gameDrawn(context){
      axios.post('/game/drawn', {
        userLogin: context.getters.loginName,
        isKira: context.getters.isKira
      }).then(response => {
        console.log(response.data)
        context.commit('setMatchEnded', true)
        context.commit('setIsGameDrawn', true)
      })
        .catch(error => {
          console.log(error)
        })
    }
  }


}
