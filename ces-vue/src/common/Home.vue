<template>
  <div>
    <el-container class="home-container">
      <el-header class="home-header">
        <i class="home_title" style="margin-right: 15px">进销存管理系统</i>
        <el-dropdown  @command="handleCommand">
            <span style="margin-right: 50px">欢迎{{this.username}}登录</span>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item command="a">退出</el-dropdown-item>
         
          </el-dropdown-menu>
        </el-dropdown>
      </el-header>

      <el-container>
        <el-aside width="200px" class="home-aside">
          <el-menu router>
              <!--一级菜单循环开始-->
            <el-submenu :index="index+''"  v-for=" (item,index) in this.$router.options.routes[1].children">
              <template slot="title">
                <i class="el-icon-message"></i>{{item.name}}
              </template>
              <!--二级菜单循环开始-->
              <el-menu-item-group > 
                <el-menu-item :index="sub.path" v-for="sub in item.children">{{sub.name}}</el-menu-item>

              </el-menu-item-group>

            </el-submenu>
          </el-menu>
        </el-aside>
        <el-main>
              <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>
<style>
.home-container {
  height: 100%;
  position: absolute;
  top: 0px;
  left: 0px;
  width: 100%;
}
.home-header {
  background-color: #20a0ff;
  color: #333;
  text-align: center;
  display: flex;
  align-items: center;
  justify-content: space-between;
  box-sizing: content-box;
  padding: 0px;
}
.home_title {
  color: #fff;
  font-size: 22px;
  display: inline;
  margin-left: 8px;
}
.home-aside {
  background-color: #ececec;
}
</style>

<script>
export default {
  data() {
    return {
      username: ""
    };
  },mounted(){
    console.log('home页面加载....this.$router.options.routes[1].children---->',this.$router.options.routes[1].children)
    this.username = localStorage.getItem('username');
  },methods:{
       handleCommand(command) {
         var $this = this;
         this.axios({
           method:'get',
           url: "http://localhost:9999/auth/admin/token/logout",
           params: { access_token: localStorage.getItem("access_token") }
         }).then(function(res){
            $this.$message(res.data.msg);
            if(res.data.code==200){
                localStorage.removeItem("username");
                $this.$router.replace({path:"/"});
            }
         })
      }
  }
};
</script>