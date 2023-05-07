import Vue from 'vue';
import VueRouter from 'vue-router';

import App from './components/App.vue';
import ClubAdministration from './components/ClubAdministration.vue';


Vue.use(VueRouter);

const routes = [
    {
      path: '/',
      component: App
    },
    {
      path: '/clubs',
      component: ClubAdministration
    },
];

const router = new VueRouter({
    mode: 'history',
    routes
  });

  export default router;
  