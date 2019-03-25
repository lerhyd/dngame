import Vue from 'vue'
import Router from 'vue-router'
import Main from '@/components/main/MainPage'
import Forgot from '@/components/main/NewForgot'
import Game from '@/components/game/Game'
import ConfirmMessage from '@/components/messages/ConfirmMessage'
import ForgotMessage from '@/components/messages/ForgotMessage'
import Contacts from '@/components/main/Contacts'
import NewRegistry from '@/components/main/NewRegistry'
import Login from '@/components/main/Log-In'
import NotFound from '@/components/main/NotFound'
import About from '@/components/main/About'
import NotConfirmEmailMessage from '@/components/messages/NotConfirmEmailMessage'
import Class from '@/components/game/Class'
import Kira from '@/components/game/Kira'
import FindMatch from '@/components/game/FindMatch'
import Area from '@/components/game/Area'
import Achievements from '@/components/game/Achievements'
import Settings from '@/components/game/Settings'
import Agent from '@/components/game/Agent'

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
      path: '/agent',
      name: 'Agent',
      component: Agent
    },
    {
      path: '/settings',
      name: 'Settings',
      component: Settings
    },
    {
      path: '/about',
      name: 'About',
      component: About
    },
    {
      path: '/registry',
      name: 'NewRegistry',
      component: NewRegistry
    },
    {
      path: "*",
      component: NotFound
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/achievements',
      name: 'Achievements',
      component: Achievements
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
      path: '/kira',
      name: 'Kira',
      component: Kira
    },
    {
      path: '/confirm',
      name: 'ConfirmMessage',
      component: ConfirmMessage
    },
    {
      path: '/reSend',
      name: 'NotConfirmEmailMessage',
      component: NotConfirmEmailMessage
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
    },
    {
      path: '/class',
      name: 'Class',
      component: Class
    },
    {
      path: '/findMatch',
      name: 'FindMatch',
      component: FindMatch
    },
    {
      path: '/area',
      name: 'Area',
      component: Area
    }
  ]
})
