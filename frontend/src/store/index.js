import Vue from 'vue'
import Vuex from 'vuex'
import login from './modules/login'
import registry from './modules/registry'

Vue.use(Vuex)

export default new Vuex.Store({
  modules: {
    login,
    registry
  }
})
