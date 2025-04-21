import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import TicketsView from '@/views/TicketsView.vue'
import DispositivosView from '@/views/DispositivosView.vue'
import HistorialView from '@/views/HistorialView.vue'
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView,
    },
    {
      path: '/tickets',
      name: 'tickets',
      component:TicketsView,
      
     
    },{
      path:'/dispositivos',
      name:'dispostivos',
      component:DispositivosView,
    },
    {
      path:'/historial',
      name:'historial',
      component:HistorialView
    }
  ],
})

export default router

