<template>
  <div id="bar">
    <p style="margin-left: -1080px">当前用户：admin</p><!--margin-left: 312px; width: 1200px-->
    <el-collapse accordion style="margin-left:70px; ">
    <el-collapse-item>
      <template slot="title">
        <h2>信息查询<i class="header-icon el-icon-info"></i></h2>
      </template>
      <el-row style="margin-left: -400px">
        <el-select class="item-choose" :placeholder="请选择" v-model="value" size="middle" style="margin: auto;width: 300px; margin-left: -90px">
        <el-option
          v-for="item in options"
          :key="item.value"
          :label="item.label"
          :value="item.value"
        ></el-option>
      </el-select>
        <!--<el-input v-model="input" placeholder="请输入内容" style="margin: auto;width: 400px"></el-input>-->
        <el-button type="primary" icon="el-icon-search" style="margin-left: 12px">搜索</el-button>
        <el-button type="primary" icon="el-icon-plus">添加</el-button>
        <el-button type="primary" icon="el-icon-delete">批量删除</el-button>
        <el-button type="primary" icon="el-icon-edit">批量修改</el-button>
      </el-row>
    </el-collapse-item>
    </el-collapse>


    <el-table border :data="user.slice((currentPage-1)*pageSize,currentPage*pageSize)" ref=""stripe
      style="width: 1200px;margin: auto" v-loading="dataListLoading">
      <el-table-column
        type="selection"
        width="55">
      </el-table-column>
      <el-table-column
        prop="id"
        label="编号"
        width="90">
      </el-table-column>
      <el-table-column
        prop="name"
        label="商品名"
        width="150">
      </el-table-column>
      <el-table-column
        prop="price"
        label="价格"
        width="90">
      </el-table-column>
      <el-table-column
        prop="detail"
        label="详情"
        width="250">
      </el-table-column>
      <el-table-column
        prop="pic"
        label="图片"
        width="150">
        <template slot-scope="scope">
          <el-popover
            placement="right"
            title=""
            trigger="hover">
            <img src="../assets/itemImg/timg.jpg"/>
            <img slot="reference" src="../assets/itemImg/timg.jpg" :alt="scope.row.pic" style="max-height: 50px;max-width: 130px">
          </el-popover>
        </template>
      </el-table-column>
      <el-table-column
        prop="createtime"
        label="创建时间"
        width="230">
      </el-table-column>
      <el-table-column
        prop="action"
        label="操作">
        <template slot-scope="scope">
          <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">Edit</el-button>
          <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">Delete</el-button>
        </template>
    </el-table-column>
    </el-table>
    <div class="block" style="margin-left: 750px">
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-sizes="[5, 10, 15, 20]"
        :page-size="pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="pageTotal">
      </el-pagination>
    </div>
  </div>

</template>
<script>
  //引入vue实例
  import VueEvent from  '../model/VueEvent.js';

  //通过resource请求
  export default {
    name: 'Bar',
    action: '修改',
    data() {
      return {
        options: [{
          value: '1',
          label: '编号'
        }, {
          value: '2',
          label: '商品名'
        }, {
          value: '3',
          label: '价格'
        }, {
          value: '4',
          label: '详情'
        }],
        value1: '',
        id: 1,
        user: [],
        input: '',
        checked: true,
        multipleSelection: [],
        dataListLoading: false,
        currentPage: 1,
        pageSize: 5,
        pageTotal: 0,
        token: [],
        value:[]
      }
    },
    mounted() {
      this.getDataList();
      VueEvent.$on("to-header",function (data) {
        console.log(data)
      })
      },
    methods: {
      getDataList() {
        this.dataListLoading = true
        this.token = localStorage.getItem("list");
        this.$http.get('/api/article/get', {
          emulateJSON: true
        }).then(function (response) {
          // 这里是处理正确的回调
          console.log(response)
          this.pageTotal = response.data.length
          this.user = response.data
          // this.articles = response.data["subjects"] 也可以
        }, function (response) {
          // 这里是处理错误的回调
          console.log(response)
        });
        this.dataListLoading = false
      },
      timestamp(url) {
        //  var getTimestamp=Math.random();
        var getTimestamp = new Date().getTime();
        if (url.indexOf("?") > -1) {
          url = url + "&timestamp=" + getTimestamp
        } else {
          url = url + "?timestamp=" + getTimestamp
        }
        return url;
      },
      /*handleSelectionChange(val) {
        this.multipleSelection = val;
      },*/
      handleSizeChange: function (val) {
        this.pageSize = val
        console.log(`每页 ${val} 条`);
      },
      handleCurrentChange: function (val) {
        this.currentPage = val
        console.log(`当前页: ${val}`);
      },
      handleEdit(index, row) {
        console.log(index, row);
      },
      handleDelete(index, row) {
        console.log(index, row);
      }
    }
  }

</script>

<style>
</style>
