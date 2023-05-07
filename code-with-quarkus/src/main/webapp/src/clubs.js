import Vue from 'vue'
import Clubs from './components/ClubAdministration.vue'
import axios from 'axios'
import VueRouter from 'vue-router'
import router from './router'
 
Vue.use(axios)
Vue.use(VueRouter)


new Vue({
router,
render: h => h(Clubs)
}).$mount('#clubs');
