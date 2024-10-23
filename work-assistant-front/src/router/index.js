import { createRouter, createWebHistory } from 'vue-router';
//import store from '../store';
import HomePage from '../views/HomePage.vue';
import InterviewSelection from '../components/interview/InterviewSelection.vue';
import InterviewResult from '../components/interview/InterviewResult.vue';
import MockInterview from '../components/interview/MockInterview.vue';
import InterviewStart from '../components/interview/InterviewStart.vue';
import SkillSelection from '../components/interview/SkillSelection.vue';

const routes = [
  {
    path: '/',
    name: 'Home',
    component: HomePage
  },
  {
    path: '/interview-selection',
    name: 'InterviewSelection',
    component: InterviewSelection
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
    path: '/skill-selection',
    name: 'SkillSelection',
    component: SkillSelection,
    props: route => ({ interview: route.params.interview })
  }
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
});

// Global before guard
// router.beforeEach((to, from, next) => {
//   alert("~");
//   if (to.path !== '/' && store.state.sessionId !== null) {
//     next('/');
//   } else {
//     next();
//   }
// });
export default router;