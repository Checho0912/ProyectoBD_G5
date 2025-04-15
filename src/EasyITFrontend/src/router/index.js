import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import NoRetornablesView from '@/views/NoRetornablesView.vue'
import DispositivosView from '@/views/DispositivosView.vue'
import OficinaView from '@/views/OficinaView.vue'
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView,
    },
    {
      path: '/no_retornables',
      name: 'table',
      component:NoRetornablesView,
      
     
    },{
      path:'/dispositivos',
      name:'dispostivos',
      component:DispositivosView,
    },
    {
      path:'/oficina',
      name:'oficina',
      component:OficinaView
    }
  ],
})

export default router

