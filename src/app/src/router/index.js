import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import Tournament from '../views/Tournament.vue'
import Browse from '../views/Browse.vue'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
    path: '/search',
    name: 'Search',
    component: () => import(/* webpackChunkName: "about" */ '../views/Search.vue')
  },
  {
    path: '/browse',
    name: 'Browse',
    component: Browse
    // component: () => import(/* webpackChunkName: "about" */ '../views/Browse.vue')
  },
  {
    path: '/create',
    name: 'Create',
    component: () => import(/* webpackChunkName: "about" */ '../views/Create.vue')
  },
  {
    path: '/learn',
    name: 'Learn',
    component: () => import(/* webpackChunkName: "about" */ '../views/Learn.vue')
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import(/* webpackChunkName: "about" */ '../views/Login.vue')
  },
  // {
  //   path: '/tournament/:tournamentId',
  //   name: 'Tournament',
  //   component: () => import(/* webpackChunkName: "about" */ '../views/Tournament.vue')
  // },
  {
    path: '/tournament/:tournamentId',
    name: 'Tournament',
    component: Tournament
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
