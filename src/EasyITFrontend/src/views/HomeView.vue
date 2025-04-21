<script setup>

import Navbar from '@/components/NavBar.vue';
</script>

<template>
  <main>
    <Navbar></Navbar>
    <div class="container">
      <h1 class="display-5 text-center fw-bold mb-4 my-3">Lenguajes de Bases de Datos</h1>
      <h2 class="h2 text-primary text-center mb-5">EasyIT</h2>
      <div class="card shadow p-4 mx-auto my-5" style="max-width: 600px;">
        <h3 class="h5 text-secondary mb-3">Docente</h3>
        <ul class="list-group list-group-flush text-start">
          <li class="list-group-item">Lic. José Pablo Rodríguez Ledezma</li>

        </ul>
      </div>
      <div class="card shadow p-4 mx-auto" style="max-width: 600px;">
        <h3 class="h5 text-secondary mb-3">Integrantes del Proyecto</h3>
        <ul class="list-group list-group-flush text-start">
          <li class="list-group-item">Víctor Andrés Ortiz Cerón</li>
          <li class="list-group-item">Ryan Umaña Hernández</li>
          <li class="list-group-item">Sergio Cabezas Martínez</li>
          <li class="list-group-item">Johana Fernandez Mora</li>
        </ul>
      </div>
      
    </div>
  </main>
</template>
