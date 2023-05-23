import Vue from 'vue'
import axios from 'axios'
import VueRouter from 'vue-router'
import router from './router'
import FrontPage from './components/FrontPage.vue'
import '../../../../node_modules/bootstrap/dist/js/bootstrap.min.js';
import '../../../../node_modules/bootstrap/dist/css/bootstrap.min.css';

Vue.use(axios)
Vue.use(VueRouter)

new Vue({
    router,
    render: h => h(FrontPage)
    }).$mount('#front');