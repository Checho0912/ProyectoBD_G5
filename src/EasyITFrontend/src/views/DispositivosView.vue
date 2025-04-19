<script setup>
import NavBar from '@/components/NavBar.vue';

</script>
<template>
  <main>
    <NavBar />


    <div class="my-5">
      <h1 class="text-center ">
        Dispositivos
      </h1>

      <div class="container">
        <div class="row align-items-end">
          <!-- Botón Crear -->
          <div class="col-md-4 mb-2">
            <button type="button" class="btn btn-primary w-100" data-bs-toggle="modal"
              data-bs-target="#modalAgregarDispositivo">
              Agregar Dispositivo
            </button>
          </div>

          <!-- Filtro por vista -->
          <div class="col-md-4 mb-2">
            <label for="viewSelector" class="form-label">Filtrar vista:</label>
            <select id="viewSelector" class="form-select" v-model="selectedView" @change="fetchDispositivosByView">
              <option value="getProcedure">Todos</option>
              <option value="disponibles">Disponibles</option>
              <option value="asignados">Asignados</option>
              <option value="reparacion">En Reparación</option>
            </select>
          </div>

          <!-- Espacio futuro o reset -->
          <div class="col-md-4 mb-2">
            <label for="search" class="form-label">Buscar por ID:</label>
            <div class="input-group">
              <input type="text" id="search" v-model="searchQuery" class="form-control" placeholder="Buscar" />
              <button class="btn btn-outline-primary bi bi-search" @click="buscarPorId">
                Buscar
              </button>

            </div>
          </div>
        </div>
      </div>



      <div class="container-fluid">

        <table class="table table-bordered text-center my-3">
          <thead>
            <tr>
              <!-- <th scope="col">ID Dispositivo</th>
                            <th scope="col">tipo</th>
                            <th scope="col">manufacturador</th>
                            <th scope="col">modelo</th>
                            <th scope="col">numeroSerial</th>
                            <th scope="col">idUsuario</th>
                            <th scope="col"></th> -->
              <th v-for="(value, key) in dispositivos[0]" :key="key" scope="col">
                {{ key }}
              </th>
              <th scope="col">Acciones</th>

            </tr>
          </thead>
          <tbody>
            <tr v-for="dispositivo in dispositivos" :key="dispositivo.idDispositivo || dispositivo.id || Math.random()">
              <td v-for="(value, key) in dispositivo" :key="key">{{ value }}</td>

              <td>
                <span v-if="dispositivo.idUsuario !== null"></span>
                <button v-else class="btn  btn-success" @click="asignarDispositivo(dispositivo)">
                  Asignar usuario
                </button>
                <button type="button" class="btn btn-warning mx-2">Actualizar</button>
                <button type="button" class="btn btn-danger mx-2"
                  @click="deleteDispositivo(dispositivo.idDispositivo)">Borrar</button>
              </td>
            </tr>
          </tbody>
        </table>
      </div>

    </div>

    <!-- Modal: Agregar Dispositivo -->
    <div class="modal fade" id="modalAgregarDispositivo" tabindex="-1" aria-labelledby="modalAgregarDispositivoLabel"
      aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <form @submit.prevent="crearDispositivo">
            <div class="modal-header">
              <h5 class="modal-title" id="modalAgregarDispositivoLabel">Agregar Dispositivo</h5>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Cerrar"></button>
            </div>
            <div class="modal-body">
              <div class="mb-3">
                <label class="form-label">Tipo de Dispositivo</label>
                <input type="text" class="form-control" v-model="nuevoDispositivo.tipoDispositivo" />
              </div>
              <div class="mb-3">
                <label class="form-label">Manufacturador</label>
                <input type="text" class="form-control" v-model="nuevoDispositivo.manufacturador" />
              </div>
              <div class="mb-3">
                <label class="form-label">Modelo</label>
                <input type="text" class="form-control" v-model="nuevoDispositivo.modelo" />
              </div>
              <div class="mb-3">
                <label class="form-label">Número de Serial</label>
                <input type="text" class="form-control" v-model="nuevoDispositivo.numeroSerial" />
              </div>

            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
              <button type="submit" class="btn btn-primary">Guardar</button>
            </div>
          </form>
        </div>
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
      dispositivos: [],
      selectedView: 'getProcedure',
      searchQuery: '',
      nuevoDispositivo: {
        tipoDispositivo: '',
        manufacturador: '',
        modelo: '',
        numeroSerial: '',
      },
    }
  },
  mounted() {
    this.fetchDispositivosByView();
  },
  methods: {
    async fetchDispositivosByView() {
      const viewEndpoints = {
        getProcedure: '/dispositivo/getProcedure',
        disponibles: '/dispositivo/disponibles',
        asignados: '/dispositivo/asignados',
        reparacion: '/dispositivo/reparacion'
      };
      const url = `http://localhost:8080${viewEndpoints[this.selectedView]}`;

      try {
        const response = await axios.get(url);
        this.dispositivos = response.data;
        //console.log(this.dispositivos);
      } catch (error) {

        console.error(error);
      }
    },
    async deleteDispositivo(id) {
      if (confirm("¿Estás seguro de que deseas eliminar este dispositivo?")) {
        try {
          await axios.delete(`http://localhost:8080/dispositivo/${id}`);
          this.dispositivos = this.dispositivos.filter(d => d.idDispositivo !== id);
        } catch (error) {
          console.error("Error al eliminar el dispositivo:", error);
          alert("Ocurrió un error al intentar eliminar el dispositivo.");
        }
      }
    },
    async buscarPorId() {
      const id = this.searchQuery;

      if (!id) {
        alert("Ingresa un ID válido.");
        return;
      }

      try {
        const response = await axios.get(`http://localhost:8080/dispositivo/get/${id}`);
        this.dispositivos = response.data;
      } catch (error) {
        console.error("Error al buscar dispositivo:", error);
        alert("No se encontró el dispositivo.");
      }
    },
    async crearDispositivo() {
      try {
        await axios.post("http://localhost:8080/dispositivo/insertProcedure/nuevoDispositivo", {
          ...this.nuevoDispositivo // omit user ID
        });

        // Recargar tabla después de crear
        this.fetchDispositivosByView();

        // Cerrar modal manualmente
        const modal = bootstrap.Modal.getInstance(document.getElementById("modalAgregarDispositivo"));
        modal.hide();

        // Reset form
        this.nuevoDispositivo = {
          tipoDispositivo: '',
          manufacturador: '',
          modelo: '',
          numeroSerial: '',
        };
      } catch (error) {
        console.error("Error al crear dispositivo:", error);
        console.log("Ocurrió un error al crear el dispositivo.");
      }
    }

  }
};

</script>
<style scoped>
.table-controls {

  margin-left: 100px;
  margin-right: 100px
}
</style>