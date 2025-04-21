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
                <button v-else class="btn  btn-success" data-bs-toggle="modal" data-bs-target="#modalAsignarUsuario"
                  @click="prepararAsignacion(dispositivo)">
                  Asignar usuario
                </button>
                <button type="button" data-bs-target="#modalActualizarDispositivo" data-bs-toggle="modal"
                  class="btn btn-warning mx-2" @click=" prepararActualizar(dispositivo)">Actualizar</button>
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


    <!-- Modal: Asignar Usuario -->
    <div class="modal fade" id="modalAsignarUsuario" tabindex="-1" aria-labelledby="modalAsignarUsuarioLabel"
      aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <form @submit.prevent="asignarDispositivo">
            <div class="modal-header">
              <h5 class="modal-title" id="modalAsignarUsuarioLabel">Asignar Usuario</h5>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Cerrar"></button>
            </div>
            <div class="modal-body">
              <p><strong>ID del Dispositivo:</strong> {{ dispositivoSeleccionado?.idDispositivo }}</p>
              <p><strong>Modelo:</strong> {{ dispositivoSeleccionado?.modelo }}</p>
              <p><strong>Manufacturador:</strong> {{ dispositivoSeleccionado?.manufacturador }}</p>
              <p><strong>Número serial:</strong> {{ dispositivoSeleccionado?.numeroSerial }}</p>
              <div class="mb-3">
                <label class="form-label">ID del Usuario</label>
                <input type="number" class="form-control" v-model="usuarioAsignado" />
              </div>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
              <button type="submit" class="btn btn-success">Asignar</button>
            </div>
          </form>
        </div>
      </div>
    </div>

    <!-- Modal: Actualizar Dispositivo -->
    <div class="modal fade" id="modalActualizarDispositivo" tabindex="-1"
      aria-labelledby="modalActualizarDispositivoLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <form @submit.prevent="confirmarActualizacion">
            <div class="modal-header">
              <h5 class="modal-title" id="modalActualizarDispositivoLabel">Actualizar Dispositivo</h5>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Cerrar"></button>
            </div>
            <div class="modal-body" v-if="dispositivoActualizar">
              <input type="hidden" v-model="dispositivoActualizar.idDispositivo" />
              <div class="mb-3">
                <label class="form-label">Tipo</label>
                <input type="text" class="form-control" v-model="dispositivoActualizar.tipoDispositivo" />
              </div>
              <div class="mb-3">
                <label class="form-label">Manufacturador</label>
                <input type="text" class="form-control" v-model="dispositivoActualizar.manufacturador" />
              </div>
              <div class="mb-3">
                <label class="form-label">Modelo</label>
                <input type="text" class="form-control" v-model="dispositivoActualizar.modelo" />
              </div>
              <div class="mb-3">
                <label class="form-label">Número Serial</label>
                <input type="text" class="form-control" v-model="dispositivoActualizar.numeroSerial" />
              </div>
              <div class="mb-3">
                <label class="form-label">Estado</label>
                <input type="text" class="form-control" v-model="dispositivoActualizar.statusActual" />
              </div>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
              <button type="submit" class="btn btn-primary">Actualizar</button>
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
      usuarioAsignado: null,
      dispositivoSeleccionado: null,
      dispositivoActualizar: null,
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
    },
    prepararAsignacion(dispositivo) {
      this.dispositivoSeleccionado = dispositivo;
    },
    async asignarDispositivo() {
      try {
        await axios.post("http://localhost:8080/dispositivo/asignarDispositivo", null, {
          params: {
            idDispositivo: this.dispositivoSeleccionado.idDispositivo,
            idUsuario: this.usuarioAsignado
          }
        });

        // limpia la lista y la vuelve a renderizar
        this.fetchDispositivosByView();


        alert("Usuario asignado exitosamente");
        // Reinicia estados
        this.dispositivoSeleccionado = null;
        this.usuarioAsignado = null;
      } catch (error) {
        console.error("Error al asignar dispositivo:", error);
        alert("No se pudo asignar el dispositivo.");
      }
    },
    prepararActualizar(dispositivo) {
      this.dispositivoActualizar = dispositivo;
    },
    async confirmarActualizacion() {


      try {
        await axios.post("http://localhost:8080/dispositivo/update", this.dispositivoActualizar);

        // Refresca lista
        this.fetchDispositivosByView();

       

        
        alert("Dispositivo actualizado correctamente.");
      } catch (error) {
        console.error("Error al actualizar el dispositivo:", error);
        alert("Ocurrió un error al actualizar el dispositivo.");
      }
      // Limpia los datos
      this.dispositivoActualizar = null;

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