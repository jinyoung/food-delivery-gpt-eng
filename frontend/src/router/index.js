import { createRouter, createWebHistory } from 'vue-router';
import RiderManagement from '../views/RiderManagement.vue';

const routes = [
  {
    path: '/',
    name: 'RiderManagement',
    component: RiderManagement
  },
  // Additional routes can be added here
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;