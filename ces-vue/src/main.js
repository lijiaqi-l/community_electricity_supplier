import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import VueRouter from 'vue-router';
import Login from './common/Login.vue';
import axios from 'axios';
import Home from './common/Home.vue'
import User from './common/User.vue'
import Role from './common/Role.vue'
import Goods from './common/Goods.vue'
import QRCode from "qrcode"; //引入生成二维码插件
axios.defaults.withCredentials=true;//让ajax携带cookie
Vue.prototype.axios = axios;
Vue.prototype.QRCode=QRCode;
Vue.use(ElementUI);
Vue.use(VueRouter);
const routes= [
  {path:"/",component:Login},
  {path:"/Home",component:Home,
    children:[
    {
    path:"/Home",
    name:"系统管理",
    component:Home,
    children:[{
      path:"/User",
      component:User,
      name:"用户管理"
    },
    {path:"/Role",component:Role,name:"角色管理"},
    {path:"/Goods",component:Goods}

  ]
    }
  ]
  }
]

const router = new VueRouter({
  routes
})
Vue.prototype.axios = axios;


//路由的钩子函数 表示路由之间的跳转必须经过此函数
router.beforeEach((to, from, next) => {
  console.log("要跳转的路径未：---->",to.path);
  if(to.path=='/'){
     localStorage.removeItem('username');
     next();
  }else{
    if(!localStorage.getItem('username')){
      next("/");
      return;
    }
    //请求后台查询登录用户对应的菜单
    initMenu(router);
    setTimeout(() => {
      next();
    }, 500);
  }
});

export  const initMenu=(router)=>{
  axios({
      url:"http://localhost:9999/upms/menu/getMenuByUserName",
      method:"get",
      params: {"access_token":localStorage.getItem("access_token")}
    }).then(function (param) { 
      console.log("根据当前登录用户的id动态获取权限菜单:{0}",param);
      if(param){
          //因为后台返回的是一个List 里面的component 不是vue 识别的组件，因此需要把List 转换成Vue 识别的对象
          var routes =  formRouters(param.data.obj);
          console.log("后台返回路由List 转换的结果为:{0}",routes);
          //把转换的结果赋值给 路由路径为/Home 的  children属性
          router.options.routes[1].children = routes;
          console.log("/Home children属性的值为:{0}",router.options.routes[1].children);
      }        
   })
}


//参数是从Menu表查出来的 List  
// [
//   {
//   path:"/Home",
//   name:"系统管理",
//   component:Home,
//   children:[{
//     path:"/User",
//     component:User,
//     name:"用户管理"
//   },
//   {path:"/role",component:Role,name:"角色管理"}
// ]
export const formRouters = (routers)=>{
  let array = [];
  routers.forEach(element => {
          let children = [];
          if(element.children && element.children instanceof Array){
              children =  formRouters(element.children);
          }
          let r = {
              path:element.path,
              component(resolve){
                  if(element.component.startsWith('User')){
                      require(['./common/' + element.component + '.vue'], resolve)
                  }else if(element.component.startsWith('Role')){
                      require(['./common/' + element.component + '.vue'], resolve)  
                  }
              },
              name:element.name,
              children:children
          }
          array.push(r);   
  });
  return array;
}



new Vue({
  el: '#app',
  router,
  render: h => h(App)
})
