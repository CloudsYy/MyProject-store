import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Foo from '@/components/Foo'
import Bar from '@/components/Bar'
import Login from '@/components/login'
import error404 from "@/components/error404";

Vue.use(Router)

//页面刷新时，重新赋值token
/*if (localStorage.getItem('token')) {
  this.$store.commit('set_token',localStorage.getItem('token'));
}*/

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
      component: Bar,
      meta:{
        requireAuth: true
      }
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/error404',
      name: 'error404',
      component: error404
    }
  ]
});


router.beforeEach((to,from,next)=>{

  if (to.path === '/login' && to.path === '/') {
    localStorage.removeItem('token');//不要之前的token
    next();
  } else {
    let token = localStorage.getItem('token');
    console.log(token + "    beforeEach")
    if (token === null || token === '') {//token ==="null"则表示token等于字符串null ，而token===null，则表示为null的空值
      next('/login');
      console.log("null");
    } else {
      console.log("not null");
      next();
    }
  }

});

export default router;
