import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Foo from '@/components/Foo'
import Bar from '@/components/Bar'
import Login from '@/components/login'

Vue.use(Router)

export default new Router({
  mode: 'history',
  base: '/vue-test/',
  routes: [
     {
      path: '*',
      component: (resolve) => require(['../components/error404.vue'], resolve)
     },
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/foo',
      name: 'Foo',
      component: Foo
    },
    {
      path: '/bar',
      name: 'Bar',
      component: Bar
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    }
  ]
})
