import Vue from 'vue'
import VueAgile from 'vue-agile'
import store from './store'
import App from './App'
import router from './router'
import Datetime from 'vue-datetime'
import 'vue-datetime/dist/vue-datetime.css'

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
