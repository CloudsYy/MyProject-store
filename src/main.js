import Vue from 'vue'
import App from './App'

//引入组件
import Foo from './components/Foo'
import Bar from './components/Bar'
import login from './components/login'
import ElementUi from 'element-ui'

import router from './router'
//import Axios from 'axios';

//引入resource
import VueResource from 'vue-resource';
import 'element-ui/lib/theme-chalk/index.css';
import Vuex from 'vuex';

//引入jQuery
import $ from 'jquery'

Vue.use(VueResource);
Vue.use(ElementUi);
Vue.use(Vuex);
//Vue.use(Axios);

Vue.config.productionTip = false

Vue.http.interceptors.push((request,next)=>{
  console.log(this)//此处this.为请求所在页面的Vue实例
  //modify request
  //request.method = 'POST';//在请求之前可以进行一些预处理和配置
  let token = localStorage.getItem('token');
  if (token){
    request.headers.set('token',token);
  }
  //continue to next interceptor
  next((response)=>{
    //在响应之后传给then之前对respond进行修改和逻辑判断，对于token时候已过期
    //的判断，就添加在此处，页面中任何一次http请求都会先调用此处方法
    console.log(request.headers.get('token')+ 1);
    return response;
  });
});

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  Vuex,
  render: h => h(App)
})
