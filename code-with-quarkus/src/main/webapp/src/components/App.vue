<template>
  <div> 
    <ul v-if="showTable">
      <li v-for="member in membersList" :key="member.tag"> {{ member.name }}</li>
    </ul>
  </div>
</template>

<script>
import axios from "axios"

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
        console.log("then : ", response.data.items )
        this.membersList = response.data.items;
        this.showTable = true;
      })
      .catch(error => {
        console.log(error);
      })
  }
}
</script>

