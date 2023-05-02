import Vue from 'vue'
import App from './components/App.vue'
import axios from 'axios'
import VueRouter from 'vue-router'
import router from './router'
 
Vue.use(axios)
Vue.use(VueRouter)


new Vue({
router,
render: h => h(App)
}).$mount('#home');
