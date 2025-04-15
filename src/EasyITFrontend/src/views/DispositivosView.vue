<script setup>
import NavBar from '@/components/NavBar.vue';

</script>
<template>
    <main>
        <NavBar />

        <div class="table-controls">
            
            <div class="row text-center">
                <div class="col">
                    <button type="button" class="btn btn-primary mx-2">Crear</button>
                    
                    <button type="button" class="btn btn-primary mx-2">Consultar</button>
                    
                </div>
                <div class="col">

                </div>
                <div class="col">

                </div>
                <div class="col">

                </div>

            </div>


            <div class="container-fluid">

                <table class="table table-bordered text-center my-3">
                    <thead>
                        <tr>
                            <th scope="col">ID Dispositivo</th>
                            <th scope="col">tipo</th>
                            <th scope="col">manufacturador</th>
                            <th scope="col">modelo</th>
                            <th scope="col">numeroSerial</th>
                            <th scope="col">idUsuario</th>
                            
                        </tr>
                    </thead>
                    <tbody>
                      <tr v-for="dispositivo in dispositivos" :key="dispositivo.idDispositivo" >
                        <td>{{dispositivo.idDispositivo}}</td>
                        <td>{{dispositivo.tipoDispositivo}}</td>
                        <td>{{dispositivo.manufacturador}}</td>
                        <td>{{dispositivo.modelo}}</td>
                        <td>{{dispositivo.numeroSerial}}</td>
                        <td>{{dispositivo.idUsuario}}</td>
                        <td><button type="button" class="btn btn-warning mx-2">Actualizar</button><button type="button" class="btn btn-danger mx-2">Borrar</button></td>
                    </tr>
                    </tbody>
                </table>
            </div>

        </div>


    </main>
</template>



<script>
import axios from 'axios';

export default {
  name: 'DispositivosView',
  data() {
    return {
      dispositivos:[],
    }
  },
  mounted() {
    this.fetchDispositivos();
  }, 
  methods: {
    async fetchDispositivos() {
      try {
        const response = await axios.get('http://localhost:8080/dispositivo/chorizo');
        this.dispositivos = response.data;
       //console.log(this.dispositivos);
      } catch (error) {
        
        console.error(error);
      }
    }
  }
};

</script>
<style>

.table-controls{
    margin-top:200px;
    margin-left: 100px;
    margin-right:100px
}
</style>