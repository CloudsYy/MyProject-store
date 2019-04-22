<template>
  <div>
    <el-form :model="dataForm" :rules="dataRule" @keyup.enter.native="login" ref="dataForm" style="height: 240px;margin:0 auto; width:400px; border:1px solid #F00" status-icon>
      <h3 class="login-title">管理员登录</h3>
      <el-form-item prop="username" style="margin-left: 20px;margin-right: 20px">
        <el-input v-model="dataForm.username" placeholder="帐号"></el-input>
      </el-form-item>
      <el-form-item prop="password" style="margin-left: 20px;margin-right: 20px">
        <el-input v-model="dataForm.password" type="password" placeholder="密码"></el-input>
      </el-form-item>
      <el-button type="primary" @click="login">登录</el-button>
    </el-form>
  </div>

</template>

<script>
  //引入vue实例
  import VueEvent from  '../model/VueEvent.js';

    export default {
      data(){
        return{
          msg: '我是新闻组件',
          dataForm: {
            username: '',
            password: ''
          },
          dataRule: {
            username: [
              { required: true, message: '帐号不能为空', trigger: 'blur' },
              { min: 2, max: 8, message: '长度在 2 到 8 个字符', trigger: 'blur' }
            ],
            password: [
              { required: true, message: '密码不能为空', trigger: 'blur' }
            ]
          }
        }
      },
      methods:{
        login(){
          this.$http.get(`/api/user/login/${this.dataForm.username},${this.dataForm.password}`, {
            emulateJSON: true
          }).then(function (response) {
            // 这里是处理正确的回调
            console.log(response)
            console.log(this.dataForm.username)
            if (response.data.length==0){
              alert("账号或密码有误！请重新输入_(:з」∠)_")
              this.dataForm.username='',
              this.dataForm.password=''
            } else{
              localStorage.setItem('list',JSON.stringify(response.data.token))
              VueEvent.$emit('to-header',this.dataForm.username)
              this.$router.push({name: 'Bar',params:{list:response.data}})
            }
            // this.articles = response.data["subjects"] 也可以
          }, function (response) {
            // 这里是处理错误的回调
            console.log(response)
          })
          /*this.$http.get(`/api/article/get`, {
            emulateJSON: true
          }).then(function (response) {
            // 这里是处理正确的回调
            console.log(response)
            this.user=response.data
            this.pageTotal = response.data.length
          }, function (response) {
            // 这里是处理错误的回调
            console.log(response)
          });*/
        }
        //emitheader(){
          //广播
          /*非父子组件传值
          * 1、新建一个js文件，然后引入vue 实例化vue 最后暴露这个实例
          * 2、在要广播的地方引入刚才定义的实例
          * 3、通过 VueEvent.$emit('名称','数据');广播
          * 4、通过VueEvent.$on('名称',function(){});监听广播*/
          //VueEvent.$emit('to-header',this.dataForm.username);
        //}
      }
    }
</script>

<style>
</style>
