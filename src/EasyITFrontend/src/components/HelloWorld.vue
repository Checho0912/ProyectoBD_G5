<template>


  <body>

    <table class="table table-bordered text-center my-3">
      <thead>
          <tr>
              <th scope="col">ID Country</th>
              <th scope="col">ID Name</th>
              <th scope="col">Region ID</th>
              
          </tr>
      </thead>
      <tbody>
          <tr v-for="country in countries" :key="country.idCountry" >
              <td>{{country.idCountry}}</td>
              <td>{{country.country_Name}}</td>
              <td>{{country.region_id}}</td>
          </tr>
          
      </tbody>
  </table>
  </body>

</template>

<script>
import axios from 'axios';
import NavBar from './NavBar.vue';

export default {
  name: 'Hello World',
  data() {
    return {
      countries:[],
    }
  },
  mounted() {
    this.fetchCountries();
  }, 
  methods: {
    async fetchCountries() {
      try {
        const response = await axios.get('http://localhost:8080/api/messages/hello');
        this.countries = response.data;
        
      } catch (error) {
        
        console.error(error);
      }
    }
  }
};

</script>
