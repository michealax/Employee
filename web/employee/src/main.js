import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import index from './router/index'

Vue.config.productionTip = false
Vue.use(ElementUI);

new Vue({
    router: index,
    render: h => h(App),
}).$mount('#app');

