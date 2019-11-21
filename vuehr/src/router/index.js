import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/Login'
import HelloWorld from '@/components/HelloWorld'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Login',
      component: Login,
      hidden:true
    },{
      path: '/HelloWorld',
      name: '主页',
      component: HelloWorld,
      hidden: true,
      meta: {
        requireAuth: true
      }
    }
  ]
})
