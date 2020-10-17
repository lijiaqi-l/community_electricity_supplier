<template>
  <el-form
    :model="ruleForm"
    :rules="rules"
    ref="ruleForm"
    class="login-container"
    label-position="left"
    label-width="0px"
    v-loading="loading"
  >
    <h3 class="login_title">系统登录</h3>
    <el-form-item prop="username">
      <el-input type="text" auto-complete="off" placeholder="账号" v-model="ruleForm.username"></el-input>
    </el-form-item>
    <el-form-item prop="password">
      <el-input type="password" auto-complete="off" placeholder="密码" v-model="ruleForm.password"></el-input>
    </el-form-item>
    <el-form-item prop="code">
      <div class="el-form-item__content" style="margin-left: 0px;">
        <div class="el-row" span="24">
          <div class="el-col el-col-16">
            <div class="el-input el-input--prefix">
              <!---->
              <input
                type="text"
                autocomplete="off"
                maxlength="4"
                placeholder="请输入验证码"
                class="el-input__inner"
                v-model="ruleForm.code"
              />
            </div>
          </div>
          <div class="el-col el-col-8">
            <div class="login-code">
              <img :src="codeUrl" class="login-code-img" @click="codeOnclick()" />
            </div>
          </div>
        </div>
      </div>
    </el-form-item>

    <div>
      <el-checkbox class="login_remember" v-model="checked" label-position="left">记住密码</el-checkbox>
    </div>

    <el-form-item style="width: 100%">
      <el-button type="primary" style="width: 100%" @click="submitForm('ruleForm')">登录</el-button>
    </el-form-item>
  </el-form>
</template>
<style>
.login-container {
  border-radius: 15px;
  background-clip: padding-box;
  margin: 180px auto;
  width: 350px;
  padding: 35px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}
.login_title {
  margin: 0px auto 40px auto;
  text-align: center;
  color: #505458;
}
.login_remember {
  margin: 0px 0px 35px 0px;
  text-align: left;
}
</style>
<script>
export default {
  mounted(){
      this.codeOnclick();
  },
  methods: {
    //点击验证码触发的事件
    codeOnclick(){
        this.ruleForm.randomStr = new Date().getTime();
        this.codeUrl =  "http://localhost:9999/code?randomStr="+this.ruleForm.randomStr;
     },
    registry() {
      this.$router.replace({ path: "/registry" });
    },
    getUserInfo() {
      var $this = this;
      this.axios({
        method: "get",
        url: "http://localhost:9999/biz/admin/tUser/info",
        params: { access_token: localStorage.getItem("access_token") }
      }).then(function(res) {
        console.log("!!!!!!!")
        console.log("认证返回信息:{}", res);

        if (res.data.code == 200) {
          localStorage.setItem("username", res.data.obj.name);
          $this.$router.replace({ path: "/Home" });
          console.log("......");
        }
      });
    },
    submitForm(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          var $this = this;
          this.axios({
            method: "post",
            url: "http://localhost:9999/auth/oauth/token",
            params: this.ruleForm,
            auth: {
              username: "android",
              password: "android"
            }
          }).then(function(res) {
            console.log("认证返回信息:{}", res);
            localStorage.setItem("access_token", res.data.access_token);
            $this.getUserInfo();
          });
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    }
  },
  data() {
    return {
      loading: false,
      codeUrl:"",
      ruleForm: {
        username: "",
        password: "",
        grant_type: "password",
        code:"",
        randomStr:""
      },
      rules: {
        username: [
          { required: true, message: "请输入用户名", trigger: "blur" },
          { min: 3, max: 10, message: "长度在 3 到 10个字符", trigger: "blur" }
        ],
        password: [
          { required: true, message: "请输入密码", trigger: "blur" },
          { min: 1, max: 10, message: "长度在 1 到 10个字符", trigger: "blur" }
        ]
      },
      checked: false
    };
  }
};
</script>
