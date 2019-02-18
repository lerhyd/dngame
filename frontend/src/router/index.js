import Vue from 'vue'
import Router from 'vue-router'
import Main from '@/components/Main'
import Registry from '@/components/Registry'
import Forgot from '@/components/Forgot'

Vue.use(Router)

export default new Router({
  mode: "history",
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'Main',
      component: Main
    },
    {
      path: '/registry',
      name: 'Registry',
      component: Registry
    },
    {
      path: '/recovery',
      name: 'Forgot',
      component: Forgot
    }
  ],
  scrollBehavior: (to, from, savedPosition) => {
    if (savedPosition) {
      return savedPosition;
    } else if (to.hash) {
      return {
        selector: to.hash
      };
    } else {
      return { x: 0, y: 0 };
    }
  }
})
