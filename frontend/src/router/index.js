import Vue from 'vue'
import Router from 'vue-router'
import Main from '@/components/main/Main'
import Registry from '@/components/main/Registry'
import Forgot from '@/components/main/Forgot'
import Game from '@/components/game/Game'
import ConfirmMessage from '@/components/messages/ConfirmMessage'
import ForgotMessage from '@/components/messages/ForgotMessage'
import Contacts from '@/components/main/Contacts'
import Header from '@/components/main/Header'

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
      path: '/header',
      name: 'Header',
      component: Header
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
    },
    {
      path: '/contacts',
      name: 'Contacts',
      component: Contacts
    }
  ]
})
