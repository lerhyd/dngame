// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import store from './store'
import App from './App'
import router from './router'
import { Datetime } from "vue-datetime";

Vue.config.productionTip = false
Vue.component('datetime', Datetime)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  store: store,
  router: router,
  components: { App },
  template: '<App/>'
})
