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
                    <button type="button" class="btn btn-primary mx-2">Actualizar</button>
                    <button type="button" class="btn btn-primary mx-2">Consultar</button>
                    <button type="button" class="btn btn-primary mx-2">Borrar</button>
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
                            <th scope="col">#</th>
                            <th scope="col">First</th>
                            <th scope="col">Last</th>
                            <th scope="col">Handle</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th scope="row">1</th>
                            <td>Mark</td>
                            <td>Otto</td>
                            <td>@mdo</td>
                        </tr>
                        <tr>
                            <th scope="row">2</th>
                            <td>Jacob</td>
                            <td>Thornton</td>
                            <td>@fat</td>
                        </tr>
                        <tr>
                            <th scope="row">3</th>
                            <td colspan="2">Larry the Bird</td>
                            <td>@twitter</td>
                        </tr>
                    </tbody>
                </table>
            </div>

        </div>


    </main>
</template>
<style>

.table-controls{
    margin-top:200px;
    margin-left: 100px;
    margin-right:100px
}
</style>