import axios from 'axios'

export default {

  state: {
    user:[],
    profile:[],
    rules: [],
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
    },
    setRules (state, data) {
      state.rules = data
    }
  },

  getters: {
    user: state => state.user,
    profile: state => state.profile,
    hasProfile: state => state.hasProfile,
    profileCreateStatus: state => state.profileCreateStatus,
    profileDeleteStatus: state => state.profileDeleteStatus,
    gameClassChooseStatus: state => state.gameClassChooseStatus,
    loginName: state => state.loginName,
    rules: state => state.rules
  },

  actions: {
    getUser(context){
      axios("/game/user", {
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
      console.log(context.getters.loginName)
      axios.post("/game/profile/create", {
          name: data.name,
          surname: data.surname,
          patr: data.patr,
          sex: data.sex,
          bornDate: data.bornDate,
          userLogin: context.getters.loginName
      }).then(response => {
        context.commit('setProfileCreateStatus', response.data)
      })
        .catch(error => {
          console.log(error)
        })
    },

    getProfile (context) {
      axios("/game/user/profile", {
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

    deleteProfile(context){
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

    hasProfile(context) {
      axios("/game/profile", {
        params: {
          login: context.getters.loginName
        },
        method: 'GET'
      }).then(response => {
        console.log(response.data)
        context.commit('setHasProfile', response.data)
      })
        .catch(error => {
          console.log(error)
        })
    },

    getLoginName(context) {
      axios("/login/userName", {
        method: 'GET'
      }).then(response => {
        context.commit('setLoginName', response.data)
      })
        .catch(error => {
          console.log(error)
        })
    },

    getRules(context){
      axios("/game/rules",
        {
          method: 'GET'
        }).then(response => {
        context.commit('setRules', response.data)
      })
        .catch(error => {
          console.log(error)
        })
    }
  }

}
