<template>
  <div>
    <ul v-if="showTable">
      <li v-for="member in membersList" :key="member.tag" class="lista"> {{ member.name }}</li>
    </ul>
    
    <p> <router-link to="/clubs">Administração de Clubes</router-link> </p>

    <div @click="testeChamada"> Teste </div>

  </div>
</template>

<script>
import axios from "axios"
import VueRouter from 'vue-router'
import Vue from 'vue'

Vue.use(VueRouter)

export default {
  name: 'App',

  data() {
    return {
      membersList: [],
      showTable: false
    }
  },

  created() {
    console.log("created")
    axios.get('http://localhost:2222/members')
      .then(response => {
        console.log("then : ", response.data.items)
        this.membersList = response.data.items;
        this.showTable = true;
      })
      .catch(error => {
        console.log(error);
      })
  },
  methods: {
    testeChamada() {
     console.log('botao 2');
     window.location.assign('/clubs')
     //this.$router.push('/clubs').then(() => {console.log('then router')}).catch(() => { console.log('catch router') });
     console.log('botao 2 - fim');
    },

  },
}
</script>

<style>
.lista {
  color: blue;
}
</style>

