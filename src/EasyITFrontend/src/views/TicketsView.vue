<script setup>
import NavBar from '@/components/NavBar.vue';

</script>
<template>
    <main>
        <NavBar />


        <div class="my-5">
            <h1 class="text-center ">
                Tickets
            </h1>

            <div class="container">
                <div class="row align-items-end">
                    <!-- Botón Crear -->
                    <div class="col-md-4 mb-2">
                        <button type="button" class="btn btn-primary w-100" data-bs-toggle="modal"
                            data-bs-target="#modalCrearTicket">
                            Crear un Ticket
                        </button>
                    </div>

                    <!-- Filtro por vista -->
                    <div class="col-md-4 mb-2">
                        <label for="viewSelector" class="form-label">Filtrar vista:</label>
                        <select id="viewSelector" class="form-select" v-model="selectedView"
                            @change="fetchTicketsByView">
                            <option value="getAll">Todos</option>
                            <option value="enEspera">En espera</option>
                            <option value="asignado">Asignando</option>
                            <option value="reparando">En reparación</option>
                            <option value="finalizado">Finalizado</option>

                        </select>
                    </div>

                    <!-- Espacio futuro o reset -->
                    <div class="col-md-4 mb-2">
                        <label for="search" class="form-label">Buscar por ID:</label>
                        <div class="input-group">
                            <input type="text" id="search" v-model="searchQuery" class="form-control"
                                placeholder="Buscar" />
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
                            <th v-for="(value, key) in tickets[0]" :key="key" scope="col">
                                {{ key }}
                            </th>
                            <th scope="col">Acciones</th>

                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="ticket in tickets" :key="ticket.idTicket || ticket.id || Math.random()">
                            <td v-for="(value, key) in ticket" :key="key">{{ value }}</td>

                            <td>
                                <!-- Asignar admin si no tiene uno -->
                                <button v-if="ticket.idAdministrador == null" class="btn btn-success btn-sm mx-1"
                                    data-bs-toggle="modal" data-bs-target="#modalAsignarAdmin"
                                    @click="prepararAsignacion(ticket)">
                                    Asignar admin
                                </button>

                                <!-- Iniciar resolución si está en ESPERA -->
                                <button v-if="ticket.status === 'ESPERA'" class="btn btn-info btn-sm mx-1"
                                    @click="iniciarResolucion(ticket.idTicket)">
                                    Iniciar resolución
                                </button>

                                <!-- Finalizar si está REPARANDO -->
                                <button v-if="ticket.status === 'REPARANDO'" class="btn btn-success btn-sm mx-1"
                                    @click="finalizarResolucion(ticket.idTicket)">
                                    Finalizar
                                </button>

                                <!-- Actualizar disponible siempre -->
                                <button type="button" class="btn btn-warning btn-sm mx-1" data-bs-toggle="modal"
                                    data-bs-target="#modalActualizarTicket" @click="prepararActualizar(ticket)">
                                    Actualizar
                                </button>

                                <!-- Eliminar disponible siempre -->
                                <button class="btn btn-danger btn-sm mx-1 my-2" @click="deleteTicket(ticket.idTicket)">
                                    Borrar
                                </button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>

        <!-- Modal de creación de Ticket-->
        <!-- Modal de creación de Ticket-->
        <div class="modal fade" id="modalCrearTicket" tabindex="-1" aria-labelledby="modalCrearTicketLabel"
            aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form @submit.prevent="crearTicket">
                        <div class="modal-header">
                            <h5 class="modal-title" id="modalCrearTicketLabel">Crear Nuevo Ticket</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                aria-label="Cerrar"></button>
                        </div>
                        <div class="modal-body">
                            <!-- Tipo de Ticket -->
                            <div class="mb-3">
                                <label class="form-label">Tipo de Ticket</label>
                                <select class="form-select" v-model="nuevoTicket.tipoTicket" required>
                                    <option disabled value="">Seleccione un tipo</option>
                                    <option v-for="tipo in tipoTickets" :key="tipo.idTipoTicket"
                                        :value="tipo.idTipoTicket">
                                        {{ tipo.nombre }}
                                    </option>
                                </select>
                            </div>

                            <!-- ID del Dispositivo -->
                            <div class="mb-3">
                                <label class="form-label">ID del Dispositivo</label>
                                <input type="number" class="form-control" v-model="nuevoTicket.idDispositivo" />
                            </div>

                            <!-- Descripción -->
                            <div class="mb-3">
                                <label class="form-label">Descripción</label>
                                <textarea class="form-control" v-model="nuevoTicket.descripcion" required></textarea>
                            </div>

                            <!-- ID del Usuario -->
                            <div class="mb-3">
                                <label class="form-label">ID del Usuario</label>
                                <input type="number" class="form-control" v-model="nuevoTicket.idUsuario" required />
                            </div>
                        </div>

                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                            <button type="submit" class="btn btn-primary">Crear Ticket</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <!-- Modal: Asignar Administrador -->
        <div class="modal fade" id="modalAsignarAdmin" tabindex="-1" aria-labelledby="modalAsignarUsuarioLabel">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form @submit.prevent="asignarDispositivo">
                        <div class="modal-header">
                            <h5 class="modal-title" id="modalAsignarUsuarioLabel">Asignar Usuario</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                aria-label="Cerrar"></button>
                        </div>
                        <div class="modal-body">
                            <p><strong>ID del Ticket:</strong> {{ ticketSeleccionado?.idTicket }}</p>
                            <p><strong>Status:</strong> {{ ticketSeleccionado?.status }}</p>
                            <p><strong>Descripcion:</strong> {{ ticketSeleccionado?.descripcion }}</p>
                            <p><strong>Tipo de Ticket:</strong> {{ getTipoNombre(ticketSeleccionado?.tipoTicket) }}</p>
                            <div class="mb-3">
                                <label class="form-label">ID del Administrador</label>
                                <input type="number" class="form-control" v-model="administradorAsignado" />
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

        <!-- Modal: Actualizar Ticket -->
        <div class="modal fade" id="modalActualizarTicket" tabindex="-1" aria-labelledby="modalActualizarTicketLabel"
            aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form @submit.prevent="actualizarTicket">
                        <div class="modal-header">
                            <h5 class="modal-title" id="modalActualizarTicketLabel">Actualizar Ticket</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                aria-label="Cerrar"></button>
                        </div>
                        <div class="modal-body" v-if="ticketActualizar">
                            <input type="hidden" v-model="ticketActualizar.idTicket" />

                            <div class="mb-3">
                                <label class="form-label">Tipo de Ticket</label>
                                <select class="form-select" v-model="ticketActualizar.tipoTicket">
                                    <option disabled value="">Seleccione un tipo</option>
                                    <option v-for="tipo in tipoTickets" :key="tipo.idTipoTicket"
                                        :value="tipo.idTipoTicket">
                                        {{ tipo.nombre }}
                                    </option>
                                </select>
                            </div>

                            <div class="mb-3">
                                <label class="form-label">ID Dispositivo</label>
                                <input type="number" class="form-control" v-model="ticketActualizar.idTicket" />
                            </div>

                            <div class="mb-3">
                                <label class="form-label">Descripción</label>
                                <textarea class="form-control" v-model="ticketActualizar.descripcion"></textarea>
                            </div>

                            <div class="mb-3">
                                <label class="form-label">ID Usuario</label>
                                <input type="number" class="form-control" v-model="ticketActualizar.idUsuario" />
                            </div>

                           

                            <div class="mb-3">
                                <label class="form-label">Estado</label>
                                <input type="text" class="form-control" v-model="ticketActualizar.idAdministrador" />
                            </div>
                             <div class="mb-3">
                                <label class="form-label">Estado</label>
                                <input type="text" class="form-control" v-model="ticketActualizar.status" />
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
    name: 'TicketsView',
    data() {
        return {
            tickets: [],
            tipoTickets: [],
            selectedView: 'getAll',
            searchQuery: '',
            nuevoTicket: {
                tipoTicket: '',
                idDispositivo: '',
                descripcion: '',
                fechaIngreso: '',
                status: '',
                fechaResolucion: null,
                accionesTomadas: null,
                idAdministrador: null,
                idUsuario: null
            },
            administradorAsignado: null,
            ticketSeleccionado: null,
            ticketActualizar: null,
            accionesTomadas: '',
        }
    }, mounted() {
        this.fetchTicketsByView();
        this.getTipoTickets();
    }, methods: {

        async fetchTicketsByView() {
            const viewEndpoints = {
                getAll: '/ticket/getAll',
                enEspera: '/ticket/enEspera',
                asignado: '/ticket/asignando',
                finalizado: '/ticket/finalizado',
                reparando: '/ticket/reparando'
            };
            const url = `http://localhost:8080${viewEndpoints[this.selectedView]}`;

            try {
                const response = await axios.get(url);
                this.tickets = response.data;
                //console.log(this.dispositivos);
            } catch (error) {

                console.error(error);
            }
        },
        async getTipoTickets() {
            const url = 'http://localhost:8080/ticket/getTipos';
            try {
                const response = await axios.get(url);
                this.tipoTickets = response.data;

            } catch (error) {

                console.error(error);
            }
        },
        async buscarPorId() {
            const id = this.searchQuery;

            if (!id) {
                alert("Ingresa un ID válido.");
                return;
            }

            try {
                const response = await axios.get(`http://localhost:8080/ticket/getById/${id}`);
                this.tickets = response.data;
            } catch (error) {
                console.error("Error al buscar ticket:", error);

            }
        },
        async crearTicket() {

            try {
                await axios.post("http://localhost:8080/ticket/crearTicket", {
                    ...this.nuevoTicket // omit user ID
                });

                // Recargar tabla después de crear
                this.fetchTicketsByView();

            } catch (error) {
                alert.error("Error al crear dispositivo:", error);
                console.log("Ocurrió un error al crear el dispositivo.");
            }
        },
        async deleteTicket(id) {
            if (confirm("¿Estás seguro de que deseas eliminar este ticket?")) {
                try {
                    await axios.delete(`http://localhost:8080/ticket/delete/${id}`);

                    this.tickets = this.tickets.filter(d => d.idTicket !== id);
                } catch (error) {
                    console.error("Error al eliminar el ticket:", error);
                    alert("Ocurrió un error al intentar eliminar el ticket.");
                }
            }
        },
        async prepararAsignacion(ticket) {
            this.ticketSeleccionado = ticket;
        },
        getTipoNombre(id) {
            const tipo = this.tipoTickets.find(t => t.idTipoTicket === id);
            return tipo ? tipo.nombre : 'Desconocido';
        },
        async asignarDispositivo() {
            try {
                await axios.post("http://localhost:8080/ticket/asignar", null, {
                    params: {
                        idTicket: this.ticketSeleccionado.idTicket,
                        idAdministrador: this.administradorAsignado
                    }
                });


                this.fetchTicketsByView();




                this.ticketSeleccionado = null;
                this.adminAsignado = null;

                alert("Administrador asignado correctamente.");
            } catch (error) {
                console.error("Error al asignar administrador:", error);
                alert("No se pudo asignar el administrador.");
            }
        },
        async iniciarResolucion(idTicket) {
            try {
                await axios.post('http://localhost:8080/ticket/iniciarResolucion', null, {
                    params: {
                        idTicket: idTicket
                    }
                });

                alert("Resolución iniciada correctamente.");
                this.fetchTicketsByView(); // Refresh the table after action
            } catch (error) {
                console.error("Error al iniciar resolución del ticket:", error);
                alert("No se pudo iniciar la resolución del ticket.");
            }

        },
        async finalizarResolucion(idTicket) {
            try {
                const acciones = prompt("Acciones tomadas para finalizar el ticket:");

                if (!acciones) {
                    alert("Debes ingresar las acciones realizadas.");
                    return;
                }

                await axios.post('http://localhost:8080/ticket/finalizarResolucion', null, {
                    params: {
                        idTicket: idTicket,
                        accionesTomadas: acciones
                    }
                });

                alert("Ticket finalizado correctamente.");
                this.fetchTicketsByView(); // Refresh the list

            } catch (error) {
                console.error("Error al finalizar resolución del ticket:", error);
                alert("No se pudo finalizar la resolución del ticket.");
            }
        }, prepararActualizar(ticket) {
            this.ticketActualizar = ticket; // Copia los datos para evitar mutaciones en vivo
        }

    }
}

</script>
<style>
.table-controls {
    margin-top: 200px;
    margin-left: 100px;
    margin-right: 100px
}
</style>