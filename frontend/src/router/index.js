import Vue from 'vue'
import Router from 'vue-router'
import Main from '@/components/Main'
import Registry from '@/components/Registry'
import Forgot from '@/components/Forgot'
import Game from '@/components/Game'
import Confirm from '@/components/Confirm'
import Header from '@/components/Header'

Vue.use(Router)

export default new Router({
  mode: 'history',
  hash: false,
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
      path: '/header',
      name: 'Header',
      component: Header
    },
    {
      path: '/recovery',
      name: 'Forgot',
      component: Forgot
    },
    {
      path: '/game',
      name: 'Game',
      component: Game
    },
    {
      path: '/confirm',
      name: 'Confirm',
      component: Confirm
    }
  ]
})
