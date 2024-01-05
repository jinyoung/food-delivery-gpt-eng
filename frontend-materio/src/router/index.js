import { createRouter, createWebHashHistory } from 'vue-router';

const router = createRouter({
  history: createWebHashHistory(),
  routes: [
    {
      path: '/',
      component: () => import('../components/pages/Index.vue'),
    },
    {
      path: '/teams',
      component: () => import('../components/ui/TeamGrid.vue'),
    },
    {
      path: '/tests',
      component: () => import('../components/ui/TestGrid.vue'),
    },
  ],
})

export default router;
