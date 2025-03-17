import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import NoRetornablesView from '@/views/NoRetornablesView.vue'
import ComputadorasView from '@/views/ComputadorasView.vue'
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
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
     
    },{
      path:'/computadoras',
      name:'computadoras',
      component:ComputadorasView
    },
    {
      path:'/oficina',
      name:'oficina',
      component:OficinaView
    }
  ],
})

export default router

