import Vue from 'vue'
import Router from 'vue-router'
import Main from '@/components/Main'
import Registry from '@/components/Registry'
import Forgot from '@/components/Forgot'
import Game from '@/components/Game'
import ConfirmMessage from '@/components/messages/ConfirmMessage'
import ForgotMessage from '@/components/messages/ForgotMessage'

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
      name: 'ConfirmMessage',
      component: ConfirmMessage
    },
    {
      path: '/forgotMessage',
      name: 'ForgotMessage',
      component: ForgotMessage
    }
  ]
})
