import { createRouter, createWebHistory } from 'vue-router';
import HomePage from '../views/HomePage.vue';
import JobSelection from '../components/interview/JobSelection.vue';
import InterviewResult from '../components/interview/InterviewResult.vue';
import MockInterview from '../components/interview/MockInterview.vue';
import InterviewStart from '../components/interview/InterviewStart.vue';
import RoleSelection from '../components/interview/RoleSelection.vue';

const routes = [
  {
    path: '/',
    name: 'Home',
    component: HomePage
  },
  {
    path: '/job-selection',
    name: 'JobSelection',
    component: JobSelection
  },
  {
    path: '/interview-result',
    name: 'InterviewResult',
    component: InterviewResult
  },
  {
    path: '/mock-interview',
    name: 'MockInterview',
    component: MockInterview
  },
  {
    path: '/interview-start',
    name: 'InterviewStart',
    component: InterviewStart
  },
  {
    path: '/role-selection',
    name: 'RoleSelection',
    component: RoleSelection,
    props: route => ({ job: route.params.job })
  }
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
});

export default router;