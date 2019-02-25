import axios from 'axios'

export default {

  state: {
    user:[],
    profile:[],
    hasProfile:undefined,
    loginName: null,
    profileCreateStatus: 0,
    profileDeleteStatus: 0,
    gameClassChooseStatus: 0
  },

  mutations: {
    setUser (state, data) {
      state.user = data
    },
    setProfile (state, data) {
      state.profile = data
    },
    setHasProfile (state, data) {
      state.hasProfile = data
    },
    setProfileCreateStatus (state, data) {
      state.profileCreateStatus = data
    },
    setProfileDeleteStatus (state, data) {
      state.profileDeleteStatus = data
    },
    setGameClassChooseStatus (state, data) {
      state.gameClassChooseStatus = data
    },
    setLoginName (state, data) {
      state.loginName = data
    }
  },

  getters: {
    user: state => state.user,
    profile: state => state.profile,
    hasProfile: state => state.hasProfile,
    profileCreateStatus: state => state.profileCreateStatus,
    profileDeleteStatus: state => state.profileDeleteStatus,
    gameClassChooseStatus: state => state.gameClassChooseStatus,
    loginName: state => state.loginName
  },

  actions: {
    getUser(context, data){
      axios("/game/user/get", {
        params: {
          login: context.getters.loginName
        },
        method: 'GET'
      }).then(response => {
        context.commit('setUser', response.data)
      })
        .catch(error => {
          console.log(error)
        })
    },

    createProfile(context, data){
      axios("/game/profile/create", {
        params: {
          name: data.name,
          surname: data.surname,
          patr: data.patr,
          sex: data.sex,
          bornDate: data.bornDate,
          userLogin: context.getters.loginName
        },
        method: 'POST'
      }).then(response => {
        context.commit('setProfileCreateStatus', response.data)
      })
        .catch(error => {
          console.log(error)
        })
    },

    getProfile (context, data) {
      axios("/game/user/profile/get", {
        params: {
          login: context.getters.loginName
        },
        method: 'GET'
      }).then(response => {
        context.commit('setProfile', response.data)
      })
        .catch(error => {
          console.log(error)
        })
    },

    deleteProfile(context, data){
      axios("/game/profile/delete", {
        params: {
          login: context.getters.loginName
        },
        method: 'POST'
      }).then(response => {
        context.commit('setProfileDeleteStatus', response.data)
      })
        .catch(error => {
          console.log(error)
        })
    },

    classChoose(context, data){
      axios("/game/class/choose", {
        params: {
          isKira: data.isKira,
          userLogin: context.getters.loginName,
          regionId: data.regionId
        },
        method: 'POST'
      }).then(response => {
        context.commit('setGameClassChooseStatus', response.data)
      })
        .catch(error => {
          console.log(error)
        })
    },

    hasProfile(context, data) {
      axios("/game/profile", {
        params: {
          login: context.getters.loginName
        },
        method: 'GET'
      }).then(response => {
        context.commit('setHasProfile', response.data)
      })
        .catch(error => {
          console.log(error)
        })
    },

    getLoginName(context, data) {
      axios("/login", {
        method: 'GET'
      }).then(response => {
        context.commit('setLoginName', response.data)
      })
        .catch(error => {
          console.log(error)
        })
    }
  }

}
