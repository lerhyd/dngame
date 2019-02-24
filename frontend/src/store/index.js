import login from './modules/login'
import registry from './modules/registry'
import Vuex from 'vuex'
import Vue from 'vue'

Vue.use(Vuex)

export default new Vuex.Store({
  modules: {
    login,
    registry
  }
})
