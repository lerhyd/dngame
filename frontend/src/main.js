import Vue from 'vue'
import VueAgile from 'vue-agile'
import store from './store'
import App from './App'
import router from './router'
import Datetime from 'vue-datetime'
import 'vue-datetime/dist/vue-datetime.css'
<<<<<<< HEAD
import { Settings } from 'luxon'

Settings.defaultLocale = 'ru'
=======
>>>>>>> 5394f71599c0d0d13dedba123fbd95e851a72227

Vue.config.productionTip = false
Vue.use(Datetime)
Vue.use(VueAgile)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  store: store,
  router: router,
  components: {
    App
  },
  template: '<App/>'
})
