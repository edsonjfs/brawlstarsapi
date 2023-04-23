import Vue from 'vue'
import App from './components/App.vue'
import axios from 'axios'

Vue.use(axios)

new Vue({
render: h => h(App)
}).$mount('#home');
