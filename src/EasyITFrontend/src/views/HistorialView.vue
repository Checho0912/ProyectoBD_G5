<script setup>
import NavBar from '@/components/NavBar.vue';

</script>
<template>
    <main>
        <NavBar />
        <div class = "p-5">
            <div class="my-2">

                <h1 class="text-center ">
                    Historial de movimientos
                </h1>
                <div class="row my-4">
                    <div class="container-fluid col mx-2">
                        <h2 class="text-center">Entregas</h2>
                        <table class="table table-bordered text-center my-3">
                            <thead>
                                <tr>
                                    <th v-for="(value, key) in entregas[0]" :key="key" scope="col">
                                        {{ key }}
                                    </th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr v-for="entrega in entregas" :key="entrega.idEntrega || Math.random()">
                                    <td v-for="(value, key) in entrega" :key="key">{{ value }}</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="container-fluid col mx-2">
                        <h2 class="text-center">Ingresos</h2>
                        <table class="table table-bordered text-center my-3">
                            <thead>
                                <tr>
                                    <th v-for="(value, key) in ingresos[0]" :key="key" scope="col">
                                        {{ key }}
                                    </th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr v-for="ingreso in ingresos" :key="ingreso.idIngreso || Math.random()">
                                    <td v-for="(value, key) in ingreso" :key="key">{{ value }}</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>

                </div>
                <div class="row">

                    <div class="container-fluid col my-4 mx-2">
                        <h2 class="text-center">Logs Tickets</h2>
                        <table class="table table-bordered text-center my-3">
                            <thead>
                                <tr>
                                    <th v-for="(value, key) in logTickets[0]" :key="key" scope="col">
                                        {{ key }}
                                    </th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr v-for="logTicket in logTickets" :key="logTicket.idLog || Math.random()">
                                    <td v-for="(value, key) in logTicket" :key="key">{{ value }}</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>



            </div>
        </div>
    </main>
</template>
<script>
import axios from 'axios'

export default {
    name: 'HistorialView',
    data() {
        return {
            ingresos: [],
            entregas: [],
            logTickets: [],
        }
    },
    mounted() {
        this.getIngresos(),
            this.getEntregas(),
            this.getLogs()
    },
    methods: {
        async getIngresos() {
            try {
                const response = await axios.get('http://localhost:8080/historial/ingresos');
                this.ingresos = response.data;

            } catch (error) {
                console.error('Error al obtener ingresos:', error)
            }
        },
        async getEntregas() {
            try {
                const response = await axios.get('http://localhost:8080/historial/entregas');
                this.entregas = response.data;

            } catch (error) {
                console.error('Error al obtener entregas:', error)
            }
        },
        async getLogs() {
            try {
                const response = await axios.get('http://localhost:8080/historial/logTickets');
                this.logTickets = response.data;

            } catch (error) {
                console.error('Error al obtener Logs:', error)
            }
        }
    }
};
</script>


<style>
.table-controls {
    margin-top: 200px;
    margin-left: 100px;
    margin-right: 100px
}
</style>