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

//引入jQuery
import $ from 'jquery'

Vue.use(VueResource);
Vue.use(ElementUi);
//Vue.use(Axios);

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  render: h => h(App)
})
