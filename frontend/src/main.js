import Vue from 'vue'
import VueAgile from 'vue-agile'
import store from './store'
import App from './App'
import router from './router'
import Datetime from 'vue-datetime'
import 'vue-datetime/dist/vue-datetime.css'

import { Settings } from 'luxon'

Settings.defaultLocale = 'ru'

Vue.config.productionTip = false
Vue.use(Datetime)
Vue.use(VueAgile)

new Vue({
  el: '#app',
  store: store,
  router: router,
  components: {
    App
  },
  template: '<App/>'
})
