<template>
 
  
  <body>
    
    <h1>
      {{ msg }}
    </h1>
  </body>

</template>

<script >
import NavBar from './NavBar.vue';

export default{
  components:{NavBar},
  name:'Hello World',
  data(){
    return{
      msg:'hola'
    }
  },
  mounted(){
    fetch("http://localhost:8080/api/messages/hello")
    .then((response)=>response.text())
    .then((data)=>{
      
      this.msg = data;
    })
    .catch((error) => {
        console.error("Error fetching data:", error);
      });
  }
}

</script>




