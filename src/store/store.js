import Vue from 'vue';
import Vuex from  'vuex';

Vue.use(Vuex);
//使用store.js对token进行token进行监管
export default new Vuex.Store({
  state:{
    token:''
  },
  mutations:{
    set_token(state,token){
      state.token = token;
      localStorage.setItem('token',JSON.stringify(token));
    },
    del_token(state){
      state.token = '';
      localStorage.removeItem('token');
    }
  }
})
