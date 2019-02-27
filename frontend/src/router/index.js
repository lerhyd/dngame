import Vue from 'vue'
import Router from 'vue-router'
import Main from '@/components/main/Main'
import Forgot from '@/components/main/Forgot'
import Game from '@/components/game/Game'
import ConfirmMessage from '@/components/messages/ConfirmMessage'
import ForgotMessage from '@/components/messages/ForgotMessage'
import Contacts from '@/components/main/Contacts'
import NewRegistry from '@/components/main/NewRegistry'
import Login from '@/components/main/Log-In'




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
      name: 'NewRegistry',
      component: NewRegistry
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
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
