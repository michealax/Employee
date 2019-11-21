import Vue from 'vue'
import Router from 'vue-router'
import Login from '../pages/Login';
import HelloWorld from '../components/HelloWorld';
import NotFound from '../components/404'
import Register from "../pages/Register";
import Profile from "../pages/Profile";

Vue.use(Router);


const index = new Router({
    routes: [
        {
            path: '/',
            name: '/',
            redirect: 'login',
            component: Login
        },
        {
            path: '/login',
            name: 'login',
            component: Login
        },
        {
            path: '/register',
            name: 'register',
            component: Register
        },
        {
            path: '/helloWorld',
            name: 'helloWorld',
            component: HelloWorld,
            meta: {
                auth: true
            }
        },
        {
            path: '/profile',
            name: 'profile',
            component: Profile,
            meta: {
                auth: true,
                roles: ['user']
            }
        },
        {
            path: '/404',
            name: "notFound",
            component: NotFound
        },
        {
            path: "*",
            redirect: "/404"
        }
    ],
    mode: 'history'
});

index.beforeEach((to, from, next) => {
    if (to.matched.some(record => record.meta.auth)) {  // 判断该路由是否需要登录权限
        if (sessionStorage.getItem('loginInfo')) {  // 判断当前用户的登录信息loginInfo是否存在
            if (to.meta.roles.length > 0){
                for (let i = 0; i < to.meta.roles.length; i++) {
                    if (role === to.meta.roles[i]) {
                        next()
                        break
                    } else if (i === to.meta.roles.length - 1) {
                        next({
                            path: '/Error'
                        })
                    }
                }
            } else {
                next()
            }


        } else {
            next({
                path: '/'
            })
        }
    } else {
        next();
    }
});

export default index
