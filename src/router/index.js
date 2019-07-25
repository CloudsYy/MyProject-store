import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Foo from '@/components/Foo'
import Bar from '@/components/Bar'
import Login from '@/components/login'

Vue.use(Router)

//页面刷新时，重新赋值token
if (localStorage.getItem('token')) {
  this.$store.commit('set_token',localStorage.getItem('token'));
}

const router = new Router({
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
});

export default router;

router.beforeEach((to,from,next)=>{
  if (to.path === '/login'){
    next();
  } else{
    let token  = localStorage.getItem('token');

    if (token === 'null' || token === ''){
      next('/login');
    } else
    {
      next();
    }
  }
});

