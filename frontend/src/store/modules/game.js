import axios from 'axios'

export default {

  state: {
    user:[],
    profile:[],
    rules: [],
    continents: [],
    countries: [],
    cities: [],
    id: null,
    continent: null,
    country: null,
    kiraAchievements: [],
    agentAchievements: [],
    hasProfile:undefined,
    criminalPeople: [],
    loginName: null,
    profileCreateStatus: 0,
    profileDeleteStatus: 0,
    gameClassChooseStatus: 0
  },

  mutations: {
    setCriminalPeople (state, data) {
      state.criminalPeople = data
    },
    setAgentAchievements (state, data) {
      state.agentAchievements = data
    },
    setKiraAchievements (state, data) {
      state.kiraAchievements = data
    },
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
    },
    setRegions (state, data) {
      state.regions = data
    },
    setContinents (state, data) {
      state.continents = data
    },
    setCountries (state, data) {
      state.countries = data
    },
    setCities (state, data) {
      state.cities = data
    },
    setId (state, data) {
      state.id = data
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
    rules: state => state.rules,
    kiraAchievements: state => state.kiraAchievements,
    agentAchievements: state => state.agentAchievements,
    regions: state => state.regions,
    continent: state => state.continent,
    country: state => state.country,
    continents: state => state.continents,
    countries: state => state.countries,
    cities: state => state.cities,
    id: state => state.id,
    criminalPeople: state => state.criminalPeople
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

    getRegionsWithContinents(context) {
      axios("/game/regions/continents", {
        method: 'GET'
      }).then(response => {
        console.log(response.data)
        context.commit('setContinents', response.data)
      })
        .catch(error => {
          console.log(error)
        })
    },

    getRegionsWithCountries(context, credentials) {
      axios("/game/regions/countries", {
        params: {
          continent: credentials.continent
        },
        method: 'GET'
      }).then(response => {
        console.log(response.data)
        context.commit('setCountries', response.data)
      })
        .catch(error => {
          console.log(error)
        })
    },

    getRegionsWithCities(context, credentials) {
      axios("/game/regions/cities", {
        params: {
          country: credentials.country
        },
        method: 'GET'
      }).then(response => {
        console.log(response.data)
        context.commit('setCities', response.data)
      })
        .catch(error => {
          console.log(error)
        })
    },

    getRegionId(context, credentials) {
      axios("/game/regions/id", {
        params: {
          city: credentials.city
        },
        method: 'GET'
      }).then(response => {
        console.log(response.data)
        context.commit('setId', response.data)
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
    },

    getRandomPeople(context) {
      axios("/game/randomCriminalPeople", {
        // params: {
        //   criminalPeople: credentials.criminalPeople
        // },
        method: 'GET'
      }).then(response => {
        console.log(response.data)
        context.commit('setCriminalPeople', response.data)
      })
        .catch(error => {
          console.log(error)
        })
    },

    getKiraAchievements(context){
      axios("/game/kira/achievements",
        {
          params: {
            login: context.getters.loginName
          },
          method: 'GET'
        }).then(response => {
        context.commit('setKiraAchievements', response.data)
      })
        .catch(error => {
          console.log(error)
        })
    },

    getAgentAchievements(context){
      axios("/game/agent/achievements",
        {
          params: {
            login: context.getters.loginName
          },
          method: 'GET'
        }).then(response => {
        context.commit('setAgentAchievements', response.data)
      })
        .catch(error => {
          console.log(error)
        })
    }
  }

}
